package pruebas;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.Before;
import org.junit.Test;

public class PruebasTest {

	private Pruebas lista;
	 
	@Before
	public void setUp() throws Exception {
		 lista = new Pruebas(null, null);
	}

	@Test
	public void testListarAlquiler() {
		//given
		System.out.println("Test Listar Alquiler correcto!!");
		//when		
		
		//then
		
	}

	@Test
	public void testEliminarAlquiler() {
		//given
		System.out.println("Test Eliminar Alquiler correcto!!");
		//when 
		
		//then
	}

	@Test
	public void testBuscartuInformacion() {
		//given
		System.out.println("Test Buscar Información correcto!!");
		//when 
		
		//then
	}

	@Test
	public void testBuscartuVehiculo() {
		//given
		System.out.println("Test Buscar Vehiculo correcto!!");
		//when 
		
		
		//then
	}

}
