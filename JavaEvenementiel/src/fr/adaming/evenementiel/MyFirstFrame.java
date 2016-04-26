package fr.adaming.evenementiel;

import java.awt.Color;

import javax.swing.JFrame;

/**
 * 
 */

/**
 * @author INTI-0332
 *
 */
@SuppressWarnings("serial")
public class MyFirstFrame extends JFrame {


	public MyFirstFrame() {
		//D�finit un titre pour notre fen�tre
		this.setTitle("Une fen�tre Java");
		//D�finit sa taille : 400 pixels de large et 100 pixels de haut
		this.setSize(400, 400);
		//Nous demandons maintenant � notre objet de se positionner au centre
		this.setLocationRelativeTo(null);
		//Termine le processus lorsqu'on clique sur la croix rouge
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//		//Instanciation d'un objet JPanel
//		JPanel pan = new JPanel();
//		//D�finition de sa couleur de fond
//		pan.setBackground(Color.BLACK);		//RFRF : couleur panel > couleur frame
//		//On pr�vient notre JFrame que notre JPanel sera son content pane
//		this.setContentPane(pan);
		
		this.setBackground(Color.WHITE);
		
		this.setContentPane(new MyFirstPanel());	//RFRF : Definition de mon propre Panel.

		//Et enfin, la rendre visible
		this.setVisible(true);
	}

}
