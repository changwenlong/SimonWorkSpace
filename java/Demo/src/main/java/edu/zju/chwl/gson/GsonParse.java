package edu.zju.chwl.gson;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * 使用Goggle的gson库，将json解析成java bean
 * 
 * json:[{name:chwl, age:25, addressList:[{country:china, province:hubei},{country:china, province:zhejiang}]}, {name:chwl, age:25,addressList:[{country:china, province:hubei}, {country:china,province:zhejiang}]}] 
 * 转化为：List<Student> ， List<Address>为Student的成员变量
 * 
 * @author chwl
 * @Date 2016年1月7日 下午10:37:55
 */
public class GsonParse {
	public static void main(String[] args) {
		String jsonStr = "[{name:chwl, age:25, addressList:[{country:china, province:hubei}, {country:china, province:zhejiang}]}, {name:chwl, age:25, addressList:[{country:china, province:hubei}, {country:china, province:zhejiang}]}]";
		 /** 
		  * 配置Gson对象，可读源码
		  * Gson gson = new GsonBuilder()
		  *     .registerTypeAdapter(Id.class, new IdTypeAdapter())
		  *     .enableComplexMapKeySerialization()
		  *     .serializeNulls()
		  *     .setDateFormat(DateFormat.LONG)
		  *     .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
		  *     .setPrettyPrinting()
		  *     .setVersion(1.0)
		  *     .create();  
		  */
		Gson gson = new GsonBuilder().create();
		//TypeToken用于声明复杂对象的类型，对于简单类型，使用public <T> T fromJson(String json, Class<T> classOfT)，比如第二个参数可为String.class
		List<Student> list=gson.fromJson(jsonStr,
				new TypeToken<List<Student>>() {}.getType());
		System.out.println(list);
	}

}

class Address {
	private String country;
	private String province;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Override
	public String toString() {
		//打印json格式的字符串
		return "{country:" + country + ", province:" + province + "}";
	}

}

class Student {
	private String name;
	private int age;
	private List<Address> addressList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	@Override
	public String toString() {
		//打印json格式的字符串
		return "{name:" + name + ", age:" + age + ", addressList:"
				+ addressList + "}";
	}

}
