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
 * Servlet implementation class UpdatePayment
 */
//@WebServlet("/UpdatePayment")
public class UpdatePayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePayment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String customerNumber = request.getParameter("cn");
		String checkNumber = request.getParameter("checkn");
		
		if (customerNumber!=null && checkNumber!=null) {
			
			DAOPaymentsImpl daoPaymentImpl = new DAOPaymentsImpl();
			DAOCustomersImpl daoCustomerImpl = new DAOCustomersImpl();
			
			Payments payment = daoPaymentImpl.getPayment(Integer.parseInt(customerNumber), checkNumber); 
			
			ArrayList<Customers> customers = daoCustomerImpl.getAllCustomers();
			
			request.setAttribute("pago", payment);
			request.setAttribute("customers", customers);
			
			
			request.getRequestDispatcher("/WEB-INF/view/admin/updatePayment.jsp").forward(request, response);
			
		} else {
			response.sendRedirect("/AdminMainServlet/Payments");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int customerNumber = Integer.parseInt(request.getParameter("cn"));
		String checkNumber = request.getParameter("checkn");
		String paymentDate = request.getParameter("paymentDate");
		Double amount = Double.parseDouble(request.getParameter("amount"));
		
		if (customerNumber!=0 && checkNumber!=null && paymentDate!=null && amount!=0.0) {
			
			Payments payment = new Payments(customerNumber, checkNumber, paymentDate, amount);
			
			DAOPaymentsImpl daoPaymentImpl = new DAOPaymentsImpl();
			
			daoPaymentImpl.updatePayment(payment);
			
		}
		
		response.sendRedirect(request.getContextPath() + "/AdminMainServlet/Payments");
		
	}

}
