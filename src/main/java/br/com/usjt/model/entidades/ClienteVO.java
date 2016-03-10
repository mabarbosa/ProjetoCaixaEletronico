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
 * Nome: ClienteVO
 * <p>Propósito: VO do cliente</p>
 * Data: <06/06/2015>
 * @author Sergio Teixeira <br>
 * copyright Copyright (c) 2013 <br> * </p>
 */
public class ClienteVO implements Serializable {
	/**
	 * Id para serializacao
	 */
	private static final long serialVersionUID = 8497103262426656325L;
	/**
	 * Atributo CNPJ
	 */
	private Long cnpj = null;
	/**
	 * atributo nome
	 */
	private String nome = null;

	/**
	 * Nome: ClienteVO()
	 * <p>Propósito: Metodo construtor </p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira<br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 */
	public ClienteVO() {
		super();
	}
	/**
	 * Nome: getCnpj
	 * <p>Propósito: metodo de acesso</p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 * @return the String
	 */
	public Long getCnpj() {
		return cnpj;
	}
	/**
	 * Nome: setCnpj
	 * <p>Propósito: </p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 * @param cnpj the String
	 */
	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}
	/**
	 * Nome: getNome
	 * <p>Propósito: Metodo de acesso</p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 * @return String
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Nome: setNome
	 * <p>Propósito: metodo modificador </p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 * @param nome the String
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
}
