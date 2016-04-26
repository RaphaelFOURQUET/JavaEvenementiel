package fr.adaming.evenementiel;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class My2DFrame extends JFrame {
	
	public My2DFrame() {
		//Définit un titre pour notre fenêtre
		this.setTitle("Une fenêtre Java graphics2D");
		//Définit sa taille : 400 pixels de large et 100 pixels de haut
		this.setSize(400, 400);
		//Nous demandons maintenant à notre objet de se positionner au centre
		this.setLocationRelativeTo(null);
		//Termine le processus lorsqu'on clique sur la croix rouge
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(new My2DPanel());	//RFRF : Definition de mon propre Panel 2D.

		//Et enfin, la rendre visible
		this.setVisible(true);
	}

}
