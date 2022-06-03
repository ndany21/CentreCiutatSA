






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
	
	
	public void crearUsuario(Connection con) {
		Scanner sc = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        String nombre ="";
        String apellido ="";
        String dni ="";
        String psw ="";
        String direccion ="";
        String cuenta ="";
        String matricula ="";
        String idStacionamiento ="";
           
        
        while(!salir){
        System.out.println("========== CREAR USUARIO ==========");
        System.out.println(" ");
        System.out.println(" Selecciona el tipo de usuario que ");
        System.out.println(" desea crear");
        System.out.println(" ");
        System.out.println(" 1) Administrador");
        System.out.println(" 2) Cliente");
        System.out.println(" 3) salir ");
        System.out.println(" ");
        System.out.println("======================================");
        System.out.println(" ");
        System.out.print("->");
        
        opcion = sc.nextInt();
        sc.nextLine();

        switch(opcion){
            case 1:
                
                System.out.println("");
                System.out.println("======= USUARIO ADMINISTRADOR =======");
                System.out.println(" ");
                System.out.println(" Introduce los datos que se le piden");
                System.out.println(" ");
                System.out.println(" ");
               
                System.out.println("  NOMBRE: ");
                nombre= sc.nextLine();
               
                System.out.println(" ");
                System.out.println(" APELLIDOS:  ");
                apellido= sc.nextLine();
           
                System.out.println(" ");
                System.out.println(" CONTRASEÑA: "); 
                psw= sc.nextLine();
            
                System.out.println(" ");
                System.out.println(" DNI: "); 
                dni= sc.nextLine();
                
                System.out.println(" ");
                System.out.println(" DIRECCÓN: ");
                direccion= sc.nextLine();
             
               	System.out.println(" ");
                System.out.println(" CUENTA CORRIENTE: "); 
                cuenta= sc.nextLine();
              
                System.out.println("");
             	System.out.println("Usuario administrador creado correctamente !!");
             	Statement stmt = null;

        		try {

        			stmt = con.createStatement();
        			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

        			ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios");

        			// Nos posicionamos con el cursor en la próxima fila vacía de la tabla
        			rs.moveToInsertRow();
        			// Actualizamos los campos con los datos pasados por parámetro en la llamada al método
        			rs.updateString("dni", dni);
        			rs.updateString("nombre", nombre);
        			rs.updateString("apellidos", apellido);
        			rs.updateString("direccion", direccion);
        			rs.updateString("cuentaCorriente", cuenta);
        			rs.updateString("matricula", null);
        			rs.updateInt("admin", 1);
        			rs.updateString("idEstacionamiento", null);
        			rs.updateString("contrasena", psw);
        			// Insertamos la nueva fila (nuevo jugador) con los datos proporcionados
        			rs.insertRow();
        			// Nos posicionamos con el cursor antes de la primera fila
        			rs.beforeFirst();

        			System.out.println("");
        			System.out.println("Se ha insertado correctamente el nuevo usuario " + nombre + "!");

        		} catch (SQLException e) {
        			e.printStackTrace();
        		} finally {
        			try {
        				stmt.close();
        			} catch (SQLException e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        			}
        		}
                break;
        case 2:
            
        	System.out.println("");
            System.out.println("======= USUARIO ADMINISTRADOR =======");
            System.out.println(" ");
            System.out.println(" Introduce los datos que se le piden");
            System.out.println(" ");
            System.out.println(" ");
           
            System.out.println("  NOMBRE: ");
            nombre= sc.nextLine();
            
            System.out.println(" ");
            System.out.println(" APELLIDOS:  ");
            apellido= sc.nextLine();
            
            System.out.println(" ");
            System.out.println(" CONTRASEÑA: "); 
            psw= sc.nextLine();
         
            System.out.println(" ");
            System.out.println(" DNI: "); 
            dni= sc.nextLine();
          
            System.out.println(" ");
            System.out.println(" DIRECCÓN: ");
            direccion= sc.nextLine();
          
           	System.out.println(" ");
            System.out.println(" CUENTA CORRIENTE: "); 
            cuenta= sc.nextLine();
        
            System.out.println(" ");
            System.out.println(" MATRICULA: "); 
            matricula= sc.nextLine();
           
            System.out.println("");
         	System.out.println(" ID ESTACIONAMIENTO: "); 
         	System.out.println("");
         	idStacionamiento = sc.nextLine();
         	
         	System.out.println("Usuario cliente creado correctamente !!");
         	Statement stmt2 = null;

    		try {

    			stmt = con.createStatement();
    			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

    			ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios");

    			// Nos posicionamos con el cursor en la próxima fila vacía de la tabla
    			rs.moveToInsertRow();
    			// Actualizamos los campos con los datos pasados por parámetro en la llamada al método
    			rs.updateString("dni", dni);
    			rs.updateString("nombre", nombre);
    			rs.updateString("apellidos", apellido);
    			rs.updateString("direccion", direccion);
    			rs.updateString("cuentaCorriente", cuenta);
    			rs.updateString("matricula", matricula);
    			rs.updateInt("admin", 0);
    			rs.updateString("idEstacionamiento", idStacionamiento);
    			rs.updateString("contrasena", psw);
    			// Insertamos la nueva fila (nuevo jugador) con los datos proporcionados
    			rs.insertRow();
    			// Nos posicionamos con el cursor antes de la primera fila
    			rs.beforeFirst();

    			System.out.println("");
    			System.out.println("Se ha insertado correctamente el nuevo usuario " + nombre + "!");

    		} catch (SQLException e) {
    			e.printStackTrace();
    		} finally {
    			try {
    				stmt2.close();
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		}
            break;  
        
         case 3:                           
            salir=true;
            System.out.println("== SALIENDO DEL PROGRAMA ==");
            System.out.println(" ");
            System.out.println("Gracias por tu colaboración, que tengas un buen dia");
            break;
         default:
            System.out.println("Solo números entre 1 y 3");
            System.out.println(" ");       
           
          }   } 
        
        
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
			System.out.println("2. No");
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
			
			//listado += "**** LISTA DE ALQUILERES ****\n";

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
					
						 "Id: " + idAlquiler +"\n"
						+ "Precio Mensual: " + precioMensual+"\n"
						+ " DNI: " + dni + "\n"
						+ " Matricula: " + matricula + "\n";
				
			}
			if(listado.equals("")) {
				System.out.println("\n\n");
				System.out.println("No hay alquileres");
				}
			else {
				
				String temp = "**** LISTA DE ALQUILERES ****\n";
				temp += listado;
				System.out.println("");
				System.out.println("¿Quieres exportar el listado?");
				System.out.println("         1) Si               ");
				System.out.println("         2) No               ");
				int opcion = teclado.nextInt();
				if(opcion == 1){
					ficherotxt(temp);
				}
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
			 f = new FileOutputStream("listado.txt", true);
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
	public void editarAlquiler(Connection con) throws SQLException {

 		Scanner teclado = new Scanner(System.in);
 		System.out.println("Introduce el Id del Alquiler para editar: ");
 		int id = 0;
 		id = teclado.nextInt();

 		teclado.nextLine(); // evitar errores

 		Statement stmt = null;

 		try {
 			int opcion;			

 			System.out.println("¿Qué deseas editar?");
 			System.out.println("1) Estacionamiento");
 			System.out.println("2) Precio Mensual");
 			System.out.println("3) DNI");
 			System.out.println("4) Matricula");
 			System.out.println("5) Salir");
 			opcion = teclado.nextInt();
 			teclado.nextLine();
 			switch (opcion) {
 			case 1:
 				System.out.print(" Escribe el nuevo estacionamiento: ");
 				String estacionamiento = "";
 				estacionamiento = teclado.nextLine();

 				stmt= con.createStatement();
 				stmt.executeUpdate("UPDATE `alquiler` SET `idEstacionamiento` = '" + estacionamiento +"' WHERE `alquiler`.`idAlquiler` = " + id); 
 				System.out.println("Valor editado correctamente.");
 				System.out.println(" ");
 				break;
 			case 2:
 				System.out.print(" Escribe el nuevo precio mensual: ");
 				int precioMensual= teclado.nextInt();

 				stmt= con.createStatement();
 				stmt.executeUpdate("UPDATE `alquiler` SET `precioMensual` = '" + precioMensual +"' WHERE `alquiler`.`idAlquiler` = " + id);
 				break;
 			case 3:
 				System.out.print(" Escribe el nuevo DNI: ");
 				String dni= teclado.nextLine();

 				stmt= con.createStatement();
 				stmt.executeUpdate("UPDATE `alquiler` SET `dni` = '" + dni +"' WHERE `alquiler`.`idAlquiler` = " + id);
 				break;
 			case 4:
 				System.out.print(" Escribe la nueva matricula: ");
 				String matricula= teclado.nextLine();


 				stmt= con.createStatement();
 				stmt.executeUpdate("UPDATE `alquiler` SET `matricula` = '" + matricula +"' WHERE `alquiler`.`idAlquiler` = " + id);
 				break;
 			case 5:
 				System.out.print("Saliendo...");
 				System.exit(0);


 				break;
 			default:
 				System.out.println("Solo números entre 1 y 5");
 		    	System.out.println(" ");  	
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
	
	//
	
}
