package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.pojo.LinkMan;
import com.utils.HibernateUtils;


public class LinkManInfoDao {

	public void save(LinkMan l) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			// ͨ��HibernateSessionFactory�Ự������õ��Ự������Ȼ�����openSession�õ�session
			session = HibernateUtils.getSessionFactory().openSession();
			// ��ʼ���ݿ�����
			session.beginTransaction();
			// ��session����usersDAO

			session.save(l);
			// �ύ����
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

	}

	public void update(LinkMan l) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			// ͨ��HibernateSessionFactory�Ự������õ��Ự������Ȼ�����openSession�õ�session
			session = HibernateUtils.getSessionFactory().openSession();
			// ��ʼ���ݿ�����
			session.beginTransaction();
			// ��session����usersDAO

			session.update(l);
			// �ύ����
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

	}

	public int count(String keyString) throws Exception {
		Session session = null;
		int result = 0;
		try {
			// ͨ��HibernateSessionFactory�Ự������õ��Ự������Ȼ�����openSession�õ�session
			session = HibernateUtils.getSessionFactory().openSession();
			// ��ʼ���ݿ�����
			session.beginTransaction();
			// ��session����usersDAO
			Query query = null;

			if (keyString == null || keyString.equals("")) {
				System.out.println("kkkk");
				query = session.createQuery("from LinkMan");

			} else {
				query = session.createQuery("from LinkMan as u where u.lkm_name like :lkm_name");
				query.setString("lkm_name", "%" + keyString + "%");

			}
			result = query.list().size();
			// �ύ����
			session.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

		return result;
	}
	public List<LinkMan> list() throws Exception {
		Session session = null;
		List<LinkMan> lList = null;
		try {
			// ͨ��HibernateSessionFactory�Ự������õ��Ự������Ȼ�����openSession�õ�session
			session = HibernateUtils.getSessionFactory().openSession();
			// ��ʼ���ݿ�����
			session.beginTransaction();
			// ��session����usersDAO
			lList=session.createQuery("from LinkMan").list();

			// lList=new LinkManService().cList(keyString,page,pageSize);
			// �ύ����
			session.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return lList;
	}
	public List<LinkMan> lList(String keyString,int page,int pageSize) throws Exception {
		Session session = null;
		List<LinkMan> lList = null;
		try {
			// ͨ��HibernateSessionFactory�Ự������õ��Ự������Ȼ�����openSession�õ�session
			session = HibernateUtils.getSessionFactory().openSession();
			// ��ʼ���ݿ�����
			session.beginTransaction();
			// ��session����usersDAO
			Query query = null;

			if (keyString==null||keyString.equals("")) {
				query = session.createQuery("from LinkMan");
				query.setFirstResult((page-1)*pageSize);
				query.setMaxResults(pageSize);
			} else {
				query = session.createQuery("from LinkMan as u where u.lkm_name like :lkm_name");
				query.setString("lkm_name", "%" + keyString + "%");
				query.setFirstResult((page-1)*pageSize);
				query.setMaxResults(pageSize);
			}
			lList = query.list();

			// cstList=new CustomerService().cList(keyString,page,pageSize);
			// �ύ����
			session.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return lList;
	}
	public LinkMan getById(long id) throws Exception {
		Session session = null;
		LinkMan l = null;
		try {
			// ͨ��HibernateSessionFactory�Ự������õ��Ự������Ȼ�����openSession�õ�session
			session = HibernateUtils.getSessionFactory().openSession();
			// ��ʼ���ݿ�����
			session.beginTransaction();
			// ��session����usersDAO

			// cstList=new CustomerService().cList(keyString,page,pageSize);
			// �ύ����
			l=(LinkMan) session.get(LinkMan.class, id);
			session.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return l;
	}

	public void delete(LinkMan l) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			// ͨ��HibernateSessionFactory�Ự������õ��Ự������Ȼ�����openSession�õ�session
			session = HibernateUtils.getSessionFactory().openSession();
			// ��ʼ���ݿ�����
			session.beginTransaction();
			// ��session����usersDAO

			session.delete(l);
			// �ύ����
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}
}
