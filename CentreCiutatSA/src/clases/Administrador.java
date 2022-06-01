package clases;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Administrador extends Persona{

	//Atributos
	private String usuario, contrasena;
	
	//Constructor
	public Administrador(String nombre, String apellidos, String dni, String direccion, int cuentaCorriente,
			String usuario, String contrasena) {
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
	
	public void alquilarParking() {
		
	}
	
	public void editarAlquiler() {
			
	}
	
	public void eliminarAlquiler(Connection con) {

		Statement stmt = null;
	
		try {
			String idAlq;
			int opcion;
			
			
			

			Scanner teclado = new Scanner(System.in);
			System.out.print(" Introduce el ID del Alquiler que deseas borrar: ");
			idAlq= teclado.nextLine();

			System.out.println("Estas seguro que lo quieres eliminar?");
			System.out.println(" ");
			System.out.println(" ");
			
			System.out.println("1. Si");
			System.out.println("1. No");
			System.out.print("Opción:");
			opcion= teclado.nextInt();
			
			switch (opcion) {
			case 1:
				stmt= con.createStatement();
				stmt.executeUpdate("Delete from  alquiler  "+" where idAlquiler = "+idAlq);
				break;
			case 2:
				
				break;
			default:
				System.out.println("Elige una opción correcta");
				break;
			}
			
			
			
			
		} catch (SQLException e) { 

		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
}	
	public void listarAlquiler() {
		
	}
	
	
	//
	
}
