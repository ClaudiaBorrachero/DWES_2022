package org.alixar.servidor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.alixar.servidor.dao.DAOEmployeesImpl;
import org.alixar.servidor.model.Employees;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Servlet implementation class AddEmpleadoServlet
 */
//@WebServlet("/AddEmpleadoServlet")
public class AddEmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(AddEmpleadoServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmpleadoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/view/admin/addEmployee.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int employeeNumber = Integer.parseInt(request.getParameter("employeeNumber"));
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String extension = request.getParameter("extension");
		String email = request.getParameter("email");
		String officeCode = request.getParameter("officeCode");
		int reportsTo = Integer.parseInt(request.getParameter("reportsTo"));
		String jobTitle = request.getParameter("jobTitle");
		
		DAOEmployeesImpl dao = new DAOEmployeesImpl();
		
		if (employeeNumber!=0 && lastName!=null && firstName!=null && extension!=null
			&& email!=null && jobTitle!=null && officeCode!=null && reportsTo!=0) {
			
			if (dao.getEmployee(employeeNumber)!=null) {
				
				request.setAttribute("errorEmpleado", "Empleado ya existente");
				doGet(request, response);
				
			} else {
				Employees employee = new Employees(employeeNumber,lastName,firstName,extension,email,officeCode,reportsTo,jobTitle);
				dao.addEmployee(employee);
				response.sendRedirect(request.getContextPath() + "/Admin/Empleados");
				
				logger.log(Level.INFO, "Registro realizado con éxito");
			}
		} else {
			request.setAttribute("error", "Registro inválido");
			logger.log(Level.INFO, "Credenciales erroneas");
			doGet(request,response);
			return;
		}
		
	}

}
