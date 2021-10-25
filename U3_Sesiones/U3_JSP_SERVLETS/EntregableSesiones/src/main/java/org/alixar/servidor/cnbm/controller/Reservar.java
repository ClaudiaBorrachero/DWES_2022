package org.alixar.servidor.cnbm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class Reservar
 */
@WebServlet("/Reservar")
public class Reservar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(Reservar.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reservar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession();
		if (!sesion.isNew() && sesion.getAttribute("LOGEADO")!=null && ((boolean)sesion.getAttribute("LOGEADO"))) {
			request.getRequestDispatcher("reservar.jsp").forward(request, response);
			return;
		} 
		sesion.invalidate();
		response.sendRedirect(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession();
		
		if (!sesion.isNew() && sesion.getAttribute("LOGEADO")!=null && ((boolean)sesion.getAttribute("LOGEADO"))) {
			
			if ( request.getParameter("reservar")!=null && request.getParameter("reservar").equals("RESERVAR")) {
				
				if (request.getParameter("fechaInicio")!=null && request.getParameter("fechaFin")!=null
						&& request.getParameter("numPersonas")!=null) {
					
					sesion.setAttribute("fechaInicio", (request.getParameter("fechaInicio")));
					sesion.setAttribute("fechaFin", (request.getParameter("fechaFin")));
					sesion.setAttribute("numPersonas", (request.getParameter("numPersonas")));
					sesion.setAttribute("checkbox", request.getParameterValues("checkbox"));
					
				}
				
				response.sendRedirect(request.getContextPath()+"/Confirmar");				
				return;
				
			} else {
				
				logger.error("Faltan parámetros o hay un dato incorrecto");
				
				response.sendRedirect(request.getContextPath()+"/Reservar");
				return;
				
			}
			
		}
		
	}

}
