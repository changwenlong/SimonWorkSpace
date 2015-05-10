package edu.zju.chwl;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.WriteResult;

public class MongoDb {
	// 1.建立一个Mongo的数据库连接对象
	private Mongo connection = null;
	// 2.创建相关数据库的连接
	private DB db = null;
	// 3.获取集合
	private DBCollection collection=null;

	public MongoDb(){
		try {
			connection = new Mongo("127.0.0.1:27017");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MongoException e) {
			e.printStackTrace();
		}
		db = connection.getDB("foobar");
		collection=db.getCollection("groups");
	}
	
	public void close(){
		connection.close();
	}

	public DBCursor findWithPage(DBObject object, DBObject object2, int i, int j) {
		DBCursor dbCursor = collection.find(object,object2).limit(j).skip(0*i);
		return dbCursor;
	}

	public DBCursor find(DBObject object, DBObject keys) {
		DBCursor dbCursor= collection.find(object,keys);
		return dbCursor;
	}
	
	public DBObject findOne(DBObject object, DBObject keys) {
		DBObject dbObject= collection.findOne(object,keys);
		close();
		return dbObject;
	}

	public int update(DBObject query, DBObject update) {
		int n= collection.update(query, update).getN();	
		close();
		return n;
	}

	public int deleteByDbs(DBObject chang) {
		int n = collection.remove(chang).getN();
		close();
		return n;
	}

	public void deleteById(String id) {
		collection.remove(new BasicDBObject("_id",new ObjectId(id)));
		close();
	}

	public void insertBatch(List<DBObject> dbObjects) {
		collection.insert(dbObjects);
		close();
	}

	/**
	 * 插入一条document
	 * @param dbs
	 */
	public ObjectId insert(DBObject dbs) {
		collection.insert(dbs);
		ObjectId id= (ObjectId)dbs.get("_id");
		close();
		return id;
	}

	public void printColl() {
		DBCursor cursor=collection.find();
		while(cursor.hasNext()){
			DBObject object=cursor.next();
			System.out.println(object.get("name"));
		}
	}
}
