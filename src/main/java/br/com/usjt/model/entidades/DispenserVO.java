package br.com.usjt.model.entidades;

import java.io.Serializable;

/**
 * Nome: DispenserVO
 * <p>Propósito: </p>
 * Data: <06/06/2015>
 * @author Sergio Teixeira <br>
 * copyright Copyright (c) 2013 <br> * </p>
 */
public class DispenserVO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1128960997746532430L;
	/**
	 *
	 */
	private Integer codigo = null;
	/**
	 *
	 */
	private String tipoNota = null;
	/**
	 *
	 */
	private Integer qtdeNota = null;


	/**
	 * Nome: DispenserVO
	 * <p>Propósito: </p>
	 * <p>
	 * Data: <07/07/2015>
	 * @author Sergio Teixeira<br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 */
	private DispenserVO() {
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
	 * Nome: getTipoNota
	 * <p>Propósito: </p>
	 * <p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 * @return
	 */
	public String getTipoNota() {
		return tipoNota;
	}

	/**
	 * Nome: setTipoNota
	 * <p>Propósito: </p>
	 * <p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 * @param tipoNota
	 */
	public void setTipoNota(String tipoNota) {
		this.tipoNota = tipoNota;
	}

	/**
	 * Nome: getQtdeNota
	 * <p>Propósito: </p>
	 * <p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 * @return
	 */
	public Integer getQtdeNota() {
		return qtdeNota;
	}

	/**
	 * Nome: setQtdeNota
	 * <p>Propósito: </p>
	 * <p>
	 * Data: <06/06/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 * @param qtdeNota
	 */
	public void setQtdeNota(Integer qtdeNota) {
		this.qtdeNota = qtdeNota;
	}
}
