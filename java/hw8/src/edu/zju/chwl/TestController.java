package edu.zju.chwl;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.math.NumberUtils;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import edu.zju.chwl.model.Group;

@Controller//用来标注当前类是springmvc的控制层的类
@RequestMapping("/test")//controller的唯一标识或者命名空间
public class TestController {
	@RequestMapping("/home.do")
	public void home(String name,String groupId,HttpSession session, PrintWriter out){
		if(ObjectId.isValid(groupId)){
			MongoDb mongo=new MongoDb();
			DBCursor cursor=mongo.find(new BasicDBObject("_id",new ObjectId(groupId)), null);
			int count=cursor.count();
			if(count!=0){
				System.out.println("home页面  name:"+name+";groupId:"+groupId);
				
				//小组成员名字写入memberNames数组中
				MongoDb mongo1=new MongoDb();
				DBObject queryObject=new BasicDBObject("_id",new ObjectId(groupId));
				DBObject updateObject=new BasicDBObject();
				updateObject.put("$addToSet",new BasicDBObject("memberNames", name));
				mongo1.update(queryObject, updateObject);
				
				session.setAttribute("name", name);
				session.setAttribute("groupId", groupId);
				out.write("ok");
			}
			else{
				out.write("wrong");
			}
		}
		else{
			out.write("wrong");
		}
		
	}
	
	@RequestMapping("/group.do")
	public void group(Group group,HttpSession session, PrintWriter out){
		System.out.println(group);
		MongoDb mongo=new MongoDb();
		DBObject dbObject=new BasicDBObject();
		dbObject.put("groupName", group.getGroupName());
		dbObject.put("memberNames", new String[]{group.getLeaderName()});
		dbObject.put("startDate", group.getStartDate());
		dbObject.put("endDate", group.getEndDate());
		dbObject.put("comment", group.getComment());
		ObjectId id=mongo.insert(dbObject);
		session.setAttribute("name", group.getLeaderName());
		session.setAttribute("groupId", id.toString());
		System.out.println("_id:"+id.toString());
		out.write(id.toString());
	}
	
	@RequestMapping("/time.do")
	public void time(String timeArr,HttpSession session, PrintWriter out){
		System.out.println(timeArr);
		String name=session.getAttribute("name").toString();
		String groupId=session.getAttribute("groupId").toString();
		//查询器
		DBObject queryObject=new BasicDBObject("_id",new ObjectId(groupId));
		Map<String,String> updateMap=new HashMap<String, String>();
		String[] cellArr=timeArr.substring(0, timeArr.length()-1).split(",");
		for(String item:cellArr){
			updateMap.put(item, name);
		}
		//修改器
		DBObject updateObject=new BasicDBObject();
		updateObject.put("$addToSet", new BasicDBObject(updateMap));
		MongoDb mongo=new MongoDb();
		int count=mongo.update(queryObject, updateObject);
		if(count!=0){
			out.write("OK");
		}
	}
	
	@RequestMapping("/toHome.do")
	public String toHome(){
		return "home";
	}
	
	@RequestMapping("/toGroup.do")
	public String toGroup(){
		return "group";
	}
	
	@RequestMapping("/toTime.do")
	public String toTime(HttpSession session,Map<String, Object> map){
		Object name=session.getAttribute("name");
		Object groupId=session.getAttribute("groupId");
		System.out.println("time页面  name:"+name+";groupId:"+groupId);
		if(name!=null&&groupId!=null){
			MongoDb mongo=new MongoDb();
			DBObject object=mongo.findOne(new BasicDBObject("_id",new ObjectId(groupId.toString())), null);
			map.put("startDate", object.get("startDate"));
			map.put("endDate", object.get("endDate"));
			return "time";
		}
		else{
			return "home";
		}	
	}	
	
	@RequestMapping("/toResult.do")
	public String toResult(HttpSession session,Map<String, Object> map){
		Object name=session.getAttribute("name");
		Object groupId=session.getAttribute("groupId");
		System.out.println("result页面  name:"+name+";groupId:"+groupId);
		if(name!=null&&groupId!=null){
			MongoDb mongo=new MongoDb();
			DBObject object=mongo.findOne(new BasicDBObject("_id",new ObjectId(groupId.toString())), null);
			Set<String> set=object.keySet();
			Map<String,Object> timeMap=new HashMap<String, Object>();
			for(String item:set){
				if(NumberUtils.isNumber(item)){
					timeMap.put("time"+item, object.get(item));
				}
				else{
					map.put(item, object.get(item));
				}
				System.out.println("key:"+item+";value:"+object.get(item));
			}
			map.put("time",timeMap);
			
			//推荐开会时间
			Set<String> timeStr=timeMap.keySet();
			Map<Integer,String> adviceMap=new HashMap<Integer, String>();
			int max=-1;
			for(String str:timeStr){
				BasicDBList timeValues=(BasicDBList)timeMap.get(str);
				int size=timeValues.size();
				max=max>size?max:size;
				String myValue=adviceMap.get(size);
				if(myValue==null){
					myValue="";
				}
				adviceMap.put(size, myValue+","+str.substring(4));
			}
			map.put("advice", adviceMap.get(max).substring(1));
			return "result";
		}
		else{
			return "home";
		}	
	}	
	
}
