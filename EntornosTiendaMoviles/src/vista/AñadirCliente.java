package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import controlador.BBDDmoviles;
import modelo.Cliente;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Panel gráfico para añadir nuevos clientes al sistema.
 * 
 * Proporciona una interfaz con campos para nombre y DNI, junto con un botón
 * para confirmar la inserción. Valida la operación con diálogos de confirmación
 * y muestra mensajes de éxito/error.
 * 
 * 
 * @author rocki y @author lazaro
 * @version 1.0
 * @see modelo.Cliente
 * @see controlador.BBDDmoviles
 */
public class AñadirCliente extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTextField txtNombre;
    private JTextField textFieldDNI;

    /**
     * Constructor que inicializa los componentes gráficos del panel.
     * 
     * Crea:
     * 
     *   Etiquetas de título y campos
     *   Campos de texto para nombre y DNI
     *   Botón de acción con lógica de inserción
     * 
     * 
     */
    public AñadirCliente() {
        setLayout(null);
        
        JLabel lblAadirCliente = new JLabel("AÑADIR CLIENTE");
        lblAadirCliente.setHorizontalAlignment(SwingConstants.CENTER);
        lblAadirCliente.setForeground(Color.RED);
        lblAadirCliente.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
        lblAadirCliente.setBackground(Color.RED);
        lblAadirCliente.setBounds(373, 62, 210, 43);
        add(lblAadirCliente);
        
        JLabel lblNewLabel = new JLabel("Nombre");
        lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 20));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(148, 264, 120, 36);
        add(lblNewLabel);
        
        JLabel lblDni = new JLabel("DNI");
        lblDni.setHorizontalAlignment(SwingConstants.CENTER);
        lblDni.setFont(new Font("Stencil", Font.PLAIN, 20));
        lblDni.setBounds(459, 264, 120, 36);
        add(lblDni);
        
        txtNombre = new JTextField();
        txtNombre.setBounds(297, 273, 137, 20);
        add(txtNombre);
        txtNombre.setColumns(10);
        
        textFieldDNI = new JTextField();
        textFieldDNI.setColumns(10);
        textFieldDNI.setBounds(576, 273, 137, 20);
        add(textFieldDNI);
        
        JButton btnNewButton = new JButton("AÑADIR");
        btnNewButton.addActionListener(new ActionListener() {
            /**
             * Maneja el evento de clic en el botón "AÑADIR".
             * 
             * Realiza:
             * 
             *   Recoge datos de los campos de texto
             *   Muestra diálogo de confirmación
             *   Inserta el cliente mediante {@link controlador.BBDDmoviles#insertaCliente}
             *   Muestra feedback visual del resultado
             *   Limpia los campos
             * 
             * 
             * 
             * @param e Evento de acción generado por el botón
             */
            public void actionPerformed(ActionEvent e) {
                boolean correcto = false;
                Cliente c = new Cliente();
                c.setNombre(txtNombre.getText());
                c.setDni(textFieldDNI.getText());
                int valor = JOptionPane.showConfirmDialog(null, "¿Desea insertar un nuevo cliente?");
                if (valor == JOptionPane.OK_OPTION) {
                    BBDDmoviles b = new BBDDmoviles();
                    correcto = b.insertaCliente(c);
                    if (correcto) {
                        JOptionPane.showMessageDialog(null, "Insertado Correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error en insertar el cliente");
                    }
                }
                textFieldDNI.setText("");
                txtNombre.setText("");
            }
        });
        btnNewButton.setFont(new Font("Stencil", Font.PLAIN, 20));
        btnNewButton.setBounds(373, 461, 194, 87);
        add(btnNewButton);
    }
}