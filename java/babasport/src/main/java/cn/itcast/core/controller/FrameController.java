package cn.itcast.core.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value="/frame")
public class FrameController {

	@RequestMapping(value="/productMain.do")
	public String productMain(){
		return "frame/product_main";
	}
	
	@RequestMapping(value="/productLeft.do")
	public String productLeft(){
		return "frame/product_left";
	}
	
	@RequestMapping(value="/orderMain.do")
	public String orderMain(){
		return "frame/order_main";
	}
	
	@RequestMapping(value="/orderLeft.do")
	public String orderLeft(){
		return "frame/order_left";
	}
	
	@RequestMapping(value="/top.do")
	public String top(){
		return "top";
	}
	
	@RequestMapping(value="/main.do")
	public String main(){
		return "main";
	}
	
	@RequestMapping(value="/left.do")
	public String left(){
		return "left";
	}
	
	@RequestMapping(value="/right.do")
	public String right(){
		return "right";
	}
}
