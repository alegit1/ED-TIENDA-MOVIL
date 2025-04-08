package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
	
	
}
