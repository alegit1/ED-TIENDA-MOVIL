package Junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class DNI_JUnit {

    @Test
    public void DNI() {
        // Crea un objeto de la clase DNI con el ID del cliente "8"
        DNI obj = new DNI("8");
        
        // Llama al método que valida el DNI del cliente
        String resultado = obj.idDNI();
        
        // Comprueba que el resultado sea "DNI no esta correcto"
        // Asegúrate de que el cliente con ID 8 tenga un DNI incorrecto en la base de datos
        assertEquals("DNI no esta correcto", resultado);
    }

}
