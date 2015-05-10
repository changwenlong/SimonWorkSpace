package edu.zju.chwl;

import java.util.HashMap;
import java.util.Map;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Test {
	public static void main(String[] args){
		String name="李四";
		String groupId="54aa845117a427ac4b2662d6";
		//查询器
		DBObject queryObject=new BasicDBObject("_id",new ObjectId(groupId));
		Map<String,String> updateMap=new HashMap<String, String>();
		String timeArr="0,1,9,";
		String[] cellArr=timeArr.substring(0, timeArr.length()-1).split(",");
		for(String item:cellArr){
			System.out.println(item);
			updateMap.put(item, name);
		}
		//修改器
		DBObject updateObject=new BasicDBObject();
		updateObject.put("$addToSet", new BasicDBObject(updateMap));
		MongoDb mongo=new MongoDb();
		int count=mongo.update(queryObject, updateObject);
		System.out.println(count);
	}
}
