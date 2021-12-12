package org.alixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.alixar.servidor.dao.DAOProductsImpl;
import org.alixar.servidor.model.Products;

/**
 * Servlet implementation class ProductDetailsUser
 */
//@WebServlet("/ProductsDetailsUser")
public class ProductsDetailsUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsDetailsUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productCode = request.getParameter("productCode");
		DAOProductsImpl daoImpl = new DAOProductsImpl();

		request.setAttribute("products", daoImpl.getProductByCode(productCode));

		request.getRequestDispatcher("/WEB-INF/view/productsDetails.jsp").forward(request, response);
		return;
	}

//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
