package br.com.torres.praisePPGenerate.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.com.torres.praisePPGenerate.service.GeneratePP;

public class GenereteDataInput extends JPanel {

	private static final long serialVersionUID = 1L;

	private GridBagConstraints c;
	private JButton btn;
	private JTextField nmFile, nmSong, nmSinger;
	private JTextArea songLyrics;
	private String path;
	private JLabel label;

	public GenereteDataInput() throws IOException {
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
								songLyrics.getText(),path);
						JOptionPane.showMessageDialog(null, "Arquivo Gerado com Sucesso!");
						nmFile.setText("");
						nmSong.setText("");
						songLyrics.setText("");
						nmSinger.setText("");
					}
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "N�o foi poss�vel gerar o aquivo...");
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

	public void setGridConfig(int constraints, double weightx, int gridx, int gridy) {
		c.fill = constraints;
		c.weightx = weightx;
		c.gridx = gridx;
		c.gridy = gridy;
	}

	public void configComponents() {
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();

		label = new JLabel("Nome do arquivo");
		setGridConfig(GridBagConstraints.HORIZONTAL, 0.1, 1, 0);
		add(label, c);

		nmFile = new JTextField();
		setGridConfig(GridBagConstraints.HORIZONTAL, 0.5, 2, 0);
		add(nmFile, c);

		label = new JLabel("Nome do Hino");
		setGridConfig(GridBagConstraints.HORIZONTAL, 0.1, 1, 1);
		add(label, c);

		nmSong = new JTextField();
		setGridConfig(GridBagConstraints.HORIZONTAL, 0.5, 2, 1);
		add(nmSong, c);

		label = new JLabel("Nome do Artista");
		setGridConfig(GridBagConstraints.HORIZONTAL, 0.1, 1, 2);
		add(label, c);

		nmSinger = new JTextField();
		setGridConfig(GridBagConstraints.HORIZONTAL, 0.5, 2, 2);
		add(nmSinger, c);

		label = new JLabel(" ");
		setGridConfig(GridBagConstraints.HORIZONTAL, 0.5, 2, 3);
		add(label, c);

		label = new JLabel("Letra do Hino");
		setGridConfig(GridBagConstraints.HORIZONTAL, 0, 2, 4);
		add(label, c);

		songLyrics = new JTextArea();
		songLyrics.setLineWrap(true);
		songLyrics.setWrapStyleWord(true);
		JScrollPane scrolltxt = new JScrollPane();
		scrolltxt.setViewportView(songLyrics);
		scrolltxt.setWheelScrollingEnabled(true);
		setGridConfig(GridBagConstraints.HORIZONTAL, 0, 2, 5);
		c.ipady = 200;
		c.gridx = 1; // aligned with button 2
		c.gridwidth = 2; // 2 columns wide
		add(scrolltxt, c);

		btn = new JButton("Salvar");
		c.insets = new Insets(260, 0, 0, 0);
		c.ipady = 2;
		add(btn, c);

	}
}