/**
 * Nome: br.com.bradesco.web.gccf.view.bean
 * Data da Criação: 19/01/2015
 * Compilador: 1.5.0_16
 * Propósito: ${proposito_padrao_cabecalho}
 * Parâmetros de Compilação:
 */
package br.com.usjt.view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.text.*;
import javax.swing.border.*;

import br.com.usjt.model.dao.ContaDAO;
import br.com.usjt.model.dao.OperacaoDAO;
import br.com.usjt.model.entidades.ContaVO;
import br.com.usjt.model.negocio.ExtratoBO;
import br.com.usjt.security.DadosLogin;
import br.com.usjt.utils.BundleUtils;
import br.com.usjt.view.arq.Tela;

/**
 * Nome: TelaExtrato
 * <p>Propósito: Modela a tela de extrato</p>
 * Data: <23/09/2015>
 * @author sergio.junior <br>
 * copyright Copyright (c) 2013 <br> * </p>
 */
public class TelaExtrato extends Tela
{
	private static final long serialVersionUID = 1L;
	private JFormattedTextField data = null;
	private JTable tabela = null;
	private JButton voltar = null;

	/**
	 * Nome: TelaExtrato
	 * <p>Propósito: Metodo Contrutor</p>
	 * Data: <23/09/2015>
	 * @author sergio.junior<br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 */
	public TelaExtrato() {

		buildObjects();
		this.setTitle(BundleUtils.getString("titulo.tela.extrato"));
		JPanel center = new JPanel(new GridLayout(2, 1, 5, 5));
		center.setBorder(new EmptyBorder(30, 30, -10, 30));

		JPanel baixo = new JPanel(new GridLayout(1, 1, 5, 5));
		baixo.setBorder(new EmptyBorder(20, 0, 20, 0));
		JScrollPane barraRolagem = new JScrollPane(tabela);
		baixo.add(barraRolagem);

		center.add(baixo);

		Container con = this.getContentPane();
		con.add(center, BorderLayout.CENTER);

		JPanel south = new JPanel();
		south.setLayout(new GridLayout(1, 2, 5, 5));
		south.setBorder(new EmptyBorder(10, 70, 10, 70));

		voltar.addActionListener(new ExtratoControl());

		south.add(voltar);
		this.add(south, BorderLayout.SOUTH);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 450); // configura o tamanho do frame
		this.setVisible(true); // exibe o frame

	}

	/**
	 * Nome: buildObjects
	 * <p>Propósito: Metodo responsavel por construir os objetos</p>
	 * Data: <23/09/2015>
	 * @author sergio.junior <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 */
	private void buildObjects()
	{
		voltar = new JButton(BundleUtils.getString("botao.tela.voltar"));

		String[] colunas = { BundleUtils.getString("label.tela.extrato.data"),
							 BundleUtils.getString("label.tela.extrato.informacoes"),
							 BundleUtils.getString("label.tela.extrato.numero"),
							 BundleUtils.getString("label.tela.extrato.valor") };

		ExtratoBO extrato = new ExtratoBO();

		ContaDAO contaDao = new ContaDAO();
		ContaVO conta = contaDao.buscarSaldo(DadosLogin.banco, DadosLogin.agencia, DadosLogin.conta );

		Object[][] dados = extrato.getExtrato(conta);

		tabela = new JTable(dados, colunas);

		try {

			data = new JFormattedTextField(new MaskFormatter("##/##/####"));
			data.setColumns(50);

		} catch (Exception e) {

		}
	}

	//Controller - Extrato
	public class ExtratoControl implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == voltar)
			{
				TelaExtrato.this.setVisible(false);
				new TelaHome();
			}

		}

	}
}