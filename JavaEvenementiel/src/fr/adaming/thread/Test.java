/**	
 * 
 */
package fr.adaming.thread;

/**
 * @author INTI-0332
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Auto-generated method stub
		CompteEnBanque cb = new CompteEnBanque();
//		CompteEnBanque cb2 = new CompteEnBanque();
		Thread t = new Thread(new RunImpl(cb, "Cysboy"));
		Thread t2 = new Thread(new RunImpl(cb, "Zéro"));
		t.start();
		t2.start();

	}

}
