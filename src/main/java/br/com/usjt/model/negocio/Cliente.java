package br.com.usjt.model.negocio;

import br.com.usjt.model.dao.ClienteDAO;
import br.com.usjt.model.entidades.ClienteVO;
import br.com.usjt.utils.DadosLogin;

/**
 * Nome: Cliente
 * <p>Propósito: Classe de nogocio para cliente </p>
 * Data: <07/10/2015>
 * @author sergio.junior  <br> 
 * copyright Copyright (c) 2015 <br> * </p>
 */
public class Cliente {
	
	
	private ClienteDAO cliente = null;
	
	/**
	 * Nome: 
	 * <p>Propósito: </p>
	 * Data: <07/10/2015>
	 * @author sergio.junior  <br> 
	 * copyright Copyright (c) 2015 <br> * </p>
	 */
	public Cliente() {
		super();
		cliente = new ClienteDAO();
	}

	/**
	 * Nome: buscaClienteLogado
	 * <p>Propósito: </p>
	 * Data: <07/10/2015>
	 * @author sergio.junior  <br> 
	 * copyright Copyright (c) 2015 <br> * </p>
	 * @param banco
	 * @param agencia
	 * @param numConta
	 * @return
	 */
	public String buscaClienteLogado(){
		
		String usuario = "Usuário Generico";
		ClienteVO client = cliente.buscarClinteLogado(DadosLogin.banco, DadosLogin.agencia, DadosLogin.conta );
		
		if(client != null){
			
			usuario = client.getNome();
		}
		
		return usuario;
	}
	
}
