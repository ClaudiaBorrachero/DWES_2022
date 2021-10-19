package org.alixar.servidor.formularios;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		String simple = request.getParameter("simple");
		request.setAttribute("simple", simple);
		
		String select1[] = request.getParameterValues("select1");
		for (int i = 0; i < select1.length; i++){
			request.setAttribute("select1", select1);
		}
		
		String checkbox[] = request.getParameterValues("checkbox");
		request.setAttribute("checkbox", Arrays.toString(checkbox));
		
		request.getRequestDispatcher("Datos.jsp").forward(request, response);
		
//		ESTO NO SE DEBE HACER AQUI
//		PrintWriter out = response.getWriter();	
//		out.println("El campo simple es: " + simple);
		
	}

}
