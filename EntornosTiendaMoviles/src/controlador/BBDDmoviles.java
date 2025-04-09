package controlador;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Cliente;

public class BBDDmoviles {
	
	private static final String x = "jdbc:mysql://localhost/bd_telefono";
    private static final String xx = "root";
    private static final String xxx = "";
	
	public boolean insertaDatos(Cliente tf) {
        try {
            // Establecer la conexión a la base de datos
            Connection conexion = DriverManager.getConnection(x,xx,xxx);
            Statement consulta = conexion.createStatement();
            
            // Consulta de inserción de datos
            consulta.executeUpdate("insert into moviles(marca, modelo, precio, cantidad, color, descripcion, capacidad, garantia, tipo) "
                    + "values ('" 
            		+ tf.getMarca() + "', '"
            		+ tf.getModelo() + "', "
                    + tf.getPrecio() + ", "
                    + tf.getCantidad() + ", '"
                    + tf.getColor() + "', '"
                    + tf.getDescripcion() + "', "
            		+ tf.getCapacidad() + ", '"
					+ tf.getGarantia() + "', '"
            		+ tf.getTipo() + "')");
            
            conexion.close();
            return true;
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
        
    }
	
	public boolean insertaCliente(Cliente cl) {
        try {
            // Establecer la conexión a la base de datos
            Connection conexion = DriverManager.getConnection(x,xx,xxx);
            Statement consulta = conexion.createStatement();
            
            // Consulta de inserción de datos
            consulta.executeUpdate("insert into clientes(nombre, dni) "
                    + "values ('" 
            		+ cl.getNombre() + "', '"
            		+ cl.getDni() + "')");  
            conexion.close();
            return true;
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
        
    }
	
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
	
	
	
	public ArrayList<String> consultaModeloPorMarca(String marcaseleccionada){
		ArrayList<String> modelo = new ArrayList<>();
		Connection conexion;
		try {
			conexion = DriverManager.getConnection(x, xx, xxx);
			PreparedStatement consulta = conexion.prepareStatement(
					"SELECT  modelo FROM moviles WHERE marca= ?");
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
	public ArrayList<Cliente> consultaGeneralPorMarca(String marca) {
		ArrayList<Cliente> arrTodo = new ArrayList<>();

		try {
			Connection conexion = DriverManager.getConnection(x, xx, xxx);
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery(
				    "SELECT * from moviles WHERE marca = '" + marca + "'"
				);


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
	public ArrayList<Cliente> consultaGeneralPorModelo(String modelo) {
		ArrayList<Cliente> arrTodo = new ArrayList<>();

		try {
			Connection conexion = DriverManager.getConnection(x, xx, xxx);
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery(
				    "SELECT * from moviles WHERE modelo = '" + modelo + "'"
				);


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
}