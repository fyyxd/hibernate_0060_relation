package com.yan.extend2;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
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
	public void testSave1() {
		Session s = HibernateSessionFactory.getSession();
		// Man m=new Man(); Ϊ�˱���saveʱ�ŷ����쳣�����齫�����Ϊabstract
		// m.setName("С��");
		// s.save(m); //���쳣
	}

	@Test
	public void testSave2() {
		Session s = HibernateSessionFactory.getSession();
		Man m = new Stu();
		m.setName("����");
		((Stu) m).setScore(56.9);
		s.save(m);

		Tea t = new Tea();
		t.setName("��ç");
		t.setSalary(2345.78);
		s.save(t);
	}

	@Test
	public void testLoad() {
		Session s = HibernateSessionFactory.getSession();
		Man m = (Man) s.get(Man.class, new BigDecimal(32768));
		System.out.println(m.getName());
		if (m instanceof Stu) {
			System.out.println(((Stu) m).getScore());
		}
	}

	@Test
	public void testQuery() {
		Session s = HibernateSessionFactory.getSession();
		Query q = s.createQuery("from Man");
		List<Man> mlist=q.list();
		for(Man temp:mlist){
			if(temp instanceof Stu){
				System.out.println(temp.getName()+"----"+((Stu)temp).getScore());
			}else if(temp instanceof Tea){
				System.out.println(temp.getName()+"----"+((Tea)temp).getSalary());
			}
		}
	}
}
