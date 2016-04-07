package br.com.usjt.model.negocio;

import br.com.usjt.model.dao.*;
import br.com.usjt.model.entidades.ContaVO;
import br.com.usjt.model.entidades.DebitoAutomaticoVO;
import br.com.usjt.security.DadosLogin;

public class DebitoAutomaticoBO
{
	private DebitoAutomaticoDAO debitoAutomatico = null;

	public DebitoAutomaticoBO()
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
