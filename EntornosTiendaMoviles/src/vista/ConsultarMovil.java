package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controlador.BBDDmoviles;
import modelo.Cliente;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;


/**
 *ConsultarMovil que muestra un panel de interfaz gráfica para consultar los móviles disponibles en la base 
 *de datos.
 *En el panel, el usuario podra filtrar por marca y modelo y ver los resultados en una tabla.
 * @author rocki
 */
public class ConsultarMovil extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel modeloTabla;

	private ArrayList<Cliente> misClientes;
	private JComboBox comboBoxMarca;
	private JComboBox comboBoxModelo;

	/**
	 * Create the panel.
	 */
	public ConsultarMovil() {
		setLayout(null);
		modeloTabla = new DefaultTableModel();
		modeloTabla.setColumnIdentifiers(new Object[] {
				"Id", "Marca", "Modelo", "Precio", "Cantidad", "Color",
				"Descripcion", "Capacidad", "Garantia", "Tipo" 
				});

		JLabel lblNewLabel = new JLabel("CONSULTAR");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(234, 64, 363, 87);
		add(lblNewLabel);

		JLabel lblNewLabel_1_1 = new JLabel("MARCA");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Stencil", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(109, 276, 100, 52);
		add(lblNewLabel_1_1);

		comboBoxMarca = new JComboBox();
		cargaComboMarcaCompletos();
		comboBoxMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				BBDDmoviles bd = new BBDDmoviles();
				Object selectedItem = comboBoxMarca.getSelectedItem(); // ✅ Correcto

				if (selectedItem != null) { // Validar que no sea null
					String marcaseleccionada = selectedItem.toString();

					// Obtener los distritos del país seleccionado
					ArrayList<String> modelos = bd.consultaModeloPorMarca(marcaseleccionada);

					// Limpiar y actualizar el ComboBox de distritos
					comboBoxModelo.removeAllItems();
					if (modelos.isEmpty()) {
						comboBoxModelo.addItem("No hay modelos disponibles"); // Mensaje predeterminado
					} else {
						for (String modelo : modelos) {
							comboBoxModelo.addItem(modelo);
						}
					}

					// Cargar la tabla con datos filtrados por el país seleccionado
					misClientes = bd.consultaGeneralPorMarca(marcaseleccionada);
					cargarTabla();
				}

			}
		});
		comboBoxMarca.setBounds(207, 292, 131, 22);
		add(comboBoxMarca);

		JLabel lblNewLabel_1_2 = new JLabel("MODELO");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Stencil", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(476, 273, 100, 52);
		add(lblNewLabel_1_2);

		comboBoxModelo = new JComboBox();
		cargaComboModeloCompletos();
		comboBoxModelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object selectedItem = comboBoxModelo.getSelectedItem();
				BBDDmoviles bd = new BBDDmoviles();
					if (selectedItem != null) { // Validar que no sea null
						String modeloseleccionado = selectedItem.toString();
						if (!modeloseleccionado.equals("No hay distritos disponibles")) {
							misClientes = bd.consultaGeneralPorModelo(modeloseleccionado);
							cargarTabla();
						} else {
							// Si no hay distritos disponibles, limpiar la tabla
							misClientes.clear();
							cargarTabla();
						}
					}
				

			}
		});
		comboBoxModelo.setBounds(591, 289, 131, 22);
		add(comboBoxModelo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(207, 416, 529, 279);
		add(scrollPane);

		misClientes = new ArrayList<Cliente>();
		modeloTabla = new DefaultTableModel();
		modeloTabla.setColumnIdentifiers(new Object[] { "Id", "Marca", "Modelo", "Precio", "Cantidad", "Color",
				"Descripcion", "Capacidad", "Garantia", "Tipo" });

		table = new JTable(modeloTabla);

		scrollPane.setViewportView(table);

	}

	/**
	 * Carga las marcas disponibles en la base de datos en el comboBoxMarca.
	 */
	public void cargaComboMarcaCompletos() {
		ArrayList<String> arrStr = new ArrayList<>();
		BBDDmoviles bd = new BBDDmoviles();
		arrStr = bd.consultaCMBporMarca(); // Consultamos las marcas en la base de datos
		for (String st : arrStr) {
			comboBoxMarca.addItem(st); // Añadimos cada marca al ComboBox de marcas
		}
	}
	
	/**
	 * Carga los modelos disponibles en la base de datos en el comboBoxModelo.
	 */
	public void cargaComboModeloCompletos() {
		ArrayList<String> arrStr = new ArrayList<>();
		BBDDmoviles bd = new BBDDmoviles();
		arrStr = bd.consultaCMBporModelo(); // Consultamos las marcas en la base de datos
		for (String st : arrStr) {
			comboBoxModelo.addItem(st); // Añadimos cada marca al ComboBox de marcas
		}
	}

	/**
	 * Llena la tabla con los datos de los móviles almacenados en misClientes.
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

}
