package fr.adaming.evenementiel;

/**
 * 
 */

/**
 * @author INTI-0332
 *
 */
public class PremierTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Auto-generated method stub
//		JFrame fenetre = new JFrame();
//		
//		System.out.println(fenetre.getDefaultCloseOperation());	//RFRF : JFrame.HIDE_ON_CLOSE par defaut.
//				
//		//Définit un titre pour notre fenêtre
//		fenetre.setTitle("Une fenêtre Java");
//		//Définit sa taille : 400 pixels de large et 100 pixels de haut
//		fenetre.setSize(400, 100);
//		//Nous demandons maintenant à notre objet de se positionner au centre
//		fenetre.setLocationRelativeTo(null);
//		//Termine le processus lorsqu'on clique sur la croix rouge
//		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		//Et enfin, la rendre visible
//		fenetre.setVisible(true);
		
		My2DFrame my2DFrame = new My2DFrame();
		my2DFrame.setLocationRelativeTo(null);
		
		MyFirstFrame myFrame = new MyFirstFrame();
		//maFenetre.setVisible(true);
		
		//Positionner ma fenetre
		myFrame.setLocation(0, 0);	//RFRF : Depuis en haut/gauche de l'écran.	(Ordonnée inversée).
		//Empecher le redimensionnement.
//		maFenetre.setResizable(false);
		//Toujours au premier plan.
//		maFenetre.setAlwaysOnTop(true);
		//Retirer boutons et contours	
//		maFenetre.setUndecorated(true);	//RFRF : IllegalComponentStateException
		
//		My2DFrame my2DFrame = new My2DFrame();
//		my2DFrame.setLocationRelativeTo(null);

	}

}
