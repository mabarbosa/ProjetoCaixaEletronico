package br.com.usjt.view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.border.*;

import br.com.usjt.model.negocio.ContaBO;
import br.com.usjt.utils.BundleUtils;
import br.com.usjt.view.arq.Tela;

/**
 * Nome:TelaConsultarSaldo
 * <p>PropÃ³sito:  Modela a tela de consulta saldo </p>
 * Data: <23/09/2015>
 * @author sergio.junior <br>
 * copyright Copyright (c) 2013 <br> * </p>
 */
public class TelaConsultarSaldo extends Tela {

	/**
	 * Id de serializacao
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *Classe de neogcio
	 */
	private ContaBO contaBO = null;
	/**
	 *
	 */
	private JTable tabela = null;

	/**
	 *
	 */
	private JButton btn_voltar = null;

	/**
	 *
	 */
	private JLabel btn_empty = null;
	/**
	 * Nome: TelaConsultarSaldo
	 * <p>PropÃ³sito: Contrutor</p>
	 * Data: <23/09/2015>
	 * @author sergio.junior<br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 */
	public TelaConsultarSaldo() {

		super();
		contaBO = new ContaBO();

		buildObjects();
		Container con = this.getContentPane();
		this.setTitle(BundleUtils.getString("titulo.tela.saldo"));

		JPanel center = new JPanel();

		center.setLayout(new GridLayout(1, 1, 5, 5));
		center.setBorder(new EmptyBorder(70, 70, 0, 70));
		JScrollPane barraRolagem = new JScrollPane(tabela);
		barraRolagem.setPreferredSize(new Dimension(50, 30));

		JPanel south = new JPanel();
		south.setLayout(new GridLayout(1, 2, 5, 5));
		south.setBorder(new EmptyBorder(70, 70, 70, 70));
		south.add(btn_voltar);
		south.add(btn_empty);

		center.add(barraRolagem);
		con.add(center, BorderLayout.CENTER);
		con.add(south , BorderLayout.SOUTH);

		this.setSize( 600, 450 );
	   	this.setVisible( true );

	}

	/**
	 * Nome: buildObjects
	 * <p>PropÃ³sito: Metodo responsavel por construir os objetos</p>
	 * Data: <23/09/2015>
	 * @author sergio.junior <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 */
	private void buildObjects() {
		btn_empty = new JLabel("");
		btn_voltar = new JButton(BundleUtils.getString("botao.tela.voltar"));
		btn_voltar.addActionListener(new EventHandler());

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();


		String [] colunas = {BundleUtils.getString("label.tela.saldo.data"), BundleUtils.getString("label.tela.saldo.saldoconrrente")};

		Object [][] dados =   { {dateFormat.format(cal.getTime())  ,  "R$  " + contaBO.consultaSaldo() }};

		tabela = new JTable(dados, colunas);

	}

	/**
	 * Nome: EventHandler
	 * <p>PropÃ³sito: </p>
	 * Data: <27/10/2015>
	 * @author sergio.junior  <br>
	 * copyright Copyright (c) 2015 <br> * </p>
	 */
	public class EventHandler implements ActionListener {

		/**
		 * Nome: EventHandler
		 * <p>PropÃ³sito: </p>
		 * <p>
		 * Data: <27/10/2015>
		 * @author sergio.junior  <br>
		 * copyright Copyright (c) 2015 <br> * </p>
		 * @param e
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent e) {
			new TelaHome();
			TelaConsultarSaldo.this.dispose();
		}
	}
}