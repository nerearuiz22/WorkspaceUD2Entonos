package ventanas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import model.Paises;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;

public class Actividad21 {

	private JFrame frame;
	private JTextField txtCod;
	private JTextField Nombre;
	private JTextField Loca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Actividad21 window = new Actividad21();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Actividad21() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1172, 815);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(51, 46, 771, 420);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblDatosDeDepartamentos = new JLabel("DATOS DE DEPARTAMENTOS");
		lblDatosDeDepartamentos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDatosDeDepartamentos.setBounds(205, 22, 289, 25);
		panel.add(lblDatosDeDepartamentos);
		
		JLabel lblCodigoDepartamento = new JLabel("Codigo de departamento");
		lblCodigoDepartamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigoDepartamento.setBounds(94, 82, 172, 25);
		panel.add(lblCodigoDepartamento);
		
		txtCod = new JTextField();
		txtCod.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCod.setBackground(Color.LIGHT_GRAY);
		txtCod.setBounds(295, 83, 104, 25);
		panel.add(txtCod);
		txtCod.setColumns(10);
		
		JLabel lblNombreDepartamento = new JLabel("Nombre de Departamento");
		
		
		lblNombreDepartamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreDepartamento.setBounds(94, 136, 172, 13);
		panel.add(lblNombreDepartamento);
		
		Nombre = new JTextField();
		Nombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Nombre.setBounds(295, 132, 217, 25);
		panel.add(Nombre);
		Nombre.setColumns(10);
		
		Loca = new JTextField();
		Loca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Loca.setColumns(10);
		Loca.setBounds(295, 181, 217, 25);
		panel.add(Loca);
		
		JLabel lblLocalidadDepartamento_1 = new JLabel("Localidad de Departamento");
		lblLocalidadDepartamento_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLocalidadDepartamento_1.setBounds(94, 185, 172, 13);
		panel.add(lblLocalidadDepartamento_1);
		
		JButton btnInsertarDatos = new JButton("Insertar Datos");
		btnInsertarDatos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnInsertarDatos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				System.out.println("Código: " + txtCod.getText() + "\nNombre: " + Nombre.getText() + "\nLocalidad: " + Loca.getText());
				
				
			}
		});
		
		
		btnInsertarDatos.addActionListener((e)-> 	
		System.out.println("Código: " + txtCod.getText() + "\nNombre: " + Nombre.getText() + "\nLocalidad: " + Loca.getText()) );
		
		btnInsertarDatos.setBounds(94, 267, 172, 34);
		panel.add(btnInsertarDatos);
		
		JButton btnLimpiarDatos = new JButton("Limpiar Datos");
		btnLimpiarDatos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpiarDatos.setBounds(350, 267, 172, 34);
		panel.add(btnLimpiarDatos);
		
		JLabel idPais = new JLabel("Seleccionar el pais");
		idPais.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idPais.setBounds(94, 222, 159, 14);
		panel.add(idPais);
		
		JComboBox cmbPaises = new JComboBox();
		cmbPaises.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String comando = e.getActionCommand();
				System.out.println(comando + " " + cmbPaises.getSelectedItem());
			}
		});
		cmbPaises.setModel(new DefaultComboBoxModel(Paises.values()));
		cmbPaises.setBounds(295, 217, 154, 22);
		panel.add(cmbPaises);
		
		JRadioButton gestion = new JRadioButton("Gestión");
		gestion.setBounds(566, 85, 109, 23);
		panel.add(gestion);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Personal");
		rdbtnNewRadioButton.setBounds(554, 133, 109, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Apoyo");
		rdbtnNewRadioButton_1.setBounds(537, 183, 109, 23);
		panel.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Tecnológico");
		rdbtnNewRadioButton_2.setBounds(554, 220, 109, 23);
		panel.add(rdbtnNewRadioButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(82, 486, 673, 131);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}
}
