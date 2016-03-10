/**
 * Nome: br.com.usjt.project.banco.projeto.utils;
 * Data da Criação: 19/05/2015
 * Compilador: 1.6
 * Propósito: Pacote Utilitario
 * Parâmetros de Compilação:
 */
package br.com.usjt.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

/**
 * Nome:FilePropertieUtils
 * <p>Propósito: Classe utilitaria para manipulacao do arquivo de Propriedades </p>
 * Data: <04/07/2015>
 * @author Sergio Teixeira <br>
 * copyright Copyright (c) 2013 <br> * </p>
 */
public class FilePropertieUtils {
	/**
	 * Arquivo de Propriedades
	 */
	private Properties propertie = null;
	/**
	 * Nome:FilePropertieUtils
	 * <p>Propósito: Metodo construtor</p>
	 * Data: <04/07/2015>
	 * @author Sergio Teixeira<br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 */
	public FilePropertieUtils( String fileName) {
		this.initialiseProperties(fileName);
	}
	
	/**
	 * Nome:FilePropertieUtils
	 * <p>Propósito: Metodo construtor padrao </p>
	 * Data: <04/07/2015>
	 * @author Sergio Teixeira<br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 */
	public FilePropertieUtils() {
		
		String path = "\\application.properties";
		this.initialiseProperties(path);
	}


	/**
	 * Nome: initialiseProperties
	 * <p>Propósito: Inicializa o Propertie</p>
	 * Data: <04/07/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 * @param filePath
	 */
	private void initialiseProperties(String filePath) {
		URL resourceAsStream = FilePropertieUtils.class.getClassLoader().getResource(filePath);
		URLConnection connection = null;
		InputStream inputStream = null;
		try {
			connection = resourceAsStream.openConnection();
			connection.setUseCaches(false);
			inputStream = connection.getInputStream();
			propertie = new Properties();
			propertie.load(inputStream);
		} catch (IOException e) {
			e.getStackTrace();
		}
	}

	/**
	 * Nome: getPropertie
	 * <p>Propósito: Metodo de acesso</p>
	 * Data: <04/07/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 * @return the Properties
	 */
	public Properties getPropertie() {
		return propertie;
	}

	/**
	 * Nome: setPropertie
	 * <p>Propósito: Metodo modificador </p>
	 * Data: <04/07/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 * @param propertie the Properties
	 */
	public void setPropertie(Properties propertie) {
		this.propertie = propertie;
	}
}
