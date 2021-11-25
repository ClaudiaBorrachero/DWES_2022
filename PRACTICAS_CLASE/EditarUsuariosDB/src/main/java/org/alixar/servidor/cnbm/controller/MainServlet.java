package org.alixar.servidor.cnbm.controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/view/inicio.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = request.getParameter("usuario");
		String passw1 = request.getParameter("passw1");
		
		if (request.getParameter("ENTRAR")!=null && request.getParameter("ENTRAR").equals("ENTRAR") 
			&& usuario.equals("admin") && passw1.equals("admin")) {

			HttpSession sesion = request.getSession();
			sesion.setAttribute("LOGEADO", true);
			sesion.setAttribute("usuario", usuario);
			
			response.sendRedirect(request.getContextPath() + "/Login");
			
			return;
			
		} else if (request.getParameter("REGISTRARSE")!=null && request.getParameter("REGISTRARSE").equals("REGISTRARSE")) {
			
			HttpSession sesion = request.getSession();
			sesion.setAttribute("LOGEADO", false);
			response.sendRedirect(request.getContextPath() + "/Registro");
			
			return;
			
		}
		
		response.sendRedirect(request.getContextPath());
		
		
	}

}
