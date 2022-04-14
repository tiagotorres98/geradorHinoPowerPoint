package br.com.torres.praisePPGenerate.view.components;

import javax.swing.JTextField;

public class TextInput extends JTextField{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TextInput(int xPos, int yPos) {
		setVisible(true);
		setBounds(xPos,yPos,150,16);
	}

}
