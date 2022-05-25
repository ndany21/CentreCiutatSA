package clases;

public class Vehiculos {
	
	//Atributos
	private String marca, modelo, color, motor, matricula, tipoVehiculo;

	//Constructor
	public Vehiculos(String marca, String modelo, String color, String motor, String matricula, String tipoVehiculo) {
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.motor = motor;
		this.matricula = matricula;
		this.tipoVehiculo = tipoVehiculo;
	}

	//Getters & Setters
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	
	
	
}
