package br.com.torres.praisePPGenerate.view.components;

import javax.swing.JLabel;

public class Label extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Label(String textLabel,int xPos, int yPos) {
		setText(textLabel);
		setVisible(true);
		setBounds(xPos,yPos,getMaximumSize().width,getMaximumSize().height);
	}

}
