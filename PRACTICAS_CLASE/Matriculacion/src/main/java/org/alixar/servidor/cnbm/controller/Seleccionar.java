package org.alixar.servidor.cnbm.controller;

import java.io.IOException;

import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Seleccionar
 */
@WebServlet("/Seleccionar")
public class Seleccionar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Seleccionar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("Seleccionar.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		String nombre = request.getParameter("nombre");
		request.setAttribute("nombre", nombre);
		String apellido = request.getParameter("apellido");
		request.setAttribute("apellido", apellido);
		String correo = request.getParameter("correo");
		request.setAttribute("correo", correo);
		
		String select[] = request.getParameterValues("select");
		for (int i = 0; i < select.length; i++){
			request.setAttribute("select", select);
		}
		
		String radio[] = request.getParameterValues("radio");
		request.setAttribute("radio", Arrays.toString(radio));

		Cookie cookieRadio = new Cookie("Curso", Arrays.toString(radio));
		response.addCookie(cookieRadio);
		
//		response.sendRedirect("Confirmar");
		request.getRequestDispatcher("Confirmar.jsp").forward(request, response);
		
		}

}
