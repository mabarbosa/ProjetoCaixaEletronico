package br.com.usjt;

import br.com.usjt.security.CriptografaArquivo;
import br.com.usjt.view.TelaPrincipal;

/**
 * Nome: Main
 * <p>Propósito: Classe principal da aplicacao</p>
 * Data: <06/10/2015>
 * @author sergio.junior  <br>
 * copyright Copyright (c) 2015 <br> * </p>
 */
public class Main
{
	/**
	 * Nome: main
	 * <p>Propósito: Metodo principal da aplicacao </p>
	 * Data: <06/10/2015>
	 * @author sergio.junior  <br>
	 * copyright Copyright (c) 2015 <br> * </p>
	 * @param args
	 */
	public static void main(String[] args)
	{
		new CriptografaArquivo().verificaArquivo();

        new TelaPrincipal();
	}

}
