/**
 * 
 */
package fr.adaming.exercice1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author INTI-0332
 *
 */
@SuppressWarnings("serial")
public class MyFinalFrame extends JFrame {

	private MyPanel pan = new MyPanel();
	private JButton bouton = new JButton("Go");
	private JButton bouton2 = new JButton("Stop");
	private JPanel container = new JPanel();
	private JLabel label = new JLabel("Le JLabel");
	//private int compteur = 0;
	private boolean animated = true;
	private boolean backX, backY;
	private int x, y;

	public MyFinalFrame(){
		this.setTitle("Animation");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		container.add(pan, BorderLayout.CENTER);

		//		bouton.addActionListener(new BoutonListener());
		//RFRF : par classe anonyme :
		bouton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				animated = true;
				bouton.setEnabled(false);
				bouton2.setEnabled(true);
				go();
			}
		});

		bouton.setEnabled(false); 

//		bouton2.addActionListener(new Bouton2Listener());
		//RFRF : par classe anonyme :
		bouton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				animated = false;
				bouton.setEnabled(true);
				bouton2.setEnabled(false);
			}
		});


		JPanel south = new JPanel(); 	 
		south.add(bouton);
		south.add(bouton2);
		container.add(south, BorderLayout.SOUTH);
		Font police = new Font("Tahoma", Font.BOLD, 16);
		label.setFont(police);
		label.setForeground(Color.blue);
		label.setHorizontalAlignment(JLabel.CENTER);
		container.add(label, BorderLayout.NORTH);
		this.setContentPane(container);
		this.setVisible(true);
		go();
	}

	private void go(){
		//Les coordonnées de départ de notre rond 
		x = pan.getPosX();
		y = pan.getPosY();

		while(this.animated){

			if(x < 1)
				backX = false;
			if(x > pan.getWidth()-50)
				backX = true;
			if(y < 1)
				backY = false;
			if(y > pan.getHeight()-50)
				backY = true;
			if(!backX)
				pan.setPosX(++x);
			else pan.setPosX(--x);
			if(!backY) 
				pan.setPosY(++y);
			else pan.setPosY(--y);
			pan.repaint();
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	}

	//	class BoutonListener implements ActionListener{
	//		public void actionPerformed(ActionEvent arg0) {
	//			animated = true;
	//			bouton.setEnabled(false);
	//			bouton2.setEnabled(true);
	//			go();
	//		}
	//	}

//	class Bouton2Listener implements ActionListener{
//		public void actionPerformed(ActionEvent e) {
//			animated = false;
//			bouton.setEnabled(true);
//			bouton2.setEnabled(false);
//		}
//	}
	
}

