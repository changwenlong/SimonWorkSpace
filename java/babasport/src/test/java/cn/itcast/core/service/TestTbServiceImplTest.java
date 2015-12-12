package cn.itcast.core.service;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.common.junit.SpringJunitTest;
import cn.itcast.core.bean.TestTb;

public class TestTbServiceImplTest extends SpringJunitTest{

	@Autowired
	private TestTbService testTbService;
	
	@Test
	public void test() {
		TestTb testTb=new TestTb();
		testTb.setName("张三");
		testTb.setBirthday(new Date());
		testTbService.add(testTb);
	}

}
