/**
 * Nome: br.com.usjt.project.banco.projeto.model.dao
 * Data da Criação: 19/05/2015
 * Compilador: 1.6
 * Propósito: Pacote Principal do Projeto
 * Parâmetros de Compilação:
 */
package br.com.usjt.model.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import javax.annotation.PostConstruct;

import br.com.usjt.utils.FilePropertieUtils;

/**
 * Nome: Conexao
 * <p>Propósito: Classe responsavel por realizar a conexao com o banco de dados.</p>
 * Data: <23/06/2015>
 * @author Sergio Teixeira <br>
 * copyright Copyright (c) 2013 <br> * </p>
 */
public class Conexao {

	/**
	 * Arquivo de propriedades
	 */
	private Properties application = null;

	/**
	 * Classe de manipulacao
	 */
	private FilePropertieUtils fileProperties = null;
    /**
	 * Nome: Conexao
	 * <p>Propósito: Metodo Construtor</p>
	 * Data: <07/07/2015>
	 * @author Sergio Teixeira<br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 */
	public Conexao() {
		super();
		fileProperties = new FilePropertieUtils();
		if(!(getFileProperties() == null)){
			this.setApplication(fileProperties.getPropertie());
		}
	}

	/**
	 * Nome: init
	 * <p>Propósito: </p>
	 * Data: <07/07/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 */
	@PostConstruct
	private void init(){
		if(!(getFileProperties() == null)){
			this.setApplication(fileProperties.getPropertie());
		}
	}

	/**
     * Nome: getConnection
     * <p>Propósito: Metodo responsavel por realizar a conexao com o banco de dados</p>
     * Data: <24/06/2015>
     * @author Sergio Teixeira <br>
     * copyright Copyright (c) 2013 <br> * </p>
     * @return the Connection
     */
	public Connection getConnection() {

		Connection con = null;
		final String driver =  application.getProperty("bd.mysql.driver");
		final String url =  application.getProperty("bd.mysql.url");
		final String user =  application.getProperty("bd.mysql.user");
		final String password =  application.getProperty("bd.mysql.password");

		try {
			// Força carregamento do driver na memória
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection(url,user,password);
			//TODO:Trocar por log
			System.out.println("Conectado com sucesso!");

		} catch (Exception e) {
			// TODO Configurar log
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * Nome: getApplication
	 * <p>Propósito: </p>
	 * Data: <07/07/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 * @return Properties
	 */
	public Properties getApplication() {
		return application;
	}

	/**
	 * Nome: setApplication
	 * <p>Propósito: </p>
	 * Data: <07/07/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 * @param application the Properties
	 */
	public void setApplication(Properties application) {
		this.application = application;
	}

	/**
	 * Nome: getFileProperties
	 * <p>Propósito: Metodo de acesso</p>
	 * Data: <07/07/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 * @return FilePropertieUtils
	 */
	public FilePropertieUtils getFileProperties() {
		return fileProperties;
	}

	/**
	 * Nome: setFileProperties
	 * <p>Propósito: Metodo modificador</p>
	 * Data: <07/07/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 * @param fileProperties the FilePropertieUtils
	 */
	public void setFileProperties(FilePropertieUtils fileProperties) {
		this.fileProperties = fileProperties;
	}


}
