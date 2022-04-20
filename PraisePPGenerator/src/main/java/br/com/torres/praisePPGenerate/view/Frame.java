package br.com.torres.praisePPGenerate.view;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;

	public void render() {
		setSize(600, 300);
		setPreferredSize(new Dimension(600,300));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Gerador de Hinos em Power Point -  Develop by: Tiago Torres - V1.2.1");
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		pack();
	}
	
	public void renderProgressBar() {
		setSize(500, 50);
		setPreferredSize(new Dimension(500,50));
		setVisible(true);
		setLocationRelativeTo(null);
		pack();
	}
}
