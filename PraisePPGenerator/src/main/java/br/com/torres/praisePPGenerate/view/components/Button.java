package br.com.torres.praisePPGenerate.view.components;

import javax.swing.JButton;

public class Button extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Button(String text,int xPos, int yPos,int height, int width) {
		setText(text);
		setBounds(xPos, yPos, width, height);
		setVisible(true);
	}

}
