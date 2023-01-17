package com.svi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarriageServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Set  response Content Type
		resp.setContentType("text/html");
		//get PrintWriter
		PrintWriter pw=resp.getWriter();
		//get form data(req param values)
		String name=req.getParameter("pname");
		String tage=req.getParameter("page");
		String gender=req.getParameter("pgender");
		//Form Validations logic(server side)
		 if(name==null || name.equals("") ||name.length()==0){//must required rule
				pw.println("<span style=color:cyan;text-align:center>Person name must required</span>");
				return;
		 } //if		
		 else if(name.length()<5) {
			pw.println("<span style=color:cyan;text-align:center>Person name must have atleast 5 charcters</span>");
			return;
		}//else
		int age=0;
		if(tage==null || tage.equals("") || tage.length()==0) {
			pw.println("<span style=color:cyan;text-align:center>Person age must required</span>");
			return;
		}
		else{
			try {
				age=Integer.parseInt(tage);
				if(age<1 || age>125) {
					pw.println("<span style=color:cyan;text-align:center>Person age must be b/w 1 to  125</span>");
					return;
				}//if
			}//try
			catch(NumberFormatException nfe) {
				pw.println("<span style=color:cyan;text-align:center>Person age must be Numeric value</span>");
				return;
			}//catch
		}//else
		//Write b.logic or request processing logic
		pw.println("<h1 style='color:black;text-align:center'>Welcome to Shaadi.com</h1>");
		if(gender.equalsIgnoreCase("M")) {
			if(age<21)
				pw.println("<h2 style='color:purple;text-align:center'> Mr. " +name  +" U R not Eligible for Marriage</h2>");
			else
				pw.println("<h2 style='color:purple;text-align:center'> Mr. " +name  +" U R Eligible for Marriage</h2>");
		}
		else {
			if(age<21)
				pw.println("<h2 style='color:violet;text-align:center'> Miss. " +name  + " U R not Eligible for Marriage</h2>");
			else
				pw.println("<h2 style='color:violet;text-align:center'> Miss. " +name  +" U R Eligible for Marriage</h2>");
		}
		//Add Graphical HyperLink For Home
		pw.println("<h2 style='color:purple;text-align:center'><a href='page.html'><img src='image/home.jpg' width=50 hieght=50></a> </h2>");
		//close stream
		pw.close();
	}//doPost(-,-)
	    @Override
	    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
	    	System.out.println("MarriageServlet.doGet(-,-)");
	    	 doPost(req,resp);
	    }//doGet(-,-)
}//class	     
