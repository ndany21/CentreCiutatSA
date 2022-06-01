package clases;


import java.util.Scanner;
import java.sql.*;
import java.io.*;
import java.util.*;

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

public Administrador() {
		
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
	public void listarAlquiler(Connection con) throws SQLException {
		Scanner teclado = new Scanner(System.in);
		Statement stmt = null;
		String query = "select idAlquiler, idEstacionamiento, precioMensual, dni, matricula from alquiler";

		try {

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			String listado = "";

			System.out.println("");
			System.out.println("**** LISTA DE ALQUILERES ****");
			listado += "**** LISTA DE ALQUILERES ****\n";

			while (rs.next()) {

				System.out.println("");
				System.out.println("*************************************");

				String idAlquiler = rs.getString("idAlquiler");
				System.out.println("Id: " + idAlquiler);
				

				String idEstacionamiento = rs.getString("idEstacionamiento");
				System.out.println("Id Estacionamiento: " + idEstacionamiento);

				String precioMensual = rs.getString("precioMensual");
				System.out.println("Precio Mensual: " + precioMensual);
				
				String dni = rs.getString("dni");
				System.out.println(" DNI: " + dni);

				String matricula = rs.getString("matricula");
				System.out.println(" Matricula: " + matricula);

				System.out.println("*************************************");
				listado +=  
						 "\n"
						+ "*****************************\n"
						+ "Id: " + idAlquiler +"\n"
						+ "Precio Mensual: " + precioMensual+"\n"
						+ " DNI: " + dni + "\n"
						+ " Matricula: " + matricula + "\n";
				
			}
			System.out.println("");
			System.out.println("¿Quieres exportar el listado?");
			System.out.println("         1) Si               ");
			System.out.println("         2) No               ");
			int opcion = teclado.nextInt();
			if(opcion == 1){
				ficherotxt(listado);
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
		}

	}
	
	public void ficherotxt(String listado) {
		FileOutputStream f = null;
		try {
			 f = new FileOutputStream("listado3.txt", true);
			for (int i = 0; i < listado.length(); i++) {
				char c = listado.charAt(i);
				f.write((byte) c);
			}
			System.out.println("Listado exportado correctamente.");
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally {
			try {
				f.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	//
	
}
