package com.yan.one2many;

import static org.junit.Assert.*;

import java.util.Set;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
		Role r=new Role();
		r.setName("系统管理员");
		User u1=new User();
		u1.setUserame("张三");
		User u2=new User();
		u2.setUserame("李四");
		
		r.getUsers().add(u1);
		r.getUsers().add(u2);
		u1.setRole(r);
		u2.setRole(r);
		
		Session s=HibernateSessionFactory.getSession();
		s.save(r);
	}
	@Test
	public void testLoad1() {
		Session s=HibernateSessionFactory.getSession();
		Role r=(Role) s.load(Role.class, 1L);
		System.out.println(r.getName());
		Set<User> set=r.getUsers();
		for(User obj:set)
			System.out.println("\t"+obj.getUserame());
	}
	@Test
	public void testLoad2() {
		Session s=HibernateSessionFactory.getSession();
		User u=(User) s.load(User.class, 2L);
		System.out.println(u.getUserame()+"----"+u.getRole().getName());
	}
	@Test
	public void testRemove() {
		Session s=HibernateSessionFactory.getSession();
		Role r=(Role) s.load(Role.class, 1L);
		s.delete(r);
	}
}
