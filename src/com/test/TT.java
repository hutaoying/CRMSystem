package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.pojo.Customer;
import com.pojo.LinkMan;
import com.pojo.Role;
import com.pojo.User;
import com.utils.HibernateUtils;




public class TT {
	@Test
	public void many_save() {
		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction tx=null;
		try{
	    sessionFactory=HibernateUtils.getSessionFactory();	
	    session=sessionFactory.openSession();
		 tx=session.beginTransaction();
		//创建对象
		 User user1=new User();
		 user1.setUser_name("hut");
		 user1.setUser_password("123");
		 
		 User user2=new User();
		 user2.setUser_name("tyhu");
		 user2.setUser_password("456");
		 
		 Role r1=new Role();
		 r1.setRole_name("总经理");
		 
		 Role r2=new Role();
		 r2.setRole_name("秘书");
		 
		 Role r3=new Role();
		 r3.setRole_name("司机");
		 /*
		  * user1---r1 r2
		  * user2---r2  r3
		  */
		 user1.getSetRole().add(r1);
		 user1.getSetRole().add(r2);
		 
		 user2.getSetRole().add(r2);
		 user2.getSetRole().add(r3);
		 
		 session.save(user1);
		 session.save(user2);
		 
		//6 提交事务
		tx.commit();
		}catch(Exception e){
			tx.rollback();
			
		}finally {
		//7 关闭资源
		session.close();
		sessionFactory.close();	
		}
	}
	
	@Test
	public void test1() {
		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction tx=null;
		try{
	    sessionFactory=HibernateUtils.getSessionFactory();	
	    session=sessionFactory.openSession();
		tx=session.beginTransaction();
		 Customer customer=new Customer();
		 customer.setCust_name("tengxun");
		 customer.setCust_level("vip");
		 customer.setCust_source("wangluo");
		 customer.setCust_phone("110");
		 customer.setCust_mobile("999");
		 
		 LinkMan linkman=new LinkMan();
		 linkman.setLkm_name("joan");
		 linkman.setLkm_gender("female");
		 linkman.setLkm_phone("990");
		 //������ϵ
		 customer.getSetLinkMan().add(linkman);
		
         
         
         
		 
		 session.save(customer);
		 
		//6 提交事务
		tx.commit();
		}catch(Exception e){
			tx.rollback();
			
		}finally {
		//7 关闭资源
		session.close();
		sessionFactory.close();	
		}
	}

}
