/**
 * 
 */
package fr.adaming.button_layout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author INTI-0332
 *
 */
@SuppressWarnings("serial")
public class MyFrame extends JFrame {
	private JPanel pan = new JPanel();
	private JButton bouton = new JButton("Mon bouton");

	CardLayout cl = new CardLayout();
	JPanel content = new JPanel();
	//Liste des noms de nos conteneurs pour la pile de cartes
	String[] listContent = {"CARD_1", "CARD_2", "CARD_3"};
	int indice = 0; 

	public MyFrame(){
		this.setTitle("Frame with JButton");
		this.setSize(300, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		//		this.setLocation(0, 0);

		//Ajout du bouton à notre content pane
		pan.add(bouton);
		this.setContentPane(pan);
		//On ajoute le bouton au content pane de la JFrame
		//		this.getContentPane().add(bouton);

		//this.setVisible(true);	//RFRF : Déplacé dans le main
	}

	public MyFrame(int i){	//RFRF : Juste pour les differents fenetres sur un même constructeur, pas top.
		switch(i) {
		case 0 :	//RFRF : BorderLayout
			this.setTitle("BorderLayout");
			this.setSize(300, 300);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//this.setLocationRelativeTo(null);
			this.setLocation(0, 200);
			//On définit le layout à utiliser sur le content pane
			this.setLayout(new BorderLayout());
			//On ajoute le bouton au content pane de la JFrame
			//Au centre
			this.getContentPane().add(new JButton("CENTER"), BorderLayout.CENTER);
			//Au nord
			this.getContentPane().add(new JButton("NORTH"), BorderLayout.NORTH);
			//Au sud
			this.getContentPane().add(new JButton("SOUTH"), BorderLayout.SOUTH);
			//À l'ouest
			this.getContentPane().add(new JButton("WEST"), BorderLayout.WEST);
			//À l'est
			this.getContentPane().add(new JButton("EAST"), BorderLayout.EAST);
			this.setVisible(true);
			break;

		case 1 :	//RFRF : GridLayout
			this.setTitle("GridLayout");
			this.setSize(300, 300);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//			this.setLocationRelativeTo(null);
			this.setLocation(0, 600);
			//On définit le layout à utiliser sur le content pane
			//Trois lignes sur deux colonnes
			GridLayout gl = new GridLayout(3, 2);
			//RFRF : gl.setColumns(2); gl.setRows(3); pour modifier le nombre de lignes/colonnes.
			this.setLayout(gl);
			gl.setHgap(5); //Cinq pixels d'espace entre les colonnes (H comme Horizontal)
			gl.setVgap(1); //Cinq pixels d'espace entre les lignes (V comme Vertical)
			//Ou en abrégé : GridLayout gl = new GridLayout(3, 2, 5, 1);

			//On ajoute le bouton au content pane de la JFrame
			this.getContentPane().add(new JButton("1"));
			this.getContentPane().add(new JButton("2"));
			this.getContentPane().add(new JButton("3"));
			this.getContentPane().add(new JButton("4"));
			this.getContentPane().add(new JButton("5"));
			this.setVisible(true); 
			break;

		case 2 :	//RFRF : BoxLayout
			this.setTitle("Box Layout");
			this.setSize(300, 120);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//			this.setLocationRelativeTo(null);
			this.setLocation(0,  0);
			JPanel b1 = new JPanel();

			//On définit le layout en lui indiquant qu'il travaillera en ligne
			b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
			b1.add(new JButton("Bouton 1"));
			JPanel b2 = new JPanel();

			//Idem pour cette ligne
			b2.setLayout(new BoxLayout(b2, BoxLayout.LINE_AXIS));
			b2.add(new JButton("Bouton 2"));
			b2.add(new JButton("Bouton 3"));
			JPanel b3 = new JPanel();

			//Idem pour cette ligne
			b3.setLayout(new BoxLayout(b3, BoxLayout.LINE_AXIS));
			b3.add(new JButton("Bouton 4"));
			b3.add(new JButton("Bouton 5"));
			b3.add(new JButton("Bouton 6"));
			JPanel b4 = new JPanel();

			//On positionne maintenant ces trois lignes en colonne
			b4.setLayout(new BoxLayout(b4, BoxLayout.PAGE_AXIS));
			b4.add(b1);
			b4.add(b2);
			b4.add(b3);
			this.getContentPane().add(b4);
			this.setVisible(true); 
			break;

		case 3 :	//RFRF : CardLayout
			this.setTitle("CardLayout");
			this.setSize(300, 120);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			this.setLocationRelativeTo(null);
			this.setLocation(400, 0);

			//On crée trois conteneurs de couleur différente
			JPanel card1 = new JPanel();
			card1.setBackground(Color.BLUE);
			JPanel card2 = new JPanel();
			card2.setBackground(Color.RED);
			JPanel card3 = new JPanel();
			card3.setBackground(Color.GREEN);
			JPanel boutonPane = new JPanel();
			
			JButton bouton = new JButton("Contenu suivant");
			//Définition de l'action du bouton
			bouton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					//Via cette instruction, on passe au prochain conteneur de la pile
					cl.next(content);
				}
			});
			
			JButton bouton2 = new JButton("Contenu par indice");
			//Définition de l'action du bouton2
			bouton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					if(++indice > 2)
						indice = 0;
					//Via cette instruction, on passe au conteneur correspondant au nom fourni en paramètre
					cl.show(content, listContent[indice]);
				}
			});
			
			boutonPane.add(bouton);
			boutonPane.add(bouton2);
			
			//On définit le layout
			content.setLayout(cl);
			
			//On ajoute les cartes à la pile avec un nom pour les retrouver
			content.add(card1, listContent[0]);
			content.add(card2, listContent[1]);
			content.add(card3, listContent[2]);
			this.getContentPane().add(boutonPane, BorderLayout.NORTH);
			this.getContentPane().add(content, BorderLayout.CENTER);
			this.setVisible(true); 
			break;
			
		default :
			System.out.println("Nothing to do here !");
		}
	}

}
