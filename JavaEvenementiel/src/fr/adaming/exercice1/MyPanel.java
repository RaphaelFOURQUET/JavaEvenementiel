/**
 * 
 */
package fr.adaming.exercice1;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComboBox;
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
		g.setColor(Color.WHITE);
		//On le dessine de sorte qu'il occupe toute la surface
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		//On redéfinit une couleur pour le rond
		g.setColor(Color.BLACK);
		//On le dessine aux coordonnées souhaitées
		g.fillOval(posX, posY, 30, 30); 
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
