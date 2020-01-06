package com.deloitte.ecommerce.ui;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deloitte.ecommerce.Customer;
import com.deloitte.ecommerce.dao.EdaoImpli;
import com.deloitte.ecommerce.service.Eservice;
import com.deloitte.ecommerce.service.EserviceImpl;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/second")
public class Servlet1 extends HttpServlet {
	
	

	    private EserviceImpl service=new EserviceImpl(new EdaoImpli());

	   
	    protected void doGet(HttpServletRequest req,
	                         HttpServletResponse resp)
	            throws ServletException, IOException {
	        resp.setContentType("text/html");
	        resp.setCharacterEncoding("UTF-8");
	        PrintWriter writer = resp.getWriter();
	        HttpSession session = req.getSession();
	        String signedOutVal = req.getParameter("signout");
	        boolean sessionDestroyed = false;
	        if (signedOutVal != null && signedOutVal.equals("true")) {
	            session.invalidate();
	            sessionDestroyed = true;
	        }
	        Object usernameObj=null;
	        if (!sessionDestroyed) {
	            usernameObj = session.getAttribute("mobileno");
	        }

	        if (usernameObj == null || usernameObj.toString().isEmpty()) {
	            resp.getWriter().println("you are not signed in yet");
	            String signInLink = "<a href='/html/form.html'>Sign In </a> ";
	            writer.println(signInLink);
	            return;
	        }
	        String mobileno=usernameObj.toString();
	        Customer user=service.getUserByMobileNo(mobileno);
	        String name=user.getName();
	        double balance=user.getBalance();
	        writer.println("Welcome " +" name="+name+" balance="+balance);
	        String signoutLink = "<a href='/second?signout=true'>Sign out </a> ";
	        writer.println(signoutLink);

	    }


	}








