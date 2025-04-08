package Junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class idClientesJUnit {

    @Test
    public void idClientes() {
        // Crea un objeto de la clase idClientes con ID "2"
        idClientes obj = new idClientes("2");
        
        // Llama al método que verifica si el cliente existe
        String resultado = obj.idCln();
        
        // Comprueba que el resultado sea "Si"
        // Asegúrate de que el cliente con ID 2 exista en la base de datos
        assertEquals("Si", resultado);
    }

}
