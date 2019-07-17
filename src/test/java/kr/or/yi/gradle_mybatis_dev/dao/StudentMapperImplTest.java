package kr.or.yi.gradle_mybatis_dev.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.gradle_mybatis_dev.AbstractTest;
import kr.or.yi.gradle_mybatis_dev.dto.PhoneNumber;
import kr.or.yi.gradle_mybatis_dev.dto.Student;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentMapperImplTest extends AbstractTest {
	private static StudentMapper stdDao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		stdDao = new StudentMapperImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		stdDao = null;
	}

	@Test
	public void test01SelectStudentByNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Student std = new Student();
		std.setStudId(1);
		
		Student selectStd = stdDao.selectStudentByNo(std);
		log.debug(selectStd.toString());
		Assert.assertEquals(std.getStudId(), selectStd.getStudId());
	}
	@Test
	public void test02SelectStudentByNoWithResultMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Student std = new Student();
		std.setStudId(1);
		
		Student selectStd = stdDao.selectStudentByNo(std);
		log.debug(selectStd.toString());
		Assert.assertEquals(std.getStudId(), selectStd.getStudId());
	}
	
	@Test
	public void test03InsertStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(2019, 7, 17);
		Student student = new Student(3, "홍길동", "lee@naver.com", new PhoneNumber("010", "4415", "5014"), newDate.getTime());
		Student student1 = new Student(4, "홍길동", "lee@naver.com", new PhoneNumber("010", "4415", "5014"), newDate.getTime());
		int res = stdDao.insertStudent(student);
		int res1 = stdDao.insertStudent(student1);
		
		log.debug(student.toString());
		log.debug(student1.toString());
		Assert.assertEquals(1, res);
		Assert.assertEquals(1, res1);
	}
	
	
//	@Test
//	public void test04InsertStudentAutoInc() {
//		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
//		Calendar newDate = GregorianCalendar.getInstance();
//		newDate.set(2019, 7, 17);
//		Student student = new Student("임종호", "lim@naver.com", new PhoneNumber("010-4415-5014"), newDate.getTime());
//		int res = stdDao.insertStudentAutoInc(student);	
//		
//		log.debug(res+"");
//		Assert.assertEquals(1, res);
//	}
	@Test
	public void test05UpdateStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Student student = new Student(4, "임종호1", "www.naver.com", new PhoneNumber("010-1111-1111"), new Date());
		int res = stdDao.updateStudent(student);
		log.debug(student.toString());
		Assert.assertEquals(1, res);
	}
	@Test
	public void test06DeleteStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Student student = new Student(4);
		Student student2 = new Student(3);
		int res = stdDao.deleteStudent(student);
		Assert.assertEquals(1, res);
		int res2 = stdDao.deleteStudent(student2);
		Assert.assertEquals(1, res2);
	}
	
	@Test
	public void test07SelectStudentByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
				
		List<Student> list = stdDao.selectStudentByAll();
		log.debug(list.toString());
		Assert.assertNotNull(list);
	}
	
	
	
	
}















