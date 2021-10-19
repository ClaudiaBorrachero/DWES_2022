package controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;

/**
 * Servlet implementation class Servlet
 */
public class Redirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Redirect() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher a = request.getRequestDispatcher("a.jsp");
		RequestDispatcher b = request.getRequestDispatcher("b.jsp");
				
		if(request.getParameter("destino")!=null) {
			
			if(request.getParameter("destino").equalsIgnoreCase("A")) {
//				response.sendRedirect("a.jsp");
				
				Usuario usuario = new Usuario();
				usuario.setUsuario("admin");
				usuario.setPass("admin");
				request.setAttribute("usuario", usuario);
				
				a.forward(request, response);
				
			} else {
//				response.sendRedirect("b.jsp");
				Usuario usuario = new Usuario();
				usuario.setUsuario("pepe");
				usuario.setPass("pepe");
				request.setAttribute("usuario", usuario);
				
				b.forward(request, response);
			}
			
		} else {
			PrintWriter out = response.getWriter();
			out.println("NO TENGO DESTINO");
		}
	}

}
