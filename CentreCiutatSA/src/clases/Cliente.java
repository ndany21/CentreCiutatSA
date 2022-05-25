package clases;

import java.sql.*;
import java.util.Scanner;

public class Cliente extends Persona {

	// Atributos
	private String usuario, contrasena;

	// Constructor
	public Cliente(String nombre, String apellidos, String dni, String direccion, int cuentaCorriente, String usuario,
			String contrasena) {
		super(nombre, apellidos, dni, direccion, cuentaCorriente);
		this.usuario = usuario;
		this.contrasena = contrasena;
	}

	public Cliente() {
		
	}

	// Getters & Setters
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

	public void buscartuInformacion(Connection con) throws SQLException {

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

			while (rs.next()) {
				System.out.println(" ");
				System.out.println("======================================");
				System.out.println("======================================");
				System.out.println(" == USUARIO CLIENTE == ");
				System.out.println("\n Nombre: " + rs.getString("nombre"));
				System.out.println("\n Apellido: " + rs.getString("apellidos"));
				System.out.println("\n DNI: " + rs.getString("dni"));
				System.out.println("\n Dirección " + rs.getString("direccion"));
				System.out.println("\n Cuenta Corriente: " + rs.getString("cuentaCorriente"));
				System.out.println("======================================");
				System.out.println("======================================");
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			stmt.close();
		}

	}

}
