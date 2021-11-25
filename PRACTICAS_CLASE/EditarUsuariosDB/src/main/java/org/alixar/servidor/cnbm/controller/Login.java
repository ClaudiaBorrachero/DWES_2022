package org.alixar.servidor.cnbm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.alixar.servidor.cnbm.dao.DAOUsuarios;
import org.alixar.servidor.cnbm.dao.DAOUsuariosImpl;
import org.alixar.servidor.cnbm.model.Usuarios;

/**
 * Servlet implementation class Login
 */
//@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOUsuariosImpl daoImpl = new DAOUsuariosImpl();
		
		ArrayList<Usuarios> listaUsuarios = (ArrayList)daoImpl.getAllUsuarios();
		
		request.setAttribute("listaUsuarios", listaUsuarios);
		
		request.getRequestDispatcher("WEB-INF/view/foto.jsp").forward(request, response);

	}

}
