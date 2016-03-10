/**
 * Nome: br.com.bradesco.web.gccf.view.bean
 * Data da Criação: 19/01/2015
 * Compilador: 1.5.0_16
 * Propósito: ${proposito_padrao_cabecalho}
 * Parâmetros de Compilação:
 */
package br.com.usjt.view.arq;

import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class Menu  extends JMenuBar{

	/**
	 * Nome:
	 * <p>Propósito: </p>
	 * <p>
	 * Data: <08/05/2015>
	 * @author sergio.lima / Capgemini <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 */
	public Menu() {

	}

	/**
	 * Nome: buildMenu
	 * <p>Propósito: </p>
	 * <p>
	 * Data: <08/05/2015>
	 * @author sergio.lima / Capgemini <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 */
	private void buildMenu(List <JMenu> menus){
		JMenu menu = new JMenu();
		for (int i = 0; i < menus.size(); i++) {
			this.add(menu);

		}

	}

}
