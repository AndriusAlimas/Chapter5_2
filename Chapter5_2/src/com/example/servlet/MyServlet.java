package com.example.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Enumeration;

public class MyServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        out.println("<html>");
	        out.println("<head><title>Test ServletContext()</title></head>");
	        out.println("<body><h3>getServletContext().getInitParameter(\"City\"):</h3><br>");
	        out.println("<i>" + this.getServletContext().getInitParameter("City") + "</i><hr>");
	        // you can do this in two ways to get servlet context object, from servlet object this
	        // or as well from servletconfig object, this is completly same like with
	        // servletconfig init parameters, just scope is different context- means application scope
	        // and you have to look in DD not in servlet tag but in web-app tag,and called context-param:
	        ServletContext servletContext = this.getServletContext();
	        Enumeration enumeration = servletContext.getInitParameterNames();
	        while (enumeration.hasMoreElements()) {
	            out.println("<br>param name = " + enumeration.nextElement() + "<br>");
	        }
	        out.println("</body></html>");
	}
}
