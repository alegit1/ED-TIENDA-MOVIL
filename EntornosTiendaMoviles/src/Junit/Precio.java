package Junit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
*
*
* Clase que verifica si existe un móvil de una marca específica
* con un precio menor o igual al indicado.
* 
* @author  Yehor Suinov
* @version 5.2
* @since   2025-04-08 
*/

public class Precio {
    
    // Marca del móvil a buscar
    private String marca;
    
    // Precio máximo permitido
    private int precio;

    /**
     * Constructor que recibe la marca y el precio máximo.
     * @param id Marca del móvil.
     * @param prc Precio máximo.
     */
    public Precio(String id, int prc) {
        marca = id;
        precio = prc;
    }

    /**
     * Verifica si existe un móvil con la marca y precio dado.
     * 
     * @return "Si hay" si hay al menos uno que cumple la condición, 
     *         "No hay" si no existe, o null en caso de error.
     */
    public String prc() {
        Connection conexion;
        try {
            // Conexión a la base de datos
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/bd_telefono", "root", "");
            Statement consulta = conexion.createStatement();

            // Ejecuta la consulta con marca y precio máximo
            ResultSet registro = consulta.executeQuery(
                "select marca, precio from moviles where marca='" + marca + "' and precio<=" + precio
            );

            // Si existe al menos un resultado
            if (registro.next()) {
                conexion.close();
                return "Si hay";
            } else {
                // Si no existe ninguno
                conexion.close();
                return "No hay";
            }

        } catch (SQLException e) {
            // Manejo de error de SQL
            e.printStackTrace();
        }

        // Retorna null si ocurre un error
        return null;
    }
}
