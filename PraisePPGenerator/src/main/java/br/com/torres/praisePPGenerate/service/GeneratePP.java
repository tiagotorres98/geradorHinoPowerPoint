package br.com.torres.praisePPGenerate.service;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Placeholder;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextRun;
import org.apache.poi.xslf.usermodel.XSLFTextShape;

import br.com.torres.praisePPGenerate.view.ProgressBar;

public class GeneratePP {

	public void generatePP(String nmFile, String nmSong, String nmSinger, String songLyrics, String path)
			throws IOException {
		XMLSlideShow ppt = new XMLSlideShow();
		generateFirstSlide(ppt, nmSong, nmSinger);
		generateLyricsSlide(ppt, songLyrics);
		FileOutputStream out = new FileOutputStream(path + "\\" + nmFile + ".pptx");
		ppt.write(out);
		out.close();
	}

	public void generateLyricsSlide(XMLSlideShow ppt, String lyrics) {
		String[] vLyrics = lyrics.split("\n");
		int j = 0;
		String t = "";
		XSLFSlide slide;
		XSLFTextShape titleShape = null;

		for (int i = 0; i < vLyrics.length; i++) {
			if (j == 0 && !vLyrics[i].isEmpty()) {
				slide = ppt.createSlide();
				titleShape = slide.createTextBox();
				titleShape.setPlaceholder(Placeholder.CENTERED_TITLE);
				titleShape.setAnchor(new Rectangle(0, 100, 720, 200));
			}
			if (!vLyrics[i].isEmpty()) {
				t += vLyrics[i];
				t += "\n";
				j++;
			}
			if (j == 4) {
				titleShape.setText(t);
				j = 0;
				t = "";

			}

		}

	}

	public void generateFirstSlide(XMLSlideShow ppt, String singer, String song) {
		XSLFSlide slide = ppt.createSlide();
		XSLFTextShape titleShape = slide.createTextBox();
		titleShape.setPlaceholder(Placeholder.CENTERED_TITLE);
		titleShape.setText(singer);
		titleShape.setAnchor(new Rectangle(0, 200, 720, 70));

		titleShape = slide.createTextBox();
		titleShape.setPlaceholder(Placeholder.BODY);
		titleShape.setText(song);
		titleShape.setAnchor(new Rectangle(0, 280, 720, 70));

	}

}
