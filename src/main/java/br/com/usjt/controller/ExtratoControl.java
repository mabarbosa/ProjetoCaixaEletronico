package br.com.usjt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.usjt.model.entidades.ContaVO;
import br.com.usjt.model.negocio.ContaBO;
import br.com.usjt.model.negocio.ExtratoBO;

/**
 * Nome: ExtratoControl
 * <p>Propósito: </p>
 * Data: <07/04/2016>
 * @author sergio.junior  <br> 
 * copyright Copyright (c) 2015 <br> * </p>
 */
@WebServlet("/Extrato.do")
public class ExtratoControl extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    private ExtratoBO extratoBO = null;
    /**
     * Nome: ExtratoControl
     * <p>Propósito: Metodo Contrutor padrao</p>
     * Data: <07/04/2016>
     * @author sergio.junior  <br> 
     * copyright Copyright (c) 2015 <br> * </p>
     *
     */
    public ExtratoControl() {
        super();
        extratoBO = new ExtratoBO();
    }

	/**
	 * Nome: doGet
	 * <p>Propósito: Requisicao Method GET</p>
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
		
		ContaVO conta = new ContaVO();
		
		String [][] extrato = extratoBO.getExtrato(conta);
		
		request.setAttribute("extrato", extrato);
		
		RequestDispatcher view = request.getRequestDispatcher("ExtratoView.jsp");
		view.forward(request, response);
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
