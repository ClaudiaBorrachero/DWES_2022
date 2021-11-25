package org.alixar.servidor.cnbm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.alixar.servidor.cnbm.dao.DAOProductLine;
import org.alixar.servidor.cnbm.dao.DAOProductLineImpl;
import org.alixar.servidor.cnbm.model.Products;

/**
 * Servlet implementation class UpdateProduct
 */
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String productLine = request.getParameter("productLine");
		
		DAOProductLine daoImpl = new DAOProductLineImpl();
		
		Products product = daoImpl.getProducts(productLine);
		
		request.setAttribute("producto", product);
		
		request.getRequestDispatcher("WEB-INF/view/update.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productLine = request.getParameter("producto");
		String textDescription = request.getParameter("textDescription");
		String htmlDescription = request.getParameter("htmlDescription");
		
		if (productLine!=null && textDescription!=null && htmlDescription!=null) {
			
			Products product = new Products(productLine, textDescription, htmlDescription);
			DAOProductLine daoImpl = new DAOProductLineImpl();
			daoImpl.updateProducts(product);
			
		}
		
		response.sendRedirect(request.getContextPath());
		
	}

}
