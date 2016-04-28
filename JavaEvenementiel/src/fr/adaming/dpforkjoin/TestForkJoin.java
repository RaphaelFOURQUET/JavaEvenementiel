/**
 * 
 */
package fr.adaming.dpforkjoin;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ForkJoinPool;

/**
 * @author INTI-0332
 *
 */
public class TestForkJoin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Auto-generated method stub
		Path chemin = Paths.get("C:\\Cours");
		String filtre = "*.txt";
		
		//Création de notre tâche principale qui se charge de découper son travail en sous-tâches
		FolderScannerFJ fs = new FolderScannerFJ(chemin, filtre);
		
		//Nous récupérons le nombre de processeurs disponibles (coeurs virtuels dispos)
		int processeurs = Runtime.getRuntime().availableProcessors();
		
		//Nous créons notre pool de thread pour nos tâches de fond
		ForkJoinPool pool = new ForkJoinPool(processeurs);
		
		long start = System.currentTimeMillis();
		
		//Nous lançons le traitement de notre tâche principale via le pool
		pool.invoke(fs);
		
		long end = System.currentTimeMillis();
		System.out.println("Il y a " + fs.getResultat() + " fichier(s) portant l'extension " + filtre);
		System.out.println("Temps de traitement : " + (end - start));

	}

}
