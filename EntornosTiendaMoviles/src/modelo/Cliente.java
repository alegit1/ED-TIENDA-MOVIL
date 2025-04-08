package modelo;

public class Cliente {
	private int idCliente;
	private String dni;
	private String nombre;

	private int idArticulo;
	private String marca;
	private String modelo;
	private float precio;
	private int cantidad;
	private String color;
	private String descripcion;
	private int capacidad;
	private String garantia;
	private String tipo;

	private int idClienteV;
	private int idVenta;
	private int idArticuloV;
	private int cantidadVendidas;
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getIdArticulo() {
		return idArticulo;
	}
	public void setIdArticulo(int idArticulo) {
		this.idArticulo = idArticulo;
	}
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
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public String getGarantia() {
		return garantia;
	}
	public void setGarantia(String garantia) {
		this.garantia = garantia;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getIdClienteV() {
		return idClienteV;
	}
	public void setIdClienteV(int idClienteV) {
		this.idClienteV = idClienteV;
	}
	public int getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	public int getIdArticuloV() {
		return idArticuloV;
	}
	public void setIdArticuloV(int idArticuloV) {
		this.idArticuloV = idArticuloV;
	}
	public int getCantidadVendidas() {
		return cantidadVendidas;
	}
	public void setCantidadVendidas(int cantidadVendidas) {
		this.cantidadVendidas = cantidadVendidas;
	}

	
}
