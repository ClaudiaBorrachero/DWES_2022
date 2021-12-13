package org.alixar.servidor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.alixar.servidor.dao.DAOProductImpl;
import org.alixar.servidor.dao.DAOUsuarioImpl;
import org.alixar.servidor.model.Usuario;

/**
 * Servlet implementation class Home
 */
//@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession();
		
		if (!sesion.isNew()) {
			request.getRequestDispatcher("WEB-INF/view/home.jsp").forward(request, response);
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
		
		String email = request.getParameter("email");
		DAOUsuarioImpl daoUsuarioImpl = new DAOUsuarioImpl();
		Usuario user = daoUsuarioImpl.getUsuarioEmail(email);
//		sesion.getAttribute("role");
		sesion.getAttribute("usuario");
		sesion.setAttribute("role", user.getRole());
		sesion.setAttribute("usuario", user.getUsuario());
		
		String productLine = request.getParameter("productLine");
		
		DAOProductImpl daoProductImpl = new DAOProductImpl();
		
		sesion.setAttribute("categorias", daoProductImpl.getProductCategory(productLine));
		
		doGet(request,response);
		return;
		
	}

}
