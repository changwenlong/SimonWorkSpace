package cn.itcast.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.core.bean.TestTb;

@Controller
public class CenterController {

	@RequestMapping(value="/test/springmvc.do")
	public String testSpringmvc(TestTb testTb,ModelMap model){
		System.out.println(testTb.getName());
		return "success";
	}
}
