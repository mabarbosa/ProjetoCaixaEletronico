package br.com.usjt.model.negocio;

import br.com.usjt.model.dao.*;
import br.com.usjt.model.entidades.ContaVO;
import br.com.usjt.model.entidades.DebitoAutomaticoVO;
import br.com.usjt.utils.DadosLogin;

public class DebitoAutomatico
{
	private DebitoAutomaticoDAO debitoAutomatico = null;

	public DebitoAutomatico()
	{
		super();

		debitoAutomatico = new DebitoAutomaticoDAO();
	}

	public boolean cadastrarDebito(DebitoAutomaticoVO debito)
	{
		boolean status = true;

		try
		{
			//Captura a Conta Atual
			ContaDAO contaDao = new ContaDAO();
			ContaVO conta = contaDao.buscarSaldo(DadosLogin.banco, DadosLogin.agencia, DadosLogin.conta );

			if(conta != null)
			{
				//Ajusta o Débito
				debito.setConta(conta);

				if(!debitoAutomatico.addDebitoAutomatico(debito))
				{
					status = false;
				}
			}


		}
		catch(Exception e)
		{
			status = false;
		}

		return status;
	}
}
