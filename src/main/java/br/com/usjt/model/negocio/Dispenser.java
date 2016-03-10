package br.com.usjt.model.negocio;

import br.com.usjt.model.dao.DispenserDAO;

public class Dispenser {

	private DispenserDAO dispenserDao = null;

	public Dispenser()
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
