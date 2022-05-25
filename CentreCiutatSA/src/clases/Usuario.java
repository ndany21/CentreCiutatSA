package clases;

import java.util.Scanner;

public class Usuario {

	// Atributos
	private String nombre;
	private String apellidos;
	private String DNI;
	private String direccion;
	private String CuentaCorriente;

	// Constructores
	public Usuario(String nombre, String apellidos, String dNI, String direccion, String cuentaCorriente) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		DNI = dNI;
		this.direccion = direccion;
		CuentaCorriente = cuentaCorriente;
	}

	// Getters & Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCuentaCorriente() {
		return CuentaCorriente;
	}

	public void setCuentaCorriente(String cuentaCorriente) {
		CuentaCorriente = cuentaCorriente;
	}

	public static void BuscarTuVehiculo() {
		Scanner teclado = new Scanner (System.in);
		System.out.println(" Introduce la matricula: ");
	}
	
	
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellidos=" + apellidos + ", DNI=" + DNI + ", direccion=" + direccion
				+ ", CuentaCorriente=" + CuentaCorriente + "]";
	}

}
