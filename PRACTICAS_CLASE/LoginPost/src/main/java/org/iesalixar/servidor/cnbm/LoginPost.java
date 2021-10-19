package org.iesalixar.servidor.cnbm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginPost
 */
@WebServlet("/LoginPost")
public class LoginPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Muestro un formulario para recoger nombre y apellidos del usuario
		PrintWriter out = response.getWriter();

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		
		out.println("<html>");
		out.println("<head><title>Login</title><head>");
		out.println("<body>");
		out.println("<h1>Formulario de inicio de sesión</h1>");
				
		if (request.getAttribute("error")!=null  && ((boolean)request.getAttribute("error"))) {
			out.println("<p style=color:red>Datos erróneos</p>");
		}

		out.println("<form method=\"post\">");
		out.println("<label for=\"user\">Usuario:</label><input id=\"user\" type=\"text\" name=\"user\" required><br><br>");
		out.println(
				"<label for=\"pass\">Password:</label><input id=\"pass\" type=\"password\" name=\"pass\" required><br><br>");
		out.println("<button type=\"submit\" name=\"submit\">Iniciar Sesión</button>");
		out.println("</form>");
		out.println("</body></html>");
		
		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		// Comienzo de la lista de parámetros
		out.println("<ul>");
					
			String user = request.getParameter("user");
			String pass = request.getParameter("pass");
			
//			out.write("User: " + user + "<br>");
//			out.write("Pass: " + pass);				
			
			if (user.equals("admin")  && pass.equals("admin")) {
				out.write("<h2>Bienvenido ADMIN</h2>");
			} else {
				request.setAttribute("error", true);
				doGet(request,response);
				}

//				while (paramEnumeration.hasMoreElements()) {
//				String param = (String) paramEnumeration.nextElement();
//				out.write(param + " : " + request.getParameter(param));
//				
//				if (user.equals("admin") && pass.equals("admin")) {
//					out.write("<h2>Eres admin</h2>");
//				} else if (user != "admin" && pass != "admin"){
//					out.write("<h2>No eres admin</h2>");
//				}
//			}
								
			// Fin de la lista de parámetros
			out.println("</ul>");
			
			out.close();
		}
        
	}
