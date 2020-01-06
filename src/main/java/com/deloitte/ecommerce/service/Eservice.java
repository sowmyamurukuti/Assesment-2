package com.deloitte.ecommerce.service;


import com.deloitte.ecommerce.Customer;

public interface Eservice {
	Customer getUserByMobileNo(String mobileno);

    boolean credentialsCorrect(String mobileno, String password);
}
