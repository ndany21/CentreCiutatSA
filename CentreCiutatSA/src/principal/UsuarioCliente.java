package principal;

import java.sql.*;
import java.util.Scanner;

import clases.Cliente;

public class UsuarioCliente {

	public static void main(String[] args) {

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/centreciutat", "root", "");
			System.out.println("Conexión establecida con la base de datos CentreCiutat S.A.");
			
			
			Cliente c1 = new Cliente();
			Scanner sc = new Scanner(System.in);
			Statement stmt = null;
			
			boolean salir = false;
			int opcion;
			
			
			System.out.println(" ");
		  	System.out.println("======================================");
		  	System.out.println("========| Centre Ciutat S.A. |========");
		  	System.out.println("======================================");
		  	System.out.println(" ");
		  	System.out.println(" ");
		  	System.out.println("==        Cual es su nombre?        ==");
		  	System.out.println(" ");
		  	String nombre = sc.nextLine();
		  	System.out.println(" ");
		  	System.out.println("==            Contraseña             ==");
		  	System.out.println(" ");
		  	String contraseña = sc.nextLine();
		  	System.out.println(" ");
		  	System.out.println(" ");
		  	System.out.println(" ");
		  	System.out.println(" ");
			
		  	String query = "SELECT nombre, contraseña, admin from usuarios where usuario = " + "'"
					+ nombre + "'";
		  	
			
			//SQL que recoga los datos y poner el nombre del usuario 
		  	
		  	System.out.println("          Bienvenido  " + nombre);
		  	System.out.println(" ");
		  	
			
		  	 
			while(!salir){
			System.out.println("========== QUE DESEA HACER? ==========");
			System.out.println(" ");
		    System.out.println("(Seleccione la opción que desee con ");
			System.out.println("las teclas * 1 - 2 o 3* )");
			System.out.println(" ");
			System.out.println(" 1) Mostrar información de su vehiculo");
			System.out.println(" 2) Mostrar su información personal");
			System.out.println(" 3) Salir de la aplicación ");
			System.out.println(" ");
			System.out.println("======================================");
			System.out.println(" ");
			opcion = sc.nextInt();

			switch(opcion){
		    	case 1:
		    	
		    		//CONTECTAR CON BASE DE DATOS Y MOSTRAR POR PANTALLA INFORMACIÓN DEL VEHÍCULO DEL CLIENTE
		    		c1.buscartuVehiculo(con);
		    	break;
			case 2:
				
					//CONTECTAR CON BASE DE DATOS Y MOSTRAR POR PANTALLA INFORMACIÓN DEL CLIENTE 
				
				c1.buscartuInformacion(con);
				
		    	break;       	
		 	case 3:                      	 
		    	salir=true;
		    	System.out.println("== SALIENDO DEL PROGRAMA ==");
		    	System.out.println(" ");
		    	System.out.println("Gracias por tu colaboración " +nombre+ ", que tengas un buen dia");
		    	System.exit(0);
		    	break;
		 	default:
		    	System.out.println("Solo números entre 1 y 3");
		    	System.out.println(" ");  	 
		  	 
		  	}	 
			} 
			
			
		} catch (SQLException e) {
			System.out.println("Error connexión BBDD");
			e.printStackTrace();
		}

	
	
	
		    }
	}	 


