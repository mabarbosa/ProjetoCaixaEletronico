package br.com.usjt.model.negocio;

import br.com.usjt.model.dao.ContaDAO;
import br.com.usjt.model.entidades.ContaVO;
import br.com.usjt.model.entidades.TransferenciaVO;
import br.com.usjt.utils.DadosLogin;

/**
 * Nome:
 * <p>PropÃ³sito: Classe responsavel por implementar as regras de negocio da conta</p>
 * Data: <07/10/2015>
 * @author sergio.junior  <br>
 * copyright Copyright (c) 2015 <br> * </p>
 */
public class Conta {

	private ContaDAO  contaDao = null;

	/**
	 * Nome: Construtor
	 * <p>PropÃ³sito: Conta</p>
	 * Data: <07/10/2015>
	 * @author sergio.junior  <br>
	 * copyright Copyright (c) 2015 <br> * </p>
	 *
	 */
	public Conta() {
		super();

		contaDao = new ContaDAO();
	}

	/**
	 * Nome: consultaSaldo
	 * <p>PropÃ³sito: Metodo responsavel por consultar o saldo da conta</p>
	 * Data: <07/10/2015>
	 * @author sergio.junior  <br>
	 * copyright Copyright (c) 2015 <br> * </p>
	 * @param conta
	 * @return
	 */

	public Double consultaSaldo () {

		Double value = 0.0;
		ContaVO conta = contaDao.buscarSaldo(DadosLogin.banco, DadosLogin.agencia, DadosLogin.conta );

		if (conta != null)
		{
			value = conta.getSaldo();
		}

		return value;
	}

	/**
	 * Nome: contaExite
	 * <p>PropÃ³sito: </p>
	 * <p>
	 * Data: <27/10/2015>
	 * @author sergio.junior  <br>
	 * copyright Copyright (c) 2015 <br> * </p>
	 *
	 * @return
	 */
	public boolean agenciaContaExite(int agencia, int conta) {
		return false;
	}

	/**
	 * Nome: consultaSaldoConta
	 * <p>PropÃ³sito: Metodo responsavel por </p>
	 * <p>
	 * Data: <27/10/2015>
	 * @author sergio.junior  <br>
	 * copyright Copyright (c) 2015 <br> * </p>
	 * @param agencia
	 * @param conta
	 * @return
	 */
	public double consultaSaldoConta(double agencia, double conta) {
		return 0.0;
	}
	
	/**
	 * Nome: atualizaSaldoOrigem
	 * <p>Propósito: </p>
	 * Data: <27/10/2015>
	 * @author sergio.junior  <br> 
	 * copyright Copyright (c) 2015 <br> * </p>
	 * @param valor
	 * @return
	 */
	public boolean atualizaSaldoOrigem (TransferenciaVO valor) {
		
		return false;
	}
	
	/**
	 * Nome: atualizaSaldoOrigem
	 * <p>Propósito: </p>
	 * Data: <27/10/2015>
	 * @author sergio.junior  <br> 
	 * copyright Copyright (c) 2015 <br> * </p>
	 * @param valor
	 * @return
	 */
	public boolean atualizaSaldoDestino (TransferenciaVO valor) {
		
		return false;
	}
}
