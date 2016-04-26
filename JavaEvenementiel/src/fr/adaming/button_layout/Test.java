/**
 * 
 */
package fr.adaming.button_layout;

/**
 * @author INTI-0332
 *
 */
public class Test {
	
	private static int NB_LAYOUT = 4;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Auto-generated method stub
		MyFrame myFrame = new MyFrame();
		myFrame.setVisible(true);	//RFRF : je n'ai pas mis le setVisible dans le constructeur pour ce cas.
		
		//RFRF : Affichage de tous mes Layouts.
		for(int i =0;i<NB_LAYOUT;i++)
			new MyFrame(i);

	}

}
