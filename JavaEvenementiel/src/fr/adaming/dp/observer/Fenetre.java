/**
 * 
 */
package fr.adaming.dp.observer;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author INTI-0332
 *
 */
@SuppressWarnings("serial")
public class Fenetre  extends JFrame {

	private JLabel label = new JLabel();
	private Horloge horloge;

	public Fenetre(){
		
		//On initialise la JFrame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setSize(200, 80);
		
		//On initialise l'horloge
		this.horloge = new Horloge();
		
		//On initialise le JLabel
		this.label.setFont(new Font("DS-digital", Font.TYPE1_FONT, 30));
		this.label.setHorizontalAlignment(JLabel.CENTER);
		
		//On ajoute le JLabel à la JFrame
		this.getContentPane().add(this.label, BorderLayout.CENTER);
	}

}


