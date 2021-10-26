package org.alixar.servidor.cnbm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ejemplo
 */
@WebServlet("/Inicio")
public class Inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inicio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession();
		
		String[] aficiones = {"golf","marisco","deportivos"};
		
		sesion.setAttribute("nombre", "pepe");
		sesion.setAttribute("apellidos", "pérez");
		sesion.setAttribute("direccion", "C/Sevilla,12");
		sesion.setAttribute("edad", 45);
		sesion.setAttribute("aficiones", aficiones);
		
		response.sendRedirect(request.getContextPath()+"/Fin");
	}

}
