package br.com.usjt.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.usjt.utils.BundleUtils;
import br.com.usjt.view.arq.Tela;

/**
 * Nome: TelaHome
 * <p>PropÃ³sito: </p>
 * Data: <06/10/2015>
 * @author sergio.junior  <br>
 * copyright Copyright (c) 2015 <br> * </p>
 */
public class TelaHome extends Tela {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private JButton btn_saque = null;

	private JButton btn_saldo = null;

	private JButton btn_extrato = null;

	private JButton btn_transferencia = null;

	private JButton btn_debito = null;

	/**
	 * Nome: TelaHome
	 * <p>PropÃ³sito: </p>
	 * Data: <06/10/2015>
	 * @author sergio.junior  <br>
	 * copyright Copyright (c) 2015 <br> * </p>
	 */
	public TelaHome() {
		this.buildObjects();
		this.setTitle(BundleUtils.getString("titulo.tela.extrato"));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel center = new JPanel(new GridLayout(3, 2, 10, 10));
		center.setBorder(new EmptyBorder(30, 30, -10, 30));

		center.add(btn_saque);
		center.add(btn_saldo);
		center.add(btn_extrato);
		center.add(btn_transferencia);
		center.add(btn_debito);

		Container con = this.getContentPane();
		con.add(center, BorderLayout.CENTER);

		this.setSize(600, 450); // configura o tamanho do frame
		this.setVisible(true); // exibe o frame
	}



	/**
	 * Nome: buildObjects
	 * <p>PropÃ³sito: Metodo responsavel por construir os objetos</p>
	 * <p>
	 * Data: <27/10/2015>
	 * @author sergio.junior  <br>
	 * copyright Copyright (c) 2015 <br> * </p>
	 *
	 */
	private void buildObjects() {

		btn_saque = new JButton(BundleUtils.getString("tela.main.menu.nivel2.saque"));
		btn_saldo = new JButton(BundleUtils.getString("tela.main.menu.nivel2.saldo"));
		btn_extrato = new JButton(BundleUtils.getString("tela.main.menu.nivel2.extrato"));
		btn_transferencia = new JButton(BundleUtils.getString("tela.main.menu.nivel2.transferencia"));
		btn_debito = new JButton(BundleUtils.getString("tela.main.menu.nivel2.cadastro"));

		EventHandler event = new EventHandler();

		btn_saque.addActionListener(event);
		btn_saldo.addActionListener(event);
		btn_extrato.addActionListener(event);
		btn_transferencia.addActionListener(event);
		btn_debito.addActionListener(event);
	}


	/**
	 * Nome: EventHandler
	 * <p>PropÃ³sito: </p>
	 * <p>
	 * Data: <27/10/2015>
	 * @author sergio.junior  <br>
	 * copyright Copyright (c) 2015 <br> * </p>
	 */
	public class EventHandler implements ActionListener {

		/**
		 * Nome: actionPerformed
		 * <p>PropÃ³sito: </p>
		 * <p>
		 * Data: <27/10/2015>
		 * @author sergio.junior  <br>
		 * copyright Copyright (c) 2015 <br> * </p>
		 * @param e
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent e) {
			//Verifica qual tela deve ser exibida
			if (e.getSource() == btn_saque) {
				new TelaSaque();

			} else if (e.getSource() == btn_saldo) {
				new TelaConsultarSaldo();

			} else if (e.getSource() == btn_extrato) {
				new TelaExtrato();

			} else if (e.getSource() == btn_transferencia) {
				new TelaTransferencia();

			} else if (e.getSource() == btn_debito) {
				new TelaDebitoAutomatico();
			}

			TelaHome.this.dispose();
		}
	}
}
