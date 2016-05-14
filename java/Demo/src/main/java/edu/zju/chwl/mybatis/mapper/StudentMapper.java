package edu.zju.chwl.mybatis.mapper;

import java.util.List;

import edu.zju.chwl.mybatis.bean.Student;

public interface StudentMapper {
	int add(Student stu);
	List<Student> selectAll();
	int addStudent(Student stu);
	int addBatch(List<Student> stuList);
}
