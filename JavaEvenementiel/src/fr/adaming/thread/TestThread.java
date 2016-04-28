/**
 * 
 */
package fr.adaming.thread;

/**
 * @author INTI-0332
 *
 */
public class TestThread extends Thread {	//RFRF : pas d'héritage multiple, si besoin méthode 2 : interface Runnable.
													//Voir exemple Test avec CompteEnBanque et RunImpl.
	Thread t;

	public TestThread(String name){
		super(name);
		System.out.println("statut du thread " + name + " = "
				+this.getState());
		this.start();
		System.out.println("statut du thread " + name + " = "
				+this.getState());
	}

	public TestThread(String name, Thread t){
		super(name);
		this.t = t;
		System.out.println("statut du thread " + name + " = "
				+this.getState());
		this.start();
		System.out.println("statut du thread " + name + " = "
				+this.getState());
	}

	public void run(){
		for(int i = 0; i < 20; i++){
			System.out.println("statut " + this.getName() + " = "
					+this.getState());
			if(t != null)
				System.out.println("statut de " + t.getName() + " pendant le thread " + this.getName() +" = " +t.getState());
		}
	}

	public void setThread(Thread t){
		this.t = t;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Auto-generated method stub
		System.out.println("Le nom du thread principal est " +
				Thread.currentThread().getName());

		TestThread tt = new TestThread("A");
		TestThread t2 = new TestThread(" B", tt);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("statut du thread " + tt.getName() + " = " +
				tt.getState());
		System.out.println("statut du thread " + t2.getName() + " = "
				+t2.getState());
	}

}
