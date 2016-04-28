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
		
		//Cr�ation de notre t�che principale qui se charge de d�couper son travail en sous-t�ches
		FolderScannerFJ fs = new FolderScannerFJ(chemin, filtre);
		
		//Nous r�cup�rons le nombre de processeurs disponibles (coeurs virtuels dispos)
		int processeurs = Runtime.getRuntime().availableProcessors();
		
		//Nous cr�ons notre pool de thread pour nos t�ches de fond
		ForkJoinPool pool = new ForkJoinPool(processeurs);
		
		long start = System.currentTimeMillis();
		
		//Nous lan�ons le traitement de notre t�che principale via le pool
		pool.invoke(fs);
		
		long end = System.currentTimeMillis();
		System.out.println("Il y a " + fs.getResultat() + " fichier(s) portant l'extension " + filtre);
		System.out.println("Temps de traitement : " + (end - start));

	}

}
