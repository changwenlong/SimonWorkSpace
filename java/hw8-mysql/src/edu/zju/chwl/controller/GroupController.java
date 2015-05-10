package edu.zju.chwl.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.zju.chwl.mapper.GroupMapper;
import edu.zju.chwl.mapper.MemberMapper;
import edu.zju.chwl.po.Group;
import edu.zju.chwl.po.Member;

@Controller//用来标注当前类是springmvc的控制层的类
@RequestMapping("/test")//controller的唯一标识或者命名空间
public class GroupController {
	
	@Autowired
    private GroupMapper groupMapper ;
	
	@Autowired
    private MemberMapper memberMapper ;
	
	@RequestMapping("/home.do")
	public void home(String name,String groupId,HttpSession session, PrintWriter out) throws Exception{
		//小组编号是否合法,是否为数字
		if(NumberUtils.isNumber(groupId.trim())){
			int id=Integer.parseInt(groupId.trim());
			Group group=groupMapper.findGroupById(id);
			if(group!=null){
				System.out.println("home页面  name:"+name+";groupId:"+groupId);
				Member member=new Member();
				member.setGroupId(id);
				member.setName(name);
				//查询小组成员
				String freeTimeStr=memberMapper.findMemberByNameAndGroupId(member);
				//小组成员不存在,新增小组成员 (需将数据库t_member中的freeTimeStr字段的默认值设为",")
				if(freeTimeStr==null){
					member.setFreeTimeStr(",");
					memberMapper.addMember(member);
				}
				//成员名字与小组编号写入session
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
	public void group(Group group,String leaderName,HttpSession session, PrintWriter out) throws Exception{
		System.out.println(group);
		Group newGroup=new Group();
		newGroup.setGroupName(group.getGroupName());
		newGroup.setStartDate(group.getStartDate());
		newGroup.setEndDate(group.getEndDate());
		newGroup.setComment(group.getComment());
		
		groupMapper.addGroup(newGroup);
		//获取小组编号
		Integer id=newGroup.getId();
		Member member=new Member();
		member.setGroupId(id);
		member.setName(leaderName);
		member.setFreeTimeStr(",");
		memberMapper.addMember(member);
		session.setAttribute("name", leaderName);
		session.setAttribute("groupId", id.toString());
		out.write(id.toString());
	}
	
	@RequestMapping("/time.do")
	public void time(String timeArr,HttpSession session, PrintWriter out) throws Exception{
		System.out.println(timeArr);
		String name=session.getAttribute("name").toString();
		String groupId=session.getAttribute("groupId").toString();
		int id=Integer.parseInt(groupId);
		Member member=new Member();
		member.setGroupId(id);
		member.setName(name);
		//freeTimeSet用来保存小组成员的空闲时间,不含重复项，使用HashSet
		Set<String> freeTimeSet=new HashSet<String>();
		String[] cellArr=timeArr.split(",");
		for(String item:cellArr){
			freeTimeSet.add(item);
		}
		//查询小组成员的之前保存的空闲时间
		String freeTimeStr=memberMapper.findMemberByNameAndGroupId(member);
		//处理空闲时间字符串
		//为默认值设为""
		if(freeTimeStr==","){
			freeTimeStr="";
		}
		String[] strs=freeTimeStr.split(",");
		for(String item:strs){
			freeTimeSet.add(item);
		}
		//将freeTimeSet转化为字符串再存入数据库
		String resultStr="";
		for(String item:freeTimeSet){
			resultStr+=item+",";
		}
		//为空则存储默认值
		if(resultStr==""){
			resultStr=",";
		}
		member.setFreeTimeStr(resultStr);
		memberMapper.updateMember(member);
		out.write("OK");
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
	public String toTime(HttpSession session,Map<String, Object> map) throws NumberFormatException, Exception{
		Object name=session.getAttribute("name");
		Object groupId=session.getAttribute("groupId");
		System.out.println("time页面  name:"+name+";groupId:"+groupId);
		if(name!=null&&groupId!=null){
			//查询小组信息 将开会大概时间传到前台
			Group group=groupMapper.findGroupById(Integer.parseInt(groupId.toString()));
			map.put("startDate", group.getStartDate());
			map.put("endDate", group.getEndDate());
			return "time";
		}
		else{
			return "home";
		}
	}	
	
	@RequestMapping("/toResult.do")
	public String toResult(HttpSession session,Map<String, Object> map) throws Exception{
		Object name=session.getAttribute("name");
		Object groupId=session.getAttribute("groupId");
		int id=Integer.parseInt(groupId.toString());
		System.out.println("result页面  name:"+name+";groupId:"+groupId);
		if(name!=null&&groupId!=null){
			Group group=groupMapper.findGroupById(id);
			map.put("groupName", group.getGroupName());
			map.put("startDate", group.getStartDate());
			map.put("endDate", group.getEndDate());
			map.put("comment", group.getComment());
			map.put("startDate", group.getStartDate());
			//保存小组成员的数组
			List<String> memberNames=new ArrayList<String>();
			//保存空闲时间的map <"time1",{"张三","李四"}>
			Map<String,List<String>> tmpMap=new HashMap<String, List<String>>();
			System.out.println(group.getMembers().size());
			for(Member item:group.getMembers()){
				memberNames.add(item.getName());
				String times=item.getFreeTimeStr();
				for(String index:times.split(",")){
					index="time"+index;
					List<String> tmpNameList=tmpMap.get(index);
					if(tmpNameList==null){
						tmpNameList=new ArrayList<String>();
					}
					tmpNameList.add(item.getName());
					tmpMap.put(index, tmpNameList);
				}
			}
			map.put("memberNames", memberNames);
			map.put("time",tmpMap);			
			//推荐开会时间
			Map<Integer,String> adviceMap=new HashMap<Integer, String>();
			int max=-1;
			for(String item:tmpMap.keySet()){
				List timeValues=tmpMap.get(item);
				int size3=timeValues.size();
				max=max>size3?max:size3;
				String myValue=adviceMap.get(size3);
				if(myValue==null){
					myValue="";
				}
				//item要截去前面的"time"
				adviceMap.put(size3, myValue+","+item.substring(4));
			}
			map.put("advice", adviceMap.get(max).substring(1));
			return "result";
		}
		else{
			return "home";
		}
	}
}
