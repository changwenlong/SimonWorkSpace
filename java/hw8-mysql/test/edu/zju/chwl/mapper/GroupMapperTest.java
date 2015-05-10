package edu.zju.chwl.mapper;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.zju.chwl.mapper.GroupMapper;
import edu.zju.chwl.po.Group;

public class GroupMapperTest {
	// spring容器
	private ApplicationContext applicationContext;

	@Before
	public void setUp() throws Exception {
		// 构造spring容器
		applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
	}

	@Test
	public void testFindGroupById() throws Exception {
		//从spring容器中获取mapper的动态代理对象userMapper
		GroupMapper groupMapper = (GroupMapper) applicationContext.getBean("groupMapper");
		//调用userMapper方法
		Group group = groupMapper.findGroupById(1);
		
		System.out.println(group.getMembers().get(0).getName());
		System.out.println(group);
		
	}
	
	@Test
	public void testAddGroup() throws Exception {
		Group group =new Group();
		group.setGroupName("小组1");
		group.setStartDate("2015/01/13");
		group.setEndDate("2015-1-18");
		group.setComment("小组开会");
		//从spring容器中获取mapper的动态代理对象userMapper
		GroupMapper groupMapper = (GroupMapper) applicationContext.getBean("groupMapper");
		//调用userMapper方法
		groupMapper.addGroup(group);
		System.out.println(group.getId());
	}
	

}
