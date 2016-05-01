/**
 * 
 */
package fr.adaming.regex;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.PatternSyntaxException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author INTI-0332
 *	Frame pour tester des RegEx.
 */
@SuppressWarnings("serial")
public class RegEx extends JFrame {
	
	private String regEx = "";
	private String exp = "";
	
	private JPanel container = new JPanel();
	
	private JTextField textRegEx = new JTextField();
	private JLabel  labelRegEx = new JLabel("RegEx :");
	
	private JTextField textTestExp = new JTextField();
	private JLabel labelTestExp = new JLabel("Expression :");
	
	private JLabel res = new JLabel("Res :");
	private JTextField textRes = new JTextField();
	
	private Dimension dim = new Dimension(100, 40);
	
	/**
	 * @return the regEx
	 */
	public String getRegEx() {
		return regEx;
	}

	/**
	 * @param regEx the regEx to set
	 */
	public void setRegEx(String regEx) {
		this.regEx = regEx;
	}

	/**
	 * @return the exp
	 */
	public String getExp() {
		return exp;
	}

	/**
	 * @param exp the exp to set
	 */
	public void setExp(String exp) {
		this.exp = exp;
	}

	public RegEx() {
		this.setSize(500, 130);
		this.setTitle("RegEx");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		initcomposants();
		
		this.setContentPane(container);
		this.setVisible(true);
	}

	private void initcomposants() {
		// Auto-generated method stub
		labelRegEx.setPreferredSize(dim);
		container.add(labelRegEx);
		textRegEx.setPreferredSize(dim);
		container.add(textRegEx);
		textRegEx.addKeyListener(new RegEXListener());
		
		container.add(labelTestExp);
		labelTestExp.setPreferredSize(dim);
		container.add(textTestExp);
		textTestExp.setPreferredSize(dim);
		textTestExp.addKeyListener(new ExpListener());
		
		container.add(res);
		res.setPreferredSize(dim);
		container.add(textRes);
		textRes.setPreferredSize(new Dimension(200, 40));
		//textRes.setBackground(Color.GREEN);
		textRes.setEnabled(false);
		
	}
	
	private void reponse(boolean b) {
		if(b) {
			textRes.setText("OK !");
			textRes.setBackground(Color.GREEN);
		} else {
			textRes.setText("WRONG !");
			textRes.setBackground(Color.RED);
		}
	}
	
	private void verifyRegEx() {
		try {
			reponse( exp.matches(regEx) );
		} catch (PatternSyntaxException e) {
			textRes.setBackground(Color.RED);
			textRes.setText("Not a valid RegEx !");
			//e.printStackTrace();
		}
	}
	
	//Listeners
	class RegEXListener implements KeyListener {
		@Override
		public void keyPressed(KeyEvent arg0) {
			setRegEx(((JTextField)arg0.getSource()).getText());
			verifyRegEx();
		}
		
		@Override
		public void keyReleased(KeyEvent arg0) {
			setRegEx(((JTextField)arg0.getSource()).getText());
			verifyRegEx();
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			setRegEx(((JTextField)arg0.getSource()).getText());
			verifyRegEx();
		}
		
	}
	
	class ExpListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			setExp(((JTextField)e.getSource()).getText());
			verifyRegEx();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			setExp(((JTextField)e.getSource()).getText());
			verifyRegEx();
		}

		@Override
		public void keyTyped(KeyEvent e) {
			setExp(((JTextField)e.getSource()).getText());
			verifyRegEx();
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Auto-generated method stub
		new RegEx();
	}

}
