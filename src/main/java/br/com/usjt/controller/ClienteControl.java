package br.com.usjt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Nome: ClienteControl
 * <p>Propósito: </p>
 * <p>
 * Data: <07/04/2016>
 * @author sergio.junior  <br> 
 * copyright Copyright (c) 2015 <br> * </p>
 */
@WebServlet("/Cliente.do")
public class ClienteControl extends HttpServlet {
	
	/**
	 * ID de serializacao
	 */
	private static final long serialVersionUID = 1L;
       
    /**
     * Nome: ClienteControl
     * <p>Propósito: Metodo Contrutor padrao </p>
     * <p>
     * Data: <07/04/2016>
     * @author sergio.junior  <br> 
     * copyright Copyright (c) 2015 <br> * </p>
     *
     */
    public ClienteControl() {
        super();
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
	 * Nome: 
	 * <p>Propósito: </p>
	 * <p>
	 * Data: <07/04/2016>
	 * @author sergio.junior  <br> 
	 * copyright Copyright (c) 2015 <br> * </p>
	 *
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
