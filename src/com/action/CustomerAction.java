package com.action;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;

import com.dao.CustomerInfoDao;
import com.opensymphony.xwork2.ActionContext;
import com.pojo.Customer;

public class CustomerAction extends BaseAction {

	private Customer customer;

	private String keyString;
	private int pageSize;
	

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getKeyString() {
		return keyString;
	}

	public void setKeyString(String keyString) {
		this.keyString = keyString;
	}

	private int page;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	public String add() {
		try {
			
			new CustomerInfoDao().save(customer);
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
		}

		return ERROR;
	}

	public String update() {
		try {
			customer=new CustomerInfoDao().getById(customer.getCust_id());
		//	customer = new CustomerService().getById(customer.getCust_id());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("customer", customer);
		return "update";
	}

	public String edit() {
		try {
			new CustomerInfoDao().update(customer);
			//new CustomerService().update(customer);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";
	}
	public String delete() {
		try {
			new CustomerInfoDao().delete(customer);
			//new CustomerService().delete(customer);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";
	}

	public String create() throws Exception {
		return "add";
	}

	public String list() {
		System.out.println("jjjj");
		int count = 0;//总记录数
		List<Customer> cList = null;
		try {
			if(pageSize==0) {
				pageSize=3;
			}
			count = new CustomerInfoDao().count(keyString);
			int total = (int) Math.ceil((double) count / pageSize);//总页数
			if (page <= 0) {
				page = 1;
			} else if (page > total) {
				page = total;
			} 
			cList = new CustomerInfoDao().csList(keyString, page, pageSize);
			// cList = new CustomerInfoDao().list();

			
			System.out.println(page+"-------------page");
			request.setAttribute("page", page);
			request.setAttribute("pageSize", pageSize);
			request.setAttribute("list", cList);
			request.setAttribute("totalPage", total);
			request.setAttribute("total", count);
			request.setAttribute("cust_name", keyString);
			return "list";

		} catch (Exception e) {
			// TODO: handle exception
		}

		return "error";

	}
}
