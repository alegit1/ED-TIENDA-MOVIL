package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Font;
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

	/**
	 * Create the panel.
	 */
	public ModificarMovil() {
		setLayout(null);

		JLabel lblNewLabel_7 = new JLabel("Capacidad");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(100, 400, 150, 30);
		add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Garantía");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(100, 450, 150, 30);
		add(lblNewLabel_8);
		
		JLabel lblNewLabel_6 = new JLabel("Descripción");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(100, 350, 150, 30);
		add(lblNewLabel_6);

		JLabel lblNewLabel_4 = new JLabel("Cantidad");
		lblNewLabel_4.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(100, 250, 150, 30);
		add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Color");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(100, 300, 150, 30);
		add(lblNewLabel_5);

		JLabel lblNewLabel_3 = new JLabel("Precio");
		lblNewLabel_3.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(100, 200, 150, 30);
		add(lblNewLabel_3);

		JLabel lblNewLabel_2 = new JLabel("Modelo");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(100, 150, 150, 30);
		add(lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("MODIFICAR Ó BORRAR");
		lblNewLabel.setBackground(new Color(255, 0, 0));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(338, 39, 210, 43);
		add(lblNewLabel);

		// Ajuste de tamaño y alineación uniforme para todos los JLabel
		JLabel lblNewLabel_1 = new JLabel("Marca del Móvil");
		lblNewLabel_1.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(100, 100, 150, 30);
		add(lblNewLabel_1);
		

		JLabel lblNewLabel_9 = new JLabel("Estado");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(100, 500, 150, 30);
		add(lblNewLabel_9);

		textFieldmarca = new JTextField();
		textFieldmarca.setBounds(300, 100, 203, 20);
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
		textFieldmodelo.setBounds(300, 150, 203, 20);
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
		textFieldprecio.setBounds(300, 200, 203, 20);
		add(textFieldprecio);
		textFieldprecio.setColumns(10);

		JSpinner spinnercantidad = new JSpinner();
		spinnercantidad.setBounds(300, 250, 81, 20);
		add(spinnercantidad);
		
		JSpinner spinnercapacidad = new JSpinner();
		spinnercapacidad.setBounds(300, 404, 81, 20);
		add(spinnercapacidad);

		textFieldcolor = new JTextField();
		textFieldcolor.setColumns(10);
		textFieldcolor.setBounds(300, 300, 203, 20);
		add(textFieldcolor);

		textFielddescripcion = new JTextField();
		textFielddescripcion.setColumns(10);
		textFielddescripcion.setBounds(300, 350, 203, 20);
		add(textFielddescripcion);

		JRadioButton RadioButtonSI = new JRadioButton("SÍ");
		RadioButtonSI.setFont(new Font("Stencil", Font.PLAIN, 16));
		RadioButtonSI.setBounds(300, 450, 109, 23);
		add(RadioButtonSI);

		JRadioButton RadioButtonNO = new JRadioButton("NO");
		RadioButtonNO.setFont(new Font("Stencil", Font.PLAIN, 16));
		RadioButtonNO.setBounds(450, 450, 109, 23);
		add(RadioButtonNO);


		JRadioButton rdbtnNuevo = new JRadioButton("Nuevo");
		rdbtnNuevo.setFont(new Font("Stencil", Font.PLAIN, 16));
		rdbtnNuevo.setBounds(300, 500, 109, 23);
		add(rdbtnNuevo);

		JRadioButton rdbtnRenovado = new JRadioButton("Renovado");
		rdbtnRenovado.setFont(new Font("Stencil", Font.PLAIN, 16));
		rdbtnRenovado.setBounds(450, 500, 109, 23);
		add(rdbtnRenovado);

		JButton btnNewButton = new JButton("MODIFICAR");
		btnNewButton.setFont(new Font("Stencil", Font.PLAIN, 25));
		btnNewButton.setBounds(102, 617, 273, 43);
		add(btnNewButton);

		JButton btnBorrar = new JButton("BORRAR");
		btnBorrar.setFont(new Font("Stencil", Font.PLAIN, 25));
		btnBorrar.setBounds(434, 617, 273, 43);
		add(btnBorrar);

		
	}
}
