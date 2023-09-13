package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Supermercado {
	private List<Producto> productos;
	private List<Cliente> cli;
	private List<Carrito> carr;
	
	

	public Supermercado(){
		this.productos= new ArrayList<Producto>();
		this.cli= new ArrayList<Cliente>();
		this.carr= new ArrayList<Carrito>();
	}
	
	
	public Supermercado(List<Cliente> cli, List<Carrito> carr) {
		super();
		this.cli = cli;
		this.carr = carr;
	}
	//************** Funciones de la lista carrito **************************
	
	public boolean agregarCarrito(LocalDate fecha,LocalTime hora,Cliente cliente) throws Exception {
		
		if (traerCarrito(cliente)!=null) {
			throw new Exception("Error: El carrito ya existe");
		}
		
		int id=1;
		if(carr.size()>0) {
			int tam=carr.size();
			id=carr.get(tam-1).getIdCarrito()+1;
		}	
		return carr.add(new Carrito(id, fecha, hora,cliente));	
	}
	
	
	public Carrito traerCarrito(Cliente cliente) {
		
		boolean carrEncontrado = false;
		Carrito carrBuscado = null;
		int i=0;
		while (i<carr.size() && !carrEncontrado) {
					
			if(carr.get(i).getCli().equals(cliente)) {
				carrEncontrado=true;
				carrBuscado=carr.get(i);
				}
		i++;
		}
		return carrBuscado;
	}
	
	public Carrito traerCarrito(int idCarrito) {
		
		boolean carrEncontrado = false;
		Carrito carrBuscado = null;
		int i=0;
		while (i<carr.size() && !carrEncontrado) {
					
			if(carr.get(i).getIdCarrito()==idCarrito) {
				carrEncontrado=true;
				carrBuscado=carr.get(i);
				}
		i++;
		}
		return carrBuscado;
	}
	
	
	public boolean eliminarCarrito (int idCarrito) throws Exception {
		Carrito carrito=traerCarrito(idCarrito);
		if(carrito==null) {
			throw new Exception("Error: el carrito no exite");
		}
		
		carr.remove(idCarrito-1);
		
		return true;
	}
	

	//************** Funciones de la lista cliente **************************
	public boolean agregarCliente(String nombreCliente, int dni, String direccion)throws Exception {
			
			if (traerCliente(dni)!=null) {
				throw new Exception("Error: El cliente ya existe");
			}
			
			int id=1;
			if(cli.size()>0) {
				int tam=cli.size();
				id=cli.get(tam-1).getIdCliente()+1;
			}
			
			
			
			return cli.add(new Cliente(id, nombreCliente, dni, direccion));	
		}
	
	public Cliente traerCliente(int dni) {
		boolean cliEncontrado = false;
		Cliente cliBuscado = null;
		int i=0;
		while (i<cli.size() && !cliEncontrado) {
					
			if(cli.get(i).getDni()==dni) {
				cliEncontrado=true;
				cliBuscado=cli.get(i);
				}
		i++;
		}

		return cliBuscado;
	}
	
	public Cliente traerClienteXid(int id) {
		boolean cliEncontrado = false;
		Cliente cliBuscado = null;
		int i=0;
		while (i<cli.size() && !cliEncontrado) {
					
			if(cli.get(i).getIdCliente()==id) {
				cliEncontrado=true;
				cliBuscado=cli.get(i);
				}
		i++;
		}

		return cliBuscado;
	}
	
	public boolean eliminarCliente(int idCliente) throws Exception {
		Cliente cliBuscado = traerClienteXid(idCliente);
		
		if(cliBuscado==null) {
			throw new Exception("Error: el cliente no existe");
		}
		cli.remove(idCliente-1);
		return true;
	}
	
	
	//************** Funciones de la lista producto **************************
	public boolean agregarProducto(String producto, float precio) throws Exception{
		
		if(traerProducto(producto)!=null) {
			throw new Exception("Error: El producto ya existe"); 
		}
		
		int id=1;
		if(productos.size()>0) {
			int tamanio= productos.size();
			id=productos.get(tamanio-1).getIdProducto()+1;
		}
		
		return productos.add(new Producto(id,producto,precio));		
	} 
	
	public Producto traerProducto(String producto) {
		boolean prodEncontrado=false;
		Producto productoEncontrado=null;
		int i=0;
		while(i<productos.size() && !prodEncontrado) {
			if(productos.get(i).getProducto().equals(producto)) {
					prodEncontrado=true;
					productoEncontrado=productos.get(i);
			}
		i++;	
		}
		
		return productoEncontrado;
	}
	
	public Producto traerProducto(int idProducto) {
		boolean prodEncontrado=false;
		Producto productoEncontrado=null;
		int i=0;
		while(i<productos.size() && !prodEncontrado) {
			if(productos.get(i).getIdProducto()==idProducto) {
					prodEncontrado=true;
					productoEncontrado=productos.get(i);
			}
		i++;	
		}
		return productoEncontrado;
	}
	
	public boolean modificarProducto(int idProducto, String producto, float precio) throws Exception {
		
		if(traerProducto(idProducto)==null) {
			throw new Exception("Error: El producto no existe"); 
		}
		productos.get(idProducto-1).setPrecio(precio);
		productos.get(idProducto-1).setProducto(producto);
		
		return true;
	}
	
	public boolean eliminarProducto(int idProducto) throws Exception{
		Producto p= traerProducto(idProducto);
		if(p==null) {
			throw new Exception("Error: El producto no existe"); 
		}
		return productos.remove(p);
	}
	
	
	
	
	@Override
	public String toString() {
		return "Supermercado [productos=" + productos + ", cli=\n" + cli + ", carr=" + carr + "]";
	}


	//*****************************************************
	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public List<Cliente> getCli() {
		return cli;
	}

	public void setCli(List<Cliente> cli) {
		this.cli = cli;
	}

	public List<Carrito> getCarr() {
		return carr;
	}

	public void setCarr(List<Carrito> carr) {
		this.carr = carr;
	}
	
	
}
