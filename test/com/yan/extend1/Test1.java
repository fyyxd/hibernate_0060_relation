package com.yan.extend1;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yan.extends1.Animal;
import com.yan.extends1.Cat;
import com.yan.extends1.Dog;
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
		Animal a1 = new Animal();
		a1.setName("畜生");
		Animal a2 = new Cat();
		a2.setName("小白痴");
		((Cat)a2).setColor("黑色");
		Dog a3=new Dog();
		a3.setName("小黑");
		a3.setCatalog("腊肠");

		Session s = HibernateSessionFactory.getSession();
		s.save(a1);
		s.save(a2);
		s.save(a3);
	}
	@Test
	public void testLoad() {
		Session s = HibernateSessionFactory.getSession();
		Animal a=(Animal) s.get(Animal.class, 4L);
		if(a!=null && a instanceof Dog){
			Dog temp=(Dog)a;
			System.out.println(temp.getName()+"---"+temp.getCatalog());
		}
	}
	@Test
	public void testQuery() {
		Session s = HibernateSessionFactory.getSession();
		Query q=s.createQuery("from Animal");
		List<Animal> list=q.list();
		for(Animal a:list){
			System.out.print(a.getId()+"---"+a.getName());
			if(a!=null && a instanceof Cat){
				System.out.print("----"+((Cat)a).getColor()+"----是猫");				
			}else if(a!=null && a instanceof Dog){
				System.out.print("----"+((Dog)a).getCatalog()+"----是狗");
			}
			System.out.println();
		}
	}
}
