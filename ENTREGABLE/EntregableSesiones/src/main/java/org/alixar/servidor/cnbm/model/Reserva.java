package org.alixar.servidor.cnbm.model;

import java.io.Serializable;

public class Reserva implements Serializable{
		private String fechaInicio, fechaFin, servicios;
		private int numPersonas;
		
		public Reserva() {
			
		}

		public String getFechaInicio() {
			return fechaInicio;
		}


		public void setFechaInicio(String fechaInicio) {
			this.fechaInicio = fechaInicio;
		}


		public String getFechaFin() {
			return fechaFin;
		}


		public void setFechaFin(String fechaFin) {
			this.fechaFin = fechaFin;
		}


		public String getServicios() {
			return servicios;
		}


		public void setServicios(String servicios) {
			this.servicios = servicios;
		}


		public int getNumPersonas() {
			return numPersonas;
		}


		public void setNumPersonas(int numPersonas) {
			this.numPersonas = numPersonas;
		}
	
}
