package com.yan.extend3;

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
		Jiaotong j1=new Jiaotong();
		j1.setName("UFO");
		Jiaotong j2=new Kache();
		j2.setName("陕解放");
		((Kache)j2).setZaizhong(0.5);
		Jiaoche j3=new Jiaoche();
		j3.setName("奇瑞QQ");
		j3.setZaike(5);
		
		s.save(j1);
		s.save(j2);
		s.save(j3);
	}

	@Test
	public void testLoad() {
		Session s = HibernateSessionFactory.getSession();
		Jiaotong j=(Jiaotong) s.get(Jiaotong.class, 2L);
		System.out.println(j.getName()+((Kache)j).getZaizhong());
	}


	@Test
	public void testQuery() {
		Session s = HibernateSessionFactory.getSession();
		Query q = s.createQuery("from Jiaotong");
		List<Jiaotong> jlist=q.list();
		for(Jiaotong temp:jlist){
			System.out.println(temp.getName());
			if(temp instanceof Kache){
				System.out.println("\t载重量为"+((Kache)temp).getZaizhong());
			}else if(temp instanceof Jiaoche){
				System.out.println("\t载客人数为"+((Jiaoche)temp).getZaike());
			}
		}
	}
}
