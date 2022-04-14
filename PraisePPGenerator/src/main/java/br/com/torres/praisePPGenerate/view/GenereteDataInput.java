package br.com.torres.praisePPGenerate.view;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import br.com.torres.praisePPGenerate.service.GeneratePP;
import br.com.torres.praisePPGenerate.view.components.Button;
import br.com.torres.praisePPGenerate.view.components.Label;
import br.com.torres.praisePPGenerate.view.components.TextAreaScroll;
import br.com.torres.praisePPGenerate.view.components.TextInput;

public class GenereteDataInput extends JPanel {

	private static final long serialVersionUID = 1L;

	private Button btn;
	private TextInput nmFile, nmSong, nmSinger;
	private JTextArea songLyrics;
	private String path;

	public GenereteDataInput() throws IOException {
		setBackground(Color.white);
		setLayout(null);
		render();
	}

	public void render() throws IOException {
		configComponents();

		btn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					if (nmFile.getText().isEmpty() || nmSong.getText().isEmpty() || nmSinger.getText().isEmpty()
							|| songLyrics.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
					} else {
						getPath();
						new GeneratePP().generatePP(nmFile.getText(), nmSong.getText(), nmSinger.getText(),
								songLyrics.getText(), path);
						JOptionPane.showMessageDialog(null, "Arquivo Gerado com Sucesso!");
						nmFile.setText("");
						nmSong.setText("");
						songLyrics.setText("");
						nmSinger.setText("");
					}
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Não foi possível gerar o aquivo...");
				}
			}
		});

	}

	public void getPath() {
		JFileChooser file = new JFileChooser();
		file.setDialogTitle("Selecione o Local para Salvar");
		file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		file.showSaveDialog(this);
		path = file.getSelectedFile().getAbsolutePath();

	}

	public void configComponents() {

		nmFile = new TextInput(130, 20);
		nmSinger = new TextInput(130, 40);
		nmSong = new TextInput(130, 60);
		songLyrics = new JTextArea();
		btn = new Button("Salvar", 310, 225, 30, 260);

		add(new Label("Nome do Arquivo", 10, 20));
		add(nmFile);
		add(new Label("Nome do Cantor", 10, 40));
		add(nmSinger);
		add(new Label("Nome do Hino", 10, 60));
		add(nmSong);
		//add(new Label("Tamanho da Fonte", 10, 80));
		add(new Label("Letra do Hino", 400, 10));
		add(new TextAreaScroll(songLyrics, 310, 30, 190, 260));
		add(btn);
	}
}
