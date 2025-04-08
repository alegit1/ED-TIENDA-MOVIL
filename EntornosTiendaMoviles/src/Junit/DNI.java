package Junit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
*
*
* Clase que verifica la validez del DNI de un cliente según su ID.
* El DNI consta de 8 números y una letra. La letra se valida con un cálculo
* estándar usando el módulo 23.
* Usa una base de datos MySQL (bd_telefono) y busca el DNI en la tabla "clientes".
* 
* 
* @author  Yehor Suinov
* @version 5.2
* @since   2025-04-08 
*/

public class DNI {
    
    private String idD;

    private static final char[] DNI_LETTERS = {
        'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B',
        'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'
    };

    /**
     * Constructor con el ID del cliente.
     * @param id ID del cliente.
     */
    public DNI(String id) {
        idD = id;
    }

    /**
     * Verifica si el DNI del cliente es correcto.
     * 
     * @return Resultado de la validación del DNI.
     */
    public String idDNI() {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bd_telefono", "root", "");
            Statement consulta = conexion.createStatement();

            ResultSet registro = consulta.executeQuery("select dni from clientes where idCliente=" + idD);
            if (!registro.next()) {
                conexion.close();
                return "Usuario no existe";
            }

            String dni = registro.getString("dni");
            int num = Integer.parseInt(dni.substring(0, 8));
            char letraCalculada = DNI_LETTERS[num % 23];
            char letraReal = dni.charAt(8);

            return (letraCalculada == letraReal) ? "DNI esta correcto" : "DNI no esta correcto";

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
