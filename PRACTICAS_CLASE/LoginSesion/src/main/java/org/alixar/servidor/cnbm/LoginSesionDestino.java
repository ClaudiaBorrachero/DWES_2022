package org.alixar.servidor.cnbm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginSesionDestino
 */
@WebServlet("/LoginSesionDestino")
public class LoginSesionDestino extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSesionDestino() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession();
		String user = (String)sesion.getAttribute("user");
		String pass = (String)sesion.getAttribute("pass");
		
		PrintWriter out = response.getWriter();
		out.println("<h1>Bienvenid@ </h1>" + user + " con pass " + pass);
		
	}
}
