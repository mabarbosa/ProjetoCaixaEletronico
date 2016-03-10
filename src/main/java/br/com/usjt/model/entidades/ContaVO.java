/**
 * Nome: br.com.usjt.project.banco.projeto.model.entidades
 * Data da Criação: 19/05/2015
 * Compilador: 1.6
 * Propósito: Pacote Principal do Projeto
 * Parâmetros de Compilação:
 */
package br.com.usjt.model.entidades;

import java.io.Serializable;

/**
 * Nome: ContaVO
 * <p>Propósito: VO - (Value Objet) para conta</p>
 * Data: <06/06/2015>
 * @author Sergio Teixeira <br>
 * copyright Copyright (c) 2013 <br> * </p>
 */
public class ContaVO implements Serializable {
	/**
	 * Id para serializacao
	 */
	private static final long serialVersionUID = -2354594714270634612L;
	/**
	 * Cliente proprietario da conta
	 */
	private ClienteVO cliente = null;
	/**
	 * Numero da conta
	 */
	private Integer numero = null;
	/**
	 * Numero da agencia
	 */
	private Integer agencia = null;
	/**
	 * nome do banco
	 */
	private String banco = null;
	/**
	 * Saldo da conta
	 */
	private Double saldo = null;

	/**
	 * Nome: ContaVO
	 * <p>Propósito: Metodo construtor padrão</p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira<br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 */
	public ContaVO() {
		super();
	}
	/**
	 * Nome: getCliente
	 * <p>Propósito: Metodo de acesso </p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 * @return the Cliente
	 */
	public ClienteVO getCliente() {
		return cliente;
	}
	/**
	 * Nome: setCliente
	 * <p>Propósito: Metodo modificador</p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 * @param the cliente
	 */
	public void setCliente(ClienteVO cliente) {
		this.cliente = cliente;
	}
	/**
	 * Nome: getNumero
	 * <p>Propósito: Metodo de acesso</p>
	 * Data: <04/07/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 * @return the Integer
	 */
	public Integer getNumero() {
		return numero;
	}
	/**
	 * Nome: setNumero
	 * <p>Propósito: Metodo modificador </p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 * @param numero
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	/**
	 * Nome: getAgencia
	 * <p>Propósito: Metodo de acesso </p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 * @return the Integer
	 */
	public Integer getAgencia() {
		return agencia;
	}
	/**
	 * Nome: setAgencia
	 * <p>Propósito: metodo modificador</p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 * @param the agencia
	 */
	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}
	/**
	 * Nome: getBanco
	 * <p>Propósito: metodo de acesso</p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 * @return the String
	 */
	public String getBanco() {
		return banco;
	}
	/**
	 * Nome: setBanco
	 * <p>Propósito: metodo modificador</p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 * @param the banco
	 */
	public void setBanco(String banco) {
		this.banco = banco;
	}
	/**
	 * Nome: getSaldo
	 * <p>Propósito: metodo de acesso </p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 * @return the Double
	 */
	public Double getSaldo() {
		return saldo;
	}
	/**
	 * Nome: setSaldo
	 * <p>Propósito: Metodo modificador</p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 * @param the saldo
	 */
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
}
