package br.com.usjt.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.usjt.model.entidades.AutenticacaoVO;
import br.com.usjt.model.negocio.AutenticacaoBO;
import br.com.usjt.utils.BundleUtils;

import br.com.usjt.view.arq.ComboBancoItem;

public class TelaAutenticacao extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField agencia = null;
	private JPasswordField senha = null;
	private JTextField conta = null;
	private JButton entrar = null;
	private JButton cancelar = null;
	private JLabel lAgencia = null;
	private JLabel lSenha = null;
	private JLabel lConta = null;
	private JLabel lBanco = null;
//	private JComboBox<?> cBanco = null;

	public TelaAutenticacao() {

		this.setTitle(BundleUtils.getString("titulo.tela.autenticao"));
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		buildObjects();

		JPanel center = new JPanel();
		center.setLayout(new GridLayout(5, 2, 5, 5));
		center.setBorder(new EmptyBorder(70, 70, 0, 70));

		center.add(lBanco);
//		center.add(cBanco);
		center.add(lAgencia);
		center.add(agencia);
		center.add(lConta);
		center.add(conta);
		center.add(lSenha);
		center.add(senha);

		JPanel south = new JPanel();
		south.setLayout(new GridLayout(1, 2, 5, 5));
		south.setBorder(new EmptyBorder(70, 70, 70, 70));

		entrar.addActionListener(new AutenticacaoControl());
		cancelar.addActionListener(new AutenticacaoControl());

		south.add(entrar);
		south.add(cancelar);

		this.add(center, BorderLayout.CENTER);
		this.add(south, BorderLayout.SOUTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 450);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void buildObjects() {
		agencia = new JTextField();
		senha = new JPasswordField(10);
		conta = new JTextField(10);

		agencia.setBounds(5, 5, 100, 100);
		agencia.setPreferredSize(new Dimension(5, 5));

		lAgencia = new JLabel(BundleUtils.getString("label.tela.autenticao.agencia"));
		lConta = new JLabel(BundleUtils.getString("label.tela.autenticao.conta"));
		lSenha = new JLabel(BundleUtils.getString("label.tela.autenticao.senha"));

		entrar = new JButton(BundleUtils.getString("botao.tela.entrar"));
		cancelar = new JButton(BundleUtils.getString("botao.tela.cancelar"));

		lBanco = new JLabel(BundleUtils.getString("label.tela.autenticao.banco"));

		ComboBancoItem[] listaBancos = new ComboBancoItem[] {
				new ComboBancoItem(
						"",
						BundleUtils
								.getString("tela.autenticacao.login.combo.banco.selecione")),
				new ComboBancoItem("1", "Banco 1"),
				new ComboBancoItem("2", "Banco 2"),
				new ComboBancoItem("3", "Banco 3") };
//		cBanco = new JComboBox(listaBancos);
	}

	public class AutenticacaoControl implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{

			//caso seja entrar
			if (e.getSource() == entrar) {

				AutenticacaoVO objAuth = validaDados();

				if (objAuth.getBanco() != null && objAuth.getAgencia() != null
						&& objAuth.getConta() != null
						&& objAuth.getSenha() != null) {

					AutenticacaoBO autenticacao = new AutenticacaoBO();

					//valida o usuario
					if (autenticacao.validaUsuario(objAuth))
					{
						new TelaHome();

						TelaAutenticacao.this.setVisible(false);

					}
					else
					{
						JOptionPane
								.showMessageDialog(
										TelaAutenticacao.this,
										BundleUtils
												.getString("tela.autenticacao.login.erro"),
										BundleUtils
												.getString("tela.autenticacao.login.erro.titulo"),
										JOptionPane.ERROR_MESSAGE);
					}
				}

			//Caso seja cancelar
			} else if (e.getSource() == cancelar) {
				int btnCancelar = JOptionPane
						.showConfirmDialog(
								TelaAutenticacao.this,
								BundleUtils
										.getString("tela.autenticacao.login.sair"),
								BundleUtils
										.getString("tela.autenticacao.login.sair.titulo"),
								JOptionPane.YES_NO_OPTION);

				if (btnCancelar == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		}

		public AutenticacaoVO validaDados()
		{

			AutenticacaoVO dados = new AutenticacaoVO();

			try {

				String codBanco = null;//((ComboBancoItem) cBanco.getSelectedItem())
//						.getCodBanco();
				String s = String.valueOf(senha.getPassword());

				if (codBanco == "")
					throw new InputMismatchException(
							BundleUtils
									.getString("tela.autenticacao.login.mensagem.banco"));

				dados.setBanco(Integer.parseInt(codBanco));

				dados.setAgencia(Integer.parseInt(agencia.getText()));
				dados.setConta(Integer.parseInt(conta.getText()));

				if (s.equals("") || s == null)
					throw new InputMismatchException(
							BundleUtils
									.getString("tela.autenticacao.login.mensagem.senha"));

				dados.setSenha(s);

			} catch (InputMismatchException ex) {

				JOptionPane.showMessageDialog(TelaAutenticacao.this, ex
						.getMessage(), BundleUtils
						.getString("tela.autenticacao.login.mensagem.titulo"),
						JOptionPane.ERROR_MESSAGE);

			} catch (NumberFormatException ex) {
				JOptionPane
						.showMessageDialog(
								TelaAutenticacao.this,
								BundleUtils
										.getString("tela.autenticacao.login.mensagem.agencia.conta"),
								BundleUtils
										.getString("tela.autenticacao.login.mensagem.titulo"),
								JOptionPane.ERROR_MESSAGE);
			}

			return dados;
		}

	}
}
