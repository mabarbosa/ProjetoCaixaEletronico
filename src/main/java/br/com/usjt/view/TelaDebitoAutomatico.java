package br.com.usjt.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.usjt.utils.BundleUtils;
import br.com.usjt.view.arq.Tela;
import br.com.usjt.model.entidades.DebitoAutomaticoVO;
import br.com.usjt.model.negocio.DebitoAutomaticoBO;

/**
 * Nome: TelaDebitoAutomatico
 * <p>Propósito: Modela a tela de debito automatico</p>
 * Data: <23/09/2015>
 * @author sergio.junior <br>
 * copyright Copyright (c) 2013 <br> * </p>
 */
public class TelaDebitoAutomatico extends Tela {

	/**
	 * Id de serializacao
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	private JTextField codigoOpe = null;

	/**
	 *
	 */
	private JTextField codigoCon = null;

    /**
	 *
	 */
	private JTextField data = null;
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
	private JLabel lCodigoOpe = null;

	/**
	 *
	 */
	private JLabel lCodigoCon = null;

	/**
	 *
	 */
	private JLabel lData = null;

	/**
	 * Nome:Metodo construtor
	 * <p>Propósito: </p>
	 * Data: <23/09/2015>
	 * @author sergio.junior<br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 */
	public TelaDebitoAutomatico() {
		super();
		buildObjects();

		this.setTitle(BundleUtils.getString("titulo.tela.debitoautomatico"));

		JPanel center = new JPanel();
		center.setLayout(new GridLayout(4, 2, 5, 5));
		center.setBorder(new EmptyBorder(70, 70, 0, 70));

		center.add(lCodigoCon);
		center.add(codigoCon);
		center.add(lCodigoOpe);
		center.add(codigoOpe);
		center.add(lData);
		center.add(data);

		JPanel south = new JPanel();
		south.setLayout(new GridLayout(1, 2, 5, 5));
		south.setBorder(new EmptyBorder(70, 70, 70, 70));

		voltar.addActionListener(new DebitoAutomaticoControl());
		confirmar.addActionListener(new DebitoAutomaticoControl());

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
	 * <p>Propósito: Metodo responsavel por construir os objetos da tela</p>
	 * Data: <23/09/2015>
	 * @author sergio.junior <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 */
	private void buildObjects() {
		codigoCon = new JTextField();
		codigoOpe = new JTextField(10);
		data =new JTextField(10);

		lCodigoCon = new JLabel(BundleUtils.getString("label.tela.debitoautomatico.lCodigoCon"));
		lCodigoOpe = new JLabel(BundleUtils.getString("label.tela.debitoautomatico.lCodigoOpe"));
		lData = new JLabel(BundleUtils.getString("label.tela.debitoautomatico.lData"));

		confirmar = new JButton(BundleUtils.getString("botao.tela.cadastrar"));
		voltar = new JButton(BundleUtils.getString("botao.tela.voltar"));
	}

	//Controller - Transferencia
	public class DebitoAutomaticoControl implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == confirmar)
			{
				boolean processar = true;

				if(codigoCon.getText().equals(""))
				{
					processar = false;
				}
				else if (codigoOpe.getText().equals(""))
				{
					processar = false;
				}
				else if(data.getText().equals(""))
				{
					processar = false;
				}

				if(processar)
				{
					DebitoAutomaticoVO debitoAutomatico = new DebitoAutomaticoVO();

					debitoAutomatico.setCodConsumidor(Integer.parseInt(codigoCon.getText()));
					debitoAutomatico.setCodOperadora(Integer.parseInt(codigoOpe.getText()));

					try
					{
						DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
						Date dataDebito = new Date();
						dataDebito = df.parse(data.getText());

						debitoAutomatico.setData(dataDebito);
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null, "A Data Informada é Inválida!");
						processar = false;
					}

					if(processar)
					{
						DebitoAutomaticoBO da = new DebitoAutomaticoBO();

						boolean status = da.cadastrarDebito(debitoAutomatico);

						if(status)
						{
							JOptionPane.showMessageDialog(null, "Débito Automático Cadastrado com Sucesso!");

							codigoCon.setText("");
							codigoOpe.setText("");
							data.setText("");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Ocorreu um erro ao Salvar o Débito Automático. Tente Novamente.");
						}
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Favor Preencher todos os campos corretamente.");
				}
			}
			if(e.getSource() == voltar)
			{
				TelaDebitoAutomatico.this.setVisible(false);
				new TelaHome();
			}
		}

	}
}
