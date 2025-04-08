package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class ConsultarInformacionVenta extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ConsultarInformacionVenta() {
		setLayout(null);
		
		JLabel lblTicketes = new JLabel("INFORMACION DE VENTAS");
		lblTicketes.setHorizontalAlignment(SwingConstants.CENTER);
		lblTicketes.setForeground(Color.RED);
		lblTicketes.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		lblTicketes.setBackground(Color.RED);
		lblTicketes.setBounds(272, 66, 390, 43);
		add(lblTicketes);
		
		JLabel lblNewLabel_1 = new JLabel("DNI");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Stencil", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(177, 170, 100, 52);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("DATE");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Stencil", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(517, 170, 100, 52);
		add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(308, 187, 131, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(627, 187, 131, 20);
		add(textField_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(208, 284, 568, 345);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("BUSCAR");
		btnNewButton.setFont(new Font("Stencil", Font.PLAIN, 20));
		btnNewButton.setBounds(407, 684, 174, 43);
		add(btnNewButton);

	}

}
