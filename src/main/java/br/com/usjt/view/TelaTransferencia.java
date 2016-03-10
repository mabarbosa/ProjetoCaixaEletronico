
package br.com.usjt.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import br.com.usjt.model.entidades.TransferenciaVO;
import br.com.usjt.model.negocio.Transferencia;
import br.com.usjt.utils.BundleUtils;
import br.com.usjt.utils.DadosLogin;
import br.com.usjt.view.arq.Tela;

import java.awt.event.*;
import java.awt.*;
import java.util.Date;
import java.util.InputMismatchException;

/**
 * Nome: TelaTransferencia
 * <p>PropÃ³sito: Modela a tela de tranferencia</p>
 * Data: <23/09/2015>
 * @author sergio.junior <br>
 * copyright Copyright (c) 2013 <br> * </p>
 */
public class TelaTransferencia extends Tela {

	/**
	 * Id de serializacao
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	private JTextField agencia = null;

	/**
	 *
	 */
	private JTextField conta = null;
	/**
	 *
	 */
	private JTextField valor = null;
	/**
	 *
	 */
	private JButton confirmar = null;

	/**
	 *
	 */
	private JButton voltar = null;

	/**
	 *
	 */
	private JLabel lAgencia = null;

	/**
	 *
	 */
	private JLabel lConta = null;

	/**
	 *
	 */
	private JLabel lValor = null;

	/**
	 * Nome: TelaTransferencia
	 * <p>PropÃ³sito: Cosntrutor padrao</p>
	 * <p>
	 * Data: <23/09/2015>
	 * @author sergio.junior<br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 */

	public TelaTransferencia (){
		super();
		buildObjects();
		this.setTitle(BundleUtils.getString("titulo.tela.transferencia"));

		JPanel center = new JPanel();
		center.setLayout(new GridLayout(4, 2, 5, 5));
		center.setBorder(new EmptyBorder(70, 70, 0, 70));

		center.add(lAgencia);
		center.add(agencia);
		center.add(lConta);
		center.add(conta);
		center.add(lValor);
		center.add(valor);

		JPanel south = new JPanel();
		south.setLayout(new GridLayout(1, 2, 5, 5));
		south.setBorder(new EmptyBorder(70, 70, 70, 70));

		south.add(voltar);
		south.add(confirmar);

		this.add(center, BorderLayout.CENTER);
		this.add(south, BorderLayout.SOUTH);

		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	    this.setSize( 600, 450 ); // configura o tamanho do frame
	    this.setVisible( true ); // exibe o frame
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

		agencia = new JTextField();
		conta = new JTextField(10);
		valor =new JTextField(10);

		agencia.setBounds(5, 5, 100, 100);
		agencia.setPreferredSize(new Dimension(5, 5));

		lAgencia = new JLabel(BundleUtils.getString("label.tela.autenticao.agencia"));
		lConta = new JLabel(BundleUtils.getString("label.tela.autenticao.conta"));
		lValor = new JLabel(BundleUtils.getString("label.tela.autenticao.valor"));

		confirmar = new JButton(BundleUtils.getString("botao.tela.transferir"));
		voltar = new JButton(BundleUtils.getString("botao.tela.voltar"));

		TransferenciaController ctr = new TransferenciaController();
		confirmar.addActionListener(ctr);
		voltar.addActionListener(ctr);

	}

	/**
	 * Nome: TransferenciaController
	 * <p>PropÃ³sito: Controller para a funcionalidade de transferencia</p>
	 * <p>
	 * Data: <27/10/2015>
	 * @author sergio.junior  <br>
	 * copyright Copyright (c) 2015 <br> * </p>
	 */
	public class TransferenciaController implements ActionListener {

		/**
		 *
		 */
		private Transferencia tranferencia = null;

		/**
		 * Nome:
		 * <p>PropÃ³sito: </p>
		 * <p>
		 * Data: <27/10/2015>
		 * @author sergio.junior  <br>
		 * copyright Copyright (c) 2015 <br> * </p>
		 *
		 */
		public TransferenciaController() {
			super();
			tranferencia = new Transferencia();
		}

		/**
		 * Nome: actionPerformed
		 * <p>PropÃ³sito:  </p>
		 * Data: <27/10/2015>
		 * @author sergio.junior  <br>
		 * copyright Copyright (c) 2015 <br> * </p>
		 * @param e
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == confirmar) {

				boolean isValido = this.validaDados();

				if (isValido) {

					Integer agenciaDes = Integer.parseInt(agencia.getText());
					Integer contaDes = Integer.parseInt(conta.getText());
					Double value = Double.parseDouble(valor.getText());

					TransferenciaVO transferencia = new TransferenciaVO();
					transferencia.setAgenciaDestino(agenciaDes);
					transferencia.setContaDestino(contaDes);
					transferencia.setDate(new Date());
					transferencia.setTipoOperacao("Transferencia");
					transferencia.setValor(value);

					try {

						boolean resul = tranferencia.efetuaTransferencia(transferencia);

						if (resul) {

							JOptionPane
									.showMessageDialog(
											TelaTransferencia.this,
											"Transferencia Realizada com Sucesso!",
											"Transferencia",
											JOptionPane.INFORMATION_MESSAGE);

							
							agencia.setText("");
							conta.setText("");
							valor.setText("");
						}

					} catch (Exception ex) {

						JOptionPane.showMessageDialog(TelaTransferencia.this,
								ex.getMessage());
					}
				}

			} else {
				TelaTransferencia.this.dispose();
				new TelaHome();
			}

		}

		/**
		 * Nome: validaDados
		 * <p>PropÃ³sito: </p>
		 * <p>
		 * Data: <27/10/2015>
		 * @author sergio.junior  <br>
		 * copyright Copyright (c) 2015 <br> * </p>
		 *
		 * @return
		 */
		public boolean validaDados() {

			boolean resultado = false;

			try {

				String agenciaTxt = agencia.getText();
				String contaTxt = conta.getText();
				String valorTxt = valor.getText();

				if(agenciaTxt.equals("")) {
					throw new InputMismatchException("Digite uma agencia");
				}

				if(contaTxt.equals("")){
					throw new InputMismatchException("Digite uma conta");
				}

				if(valorTxt.equals("")){
					throw new InputMismatchException("Digite um valor");
				}

				Double value = Double.parseDouble(valorTxt);
				Integer.parseInt(agenciaTxt);
				Integer.parseInt(contaTxt);

				if(value <= 0) {
					throw new InputMismatchException("O valor nÃ£o pode ser negativo ou igual a zero");
				}
				resultado = true;

			} catch (NumberFormatException ex) {

				JOptionPane.showMessageDialog(TelaTransferencia.this, "Digite apenas nÃºmeros", BundleUtils
						.getString("tela.autenticacao.login.mensagem.titulo"),
						JOptionPane.ERROR_MESSAGE);

			} catch (InputMismatchException ex ) {

				JOptionPane.showMessageDialog(TelaTransferencia.this, ex
						.getMessage(), BundleUtils
						.getString("tela.autenticacao.login.mensagem.titulo"),
						JOptionPane.ERROR_MESSAGE);
			}

			return resultado;
		}

	}
}