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
 * Servlet implementation class Confirmar
 */
@WebServlet("/Confirmar")
public class Confirmar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(Confirmar.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Confirmar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession();
		
		if (!sesion.isNew() && sesion.getAttribute("LOGEADO")!=null && ((boolean)sesion.getAttribute("LOGEADO"))) {
			request.getRequestDispatcher("confirmar.jsp").forward(request, response);
			return;
		} 
		logger.error("Intento de entrar en Confirmar sin tener sesión");
		sesion.invalidate();
		response.sendRedirect(request.getContextPath());
	}

}
