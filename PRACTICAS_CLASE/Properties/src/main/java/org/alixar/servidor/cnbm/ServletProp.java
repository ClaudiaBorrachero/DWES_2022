package org.alixar.servidor.cnbm;

import java.io.IOException;
import java.util.*;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletProp
 */
@WebServlet("/ServletProp")
public class ServletProp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<String> listaProp = new ArrayList<String>();
		
		Properties prop = new Properties();
		InputStream is = null;
		
		try {
			is = new FileInputStream("resources/bd.properties");
			prop.load(is);
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		String usuario = prop.getProperty("servidor.usuario");
		String password = prop.getProperty("servidor.password");
		String host = prop.getProperty("servidor.host");
		String puerto = prop.getProperty("servidor.puerto");
		
		for(Enumeration e = prop.keys();e.hasMoreElements();) {
			
			String key = (String) e.nextElement();
			listaProp.add(prop.getProperty(key));
			
//			Object obj = e.nextElement();
//			String value = prop.getProperty(obj.toString());
			
		}
		request.setAttribute("propiedades", listaProp);
		request.getRequestDispatcher("propiedades.jsp").forward(request, response);
	}

}
