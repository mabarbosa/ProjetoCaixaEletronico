package br.com.usjt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.usjt.model.negocio.DebitoAutomaticoBO;


/**
 * Nome: DebitoAutomaticoControl
 * <p>Propósito: Classe de Controle para o Debito Automatico </p>
 * <p>
 * Data: <07/04/2016>
 * @author sergio.junior  <br> 
 * copyright Copyright (c) 2015 <br> * </p>
 */
@WebServlet("/DebitoAutomatico.do")
public class DebitoAutomaticoControl extends HttpServlet {
	
	/**
	 * ID de serialização
	 */
	private static final long serialVersionUID = 1L;

	private DebitoAutomaticoBO debitoAutomaticoBO = null;
    /**
     * Nome: DebitoAutomaticoControl
     * <p>Propósito: Metodo construtor padrao</p>
     * Data: <07/04/2016>
     * @author sergio.junior  <br> 
     * copyright Copyright (c) 2015 <br> * </p>
     *
     */
    public DebitoAutomaticoControl() {
        super();
        debitoAutomaticoBO = new DebitoAutomaticoBO();
    }
    
	/**
	 * Nome: doGet
	 * <p>Propósito: </p>
	 * <p>
	 * Data: <07/04/2016>
	 * @author sergio.junior  <br> 
	 * copyright Copyright (c) 2015 <br> * </p>
	 *
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Implementar
	}

	/**
	 * Nome: doPost
	 * <p>Propósito: </p>
	 * <p>
	 * Data: <07/04/2016>
	 * @author sergio.junior  <br> 
	 * copyright Copyright (c) 2015 <br> * </p>
	 *
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Implementar
	}

}
