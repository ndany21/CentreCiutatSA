package clases;

public class Parking {
	
	//Atributos
	private int id_parking, capacidad;
	private double precioMensual;
	
	//Constructor
	public Parking(int id_parking, int capacidad, double precioMensual) {
		this.id_parking = id_parking;
		this.capacidad = capacidad;
		this.precioMensual = precioMensual;
	}
	
	//Getters & Setters
	public int getId_parking() {
		return id_parking;
	}
	public void setId_parking(int id_parking) {
		this.id_parking = id_parking;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public double getPrecioMensual() {
		return precioMensual;
	}
	public void setPrecioMensual(double precioMensual) {
		this.precioMensual = precioMensual;
	}
	//
	
	
	
}
