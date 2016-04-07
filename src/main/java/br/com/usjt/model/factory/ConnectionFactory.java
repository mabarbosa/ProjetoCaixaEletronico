/**
 * Nome: br.com.usjt.project.banco.projeto.model.dao
 * Data da Criação: 19/05/2015
 * Compilador: 1.6
 * Propósito: Pacote Principal do Projeto
 * Parâmetros de Compilação:
 */
package br.com.usjt.model.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import br.com.usjt.utils.FilePropertieUtils;

/**
 * Nome: Conexao
 * <p>Propósito: Classe responsavel por realizar a conexao com o banco de dados.</p>
 * Data: <23/06/2015>
 * @author Sergio Teixeira <br>
 * copyright Copyright (c) 2013 <br> * </p>
 */
public class ConnectionFactory  {

	/**
	 * Arquivo de propriedades
	 */
	private static Properties application = null;

	/**
	 * Classe de manipulacao
	 */
	private static FilePropertieUtils fileProperties = null;
	
	/**
	 * Connection para o banco de dados
	 */
	private static Connection connection = null;

	//Bloco inicializador Estatico
	static {
		
		fileProperties = new FilePropertieUtils();
		
		if(!(fileProperties == null)){
			application =  fileProperties.getPropertie();
		}
		
		try {
			// Força carregamento do driver na memória
			Class.forName( application.getProperty("bd.mysql.driver") ).newInstance();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
     * Nome: getConnection
     * <p>Propósito: Metodo responsavel por realizar a conexao com o banco de dados </p>
     * Data: <24/06/2015>
     * @author Sergio Teixeira <br>
     * copyright Copyright (c) 2013 <br> * </p>
     * @return the Connection
     */
	public static Connection getConnection() {

		final String URL = application.getProperty("bd.mysql.url");
		final String USER = application.getProperty("bd.mysql.user");
		final String PASSWORD = application.getProperty("bd.mysql.password");

		try {

			//Verifica se já existe conexoes abertas
			if (connection == null) {

				connection = DriverManager.getConnection(URL, USER, PASSWORD);
				// TODO:Trocar por log
				System.out.println("Conectado com sucesso!");
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return connection;
	}
}
