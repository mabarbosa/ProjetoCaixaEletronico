package br.com.usjt.model.negocio;

import br.com.usjt.model.dao.ClienteDAO;
import br.com.usjt.model.dao.ContaDAO;
import br.com.usjt.model.dao.TransferenciaDAO;
import br.com.usjt.model.entidades.ContaVO;
import br.com.usjt.model.entidades.TransferenciaVO;
import br.com.usjt.security.DadosLogin;

/**
 * Nome: Transferecia
 * <p>PropÃ³sito: </p>
 * <p>
 * Data: <27/10/2015>
 * @author sergio.junior  <br>
 * copyright Copyright (c) 2015 <br> * </p>
 * @param <TransferenciaBO>
 */
public class TransferenciaBO {

	/**
	 *
	 */
	private ContaBO conta = null;

	private ContaDAO contaDAO = null;
	/**
	 *
	 */
	private TransferenciaDAO transDAO = null;


	public TransferenciaBO() {
		conta = new ContaBO();
		transDAO = new TransferenciaDAO();
		contaDAO = new ContaDAO();
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

		ContaVO con = contaDAO.consultaSaldo(trans.getAgenciaDestino(), trans.getContaDestino());

		if(con == null) {
			throw new Exception("Consta nao exite");
		}

		ContaDAO contaDao = new ContaDAO();
		ContaVO conta = contaDao.buscarSaldo(DadosLogin.banco, DadosLogin.agencia, DadosLogin.conta );
		contaDAO.mudarSaldo(conta, (conta.getSaldo() - trans.getValor()));

		ContaVO  contadest = contaDAO.consultaSaldo(trans.getAgenciaDestino(), trans.getContaDestino());
		contaDAO.mudarSaldo(contadest, (contadest.getSaldo() + trans.getValor()));

		this.gravaTransferencia(trans);

		return true;
	}

	/**
	 * Nome: gravaTransferencia
	 * <p>Propósito: Metodo responsavel por gravar a transferencia</p>
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
