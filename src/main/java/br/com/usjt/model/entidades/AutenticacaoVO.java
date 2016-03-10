package br.com.usjt.model.entidades;

/**
 * Nome: AutenticacaoVO
 * <p>Propósito: Classe para receber valores</p>
 * Data: <28/09/2015>
 * @author sergio.junior <br>
 * copyright Copyright (c) 2013 <br> * </p>
 */
public class AutenticacaoVO {

	private Integer banco = null;
	private Integer agencia = null;
	private Integer conta = null;
	private String senha = null;


	public Integer getAgencia() {
		return agencia;
	}
	/**
	 * Nome: setAgencia
	 * <p>Propósito: </p>
	 * Data: <28/09/2015>
	 * @author sergio.junior <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 * @param agencia
	 */
	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}
	/**
	 * Nome: getConta
	 * <p>Propósito: </p>
	 * Data: <28/09/2015>
	 * @author sergio.junior <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 * @return
	 */
	public Integer getConta() {
		return conta;
	}
	/**
	 * Nome: setConta
	 * <p>Propósito: </p>
	 * Data: <28/09/2015>
	 * @author sergio.junior <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 * @param conta
	 */
	public void setConta(Integer conta) {
		this.conta = conta;
	}
	/**
	 * Nome: getSenha
	 * <p>Propósito: </p>
	 * Data: <28/09/2015>
	 * @author sergio.junior <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 * @return
	 */
	public String getSenha() {
		return senha;
	}
	/**
	 * Nome: setSenha
	 * <p>Propósito: </p>
	 * Data: <28/09/2015>
	 * @author sergio.junior <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 * @param senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getBanco() {
		return banco;
	}

	public void setBanco(Integer banco) {
		this.banco = banco;
	}


}
