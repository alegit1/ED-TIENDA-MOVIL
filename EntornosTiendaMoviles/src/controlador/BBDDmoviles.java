package controlador;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;

import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import modelo.Cliente;
import jakarta.mail.*;
import jakarta.mail.internet.*;

/**
 * Clase que gestiona la conexión y operaciones con la base de datos del sistema
 * de gestión de ventas de móviles. Permite insertar y consultar datos, procesar
 * ventas y enviar correos con boletas.
 * 
 * @author rocki
 */
public class BBDDmoviles {

    private static final String URL = "jdbc:mysql://localhost/bd_telefono";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    /**
     * Inserta un nuevo móvil en la base de datos.
     * 
     * @param tf Objeto Cliente con los datos del móvil.
     * @return true si la inserción fue exitosa, false si ocurrió un error.
     */
    public boolean insertaDatos(Cliente tf) {
        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement consulta = conexion.prepareStatement(
                    "INSERT INTO moviles (marca, modelo, precio, cantidad, color, descripcion, capacidad, garantia, tipo) "
                            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            consulta.setString(1, tf.getMarca());
            consulta.setString(2, tf.getModelo());
            consulta.setFloat(3, tf.getPrecio());
            consulta.setInt(4, tf.getCantidad());
            consulta.setString(5, tf.getColor());
            consulta.setString(6, tf.getDescripcion());
            consulta.setInt(7, tf.getCapacidad());
            consulta.setString(8, tf.getGarantia());
            consulta.setString(9, tf.getTipo());
            
            consulta.executeUpdate();
            conexion.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Inserta un nuevo cliente en la base de datos.
     * 
     * @param cl Objeto Cliente con los datos del cliente.
     * @return true si la inserción fue exitosa, false si ocurrió un error.
     */
    public boolean insertaCliente(Cliente cl) {
        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement consulta = conexion.prepareStatement(
                    "INSERT INTO clientes (nombre, dni) VALUES (?, ?)");
            
            consulta.setString(1, cl.getNombre());
            consulta.setString(2, cl.getDni());
            
            consulta.executeUpdate();
            conexion.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Consulta las marcas de móviles disponibles.
     * 
     * @return Lista de marcas únicas de móviles.
     */
    public ArrayList<String> consultaCMBporMarca() {
        ArrayList<String> arrPaisCodigo = new ArrayList<>();
        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement consulta = conexion.prepareStatement(
                    "SELECT DISTINCT marca FROM moviles");
            
            ResultSet registro = consulta.executeQuery();
            
            while (registro.next()) {
                arrPaisCodigo.add(registro.getString("marca"));
            }
            conexion.close();
            return arrPaisCodigo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Tiene el SQL sin iniciar");
            return new ArrayList<>();
        }
    }

    /**
     * Consulta los modelos de móviles disponibles.
     * 
     * @return Lista de modelos únicos de móviles.
     */
    public ArrayList<String> consultaCMBporModelo() {
        ArrayList<String> arrPaisCodigo = new ArrayList<>();
        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement consulta = conexion.prepareStatement(
                    "SELECT DISTINCT modelo FROM moviles");
            
            ResultSet registro = consulta.executeQuery();
            
            while (registro.next()) {
                arrPaisCodigo.add(registro.getString("modelo"));
            }
            conexion.close();
            return arrPaisCodigo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Tiene el SQL sin iniciar");
            return new ArrayList<>();
        }
    }

    /**
     * Obtener modelos disponibles para marca.
     * 
     * @param marcaseleccionada la marca seleccionada
     * @return la lista de modelos de este marca
     */
    public ArrayList<String> consultaModeloPorMarca(String marcaseleccionada) {
        ArrayList<String> modelo = new ArrayList<>();
        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement consulta = conexion.prepareStatement(
                    "SELECT modelo FROM moviles WHERE marca = ?");
            
            consulta.setString(1, marcaseleccionada);
            ResultSet resultado = consulta.executeQuery();
            
            while (resultado.next()) {
                modelo.add(resultado.getString("modelo"));
            }
            conexion.close();
            return modelo;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * Consulta la información completa de los móviles de una marca.
     * 
     * @param marca la marca a buscar
     * @return List de objetos cliente, que contienen datos de los móviles
     */
    public ArrayList<Cliente> consultaGeneralPorMarca(String marca) {
        ArrayList<Cliente> arrTodo = new ArrayList<>();
        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement consulta = conexion.prepareStatement(
                    "SELECT * FROM moviles WHERE marca = ?");
            
            consulta.setString(1, marca);
            ResultSet registro = consulta.executeQuery();
            
            while (registro.next()) {
                Cliente mo = new Cliente();
                mo.setIdArticulo(registro.getInt("idArticulo"));
                mo.setMarca(registro.getString("marca"));
                mo.setModelo(registro.getString("modelo"));
                mo.setPrecio(registro.getFloat("precio"));
                mo.setCantidad(registro.getInt("cantidad"));
                mo.setColor(registro.getString("color"));
                mo.setDescripcion(registro.getString("descripcion"));
                mo.setCapacidad(registro.getInt("capacidad"));
                mo.setGarantia(registro.getString("garantia"));
                mo.setTipo(registro.getString("tipo"));
                arrTodo.add(mo);
            }
            conexion.close();
            return arrTodo;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * Consultar información completa de los móviles de un modelo.
     * 
     * @param modelo el modelo para buscar
     * @return List de objetos cliente, que contienen información sobre el móvil
     */
    public ArrayList<Cliente> consultaGeneralPorModelo(String modelo) {
        ArrayList<Cliente> arrTodo = new ArrayList<>();
        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement consulta = conexion.prepareStatement(
                    "SELECT * FROM moviles WHERE modelo = ?");
            
            consulta.setString(1, modelo);
            ResultSet registro = consulta.executeQuery();
            
            while (registro.next()) {
                Cliente mo = new Cliente();
                mo.setIdArticulo(registro.getInt("idArticulo"));
                mo.setMarca(registro.getString("marca"));
                mo.setModelo(registro.getString("modelo"));
                mo.setPrecio(registro.getFloat("precio"));
                mo.setCantidad(registro.getInt("cantidad"));
                mo.setColor(registro.getString("color"));
                mo.setDescripcion(registro.getString("descripcion"));
                mo.setCapacidad(registro.getInt("capacidad"));
                mo.setGarantia(registro.getString("garantia"));
                mo.setTipo(registro.getString("tipo"));
                arrTodo.add(mo);
            }
            conexion.close();
            return arrTodo;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * Consultar las ventas realizadas por el cliente en la fecha mencionada
     * 
     * @param dni   el DNI del cliente
     * @param fecha la fecha o parte de ella (LIKE formato SQL)
     * @return List de objetos cliente con la información sobre ventas
     */
    public ArrayList<Cliente> consultaGeneralPorDate(String dni, String fecha) {
        ArrayList<Cliente> arrTodo = new ArrayList<>();
        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement consulta = conexion.prepareStatement(
                    "SELECT dni, idventa, modelo, ventas.cantidad, fecha FROM ventas, clientes, moviles "
                            + "WHERE clientes.idCliente = ventas.idCliente "
                            + "AND moviles.idArticulo = ventas.idArticulo AND dni = ? AND fecha LIKE ?");
            
            consulta.setString(1, dni);
            consulta.setString(2, "%" + fecha + "%");
            ResultSet registro = consulta.executeQuery();
            
            while (registro.next()) {
                Cliente mo = new Cliente();
                mo.setDni(registro.getString("dni"));
                mo.setIdVenta(registro.getInt("idventa"));
                mo.setModelo(registro.getString("modelo"));
                mo.setCantidad(registro.getInt("cantidad"));
                mo.setFecha(registro.getString("fecha"));
                arrTodo.add(mo);
            }
            conexion.close();
            return arrTodo;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * Procesa una venta Verificar si existe el stock necesario y si efectivamente
     * el cliente es quien dice ser.
     * 
     * @param venta. Objeto Cliente con la información de la venta. @return. true si
     *               la venta fue realizada exitosamente, false si es lo contrario.
     */
    public boolean procesarVenta(Cliente venta) {
    	
        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            
            if (!existeCliente(venta.getIdCliente())) {
                JOptionPane.showMessageDialog(null,
                        "\n\tError: El cliente con ID " + venta.getIdCliente() + " no está registrado.");
                conexion.close();
                return false;
            }

            PreparedStatement consulta = conexion.prepareStatement(
                    "INSERT INTO ventas (idCliente, idArticulo, cantidad) "
                            + "SELECT ?, ?, ? FROM moviles WHERE idArticulo = ? AND cantidad >= ?");
            
            consulta.setInt(1, venta.getIdCliente());
            consulta.setInt(2, venta.getIdArticulo());
            consulta.setInt(3, venta.getCantidadVendidas());
            consulta.setInt(4, venta.getIdArticulo());
            consulta.setInt(5, venta.getCantidadVendidas());
            
            int filasInsertadas = consulta.executeUpdate();
            
            if (filasInsertadas == 1) {
                PreparedStatement consultaDos = conexion.prepareStatement(
                        "UPDATE moviles SET cantidad = cantidad - ? WHERE idArticulo = ?");
                consultaDos.setInt(1, venta.getCantidadVendidas());
                consultaDos.setInt(2, venta.getIdArticulo());
                consultaDos.executeUpdate();
                conexion.close();
                return true;
            }
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Genera una boleta de venta y la envía por correo.
     * 
     * @param venta. Objeto Cliente con la información necesaria para enviar la
     *               boleta. @return. true si el correo fue enviado exitosamente,
     *               false es lo contrario.
     */
    public boolean correo(Cliente venta) {
        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement consulta = conexion.prepareStatement(
                    "SELECT m.marca, m.precio, c.nombre, m.modelo, v.fecha "
                            + "FROM moviles m, ventas v, clientes c "
                            + "WHERE c.idCliente = ? AND m.idArticulo = ?");
            
            consulta.setInt(1, venta.getIdCliente());
            consulta.setInt(2, venta.getIdArticulo());
            ResultSet resultado = consulta.executeQuery();
            
            if (resultado.next()) {
                String marca = resultado.getString("marca");
                String modelo = resultado.getString("modelo");
                float precio = resultado.getFloat("precio");
                String nombreCliente = resultado.getString("nombre");
                String fecha = resultado.getString("fecha");

                String mensaje = "Gracias por tu compra, " + nombreCliente + "!\n" + 
                		"Artículo: " + marca + " " + modelo + "\n" + 
                		"Cantidad: " + venta.getCantidadVendidas() + "\n" + 
                		"Precio por unidad: " + precio + " euros\n" + 
                		"Total: " + (precio * venta.getCantidadVendidas() + " euros\n" + 
                		"Fecha de compra: " + fecha + "\n" +
                        "Espero volver a verte pronto " + nombreCliente + " `>.<´");

                if (venta.getCorreo() != null && !venta.getCorreo().isEmpty()) {
                    enviarCorreoBoleta(venta.getCorreo(), "Boleta de venta", mensaje);
                    conexion.close();
                    return true;
                } else {
                    conexion.close();
                    return false;
                }
            } else {
                conexion.close();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Enviar correo con el contenido de la boleta.
     * 
     * @param destinatario
     * @param asunto
     * @param mensaje
     */
    public void enviarCorreoBoleta(String destinatario, String asunto, String mensaje) {
        String host = "smtp.gmail.com";
        String puerto = "587";
        String remitente = "ventasmovil.madrid@gmail.com";
        String claveApp = "fetg wnww iipe lgwz";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", puerto);

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected jakarta.mail.PasswordAuthentication getPasswordAuthentication() {
                return new jakarta.mail.PasswordAuthentication(remitente, claveApp);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remitente));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(asunto);
            message.setText(mensaje);
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    /**
     * Verificar que un cliente con el id pasado exista en la base de datos.
     * 
     * @param idCliente
     * @return boolean dependiendo si encuentre al cliente o no
     */
    public boolean existeCliente(int idCliente) {
        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement consulta = conexion.prepareStatement(
                    "SELECT idCliente FROM clientes WHERE idCliente = ?");
            
            consulta.setInt(1, idCliente);
            ResultSet registro = consulta.executeQuery();
            
            if (registro.next()) {
                return true;
            }
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Consulta datos del cliente por su DNI (coincidencia parcial).
     * 
     * @param dni Parte o totalidad del DNI a buscar.
     * @return Lista de clientes que coincidan con el DNI proporcionado.
     */
    public ArrayList<Cliente> consultaGeneralPorDNI(String dni) {
        ArrayList<Cliente> arrTodo = new ArrayList<>();
        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement consulta = conexion.prepareStatement(
                    "SELECT IdCliente, dni, nombre FROM clientes WHERE dni LIKE ?");
            
            consulta.setString(1, "%" + dni + "%");
            ResultSet registro = consulta.executeQuery();
            
            while (registro.next()) {
                Cliente clienteConsultadoporDni = new Cliente();
                clienteConsultadoporDni.setIdCliente(registro.getInt("IdCliente"));
                clienteConsultadoporDni.setDni(registro.getString("dni"));
                clienteConsultadoporDni.setNombre(registro.getString("nombre"));
                arrTodo.add(clienteConsultadoporDni);
            }
            conexion.close();
            return arrTodo;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public ArrayList<Cliente> getVentasByDniAndFecha(String dni, String fecha) {
        ArrayList<Cliente> ventas = new ArrayList<>();
        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement consulta = conexion.prepareStatement(
                    "SELECT moviles.marca, idVenta, moviles.modelo, ventas.cantidad, ventas.fecha, dni "
                            + "FROM ventas, moviles, clientes "
                            + "WHERE ventas.idArticulo = moviles.idArticulo "
                            + "AND ventas.idCliente = clientes.idCliente "
                            + "AND dni LIKE ? AND fecha LIKE ?");
            
            consulta.setString(1, "%" + dni + "%");
            consulta.setString(2, "%" + fecha + "%");
            ResultSet rs = consulta.executeQuery();
            
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setDni(rs.getString("dni"));
                cliente.setIdVenta(rs.getInt("idVenta"));
                cliente.setModelo(rs.getString("modelo"));
                cliente.setCantidadVendidas(rs.getInt("cantidad"));
                cliente.setFecha(rs.getString("fecha"));
                ventas.add(cliente);
            }
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ventas;
    }

    public ArrayList<Cliente> consultaGeneralPorMarcaModeloyColor(String marca, String modelo, String color) {
        ArrayList<Cliente> arrTodo = new ArrayList<>();
        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement consulta = conexion.prepareStatement(
                    "SELECT * FROM moviles WHERE LOWER(marca) LIKE LOWER(?) AND LOWER(modelo) LIKE LOWER(?) AND LOWER(color) LIKE LOWER(?)");
            
            consulta.setString(1, "%" + marca.toLowerCase() + "%");
            consulta.setString(2, "%" + modelo.toLowerCase() + "%");
            consulta.setString(3, "%" + color.toLowerCase() + "%");
            ResultSet registro = consulta.executeQuery();
            
            while (registro.next()) {
                Cliente consultandoParalaTabla = new Cliente();
                consultandoParalaTabla.setIdArticulo(registro.getInt("idArticulo"));
                consultandoParalaTabla.setMarca(registro.getString("marca"));
                consultandoParalaTabla.setModelo(registro.getString("modelo"));
                consultandoParalaTabla.setPrecio(registro.getInt("precio"));
                consultandoParalaTabla.setCantidad(registro.getInt("cantidad"));
                consultandoParalaTabla.setColor(registro.getString("color"));
                consultandoParalaTabla.setDescripcion(registro.getString("descripcion"));
                consultandoParalaTabla.setCapacidad(registro.getInt("capacidad"));
                consultandoParalaTabla.setGarantia(registro.getString("garantia"));
                consultandoParalaTabla.setTipo(registro.getString("tipo"));
                arrTodo.add(consultandoParalaTabla);
            }
            conexion.close();
            return arrTodo;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public boolean modificaDatosMovil(Cliente c) {
        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement consulta = conexion.prepareStatement(
                    "UPDATE moviles SET marca = ?, modelo = ?, precio = ?, cantidad = ?, color = ?, "
                            + "descripcion = ?, capacidad = ?, garantia = ?, tipo = ? WHERE idArticulo = ?");
            
            consulta.setString(1, c.getMarca());
            consulta.setString(2, c.getModelo());
            consulta.setBigDecimal(3, BigDecimal.valueOf(c.getPrecio()));
            consulta.setInt(4, c.getCantidad());
            consulta.setString(5, c.getColor());
            consulta.setString(6, c.getDescripcion());
            consulta.setInt(7, c.getCapacidad());
            consulta.setString(8, c.getGarantia());
            consulta.setString(9, c.getTipo());
            consulta.setInt(10, c.getIdArticulo());
            
            consulta.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean borrarMovil(Cliente c) {
        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement consulta = conexion.prepareStatement(
                    "DELETE FROM moviles WHERE idArticulo = ?");
            
            consulta.setInt(1, c.getIdArticulo());
            consulta.executeUpdate();
            conexion.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}