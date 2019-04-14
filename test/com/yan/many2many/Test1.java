package com.yan.many2many;

import static org.junit.Assert.*;

import java.util.Set;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yan.entity.many2many.Course;
import com.yan.entity.many2many.Student;
import com.yan.entity.one2many.Role;
import com.yan.entity.one2many.User;
import com.yan.entity.one2one2.IdCard;
import com.yan.entity.one2one2.Person;
import com.yan.util.HibernateSessionFactory;

public class Test1 {
	@Before
	public void setUp() throws Exception {
		Session s = HibernateSessionFactory.getSession();
		s.beginTransaction();
	}

	@After
	public void tearDown() throws Exception {
		HibernateSessionFactory.getSession().getTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
	@Test
	public void testSave() {
		Course c1=new Course();
		c1.setTitle("����");
		Course c2=new Course();
		c2.setTitle("��ѧ");
		Student s1=new Student();
		s1.setName("��Ȩ");
		Student s2=new Student();
		s2.setName("�ܲ�");
		Student s3=new Student();
		s3.setName("����");
		
		c1.getStudents().add(s1);
		c1.getStudents().add(s3);
		s1.getCourses().add(c1);
		s3.getCourses().add(c1);
		
		c2.getStudents().add(s2);
		c2.getStudents().add(s3);
		s2.getCourses().add(c2);
		s3.getCourses().add(c2);
		
		Session s=HibernateSessionFactory.getSession();
		s.save(c1);
		s.save(c2);
	}
	@Test
	public void testLoad1() {
		Session s=HibernateSessionFactory.getSession();
		Course c=(Course) s.load(Course.class, 1L);
		System.out.println("�γ�����:"+c.getTitle());
		Set<Student> ss=c.getStudents();
		for(Student obj:ss)
			System.out.println("ѡ��"+c.getTitle()+"��ѧ����:"+obj.getName());
	}
	@Test
	public void testLoad2() {
		Session s=HibernateSessionFactory.getSession();
		Student st=(Student) s.load(Student.class,2L);
		Set<Course> cs=st.getCourses();
		System.out.println("ѧԱ��"+st.getName());
		for(Course c:cs)
			System.out.println("\tѡ�޵Ŀγ��У�"+c.getTitle());
	}
	@Test
	public void testRemove() {
		Session s=HibernateSessionFactory.getSession();
		Course c=(Course) s.load(Course.class,1L);
		s.delete(c);
	}
}
