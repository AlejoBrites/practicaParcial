package model;

public class Cliente {
	private int idCliente;
	private String nombreCliente;
	private int dni;
	private String direccion;
	
	
	public Cliente(String nombreCliente, int dni, String direccion) {
		super();
		this.setNombreCliiente(nombreCliente);
		this.setDni(dni);
		this.setDireccion(direccion);
	}


	public Cliente(int id,String nombreCliente, int dni, String direccion) {
		super();
		this.setIdCliente(id);
		this.setNombreCliiente(nombreCliente);
		this.setDni(dni);
		this.setDireccion(direccion);
	}
	
	@Override
	public String toString() {
		return "\n Cliente [idCliente=" + idCliente + ", nombreCliente=" + nombreCliente + ", dni=" + dni + ", direccion="
				+ direccion + "]";
	}
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombreCliiente() {
		return nombreCliente;
	}
	public void setNombreCliiente(String nombreCliiente) {
		this.nombreCliente = nombreCliiente;
	}


	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
}
