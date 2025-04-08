package Junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class IVAidArticuloJUnit {

    @Test
    public void IVAidArticulo() {
        // Crea un objeto de la clase IVAidArticulo con ID de artículo "1"
        IVAidArticulo obj = new IVAidArticulo("1");
        
        // Llama al método que calcula el precio sin IVA
        String resultado = obj.idArt();
        
        // Verifica que el resultado sea igual al valor esperado
        // Asegúrate de que el artículo con ID 1 tenga precio 1000 en la base de datos
        assertEquals("825.6198347107438", resultado);
    }

}
