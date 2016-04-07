package br.com.usjt.model.negocio;

import java.util.Date;

import br.com.usjt.model.dao.ContaDAO;
import br.com.usjt.model.dao.OperacaoDAO;
import br.com.usjt.model.entidades.ContaVO;
import br.com.usjt.model.entidades.OperacaoVO;
import br.com.usjt.security.DadosLogin;

/**
 * Nome:
 * <p>Propósito: Classe de Negocio para a Funcionalidade SAQUE</p>
 * Data: <02/04/2016>
 * @author Sergio Teixeira  <br>
 * copyright Copyright (c) 2015 <br> * </p>
 */
public class SaqueBO
{
	/**
	 * Nome: executaSaque
	 * <p>Propósito: Metodo responsavel pr sacar</p>
	 * Data: <02/04/2016>
	 * @author Sergio Teixeira  <br>
	 * copyright Copyright (c) 2015 <br> * </p>
	 *
	 * @param valor Double
	 * @return boolean
	 */
	public boolean executaSaque(Double valor)
	{
		boolean status = true;

		try
		{
			//Captura a Conta Atual
			ContaDAO contaDao = new ContaDAO();
			OperacaoDAO operacaoDao = new OperacaoDAO();

			ContaVO conta = contaDao.buscarSaldo(DadosLogin.banco, DadosLogin.agencia, DadosLogin.conta );

			if(conta.getSaldo() >= valor)
			{
				try
				{
					contaDao.mudarSaldo(conta, (conta.getSaldo() - valor));

					OperacaoVO operacao = new OperacaoVO();
					operacao.setConta(conta);
					operacao.setDate(new Date());
					operacao.setTipoOperacao("SAQUE");
					operacao.setValor(valor);

					operacaoDao.addOperacao(operacao, conta);

					DispenserBO d = new DispenserBO();
					d.processaNotas(valor);
				}
				catch(Exception ex)
				{
					throw new Exception("Erro ao Atualizar Saldo!");
				}
			}
			else
			{
				throw new Exception("Saldo Insuficiente!");
			}
		}
		catch(Exception ex)
		{
			status = false;
			System.out.println(ex.getMessage());
		}

		return status;
	}
}
