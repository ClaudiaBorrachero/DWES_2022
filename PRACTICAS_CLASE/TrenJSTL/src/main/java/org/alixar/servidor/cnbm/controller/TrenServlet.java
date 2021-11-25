package org.alixar.servidor.cnbm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.alixar.servidor.cnbm.model.Maquinista;
import org.alixar.servidor.cnbm.model.Tren;
import org.alixar.servidor.cnbm.model.Vagon;

/**
 * Servlet implementation class TrenServlet
 */
@WebServlet("/TrenServlet")
public class TrenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Maquinista maquinista = new Maquinista("Pepe","Mallofret","12345678C");
		ArrayList<Vagon> vagones = new ArrayList<>();
		Vagon v1 = new Vagon(1000,5000);
		Vagon v2 = new Vagon(1500,5500);
		Vagon v3 = new Vagon(2000,6000);
		
		vagones.add(v1);
		vagones.add(v2);
		vagones.add(v3);
		
		Tren tren = new Tren("AVE",maquinista,vagones);
		
		request.setAttribute("tren", tren);
		
		request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
		
		
	}

}
