package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import controlador.BBDDmoviles;
import modelo.Cliente;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertarMovil extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldmarca;
	private JTextField textFieldmodelo;
	private JTextField textFieldprecio;
	private JTextField textFieldcolor;
	private JTextField textFielddescripcion;
	private JTextField textFieldcapacidad;

	/**
	 * Create the panel.
	 */
	public InsertarMovil() {
		setLayout(null);

		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("Garantía");
		lblNewLabel_4_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1_1_1.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblNewLabel_4_1_1_1_1.setBounds(683, 462, 194, 26);
		add(lblNewLabel_4_1_1_1_1);

		JLabel lblNewLabel_4_1_1_1 = new JLabel("Capacidad del Móvil");
		lblNewLabel_4_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1_1.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblNewLabel_4_1_1_1.setBounds(669, 422, 194, 14);
		add(lblNewLabel_4_1_1_1);

		JLabel lblNewLabel_4_1_1 = new JLabel("Descripcion");
		lblNewLabel_4_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblNewLabel_4_1_1.setBounds(756, 372, 107, 14);
		add(lblNewLabel_4_1_1);
		JLabel lblNewLabel_4 = new JLabel("Cantidad");
		lblNewLabel_4.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(756, 273, 107, 14);
		add(lblNewLabel_4);

		JLabel lblNewLabel_4_1 = new JLabel("Color");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblNewLabel_4_1.setBounds(756, 327, 107, 14);
		add(lblNewLabel_4_1);
		JLabel lblNewLabel_3 = new JLabel("Precio");
		lblNewLabel_3.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(749, 228, 125, 14);
		add(lblNewLabel_3);

		JLabel lblNewLabel_2 = new JLabel("Modelo");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(756, 180, 118, 14);
		add(lblNewLabel_2);

		JLabel lblNewLabelEstado = new JLabel("Estado");
		lblNewLabelEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelEstado.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblNewLabelEstado.setBounds(683, 499, 194, 26);
		add(lblNewLabelEstado);

		JLabel lblNewLabel = new JLabel("INSERTAR");
		lblNewLabel.setBackground(new Color(255, 0, 0));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Britannic Bold", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(877, 65, 210, 43);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Marca del Móvil");
		lblNewLabel_1.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(683, 138, 203, 31);
		add(lblNewLabel_1);

		textFieldmarca = new JTextField();
		textFieldmarca.setBounds(884, 143, 203, 20);
		add(textFieldmarca);
		textFieldmarca.setColumns(10);

		textFieldmodelo = new JTextField();
		textFieldmodelo.setBounds(884, 176, 203, 20);
		add(textFieldmodelo);
		textFieldmodelo.setColumns(10);

		textFieldprecio = new JTextField();
		textFieldprecio.setBounds(884, 224, 203, 20);
		add(textFieldprecio);
		textFieldprecio.setColumns(10);

		JSpinner spinnercantidad = new JSpinner();
		spinnercantidad.setBounds(884, 269, 81, 20);
		add(spinnercantidad);

		textFieldcolor = new JTextField();
		textFieldcolor.setColumns(10);
		textFieldcolor.setBounds(884, 323, 203, 20);
		add(textFieldcolor);

		textFielddescripcion = new JTextField();
		textFielddescripcion.setColumns(10);
		textFielddescripcion.setBounds(884, 368, 203, 20);
		add(textFielddescripcion);

		textFieldcapacidad = new JTextField();
		textFieldcapacidad.setColumns(10);
		textFieldcapacidad.setBounds(884, 418, 203, 20);
		add(textFieldcapacidad);

		// Botones de radio con ButtonGroup para "Garantía"
		JRadioButton RadioButtonSI = new JRadioButton("SÍ");
		RadioButtonSI.setFont(new Font("Stencil", Font.PLAIN, 16));
		RadioButtonSI.setBounds(894, 463, 109, 23);
		add(RadioButtonSI);

		JRadioButton RadioButtonNO = new JRadioButton("NO");
		RadioButtonNO.setFont(new Font("Stencil", Font.PLAIN, 16));
		RadioButtonNO.setBounds(1052, 463, 109, 23);
		add(RadioButtonNO);

		ButtonGroup groupGarantia = new ButtonGroup();
		groupGarantia.add(RadioButtonSI);
		groupGarantia.add(RadioButtonNO);

		// Botones de radio con ButtonGroup para "Estado"
		JRadioButton rdbtnNuevo = new JRadioButton("Nuevo");
		rdbtnNuevo.setFont(new Font("Stencil", Font.PLAIN, 16));
		rdbtnNuevo.setBounds(894, 499, 109, 23);
		add(rdbtnNuevo);

		JRadioButton rdbtnRenovado = new JRadioButton("Renovado");
		rdbtnRenovado.setFont(new Font("Stencil", Font.PLAIN, 16));
		rdbtnRenovado.setBounds(1052, 499, 109, 23);
		add(rdbtnRenovado);

		ButtonGroup groupEstado = new ButtonGroup();
		groupEstado.add(rdbtnNuevo);
		groupEstado.add(rdbtnRenovado);

		JButton btnNewButton = new JButton("INSERTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean correcto = false;
				Cliente c = new Cliente();
				c.setMarca(textFieldmarca.getText());
				c.setModelo(textFieldmodelo.getText());
				c.setPrecio(Float.parseFloat(textFieldprecio.getText()));
				c.setColor(textFieldcolor.getText());
				c.setDescripcion(textFielddescripcion.getText());
				c.setCapacidad(Integer.parseInt(textFieldcapacidad.getText()));
				c.setCantidad((Integer) spinnercantidad.getValue());

				// Comprobar la selección de los radio buttons "Garantía"
				if (RadioButtonSI.isSelected()) {
					c.setGarantia("si"); // Suponiendo que Cliente tiene un atributo booleano "garantia"
				} else if (RadioButtonNO.isSelected()) {
					c.setGarantia("no");
				}

				// Comprobar la selección de los radio buttons "Estado"
				if (rdbtnNuevo.isSelected()) {
					c.setTipo("Nuevo");
				} else if (rdbtnRenovado.isSelected()) {
					c.setTipo("Renovado");
				}

				int valor = JOptionPane.showConfirmDialog(null, "¿Desea insertar un nuevo Movil?");
				if (valor == JOptionPane.OK_OPTION) {
					BBDDmoviles b = new BBDDmoviles();
					correcto = b.insertaDatos(c);
					if (correcto) {
						JOptionPane.showMessageDialog(null, "Insertado Correctamente");
					} else {
						JOptionPane.showMessageDialog(null, "Error en insertar el Movil");
					}
				}
				textFieldmarca.setText("");
				textFieldmodelo.setText("");
				textFieldcolor.setText("");
				textFielddescripcion.setText("");
				spinnercantidad.setValue(0);
				textFieldprecio.setText("");
				textFieldcapacidad.setText("");
				// Limpiar las selecciones de los radio buttons
		        groupGarantia.clearSelection(); // Desmarcar el grupo de "Garantía"
		        groupEstado.clearSelection(); // Desmarcar el grupo de "Estado"
			}
		});
		btnNewButton.setFont(new Font("Stencil", Font.PLAIN, 25));
		btnNewButton.setBounds(870, 643, 273, 43);
		add(btnNewButton);

	}

}
