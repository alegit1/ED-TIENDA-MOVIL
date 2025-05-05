package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import controlador.BBDDmoviles;
import modelo.Cliente;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;

/**
 * Clase PanelVenta que representa la interfaz gráfica del panel de ventas
 * de dispositivos móviles. Permite seleccionar marca y modelo, realizar ventas,
 * enviar correos, buscar clientes por DNI y mostrar artículos y clientes.
 * Hereda de JPanel.
 * @author rocki
 */

public class PanelVenta extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldArticulo;
	private JTextField textFieldCliente;
	private JTextField textFieldEmail;
	private ArrayList<Cliente> misClientes;
	private JComboBox comboBoxMarca;
	private JComboBox comboBoxModelo;
	private JTable tableCelulares;
	private DefaultTableModel modeloTabla;
	private DefaultTableModel modeloTablaClientes;
	private JTable tableClientes;
	private JTextField textFieldDNI;
	private JSpinner spinnercantidad;
	private JRadioButton rdbtnSi;
	private JRadioButton rdbtnNo;
	private ButtonGroup groupAfirmacion; 


	/**
	 * Create the panel.
	 */
	public PanelVenta() {
		setLayout(null);

		comboBoxMarca = new JComboBox();
		comboBoxModelo = new JComboBox();

		JLabel lblVenta = new JLabel("VENTA");
		lblVenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblVenta.setForeground(Color.RED);
		lblVenta.setFont(new Font("Modern No. 20", Font.BOLD, 30));
		lblVenta.setBackground(Color.RED);
		lblVenta.setBounds(584, 49, 210, 43);
		add(lblVenta);

		JLabel lblNewLabel = new JLabel("ID ARTICULO");
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(726, 153, 195, 30);
		add(lblNewLabel);

		JLabel lblIdCliente = new JLabel("ID CLIENTE");
		lblIdCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdCliente.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblIdCliente.setBounds(726, 217, 195, 30);
		add(lblIdCliente);

		JLabel lblCantidad = new JLabel("CANTIDAD");
		lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblCantidad.setBounds(726, 274, 195, 30);
		add(lblCantidad);

		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblEmail.setBounds(726, 337, 195, 30);
		add(lblEmail);

		textFieldArticulo = new JTextField();
		textFieldArticulo.setBounds(1013, 159, 170, 20);
		add(textFieldArticulo);
		textFieldArticulo.setColumns(10);

		textFieldCliente = new JTextField();
		textFieldCliente.setColumns(10);
		textFieldCliente.setBounds(1013, 223, 170, 20);
		add(textFieldCliente);

		spinnercantidad = new JSpinner();
		spinnercantidad.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinnercantidad.setBounds(1013, 280, 64, 20);
		add(spinnercantidad);

		comboBoxMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BBDDmoviles bd = new BBDDmoviles();
				Object selectedItem = comboBoxMarca.getSelectedItem();
				if (selectedItem != null) {
					String marcaseleccionada = selectedItem.toString();
					ArrayList<String> modelos = bd.consultaModeloPorMarca(marcaseleccionada);
					comboBoxModelo.removeAllItems();
					if (modelos.isEmpty()) {
						comboBoxModelo.addItem("No hay modelos disponibles");
					} else {
						for (String modelo : modelos) {
							comboBoxModelo.addItem(modelo);
						}
					}
					misClientes = bd.consultaGeneralPorMarca(marcaseleccionada);
					cargarTabla();
				}
			}
		});
		comboBoxMarca.setBounds(108, 134, 131, 22);
		add(comboBoxMarca);

		JLabel lblNewLabel_1_1 = new JLabel("MARCA");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Stencil", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(10, 118, 100, 52);
		add(lblNewLabel_1_1);

		comboBoxModelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object selectedItem = comboBoxModelo.getSelectedItem();
				BBDDmoviles bd = new BBDDmoviles();
				if (selectedItem != null) {
					String modeloseleccionado = selectedItem.toString();
					if (!modeloseleccionado.equals("No hay modelos disponibles")) {
						misClientes = bd.consultaGeneralPorModelo(modeloseleccionado);
						cargarTabla();
					} else {
						misClientes.clear();
						cargarTabla();
					}
				}
			}
		});
		comboBoxModelo.setBounds(492, 131, 131, 22);
		add(comboBoxModelo);

		JLabel lblNewLabel_1_2 = new JLabel("MODELO");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Stencil", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(377, 115, 100, 52);
		add(lblNewLabel_1_2);

		rdbtnSi = new JRadioButton("SI");
		rdbtnSi.setBounds(1013, 342, 109, 23);
		add(rdbtnSi);
		rdbtnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldEmail.setEnabled(true);
			}
		});

		rdbtnNo = new JRadioButton("NO");
		rdbtnNo.setBounds(1146, 342, 109, 23);
		add(rdbtnNo);
		rdbtnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldEmail.setEnabled(false);
				textFieldEmail.setText(""); // Opcional: también limpia el campo
			}
		});

		groupAfirmacion = new ButtonGroup(); // Lo declaramos como variablePrivada para que funcione en toda la clase 
		groupAfirmacion.add(rdbtnSi);
		groupAfirmacion.add(rdbtnNo);

		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(1013, 408, 170, 20);
		add(textFieldEmail);
		textFieldEmail.setColumns(10);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 499, 603, 216);
		add(scrollPane_1);
		modeloTablaClientes = new DefaultTableModel();
		modeloTablaClientes.setColumnIdentifiers(new Object[] { "Id", "DNI", "Nombre" });
		tableClientes = new JTable(modeloTablaClientes);
		scrollPane_1.setViewportView(tableClientes);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 181, 603, 228);
		add(scrollPane);
		modeloTabla = new DefaultTableModel();
		modeloTabla.setColumnIdentifiers(new Object[] { "Id", "Marca", "Modelo", "Precio", "Cantidad", "Color",
				"Descripcion", "Capacidad", "Garantia", "Tipo" });
		tableCelulares = new JTable(modeloTabla);
		scrollPane.setViewportView(tableCelulares);

		textFieldDNI = new JTextField();
		textFieldDNI.setBounds(306, 449, 131, 20);
		add(textFieldDNI);
		textFieldDNI.setColumns(10);

		// Agregar DocumentListener para búsqueda en tiempo real
		textFieldDNI.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				buscarCliente(); // Se ejecuta cuando el usuario escribe
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				buscarCliente(); // Se ejecuta cuando se borra texto
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// No se usa con JTextField
			}
		});

		JLabel lblNewLabel_1_1_1 = new JLabel("DNI");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(206, 429, 100, 52);
		add(lblNewLabel_1_1_1);

		JButton btnNewButton = new JButton("VENTA");
		btnNewButton.setFont(new Font("Stencil", Font.PLAIN, 20));
		btnNewButton.setBounds(940, 482, 151, 43);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(!controlamosEspaciosenBlanco()) {
					return;
				}
				realizarVenta();								
				limpiarCampos();

			}
		});
		add(btnNewButton);

		// Cargar combos al iniciar
		cargaComboMarcaCompletos();
		cargaComboModeloCompletos();
	}
	public void realizarVenta() {
		BBDDmoviles b = new BBDDmoviles();
		boolean positivo = false;
		boolean ventaprocesada = false;
		Cliente c = new Cliente();
		c.setIdArticulo(Integer.parseInt(textFieldArticulo.getText()));
		c.setIdCliente(Integer.parseInt(textFieldCliente.getText()));
		c.setCantidadVendidas((Integer) spinnercantidad.getValue());
		c.setCorreo(textFieldEmail.getText());
		if (rdbtnSi.isSelected()) {
			positivo = b.correo(c);
			if (positivo) {
				JOptionPane.showMessageDialog(null, "Correo enviado");
			} else {
				JOptionPane.showMessageDialog(null, "Error al enviar correo");
			}
		}  if (rdbtnNo.isSelected()) {
			//textFieldEmail.setEnabled(false); lo debemos hacer en un action 
		}
		ventaprocesada = b.procesarVenta(c);
		if (ventaprocesada) {
			JOptionPane.showMessageDialog(null, "Venta procesada correctamente y stock actualizado.");
		} else {
			JOptionPane.showMessageDialog(null,
					"Venta cancelada: no hay suficiente stock o el artículo no existe.");
		}
	}
	
	private boolean controlamosEspaciosenBlanco() {
		if (textFieldArticulo.getText().trim().isEmpty() || textFieldCliente.getText().trim().isEmpty()
				|| (!rdbtnSi.isSelected() && !rdbtnNo.isSelected())) {
			JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
			return false;
		}
		return true;
	}


	/**
	 * Realiza la búsqueda de un cliente por DNI y carga los resultados en la tabla de clientes.
	 */
	public void buscarCliente() {
	    String texto = textFieldDNI.getText().trim();
	    BBDDmoviles bd = new BBDDmoviles();
	    misClientes = bd.consultaGeneralPorDNI(texto); // Asegúrate de que esta consulta funcione
	    cargarTablaClientes(); // Carga los datos en la tabla de clientes
	}
	
	private void limpiarCampos() {
		textFieldArticulo.setText("");
		textFieldCliente.setText("");
		spinnercantidad.setValue(1);
		groupAfirmacion.clearSelection();
		textFieldEmail.setText("");
		textFieldEmail.setEnabled(true);
	}


	/**
	 *Carga todas las marcas disponibles en el comboBox de marcas. 
	 */
	public void cargaComboMarcaCompletos() {
		ArrayList<String> arrStr = new ArrayList<>();
		BBDDmoviles bd = new BBDDmoviles();
		arrStr = bd.consultaCMBporMarca();
		for (String st : arrStr) {
			comboBoxMarca.addItem(st);
		}
	}
	
	/**
	 * Carga todos los modelos disponibles en el comboBox de modelos.
	 */
	public void cargaComboModeloCompletos() {
		ArrayList<String> arrStr = new ArrayList<>();
		BBDDmoviles bd = new BBDDmoviles();
		arrStr = bd.consultaCMBporModelo();
		for (String st : arrStr) {
			comboBoxModelo.addItem(st);
		}
	}
	/**
	 * Carga en la tabla de celulares la información de los artículos móviles
	 * consultados por marca o modelo.
	 */

	public void cargarTabla() {
		modeloTabla.setRowCount(0);
		if (misClientes != null) {
			for (Cliente mo : misClientes) {
				modeloTabla.addRow(new Object[] { mo.getIdArticulo(), mo.getMarca(), mo.getModelo(), mo.getPrecio(),
						mo.getCantidad(), mo.getColor(), mo.getDescripcion(), mo.getCapacidad(), mo.getGarantia(),
						mo.getTipo() });
			}
		}
	}
	/**
	 * Carga en la tabla de clientes los datos del cliente encontrado por DNI
	 */
	public void cargarTablaClientes() {
	    modeloTablaClientes.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos
	    if (misClientes != null) {
	        for (Cliente mo : misClientes) {
	            modeloTablaClientes.addRow(new Object[] { 
	                mo.getIdCliente(), 
	                mo.getDni(), 
	                mo.getNombre() 
	            });
	        }
	    }
	}
}