package org.alixar.servidor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.alixar.servidor.dao.DAOProductImpl;
import org.alixar.servidor.model.Product;

/**
 * Servlet implementation class EditarProductoServlet
 */
//@WebServlet("/EditarProductoServlet")
public class EditarProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarProductoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession();
		String productCode = request.getParameter("productCode");
		
//		&& sesion.getAttribute("usuario")!=null && sesion.getAttribute("role").equals("admin")
		if (!sesion.isNew()) {
			
			if (productCode!=null) {
				
				DAOProductImpl daoProductImpl = new DAOProductImpl();
				
				Product product = daoProductImpl.getProductByCode(productCode);
								
				request.setAttribute("product", product);

				request.getRequestDispatcher("../WEB-INF/view/admin/updateProduct.jsp").forward(request, response);

			} else {
				response.sendRedirect(request.getContextPath() + "/Admin/");
			}
			
		} else {
			
			sesion.invalidate();
			response.sendRedirect(request.getContextPath());
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession();
		
		String productCode = request.getParameter("productCode");
		String productName = request.getParameter("productName");
		String productLine = request.getParameter("productLine");
		String productScale = request.getParameter("productScale");
		String productVendor = request.getParameter("productVendor");
		String productDescription = request.getParameter("productDescription");
		int quantityInStock = Integer.parseInt(request.getParameter("quantityInStock"));
		double buyPrice = Double.parseDouble(request.getParameter("buyPrice"));
		double MSRP = Double.parseDouble(request.getParameter("MSRP"));
		
		request.getRequestDispatcher("../WEB-INF/view/admin/updateProduct.jsp").forward(request, response);
		
		if (productCode!=null && productName!=null && productLine!=null && productScale!=null && productVendor!=null
			&& productDescription!=null && quantityInStock!=0 && buyPrice!=0.0 && MSRP!=0.0) {
			
			Product product = new Product(productCode,productName,productLine,productScale,productVendor,productDescription,quantityInStock,buyPrice,MSRP);
			
			DAOProductImpl daoProductImpl = new DAOProductImpl();
			
			daoProductImpl.updateProduct(product);
			
		} else {
			response.sendRedirect(request.getContextPath() + "/Admin/");
		}
	}

}
