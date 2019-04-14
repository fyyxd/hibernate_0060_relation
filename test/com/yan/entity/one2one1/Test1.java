package com.yan.entity.one2one1;

import static org.junit.Assert.fail;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
		Husband h=new Husband("¡ı±∏");
		Wife w=new Wife();
		w.setName("ÀÔ…–œ„");
		
		h.setWife(w);
		w.setHusband(h);
		
		Session s=HibernateSessionFactory.getSession();
		s.save(h);
	}
	@Test
	public void testLoad() {
		Session s=HibernateSessionFactory.getSession();
		Husband h=(Husband) s.load(Husband.class, 2L);
		System.out.println(h.getName()+"----"+h.getWife().getName());
	}
	@Test
	public void testRemove() {
		Session s=HibernateSessionFactory.getSession();
		Husband h=(Husband) s.load(Husband.class, 2L);
		s.delete(h);
	}
}
