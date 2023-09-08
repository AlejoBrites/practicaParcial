package model;

public class ItemCarrito {
	private int idItem;
	private Producto productos;
	private int cantidad;
	
	public ItemCarrito(int idItem, Producto productos, int cantidad) {
		super();
		this.idItem = idItem;
		this.productos = productos;
		this.cantidad = cantidad;
	}
	
	
	
	@Override
	public String toString() {
		return "ItemCarrito [idItem=" + idItem + ", productos=" + productos + ", cantidad=" + cantidad + "]\n";
	}



	//*****************************************************
	public int getIdItem() {
		return idItem;
	}
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}
	
	
	public Producto getProductos() {
		return productos;
	}
	public void setProductos(Producto productos) {
		this.productos = productos;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
}
