package model;

import java.util.Objects;

public class Producto {
	private int idProducto;
	private String producto;
	private float precio;
	
	public Producto(String producto, float precio) {
		super();
		this.setProducto(producto);
		this.setPrecio(precio);
	}
	
	
	public Producto(int idProducto, String producto, float precio) {
		super();
		this.setIdProducto(idProducto);
		this.setProducto(producto);
		this.setPrecio(precio);
	}
	
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(idProducto, precio, producto);
	}



	public boolean equals(Producto producto) {
		return (this.idProducto == producto.getIdProducto()) && (this.producto == producto.getProducto());
	}


	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", producto=" + producto + ", precio=" + precio + "]\n";
	}

	//*****************************************************
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	
	
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	

	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
}
