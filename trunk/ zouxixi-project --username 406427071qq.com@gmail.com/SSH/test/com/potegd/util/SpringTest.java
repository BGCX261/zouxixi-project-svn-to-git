package com.potegd.util;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.potegd.model.User;

public class SpringTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
		SessionFactory sf = (SessionFactory) ctx.getBean("sessionFactory");
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		User user = new User();
		user.setAge(23);
		user.setName("aaa");
		user.setBirthday(new Date());
		session.save(user);
		tr.commit();
		session.flush();
	}
	
}
