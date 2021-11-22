package org.alixar.servidor.cnbm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.alixar.servidor.cnbm.dao.DAOUsuarioImpl;
import org.alixar.servidor.cnbm.model.Usuario;


/**
 * Servlet implementation class DatosUsuario
 */

public class DatosUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatosUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = request.getParameter("usuario");
		String email = request.getParameter("email");
		
//		if (usuario!=null && email!=null) {
			
			DAOUsuarioImpl daoUsuarioImpl = new DAOUsuarioImpl();
			Usuario user = daoUsuarioImpl.getUsuario(usuario);
			
//			request.setAttribute("usuario", user);
//			request.getRequestDispatcher("WEB-INF/view/updatePassword.jsp").forward(request, response);
		
//		} else {
//			response.sendRedirect(request.getContextPath() + "/DatosUsuario");
//		}
		
		request.getRequestDispatcher("WEB-INF/view/datosUsuario.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);
		
	}

}
