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
			System.out.println("Vous �tes � d�couvert !");
		return this.solde;
	}

	public synchronized void retraitArgent(int retrait) {	//RFRF : synchronized !
		/*Il vous suffit d'ajouter dans la d�claration de la m�thode le mot cl� synchronized,
		 *  gr�ce auquel la m�thode est inaccessible � un thread si elle est d�j� utilis�e par un autre thread.
		 *   Ainsi, les threads cherchant � utiliser des m�thodes d�j� prises en charge par un autre thread
		 *    sont plac�s dans une � liste d'attente �.*/
		solde = solde - retrait;
		System.out.println("Solde = " + solde);
	}

}
