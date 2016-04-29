/**
 * 
 */
package fr.adaming.mvc.controler;

import fr.adaming.mvc.model.AbstractModel;

/**
 * @author INTI-0332
 *
 */
public class CalculetteControler extends AbstractControler {

	public CalculetteControler(AbstractModel cal) {
		super(cal);
	}

	public void control() {	//RFRF : control() identique pour chiffres et operateurs ? donc controle op relance à chaque chiffre ...bof
		//On notifie le modèle d'une action si le contrôle est bon
		//--------------------------------------------------------

		//Si l'opérateur est dans la liste
		if(this.listOperateur.contains(this.operateur)) {
			//Si l'opérateur est =
			if(this.operateur.equals("="))
				this.calc.getResultat(); //On ordonne au modèle d'afficher le résultat
			//Sinon, on passe l'opérateur au modèle
			else
				this.calc.setOperateur(this.operateur);
		}

		//Si le nombre est conforme
		//RFRF : REGEX ("^[0-9]+.?[0-9]*$") pour un chiffre mais ici, teste seulement le dernier nombre entré
		if(this.nbre.matches("^[0-9.]$")) {
			if(!(this.nbre.equals(".") && this.calc.getOperande().contains(".")))
				this.calc.setNombre(this.nbre);	//A tester plus en profondeur.
		}
		this.operateur = "";
		this.nbre = "";
	}

}
