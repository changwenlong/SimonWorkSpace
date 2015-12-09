package cn.itcast.common.web.springmvc;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

public class ResponseUtils {

	public static void render(HttpServletResponse response,String data,String contentType){
		response.setContentType(contentType);
		try {
			response.getWriter().write(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void renderJson(HttpServletResponse response,String data){
		render(response,data,"application/json;charset=UTF-8");
	}
	
	public static void renderXml(HttpServletResponse response,String data){
		render(response,data,"text/xml;charset=UTF-8");
	}
	
	public static void renderText(HttpServletResponse response,String data){
		render(response,data,"text/plain;charset=UTF-8");
	}
}
