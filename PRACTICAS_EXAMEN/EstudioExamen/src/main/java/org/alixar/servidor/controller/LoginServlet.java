package org.alixar.servidor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.alixar.servidor.dao.DAOUsuariosImpl;
import org.alixar.servidor.model.Usuarios;
import org.alixar.servidor.utils.PasswordHashGenerator;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		
		if (usuario!=null && password!=null) {
		
			DAOUsuariosImpl daoUsuarioImpl = new DAOUsuariosImpl();
			
			Usuarios user = daoUsuarioImpl.getUsuario(usuario);
			
			if (PasswordHashGenerator.checkPassword(password, user.getPassword())) {
				
				HttpSession sesion = request.getSession();
				
				sesion.setAttribute("usuario", user.getUsuario());
				sesion.setAttribute("email", user.getEmail());
				sesion.setAttribute("role", user.getRole());
								
				if ("admin".equals(user.getRole())) {
					response.sendRedirect("AdminMainServlet/");
				} else {
					response.sendRedirect("SearchProductServlet");
				}
			} else {
				
				request.setAttribute("error", "Credenciales inválidas");
				doGet(request, response);
				return; 
				
			}
						
		}  else {
			   
			request.setAttribute("error", "Usuario no existente");
			doGet(request,response);
			return;
			
		}
		
	}

}
