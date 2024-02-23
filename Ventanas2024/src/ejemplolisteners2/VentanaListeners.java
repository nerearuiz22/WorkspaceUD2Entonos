package ejemplolisteners2;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ejemplosliistener.modelo.MiModelo;
import ejemplosliistener.modelo.Persona;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class VentanaListeners {

	private JFrame frame;
	private JTextField textField;
	private JTextArea textArea;
	private JLabel lblGenero;
	private ButtonGroup cbg;
	private JComboBox comboBox;
	private JList lista;
	private JScrollPane scrollPaneLista;

	public static List<Persona> personas() {

		List<Persona> arraylist = new ArrayList<Persona>();

		arraylist.add(new Persona("Carlos", "Perdices"));
		arraylist.add(new Persona("Carlos", "Perez"));
		arraylist.add(new Persona("Angel", "Sanchez"));
		arraylist.add(new Persona("Julian", "Muñoz"));
		arraylist.add(new Persona("Kate", "Lopez"));

		return arraylist;

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaListeners window = new VentanaListeners();
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
	public VentanaListeners() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1309, 791);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(158, 76, 127, 13);
		frame.getContentPane().add(lblNombre);

		textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {

				textField.transferFocus();
				JOptionPane.showMessageDialog(frame, "Focus ganado");

			}
		});

		textField.setBounds(294, 75, 196, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);


		lblGenero = new JLabel("Género:");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGenero.setBounds(162, 138, 109, 17);
		frame.getContentPane().add(lblGenero);

		textField.getDocument().addDocumentListener(

				new DocumentListener() {

					@Override
					public void insertUpdate(DocumentEvent e) {
						// TODO Auto-generated method stub

						warn();

					}

					@Override
					public void removeUpdate(DocumentEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void changedUpdate(DocumentEvent e) {
						// TODO Auto-generated method stub
						warn();
					}

					private void warn() {

						textArea.append("CambioDeTexto:" + textField.getText() + "\n");
					}

				}

		);

		JCheckBox chckMasculino = new JCheckBox("Masculino");
		chckMasculino.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckMasculino.setBounds(294, 138, 93, 21);
		frame.getContentPane().add(chckMasculino);

		JCheckBox chckFemenido = new JCheckBox("Femenino");
		chckFemenido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckFemenido.setBounds(408, 138, 93, 21);
		frame.getContentPane().add(chckFemenido);

		cbg = new ButtonGroup();

		cbg.add(chckMasculino);
		cbg.add(chckFemenido);

		JPanel idPersonasCombo = new JPanel();
		idPersonasCombo.setToolTipText("Personas Combo");
		idPersonasCombo.setBounds(169, 203, 10, 10);
		frame.getContentPane().add(idPersonasCombo);

		ButtonModel masc = chckMasculino.getModel();
		ButtonModel fem = chckFemenido.getModel();

		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (cbg.getSelection() != null) {

					if (cbg.getSelection().equals(masc)) {

						textArea.append("Seleccionaste masculino\n");

					} else {

						textArea.append("Seleccionaste femenino\n");
					}
				}

			}

		};

		masc.addActionListener(action);
		fem.addActionListener(action);

		initializeCombo();
		
		scrollPaneLista = new JScrollPane();
		scrollPaneLista.setBounds(70, 357, 414, 195);
		frame.getContentPane().add(scrollPaneLista);
	
		inicializaLista();

	}

	private void initializeCombo() {

		Persona person1 = new Persona("Carlos", "Perdicero");
		Persona person2 = new Persona("Antonio", "Carrasquero");
		Persona[] persons = new Persona[] { person1, person2 };

		comboBox = new JComboBox<Persona>(new DefaultComboBoxModel(persons));
		comboBox.setBounds(294, 201, 196, 21);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));

		comboBox.setRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (value instanceof Persona) {
					Persona person = (Persona) value;
					setText(person.getNombre() + " " + person.getApellidos());
				}
				return this;
			}
		});

		comboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Object item = e.getItem();
					// do something with object

					JOptionPane.showMessageDialog(frame, "Persona seleccionada" + e.getItem());
				}

			}

		});
		frame.getContentPane().add(comboBox);

	}

	
	private void inicializaLista() {

		AbstractListModel dfd = new MiModelo(personas());

		lista = new JList(dfd);

		// se cambia la orientación de presentación y el ajuste
		lista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		// selecciona un elemento de la lista

		lista.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub

				JOptionPane.showMessageDialog(frame, "Elemento seleccionado: " + lista.getSelectedValue());

			}
		});

		lista.setCellRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (value instanceof Persona) {
					Persona person = (Persona) value;
					setText(person.getNombre() + " " + person.getApellidos());
				}
				return this;
			}
		});

		scrollPaneLista.setViewportView(lista);

	}
}