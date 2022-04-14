package br.com.torres.praisePPGenerate.view.components;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextAreaScroll extends JScrollPane{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TextAreaScroll(JTextArea textArea,int xPos, int yPos,int height, int width) {
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true); 
		setViewportView(textArea);
		setWheelScrollingEnabled(true);
		setVisible(true);
		setBounds(xPos, yPos, width, height);
		setBackground(Color.white);
	}

}
