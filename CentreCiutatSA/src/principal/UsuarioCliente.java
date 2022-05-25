package principal;

import java.sql.*;

import clases.Cliente;

public class UsuarioCliente {

	public static void main(String[] args) {

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/centreciutat", "root", "");
			System.out.println("Conexión establecida con la base de datos ciutat centre");
			Cliente c1 = new Cliente();
			c1.buscartuInformacion(con);
		} catch (SQLException e) {
			System.out.println("Error connexión BBDD");
			e.printStackTrace();
		}

	}

}
