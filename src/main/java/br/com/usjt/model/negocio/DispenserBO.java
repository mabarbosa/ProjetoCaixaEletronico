package br.com.usjt.model.negocio;

import br.com.usjt.model.dao.DispenserDAO;

public class DispenserBO {

	private DispenserDAO dispenserDao = null;

	public DispenserBO()
	{
		dispenserDao = new DispenserDAO();
	}

	public void processaNotas(double valor)
	{
		for(int nota: dispenserDao.getNotasDisponiveis())
		{
			int qtdNotas = (int) valor / nota;
			valor = valor % nota;

			if(qtdNotas > 0)
			{
			    dispenserDao.mudaDispenser(nota, qtdNotas);
			}
		}
	}
}
