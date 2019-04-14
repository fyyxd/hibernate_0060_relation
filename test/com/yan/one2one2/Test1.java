package com.yan.one2one2;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
		Person p=new Person();
		p.setUsername("’≈∑…");
		IdCard c=new IdCard();
		c.setCardNo("61010319810647010");
		
		p.setIdCard(c);
		c.setPerson(p);
		
		Session s=HibernateSessionFactory.getSession();
		s.save(p);
	}
	@Test
	public void testLoad() {
		Session s=HibernateSessionFactory.getSession();
		Person p=(Person) s.load(Person.class,13L);
		System.out.println(p.getUsername()+"----"+p.getIdCard().getCardNo());
	}
	@Test
	public void testModify() {
		Session s=HibernateSessionFactory.getSession();
		Person p=(Person) s.load(Person.class, 13L);
		p.setUsername("’≈∑…∑…");
		p.getIdCard().setCardNo("6101081999052300");
		s.update(p);
	}
	@Test
	public void testRemove() {
		Session s=HibernateSessionFactory.getSession();
		Person p=(Person) s.load(Person.class, 13L);
		s.delete(p);
	}
}
