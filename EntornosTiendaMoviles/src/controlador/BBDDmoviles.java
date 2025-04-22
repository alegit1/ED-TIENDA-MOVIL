package controlador;

import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
 * de gestión de ventas de móviles. Permite insertar y consultar datos, procesar ventas y
 * enviar correos con boletas.
 * @author rocki
 */
public class BBDDmoviles {

	private static final String x = "jdbc:mysql://localhost/bd_telefono";
	private static final String xx = "root";
	private static final String xxx = "";

	/**
	 * Inserta un nuevo móvil en la base de datos.
	 *  @param tf Objeto Cliente con los datos del móvil.
	 *  @return true si la inserción fue exitosa, false si ocurrió un error.
	 */
	public boolean insertaDatos(Cliente tf) {
		try {
			// Establecer la conexión a la base de datos
			Connection conexion = DriverManager.getConnection(x, xx, xxx);
			Statement consulta = conexion.createStatement();

			// Consulta de inserción de datos
			consulta.executeUpdate(
					"insert into moviles(marca, modelo, precio, cantidad, color, descripcion, capacidad, garantia, tipo) "
							+ "values ('" + tf.getMarca() + "', '" + tf.getModelo() + "', " + tf.getPrecio() + ", "
							+ tf.getCantidad() + ", '" + tf.getColor() + "', '" + tf.getDescripcion() + "', "
							+ tf.getCapacidad() + ", '" + tf.getGarantia() + "', '" + tf.getTipo() + "')");

			conexion.close();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
	
	/**
	 * Inserta un nuevo cliente en la base de datos.
	 *  @param cl Objeto Cliente con los datos del cliente.
	 *  @return true si la inserción fue exitosa, false si ocurrió un error.
	 */
	public boolean insertaCliente(Cliente cl) {
		try {
			// Establecer la conexión a la base de datos
			Connection conexion = DriverManager.getConnection(x, xx, xxx);
			Statement consulta = conexion.createStatement();

			// Consulta de inserción de datos
			consulta.executeUpdate(
					"insert into clientes(nombre, dni) " + "values ('" + cl.getNombre() + "', '" + cl.getDni() + "')");
			conexion.close();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
	
	/**
	 * Consulta las marcas de móviles disponibles.
	 * @return Lista de marcas únicas de móviles.
	 */
	public ArrayList<String> consultaCMBporMarca() {
		ArrayList<String> arrPaisCodigo = new ArrayList<>();
		Connection conexion;
		try {
			conexion = DriverManager.getConnection(x, xx, xxx);
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select distinct marca from moviles ");

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
	 * @return Lista de modelos únicos de móviles.
	 */
	public ArrayList<String> consultaCMBporModelo() {
		ArrayList<String> arrPaisCodigo = new ArrayList<>();
		Connection conexion;
		try {
			conexion = DriverManager.getConnection(x, xx, xxx);
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select distinct modelo from moviles ");

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
	 * @param marcaseleccionada la marca seleccionada
	 * @return la lista de modelos de este marca
	 */
	public ArrayList<String> consultaModeloPorMarca(String marcaseleccionada) {
		ArrayList<String> modelo = new ArrayList<>();
		Connection conexion;
		try {
			conexion = DriverManager.getConnection(x, xx, xxx);
			PreparedStatement consulta = conexion.prepareStatement("SELECT  modelo FROM moviles WHERE marca= ?");
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
	 * @param marca la marca a buscar 
	 * @return List de objetos cliente, que contienen datos de los móviles
	 */
	public ArrayList<Cliente> consultaGeneralPorMarca(String marca) {
		ArrayList<Cliente> arrTodo = new ArrayList<>();

		try {
			Connection conexion = DriverManager.getConnection(x, xx, xxx);
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("SELECT * from moviles WHERE marca = '" + marca + "'");

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
			return arrTodo;

		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
	
	/**
	 * Consultar información completa de los móviles de un modelo.
	 * @param modelo el modelo para buscar
	 * @return List de objetos cliente, que contienen información sobre el móvil
	 */
	public ArrayList<Cliente> consultaGeneralPorModelo(String modelo) {
		ArrayList<Cliente> arrTodo = new ArrayList<>();

		try {
			Connection conexion = DriverManager.getConnection(x, xx, xxx);
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("SELECT * from moviles WHERE modelo = '" + modelo + "'");

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
			return arrTodo;

		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
	
	/**
	 * Consultar las ventas realizadas por el cliente en la fecha mencionada
	 * @param dni el DNI del cliente
	 * @param fecha la fecha o parte de ella (LIKE formato SQL)
	 * @return List de objetos cliente con la información sobre ventas
	 */
	public ArrayList<Cliente> consultaGeneralPorDate(String dni, String fecha) {
		ArrayList<Cliente> arrTodo = new ArrayList<>();

		try {
			Connection conexion = DriverManager.getConnection(x, xx, xxx);
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta
					.executeQuery("SELECT dni, idventa, modelo, ventas.cantidad, fecha FROM ventas, clientes, moviles "
							+ " WHERE clientes.idCliente = ventas.idCliente"
							+ " AND moviles.idArticulo = ventas.idArticulo  and  dni='" + dni + "'  and fecha LIKE '%"
							+ fecha + "%'");

			while (registro.next()) {
				Cliente mo = new Cliente();
				mo.setDni(registro.getString("dni"));
				mo.setIdVenta(registro.getInt("idventa"));
				mo.setModelo(registro.getString("modelo"));
				mo.setCantidad(registro.getInt("cantidad"));
				mo.setFecha(registro.getString("fecha"));
				;
				arrTodo.add(mo);

			}
			return arrTodo;

		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
	
	/**
	 * Procesa una venta Verificar si existe el stock necesario y si efectivamente el cliente es quien dice 
	 * ser.
	 * @param venta. Objeto Cliente con la información de la venta.
	 * @return. true si la venta fue realizada exitosamente, false si es lo contrario.
	 */
	public boolean procesarVenta(Cliente venta) {
		// Controlamos que la venta sea mayor a 0

		if (venta.getCantidadVendidas() <= 0) {
			JOptionPane.showMessageDialog(null, "\n\tError: La cantidad a vender debe ser mayor a 0.");
			return false;
		}

		try (Connection conexion = DriverManager.getConnection(x, xx, xxx);
				Statement consulta = conexion.createStatement()) {

			// Verificar si el cliente existe antes de procesar la venta
			if (!existeCliente(venta.getIdCliente())) { // pasamos el idPara comprobar si existe o no
				JOptionPane.showMessageDialog(null,
						"\n\tError: El cliente con ID " + venta.getIdCliente() + " no está registrado.");
				return false;
			}

			// Inserta la venta solo si hay suficiente stock
			// La consulta SQL utiliza un SELECT para verificar el stock antes de insertar
			int filasInsertadas = consulta.executeUpdate("INSERT INTO ventas (idCliente, idArticulo, cantidad) "
					+ "SELECT " + venta.getIdCliente() + ", " + venta.getIdArticulo() + ", "
					+ venta.getCantidadVendidas() + " " + "FROM moviles " + "WHERE idArticulo = "
					+ venta.getIdArticulo() + " " + "AND cantidad >= " + venta.getCantidadVendidas() + ";");

			if (filasInsertadas == 1) {// Si se insertó correctamente (había suficiente stock)
				// Actualiza el stock restando la cantidad vendida
				consulta.executeUpdate("UPDATE moviles SET cantidad = cantidad - " + venta.getCantidadVendidas()
						+ " WHERE idArticulo = " + venta.getIdArticulo() + ";");

				return true;

			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return false;
	}

	/**
	 * Genera una boleta de venta y la envía por correo.
	 * @param venta. Objeto Cliente con la información necesaria para enviar la boleta.
	 * @return. true si el correo fue enviado exitosamente, false es lo contrario.
	 */
	public boolean correo(Cliente venta) {
		try (Connection conexion = DriverManager.getConnection(x, xx, xxx);
				Statement consulta = conexion.createStatement()) {
			// Consulta datos adicionales para la boleta
			ResultSet resultado = consulta.executeQuery("SELECT m.marca, m.precio, c.nombre, m.modelo, v.fecha "
					+ "FROM moviles m, ventas v " + "JOIN clientes c ON c.idCliente = " + venta.getIdCliente() + " "
					+ "WHERE m.idArticulo = " + venta.getIdArticulo());

			if (resultado.next()) {// Si hay resultados
				// Extrae los datos de la consulta
				String marca = resultado.getString("marca");
				String modelo = resultado.getString("modelo");
				float precio = resultado.getFloat("precio");
				String nombreCliente = resultado.getString("nombre");
				String fecha = resultado.getString("fecha");

				// Crear mensaje de la boleta
				String mensaje = "Gracias por tu compra, " + nombreCliente + "!\n" + "Artículo: " + marca + " " + modelo
						+ "\n" + "Cantidad: " + venta.getCantidadVendidas() + "\n" + "Precio por unidad: " + precio
						+ " euros\n" + "Total: "
						+ (precio * venta.getCantidadVendidas() + " euros\n" + "Fecha de compra: " + fecha + "\n"
								+ "Espero volver a verte pronto " + nombreCliente + " `>.<´");

				// Solicitar correo electrónico del cliente

				if (venta.getCorreo() != null && !venta.getCorreo().isEmpty()) {
					enviarCorreoBoleta(venta.getCorreo(), "Boleta de venta", mensaje);
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * Enviar correo con el contenido de la boleta.
	 * @param destinatario
	 * @param asunto
	 * @param mensaje
	 */
	public void enviarCorreoBoleta(String destinatario, String asunto, String mensaje) {

		// Configuración del servidor SMTP de Gmail
		String host = "smtp.gmail.com";
		String puerto = "587";
		String remitente = "ventasmovil.madrid@gmail.com"; // Correo del remitente
		String claveApp = "fetg wnww iipe lgwz"; // Contraseña de aplicación

		// Propiedades para la conexión SMTP
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true"); // Requiere autenticación
		props.put("mail.smtp.starttls.enable", "true"); // Usa conexión segura
		props.put("mail.smtp.host", host); // Servidor SMTP
		props.put("mail.smtp.port", puerto); // Puerto del servidor

		// Crear la sesión con autenticación
		Session session = Session.getInstance(props, new Authenticator() {
		    @Override
		    protected jakarta.mail.PasswordAuthentication getPasswordAuthentication() {
		        return new jakarta.mail.PasswordAuthentication(remitente, claveApp);
		    }
		});

		try {
			// Crear el mensaje
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(remitente));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
			message.setSubject(asunto);
			message.setText(mensaje);

			// Enviar el correo
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	/**

	Verificar que un cliente con el id pasado exista en la base de datos.
	* @param idCliente
	* @return boolean dependiendo si encuentre al cliente o no
	*/
	public boolean existeCliente(int idCliente) {
		boolean existe = false;
		try (Connection conexion = DriverManager.getConnection(x, xx, xxx);
				Statement consulta = conexion.createStatement()) {

			// Método para verificar si un cliente existe en la base de datos
			ResultSet registro = consulta.executeQuery("SELECT idCliente FROM clientes WHERE idCliente = " + idCliente);

			if (registro.next()) {
				existe = true; // Si hay un resultado, existe se vuelve true
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return existe;
	}

	/**
	 * Consulta datos del cliente por su DNI (coincidencia parcial).
	 *  @param dni Parte o totalidad del DNI a buscar.
	 *  @return Lista de clientes que coincidan con el DNI proporcionado.
	 */
	public ArrayList<Cliente> consultaGeneralPorDNI(String dni) {
		ArrayList<Cliente> arrTodo = new ArrayList<>();
		Connection conexion;
		try {
			conexion = DriverManager.getConnection(x, xx, xxx);
			PreparedStatement consulta = conexion
					.prepareStatement("SELECT IdCliente, dni, nombre from clientes where dni like ?");

			// Establece el parámetro correctamente
			consulta.setString(1, "%" + dni + "%");

			ResultSet registro = consulta.executeQuery();

			while (registro.next()) {
				Cliente pcl = new Cliente();
				pcl.setIdCliente(registro.getInt("IdCliente"));
				pcl.setDni(registro.getString("dni"));
				pcl.setNombre(registro.getString("nombre"));

				arrTodo.add(pcl);
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
	    		Connection conn = DriverManager.getConnection(x, xx, xxx);
	         PreparedStatement pstmt = conn.prepareStatement(
	        		 "SELECT moviles.marca, idVenta, moviles.modelo, ventas.cantidad, ventas.fecha, dni " +
	                 "FROM ventas, moviles, clientes " +
	                 "WHERE ventas.idArticulo = moviles.idArticulo " +
	                 "AND ventas.idCliente = clientes.idCliente " + 
	                 "AND dni LIKE ? AND fecha LIKE ?");

	        pstmt.setString(1, "%" + dni + "%");
	        pstmt.setString(2, "%" + fecha + "%");

	        try (ResultSet rs = pstmt.executeQuery()) {
	            while (rs.next()) {
	                Cliente cliente = new Cliente();
	                cliente.setDni(rs.getString("dni"));
	                cliente.setIdVenta(rs.getInt("idVenta"));
	                cliente.setModelo(rs.getString("modelo"));
	                cliente.setCantidadVendidas(rs.getInt("cantidad"));
	                //cliente.setFecha(rs.getString("fecha"));
	                ventas.add(cliente);
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return ventas;
	}

}