package ejemplotienda;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import ejemplotiendamodelo.Cliente;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertarCliente extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtDniDialog;
	private JTextField txtNombreDialog;
	private JTextField txtApellidosDialog;
	private Cliente clienteInsertado;
	private AppTienda appTienda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InsertarCliente dialog = new InsertarCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	public AppTienda getAppTienda() {
		return appTienda;
	}



	public void setAppTienda(AppTienda appTienda) {
		this.appTienda = appTienda;
	}


	/**
	 * Create the dialog.
	 */
	public InsertarCliente() {
		
		this.appTienda=appTienda;
		setBounds(100, 100, 754, 465);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 738, 393);
		contentPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblDni = new JLabel("Dni:");
			lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblDni.setBounds(89, 76, 104, 24);
			contentPanel.add(lblDni);
		}
		{
			JLabel lblNombreCliente = new JLabel("Nombre del cliente:");
			lblNombreCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNombreCliente.setBounds(89, 132, 135, 14);
			contentPanel.add(lblNombreCliente);
		}
		{
			JLabel lblApellidosCliente = new JLabel("Apellidos del cliente:");
			lblApellidosCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblApellidosCliente.setBounds(89, 195, 125, 14);
			contentPanel.add(lblApellidosCliente);
		}
		{
			txtDniDialog = new JTextField();
			txtDniDialog.setText((String) null);
			txtDniDialog.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtDniDialog.setColumns(10);
			txtDniDialog.setBounds(251, 79, 119, 20);
			contentPanel.add(txtDniDialog);
		}
		{
			txtNombreDialog = new JTextField();
			txtNombreDialog.setText((String) null);
			txtNombreDialog.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtNombreDialog.setColumns(10);
			txtNombreDialog.setBounds(251, 130, 119, 20);
			contentPanel.add(txtNombreDialog);
		}
		{
			txtApellidosDialog = new JTextField();
			txtApellidosDialog.setText((String) null);
			txtApellidosDialog.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtApellidosDialog.setColumns(10);
			txtApellidosDialog.setBounds(251, 192, 119, 20);
			contentPanel.add(txtApellidosDialog);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 393, 738, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						clienteInsertado = 
								new Cliente(txtNombreDialog.getText(), txtApellidosDialog.getText(),txtDniDialog.getText());
						appTienda.setEsInsertado(true);
						appTienda.setClienteInsertado(clienteInsertado);
						dispose();

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						appTienda.setEsInsertado(false);
						dispose();
						
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}



}
