package clases;

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
	
	public void eliminarAlquiler() {
		
	}
	
	public void listarAlquiler() {
		
	}
	
	
	//
	
}
