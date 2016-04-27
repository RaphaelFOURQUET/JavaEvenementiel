/**
 * 
 */
package fr.adaming.dp.observer;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author INTI-0332
 *
 */
public class Horloge implements IObservable {
	//Objet calendrier pour récupérer l'heure courante
	private Calendar cal;
	private String hour = "";

	//Notre collection d'observateurs
	private ArrayList<IObservateur> listObservateur = new ArrayList<IObservateur>();

	public void run() {
		while(true) {
			//On récupère l'instance d'un calendrier à chaque tour
			//Elle va nous permettre de récupérer l'heure actuelle
			this.cal = Calendar.getInstance();
			this.hour =  //Les heures
					this.cal.get(Calendar.HOUR_OF_DAY) + " : "
					+
					(    //Les minutes
							(this.cal.get(Calendar.MINUTE) < 10 ? "0" : "") + this.cal.get(Calendar.MINUTE)
							)
					+ " : "
					+
					(    //Les secondes
							(this.cal.get(Calendar.SECOND)< 10 ? "0" : "") + this.cal.get(Calendar.SECOND)
							);
			
			//On avertit les observateurs que l'heure a été mise à jour
			this.updateObservateur();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void addObservateur(IObservateur obs) {
		this.listObservateur.add(obs);
	}

	//Retire tous les observateurs de la liste
	public void delObservateur() {
		this.listObservateur = new ArrayList<IObservateur>();
	}

	//Avertit les observateurs que l'objet observable a changé et invoque la méthode update() de chaque observateur
	public void updateObservateur() {
		for(IObservateur obs : this.listObservateur )
			obs.update(this.hour);
	}

}
