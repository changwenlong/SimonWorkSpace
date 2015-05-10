package edu.zju.chwl.mapper;

import edu.zju.chwl.po.Member;


public interface MemberMapper {
	//新增小组成员
	public void addMember(Member member) throws Exception;
	//更新小组成员空余时间信息
	public void updateMember(Member member) throws Exception;
	//查询小组成员空闲时间字符串
	public String findMemberByNameAndGroupId(Member member) throws Exception;
}
