package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import controlador.BBDDmoviles;
import modelo.Cliente;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Panel de consulta de información de ventas por DNI y fecha.
 * 
 * Permite buscar y visualizar en una tabla los registros de ventas
 * filtrando por DNI del cliente y fecha de venta. Incluye validación
 * básica de campos y manejo de resultados.
 * 
 * 
 * @author lazaro
 * @version 1.0
 * @see modelo.Cliente
 * @see controlador.BBDDmoviles
 */
public class ConsultarInformacionVenta extends JPanel {
    private static final long serialVersionUID = 1L;
    private ArrayList<Cliente> misClientes;
    private JTextField textFieldDni;
    private JTextField textFieldFecha;
    private JButton btnBuscar;
    private JTable table;
    private DefaultTableModel model;

    /**
     * Constructor que inicializa la interfaz gráfica y componentes.
     * 
     * Configura:
     * 
     *   Campos de texto para DNI y fecha
     *   Tabla con modelo de datos para resultados
     *   Botón con acción de búsqueda
     * 
     * 
     */
    public ConsultarInformacionVenta() {
        setLayout(null);

        // [Código de inicialización de componentes...]

        btnBuscar.addActionListener(new ActionListener() {
            /**
             * Maneja el evento de búsqueda al hacer clic en el botón.
             * 
             * Realiza:
             * 
             *   Validación de campos obligatorios
             *   Consulta a la base de datos mediante {@link controlador.BBDDmoviles#getVentasByDniAndFecha}
             *   Actualización de la tabla con resultados
             * 
             * 
             * 
             * @param e Evento de acción generado por el botón
             */
            public void actionPerformed(ActionEvent e) {
                BBDDmoviles dbManager = new BBDDmoviles();
                String idCliente = textFieldDni.getText().trim();
                String fecha = textFieldFecha.getText().trim();

                if (idCliente.isEmpty() || fecha.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un DNI válido.");
                    return;
                }

                misClientes = dbManager.getVentasByDniAndFecha(idCliente, fecha); 
                cargaTabla();
            }
        });
    }

    /**
     * Carga los datos de ventas en la tabla de resultados.
     * 
     * Limpia el modelo existente y añade filas con:
     * 
     *   DNI del cliente
     *   ID de venta
     *   Modelo del artículo
     *   Cantidad vendida
     *   Fecha de venta
     * 
     * Muestra mensaje si no hay resultados.
     * 
     */
    public void cargaTabla() {
        model.setRowCount(0); 

        if (misClientes == null || misClientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontraron ventas para los criterios ingresados.");
            return;
        }

        for (Cliente c : misClientes) {
            model.addRow(new Object[]{
                    c.getDni(),
                    c.getIdVenta(),
                    c.getModelo(),
                    c.getCantidadVendidas(),
                    c.getFecha()
            });
        }
    }
}