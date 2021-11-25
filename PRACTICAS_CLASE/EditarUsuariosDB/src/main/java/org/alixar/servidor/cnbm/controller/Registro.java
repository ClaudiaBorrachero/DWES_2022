package org.alixar.servidor.cnbm.controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.alixar.servidor.cnbm.dao.DAOUsuarios;
import org.alixar.servidor.cnbm.dao.DAOUsuariosImpl;
import org.alixar.servidor.cnbm.model.Usuarios;

/**
 * Servlet implementation class Registro
 */
//@WebServlet("/Registro")
public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*" +
            "@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession();
		
		if (!sesion.isNew() && sesion.getAttribute("LOGEADO") != null && ((boolean) sesion.getAttribute("LOGEADO"))) { 
		
			response.sendRedirect(request.getContextPath() + "/Login");
		
		} else {
			
			sesion.invalidate();
			request.getRequestDispatcher("WEB-INF/view/registro.jsp").forward(request, response); 
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String correo = request.getParameter("correo");
		String rol = request.getParameter("rol");
		String passw1 = request.getParameter("passw1");
		String passw2 = request.getParameter("passw2");
		
		HttpSession sesion = request.getSession();
		
//		if (!sesion.isNew() && sesion.getAttribute("LOGEADO") != null && ((boolean) sesion.getAttribute("LOGEADO"))) { 
//			if (request.getParameter("REGISTRARSE")!=null && request.getParameter("REGISTRARSE").equals("REGISTRARSE")
//				|| request.getParameter("ACTUALIZAR")!=null && request.getParameter("ACTUALIZAR").equals("ACTUALIZAR") ) {
				
				if (nombre!=null && correo!=null && EMAIL_PATTERN.matcher(correo).matches()
					&& rol!=null && passw1!=null && passw2!=null && passw1.equals(passw2)) {
										
						sesion.setAttribute("LOGEADO", true);
						sesion.setAttribute("usuario", nombre);
						
						DAOUsuariosImpl daoImpl = new DAOUsuariosImpl();
						
						if (daoImpl.getUsuarios(nombre, passw1)==null) {
							
							Usuarios usuario = new Usuarios(nombre,correo, rol, passw1);
							daoImpl.addUsuarios(usuario);
							response.sendRedirect(request.getContextPath() + "/Login");
							
						} else {
							
							request.setAttribute("error", "Usuario ya existente");
							request.setAttribute("nombre", nombre);
							request.setAttribute("correo", correo);
							request.setAttribute("rol", rol);
							request.setAttribute("passw1", passw1);
							
							doGet(request, response);
						}
						
					} else {
					
						response.sendRedirect(request.getContextPath() + "/Registro");
						
					}
					
//				} 
			
			return;
//		}
	}
}
