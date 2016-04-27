/**
 * 
 */
package fr.adaming.dp.observer;

/**
 * @author INTI-0332
 *
 */
public interface IObservable {
	
	public void addObservateur(IObservateur obs);
	public void updateObservateur();
	public void delObservateur();

}
