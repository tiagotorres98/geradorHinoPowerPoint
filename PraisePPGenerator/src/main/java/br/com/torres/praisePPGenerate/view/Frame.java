package br.com.torres.praisePPGenerate.view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;

	public void render() {
		setSize(300, 500);
		setPreferredSize(new Dimension(300,500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		pack();
		setName("Gerador - Hinos para PowerPoint");
	}
	
	public void renderProgressBar() {
		setSize(500, 50);
		setPreferredSize(new Dimension(500,50));
		setVisible(true);
		setLocationRelativeTo(null);
		pack();
	}
}
