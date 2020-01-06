package com.deloitte.ecommerce.dao;

import com.deloitte.ecommerce. Customer;

public interface Edao {
	 Customer getUserByMobileNo(String mobileno);

    boolean credentialsCorrect(String mobileno, String password);
}
