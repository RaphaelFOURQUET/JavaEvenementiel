/**
 * 
 */
package fr.adaming.exercice1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author INTI-0332
 *
 */
@SuppressWarnings("serial")
//public class MyFrameAnimationButton extends JFrame  implements ActionListener {
public class MyFrameAnimationButton extends JFrame {
	private MyPanel pan = new MyPanel();
	private MyButton bouton = new MyButton("My Button");
	private MyButton bouton2 = new MyButton("Button 2");
	private JPanel container = new JPanel();
	private JLabel label = new JLabel("Un JLabel");
	private JLabel labelCpt = new JLabel("0 clics");
	//	private int cptClic = 0;	//RFRF : deplacé dans MyButton, bonne idée ??
	//
	//	public int getCptClic() {
	//		return this.cptClic;
	//	}


	public MyFrameAnimationButton() {
		this.setTitle("Animation+MyButton");
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		container.setBackground(Color.WHITE);
		container.setLayout(new BorderLayout());
		container.add(pan, BorderLayout.CENTER);

		JPanel south = new JPanel();
		south.add(bouton);
		south.add(bouton2);
		container.add(south, BorderLayout.SOUTH); 

		//Définition d'une police d'écriture
		Font police = new Font("Tahoma", Font.BOLD, 16);
		//On l'applique au JLabel
		label.setFont(police);
		//Changement de la couleur du texte
		label.setForeground(Color.blue); 
		//RFRF : ajout du JLabel centré
		label.setHorizontalAlignment(JLabel.CENTER); 
		container.add(label, BorderLayout.NORTH);
		container.add(labelCpt, BorderLayout.WEST);

		//Nous ajoutons notre fenêtre à la liste des auditeurs de notre bouton
		//		bouton.addActionListener(this);
		//		bouton2.addActionListener(this);
		//Ce sont maintenant nos classes internes qui écoutent nos boutons
		bouton.addActionListener(new BoutonListener());
		//Deuxième classe écoutant mon premier bouton
		//		bouton.addActionListener(new Bouton3Listener()); //RFRF : On peut mettre 2 listener sur un même bouton !

		bouton2.addActionListener(new ActionListener() {	//RFRF : Par classe anonyme : plus propre !
			//RFRF : Classe anonyme ! : On implémente ActionListener directement sans nom.
			//Redéfinition de la méthode actionPerformed()
			public void actionPerformed(ActionEvent e) {
				bouton2.setCptClic(bouton2.getCptClic()+1);
				label.setText("Vous avez cliqué sur le bouton 2");
				setNbClic();
			}
		}); 

		this.setContentPane(container);
		this.setVisible(true);
		go(); 
	}

	private void go() {
		//Les coordonnées de départ de notre rond
		int x = pan.getPosX(), y = pan.getPosY();
		//Le booléen pour savoir si l'on recule ou non sur l'axe x
		boolean backX = false;
		//Le booléen pour savoir si l'on recule ou non sur l'axe y
		boolean backY = false;
		//Dans cet exemple, j'utilise une boucle while
		//Vous verrez qu'elle fonctionne très bien
		while(true){
			//Si la coordonnée x est inférieure à 1, on avance
			if(x < 1)backX = false;
			//Si la coordonnée x est supérieure à la taille du Panneau moins la taille du rond, on recule
			if(x > pan.getWidth()-50)backX = true;
			//Idem pour l'axe y
			if(y < 1)backY = false;
			if(y > pan.getHeight()-50)backY = true;
			//Si on avance, on incrémente la coordonnée
			if(!backX)
				pan.setPosX(++x);
			//Sinon, on décrémente 
			else
				pan.setPosX(--x);
			//Idem pour l'axe Y
			if(!backY)
				pan.setPosY(++y);
			else
				pan.setPosY(--y);
			//On redessine notre Panneau
			pan.repaint();
			//Comme on dit : la pause s'impose ! Ici, trois millièmes de seconde
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		} 
	}


	//RFRF : modifié pour classe interne ? pour pouvoir affiner l actionPerformed selon l'objet utilise
	//	@Override
	//	public void actionPerformed(ActionEvent arg0) {	//RFRF : Ne pas oublier d'ajouter l'ActionListener dans constructeur !
	//		// Auto-generated method stub
	//		//		cptClic++;
	//
	//		if(arg0.getSource() == bouton) {
	//			bouton.setCptClic(bouton.getCptClic()+1);
	//			label.setText("Vous avez cliqué sur le bouton 1");
	//		}
	//		if(arg0.getSource() == bouton2) {
	//			bouton2.setCptClic(bouton2.getCptClic()+1);
	//			label.setText("Vous avez cliqué sur le bouton 2");
	//		}
	//		
	//		setNbClic();
	//	}

	//Classe écoutant notre second bouton
	class BoutonListener implements ActionListener {
		//Redéfinition de la méthode actionPerformed()
		public void actionPerformed(ActionEvent e) {
			bouton.setCptClic(bouton.getCptClic()+1);
			label.setText("Vous avez cliqué sur le bouton 1");
			setNbClic();
		}  
	}

		//RFRF : Déplacé en classe anonyme dans le constructeur !!!!
	//	//Classe écoutant notre second bouton
	//	class Bouton2Listener implements ActionListener {
	//		//Redéfinition de la méthode actionPerformed()
	//		public void actionPerformed(ActionEvent e) {
	//			bouton2.setCptClic(bouton2.getCptClic()+1);
	//			label.setText("Vous avez cliqué sur le bouton 2");
	//			setNbClic();
	//		}  
	//	}

	//	class Bouton3Listener implements ActionListener {
	//		//Redéfinition de la méthode actionPerformed()
	//		public void actionPerformed(ActionEvent e) {
	//			System.out.println("Ma classe interne numéro 3 écoute bien !");
	//		}
	//	} 

	private void setNbClic() {
		labelCpt.setForeground(Color.BLACK);
		labelCpt.setText(bouton.getCptClic()+bouton2.getCptClic()+"clics.");
	}

}

