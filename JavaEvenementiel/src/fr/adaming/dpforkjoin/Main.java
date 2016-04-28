/**
 * 
 */
package fr.adaming.dpforkjoin;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author INTI-0332
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {	//Methode avant forkjoin
		// Auto-generated method stub
		Path chemin = Paths.get("C:\\Cours");
		String filtre = "*.txt";
		FolderScanner fs = new FolderScanner(chemin, filtre);
		try {
			long start = System.currentTimeMillis();
			long resultat = fs.sequentialScan();
			long end = System.currentTimeMillis();
			System.out.println("Il y a " + resultat + " fichier(s) portant l'extension " + filtre);
			System.out.println("Temps de traitement : " + (end - start));
		} catch (ScanException e) {
			e.printStackTrace();
		}
	}

}

