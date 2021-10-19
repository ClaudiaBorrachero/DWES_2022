package org.alixar.servidor.cnbm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.alixar.servidor.cnbm.model.Usuarios;

/**
 * Servlet implementation class Login
 */

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("Login.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = request.getParameter("user");
		String password = request.getParameter("pass");
		HttpSession sesion = null;
		
		if (usuario.equals("admin") && password.equals("admin")) {
			
			sesion = request.getSession();
			Usuarios user = new Usuarios();
			user.setNombre(usuario);
			sesion.setAttribute("user",user);
			
			response.sendRedirect("Admin");
			
		} else if (usuario.equals("usuario") && password.equals("usuario")) {
			
			sesion = request.getSession();
			Usuarios user = new Usuarios();
			user.setNombre(usuario);
			sesion.setAttribute("user",user);
			
			response.sendRedirect("Usuario");
			
		} else {
			response.sendRedirect("Login");
		}
	}

}
