package exp;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Startseite1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Startseite1 frame = new Startseite1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Startseite1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabPane = new JTabbedPane(JTabbedPane.TOP);
		tabPane.setBounds(0, 0, 424, 261);
		contentPane.add(tabPane);
		
		JPanel panel = new JPanel();
		tabPane.addTab("Suche", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblSeriennummerId = new JLabel("Seriennummer / ID");
		lblSeriennummerId.setBounds(26, 31, 118, 14);
		panel.add(lblSeriennummerId);
		
		textField = new JTextField();
		textField.setBounds(144, 28, 118, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnSuche = new JButton("Suche");
		btnSuche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null," Schuh gefunden! \n Modell: Nike Free RN \n Größe: 43 \n Farbe: Rot \n Bestand: 3 \n Regal/Fach: 5/d");
			}
		});
		btnSuche.setBounds(306, 27, 89, 23);
		panel.add(btnSuche);
		
		Label label = new Label("Schuhgr\u00F6\u00DFe");
		label.setBounds(26, 131, 118, 22);
		panel.add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46"}));
		comboBox.setBounds(144, 131, 104, 20);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Schwarz", "Wei\u00DF ", "Rot", "Gr\u00FCn", "Blau"}));
		comboBox_1.setBounds(144, 159, 104, 20);
		panel.add(comboBox_1);
		
		Label label_1 = new Label("Schuhfarbe");
		label_1.setBounds(26, 159, 118, 22);
		panel.add(label_1);
		
		JButton button = new JButton("Suche");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null," Ihre Suche ergabe 3 Treffer!");
			
			}
		});
		button.setBounds(306, 162, 89, 23);
		panel.add(button);
		
		Label label_2 = new Label("Schuhmarke");
		label_2.setBounds(26, 103, 118, 22);
		panel.add(label_2);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Adidas", "Bugatti", "Le Coq Sportif", "Nike", "Puma", "Vans"}));
		comboBox_2.setBounds(144, 103, 104, 20);
		panel.add(comboBox_2);
		
		JPanel panel_1 = new JPanel();
		tabPane.addTab("Verwaltung", null, panel_1, null);
	}
}