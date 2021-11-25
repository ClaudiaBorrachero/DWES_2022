package org.alixar.servidor.cnbm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.alixar.servidor.cnbm.dao.DAOProductLine;
import org.alixar.servidor.cnbm.dao.DAOProductLineImpl;
import org.alixar.servidor.cnbm.model.Products;

/**
 * Servlet implementation class ListadoProductos
 */
@WebServlet("/ListadoProductos")
public class ListadoProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListadoProductos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOProductLine daoImpl = new DAOProductLineImpl();
		
		ArrayList<Products> productsList = (ArrayList)daoImpl.getAllProducts();
		
		request.setAttribute("productos", productsList);
		request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
		
	}

}
