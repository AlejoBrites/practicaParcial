package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class Carrito {
	private int idCarrito;
	private LocalDate fecha;
	private LocalTime hora;
	private List<ItemCarrito> items;
	private Cliente cli;
	
	
	
	public Carrito(int idCarrito, LocalDate fecha, LocalTime hora) {
		super();
		this.setIdCarrito(idCarrito);
		this.setFecha(fecha);
		this.setHora(hora);
		this.items = new ArrayList<ItemCarrito>();
	}



	public Carrito(int idCarrito, LocalDate fecha, LocalTime hora,Cliente cliente) {
		super();
		this.setIdCarrito(idCarrito);
		this.setFecha(fecha);
		this.setHora(hora);
		this.items = new ArrayList<ItemCarrito>();
		this.setCli(cliente);
	}



	//******* FUNCIONES DE LAS LISTA ITEM CARRITO*************
	public boolean  agregarItem(Producto producto, int cantidad) {
		
		ItemCarrito auxCarrito= traerItem(producto);
		
		if(auxCarrito==null) {
			int id=1;
			if(items.size()>0) {
				int tam=items.size();
				id=items.get(tam-1).getIdItem()+1;	
			}
			return items.add(new ItemCarrito(id, producto, cantidad));
		}
		
		auxCarrito.setCantidad(cantidad + auxCarrito.getCantidad());
		
		return true;
	} 
	
	public ItemCarrito traerItem(Producto producto) {
		boolean itemEncontrado = false;
		ItemCarrito itemBuscado = null;
		int i=0;
		while (i<items.size() && !itemEncontrado) {
					
			if(items.get(i).getProductos().equals(producto)) {
				itemEncontrado=true;
				itemBuscado=items.get(i);
				}
		i++;
		}

		return itemBuscado;
	}
	
	public boolean eliminarItem (Producto producto, int cantidad) throws Exception {
		ItemCarrito itemBuscado = traerItem(producto);
		if(itemBuscado==null) {
			throw new Exception("Error: El producto no existe"); 
		}
		
		if(cantidad<itemBuscado.getCantidad()) {
			itemBuscado.setCantidad(itemBuscado.getCantidad()-cantidad);
			return true;
		}else if (cantidad==itemBuscado.getCantidad()) {
			items.remove(itemBuscado);
			return true;
		}else {
			throw new Exception("Error: no se puede eliminar mas cantidad de lo que hay"); 
		}
	}
	
	public float calcularSubTotal() {
		ItemCarrito itemBuscado = null;
		float auxSubTotal=0;
		
		for(int i=0;i<items.size();i++) {
			
			itemBuscado=items.get(i);
			float p= itemBuscado.getProductos().getPrecio();
			
			if(items.get(i).getCantidad()>1) {
				
				auxSubTotal=auxSubTotal+p*items.get(i).getCantidad();
				
			}else {
				auxSubTotal=auxSubTotal+p;
			}
		}
		
		return auxSubTotal;
	}
	
	

	@Override
	public String toString() {
		return "Carrito [idCarrito=" + idCarrito + ", fecha=" + fecha + ", hora=" + hora + ", items=" + items + ", cliente="
				+ cli + "]\n";
	}



	//*****************************************************
	public int getIdCarrito() {
		return idCarrito;
	}
	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}
	
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	
	public LocalTime getHora() {
		return hora;
	}
	
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	
	
	
	public List<ItemCarrito> getItems() {
		return items;
	}
	public void setItems(List<ItemCarrito> items) {
		this.items = items;
	}



	public Cliente getCli() {
		return cli;
	}

	public void setCli(Cliente cli) {
		this.cli = cli;
	}
	
	
	
}
