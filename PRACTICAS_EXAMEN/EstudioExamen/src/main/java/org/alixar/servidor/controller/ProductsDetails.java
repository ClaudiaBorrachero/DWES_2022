package org.alixar.servidor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.alixar.servidor.dao.DAOProductsImpl;

/**
 * Servlet implementation class ProductsDetails
 */
//@WebServlet("/ProductsDetails")
public class ProductsDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOProductsImpl dao = new DAOProductsImpl();
		
		request.setAttribute("productos", dao.getProductByCode(request.getParameter("pc")));
		
		request.setAttribute("detailsOrderNumber", dao.getDetailsOrderNumber(request.getParameter("pc")));
		request.setAttribute("detailsNumProductosVentas", dao.getDetailsNumProductosVentas(request.getParameter("pc")));
		request.setAttribute("detailsNumVentasPrecio", dao.getDetailsNumVentasPrecio(request.getParameter("pc")));
		
		request.getRequestDispatcher("/WEB-INF/view/admin/detalleProducto.jsp").forward(request, response);
		
	}

//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		doGet(request,response);
//		
//	}

}
