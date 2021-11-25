package org.alixar.servidor.cnbm.controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.alixar.servidor.cnbm.dao.DAOUsuarios;
import org.alixar.servidor.cnbm.dao.DAOUsuariosImpl;
import org.alixar.servidor.cnbm.model.Usuarios;

/**
 * Servlet implementation class UpdateUser
 */
//@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*" +
            "@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
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
		
		Usuarios usuario = daoImpl.getUsuarios(nombre, correo);
		
		request.setAttribute("usuario", usuario);
		request.getRequestDispatcher("WEB-INF/view/update.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String correo = request.getParameter("correo");
		String rol = request.getParameter("rol");
		String passw1 = request.getParameter("passw1");
		
		if (nombre!=null && EMAIL_PATTERN.matcher(correo).matches() && correo!=null
				&& rol!=null && passw1!=null) {
			
			Usuarios usuario = new Usuarios(nombre,correo, rol, passw1);
			DAOUsuariosImpl daoImpl = new DAOUsuariosImpl();
			daoImpl.updateUsuarios(usuario);
			
		} 
		
		response.sendRedirect(request.getContextPath() + "/Login");
		
	}

}
