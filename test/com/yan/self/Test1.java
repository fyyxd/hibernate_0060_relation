package com.yan.self;

import static org.junit.Assert.*;

import java.util.Set;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yan.entity.one2one2.IdCard;
import com.yan.entity.one2one2.Person;
import com.yan.entity.self.Catalog;
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
		Catalog c = new Catalog("ͼ��");
		Catalog c1 = new Catalog("�����ͼ��");
		c.getChildren().add(c1);
		c1.setParent(c);
		Catalog c2 = new Catalog("����ͼ��");
		c.getChildren().add(c2);
		c2.setParent(c);
		Catalog c11 = new Catalog("���ͼ��");
		c1.getChildren().add(c11);
		c11.setParent(c1);
		Catalog c12 = new Catalog("Ӳ��ͼ��");
		c1.getChildren().add(c12);
		c12.setParent(c1);
		
		Session s=HibernateSessionFactory.getSession();
		s.save(c);
	}

	@Test
	public void testLoad() {
		Session s = HibernateSessionFactory.getSession();
		Catalog c=(Catalog) s.load(Catalog.class, 1L);
		show(c,0);
	}

	
	private void show(Catalog c,int level){
		for(int i=0;i<level;i++)
			System.out.print(" ");
		System.out.println(c.getTitle());
		Set<Catalog> children=c.getChildren();
		for(Catalog temp:children)
			show(temp,level+5);
	}
	
}
