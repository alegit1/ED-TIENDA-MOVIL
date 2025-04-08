package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;

public class ConsultarMovil extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ConsultarMovil() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONSULTAR");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(234, 64, 363, 87);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Stencil", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(313, 162, 100, 52);
		add(lblNewLabel_1);
		
		JComboBox comboBoxID = new JComboBox();
		comboBoxID.setBounds(423, 178, 131, 22);
		add(comboBoxID);
		
		JLabel lblNewLabel_1_1 = new JLabel("MARCA");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Stencil", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(109, 276, 100, 52);
		add(lblNewLabel_1_1);
		
		JComboBox comboBoxID_1 = new JComboBox();
		comboBoxID_1.setBounds(207, 292, 131, 22);
		add(comboBoxID_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("MODELO");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Stencil", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(476, 273, 100, 52);
		add(lblNewLabel_1_2);
		
		JComboBox comboBoxID_2 = new JComboBox();
		comboBoxID_2.setBounds(591, 289, 131, 22);
		add(comboBoxID_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(207, 416, 529, 279);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

	}
}
