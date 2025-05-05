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
    private JTextField textFieldFecha; // Renombrado para mayor claridad
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

        JLabel lblTickets = new JLabel("INFORMACIÓN DE VENTAS");
        lblTickets.setHorizontalAlignment(SwingConstants.CENTER);
        lblTickets.setForeground(Color.RED);
        lblTickets.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
        lblTickets.setBackground(Color.RED);
        lblTickets.setBounds(272, 66, 390, 43);
        add(lblTickets);

        JLabel lblNewLabel_1 = new JLabel("DNI");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Stencil", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(177, 170, 100, 52);
        add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("FECHA");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1.setFont(new Font("Stencil", Font.PLAIN, 20));
        lblNewLabel_1_1.setBounds(514, 181, 100, 30);
        add(lblNewLabel_1_1);

        textFieldDni = new JTextField();
        textFieldDni.setBounds(301, 182, 150, 30);
        add(textFieldDni);
        textFieldDni.setColumns(10);

        textFieldFecha = new JTextField(); 
        textFieldFecha.setColumns(10);
        textFieldFecha.setBounds(633, 182, 150, 30);
        add(textFieldFecha);

        model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{
                "DNI", "idVenta", "Modelo", "Cantidad Vendidas", "Fecha"
        });
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(103, 277, 745, 355);
        add(scrollPane);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(444, 643, 100, 30);
        add(btnBuscar);
        
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
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {            	
            	consultarPorDniyFecha();            	
            }
        });

        table.setModel(model);
        scrollPane.setViewportView(table);
    }
    
    public void consultarPorDniyFecha() {
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