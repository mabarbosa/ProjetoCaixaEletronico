package br.com.usjt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.usjt.model.negocio.TransferenciaBO;

/**
 * Nome: TransferenciaControl
 * <p>Propósito: Controller para a funcionalidade transferencia</p>
 * <p>
 * Data: <05/04/2016>
 * @author sergio.junior  <br> 
 * copyright Copyright (c) 2015 <br> * </p>
 *
 */
@WebServlet("/Transferencia.do")
public class TransferenciaControl extends HttpServlet {
	
	/**
	 * ID de Serializacao
	 */
	private static final long serialVersionUID = 1L;
     
	/**
	 * Objeto de Negocio
	 */
	private TransferenciaBO transferenciaBO = null;
	
    /**
     * Nome: TransferenciaControl
     * <p>Propósito: Metodo construtor Padrao</p>
     * <p>
     * Data: <05/04/2016>
     * @author sergio.junior  <br> 
     * copyright Copyright (c) 2015 <br> * </p>
     *
     */
    public TransferenciaControl() {
        super();
        transferenciaBO = new TransferenciaBO();
    }

	/**
	 * Nome: doGet
	 * <p>Propósito: </p>
	 * <p>
	 * Data: <05/04/2016>
	 * @author sergio.junior  <br> 
	 * copyright Copyright (c) 2015 <br> * </p>
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO: Implementar
	}

	/**
	 * Nome: doPost
	 * <p>Propósito: </p>
	 * Data: <05/04/2016>
	 * @author sergio.junior  <br> 
	 * copyright Copyright (c) 2015 <br> * </p>
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO: Implementar
	}
}
