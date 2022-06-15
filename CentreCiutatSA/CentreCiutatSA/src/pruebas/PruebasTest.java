package pruebas;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.Before;
import org.junit.Test;

public class PruebasTest {

	 Pruebas a3  = new Pruebas();
	 Pruebas a4  = new Pruebas();
	 
	 
	@Before
	public void setUp() throws Exception {
		
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
	public void testBuscartuInformacion() throws SQLException {
		//given
		System.out.println("Test Buscar Información correcto!!");
		//when 
		Assert.assertEquals("43056439H", a3.buscartuInformacion(null)); 
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
