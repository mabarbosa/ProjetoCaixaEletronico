package br.com.usjt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.usjt.model.negocio.SaqueBO;

/**
 * Nome: SaqueControl
 * <p>Propósito: Metodo Controller para o SAQUE</p>
 * Data: <02/04/2016>
 * @author Sergio Teixeira  <br>
 * copyright Copyright (c) 2015 <br> * </p>
 */
@WebServlet("/Saque.do")
public class SaqueControl extends HttpServlet {

	/**
	 * Atributo de Serialização
	 */
	private static final long serialVersionUID = 1L;

	private SaqueBO saqueBO = null;
    /**
     * Nome: SaqueControl
     * <p>Propósito: Metodo construtor padrão</p>
     * Data: <02/04/2016>
     * @author Sergio Teixeira  <br>
     * copyright Copyright (c) 2015 <br> * </p>
     *
     */
    public SaqueControl() {
    	super();
    	saqueBO = new SaqueBO();
    }


	/**
	 * Nome: doGet
	 * <p>Propósito: Metodo chamado quando e executada uma requisição GET</p>
	 * Data: <02/04/2016>
	 * @author Sergio Teixeira  <br>
	 * copyright Copyright (c) 2015 <br> * </p>
	 *
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("SaqueView.jsp");
		view.forward(request, response);
	}

	/**
	 * Nome:doPost
	 * <p>Propósito: Metodo chamado quando e executada uma requisição POST</p>
	 * Data: <02/04/2016>
	 * @author Sergio Teixeira  <br>
	 * copyright Copyright (c) 2015 <br> * </p>
	 *
	 * @param request HttpServletRequest
	 * @param response HttpServletResSponse
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String valor = request.getParameter("hdValorSaque");
		
		saqueBO.executaSaque(Double.parseDouble(valor));
		
		
		RequestDispatcher view = request.getRequestDispatcher("SaqueView.jsp");
		view.forward(request, response);
	}

}
