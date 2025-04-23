package controlador;

import vista.VentanaFrame;

/**
 * Clase principal que inicia la aplicación.
 * 
 * Esta clase contiene el método {@code main} que es el punto de entrada de la aplicación.
 * Crea una instancia de {@link vista.VentanaFrame} y llama al método {@code empezando()} para iniciar la interfaz gráfica.
 * 
 * 
 * @author rocki
 * @version 1.0
 */
public class Principal {

    /**
     * Método principal que inicia la aplicación.
     * 
     * Este método crea una instancia de la ventana principal ({@link vista.VentanaFrame})
     * y llama al método {@code empezando()} para mostrar la interfaz gráfica.
     * 
     * 
     * @param args Argumentos de línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {
        VentanaFrame vf = new VentanaFrame();
        vf.empezando();
    }

}
