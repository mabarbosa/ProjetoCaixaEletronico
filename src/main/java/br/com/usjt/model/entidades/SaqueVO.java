package br.com.usjt.model.entidades;

import java.io.Serializable;

/**
 * Nome: SaqueVO
 * <p>Propósito: </p>
 * Data: <06/06/2015>
 * @author Sergio Teixeira <br>
 * copyright Copyright (c) 2013 <br> * </p>
 */
public class SaqueVO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 5170739115530150481L;
	/**
	 *
	 */
	private Integer codigo = null;
	/**
	 *
	 */
	private OperacaoVO operacao = null;
	/**
	 * Nome:SaqueVO
	 * <p>Propósito: </p>
	 * <p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira<br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 */
	public SaqueVO() {
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
