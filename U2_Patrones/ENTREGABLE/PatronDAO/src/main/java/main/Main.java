package main;

import bd.ConexionBD;
import dao.PaymentsDAO;

public class Main {

	public static void main(String[] args) {

		System.out.println("-----------------------------");
		System.out.println("LISTA DE CUSTOMERNUMBER");
		System.out.println(PaymentsDAO.getPayments());
		System.out.println("-----------------------------");
		
		ConexionBD.close();
	}

}
