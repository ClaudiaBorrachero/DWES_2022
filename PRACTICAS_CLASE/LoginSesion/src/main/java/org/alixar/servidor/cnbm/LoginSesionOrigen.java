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
 * Servlet implementation class LoginSesion
 */
@WebServlet("/LoginSesionOrigen")
public class LoginSesionOrigen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSesionOrigen() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		PrintWriter out = response.getWriter();

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
				
		out.println("<html>");
		out.println("<head><title>Login</title><head>");
		out.println("<body>");
		out.println("<h1>Formulario de inicio de sesión</h1>");
			
		out.println("<form method=\"post\">");
		out.println("<label for=\"user\">Usuario:</label><input id=\"user\" type=\"text\" name=\"user\" required><br><br>");
		out.println(
				"<label for=\"pass\">Password:</label><input id=\"pass\" type=\"password\" name=\"pass\" required><br><br>");
		out.println("<button type=\"submit\" name=\"submit\">Iniciar Sesión</button>");
		out.println("</form>");
		out.println("</body></html>");
		
		out.close();
		
		response.sendRedirect(request.getContextPath() + "/LoginSesionDestino");
	
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

    	PrintWriter out = response.getWriter();

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		
		if (request.getMethod().equals("POST")){
			if (user.equals("admin")  && pass.equals("admin")) {
				HttpSession sesion = request.getSession();	
				sesion.setAttribute("user", user);
				sesion.setAttribute("pass", pass);
				response.sendRedirect(request.getContextPath() + "/LoginSesionDestino");
			} else {
				out.println("Error al introducir el usuario y/o la contraseña");
				doGet(request,response);
			}
		}
		out.close();
    }
    
}
