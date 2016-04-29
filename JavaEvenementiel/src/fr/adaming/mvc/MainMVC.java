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
		
		//Instanciation de notre modèle
		AbstractModel calc = new Calculator();
		//Création du contrôleur
		AbstractControler controler = new CalculetteControler(calc);
		//Création de notre fenêtre avec le contrôleur en paramètre
		Calculette calculette = new Calculette(controler);
		//Ajout de la fenêtre comme observer de notre modèle
		calc.addObserver(calculette);

	}

}
