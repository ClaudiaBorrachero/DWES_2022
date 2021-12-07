package org.alixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.alixar.servidor.dao.DAOCustomersImpl;
import org.alixar.servidor.dao.DAOPaymentsImpl;
import org.alixar.servidor.model.Customers;
import org.alixar.servidor.model.Payments;

/**
 * Servlet implementation class DeletePayment
 */
//@WebServlet("/DeletePayment")
public class DeletePayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePayment() {
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
			
			daoPaymentImpl.removePayment(Integer.parseInt(customerNumber), checkNumber);
			
		}
		response.sendRedirect(request.getContextPath() + "/AdminMainServlet/Payments");
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
