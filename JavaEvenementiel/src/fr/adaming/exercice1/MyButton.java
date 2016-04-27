/**
 * 
 */
package fr.adaming.exercice1;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

/**
 * @author INTI-0332
 *
 */
@SuppressWarnings("serial")
public class MyButton extends JButton implements MouseListener {

	private String name;
	private Image img; 
//	private int nbClic = 0;
	private int cptClic = 0;

	public int getCptClic() {
		return this.cptClic;
	}
	
	public void setCptClic(int cptClic) {
		this.cptClic = cptClic;
	}

	public MyButton(String str){
		super(str);
		this.name = str;
		try {
			img = ImageIO.read(new File("IO/image.png"));
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		//Grâce à cette instruction, notre objet va s'écouter
		//Dès qu'un événement de la souris sera intercepté, il en sera averti
		this.addMouseListener(this);
	} 

	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		GradientPaint gp = new GradientPaint(0, 0, Color.BLUE, 0, 20, Color.CYAN, true);
		g2d.setPaint(gp);
		g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);	//RFRF : appliquer une image de fond au bouton.
		//		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		g2d.setColor(Color.BLACK);
		//RFRF : On ecrit son nom sur le bouton en noir.
		g2d.drawString(this.name, this.getWidth() / 2 - (this.getWidth()/ 2 /4), (this.getHeight() / 2) + 5);
	}

	//RFRF : On doit implémenter (même vide si pas besoin) toutes les méthodes de MouseListener

	@Override
	//Methode appelée lors du clic souris
	public void mouseClicked(MouseEvent arg0) {
		// Auto-generated method stub
//		cptClic++;		//RFRF : déplacé dans MyFrameAnimationButton
		
		//RFRF : désactivé pour la suite.
//		if(cptClic>10) {
//			System.out.println(this.name+" : \tLeave me alone !");
//			this.setEnabled(false);	//RFRF : on desactive le bouton !
//			try {
//				img = ImageIO.read(new File("IO/fondGris.png"));
//			} catch (IOException e) { 
//				e.printStackTrace();
//			}
//		}
		
//		System.out.println("Tu as cliqué sur ce bouton "+nbClic+" fois !");

	}

	@Override
	//Méthode appelée lors du survol de la souris 
	public void mouseEntered(MouseEvent arg0) {
		// Auto-generated method stub
		try {
			img = ImageIO.read(new File("IO/fondJaune.png"));
		} catch (IOException e) { 
			e.printStackTrace();
		}

	}

	@Override
	//Méthode appelée lorsque la souris sort de la zone du bouton
	public void mouseExited(MouseEvent arg0) {
		// Auto-generated method stub
		try {
			img = ImageIO.read(new File("IO/fondBleu.png"));
		} catch (IOException e) {
			e.printStackTrace(); 
		}

	}

	@Override
	//Méthode appelée lorsque l'on presse le bouton gauche de la souris 
	public void mousePressed(MouseEvent arg0) {
		// Auto-generated method stub
		try {
			img = ImageIO.read(new File("IO/fondRouge.png"));
		} catch (IOException e) { 
			e.printStackTrace();
		}

	}

	@Override
	//Méthode appelée lorsque l'on relâche le clic de souris 
	public void mouseReleased(MouseEvent event) {
		// Auto-generated method stub
		//		try {
		//			img = ImageIO.read(new File("IO/fondVert.png"));
		//		} catch (IOException e) { 
		//			e.printStackTrace();
		//		}
		
		//RFRF : petits bugs si presse sur le bouton et relache ailleurs pour corriger :
		if((event.getY() > 0 && event.getY() < this.getHeight())
				&& (event.getX() > 0 && event.getX() < this.getWidth())) {
			try {
				img = ImageIO.read(new File("IO/fondVert.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//Si on se trouve à l'extérieur, on dessine le fond par défaut
		else{
			try { 
				img = ImageIO.read(new File("IO/fondBleu.png")); 
			} catch (IOException e) { 
				e.printStackTrace(); 
			}
		} 

	}

}
