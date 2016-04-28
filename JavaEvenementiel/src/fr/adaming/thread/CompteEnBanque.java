/**
 * 
 */
package fr.adaming.thread;

/**
 * @author INTI-0332
 *
 */
public class CompteEnBanque {
	private int solde = 100;

	public int getSolde() {
		if(this.solde < 0)
			System.out.println("Vous êtes à découvert !");
		return this.solde;
	}

	public synchronized void retraitArgent(int retrait) {	//RFRF : synchronized !
		/*Il vous suffit d'ajouter dans la déclaration de la méthode le mot clé synchronized,
		 *  grâce auquel la méthode est inaccessible à un thread si elle est déjà utilisée par un autre thread.
		 *   Ainsi, les threads cherchant à utiliser des méthodes déjà prises en charge par un autre thread
		 *    sont placés dans une « liste d'attente ».*/
		solde = solde - retrait;
		System.out.println("Solde = " + solde);
	}

}
