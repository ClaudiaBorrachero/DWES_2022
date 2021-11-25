package org.iesalixar.servidor.controller;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOProductImpl;
import org.iesalixar.servidor.dao.DAOUsuarioImpl;
import org.iesalixar.servidor.model.Product;
import org.iesalixar.servidor.model.Usuario;
import org.iesalixar.servidor.utils.PasswordHashGenerator;

/**
 * Servlet implementation class UpdatePassword
 */

public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = request.getParameter("usuario");
		DAOProductImpl daoProductImpl = new DAOProductImpl();
		
		Cookie[] cookies = request.getCookies();

		for (Cookie c : cookies) {

			if (c.getName().equals("cesta")) {
				
				ArrayList<Product> listaCesta = new ArrayList<Product>();
				listaCesta.add(daoProductImpl.getProducts(c.getValue()));
						
				request.setAttribute("cesta", listaCesta);
			}
		}
		
		request.getRequestDispatcher("WEB-INF/view/updatePassword.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String usuario = request.getParameter("usuario");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		
		DAOUsuarioImpl daoUsuarioImpl = new DAOUsuarioImpl();
		Usuario user = daoUsuarioImpl.getUsuario(usuario);
		
//		usuario!=null && email!=null && password!=null && password2!=null && 
		if (password.equals(password2)) {

			password2 = PasswordHashGenerator.hashPassword(password2);
			user.setPassword(password2);
			daoUsuarioImpl.updatePassword(user);	
			
			response.sendRedirect(request.getContextPath() + "/DatosUsuario");
			return;
		} else {
			request.setAttribute("diferentes", "Las contraseñas no son iguales");
			System.out.println("Las contraseñas no son iguales");
		}
		doGet(request, response);
	}

}
