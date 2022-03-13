package br.com.torres.praisePPGenerate.view;

import javax.swing.JProgressBar;

import lombok.Getter;

@Getter
public class ProgressBar extends JProgressBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int barValue = 0;

	private Frame f;

	public ProgressBar() {
		render();
	}

	public void render() {
		f = new Frame();
		f.renderProgressBar();
		setBounds(40, 40, 500, 50);
		setStringPainted(true);
		setValue(barValue);
		setMaximum(100);
		f.add(this);
	}

	public void updateValue(int v) {
		setValue(barValue + v);
	}

}
