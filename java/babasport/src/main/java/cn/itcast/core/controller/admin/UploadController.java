package cn.itcast.core.controller.admin;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.itcast.common.web.springmvc.ResponseUtils;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

@Controller
public class UploadController {
	
	@RequestMapping(value="/upload/uploadPic.do")
	public void uploadPic(@RequestParam(required = false)MultipartFile pic,HttpServletResponse response){
		//图片名称生成
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String picName=dateFormat.format(new Date());
		
		Random random=new Random();
		for(int i=0;i<3;i++){
			picName += random.nextInt(10);
		}
		
		//获取扩展名
		String extensionName=FilenameUtils.getExtension(pic.getOriginalFilename());
		
		//相对路径
		String path = "upload/"+picName+"."+extensionName;
		
		//绝对路径
		String url = "http://localhost:8088/image-web/"+path;
		
		//jersey 将图片发送至图片服务器
		Client client = new Client();
		WebResource resource=client.resource(url);
		try {
			resource.put(String.class,pic.getBytes());
		} catch ( IOException e) {
			e.printStackTrace();
		}
		
		//回显url和path
		JSONObject json = new JSONObject();
		json.put("path", path);
		json.put("url", url);
		
		ResponseUtils.renderJson(response, json.toString());
		
	}
}
