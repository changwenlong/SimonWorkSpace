package edu.zju.chwl.drools;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseConfiguration;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.conf.EventProcessingOption;
import org.drools.conf.MaxThreadsOption;
import org.drools.io.ResourceFactory;
import org.drools.runtime.KnowledgeSessionConfiguration;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.conf.ClockTypeOption;


public class DroolsEngine {

	private StatefulKnowledgeSession session;
	
	private Integer ruleId;

	public StatefulKnowledgeSession getSession() {
		return session;
	}

	public void setSession(StatefulKnowledgeSession session) {
		this.session = session;
	}

	public DroolsEngine(Integer ruleId, String ruleContent) {
		this.ruleId=ruleId;
		try {
			KnowledgeBaseConfiguration baseConfiguration = KnowledgeBaseFactory
					.newKnowledgeBaseConfiguration();
			baseConfiguration.setOption(EventProcessingOption.STREAM);
			baseConfiguration.setOption(MaxThreadsOption.get(5));
			KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase(baseConfiguration);
			
			KnowledgeBuilder knowledgeBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
			knowledgeBuilder.add(ResourceFactory.newByteArrayResource(ruleContent.getBytes()),ResourceType.DRL);
			KnowledgeBuilderErrors errors = knowledgeBuilder.getErrors();
			if (errors.size() > 0) {
				for (KnowledgeBuilderError error : errors) {
					System.err.println(error);
				}
				throw new RuntimeException("Failed to parse alert rule "+ ruleId);
			}
			
			knowledgeBase.addKnowledgePackages(knowledgeBuilder.getKnowledgePackages());
			
			session = newStatefulKnowledgeSession(knowledgeBase);
		} catch (Exception e) {
			String error = "Failed to init drools rule engine";
			throw new RuntimeException(error, e);
		}

	}
	
	private StatefulKnowledgeSession newStatefulKnowledgeSession(KnowledgeBase knowledgeBase) {
		KnowledgeSessionConfiguration config = KnowledgeBaseFactory.newKnowledgeSessionConfiguration();
		config.setOption(ClockTypeOption.get("realtime"));
		return knowledgeBase.newStatefulKnowledgeSession(config, null);
	}

	public void start() {
		new Thread() {
			public void run() {
				session.fireUntilHalt();
				System.out.println("Fusion engine with rule id " + ruleId + " has been stopped");
			}
		}.start();
	}

	public void stop() {
		session.dispose();
	}

	public void insert(Object obj) {
		session.insert(obj);
	}

	public void setGlobal(String name, Object value) {
		session.setGlobal(name, value);
	}

	public void destroyFusionEngine() {
		session.dispose();
	}
}
