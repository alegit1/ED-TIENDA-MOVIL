package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import controlador.BBDDmoviles;
import modelo.Cliente;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Panel gráfico para añadir nuevos clientes al sistema.
 * 
 * Proporciona una interfaz con campos para nombre y DNI, junto con un botón
 * para confirmar la inserción. Valida la operación con diálogos de confirmación
 * y muestra mensajes de éxito/error.
 * 
 * 
 * @author rocki y @author lazaro
 * @version 1.0
 * @see modelo.Cliente
 * @see controlador.BBDDmoviles
 */
public class AñadirCliente extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private JTextField txtCiudad;
	private JTextField txtCodigoPostal;
	private JTextField txtProvincia;
	private JTextField txtDNI;
	private JTextField txtLetraDNI;

	/**
	 * Constructor que inicializa los componentes gráficos del panel.
	 * 
	 * Crea: Etiquetas de título y campos Campos de texto para nombre y DNI Botón de
	 * acción con lógica de inserción
	 * 
	 */
	public AñadirCliente() {
		setLayout(null);

		JLabel lblInsertarCliente = new JLabel("Insertar Cliente");
		lblInsertarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertarCliente.setForeground(new Color(60, 60, 60));
		lblInsertarCliente.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblInsertarCliente.setBounds(262, 49, 300, 30);
		add(lblInsertarCliente);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setForeground(new Color(60, 60, 60));
		lblNombre.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNombre.setBounds(262, 109, 100, 25);
		add(lblNombre);

		JLabel lblDireccion = new JLabel("Dirección:");
		lblDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccion.setForeground(new Color(60, 60, 60));
		lblDireccion.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDireccion.setBounds(262, 149, 100, 25);
		add(lblDireccion);

		JLabel lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefono.setForeground(new Color(60, 60, 60));
		lblTelefono.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTelefono.setBounds(262, 189, 100, 25);
		add(lblTelefono);

		JLabel lblCorreo = new JLabel("Correo Electrónico:");
		lblCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCorreo.setForeground(new Color(60, 60, 60));
		lblCorreo.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCorreo.setBounds(222, 229, 140, 25);
		add(lblCorreo);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtNombre.setBounds(372, 109, 220, 25);
		add(txtNombre);

		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtDireccion.setBounds(372, 149, 220, 25);
		add(txtDireccion);

		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTelefono.setBounds(372, 189, 220, 25);
		add(txtTelefono);

		txtCorreo = new JTextField();
		txtCorreo.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtCorreo.setBounds(372, 229, 220, 25);
		add(txtCorreo);

		txtCiudad = new JTextField();
		txtCiudad.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtCiudad.setBounds(372, 385, 220, 25);
		add(txtCiudad);

		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCiudad.setForeground(new Color(60, 60, 60));
		lblCiudad.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCiudad.setBounds(222, 385, 140, 25);
		add(lblCiudad);

		JLabel lblCdigoPostal = new JLabel("Código Postal:");
		lblCdigoPostal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCdigoPostal.setForeground(new Color(60, 60, 60));
		lblCdigoPostal.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCdigoPostal.setBounds(214, 345, 148, 25);
		add(lblCdigoPostal);

		txtCodigoPostal = new JTextField();
		txtCodigoPostal.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtCodigoPostal.setBounds(372, 345, 220, 25);
		add(txtCodigoPostal);

		txtProvincia = new JTextField();
		txtProvincia.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtProvincia.setBounds(372, 305, 220, 25);
		add(txtProvincia);

		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProvincia.setForeground(new Color(60, 60, 60));
		lblProvincia.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblProvincia.setBounds(262, 305, 100, 25);
		add(lblProvincia);

		JLabel lblDni = new JLabel("DNI:");
		lblDni.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDni.setForeground(new Color(60, 60, 60));
		lblDni.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDni.setBounds(262, 265, 100, 25);
		add(lblDni);

		txtLetraDNI = new JTextField();
		txtLetraDNI.setHorizontalAlignment(SwingConstants.CENTER);
		txtLetraDNI.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtLetraDNI.setBounds(558, 265, 34, 25);
		txtLetraDNI.setEditable(false);
		add(txtLetraDNI);

		txtDNI = new JTextField();
		txtDNI.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtDNI.setBounds(372, 265, 179, 25);
		add(txtDNI);
		txtDNI.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				actualizarLetra();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				actualizarLetra();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				actualizarLetra();
			}
		});

		/**
		 * Maneja el evento de clic en el botón "AÑADIR".
		 * 
		 * Realiza:		 * 
		 * Recoge datos de los campos de texto Muestra diálogo de confirmación Inserta
		 * el cliente mediante {@link controlador.BBDDmoviles#insertaCliente} Muestra
		 * feedback visual del resultado Limpia los campos
		 * 
		 * @param e Evento de acción generado por el botón
		 */

		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.setForeground(Color.DARK_GRAY);
		btnInsertar.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnInsertar.setFocusPainted(false);
		btnInsertar.setBackground(new Color(30, 144, 255));
		btnInsertar.setBounds(335, 455, 160, 40);
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!controlamosTodosLosPosiblesErrores())
					return;

				int valor = JOptionPane.showConfirmDialog(null, "¿Desea insertar este cliente en la base de datos?");

				if (valor == JOptionPane.YES_OPTION) {
					Cliente nuevoCliente = crearCliente();
					insertarClienteEnBaseDeDatos(nuevoCliente);
					limpiarCampos();
				}
			}
		});

		add(btnInsertar);
	}

	public boolean controlamosTodosLosPosiblesErrores() {
		if (!camposCompletos())
			return false;
		if (!validarCorreo(txtCorreo.getText()))
			return false;
		if (!controlarNumeroMovil(txtTelefono.getText()))
			return false;
		if (!validarDNI(txtDNI.getText()))
			return false;
		if (!validarCodigoPostal(txtCodigoPostal.getText()))
			return false;
		return true;
	}

	public boolean camposCompletos() {
		if (txtNombre.getText().trim().isEmpty() || txtDNI.getText().trim().isEmpty()
				|| txtCorreo.getText().trim().isEmpty() || txtTelefono.getText().trim().isEmpty()
				|| txtDireccion.getText().trim().isEmpty() || txtCiudad.getText().trim().isEmpty()
				|| txtProvincia.getText().trim().isEmpty() || txtCodigoPostal.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Todos los campos deben estar completos.");
			return false;
		}
		return true;
	}

	public boolean validarCodigoPostal(String codigoPostal) {
		if (codigoPostal.length() != 5) {
			JOptionPane.showMessageDialog(null, "Introduzca un Código Postal válido");
			return false;
		}
		if (codigoPostal.contains(" ")) {
			JOptionPane.showMessageDialog(null, "El Código Postal no puede contener espacios en blanco");
			return false;
		}

		if (!controlarNumeroEntero(codigoPostal, "el código postal")) {
			return false;
		}

		return true;
	}
	
	public boolean validarDNI(String numerodni) {
		if (numerodni.length() != 8) {
			JOptionPane.showMessageDialog(null, "Introduzca un DNI válido");
			return false;
		}
		if (numerodni.contains(" ")) {
			JOptionPane.showMessageDialog(null, "El DNI no puede contener espacios en blanco");
			return false;
		}

		if (!controlarNumeroEntero(numerodni, "el DNI")) {
			return false;
		}
		if (!ExisteoNoEnBaseDeDatos(numerodni, "DNI")) {
			return false;
		}

		return true;
	}

	private boolean ExisteoNoEnBaseDeDatos(String numeroaComprobarSiExiste, String mensajeOpalabraClave) {
		BBDDmoviles bd = new BBDDmoviles();
		if (bd.existeOnoEnlaBaseDeDatos(numeroaComprobarSiExiste, mensajeOpalabraClave)) {
			mensajeparaMostrarSiExisteenBaseDeDatos(mensajeOpalabraClave);
			return false;
		}
		return true;
	}

	private void mensajeparaMostrarSiExisteenBaseDeDatos(String mensaje) {
		JOptionPane.showMessageDialog(null, "El " + mensaje + " ya existe en la base de datos.");
	}

	public boolean controlarNumeroMovil(String telefono) {
		if (telefono.length() < 9 || telefono.length() > 11) {
			JOptionPane.showMessageDialog(null, "Escriba un número de teléfono válido.");
			return false;
		}
		if (!controlarNumeroEntero(telefono, "el teléfono")) {
			return false;
		}
		if (!ExisteoNoEnBaseDeDatos(telefono, "telefono")) {
			return false;
		}

		return true;
	}

	public boolean controlarNumeroEntero(String numerito, String mensaje) {
		try {
			Long.parseLong(numerito); // usamos Long > INT (2.147.483.647)
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Por favor, " + mensaje + " solo debe contener números");
			return false;
		}
		return true;
	}

	public boolean validarCorreo(String correoaComprobar) {
		String cosasQueDebeContenerElCorreo = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

		if (correoaComprobar == null || !correoaComprobar.matches(cosasQueDebeContenerElCorreo)) {
			JOptionPane.showMessageDialog(null, "El correo electrónico no es válido.");
			return false;
		}

		if (correoaComprobar.contains(" ")) {
			JOptionPane.showMessageDialog(null, "El correo no puede contener espacios en blanco.");
			return false;
		}
		if (!ExisteoNoEnBaseDeDatos(correoaComprobar, "correo")) {
			return false;
		}

		return true;
	}

	private void actualizarLetra() {
		String dniTexto = txtDNI.getText().trim();
		// Aun que ya controlamos que sea solo numeros el campo del DNI, debemos hacer
		// un if para que en el "proceso" de escritura no haya errores.
		if (!dniTexto.matches("\\d+")) {// REcordemos que e
			txtLetraDNI.setText("");
			return;
		}

		try {
			int numero = Integer.parseInt(dniTexto);
			char letra = calcularLetraDNI(numero);
			txtLetraDNI.setText(String.valueOf(letra));
		} catch (NumberFormatException ex) {
			txtLetraDNI.setText(""); // En caso de fallo
		}
	}

	private char calcularLetraDNI(int numero) {
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		return letras.charAt(numero % 23);
	}

	private Cliente crearCliente() {
		Cliente c = new Cliente();
		c.setNombre(txtNombre.getText());
		c.setDni(txtDNI.getText());
		c.setCiudad(txtCiudad.getText());
		c.setCodigoPostal(txtCodigoPostal.getText());
		c.setCorreo(txtCorreo.getText());
		c.setDireccion(txtDireccion.getText());
		c.setProvincia(txtProvincia.getText());
		c.setTelefono(txtTelefono.getText());
		return c;
	}

	private void insertarClienteEnBaseDeDatos(Cliente nuevoCliente) {
		boolean correcto = false;
		BBDDmoviles b = new BBDDmoviles();
		correcto = b.insertaCliente(nuevoCliente);
		if (correcto) {
			JOptionPane.showMessageDialog(null, "Insertado Correctamente");
		} else {
			JOptionPane.showMessageDialog(null, "Error en insertar el cliente");
		}
	}

	public void limpiarCampos() {
		txtNombre.setText("");
		txtDNI.setText("");
		txtCiudad.setText("");
		txtCodigoPostal.setText("");
		txtCorreo.setText("");
		txtDireccion.setText("");
		txtProvincia.setText("");
		txtTelefono.setText("");
		txtLetraDNI.setText("");

	}
}
