/**
 * Nome: br.com.bradesco.web.gccf.view.bean
 * Data da CriaÃ§Ã£o: 19/01/2015
 * Compilador: 1.6.0_16
 * PropÃ³sito: ${proposito_padrao_cabecalho}
 * ParÃ¢metros de CompilaÃ§Ã£o:
 */
package br.com.usjt.view.arq;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

import javax.swing.border.*;

import br.com.usjt.model.negocio.Cliente;
import br.com.usjt.utils.BundleUtils;

/**
 * Nome: Tela
 * <p>PropÃ³sito: Modela a tela de modelo</p>
 * <p>
 * Data: <23/09/2015>
 * @author sergio.junior <br>
 * copyright Copyright (c) 2013 <br> * </p>
 */
public class Tela extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	private JLabel nome, aux;


	private Cliente cliente = null;
	/**
	 * Nome:Tela
	 * <p>PropÃ³sito: Metodo responsavel por construir os objetos</p>
	 * Data: <23/09/2015>
	 * @author sergio.junior<br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 */
	public Tela() {
		cliente = new Cliente();
		buildObjects();

		JPanel north = new JPanel();
		north.setLayout(new GridLayout(1, 2, 5, 5));
		north.add(aux);
		north.add(nome);

		JPanel sout = new JPanel();
		sout.setLayout(new GridLayout(1, 2, 20, 20));
		sout.setBorder(new EmptyBorder(70, 70, 10, 70));

		Container con = getContentPane();
		con.setLayout(new BorderLayout(10, 10));
		con.add(north, BorderLayout.NORTH);
		con.add(sout, BorderLayout.SOUTH);
		this.setLocationRelativeTo(null);
	}

	/**
	 * Nome: buildObjects
	 * <p>PropÃ³sito:Metodo responsavel por construir os objetos da tela principal </p>
	 * Data: <23/09/2015>
	 * @author sergio.junior <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 */
	private void buildObjects() {

		nome = new JLabel(BundleUtils.getString("label.tela.main.ident") + cliente.buscaClienteLogado());
		aux = new JLabel("");
	}

}