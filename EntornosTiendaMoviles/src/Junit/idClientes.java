package Junit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
*
*
* Clase que verifica si existe un cliente en la base de datos
* según su ID.
* 
* 
* @author  Yehor Suinov
* @version 5.2
* @since   2025-04-08 
*/

public class idClientes {
    // Almacena el ID del cliente a verificar
    private String idC;

    /**
     * Constructor que recibe el ID del cliente.
     * @param id ID del cliente.
     */
    public idClientes(String id) {
        idC = id;
    }

    /**
     * Verifica si el cliente con el ID existe en la base de datos.
     * 
     * @return "Si" si el cliente existe, "No" si no existe,
     *         o null en caso de error.
     */
    public String idCln() {
        Connection conexion;
        try {
            // Conexión a la base de datos bd_telefono
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/bd_telefono", "root", "");
            Statement consulta = conexion.createStatement();

            // Ejecuta la consulta para buscar el ID del cliente
            ResultSet registro = consulta.executeQuery("select idCliente from clientes where idCliente=" + idC);

            // Si hay resultado, el cliente existe
            if (registro.next()) {
                conexion.close();
                return "Si";
            } else {
                // Si no hay resultado, el cliente no existe
                conexion.close();
                return "No";
            }
        } catch (SQLException e) {
            // Imprime el error si ocurre una excepción SQL
            e.printStackTrace();
        }

        // Retorna null en caso de error
        return null;
    }
}
