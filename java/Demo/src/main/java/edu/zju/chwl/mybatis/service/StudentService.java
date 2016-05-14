package edu.zju.chwl.mybatis.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import edu.zju.chwl.mybatis.bean.Student;
import edu.zju.chwl.mybatis.mapper.StudentMapper;

public class StudentService {
	
	public static SqlSessionFactory sqlSessionFactory;
	
	static{
		String resource = "edu/zju/chwl/mybatis/mapper/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {			
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public static SqlSessionFactory getSqlSessionFactory(){
		return sqlSessionFactory;
	}
	
	//insert
	public int add(Student stu){
		SqlSession session = getSqlSessionFactory().openSession();
		try{
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			int result = mapper.add(stu);			
			session.commit();
			return result;
		}finally{
			session.close();
		}
	}
	
	//select *
	public static List<Student> selectAll(){
		SqlSession session = getSqlSessionFactory().openSession();
		try{
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			List<Student> list = mapper.selectAll();
			session.commit();
			return list;
		}finally{
			session.close();
		}
	}

	@Test
	public void testSelectAll(){
		System.out.println(selectAll());
	}
	
	//insert with sp
	public static int addStudent(Student stu){
		SqlSession session = getSqlSessionFactory().openSession();
		try{
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			int result = mapper.addStudent(stu);
			session.commit();
			return result;
		}finally{
			session.close();
		}
	}
	
	@Test
	public void testAddStudent(){
		System.out.println(addStudent(new Student(10,"sp10",10)));
	}
	
	//insert batch
	public static int addBatch(List<Student> stuList){
		SqlSession session = getSqlSessionFactory().openSession(ExecutorType.BATCH);
		try{
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			int result = mapper.addBatch(stuList);
			session.commit();
			return result;
		}finally{
			session.close();
		}
	}
	
	@Test
	public void testAddBatch(){
		ArrayList<Student> lists = new ArrayList<Student>();
		lists.add(new Student(20,"batch20",20));
		lists.add(new Student(21,"batch21",21));
		lists.add(new Student(22,"batch22",22));
		System.out.println(addBatch(lists));
	}
}
