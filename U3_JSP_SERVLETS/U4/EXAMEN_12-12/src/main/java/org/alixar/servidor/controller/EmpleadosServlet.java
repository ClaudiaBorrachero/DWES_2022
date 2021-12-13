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

/**
 * Servlet implementation class MostrarEmpleados
 */
//@WebServlet("/EmpleadosServlet")
public class EmpleadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpleadosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOEmployeesImpl daoImpl = new DAOEmployeesImpl();
//		DAOOfficesImpl daoOff = new DAOOfficesImpl();
		
		ArrayList<EmpleadosServlet> listaEmployees = (ArrayList) daoImpl.getAllEmployees();
		
		request.setAttribute("employee", listaEmployees);
//		request.setAttribute("offices", daoOff.getOffice(request.getParameter("employeeNumber")));
		
		request.getRequestDispatcher("/WEB-INF/view/admin/employees.jsp").forward(request, response);
		
	}

//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
