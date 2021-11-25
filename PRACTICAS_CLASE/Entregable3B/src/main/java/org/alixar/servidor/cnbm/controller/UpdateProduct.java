package org.alixar.servidor.cnbm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.alixar.servidor.cnbm.dao.DAOProductImpl;
import org.alixar.servidor.cnbm.model.Product;

/**
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/UpdateProduct")
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
		
		String productCode = request.getParameter("productCode");
		String productName = request.getParameter("productName");
		String productLine = request.getParameter("productLine");
		String quantityInStock = request.getParameter("quantityInStock");
		String buyPrice = request.getParameter("buyPrice");
		
		request.getRequestDispatcher("../WEB-INF/view/admin/update.jsp").forward(request, response);
		
		if (productCode!=null && productName!=null && productLine!=null
			&& quantityInStock!=null && buyPrice!=null) {
			
			DAOProductImpl daoProductImpl = new DAOProductImpl();
//			Product product = daoProductImpl.getProduct();
//			ArrayList <Product> product = daoProductImpl.getAllProducts();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
