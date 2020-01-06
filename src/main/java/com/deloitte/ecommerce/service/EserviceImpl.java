package com.deloitte.ecommerce.service;

import com.deloitte.ecommerce.Customer;
import com.deloitte.ecommerce.dao.Edao;

public class EserviceImpl {
	  private Edao dao;

	    public EserviceImpl(Edao dao) {
	        this.dao = dao;
	    }

	    public  Customer getUserByMobileNo(String mobileno) {
	        Customer user = dao.getUserByMobileNo(mobileno);
	        return user;
	    }

	
	    public boolean credentialsCorrect(String mobileno, String password) {
	        boolean correct = dao.credentialsCorrect(mobileno, password);
	        return correct;
	    }
}
