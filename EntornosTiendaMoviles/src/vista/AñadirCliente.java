package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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
	private JTextField txtDNI;
	private JTextField txtLetraDelDni;

	/**
	 * Constructor que inicializa los componentes gráficos del panel.
	 * 
	 * Crea:
	 * 
	 * Etiquetas de título y campos Campos de texto para nombre y DNI Botón de
	 * acción con lógica de inserción
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

		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		txtDNI.setBounds(576, 273, 137, 20);
		add(txtDNI);
		txtDNI.getDocument().addDocumentListener(new DocumentListener() {
		    
			@Override
		    public void insertUpdate(DocumentEvent e) {
		        actualizarLetra();
		    }

		    @Override
		    public void removeUpdate(DocumentEvent e) {
		        actualizarLetra();
		    }

		    @Override
		    public void changedUpdate(DocumentEvent e) {
		        actualizarLetra();
		    }
		});

		JButton btnNewButton = new JButton("AÑADIR");
		btnNewButton.addActionListener(new ActionListener() {
			/**
			 * Maneja el evento de clic en el botón "AÑADIR".
			 * 
			 * Realiza:
			 * 
			 * Recoge datos de los campos de texto Muestra diálogo de confirmación Inserta
			 * el cliente mediante {@link controlador.BBDDmoviles#insertaCliente} Muestra
			 * feedback visual del resultado Limpia los campos
			 * 
			 * 
			 * 
			 * @param e Evento de acción generado por el botón
			 */
			public void actionPerformed(ActionEvent e) {
				if (!controlamosEspaciosenBlanco()) {
					return;
				}

				Cliente nuevoCliente = crearCliente();
				insertarClienteEnBaseDeDatos(nuevoCliente);

				limpiarCampos();
			}
		});
		btnNewButton.setFont(new Font("Stencil", Font.PLAIN, 20));
		btnNewButton.setBounds(373, 461, 194, 87);
		add(btnNewButton);
		
		txtLetraDelDni = new JTextField();
		txtLetraDelDni.setColumns(10);
		txtLetraDelDni.setBounds(723, 273, 30, 20);
		add(txtLetraDelDni);
	}

	public boolean controlamosEspaciosenBlanco() {
		if (txtNombre.getText().isEmpty() || txtDNI.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Todos los campos deben estar completos.");
			return false;
		}
		
		if (txtDNI.getText().trim().length() != 8 ) {
	        JOptionPane.showMessageDialog(null, "Introduzca un DNI válido");
	        return false;
	    }

		String dni = txtDNI.getText().trim();
	    try {
	        Long.parseLong(dni); // usamos Long > INT (2.147.483.647)
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "El número de DNI solo debe contener números.");
	        return false;
	    }
		
		return true;
	}

	private void actualizarLetra() {
        String textoDni = txtDNI.getText().trim();
        if (textoDni.matches("\\d{8}")) {
            int numeroDNI = Integer.parseInt(textoDni);
            char letra = calcularLetraDNI(numeroDNI);
            txtLetraDelDni.setText(String.valueOf(letra));
        } else {
            txtLetraDelDni.setText("");
        }
    }
	private char calcularLetraDNI(int numero) {
	    String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
	    return letras.charAt(numero % 23);
	}

	private Cliente crearCliente() {
		Cliente c = new Cliente();
		c.setNombre(txtNombre.getText());
		c.setDni(txtDNI.getText());
		return c;
	}

	private void insertarClienteEnBaseDeDatos(Cliente nuevoCliente) {
		boolean correcto = false;
		int valor = JOptionPane.showConfirmDialog(null, "¿Desea insertar un nuevo cliente?");
		if (valor == JOptionPane.OK_OPTION) {
			BBDDmoviles b = new BBDDmoviles();
			correcto = b.insertaCliente(nuevoCliente);
			if (correcto) {
				JOptionPane.showMessageDialog(null, "Insertado Correctamente");
			} else {
				JOptionPane.showMessageDialog(null, "Error en insertar el cliente");
			}
		}
	}

	public void limpiarCampos() {
		txtNombre.setText("");
		txtDNI.setText("");
	}
}