package kr.or.yi.gradle_mybatis_dev.dao;

import java.util.List;
import java.util.Map;

import kr.or.yi.gradle_mybatis_dev.dto.Student;

public interface StudentMapper {
	Student selectStudentByNo(Student student);//typehandler
	Student selectStudentByNoWithResultMap(Student student);//resultmap
	List<Student> selectStudentByAll();
	
	int insertStudent(Student student);
	int insertStudentAutoInc(Student student);
	int insertStudentEnum(Student student);
	
	int updateStudent(Student student);
	int deleteStudent(Student student);
	Student selectStudentByResultMapExtends(Student student);
	List<Map<String, Object>> selectStudentMapByAll();
}
