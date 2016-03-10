package br.com.usjt.model.entidades;

import java.io.Serializable;
import java.util.Date;

/**
 * Nome: OperacaoVO
 * <p>Propósito: </p>
 * <p>
 * Data: <06/06/2015>
 * @author Sergio Teixeira <br>
 * copyright Copyright (c) 2013 <br> * </p>
 */
public class OperacaoVO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -1425993922606033146L;
	/**
	 *
	 */
	private Integer codigo = null;
	/**
	 *
	 */
	private ContaVO conta = null;
	/**
	 *
	 */
	private Date date  = null;
	/**
	 *
	 */
	private Double valor = null;
	/**
	 *
	 */
	private String tipoOperacao = null;


	/**
	 * Nome: OperacaoVO
	 * <p>Propósito: </p>
	 * <p>
	 * Data: <07/07/2015>
	 * @author Sergio Teixeira<br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 */
	public OperacaoVO() {
		super();
	}

	/**
	 * Nome: getCodigo
	 * <p>Propósito: </p>
	 * <p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 * @return
	 */
	public Integer getCodigo() {
		return codigo;
	}
	/**
	 * Nome: setCodigo
	 * <p>Propósito: </p>
	 * <p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 * @param codigo
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	/**
	 * Nome: getConta
	 * <p>Propósito: </p>
	 * <p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 * @return
	 */
	public ContaVO getConta() {
		return conta;
	}
	/**
	 * Nome: setConta
	 * <p>Propósito: </p>
	 * <p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 * @param conta
	 */
	public void setConta(ContaVO conta) {
		this.conta = conta;
	}
	/**
	 * Nome: getDate
	 * <p>Propósito: </p>
	 * <p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 * @return
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * Nome: setDate
	 * <p>Propósito: </p>
	 * <p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * Nome: getValor
	 * <p>Propósito: </p>
	 * <p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 * @return
	 */
	public Double getValor() {
		return valor;
	}
	/**
	 * Nome: setValor
	 * <p>Propósito: </p>
	 * <p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 * @param valor
	 */
	public void setValor(Double valor) {
		this.valor = valor;
	}
	/**
	 * Nome: getTipoOperacao
	 * <p>Propósito: </p>
	 * <p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 * @return
	 */
	public String getTipoOperacao() {
		return tipoOperacao;
	}
	/**
	 * Nome: setTipoOperacao
	 * <p>Propósito: </p>
	 * <p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 * @param tipoOperacao
	 */
	public void setTipoOperacao(String tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}
}
