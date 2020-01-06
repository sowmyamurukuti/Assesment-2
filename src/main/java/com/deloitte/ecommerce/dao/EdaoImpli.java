package com.deloitte.ecommerce.dao;

import java.util.HashMap;
import com.deloitte.ecommerce. Customer;
import java.util.Map;


public class EdaoImpli implements Edao{
	 private Map<String,  Customer> store = new HashMap<>();

	    public void EdaoImpl() {
	    	 Customer user1 = new  Customer("987654321", "1234","Sowmya", 5000);
	        store.put("987654321", user1);
	        Customer user2 = new  Customer("987654374", "4321","Aarti", 2100);
	        store.put("987654374", user2);
	    }

	   
	    public boolean credentialsCorrect(String mobileno, String password) {
	    	 Customer user = store.get(mobileno);
	        if (user == null) {
	            return false;
	        }
	        return user.getPassword().equals(password);
	    }

	    @Override
	    public  Customer getUserByMobileNo(String mobileno) {
	    	 Customer user = store.get(mobileno);
	        return user;
	    }

}
