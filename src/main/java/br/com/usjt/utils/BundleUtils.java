/**
 * Nome: br.com.usjt.utils;
 * Data da Criação: 19/05/2015
 * Compilador: 1.6
 * Propósito: Pacote Principal do Projeto
 * Parâmetros de Compilação:
 */
package br.com.usjt.utils;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Nome: BundleUtils
 * <p>Propósito: Classe responsavel por fornecer os recursos de
 * internacionalizacao para a aplicacao</p>
 * Data: <04/07/2015>
 * @author Sergio Teixeira <br>
 * copyright Copyright (c) 2013 <br> * </p>
 */

public class BundleUtils {

	/**
	 * Atributo Bundle
	 */
	private static ResourceBundle bundles = null;

	/**
	 * Nome: configureBundle
	 * <p>Propósito: Metodo responsavel por configurar o bundle</p>
	 * Data: <23/09/2015>
	 * @author sergio.junior <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 */
	public static void configureBundle(String file, Locale locale) {

		bundles = ResourceBundle.getBundle(file, locale);

	}

	/**
	 * Nome: getString
	 * <p>Propósito: Metodo reponsavel por buscar os recursos no bundle</p>
	 * <p>
	 * Data: <23/09/2015>
	 * @author sergio.junior <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 * @param key
	 * @return
	 */
	public static String getString (String key) {

		try {

			return bundles.getString(key);

		} catch(MissingResourceException ex) {
			System.err.println("Fala ao buscar chave no Bundle");
			return "";
		}
	}

}
