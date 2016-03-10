
package br.com.usjt.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.usjt.utils.BundleUtils;

/**
 * Nome: TelaCadastro
 * <p>Propósito: Modela a tela de cadastro</p>
 * Data: <23/09/2015>
 * @author sergio.junior <br>
 * copyright Copyright (c) 2013 <br> * </p>
 */
public class TelaCadastro extends JFrame {

	/**
	 * Id para serializacao
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *
	 */
	private JButton bt_01 = null;
	/**
	 *
	 */
	private JButton bt_02 = null;
	/**
	 *
	 */
	private JButton bt_03 = null;
	/**
	 *
	 */
	private JButton bt_04 = null;
	/**
	 *
	 */
	private JButton bt_05 = null;

	/**
	 *
	 */
	private JButton confirmar = null;

	/**
	 *
	 */
	private JButton cancelar = null;


	/**
	 * Nome: TelaCadastro
	 * <p>Propósito: Metodo construtor</p>
	 * Data: <23/09/2015>
	 * @author sergio.junior<br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 */
	public TelaCadastro(){

		this.setTitle(BundleUtils.getString("titulo.tela.cadastro"));
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		buildObjects();

		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3,2,40,40));
		center.setBorder(new EmptyBorder(90, 110, 90, 110));

		center.add(bt_01);
		center.add(bt_04);
		center.add(bt_02);
		center.add(bt_05);
		center.add(bt_03);

		JPanel south = new JPanel();
		south.setLayout(new GridLayout(1, 2, 5, 5));
		south.setBorder(new EmptyBorder(10, 30, 10, 30));

		south.add(cancelar);
		south.add(confirmar);

		this.add(center,BorderLayout.CENTER);
		this.add(south,BorderLayout.SOUTH);
	   	this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	   	this.setLocationRelativeTo(null);
	   	this.setSize( 600, 450 ); // configura o tamanho do frame
	   	this.setVisible( true ); // exibe o frame

	}


	/**
	 * Nome: buildObjects
	 * <p>Propósito: Metodo responsavel por construir os objetos da tela</p>
	 * Data: <23/09/2015>
	 * @author sergio.junior <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 */
	private void buildObjects() {

		bt_01 = new JButton("0 - 1");
		bt_02 = new JButton("2 - 3");
		bt_03 = new JButton("4 - 5");
		bt_04 = new JButton("6 - 7");
		bt_05 = new JButton("8 - 9");

		confirmar = new JButton(BundleUtils.getString("botao.tela.confirmar"));
		cancelar = new JButton(BundleUtils.getString("botao.tela.cancelar"));

	}
}
