package org.alixar.servidor.cnbm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.alixar.servidor.cnbm.dao.DAOUsuariosImpl;

/**
 * Servlet implementation class RemoveUser
 */
//@WebServlet("/RemoveUser")
public class RemoveUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String correo = request.getParameter("correo");
		
		DAOUsuariosImpl daoImpl = new DAOUsuariosImpl();
		
		if (nombre!=null && correo!=null) {
			
			daoImpl.removeUsuarios(nombre, correo);
			
		}
		
		response.sendRedirect(request.getContextPath() + "/Login");
		
	}

}
