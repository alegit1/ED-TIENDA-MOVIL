package Junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class PrecioJUnit {

    @Test
    public void Precio() {
        // Crea un objeto de la clase Precio con marca "Apple" y precio máximo 1000
        Precio obj = new Precio("Apple", 1000);
        
        // Llama al método que busca si hay móviles Apple con precio <= 1000
        String resultado = obj.prc();
        
        // Verifica que el resultado sea "Si hay"
        // Asegúrate de que en la base de datos exista al menos un móvil Apple con ese precio o menor
        assertEquals("Si hay", resultado);
    }

}
