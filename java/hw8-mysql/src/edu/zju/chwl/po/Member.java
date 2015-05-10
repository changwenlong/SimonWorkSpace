package edu.zju.chwl.po;


public class Member {
	public Member(){
		
	}
	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	int groupId;
	String name;
	String freeTimeStr;
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFreeTimeStr() {
		return freeTimeStr;
	}
	public void setFreeTimeStr(String freeTimeStr) {
		this.freeTimeStr = freeTimeStr;
	}
}
