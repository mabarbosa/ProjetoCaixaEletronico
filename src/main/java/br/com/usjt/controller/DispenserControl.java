package br.com.usjt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Nome: DispenserControl
 * <p>Propósito: Controller para a funcionalidade dispenser</p>
 * Data: <05/04/2016>
 * @author sergio.junior  <br> 
 * copyright Copyright (c) 2015 <br> * </p>
 */
@WebServlet("/Dispenser.do")
public class DispenserControl extends HttpServlet {
	
	/**
	 * ID de serializacao
	 */
	private static final long serialVersionUID = 1L;
       
    /**
     * Nome: DispenserControl
     * <p>Propósito: Metodo construtor padrao</p>
     * <p>
     * Data: <05/04/2016>
     * @author sergio.junior  <br> 
     * copyright Copyright (c) 2015 <br> * </p>
     *
     */
    public DispenserControl() {
        super();
    }

	/**
	 * Nome: doGet
	 * <p>Propósito: </p>
	 * <p>
	 * Data: <05/04/2016>
	 * @author sergio.junior  <br> 
	 * copyright Copyright (c) 2015 <br> * </p>
	 *
	 * @param request
	 * @param response
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
	 * Data: <05/04/2016>
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
		// TODO Implementar
	}

}
