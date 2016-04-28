/**
 * 
 */
package fr.adaming.dpforkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author INTI-0332
 *
 */
@SuppressWarnings("serial")
public class CalculSuite extends RecursiveTask<Long> {	//RFRF : attention : utiliser Long ! (le type wrapper).

	private long debut = 0, fin = 0, resultat = 0;
	private final int SEUIL = 1_000;

	public CalculSuite(long debut, long fin) {
		this.debut = debut;
		this.fin = fin;
	}

	protected Long compute() {
		long nombreDeChoseAFaire = fin - debut;
		if(nombreDeChoseAFaire < SEUIL){
			System.out.println("Passage en mode MonoThread ou le d�coupage calcule le r�sultat");
			resultat = calculer();
		}
		else {
			System.out.println("Passage en mode Fork/Join");
			//On d�coupe la t�che en deux
			long milieu = nombreDeChoseAFaire/2;
			CalculSuite calcul1 = new CalculSuite(debut,(debut+milieu)-1);
			calcul1.fork();	//RFRF : le fork appellera le compute()
			CalculSuite calcul2 = new CalculSuite(debut + milieu, fin);
			resultat = calcul2.compute() + calcul1.join();
		}
		return resultat;
	}

	public long calculer() {
		for(long i = debut; i <= fin; i++) {
			System.out.println(resultat + " + " + i);
			resultat += i;
		}
		return resultat;
	}

	public long getResultat() {
		return resultat;
	}

	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();
		CalculSuite calcul = new CalculSuite(0, 100_000);
		pool.invoke(calcul);
		System.out.println("R�sultat du calcul : " + calcul.getResultat());
	}

}
