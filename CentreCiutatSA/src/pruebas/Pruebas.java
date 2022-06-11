package pruebas;

import java.sql.*;
import java.io.*;
import java.util.*;
import clases.Administrador;
import clases.Cliente;

public class Pruebas {
		
		
	//ATRIBUTOS
	private Administrador admin;
	private Cliente client;
	
	//CONSTRUCTOR
	public Pruebas(Administrador admin, Cliente client) {
		super();
		this.admin = admin;
		this.client = client;
	}

	//GETTERS AND SETTERS
	public Administrador getAdmin() {
		return admin;
	}


	public void setAdmin(Administrador admin) {
		this.admin = admin;
	}


	public Cliente getClient() {
		return client;
	}


	public void setClient(Cliente client) {
		this.client = client;
	}
	
	//METODOS TESTEO
	public String listarAlquiler(Connection con) throws SQLException {
		
	
		Statement stmt = null;
		String query = "select * from alquiler";


			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			String listado = "";

			
			System.out.println("");
			System.out.println("**** LISTA DE ALQUILERES ****");
			
			//listado += "**** LISTA DE ALQUILERES ****\n";

			while (rs.next()) {

				System.out.println("");
				System.out.println("*************************************");

				String idAlquiler = rs.getString("idAlquiler");
				System.out.println(" ID: " + idAlquiler);
				

				String idEstacionamiento = rs.getString("idEstacionamiento");
				System.out.println(" ID Estacionamiento: " + idEstacionamiento);

				String precioMensual = rs.getString("precioMensual");
				System.out.println(" Precio Mensual: " + precioMensual);
				
				String dni = rs.getString("dni");
				System.out.println(" DNI: " + dni);

				String matricula = rs.getString("matricula");
				System.out.println(" Matricula: " + matricula);

				System.out.println("*************************************");
		
			}
			return listado;
	
	}
	
	public void eliminarAlquiler() {
		
	}
	
	public void buscartuInformacion(){
		
	}	
	
	public void buscartuVehiculo() {
		
	}
	
}
