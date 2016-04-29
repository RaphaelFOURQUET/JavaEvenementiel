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

	public void control() {	//RFRF : control() identique pour chiffres et operateurs ? donc controle op relance � chaque chiffre ...bof
		//On notifie le mod�le d'une action si le contr�le est bon
		//--------------------------------------------------------

		//Si l'op�rateur est dans la liste
		if(this.listOperateur.contains(this.operateur)) {
			//Si l'op�rateur est =
			if(this.operateur.equals("="))
				this.calc.getResultat(); //On ordonne au mod�le d'afficher le r�sultat
			//Sinon, on passe l'op�rateur au mod�le
			else
				this.calc.setOperateur(this.operateur);
		}

		//Si le nombre est conforme
		//RFRF : REGEX ("^[0-9]+.?[0-9]*$") pour un chiffre mais ici, teste seulement le dernier nombre entr�
		if(this.nbre.matches("^[0-9.]$")) {
			if(!(this.nbre.equals(".") && this.calc.getOperande().contains(".")))
				this.calc.setNombre(this.nbre);	//A tester plus en profondeur.
		}
		this.operateur = "";
		this.nbre = "";
	}

}
