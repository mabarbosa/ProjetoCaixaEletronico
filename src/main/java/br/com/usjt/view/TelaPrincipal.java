package br.com.usjt.view;

import java.net.URL;
import java.util.*;

import javax.swing.*;

import br.com.usjt.utils.BundleUtils;
import br.com.usjt.view.arq.Tela;

import java.awt.*;
import java.awt.event.*;

/**
 * Nome: TelaPrincipal
 * <p>Propósito: Tela de internacionalizacao</p>
 * Data: <06/10/2015>
 * @author sergio.junior  <br> 
 * copyright Copyright (c) 2015 <br> * </p>
 */
public class TelaPrincipal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JLabel lImagem;
	private ImageIcon iPrincipal;
	private JButton btn1, btn2, btn3;

	/**
	 * Nome: 
	 * <p>Propósito: </p>
	 * Data: <06/10/2015>
	 * @author sergio.junior  <br> 
	 * copyright Copyright (c) 2015 <br> * </p>
	 */
	public TelaPrincipal() {
		super("Caixa Eletrônico");

		URL url = TelaPrincipal.class.getClassLoader().getResource(
				"imagens/principal2.png");

		iPrincipal = new ImageIcon(url);
		lImagem = new JLabel();
		lImagem.setIcon(iPrincipal);

		btn1 = new JButton("Português");
		btn2 = new JButton("English");
		btn3 = new JButton("Español");

		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);

		painel = new JPanel(new GridLayout(1, 3));
		painel.add(btn1);
		painel.add(btn2);
		painel.add(btn3);

		Container tela = this.getContentPane();
		tela.setLayout(new BorderLayout());

		tela.add(lImagem, BorderLayout.NORTH);
		tela.add(painel, BorderLayout.SOUTH);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(995, 370));
		this.setLocation(100, 100);
		this.setVisible(true);
		this.pack();
	}

	/**
	 * Nome: exibeTela
	 * <p>Propósito:Metodo responsavel por exibir a tela </p>
	 * Data: <06/10/2015>
	 * @author sergio.junior  <br> 
	 * copyright Copyright (c) 2015 <br> * </p>
	 *
	 */
	public void exibeTela() {
		this.setVisible(false);
		new TelaAutenticacao();
	}

	/**
	 * Nome: 
	 * <p>Propósito: </p>
	 * Data: <06/10/2015>
	 * @author sergio.junior  <br> 
	 * copyright Copyright (c) 2015 <br> * </p>
	 * @param e
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == btn1) {
				BundleUtils.configureBundle("bundle/Messages", new Locale("pt",
						"BR"));
				exibeTela();
			} else if (e.getSource() == btn2) {
				BundleUtils.configureBundle("bundle/Messages", Locale.US);
				exibeTela();
			} else if (e.getSource() == btn3) {
				BundleUtils.configureBundle("bundle/Messages", new Locale("es",
						"AR"));
				exibeTela();
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this,
					"Ocorreu um erro ao processar sua solicitação.");
		}
	}
}