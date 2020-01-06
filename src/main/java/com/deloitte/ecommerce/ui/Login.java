package com.deloitte.ecommerce.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deloitte.ecommerce.dao.Edao;
import com.deloitte.ecommerce.dao.EdaoImpli;
import com.deloitte.ecommerce.service.Eservice;
import com.deloitte.ecommerce.service.EserviceImpl;

public class Login extends HttpServlet{
	private EserviceImpl service=new EserviceImpl(new EdaoImpli());

   
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        String mobileno = req.getParameter("mobileno");
        String password = req.getParameter("password");
        boolean correct=service.credentialsCorrect(mobileno,password);
        
        if (correct) {
            HttpSession session=req.getSession();
            session.setAttribute("mobileno",mobileno);
            resp.sendRedirect("/second");
        }else {
            resp.sendRedirect("html/file.html");
        }
    }


}



