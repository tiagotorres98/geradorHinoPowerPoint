package br.com.torres.praisePPGenerate;

import java.io.IOException;

import br.com.torres.praisePPGenerate.view.Frame;
import br.com.torres.praisePPGenerate.view.GenereteDataInput;

public class PraisePPGenerateAplication{

	public static void main(String[] args) throws IOException {
		Frame frame = new Frame();
		frame.add(new GenereteDataInput());
		frame.render();
	}
}
