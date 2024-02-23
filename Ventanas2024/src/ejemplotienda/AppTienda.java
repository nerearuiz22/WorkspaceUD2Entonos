package ejemplotienda;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.border.LineBorder;

import ejemplosliistener.modelo.Persona;
import ejemplotiendamodelo.Cliente;
import ejemplotiendamodelo.Tienda;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppTienda {

	private JFrame frame;
	private JTextField txtNombreTienda;
	private JTextField txtDireccionTienda;
	private JTextField textDni;
	private JTextField textNombreCliente;
	private JTextField textApellidosCliente;
	private JComboBox cmbClientes;
	private JButton btnModificarTienda;
	private JButton btnModificarCliente;
	
	private boolean esInsertado= false;
	private Cliente clienteInsertado=null;
	private Tienda t1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppTienda window = new AppTienda();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	public boolean isEsInsertado() {
		return esInsertado;
	}



	public void setEsInsertado(boolean esInsertado) {
		this.esInsertado = esInsertado;
	}



	public Cliente getClienteInsertado() {
		return clienteInsertado;
	}



	public void setClienteInsertado(Cliente clienteInsertado) {
		this.clienteInsertado = clienteInsertado;
	}



	/**
	 * Create the application.
	 */
	public AppTienda() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 862, 644);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panelTienda = new JPanel();
		panelTienda.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTienda.setBounds(39, 117, 435, 312);
		frame.getContentPane().add(panelTienda);
		panelTienda.setLayout(null);

		JLabel lblNombreTienda = new JLabel("Nombre de tienda:");
		lblNombreTienda.setBounds(101, 56, 114, 17);
		lblNombreTienda.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelTienda.add(lblNombreTienda);

		txtNombreTienda = new JTextField();
		txtNombreTienda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNombreTienda.setBounds(268, 51, 122, 29);
		panelTienda.add(txtNombreTienda);
		txtNombreTienda.setColumns(10);

		txtDireccionTienda = new JTextField();
		txtDireccionTienda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDireccionTienda.setColumns(10);
		txtDireccionTienda.setBounds(185, 112, 240, 29);
		panelTienda.add(txtDireccionTienda);

		JLabel lblDireccionTienda = new JLabel("Dirección de tienda:");
		lblDireccionTienda.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDireccionTienda.setBounds(34, 117, 157, 17);
		panelTienda.add(lblDireccionTienda);

		btnModificarTienda = new JButton("Modificar");
		btnModificarTienda.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificarTienda.setBounds(141, 232, 140, 51);
		panelTienda.add(btnModificarTienda);

		JLabel lblClientes = new JLabel("Clientes:");
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClientes.setBounds(101, 173, 114, 14);
		panelTienda.add(lblClientes);

		cmbClientes = new JComboBox();
		cmbClientes.setBounds(185, 168, 240, 29);
		panelTienda.add(cmbClientes);

		JLabel lblAplicacionTienda = new JLabel("Aplicación Tienda");
		lblAplicacionTienda.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAplicacionTienda.setBounds(372, 28, 194, 23);
		frame.getContentPane().add(lblAplicacionTienda);

		JLabel lblTienda = new JLabel("Tienda");
		lblTienda.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTienda.setBounds(237, 81, 141, 14);
		frame.getContentPane().add(lblTienda);

		JPanel panelCliente = new JPanel();
		panelCliente.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelCliente.setBounds(516, 123, 282, 306);
		frame.getContentPane().add(panelCliente);
		panelCliente.setLayout(null);

		JLabel lblDni = new JLabel("Dni:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDni.setBounds(51, 67, 104, 24);
		panelCliente.add(lblDni);

		textDni = new JTextField();
		textDni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textDni.setBounds(153, 67, 119, 20);
		panelCliente.add(textDni);
		textDni.setColumns(10);

		JLabel lblNombreCliente = new JLabel("Nombre del cliente:");
		lblNombreCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreCliente.setBounds(20, 104, 135, 14);
		panelCliente.add(lblNombreCliente);

		textNombreCliente = new JTextField();
		textNombreCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNombreCliente.setColumns(10);
		textNombreCliente.setBounds(153, 102, 119, 20);
		panelCliente.add(textNombreCliente);

		textApellidosCliente = new JTextField();
		textApellidosCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textApellidosCliente.setColumns(10);
		textApellidosCliente.setBounds(153, 145, 119, 20);
		panelCliente.add(textApellidosCliente);

		JLabel lblApellidosCliente = new JLabel("Apellidos del cliente:");
		lblApellidosCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApellidosCliente.setBounds(20, 148, 125, 14);
		panelCliente.add(lblApellidosCliente);

		btnModificarCliente = new JButton("Modificar");
		btnModificarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (cmbClientes.getSelectedItem() instanceof Cliente) {
		
					Cliente cl=(Cliente)cmbClientes.getSelectedItem();
					cl.setDni(textDni.getText());
					cl.setNombre(textNombreCliente.getText());
					cl.setApellidos(textApellidosCliente.getText());
					panelTienda.updateUI();	
					}
 				
			}
		});
		
		btnModificarCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificarCliente.setBounds(153, 221, 119, 40);
		panelCliente.add(btnModificarCliente);
		
		JButton btnInsertarCliente = new JButton("Insertar");
		
		btnInsertarCliente.addActionListener( 
						
						(e) -> {				
						
						InsertarCliente dialog = new InsertarCliente();
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setAppTienda(this);
						dialog.setModal(true);
						dialog.setVisible(true);
						Cliente cliente;
						
						if (this.esInsertado) {
							
							t1.addCliente(this.clienteInsertado);
							panelTienda.updateUI();
							cmbClientes.setModel(new DefaultComboBoxModel<Cliente>(t1.getClientes()));
							
						}
						
					}
				);
		
		btnInsertarCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnInsertarCliente.setBounds(20, 221, 119, 40);
		panelCliente.add(btnInsertarCliente);

		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCliente.setBounds(646, 93, 111, 14);
		frame.getContentPane().add(lblCliente);

		bootStrap();
	}

	private void bootStrap() {
		Cliente c1 = new Cliente("Jesus", "Soto", "444444");
		Cliente c2 = new Cliente("Pablo", "Martinez", "555555");

		t1 = new Tienda("Software JGP", " C. San Vicente Paul, 32, 23740 Andújar, Jaén");

		t1.addCliente(c1);
		t1.addCliente(c2);

		txtNombreTienda.setText(t1.getNombre());
		txtDireccionTienda.setText(t1.getDireccion());

		cmbClientes.setModel(new DefaultComboBoxModel<Cliente>(t1.getClientes()));
		
		defineCombo();
		
		textDni.setText(t1.getClientes()[0].getDni());
		textNombreCliente.setText(t1.getClientes()[0].getNombre());
		textApellidosCliente.setText(t1.getClientes()[0].getApellidos());

	}

	private void defineCombo() {

		cmbClientes.setRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,boolean cellHasFocus) {
				
				super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (value instanceof Cliente) {
					Cliente client = (Cliente) value;
					setText(client.getNombre() + " " + client.getApellidos());
				}
				return this;
			}
		});

		cmbClientes.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Object item = e.getItem();
					
					if (item instanceof Cliente) {
						Cliente cl=(Cliente) item;
		
						textDni.setText(cl.getDni());
						textNombreCliente.setText(cl.getNombre());
						textApellidosCliente.setText(cl.getApellidos());
						
					}
					// do something with object

					JOptionPane.showMessageDialog(frame, "Persona seleccionada" + e.getItem());
				}

			}

		});
		
		
	

	}

}
