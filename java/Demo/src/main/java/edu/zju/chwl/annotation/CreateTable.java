package edu.zju.chwl.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.*;

public class CreateTable {

	public static void main(String[] args){
		String tableName;
		List<String> columnList=new ArrayList<String>();
		Class<Student> clazz=Student.class;
		//获取表名
		DBTable dbTable=clazz.getAnnotation(DBTable.class);
		if("".equals(dbTable.name())){
			tableName=clazz.getSimpleName().toLowerCase();
		}else{
			tableName=dbTable.name();
		}
		
		//获取所有列
		Field[] fields=clazz.getDeclaredFields();
		for(Field field:fields){
			StringBuilder sb=new StringBuilder();
			Annotation[] ans=field.getAnnotations();
			if(ans.length<1){
				continue;
			}
			//可以理解为：SQLString继承自Annotation
			if(ans[0] instanceof SQLString){
				SQLString sqlStr=(SQLString)ans[0];
				if("".equals(sqlStr.name())){
					sb.append(field.getName());
				}else{
					sb.append(sqlStr.name());
				}
				if(sqlStr.value()==0){
					sb.append(" varchar(50)");
				}else{
					sb.append(" varchar(").append(sqlStr.value()).append(")");
				}
				sb.append(getConstraint(sqlStr.constraints()));
			}
			
			if(ans[0] instanceof SQLInteger){
				SQLInteger sqlStr=(SQLInteger)ans[0];
				if("".equals(sqlStr.name())){
					sb.append(field.getName());
				}else{
					sb.append(sqlStr.name());
				}
				sb.append(" int");
				sb.append(getConstraint(sqlStr.constraints()));
			}
			columnList.add(sb.toString());
		}
		
		System.out.println(getCreateStr(tableName,columnList));
	}

	//根据表明,列信息创建SQL语句
	private static String getCreateStr(String tableName, List<String> columnList) {
		StringBuilder sbuf=new StringBuilder();
		sbuf.append("CREATE TABLE ").append(tableName).append("(\n");
		for(String column:columnList){
			sbuf.append("\t").append(column).append(",\n");
		}

		return sbuf.substring(0,sbuf.length()-2)+");";
	}

	//生成约束
	private static String getConstraint(Constraints constraints) {
		StringBuilder sbuf=new StringBuilder();
		if(!constraints.allowNull()){
			sbuf.append(" NOT NULL");
		}
		if(constraints.primaryKey()){
			sbuf.append(" PRIMARY KEY");
		}
		if(constraints.unique()){
			sbuf.append(" UNIQUE");
		}
		return sbuf.toString();
	}	

}
