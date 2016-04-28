/**
 * 
 */
package fr.adaming.mvc;

/**
 * @author INTI-0332
 *
 */
public interface Observable {
	public void addObserver(Observer obs);
	public void removeObserver();
	public void notifyObserver(String str);

}
