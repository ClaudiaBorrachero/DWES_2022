package org.alixar.servidor.controller;

import java.io.IOException;


import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.alixar.servidor.dao.DAOEmployeesImpl;
import org.alixar.servidor.dao.DAOOfficesImpl;
import org.alixar.servidor.model.Employees;

/**
 * Servlet implementation class EmployeeServlet
 */

public class EmployeeOffice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeOffice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		DAOEmployeesImpl daoImpl = new DAOEmployeesImpl();
		DAOOfficesImpl daoOff = new DAOOfficesImpl();
		
		ArrayList<Employees> listaEmployees = (ArrayList) daoImpl.getEmployeesSearch(request.getParameter("en"));
		
		request.setAttribute("employees", listaEmployees);
		
		request.setAttribute("oficina", daoOff.getOffice(request.getParameter("en")));
		
		request.getRequestDispatcher("/WEB-INF/view/admin/employeeOffice.jsp").forward(request, response);;
		
	}

}
