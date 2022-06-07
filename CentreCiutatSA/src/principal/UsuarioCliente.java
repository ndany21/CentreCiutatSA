package principal;

import java.sql.*;
import java.util.Scanner;

import clases.*;;

public class UsuarioCliente {

	public static void main(String[] args) {

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/centreciutat", "root", "");
			System.out.println("Conexión establecida con la base de datos CentreCiutat S.A.");

			

			Scanner sc = new Scanner(System.in);

			int opcion;

			login(con, sc);

		} catch (SQLException e) {
			System.out.println("Error connexión BBDD");
			e.printStackTrace();
		}

		
	}

	public static void login(Connection con, Scanner sc) throws SQLException {
		
		Cliente c1 = new Cliente();
		Administrador a1 = new Administrador();
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("======================================");
		System.out.println("========| Centre Ciutat S.A. |========");
		System.out.println("======================================");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("==        Cual es su nombre?        ==");
		System.out.println(" ");
		System.out.print("Introduce tu nombre: ");
		String nombreIntroducido = sc.nextLine();
		System.out.println(" ");
		System.out.println("==            Contraseña             ==");
		System.out.println(" ");
		System.out.print("Introduce tu contraseña: ");
		String contrasenaIntroducida = sc.nextLine();

		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");

		Statement stmt = null;

		// String query = "SELECT nombre, apellidos, admin, contrasena from usuarios
		// where nombre = " + "'" + nombreIntroducido + "'";

		String query = "SELECT nombre, apellidos,admin, contrasena FROM `usuarios` WHERE nombre = '" + nombreIntroducido
				+ "'";

		try {

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			String nombreUsuario = "";
			String apellidosUsuario = "";
			String esAdmin = "";
			String contrasena = "";

			if (rs.next() == false) {
				System.out.println("No se encuentra en la base de datos  ");
				login(con, sc);

			} else {

				nombreUsuario = rs.getString("nombre");
				esAdmin = rs.getString("admin");
				apellidosUsuario = rs.getString("apellidos");
				contrasena = rs.getString("contrasena");

				if (nombreUsuario.equals(nombreIntroducido) && contrasena.equals(contrasenaIntroducida)
						&& esAdmin.equals("0")) {
					menuCliente(con, c1, sc, nombreIntroducido, nombreUsuario, apellidosUsuario);

				} else if (nombreUsuario.equals(nombreIntroducido) && contrasena.equals(contrasenaIntroducida) && esAdmin.equals("1")) {

					menuAdmin(con, a1, sc);
				} else {
					System.out.println("No se encuentra en la base de datos");
					login(con, sc);
				}

			}

		} catch (Exception e) {
			System.out.println("ERROR! No se encuentra en la base de datos");
			e.getMessage();
		} finally {
			stmt.close();
		}
	}

	public static void menuAdmin(Connection con, Administrador a1, Scanner sc) throws SQLException {
		int opcion;

		System.out.println("========== Bienvenid@  ==========");
		System.out.println(" ");
		System.out.println("(Seleccione la opción que desee con ");
		System.out.println("las teclas * 1 - 2 - 3 - 4 o 5* )");
		System.out.println(" ");
		System.out.println(" 1) Listar alquileres");
		System.out.println(" 2) Editar alquileres");
		System.out.println(" 3) Eliminar alquileres ");
		System.out.println(" 4) Crear nuevo usuario ");
		System.out.println(" 5) Cerrar sesión ");
		System.out.println(" ");
		System.out.println("======================================");
		System.out.println(" ");
		opcion = sc.nextInt();
		sc.nextLine();

		switch (opcion) {
		case 1:

			// CONTECTAR CON BASE DE DATOS Y MOSTRAR POR PATNALLA LISTADO DE ALQUILERES
			a1.listarAlquiler(con);
			menuAdmin(con, a1, sc);

			break;
		case 2:
			a1.editarAlquiler(con);

			// CONTECTAR CON BASE DE DATOS PARA EDITAR ALQUILERES
			menuAdmin(con, a1, sc);

			break;
		case 3:
			a1.eliminarAlquiler(con);
			menuAdmin(con, a1, sc);
			// CONTECTAR CON BASE DE DATOS PARA ELIMINAR ALQUILERES

			break;
		case 4:
			a1.crearUsuario(con);
			menuAdmin(con, a1, sc);
			// CONTECTAR CON BASE DE DATOS PARA CREAR USUARIO

			break;
		case 5:
			System.out.println("CERRANDO SESIÓN...");
			System.out.println("");
			login(con, sc);

			break;
		default:
			System.out.println("Solo números entre 1 y 5");
			System.out.println(" ");
			menuAdmin(con, a1, sc);

		}

	}

	public static void menuCliente(Connection con, Cliente c1, Scanner sc, String nombreIntroducido,
			String nombreUsuario, String apellidosUsuario) throws SQLException {
		int opcion;
		// SQL que recoga los datos y poner el nombre del usuario

		System.out.println("Bienvenido " + nombreUsuario + " " + apellidosUsuario);
		System.out.println(" ");

		System.out.println("========== QUE DESEA HACER? ==========");
		System.out.println(" ");
		System.out.println("(Seleccione la opción que desee con ");
		System.out.println("las teclas * 1 - 2 o 3* )");
		System.out.println(" ");
		System.out.println(" 1) Mostrar información de su vehiculo");
		System.out.println(" 2) Mostrar su información personal");
		System.out.println(" 3) Cerrar sesión ");
		System.out.println(" ");
		System.out.println("======================================");
		
		System.out.println(" ");
		opcion = sc.nextInt();
		sc.nextLine();

		switch (opcion) {
		case 1:
			c1.buscartuVehiculo(con);
			menuCliente(con, c1, sc, nombreIntroducido, nombreUsuario, apellidosUsuario);
			// CONTECTAR CON BASE DE DATOS Y MOSTRAR POR PANTALLA INFORMACIÓN DEL VEHÍCULO
			// DEL CLIENTE

			break;
		case 2:

			// CONTECTAR CON BASE DE DATOS Y MOSTRAR POR PANTALLA INFORMACIÓN DEL CLIENTE

			c1.buscartuInformacion(con);
			menuCliente(con, c1, sc, nombreIntroducido, nombreUsuario, apellidosUsuario);

			break;
		case 3:

			System.out.println("CERRANDO SESIÓN...");
			System.out.println("");
			System.out.println("Gracias por tu colaboración " + nombreIntroducido + ", que tengas un buen dia");
			System.out.println("");
			login(con, sc);
			break;
		default:
			System.out.println("Solo números entre 1 y 3");
			System.out.println(" ");
			menuCliente(con, c1, sc, nombreIntroducido, nombreUsuario, apellidosUsuario);

		}

	}
}
