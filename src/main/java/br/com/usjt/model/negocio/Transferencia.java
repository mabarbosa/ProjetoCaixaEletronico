package br.com.usjt.model.negocio;

import br.com.usjt.model.dao.ClienteDAO;
import br.com.usjt.model.dao.ContaDAO;
import br.com.usjt.model.dao.TransferenciaDAO;
import br.com.usjt.model.entidades.ContaVO;
import br.com.usjt.model.entidades.TransferenciaVO;
import br.com.usjt.utils.DadosLogin;

/**
 * Nome: Transferecia
 * <p>PropÃ³sito: </p>
 * <p>
 * Data: <27/10/2015>
 * @author sergio.junior  <br>
 * copyright Copyright (c) 2015 <br> * </p>
 */
public class Transferencia {

	/**
	 * 
	 */
	private Conta conta = null;
	
	private ContaDAO contadao = null;
	/**
	 * 
	 */
	private TransferenciaDAO transDAO = null;
	/**
	 * Nome: Metodo construtor
	 * <p>PropÃ³sito: </p>
	 * Data: <27/10/2015>
	 * @author sergio.junior  <br>
	 * copyright Copyright (c) 2015 <br> * </p>
	 *
	 */
	public Transferencia() {
		super();
		conta = new Conta();
		transDAO = new TransferenciaDAO();
		contadao = new ContaDAO();
	}

	/**
	 * Nome: efetuaTransferencia
	 * <p>PropÃ³sito: Metodo responsavel por efetuar a transferencia </p>
	 * <p>
	 * Data: <27/10/2015>
	 * @author sergio.junior  <br>
	 * copyright Copyright (c) 2015 <br> * </p>
	 *
	 * @param trans
	 * @return
	 */
	public boolean efetuaTransferencia(TransferenciaVO trans) throws Exception
	{
		
		ContaVO con = contadao.consultaSaldo(trans.getAgenciaDestino(), trans.getContaDestino());
		
		if(con == null) {
			throw new Exception("Consta nao exite");
		}
	
		ContaDAO contaDao = new ContaDAO();
		ContaVO conta = contaDao.buscarSaldo(DadosLogin.banco, DadosLogin.agencia, DadosLogin.conta );
		contadao.mudarSaldo(conta, (conta.getSaldo() - trans.getValor()));
		
		ContaVO  contadest = contadao.consultaSaldo(trans.getAgenciaDestino(), trans.getContaDestino());
		contadao.mudarSaldo(contadest, (contadest.getSaldo() + trans.getValor()));
		
		this.gravaTransferencia(trans);
		
		return true;
	}
	
	/**
	 * Nome: gravaTransferencia
	 * <p>Propósito: </p>
	 * <p>
	 * Data: <27/10/2015>
	 * @author sergio.junior  <br> 
	 * copyright Copyright (c) 2015 <br> * </p>
	 *
	 * @param trans
	 */
	public void gravaTransferencia(TransferenciaVO trans){
		transDAO.cadastrar(trans);
	}
}
