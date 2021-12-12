package org.alixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.alixar.servidor.dao.DAOCustomersImpl;
import org.alixar.servidor.dao.DAOPaymentsImpl;
import org.alixar.servidor.model.Customers;
import org.alixar.servidor.model.Payments;

/**
 * Servlet implementation class AddPayment
 */
//@WebServlet("/AddPayment")
public class AddPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPayment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOCustomersImpl daoImpl = new DAOCustomersImpl();
		ArrayList<Customers> customers = daoImpl.getAllCustomers();
		
		request.setAttribute("customers", customers);
		
		request.getRequestDispatcher("/WEB-INF/view/admin/addPayment.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String customerNumber = request.getParameter("customerNumber");
		String checkNumber = request.getParameter("checkNumber");
		String paymentDate = request.getParameter("paymentDate");
		Double amount = Double.parseDouble(request.getParameter("amount"));
		
		if (customerNumber!=null && checkNumber!=null && paymentDate!=null && amount!=0.0) {
			
			Payments payment = new Payments(Integer.parseInt(customerNumber), checkNumber, paymentDate, amount);
			
			DAOPaymentsImpl daoPaymentImpl = new DAOPaymentsImpl();
			daoPaymentImpl.addPayment(payment);
			
		} 
		
		response.sendRedirect(request.getContextPath() + "/AdminMainServlet/Payments");
		
	}

}
