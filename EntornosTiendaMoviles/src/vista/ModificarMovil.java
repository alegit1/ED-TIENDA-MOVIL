package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controlador.BBDDmoviles;
import modelo.Cliente;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class ModificarMovil extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldmarca;
	private JTextField textFieldmodelo;
	private JTextField textFieldprecio;
	private JTextField textFieldcolor;
	private JTextField textFielddescripcion;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textmarcamodificar;
	private JTextField textmodelomodificar;
	private JTextField textFieldcapacidad;

	/**
	 * Create the panel.
	 */
	public ModificarMovil() {
		setLayout(null);

		JLabel lblNewLabel_7 = new JLabel("Capacidad");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(415, 415, 150, 30);
		add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Garantía");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(422, 476, 150, 30);
		add(lblNewLabel_8);
		
		JLabel lblNewLabel_6 = new JLabel("Descripción");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(415, 366, 150, 30);
		add(lblNewLabel_6);

		JLabel lblNewLabel_4 = new JLabel("Cantidad");
		lblNewLabel_4.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(415, 266, 150, 30);
		add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Color");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(415, 316, 150, 30);
		add(lblNewLabel_5);

		JLabel lblNewLabel_3 = new JLabel("Precio");
		lblNewLabel_3.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(415, 225, 150, 30);
		add(lblNewLabel_3);

		JLabel lblNewLabel_2 = new JLabel("Modelo");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(415, 184, 150, 30);
		add(lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("MODIFICAR Ó BORRAR");
		lblNewLabel.setBackground(new Color(255, 0, 0));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(508, 23, 210, 43);
		add(lblNewLabel);

		// Ajuste de tamaño y alineación uniforme para todos los JLabel
		JLabel lblNewLabel_1 = new JLabel("Marca del Móvil");
		lblNewLabel_1.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(415, 143, 150, 30);
		add(lblNewLabel_1);
		

		JLabel lblNewLabel_9 = new JLabel("Estado");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(415, 533, 150, 30);
		add(lblNewLabel_9);

		textFieldmarca = new JTextField();
		textFieldmarca.setBounds(615, 143, 203, 20);
		add(textFieldmarca);
		textFieldmarca.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // No se usa con JTextField
            }
        });
		textFieldmarca.setColumns(10);

		textFieldmodelo = new JTextField();
		textFieldmodelo.setBounds(615, 184, 203, 20);
		add(textFieldmodelo);
		textFieldmodelo.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // No se usa con JTextField
            }
        });
		textFieldmodelo.setColumns(10);

		textFieldprecio = new JTextField();
		textFieldprecio.setBounds(615, 225, 203, 20);
		add(textFieldprecio);
		textFieldprecio.setColumns(10);

		JSpinner spinnercantidad = new JSpinner();
		spinnercantidad.setBounds(615, 266, 81, 20);
		add(spinnercantidad);

		textFieldcolor = new JTextField();
		textFieldcolor.setColumns(10);
		textFieldcolor.setBounds(615, 316, 203, 20);
		add(textFieldcolor);

		textFielddescripcion = new JTextField();
		textFielddescripcion.setColumns(10);
		textFielddescripcion.setBounds(615, 366, 203, 20);
		add(textFielddescripcion);

		JRadioButton RadioButtonSI = new JRadioButton("SÍ");
		RadioButtonSI.setFont(new Font("Stencil", Font.PLAIN, 16));
		RadioButtonSI.setBounds(622, 476, 109, 23);
		add(RadioButtonSI);

		JRadioButton RadioButtonNO = new JRadioButton("NO");
		RadioButtonNO.setFont(new Font("Stencil", Font.PLAIN, 16));
		RadioButtonNO.setBounds(772, 476, 109, 23);
		add(RadioButtonNO);


		JRadioButton rdbNuevo = new JRadioButton("Nuevo");
		rdbNuevo.setFont(new Font("Stencil", Font.PLAIN, 16));
		rdbNuevo.setBounds(615, 533, 109, 23);
		add(rdbNuevo);

		JRadioButton rdbRenovado = new JRadioButton("Renovado");
		rdbRenovado.setFont(new Font("Stencil", Font.PLAIN, 16));
		rdbRenovado.setBounds(765, 533, 109, 23);
		add(rdbRenovado);

		JButton btnBorrar = new JButton("BORRAR");
		btnBorrar.setFont(new Font("Stencil", Font.PLAIN, 25));
		btnBorrar.setBounds(663, 608, 273, 43);
		add(btnBorrar);
		//hay que terminar la conexion entre los botones y hay que retocar;
		 /**
		JButton btnNewButton = new JButton("MODIFICAR");
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
		        
		
		        * 
		        */
		});
		btnNewButton.setFont(new Font("Stencil", Font.PLAIN, 25));
		btnNewButton.setBounds(335, 608, 273, 43);
		add(btnNewButton);
		
		JLabel lblIdDeLa = new JLabel("marca del movil a modificar modificar");
		lblIdDeLa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdDeLa.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		lblIdDeLa.setBounds(71, 100, 317, 14);
		add(lblIdDeLa);
		
		textmarcamodificar = new JTextField();
		textmarcamodificar.setColumns(10);
		textmarcamodificar.setBounds(398, 88, 206, 26);
		add(textmarcamodificar);
		
		JLabel lblNombreDelPais = new JLabel("modelo del movil a modificar");
		lblNombreDelPais.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreDelPais.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		lblNombreDelPais.setBounds(614, 99, 317, 14);
		add(lblNombreDelPais);
		
		textmodelomodificar = new JTextField();
		textmodelomodificar.setColumns(10);
		textmodelomodificar.setBounds(940, 87, 206, 26);
		add(textmodelomodificar);
		
		textFieldcapacidad = new JTextField();
		textFieldcapacidad.setColumns(10);
		textFieldcapacidad.setBounds(615, 419, 203, 20);
		add(textFieldcapacidad);

	}
		
	}

