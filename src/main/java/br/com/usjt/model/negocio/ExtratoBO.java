package br.com.usjt.model.negocio;

import java.util.List;

import br.com.usjt.model.dao.OperacaoDAO;
import br.com.usjt.model.entidades.ContaVO;
import br.com.usjt.model.entidades.OperacaoVO;

/**
 * Nome: ExtratoBO
 * <p>Propósito: Classe de Negocio para Extrato</p>
 * <p>
 * Data: <07/04/2016>
 * @author sergio.junior  <br> 
 * copyright Copyright (c) 2015 <br> * </p>
 */
public class ExtratoBO {

	private OperacaoDAO operacaoDAO = null;
	
	/**
	 * Nome: ExtratoBO
	 * <p>Propósito: </p>
	 * <p>
	 * Data: <07/04/2016>
	 * @author sergio.junior  <br> 
	 * copyright Copyright (c) 2015 <br> * </p>
	 */
	public ExtratoBO() {
		super();
		operacaoDAO = new OperacaoDAO();
	}

	/**
	 * Nome: getExtrato
	 * <p>Propósito: Metodo responsavel por pegar o Extrato</p>
	 * Data: <05/04/2016>
	 * @author sergio.junior  <br> 
	 * copyright Copyright (c) 2015 <br> * </p>
	 *
	 * @param conta ContaVO
	 * @return String[][]
	 */
	public String[][] getExtrato(ContaVO conta)
	{
		List<OperacaoVO> lista = operacaoDAO.buscarOperacoes(conta);

		String[][] retorno = new String[lista.size()][4];

		int contador = 0;

		try
		{
			for(OperacaoVO operacao : lista)
			{
				String[] x = { operacao.getDate().toString(), operacao.getTipoOperacao().toString(), operacao.getCodigo().toString(), operacao.getValor().toString() };

				retorno[contador] = x;

				contador++;
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

		return retorno;
	}
}
