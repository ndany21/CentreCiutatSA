package clases;

import java.util.Scanner;

public class Cliente extends Persona {

	//Atributos
	private String usuario, contrasena;

	//Constructor
	public Cliente(String nombre, String apellidos, String dni, String direccion, int cuentaCorriente, String usuario,
			String contrasena) {
		super(nombre, apellidos, dni, direccion, cuentaCorriente);
		this.usuario = usuario;
		this.contrasena = contrasena;
	}

	//Getters & Setters
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	// Métodos
	public void buscarVehiculos() {
		
	}
	
	public void buscarInformacion() {
		boolean salir = false;

		while (!salir) {
			Scanner teclado = new Scanner(System.in);
			System.out.println(" Introduce tu DNI: ");
			String dni = teclado.nextLine();
			System.out.println(" ");
			System.out.println("======================================");
			System.out.println("======================================");
			System.out.println(" == USUARIO CLIENTE == ");
			System.out.println("\n Nombre: " + this.getNombre());
			System.out.println("\n Apellido: " + this.getApellidos());
			System.out.println("\n DNI: " + this.getDni());
			System.out.println("\n Dirección " + this.getDireccion());
			System.out.println("\n Cuenta Corriente: " + this.getCuentaCorriente());
			System.out.println("======================================");
			System.out.println("======================================");
		}
		
	} 
	
	
	
}
