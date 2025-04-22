package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controlador.BBDDmoviles;
import modelo.Cliente;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ConsultarInformacionVenta extends JPanel {

    private static final long serialVersionUID = 1L;
    private ArrayList<Cliente> misClientes;
    private JTextField textFieldDni;
    private JTextField textFieldFecha; // Renombrado para mayor claridad
    private JButton btnBuscar;
    private JTable table;
    private DefaultTableModel model;

    public ConsultarInformacionVenta() {
        setLayout(null);

        // Etiqueta principal
        JLabel lblTickets = new JLabel("INFORMACIÓN DE VENTAS");
        lblTickets.setHorizontalAlignment(SwingConstants.CENTER);
        lblTickets.setForeground(Color.RED);
        lblTickets.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
        lblTickets.setBackground(Color.RED);
        lblTickets.setBounds(272, 66, 390, 43);
        add(lblTickets);

        // Etiqueta para el campo de DNI
        JLabel lblNewLabel_1 = new JLabel("DNI");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Stencil", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(177, 170, 100, 52);
        add(lblNewLabel_1);

        // Etiqueta para el campo de fecha
        JLabel lblNewLabel_1_1 = new JLabel("FECHA");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1.setFont(new Font("Stencil", Font.PLAIN, 20));
        lblNewLabel_1_1.setBounds(514, 181, 100, 30);
        add(lblNewLabel_1_1);

        // Campo de texto para ingresar el DNI
        textFieldDni = new JTextField();
        textFieldDni.setBounds(301, 182, 150, 30);
        add(textFieldDni);
        textFieldDni.setColumns(10);

        // Campo de texto para la fecha (opcional)
        textFieldFecha = new JTextField(); // Renombrado para mayor claridad
        textFieldFecha.setColumns(10);
        textFieldFecha.setBounds(633, 182, 150, 30);
        add(textFieldFecha);

        // Tabla y scroll
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{
                "DNI", "idVenta", "Modelo", "Cantidad Vendidas", "Fecha"
        });
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(224, 277, 559, 350);
        add(scrollPane);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(444, 643, 100, 30);
        add(btnBuscar);

        btnBuscar.addActionListener(new ActionListener() {
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

        table.setModel(model);
        scrollPane.setViewportView(table);
    }

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








