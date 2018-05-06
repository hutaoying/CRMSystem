package com.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	static Configuration cfg=null;
	static SessionFactory sessionFactory=null;
	//��̬�����ʵ��
	static {
		cfg=new Configuration();
		cfg.configure();
		sessionFactory=cfg.buildSessionFactory();
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	//��ȡ�뱾���̰߳󶨵�session
	public static  Session getSessionObject() {
		return sessionFactory.getCurrentSession();
	}
	

}
