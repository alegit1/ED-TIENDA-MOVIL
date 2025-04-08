package Junit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
*
*
* Clase que calcula el IVA (21%) del precio de un artículo
* según su ID en la base de datos.
*  * Utiliza la base de datos bd_telefono y la tabla "moviles"
* para obtener el precio de un artículo.
* 
* @author  Yehor Suinov
* @version 5.2
* @since   2025-04-08 
*/

public class IVAidArticulo {
    // Almacena el ID del artículo
    private String idA;

    /**
     * Constructor que recibe el ID del artículo.
     * @param id ID del artículo.
     */
    public IVAidArticulo(String id) {
        idA = id;
    }

    /**
     * Calcula el IVA del precio del artículo.
     * 
     * @return El valor del IVA calculado si el artículo existe,
     *         o "No existe" si no se encuentra el artículo en la base de datos.
     */
    public String idArt() {
        Connection conexion;
        try {
            // Conexión a la base de datos bd_telefono
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/bd_telefono", "root", "");
            Statement consulta = conexion.createStatement();

            // Ejecuta la consulta para obtener el precio del artículo
            ResultSet registro = consulta.executeQuery("select precio from moviles where idArticulo= " + idA);

            // Si el artículo existe, calcula el IVA (21%) del precio
            if (registro.next()) {
                double iva = registro.getInt("precio") / 1.21;
                conexion.close();
                // Convierte el valor de IVA a String y lo retorna
                String iva1 = String.valueOf(iva);
                return iva1;
            } else {
                // Si el artículo no existe, retorna "No existe"
                conexion.close();
                return "No existe";
            }
        } catch (SQLException e) {
            // Imprime el error si ocurre una excepción SQL
            e.printStackTrace();
        }

        // Retorna null en caso de error
        return null;
    }
}
