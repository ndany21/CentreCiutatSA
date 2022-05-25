package clases;

public abstract class Persona {

	//Atributos
	
	private String nombre, apellidos, dni, direccion;
	private int cuentaCorriente;
	
	//Constructor
	public Persona(String nombre, String apellidos, String dni, String direccion, int cuentaCorriente) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.direccion = direccion;
		this.cuentaCorriente = cuentaCorriente;
	}
	
	public Persona() {
		
	}

	//Getters & Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCuentaCorriente() {
		return cuentaCorriente;
	}

	public void setCuentaCorriente(int cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
	}
	
	
	
}
