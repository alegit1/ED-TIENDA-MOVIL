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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class ModificarMovil extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldMarca;
	private JTextField textFieldModelo;
	private JTextField textFieldPrecio2;
	private JTextField textFieldColor2;
	private JTextField textFieldDescripcion2;
	private JTextField textFieldCapacidad2;
	private static final String DB_URL = "jdbc:mysql://localhost/bd_telefono";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "";
	private ButtonGroup gRadioGarantia;
	private ButtonGroup gRadioEstado;
	private JRadioButton radioButtonSi2;
	private JRadioButton radioButtonNo2;
	private JRadioButton radioButtonNuevo2;
	private JRadioButton radioButtonRenovado2;
	private JSpinner spinnerCantidad2;

	private static final String x = "jdbc:mysql://localhost/bd_telefono";
	private static final String xx = "root";
	private static final String xxx = "";
	private JTextField textField_modelo2;
	private JTextField textField_Marca2;
	private JLabel lblColor_1;
	private JTextField textFieldColor1;
	private JButton btnNewButton;

	public ModificarMovil() {
		gRadioGarantia = new ButtonGroup();
		gRadioEstado = new ButtonGroup();

		setLayout(null);

		JLabel lblTitulo = new JLabel("MODIFICAR MÓVIL");
		lblTitulo.setForeground(Color.RED);
		lblTitulo.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(353, 22, 366, 43);
		add(lblTitulo);

		JLabel lblMarca = new JLabel("Marca del Móvil");
		lblMarca.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblMarca.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarca.setBounds(10, 86, 150, 30);
		add(lblMarca);

		textFieldMarca = new JTextField();
		textFieldMarca.setBounds(170, 90, 203, 20);
		add(textFieldMarca);
		textFieldMarca.setColumns(10);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblModelo.setHorizontalAlignment(SwingConstants.CENTER);
		lblModelo.setBounds(383, 86, 150, 30);
		add(lblModelo);

		textFieldModelo = new JTextField();
		textFieldModelo.setBounds(543, 90, 203, 20);
		add(textFieldModelo);
		textFieldModelo.setColumns(10);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio.setBounds(318, 192, 150, 30);
		add(lblPrecio);

		textFieldPrecio2 = new JTextField();
		textFieldPrecio2.setBounds(518, 196, 203, 20);
		add(textFieldPrecio2);
		textFieldPrecio2.setColumns(10);

		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad.setBounds(318, 232, 150, 30);
		add(lblCantidad);

		spinnerCantidad2 = new JSpinner();
		spinnerCantidad2.setBounds(518, 236, 81, 20);
		add(spinnerCantidad2);

		JLabel lblColor = new JLabel("Color");
		lblColor.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblColor.setHorizontalAlignment(SwingConstants.CENTER);
		lblColor.setBounds(318, 272, 150, 30);
		add(lblColor);

		textFieldColor2 = new JTextField();
		textFieldColor2.setBounds(518, 276, 203, 20);
		add(textFieldColor2);
		textFieldColor2.setColumns(10);

		JLabel lblDescripcion = new JLabel("Descripción");
		lblDescripcion.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripcion.setBounds(318, 312, 150, 30);
		add(lblDescripcion);

		textFieldDescripcion2 = new JTextField();
		textFieldDescripcion2.setBounds(518, 316, 203, 20);
		add(textFieldDescripcion2);
		textFieldDescripcion2.setColumns(10);

		JLabel lblCapacidad = new JLabel("Capacidad");
		lblCapacidad.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblCapacidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCapacidad.setBounds(318, 352, 150, 30);
		add(lblCapacidad);

		textFieldCapacidad2 = new JTextField();
		textFieldCapacidad2.setBounds(518, 356, 203, 20);
		add(textFieldCapacidad2);
		textFieldCapacidad2.setColumns(10);

		JLabel lblGarantia = new JLabel("Garantía");
		lblGarantia.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblGarantia.setHorizontalAlignment(SwingConstants.CENTER);
		lblGarantia.setBounds(318, 392, 150, 30);
		add(lblGarantia);

		radioButtonSi2 = new JRadioButton("SÍ");
		radioButtonSi2.setFont(new Font("Stencil", Font.PLAIN, 16));
		radioButtonSi2.setBounds(525, 396, 109, 23);
		radioButtonSi2.setSelected(true);
		add(radioButtonSi2);
		gRadioGarantia.add(radioButtonSi2);

		radioButtonNo2 = new JRadioButton("NO");
		radioButtonNo2.setFont(new Font("Stencil", Font.PLAIN, 16));
		radioButtonNo2.setBounds(675, 396, 109, 23);
		add(radioButtonNo2);
		gRadioGarantia.add(radioButtonNo2);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstado.setBounds(318, 432, 150, 30);
		add(lblEstado);

		radioButtonNuevo2 = new JRadioButton("Nuevo");
		radioButtonNuevo2.setFont(new Font("Stencil", Font.PLAIN, 16));
		radioButtonNuevo2.setBounds(518, 435, 109, 23);
		radioButtonNuevo2.setSelected(true);
		add(radioButtonNuevo2);
		gRadioEstado.add(radioButtonNuevo2);

		radioButtonRenovado2 = new JRadioButton("Renovado");
		radioButtonRenovado2.setFont(new Font("Stencil", Font.PLAIN, 16));
		radioButtonRenovado2.setBounds(647, 435, 137, 23);
		add(radioButtonRenovado2);
		gRadioEstado.add(radioButtonRenovado2);

		JButton btnBorrar_1 = new JButton("BORRAR");
		btnBorrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean acierto = false;
                BBDDmoviles b = new BBDDmoviles();
                Cliente cl = new Cliente();
				cl.setMarca(textField_Marca2.getText());
				cl.setModelo(textField_modelo2.getText());
				cl.setPrecio(Float.parseFloat(textFieldPrecio2.getText()));
				cl.setColor(textFieldColor2.getText());
				cl.setDescripcion(textFieldDescripcion2.getText());
				cl.setCapacidad(Integer.parseInt(textFieldCapacidad2.getText()));
				cl.setCantidad((Integer) spinnerCantidad2.getValue());
				
                int valor = JOptionPane.showConfirmDialog(null, "¿Seguro de eliminar la ciudad seleccionada?");
                if (valor == JOptionPane.OK_OPTION) {
                    acierto = b.borrarMovil(cl);
                }
                if (acierto) {
                    JOptionPane.showMessageDialog(null, "Ciudad eliminada.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar la ciudad seleccionada.");
                }
                limpiarcampos();
			}
		});
		btnBorrar_1.setFont(new Font("Stencil", Font.PLAIN, 25));
		btnBorrar_1.setBounds(123, 482, 273, 43);
		add(btnBorrar_1);

		JLabel lblModelo_2 = new JLabel("Modelo");
		lblModelo_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblModelo_2.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblModelo_2.setBounds(318, 154, 150, 30);
		add(lblModelo_2);

		textField_modelo2 = new JTextField();
		textField_modelo2.setColumns(10);
		textField_modelo2.setBounds(516, 154, 203, 20);
		add(textField_modelo2);

		JLabel lblMarca_2 = new JLabel("Marca del Móvil");
		lblMarca_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarca_2.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblMarca_2.setBounds(318, 121, 150, 30);
		add(lblMarca_2);

		textField_Marca2 = new JTextField();
		textField_Marca2.setColumns(10);
		textField_Marca2.setBounds(518, 125, 203, 20);
		add(textField_Marca2);

		lblColor_1 = new JLabel("Color");
		lblColor_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblColor_1.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblColor_1.setBounds(732, 86, 109, 30);
		add(lblColor_1);

		textFieldColor1 = new JTextField();
		textFieldColor1.setColumns(10);
		textFieldColor1.setBounds(851, 90, 98, 20);
		add(textFieldColor1);

		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean acierto = false;
				BBDDmoviles bd = new BBDDmoviles();
				Cliente c = new Cliente();
				c.setMarca(textField_Marca2.getText());
				c.setModelo(textField_modelo2.getText());
				c.setPrecio(Float.parseFloat(textFieldPrecio2.getText()));
				c.setColor(textFieldColor2.getText());
				c.setDescripcion(textFieldDescripcion2.getText());
				c.setCapacidad(Integer.parseInt(textFieldCapacidad2.getText()));
				c.setCantidad((Integer) spinnerCantidad2.getValue());

				// Comprobar la selección de los radio buttons "Garantía"
				if (radioButtonSi2.isSelected()) {
					c.setGarantia("si"); // Suponiendo que Cliente tiene un atributo booleano "garantia"
				} else if (radioButtonNo2.isSelected()) {
					c.setGarantia("no");
				}

				// Comprobar la selección de los radio buttons "Estado"
				if (radioButtonNuevo2.isSelected()) {
					c.setTipo("Nuevo");
				} else if (radioButtonRenovado2.isSelected()) {
					c.setTipo("Renovado");
				}


				int valor = JOptionPane.showConfirmDialog(null, "¿Desea modificar los datos de la ciudad?");
				if (valor == JOptionPane.OK_OPTION) {
					acierto = bd.modificaDatosMovil(c);
				}

				if (acierto) {
					JOptionPane.showMessageDialog(null, "Ciudad modificada correctamente.");
				} else {
					JOptionPane.showMessageDialog(null, "Error al modificar la ciudad.");
				}
				limpiarcampos();

			}
		});
		btnModificar.setFont(new Font("Stencil", Font.PLAIN, 25));
		btnModificar.setBounds(474, 482, 273, 43);
		add(btnModificar);
		
		btnNewButton = new JButton("buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarPorMarcaModeloColor();
			}
		});
		btnNewButton.setBounds(840, 120, 109, 30);
		add(btnNewButton);
	}

	public void limpiarcampos() {

		textField_modelo2.setText("");
		textField_Marca2.setText("");
		textFieldMarca.setText("");
		textFieldModelo.setText("");
		textFieldPrecio2.setText("");
		spinnerCantidad2.setValue(0);
		textFieldColor1.setText("");
		textFieldColor2.setText("");
		textFieldDescripcion2.setText("");
		textFieldCapacidad2.setText("");
		gRadioGarantia.clearSelection();
		gRadioEstado.clearSelection();

	}

	public void buscarPorMarcaModeloColor() {
		String nombreMarca = textFieldMarca.getText().trim();
		String nombreModelo = textFieldModelo.getText().trim();
		String nombreColor = textFieldColor1.getText().trim();

		BBDDmoviles bd = new BBDDmoviles();
		ArrayList<Cliente> resultado = bd.consultaGeneralPorMarcaModeloyColor(nombreMarca, nombreModelo, nombreColor);

		if (!resultado.isEmpty()) {
			Cliente c = resultado.get(0);

			textField_Marca2.setText(c.getMarca());
			textField_modelo2.setText(c.getModelo());
			textFieldPrecio2.setText(String.valueOf(c.getPrecio())); // Suponiendo que textFieldPrecio2 es un JTextField
			spinnerCantidad2.setValue(c.getCantidad()); // Suponiendo que es un JSpinner
			textFieldColor2.setText(c.getColor());
			textFieldDescripcion2.setText(c.getDescripcion());
			textFieldCapacidad2.setText(String.valueOf(c.getCapacidad()));

			if ("si".equalsIgnoreCase(c.getGarantia())) {
				radioButtonSi2.setSelected(true);
			} else {
				radioButtonNo2.setSelected(true);
			}

			if ("nuevo".equalsIgnoreCase(c.getTipo())) {
				radioButtonNuevo2.setSelected(true);
			} else {
				radioButtonRenovado2.setSelected(true);
			}
		} else {

			limpiarcampos();
			JOptionPane.showMessageDialog(null, "No se encontraron resultados con los criterios proporcionados.");
		}
	}
}
