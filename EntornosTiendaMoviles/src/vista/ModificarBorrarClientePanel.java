package vista;

import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import controlador.BBDDmoviles;
import modelo.Cliente;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ModificarBorrarClientePanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTextField txtNuevoNombre;
    private JTextField txtNuevaDireccion;
    private JTextField txtNuevoTelefonoNumber;
    private JTextField txtNuevaCorreoElectronico;
    private JTextField txtNombreBuscarParaCambiar;
    private JTextField txtTelefonoBuscarParaCambiar;
    private int nombreSeleccionadoId = -1; // -1 indica que no hay ningun nombre seleccionado
    private JTextField txtNuevoCodigoPostal;
    private JTextField txtNuevaPrivincia;
    private JTextField txtNuevoDNI;
    private JTextField txtNuevaCiudad;

    public ModificarBorrarClientePanel() {
        setLayout(null);

        JLabel lblIdDeLa = new JLabel("Nombre del cliente :");
        lblIdDeLa.setHorizontalAlignment(SwingConstants.RIGHT);
        lblIdDeLa.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
        lblIdDeLa.setBounds(37, 183, 167, 14);
        add(lblIdDeLa);

        JLabel lblNuevoNombre = new JLabel("Nuevo Nombre");
        lblNuevoNombre.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNuevoNombre.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
        lblNuevoNombre.setBounds(118, 299, 257, 14);
        add(lblNuevoNombre);

        JLabel lblNuevoCodigoDe = new JLabel("Nueva Dirección");
        lblNuevoCodigoDe.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNuevoCodigoDe.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
        lblNuevoCodigoDe.setBounds(118, 345, 257, 18);
        add(lblNuevoCodigoDe);

        JLabel lblNuevoDistrito = new JLabel("Nuevo Teléfono");
        lblNuevoDistrito.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNuevoDistrito.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
        lblNuevoDistrito.setBounds(118, 381, 257, 14);
        add(lblNuevoDistrito);

        JLabel lblNuevaPoblacin = new JLabel("Nuevo Correo Electronico");
        lblNuevaPoblacin.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNuevaPoblacin.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
        lblNuevaPoblacin.setBounds(118, 424, 257, 14);
        add(lblNuevaPoblacin);

        JLabel lblNombreDelPais = new JLabel("Teléfono del cliente:");
        lblNombreDelPais.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNombreDelPais.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
        lblNombreDelPais.setBounds(418, 183, 160, 14);
        add(lblNombreDelPais);

        JLabel lblNewLabel = new JLabel("Datos a modificar o borrar:");
        lblNewLabel.setFont(new Font("Sitka Text", Font.PLAIN, 22));
        lblNewLabel.setBounds(285, 233, 309, 45);
        add(lblNewLabel);

        JLabel lblIntroduceLosDatos = new JLabel("Introduce los datos para buscar al cliente:");
        lblIntroduceLosDatos.setFont(new Font("Sitka Text", Font.PLAIN, 22));
        lblIntroduceLosDatos.setBounds(210, 93, 441, 45);
        add(lblIntroduceLosDatos);

        JLabel lblModificarOBorrar = new JLabel("Modificar o Borrar Cliente");
        lblModificarOBorrar.setHorizontalAlignment(SwingConstants.CENTER);
        lblModificarOBorrar.setFont(new Font("Segoe UI Black", Font.ITALIC, 17));
        lblModificarOBorrar.setBounds(225, 24, 384, 45);
        add(lblModificarOBorrar);

        txtNuevoNombre = new JTextField();
        txtNuevoNombre.setColumns(10);
        txtNuevoNombre.setBounds(408, 289, 206, 26);
        add(txtNuevoNombre);

        txtNuevaDireccion = new JTextField();
        txtNuevaDireccion.setColumns(10);
        txtNuevaDireccion.setBounds(408, 335, 206, 26);
        add(txtNuevaDireccion);

        txtNuevoTelefonoNumber = new JTextField();
        txtNuevoTelefonoNumber.setColumns(10);
        txtNuevoTelefonoNumber.setBounds(408, 374, 206, 26);
        add(txtNuevoTelefonoNumber);

        txtNuevaCorreoElectronico = new JTextField();
        txtNuevaCorreoElectronico.setColumns(10);
        txtNuevaCorreoElectronico.setBounds(408, 417, 206, 26);
        add(txtNuevaCorreoElectronico);

        txtNombreBuscarParaCambiar = new JTextField();
        txtNombreBuscarParaCambiar.setColumns(10);
        txtNombreBuscarParaCambiar.setBounds(214, 173, 160, 26);
        add(txtNombreBuscarParaCambiar);

        txtNombreBuscarParaCambiar.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                buscarClientePorNombreyTelefono();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                buscarClientePorNombreyTelefono();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // No se usa con JTextField
            }
        });

        txtTelefonoBuscarParaCambiar = new JTextField();
        txtTelefonoBuscarParaCambiar.setColumns(10);
        txtTelefonoBuscarParaCambiar.setBounds(588, 173, 173, 26);
        add(txtTelefonoBuscarParaCambiar);
        txtTelefonoBuscarParaCambiar.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                buscarClientePorNombreyTelefono();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                buscarClientePorNombreyTelefono();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // No se usa con JTextField
            }
        });

        
        txtNuevoCodigoPostal = new JTextField();
        txtNuevoCodigoPostal.setColumns(10);
        txtNuevoCodigoPostal.setBounds(408, 582, 206, 26);
        add(txtNuevoCodigoPostal);
        
        JLabel lblNuevoCodigoPostal = new JLabel("Nuevo Codigo Postal");
        lblNuevoCodigoPostal.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNuevoCodigoPostal.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
        lblNuevoCodigoPostal.setBounds(118, 589, 257, 14);
        add(lblNuevoCodigoPostal);
        
        JLabel lblNuevaProvincia = new JLabel("Nueva Provincia");
        lblNuevaProvincia.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNuevaProvincia.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
        lblNuevaProvincia.setBounds(118, 546, 257, 14);
        add(lblNuevaProvincia);
        
        txtNuevaPrivincia = new JTextField();
        txtNuevaPrivincia.setColumns(10);
        txtNuevaPrivincia.setBounds(408, 539, 206, 26);
        add(txtNuevaPrivincia);
        
        txtNuevoDNI = new JTextField();
        txtNuevoDNI.setColumns(10);
        txtNuevoDNI.setBounds(408, 500, 206, 26);
        add(txtNuevoDNI);
        
        JLabel lblNuevoDni = new JLabel("Nuevo DNI");
        lblNuevoDni.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNuevoDni.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
        lblNuevoDni.setBounds(118, 510, 257, 18);
        add(lblNuevoDni);
        
        JLabel lblNuevaCiudad = new JLabel("Nuevo Ciudad");
        lblNuevaCiudad.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNuevaCiudad.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
        lblNuevaCiudad.setBounds(118, 464, 257, 14);
        add(lblNuevaCiudad);
        
        txtNuevaCiudad = new JTextField();
        txtNuevaCiudad.setColumns(10);
        txtNuevaCiudad.setBounds(408, 454, 206, 26);
        add(txtNuevaCiudad);
        
        JButton btnModificar = new JButton("Modificar");
        btnModificar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 16));
        btnModificar.setBounds(285, 654, 123, 32);
        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {            	
                controlamoscosas();

                Boolean acierto = false;
                BBDDmoviles bd = new BBDDmoviles();
                Cliente c = new Cliente();
                c.setIdCliente(nombreSeleccionadoId);
                c.setNombre(txtNuevoNombre.getText());
                c.setDireccion(txtNuevaDireccion.getText());
                c.setTelefono(txtNuevoTelefonoNumber.getText());
                c.setCorreo(txtNuevaCorreoElectronico.getText());
                c.setCodigoPostal(txtNuevoCodigoPostal.getText());
                c.setProvincia(txtNuevaPrivincia.getText());
                c.setDni(txtNuevoDNI.getText());
                c.setCiudad(txtNuevaCiudad.getText());

                int valor = JOptionPane.showConfirmDialog(null, "¿Desea modificar los datos de Cliente?");
                if (valor == JOptionPane.OK_OPTION) {
                    acierto = bd.modificaDatosCliente(c);
                }

                if (acierto) {
                    JOptionPane.showMessageDialog(null, "Cliente modificado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar el Cliente.");
                }

                limpiarCampos();
            }
            
        });

        add(btnModificar);

        JButton btnBorrar = new JButton("Borrar");
        btnBorrar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 16));
        btnBorrar.setBounds(445, 654, 123, 32);
        btnBorrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                if (nombreSeleccionadoId == -1) {
                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún nombre.");
                    return;
                }
                
                Boolean acierto = false;
                BBDDmoviles b = new BBDDmoviles();
                Cliente c = new Cliente();
                int valor = JOptionPane.showConfirmDialog(null, "¿Seguro de eliminar el cliente seleccionado?");
                if (valor == JOptionPane.OK_OPTION) {
                    c.setIdCliente(nombreSeleccionadoId);
                    acierto = b.borrarCliente(c);
                }
                if (acierto) {
                    JOptionPane.showMessageDialog(null, "Cliente eliminado.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar el cliente seleccionado.");
                }

                limpiarCampos();
            }
        });

        add(btnBorrar);
        
    }

    public void controlamoscosas() {
        if (nombreSeleccionadoId == -1) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún nombre.");
            return;
        }

        if (txtNuevoNombre.getText().isEmpty() || txtNuevaDireccion.getText().trim().isEmpty()
                || txtNuevoTelefonoNumber.getText().trim().isEmpty()
                || txtNuevaCorreoElectronico.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar completos.");
            return;
        }

        AñadirCliente cu = new AñadirCliente();
        if (!cu.validarCorreo(txtNuevaCorreoElectronico.getText())) {
            return;
        }

        if (!cu.controlarNumeroMovil(txtNuevoTelefonoNumber.getText())) {
            return;
        }
    }

    public void buscarClientePorNombreyTelefono() {
        String nombreCliente = txtNombreBuscarParaCambiar.getText().trim();
        String numeroCliente = txtTelefonoBuscarParaCambiar.getText().trim();

        if (nombreCliente.isEmpty() || numeroCliente.isEmpty()) {
            nombreSeleccionadoId = -1; // Limpiar el ID si algún campo está vacío
            limpiarCampos();
            return;
        }

        BBDDmoviles bd = new BBDDmoviles();
        ArrayList<Cliente> arrResultado = bd.consultaGeneralPorNombreyTelefonoDelCliente(nombreCliente,
                numeroCliente);

        if (!arrResultado.isEmpty()) {
            Cliente cliente = arrResultado.get(0); // Tomamos la primera ciudad encontrada
            nombreSeleccionadoId = cliente.getIdCliente(); // Guardamos el ID del cliente
            txtNuevoNombre.setText(cliente.getNombre());
            txtNuevaDireccion.setText(cliente.getDireccion());
            txtNuevoTelefonoNumber.setText(cliente.getTelefono());
            txtNuevaCorreoElectronico.setText(cliente.getCorreo());
            txtNuevoCodigoPostal.setText(cliente.getCodigoPostal());
            txtNuevaPrivincia.setText(cliente.getProvincia());
            txtNuevoDNI.setText(cliente.getDni());
            txtNuevaCiudad.setText(cliente.getCiudad());
            

        } else {
            nombreSeleccionadoId = -1;
            limpiarCampos();
            JOptionPane.showMessageDialog(null, "No se encontró ningún cliente con esos criterios.");
        }
    }

    public void limpiarCampos() {
        txtNuevoNombre.setText("");
        txtNuevaDireccion.setText("");
        txtNuevoTelefonoNumber.setText("");
        txtNuevaCorreoElectronico.setText("");
        txtNuevoCodigoPostal.setText("");
        txtNuevaPrivincia.setText("");
        txtNuevoDNI.setText("");
        txtNuevaCiudad.setText("");
    }
}
