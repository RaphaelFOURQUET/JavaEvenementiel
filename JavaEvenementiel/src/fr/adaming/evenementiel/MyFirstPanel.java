/**
 * 
 */
package fr.adaming.evenementiel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * @author INTI-0332
 *
 */
@SuppressWarnings("serial")
public class MyFirstPanel extends JPanel {

	public void paintComponent(Graphics g){
		//Vous verrez cette phrase chaque fois que la méthode sera invoquée
		System.out.println("Appel paintComponent(Graphics g) : Je spamme ta console à chaque redimensionnement et j'en suis fier !");
		this.setBackground(Color.RED);	//RFRF : TODO ne marche plus ?

		g.fillOval(this.getWidth()/4, this.getHeight()/4, this.getWidth()/2, this.getHeight()/2);

		g.drawOval(this.getWidth()/16, this.getHeight()/16, this.getWidth()/4, this.getHeight()/4);
		g.drawOval(11*this.getWidth()/16, this.getHeight()/16, this.getWidth()/4, this.getHeight()/4);

		g.drawRoundRect(5, 5, this.getWidth()-10, this.getHeight()-10, 10, 10);

		//RFRF : drawLine
		g.drawLine(0, 0, this.getWidth(), this.getHeight());
		g.drawLine(0, this.getHeight(), this.getWidth(), 0);

		//RFRF : drawString
		g.setFont(new Font("Courier", Font.BOLD, 20));
		g.setColor(Color.BLUE);
		g.drawString("Tiens ! Le Site du Zéro !", 20, 20);

		//RFRF : drawImage(Image img, int x, int y, Observer obs);
		try { 
			Image img = ImageIO.read(new File("IO/image.png"));
			//g.drawImage(img, 0, 0, this);	//RFRF : taille reelle de l'image.
			//Pour une image de fond
			g.drawImage(img, 5, this.getHeight()/2, this.getWidth()/8, this.getHeight()/8, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
