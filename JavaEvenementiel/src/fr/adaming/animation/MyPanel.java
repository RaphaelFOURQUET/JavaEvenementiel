/**
 * 
 */
package fr.adaming.animation;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * @author INTI-0332
 *
 */
@SuppressWarnings("serial")
public class MyPanel extends JPanel {

	private int posX = -50;
	private int posY = -50;

	public void paintComponent(Graphics g){
		//RFRF : On dessine un rectangle blanc pour "effacer" le cadre
		//On choisit une couleur de fond pour le rectangle
		g.setColor(Color.white);
		//On le dessine de sorte qu'il occupe toute la surface
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		//On redéfinit une couleur pour le rond
		if((posX%100)<=50)	//RFRF : Selon la position vert ou rouge
			g.setColor(Color.GREEN);
		else g.setColor(Color.RED);
		//On le dessine aux coordonnées souhaitées
		g.fillOval(posX, posY, 50, 50); 
	}

	public int getPosX() {
		return posX;
	}  

	public void setPosX(int posX) {
		this.posX = posX; 
	}  

	public int getPosY() { 
		return posY; 
	}

	public void setPosY(int posY) { 
		this.posY = posY; 
	} 

}
