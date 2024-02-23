package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Actividad2_1 {

	private JFrame frame;
	private JTextField txtCod;
	private JTextField Nombre;
	private JTextField Loca;
	private ButtonGroup btnGroup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Actividad2_1 window = new Actividad2_1();
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
	public Actividad2_1() {
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
		panel.setBounds(173, 72, 771, 420);
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
	}
}
