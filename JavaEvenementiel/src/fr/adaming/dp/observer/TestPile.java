/**
 * 
 */
package fr.adaming.dp.observer;

/**
 * @author INTI-0332
 *
 */
public class TestPile {

	public TestPile(){
		System.out.println("D�but constructeur");
		methode1();
		System.out.println("Fin constructeur");
	}

	public void methode1(){
		System.out.println("D�but m�thode 1");
		methode2();
		System.out.println("Fin m�thode 1");
	}

	public void methode2(){
		System.out.println("D�but m�thode 2");
		methode3();
		System.out.println("Fin m�thode 2");
	}

	public void methode3(){
		System.out.println("D�but m�thode 3");
		System.out.println("Fin m�thode 3"); 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Auto-generated method stub
		new TestPile();
	}

}
