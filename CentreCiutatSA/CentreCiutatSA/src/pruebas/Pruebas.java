package pruebas;

import java.sql.*;
import java.io.*;
import java.util.*;


public class Pruebas {
		
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
	
	public String buscartuInformacion(Connection con) throws SQLException{
		String dni;
		
		Statement stmt = null;

		Scanner teclado = new Scanner(System.in);
		
		System.out.println(" Introduce tu DNI: ");
		dni = teclado.nextLine();

		String query = "SELECT dni, nombre, apellidos, direccion, cuentaCorriente from usuarios where dni = " + "'"
				+ dni + "'";
		

		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			String nombre = "";

			while (rs.next()) {
				System.out.println(" ");
				System.out.println(" ");
				System.out.println("======================================");
				System.out.println("======================================");
				System.out.println("");
				System.out.println(" == USUARIO CLIENTE == ");
				System.out.println("\n Nombre: " + rs.getString("nombre"));
				System.out.println("\n Apellido: " + rs.getString("apellidos"));
				System.out.println("\n DNI: " + rs.getString("dni"));
				System.out.println("\n Dirección " + rs.getString("direccion"));
				System.out.println("\n Cuenta Corriente: " + rs.getString("cuentaCorriente"));
				System.out.println("");
				System.out.println("======================================");
				System.out.println("======================================");
				System.out.println("");
				System.out.println(" ");
				nombre= rs.getString("nombre");
				
			}
			if(nombre.equals("")) {
				System.out.println("\n\n");
				System.err.println("Este DNI no está en la base de datos.");
				System.out.println(" ");
				}
			
		} catch (SQLException e) {
			e.getStackTrace();
		} finally {
			stmt.close();
		}
		//return nombre;
		return dni;
	}

	public void buscartuVehiculo(Connection con) throws SQLException {
		String matricula;
		Statement stmt = null;
		Statement stmt2 = null;

		Scanner teclado = new Scanner(System.in);
		System.out.println(" Introduce la matricula: ");
		matricula = teclado.nextLine();

		String query = "SELECT matricula, marca, modelo, TipoVehiculo from vehiculos where matricula = " + "'"
				+ matricula + "'";

		String query2 = "SELECT idEstacionamiento from usuarios where matricula = " + "'" + matricula + "'";
		String idEstacionamiento ="";
		try {
			stmt = con.createStatement();
			stmt2 = con.createStatement();
			
			
			ResultSet rs = stmt.executeQuery(query);
			ResultSet rs2 = stmt2.executeQuery(query2);
			
			
			while (rs2.next()) {
				System.out.println(" ");
				System.out.println("======================================");
				System.out.println("======================================");
				System.out.println(" == VEHICULO DEL CLIENTE == ");
				System.out.println("\n Número de estacionamiento: " + rs2.getString("idEstacionamiento"));
				idEstacionamiento = rs2.getString("idEstacionamiento");
			

				while (rs.next()) {

					System.out.println("\n Marca: " + rs.getString("marca"));
					System.out.println("\n Modelo: " + rs.getString("modelo"));
					System.out.println("\n Tipo de vehículo: " + rs.getString("TipoVehiculo"));
					System.out.println("======================================");
					System.out.println("======================================");
					
				}
				
			}
			
			if(idEstacionamiento.equals("")) {
				System.out.println("\n\n");
				System.err.println("Esta matricula no está en la base de datos.");
				System.out.println(" ");
				}

		} catch (SQLException e) {
			e.getStackTrace();
		} finally {
			stmt.close();
		}
	}
	
}
