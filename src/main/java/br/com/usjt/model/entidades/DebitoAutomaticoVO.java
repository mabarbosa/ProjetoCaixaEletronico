/**
 *
 */
package br.com.usjt.model.entidades;

import java.io.Serializable;
import java.util.Date;

/**
 * Nome: DebitoAutomaticoVO
 * <p>Propósito: </p>
 * <p>
 * Data: <06/06/2015>
 * @author Sergio Teixeira <br>
 * copyright Copyright (c) 2013 <br> * </p>
 *
 *
 */
public class DebitoAutomaticoVO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -8249772394392583937L;
	/**
	 *
	 */
	private Integer codigo = null;
	/**
	 *
	 */
	private  ContaVO conta = null;
	/**
	 *
	 */
	private Date data = null;
	/**
	 *
	 */
	private Integer codOperadora = null;
	/**
	 *
	 */
	private Integer codConsumidor = null;
	/**
	 *
	 */
	private OperacaoVO operacao = null;

	/**
	 * Nome:DebitoAutomaticoVO
	 * <p>Propósito: </p>
	 * <p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira<br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 */
	public DebitoAutomaticoVO() {
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
	 * Nome: getData
	 * <p>Propósito: </p>
	 * <p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 * @return
	 */
	public Date getData() {
		return data;
	}
	/**
	 * Nome: setData
	 * <p>Propósito: </p>
	 * <p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 * @param data
	 */
	public void setData(Date data) {
		this.data = data;
	}
	/**
	 * Nome: getCodOperadora
	 * <p>Propósito: </p>
	 * <p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 * @return
	 */
	public Integer getCodOperadora() {
		return codOperadora;
	}
	/**
	 * Nome: setCodOperadora
	 * <p>Propósito: </p>
	 * <p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 * @param codOperadora
	 */
	public void setCodOperadora(Integer codOperadora) {
		this.codOperadora = codOperadora;
	}
	/**
	 * Nome: getCodConsumidor
	 * <p>Propósito: </p>
	 * <p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 * @return
	 */
	public Integer getCodConsumidor() {
		return codConsumidor;
	}
	/**
	 * Nome: setCodConsumidor
	 * <p>Propósito: </p>
	 * <p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 * @param codConsumidor
	 */
	public void setCodConsumidor(Integer codConsumidor) {
		this.codConsumidor = codConsumidor;
	}
	/**
	 * Nome: getOperacao
	 * <p>Propósito: </p>
	 * <p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 * @return
	 */
	public OperacaoVO getOperacao() {
		return operacao;
	}
	/**
	 * Nome: setOperacao
	 * <p>Propósito: </p>
	 * <p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 * @param operacao
	 */
	public void setOperacao(OperacaoVO operacao) {
		this.operacao = operacao;
	}
}
