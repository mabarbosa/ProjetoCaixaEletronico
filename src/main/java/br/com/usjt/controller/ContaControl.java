package br.com.usjt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.usjt.model.negocio.ContaBO;

/**
 * Nome: ContaControl
 * <p>Propósito: </p>
 * <p>
 * Data: <07/04/2016>
 * @author sergio.junior  <br> 
 * copyright Copyright (c) 2015 <br> * </p>
 *
 */
@WebServlet("/Conta.do")
public class ContaControl extends HttpServlet {
	
	/**
	 * ID de Serialização
	 */
	private static final long serialVersionUID = 1L;
       
	private ContaBO contaBO = null;
    /**
     * Nome: ContaControl
     * <p>Propósito: Metodo construtor </p>
     * <p>
     * Data: <07/04/2016>
     * @author sergio.junior  <br> 
     * copyright Copyright (c) 2015 <br> * </p>
     *
     */
    public ContaControl() {
        super();
        contaBO = new ContaBO();
    }

	/**
	 * Nome: doGet
	 * <p>Propósito: </p>
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
	 * @param request HttpServletRequest HttpServletRequest
	 * @param response HttpServletResponse HttpServletResponse
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Implementar
	}

}
