package modelo;

/**
 * Clase que representa a un Cliente y su relación con artículos y ventas en el sistema.
 * 
 * Esta clase almacena información personal del cliente (como ID, DNI, nombre y correo),
 * así como detalles de artículos asociados (marca, modelo, precio, etc.) y datos de ventas.
 * Proporciona métodos getter y setter para acceder y modificar todos sus atributos.
 * 
 * 
 * @author rocki
 * @version 1.0
 */
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
    private String fecha;
    private String correo;
    private int idClienteV;
    private int idVenta;
    private int idArticuloV;
    private int cantidadVendidas;

    /**
     * Obtiene el correo electrónico del cliente.
     * 
     * @return El correo electrónico del cliente.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del cliente.
     * 
     * @param correo El correo electrónico a asignar.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el ID del cliente.
     * 
     * @return El ID del cliente.
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Obtiene la fecha asociada al cliente.
     * 
     * @return La fecha en formato String.
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha asociada al cliente.
     * 
     * @param fecha La fecha a asignar en formato String.
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Establece el ID del cliente.
     * 
     * @param idCliente El ID a asignar.
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Obtiene el DNI del cliente.
     * 
     * @return El DNI del cliente.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el DNI del cliente.
     * 
     * @param dni El DNI a asignar.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Obtiene el nombre del cliente.
     * 
     * @return El nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     * 
     * @param nombre El nombre a asignar.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el ID del artículo asociado al cliente.
     * 
     * @return El ID del artículo.
     */
    public int getIdArticulo() {
        return idArticulo;
    }

    /**
     * Establece el ID del artículo asociado al cliente.
     * 
     * @param idArticulo El ID del artículo a asignar.
     */
    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    /**
     * Obtiene la marca del artículo.
     * 
     * @return La marca del artículo.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca del artículo.
     * 
     * @param marca La marca a asignar.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obtiene el modelo del artículo.
     * 
     * @return El modelo del artículo.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Establece el modelo del artículo.
     * 
     * @param modelo El modelo a asignar.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Obtiene el precio del artículo.
     * 
     * @return El precio del artículo.
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del artículo.
     * 
     * @param precio El precio a asignar.
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la cantidad disponible del artículo.
     * 
     * @return La cantidad disponible.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad disponible del artículo.
     * 
     * @param cantidad La cantidad a asignar.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el color del artículo.
     * 
     * @return El color del artículo.
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece el color del artículo.
     * 
     * @param color El color a asignar.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Obtiene la descripción del artículo.
     * 
     * @return La descripción del artículo.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del artículo.
     * 
     * @param descripcion La descripción a asignar.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la capacidad del artículo.
     * 
     * @return La capacidad del artículo.
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Establece la capacidad del artículo.
     * 
     * @param capacidad La capacidad a asignar.
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Obtiene la garantía del artículo.
     * 
     * @return La garantía del artículo.
     */
    public String getGarantia() {
        return garantia;
    }

    /**
     * Establece la garantía del artículo.
     * 
     * @param garantia La garantía a asignar.
     */
    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    /**
     * Obtiene el tipo de artículo.
     * 
     * @return El tipo de artículo.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de artículo.
     * 
     * @param tipo El tipo a asignar.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene el ID del cliente asociado a una venta.
     * 
     * @return El ID del cliente en el contexto de ventas.
     */
    public int getIdClienteV() {
        return idClienteV;
    }

    /**
     * Establece el ID del cliente asociado a una venta.
     * 
     * @param idClienteV El ID del cliente en ventas a asignar.
     */
    public void setIdClienteV(int idClienteV) {
        this.idClienteV = idClienteV;
    }

    /**
     * Obtiene el ID de la venta.
     * 
     * @return El ID de la venta.
     */
    public int getIdVenta() {
        return idVenta;
    }

    /**
     * Establece el ID de la venta.
     * 
     * @param idVenta El ID de la venta a asignar.
     */
    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    /**
     * Obtiene el ID del artículo vendido.
     * 
     * @return El ID del artículo vendido.
     */
    public int getIdArticuloV() {
        return idArticuloV;
    }

    /**
     * Establece el ID del artículo vendido.
     * 
     * @param idArticuloV El ID del artículo vendido a asignar.
     */
    public void setIdArticuloV(int idArticuloV) {
        this.idArticuloV = idArticuloV;
    }

    /**
     * Obtiene la cantidad de artículos vendidos.
     * 
     * @return La cantidad vendida.
     */
    public int getCantidadVendidas() {
        return cantidadVendidas;
    }

    /**
     * Establece la cantidad de artículos vendidos.
     * 
     * @param cantidadVendidas La cantidad vendida a asignar.
     */
    public void setCantidadVendidas(int cantidadVendidas) {
        this.cantidadVendidas = cantidadVendidas;
    }
}