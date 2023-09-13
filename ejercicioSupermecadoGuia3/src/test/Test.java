package test;

import java.time.LocalDate;
import java.time.LocalTime;

import model.Carrito;
import model.Cliente;
import model.Producto;
import model.Supermercado;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cliente cl=new Cliente(1,"Alejo Brites", 44182530, "Dean funes 1320");
		Supermercado s= new Supermercado();
		Carrito carrito= new Carrito(1, LocalDate.now(), LocalTime.now(),cl);
		
		
		System.out.println("TEST 1 (Agregar Productos)");
		System.out.println("supermercado-Lista producto:");
		try {
			s.agregarProducto("azucar", 1051.11F);
			//s.agregarProducto("azucar", 1051.11F);
			s.agregarProducto("yerba", 840.4F);
			s.agregarProducto("cafe", 755.56F);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(s.getProductos());
		
		System.out.println("TEST 2 (Traer producto por id)");
		System.out.println(s.traerProducto(3));
		
		System.out.println("TEST 3 (modificar producto)");
		try {
			s.modificarProducto(3, "vino", 42321.18F);
			//s.modificarProducto(7, "vino", 42321.18F);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(s.getProductos());
		
		System.out.println("TEST 4 (eliminar producto)");
		try {
			s.eliminarProducto(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(s.getProductos());
		
		System.out.println(" \n Carrito-Lista item:");
		System.out.println("TEST 5 (agregar item al carrito)");
		
		carrito.agregarItem(new Producto(1,"coca cola", 533), 2);
		carrito.agregarItem(new Producto(1,"coca cola", 533), 2);
		carrito.agregarItem(new Producto(2,"yerba",840.4F), 2);
		System.out.println(carrito);
		
		System.out.println("TEST 6 (eliminar item)");
		try {
			carrito.eliminarItem(new Producto(2,"yerba",840.4F), 1);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(carrito);
		
		System.out.println("TEST 7 (calcular sub total)");
		
		System.out.println("El subtotal es de: "+ carrito.calcularSubTotal());
		
		System.out.println("NVEL 2 CARRITO");
	
		System.out.println("\n supermercado-Lista cliente:");
		System.out.println("TEST 8 (agregar cliente)");
		try {
			s.agregarCliente("Alejo Brites", 44182530,"Dean funes 1320");
			s.agregarCliente("Juan Brites", 20182530,"Dean funes 1320");
			s.agregarCliente("Leo Messi", 20221987,"Lusail 2022");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(s.getCli());
		
		System.out.println("TEST 9 (traer cliente)");
		
		System.out.println(s.traerClienteXid(1));
		
		System.out.println("TEST 10 (eliminar cliente)");
		try {
			s.eliminarCliente(1);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(s.getCli());
		
		System.out.println("\n Supermercado-Lista carrito:");
		System.out.println("TEST 11 (agregar carrito)");
		try {
			s.agregarCarrito(LocalDate.now() , LocalTime.now(), s.traerClienteXid(2));
			s.agregarCarrito(LocalDate.now() , LocalTime.now(),s.traerClienteXid(3));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(s.getCarr());
		System.out.println("TEST 12 (traer carrito)");
		System.out.println(s.traerCarrito(2));
		
		System.out.println("TEST 13 (eliminar carrito)");
		
		try {
			s.eliminarCarrito(2);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(s.getCarr());
	}

}
