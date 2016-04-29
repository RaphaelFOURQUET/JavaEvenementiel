/**
 * 
 */
package fr.adaming.formulaire;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author INTI-0332
 *
 */
@SuppressWarnings("serial")
public class MyJComboBox extends JFrame {

	private JPanel container = new JPanel();
	private String[] tab = {"Option 1", "Option 2", "Option 3", "Option 4"};
	private JComboBox<String> combo = new JComboBox<String>(tab);
	private JLabel label = new JLabel("Une ComboBox");

	public MyJComboBox(){
		this.setTitle("Animation");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());

		//Ajout du listener
		combo.addItemListener(new ItemState());
		combo.addActionListener(new ItemAction());
		
		combo.setPreferredSize(new Dimension(100, 20));
		combo.setForeground(Color.blue);

		//		combo.addItem("Option 1");	//RFRF : deplace dans le constructeur.
		//		combo.addItem("Option 2");
		//		combo.addItem("Option 3");
		//		combo.addItem("Option 4");
		combo.addItem("Option 5");

		combo.setSelectedIndex(2);	//RFRF : choix par defaut.

		JPanel top = new JPanel();
		top.add(label);
		top.add(combo);
		container.add(top, BorderLayout.NORTH);
		this.setContentPane(container);
		this.setVisible(true);
	}

	//Classe interne implémentant l'interface ItemListener
	class ItemState implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			System.out.println("événement déclenché sur : " +
					e.getItem());
		}
	}

	class ItemAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("ActionListener : action sur " +
					combo.getSelectedItem());
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Auto-generated method stub
		new MyJComboBox();
	}

}
