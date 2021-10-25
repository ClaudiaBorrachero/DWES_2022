package org.alixar.servidor.cnbm.controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(Main.class);
	
	private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*" +
            "@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
 
private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("inicio.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession();
		
		if ( request.getParameter("registrarse")!=null && request.getParameter("registrarse").equals("REGISTRARSE")) {
			
			String pass = request.getParameter("pass");
			String passw = request.getParameter("passw");
			String usuario = request.getParameter("usuario");
			
			if (pass.equals(passw) && EMAIL_PATTERN.matcher(request.getParameter("email")).matches()) {
			
				sesion.setAttribute("LOGEADO", true);
				sesion.setAttribute("usuario", usuario);
				
				response.sendRedirect(request.getContextPath()+"/Reservar");
				return;
				
			} else {
				
				logger.error("Faltan parámetros o el email es incorrecto");
				
				response.sendRedirect(request.getContextPath()+"/Main");
				return;
				
			}	
		}
		response.sendRedirect(request.getContextPath());
	}

}
