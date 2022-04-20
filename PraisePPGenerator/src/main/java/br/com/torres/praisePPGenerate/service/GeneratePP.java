package br.com.torres.praisePPGenerate.service;

import java.awt.Rectangle;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.sl.usermodel.Placeholder;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextShape;

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
		List<String> vLyrics = new ArrayList<String>(Arrays.asList(lyrics.split("\n")));
		int counter = 0;
		String text = "";
		XSLFSlide slide;
		XSLFTextShape titleShape = null;

		Iterator<String> lineLyrics = vLyrics.iterator();

		while (lineLyrics.hasNext()) {
			String line = lineLyrics.next();
			
			if (counter == 0 && !line.isEmpty()) {
				slide = ppt.createSlide();
				titleShape = slide.createTextBox();
				titleShape.setPlaceholder(Placeholder.CENTERED_TITLE);
				titleShape.setAnchor(new Rectangle(0, 100, 720, 200));
			}
			if (!line.isEmpty()) {
				text += line + "\n";
				counter++;
			}
			if (counter == 4) {
				titleShape.setText(text);
				counter = 0;
				text = "";
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
