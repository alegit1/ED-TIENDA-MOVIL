package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class Venta extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public Venta() {
		setLayout(null);
		
		JLabel lblVenta = new JLabel("VENTA");
		lblVenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblVenta.setForeground(Color.RED);
		lblVenta.setFont(new Font("Modern No. 20", Font.BOLD, 30));
		lblVenta.setBackground(Color.RED);
		lblVenta.setBounds(358, 61, 210, 43);
		add(lblVenta);
		
		JLabel lblNewLabel = new JLabel("ID ARTICULO");
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(246, 539, 195, 30);
		add(lblNewLabel);
		
		JLabel lblDniCliente = new JLabel("DNI CLIENTE");
		lblDniCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblDniCliente.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblDniCliente.setBounds(246, 603, 195, 30);
		add(lblDniCliente);
		
		JLabel lblCantidad = new JLabel("CANTIDAD");
		lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblCantidad.setBounds(246, 660, 195, 30);
		add(lblCantidad);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblEmail.setBounds(246, 723, 195, 30);
		add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(533, 545, 170, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(533, 609, 170, 20);
		add(textField_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(533, 666, 64, 20);
		add(spinner);
		
		JComboBox comboBoxID_1 = new JComboBox();
		comboBoxID_1.setBounds(242, 136, 131, 22);
		add(comboBoxID_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("MARCA");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Stencil", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(144, 120, 100, 52);
		add(lblNewLabel_1_1);
		
		JComboBox comboBoxID_2 = new JComboBox();
		comboBoxID_2.setBounds(626, 133, 131, 22);
		add(comboBoxID_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("MODELO");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Stencil", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(511, 117, 100, 52);
		add(lblNewLabel_1_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(246, 195, 529, 279);
		add(scrollPane);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("SI");
		rdbtnNewRadioButton.setBounds(533, 728, 109, 23);
		add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNo = new JRadioButton("NO");
		rdbtnNo.setBounds(666, 728, 109, 23);
		add(rdbtnNo);
		
		textField_2 = new JTextField();
		textField_2.setBounds(533, 794, 170, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("VENTA");
		btnNewButton.setFont(new Font("Stencil", Font.PLAIN, 20));
		btnNewButton.setBounds(460, 868, 151, 43);
		add(btnNewButton);

	}

}
