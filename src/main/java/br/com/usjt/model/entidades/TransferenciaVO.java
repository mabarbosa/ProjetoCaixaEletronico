package br.com.usjt.model.entidades;

import java.io.Serializable;

/**
 * Nome: TransferenciaVO
 * <p>PropÃ³sito: </p>
 * Data: <06/06/2015>
 * @author Sergio Teixeira <br>
 * copyright Copyright (c) 2013 <br> * </p>
 */
public class TransferenciaVO extends OperacaoVO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -983491351782080618L;
	/**
	 *
	 */
	private Integer codigo = null;
	/**
	 *
	 */
	private Integer agenciaDestino = null;
	/**
	 *
	 */
	private Integer contaDestino = null;
	
	/**
	 * Nome:TransferenciaVO
	 * <p>PropÃ³sito: </p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira<br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 */
	public TransferenciaVO() {
		super();
	}
	/**
	 * Nome: getCodigo
	 * <p>PropÃ³sito: </p>
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
	 * <p>PropÃ³sito: </p>
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
	 * Nome: getAgenciaDestino
	 * <p>PropÃ³sito: </p>
	 * <p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 * @return
	 */
	public Integer getAgenciaDestino() {
		return agenciaDestino;
	}
	/**
	 * Nome: setAgenciaDestino
	 * <p>PropÃ³sito: </p>
	 * <p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 * @param agenciaDestino
	 */
	public void setAgenciaDestino(Integer agenciaDestino) {
		this.agenciaDestino = agenciaDestino;
	}
	/**
	 * Nome: getContaDestino
	 * <p>PropÃ³sito: </p>
	 * <p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 * @return
	 */
	public Integer getContaDestino() {
		return contaDestino;
	}
	/**
	 * Nome: setContaDestino
	 * <p>PropÃ³sito: </p>
	 * <p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 * @param contaDestino
	 */
	public void setContaDestino(Integer contaDestino) {
		this.contaDestino = contaDestino;
	}
}