package edu.zju.chwl.mapper;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.zju.chwl.po.Member;

public class MemberMapperTest {
	// spring容器
	private ApplicationContext applicationContext;

	@Before
	public void setUp() throws Exception {
		// 构造spring容器
		applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
	}
	@Test
	public void testAddMember() throws Exception {
		Member member =new Member();
		member.setGroupId(1);
		member.setName("张三");
		//从spring容器中获取mapper的动态代理对象userMapper
		MemberMapper memberMapper = (MemberMapper) applicationContext.getBean("memberMapper");
		//调用userMapper方法
		memberMapper.addMember(member);
	}
	
	@Test
	public void testUpdateMember() throws Exception {
		Member member =new Member();
		member.setGroupId(1);
		member.setName("张三");
		member.setFreeTimeStr("1,2,4");
		//从spring容器中获取mapper的动态代理对象userMapper
		MemberMapper memberMapper = (MemberMapper) applicationContext.getBean("memberMapper");
		//调用userMapper方法
		memberMapper.updateMember(member);
	}
	
	@Test
	public void testFindMemberByNameAndGroupId() throws Exception {
		Member member =new Member();
		member.setGroupId(1);
		member.setName("张三");
		//从spring容器中获取mapper的动态代理对象userMapper
		MemberMapper memberMapper = (MemberMapper) applicationContext.getBean("memberMapper");
		//调用userMapper方法
		String freeTimeStr=memberMapper.findMemberByNameAndGroupId(member);
		System.out.println(freeTimeStr);
	}
	
	@Test
	public void testFindMemberByNameAnwdGroupId() throws Exception {
		System.out.println("1,2,1,".split(",").length);
		System.out.println("1,2,1".split(",").length);
	}

}
