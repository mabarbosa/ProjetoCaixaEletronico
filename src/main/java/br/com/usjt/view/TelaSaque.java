package br.com.usjt.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.usjt.model.dao.ContaDAO;
import br.com.usjt.model.dao.SaqueDAO;
import br.com.usjt.model.negocio.Saque;
import br.com.usjt.utils.BundleUtils;
import br.com.usjt.view.TelaExtrato.ExtratoControl;
import br.com.usjt.view.arq.Tela;

/**
 * Nome:
 * <p>PropÃ³sito: </p>
 * Data: <10/05/2015>
 * @author Sergio Teixeira <br>
 * copyright Copyright (c) 2013 <br> * </p>
 */

public class TelaSaque extends Tela {

	/**
	 * Id para serializacao
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	private JLabel dispenser = null;

	/**
	 *
	 */
	private JButton voltar = null;

	/**
	 *
	 */
	private JButton sacar = null;

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
	private JButton bt_06 = null;

	/**
	 *
	 */
	private JTextField input = null;

	/**
	 * Nome: TelaSaque
	 * <p>PropÃ³sito: Modela a tela de saque </p>
	 * <p>
	 * Data: <23/09/2015>
	 * @author sergio.junior<br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 */
	public TelaSaque()
	{
		super();

		this.buildObjects();

		this.setTitle(BundleUtils.getString("titulo.tela.saque"));
		JPanel center = new JPanel(new GridLayout(2, 1, 5, 5));
		center.setBorder(new EmptyBorder(30, 30, -10, 30));

		JPanel cima = new JPanel(new GridLayout(4, 1, 5, 5));
		cima.add(dispenser);
		cima.setBorder(new EmptyBorder(0, 90, 0, 0));

		JPanel baixo = new JPanel(new BorderLayout(5,5));
		baixo.setBorder(new EmptyBorder(20, 0, 20, 0));

		JPanel esquerda =  new JPanel(new GridLayout(3,1,5,5));
		bt_01.addActionListener(new SaqueControl());
		esquerda.add(bt_01);
		bt_02.addActionListener(new SaqueControl());
		esquerda.add(bt_02);
		bt_03.addActionListener(new SaqueControl());
		esquerda.add(bt_03);

		JPanel direita =  new JPanel(new GridLayout(3,1,5,5));
		bt_04.addActionListener(new SaqueControl());
		direita.add(bt_04);
		bt_05.addActionListener(new SaqueControl());
		direita.add(bt_05);
		bt_06.addActionListener(new SaqueControl());
		direita.add(bt_06);

		baixo.add(esquerda, BorderLayout.WEST);
		baixo.add(direita, BorderLayout.EAST);
		baixo.add(input,BorderLayout.CENTER);

		center.add(cima);
		center.add(baixo);

		JPanel sout = new JPanel();
		sout.setLayout(new GridLayout(1, 2, 20, 20));
		sout.setBorder(new EmptyBorder(70, 70, 10, 70));

		voltar.addActionListener(new SaqueControl());
		sout.add(voltar);

		sacar.addActionListener(new SaqueControl());
		sout.add(sacar);

		Container con = this.getContentPane();
		con.add(center, BorderLayout.CENTER);
		con.add(sout,BorderLayout.SOUTH);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 450); // configura o tamanho do frame
		this.setVisible(true); // exibe o frame
	}

	/**
	 * Nome: buildObjects
	 * <p>PropÃ³sito: Metodo responsavel por construir os objetos da tela</p>
	 * Data: <23/09/2015>
	 * @author sergio.junior <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 */
	private void buildObjects()
	{

		SaqueDAO saqueDao = new SaqueDAO();

		dispenser = new JLabel(BundleUtils.getString("label.tela.saque.cedulas") + saqueDao.getNotasDisponiveis());

		voltar = new JButton(BundleUtils.getString("botao.tela.voltar"));
		sacar = new JButton(BundleUtils.getString("botao.tela.sacar"));

		bt_01 = new JButton("R$ 20,00");
		bt_02 = new JButton("R$ 50,00");
		bt_03 = new JButton("R$ 100,00");
		bt_04 = new JButton("R$ 200,00");
		bt_05 = new JButton("R$ 500,00");
		bt_06 = new JButton("R$ 1000,00");

		input = new JTextField(10);
		input.setText("0,00");

		/*
		try
		{
			input = new JFormattedTextField(new MaskFormatter("R$ ####,##"));
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		*/
	}

	//Controller - Extrato
	public class SaqueControl implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == voltar)
			{
				TelaSaque.this.setVisible(false);
				new TelaHome();
			}
			else if(e.getSource() == bt_01)
			{
				input.setText("20,00");
			}
			else if(e.getSource() == bt_02)
			{
				input.setText("50,00");
			}
			else if(e.getSource() == bt_03)
			{
				input.setText("100,00");
			}
			else if(e.getSource() == bt_04)
			{
				input.setText("200,00");
			}
			else if(e.getSource() == bt_05)
			{
				input.setText("500,00");
			}
			else if(e.getSource() == bt_06)
			{
				input.setText("1000,00");
			}
			else if(e.getSource() == sacar)
			{
				try
				{
					Double valorSaque = Double.parseDouble(input.getText().replace(',', '.'));

					Saque s = new Saque();

					if(s.executaSaque(valorSaque))
					{
						JOptionPane.showMessageDialog(null, "Saque Realizado Com Sucesso!");
						input.setText("0,00");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Saldo Insuficiente para sacar este valor!");
					}
				}
				catch(Exception ex)
				{
					//
				}
			}
		}

	}
}
