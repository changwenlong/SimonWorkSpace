package edu.zju.chwl.mapper;

import edu.zju.chwl.po.Group;

public interface GroupMapper {
	
	//根据主键id查询小组信息
	public Group  findGroupById(int id) throws Exception;
	
	//新增小組
	public int addGroup(Group group) throws Exception;
		
}
