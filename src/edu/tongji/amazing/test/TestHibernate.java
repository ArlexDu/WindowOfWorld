package edu.tongji.amazing.test;



import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.tongji.amazing.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class TestHibernate extends AbstractJUnit4SpringContextTests{
	
//	private ApplicationContext context = null;
	
	@Resource(name="user")
	private User user;
	
	@Test
	public void testName() throws Exception {
		
		user.setUsername("happy");
		System.out.println("username is "+user.getUsername());
	}


//	public void testDataSource() throws SQLException{
//		context = new ClassPathXmlApplicationContext("applicationContext.xml");
////		System.out.println(context);
//		DataSource datasource = context.getBean(DataSource.class);
////		System.out.println(datasource.getConnection().toString());
//		SessionFactory factory = context.getBean(SessionFactory.class);
////		System.out.println(factory);
////		打开session
//		Session session = factory.openSession();
////		开启事务
//		Transaction transaction = session.beginTransaction();
//		User user = new User();
//		user.setIdentity_id("130823199511258098");
//		user.setUsername("roth");
//		user.setPassword("123456");
//		session.save(user);
//		transaction.commit();
//		session.close();
//		
//	}
	
}
