package org.alixar.servidor.cnbm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.alixar.servidor.cnbm.dao.DAOPaymentsImpl;
import org.alixar.servidor.cnbm.model.Payments;

/**
 * Servlet implementation class Actualizar
 */

public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String checkNumber = request.getParameter("checkNumber");
		int customerNumber = Integer.parseInt(request.getParameter("customerNumber"));
		
		DAOPaymentsImpl daoImpl = new DAOPaymentsImpl();
		
		Payments payment = daoImpl.getPayments(customerNumber, checkNumber);
		
		request.setAttribute("pago", payment);
		
		request.getRequestDispatcher("WEB-INF/view/update.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String checkNumber = request.getParameter("checkNumber");
		int customerNumber = Integer.parseInt(request.getParameter("customerNumber"));
		String date = request.getParameter("paymentDate");
		Double amount = Double.parseDouble(request.getParameter("amount"));
		
		if (checkNumber!=null && customerNumber!=0 && date!=null && amount!=0) {
			
			Payments payment = new Payments(customerNumber,checkNumber,date,amount);
			DAOPaymentsImpl daoImpl = new DAOPaymentsImpl();
			daoImpl.updatePayments(payment);
			
		}
		response.sendRedirect(request.getContextPath());
	}

}
