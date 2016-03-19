package edu.tongji.amazing.test;



import java.sql.SQLException;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.inject.Context;

import edu.tongji.amazing.model.User;


public class TestHibernate {
	
	private ApplicationContext context = null;
	@Test
	public void testName() throws Exception {
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		User user = (User) context.getBean("User");
		System.out.println("username is "+user.getUsername());
	}
	
//    public void createTable(){
//    	Configuration configuration = new Configuration().configure();
//    	@SuppressWarnings("deprecation")
//		SchemaExport export = new SchemaExport(configuration);
//    	export.create(true, true);
//    }
	@Test
	public void testDataSource() throws SQLException{
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		System.out.println(context);
		DataSource datasource = context.getBean(DataSource.class);
//		System.out.println(datasource.getConnection().toString());
		SessionFactory factory = context.getBean(SessionFactory.class);
//		System.out.println(factory);
//		打开session
		Session session = factory.openSession();
//		开启事务
		Transaction transaction = session.beginTransaction();
		User user = new User();
		user.setId(2);
		user.setIdentity_id("130823199511258097");
		user.setUsername("happy");
		user.setPassword("123456");
		session.save(user);
		transaction.commit();
		session.close();
		
	}
	
}
