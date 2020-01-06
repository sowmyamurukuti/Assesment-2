package com.deloitte.ecommerce;



public class Customer {

    
	private String mobileno;
	private String password;
	private String name;
	private double balance;

	public Customer() {

    }

    public Customer(String mobileno, String password, String name, double balance) {
        this.mobileno = mobileno;
        this.password = password;
        this.name = name;
        this.balance=balance;
    }




	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof  Customer)) {
            return false;
        }
        Customer user = ( Customer) obj;
        return user.mobileno.equals(this.mobileno);
    }

    @Override
    public int hashCode() {
        return mobileno.hashCode();
    }
}
