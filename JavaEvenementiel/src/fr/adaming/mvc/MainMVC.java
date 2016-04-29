/**
 * 
 */
package fr.adaming.mvc;

import fr.adaming.mvc.controler.AbstractControler;
import fr.adaming.mvc.controler.CalculetteControler;
import fr.adaming.mvc.model.AbstractModel;
import fr.adaming.mvc.model.Calculator;
import fr.adaming.mvc.vue.Calculette;

/**
 * @author INTI-0332
 *
 */
public class MainMVC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Auto-generated method stub
		
		//Instanciation de notre mod�le
		AbstractModel calc = new Calculator();
		//Cr�ation du contr�leur
		AbstractControler controler = new CalculetteControler(calc);
		//Cr�ation de notre fen�tre avec le contr�leur en param�tre
		Calculette calculette = new Calculette(controler);
		//Ajout de la fen�tre comme observer de notre mod�le
		calc.addObserver(calculette);

	}

}
