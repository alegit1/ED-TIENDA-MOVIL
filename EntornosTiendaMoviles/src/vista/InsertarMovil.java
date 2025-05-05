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
import javax.swing.SpinnerNumberModel;


/**
 * Clase que representa un panel para insertar nuevos móviles en el sistema.
 * Proporciona una interfaz gráfica con campos para introducir los datos del móvil
 * y botones para confirmar la inserción.
 * 
 * @author lazaro y @author rocki
 * @version 1.0
 */
public class InsertarMovil extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldmarca;
	private JTextField textFieldmodelo;
	private JTextField textFieldprecio;
	private JTextField textFieldcolor;
	private JTextField textFielddescripcion;
	private JTextField textFieldcapacidad;
	private JRadioButton radioButtonSI;
	private JRadioButton radioButtonNO;
	private JRadioButton rdbtnNuevo;
	private JRadioButton rdbtnRenovado;
	private JSpinner spinnercantidad;
	private JButton btnNewButton;


	/**
     * Constructor que inicializa los componentes de la interfaz gráfica.
     * Crea y organiza los campos de texto, etiquetas, botones de radio
     * y el botón de inserción.
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

		spinnercantidad = new JSpinner();
		spinnercantidad.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
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
		radioButtonSI = new JRadioButton("SÍ");
		radioButtonSI.setFont(new Font("Stencil", Font.PLAIN, 16));
		radioButtonSI.setBounds(894, 463, 109, 23);
		add(radioButtonSI);

		radioButtonNO = new JRadioButton("NO");
		radioButtonNO.setFont(new Font("Stencil", Font.PLAIN, 16));
		radioButtonNO.setBounds(1052, 463, 109, 23);
		add(radioButtonNO);

		ButtonGroup groupGarantia = new ButtonGroup();
		groupGarantia.add(radioButtonSI);
		groupGarantia.add(radioButtonNO);

		rdbtnNuevo = new JRadioButton("Nuevo");
		rdbtnNuevo.setFont(new Font("Stencil", Font.PLAIN, 16));
		rdbtnNuevo.setBounds(894, 499, 109, 23);
		add(rdbtnNuevo);

		rdbtnRenovado = new JRadioButton("Renovado");
		rdbtnRenovado.setFont(new Font("Stencil", Font.PLAIN, 16));
		rdbtnRenovado.setBounds(1052, 499, 109, 23);
		add(rdbtnRenovado);

		ButtonGroup groupEstado = new ButtonGroup();
		groupEstado.add(rdbtnNuevo);
		groupEstado.add(rdbtnRenovado);

		/**
         * Método que se ejecuta al hacer clic en el botón INSERTAR.
         * Recoge los datos de los campos, valida las selecciones de radio botones,
         * muestra un diálogo de confirmación y realiza la inserción en la base de datos.
         * 
         * @param e Evento de acción que desencadena el método
         */
		btnNewButton = new JButton("INSERTAR");		
		btnNewButton.setFont(new Font("Stencil", Font.PLAIN, 25));
		btnNewButton.setBounds(870, 643, 273, 43);		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!controlamosEspaciosenBlanco()) {
					return;
				}
				
				Cliente insertarMovil = crearMovil();
				insertarMovilEnBaseDeDatos(insertarMovil);

				limpiarCampos();
		        groupGarantia.clearSelection(); 
		        groupEstado.clearSelection(); 
			}
		});
		add(btnNewButton);

	}
	
	public boolean controlamosEspaciosenBlanco() {
		if (textFieldmarca.getText().isEmpty() || textFieldmodelo.getText().trim().isEmpty() ||
				textFieldprecio.getText().isEmpty() || textFieldcolor.getText().trim().isEmpty() || 	
				textFielddescripcion.getText().isEmpty() || textFieldcapacidad.getText().trim().isEmpty() 	
				) {
			JOptionPane.showMessageDialog(null, "Todos los campos deben estar completos.");
			return false;
		}
		
		try {
			int capacidad = Integer.parseInt(textFieldcapacidad.getText().trim());
			float precio = Float.parseFloat(textFieldprecio.getText());
			if (capacidad <= 0) {
				JOptionPane.showMessageDialog(null, "Introduzca una capacidad válida (mayor a 0).");
				return false;
			}
			if (precio <= 0) {
				JOptionPane.showMessageDialog(null, "Introduzca una precio válido (mayor a 0).");
				return false;
			}
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "La capacidad y el precio deben ser números válidos.");
			return false;
		}
		
		if (!radioButtonSI.isSelected() && !radioButtonNO.isSelected()) {
			JOptionPane.showMessageDialog(null, "Seleccione una opción de garantía.");
			return false;
		}

		if (!rdbtnNuevo.isSelected() && !rdbtnRenovado.isSelected()) {
			JOptionPane.showMessageDialog(null, "Seleccione una opción de estado (Nuevo o Renovado).");
			return false;
		}
		
		return true;
	}

	private Cliente crearMovil() {
		Cliente c = new Cliente();
		c.setMarca(textFieldmarca.getText());
		c.setModelo(textFieldmodelo.getText());
		c.setPrecio(Float.parseFloat(textFieldprecio.getText()));
		c.setColor(textFieldcolor.getText());
		c.setDescripcion(textFielddescripcion.getText());
		c.setCapacidad(Integer.parseInt(textFieldcapacidad.getText()));
		c.setCantidad((Integer) spinnercantidad.getValue());

		if (radioButtonSI.isSelected()) {
			c.setGarantia("si"); 
		} else if (radioButtonNO.isSelected()) {
			c.setGarantia("no");
		}

		if (rdbtnNuevo.isSelected()) {
			c.setTipo("Nuevo");
		} else if (rdbtnRenovado.isSelected()) {
			c.setTipo("Renovado");
		}
		return c;
	}
	
	private void insertarMovilEnBaseDeDatos(Cliente nuevoCliente) {
		boolean correcto = false;
		int valor = JOptionPane.showConfirmDialog(null, "¿Desea insertar un nuevo Movil?");
		if (valor == JOptionPane.OK_OPTION) {
			BBDDmoviles b = new BBDDmoviles();
			correcto = b.insertaDatos(nuevoCliente);
			if (correcto) {
				JOptionPane.showMessageDialog(null, "Insertado Correctamente");
			} else {
				JOptionPane.showMessageDialog(null, "Error en insertar el Movil");
			}
		}
	}
	public void limpiarCampos() {
		textFieldmarca.setText("");
		textFieldmodelo.setText("");
		textFieldcolor.setText("");
		textFielddescripcion.setText("");
		spinnercantidad.setValue(0);
		textFieldprecio.setText("");
		textFieldcapacidad.setText("");
	}

}
