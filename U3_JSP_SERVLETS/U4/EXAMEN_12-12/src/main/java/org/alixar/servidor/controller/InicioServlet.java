package org.alixar.servidor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.alixar.servidor.dao.DAOUsuarioImpl;
import org.alixar.servidor.model.Usuario;
import org.alixar.servidor.utils.PasswordHashGenerator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Servlet implementation class InicioServlet
 */
@WebServlet("/InicioServlet")
public class InicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(InicioServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InicioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/view/login.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if (email!=null && password!=null) {
			
			DAOUsuarioImpl daoUsuarioImpl = new DAOUsuarioImpl();
			Usuario user = daoUsuarioImpl.getUsuarioEmail(email);
			
			if (user!=null) {
			
				if (PasswordHashGenerator.checkPassword(password, user.getPassword())) {
					
					HttpSession sesion = request.getSession();
					
					sesion.setAttribute("usuario", user.getUsuario());
					sesion.setAttribute("email", user.getEmail());
					sesion.setAttribute("role", user.getRole());
					sesion.setAttribute("firstName", user.getFirstName());
					sesion.setAttribute("lastName", user.getLastName());
					
					if ("admin".equals(user.getRole())) {
						logger.log(Level.INFO, "Admin Conectado con éxito");
						response.sendRedirect(request.getContextPath()+"/Home");
					} else {
						logger.log(Level.INFO, "Usuario Conectado con éxito");
						doGet(request,response);
					}
				} else {
					
					request.setAttribute("error", "Credenciales inválidas");
					logger.log(Level.INFO, "Credenciales erroneas");
					doGet(request, response);
					return; 
					
				}
			} else {
				
				request.setAttribute("error", "Usuario no existente");
				logger.log(Level.INFO, "Usuario no existente");
				doGet(request,response);
				return;
				
			}
						
		}  else {
			   
			request.setAttribute("error", "Rellena el formulario");
			logger.log(Level.INFO, "Rellena el formulario");
			doGet(request,response);
			return;
			
		}
		
	}

}
