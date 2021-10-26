package org.alixar.servidor.cnbm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.alixar.servidor.cnbm.model.Usuario;

/**
 * Servlet implementation class Fin
 */
@WebServlet("/Fin")
public class Fin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession();
		
		if (!sesion.isNew() && sesion.getAttribute("nombre")!=null) {
			
			Usuario usuario = new Usuario();
			usuario.setNombre((String)sesion.getAttribute("nombre"));
			usuario.setApellidos((String)sesion.getAttribute("apellidos"));
			usuario.setDireccion((String)sesion.getAttribute("direccion"));
			usuario.setEdad((int)sesion.getAttribute("edad"));
			usuario.setAficiones((String[])sesion.getAttribute("aficiones"));
			
			request.setAttribute("usuario", usuario);
			
			request.getRequestDispatcher("fin.jsp").forward(request, response);
			
		} else {
		
			sesion.invalidate();
			response.sendRedirect(request.getContextPath()+"/Inicio");
			
		}
		
	}


}
