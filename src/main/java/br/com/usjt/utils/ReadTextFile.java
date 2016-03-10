package br.com.usjt.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import br.com.usjt.model.entidades.AutenticacaoVO;

/**
 * Nome: ReadTextFile
 * <p>Propósito: Classe responsavel por ler o arquivo</p>
 * Data: <28/09/2015>
 * @author sergio.junior <br>
 * copyright Copyright (c) 2013 <br> * </p>
 */
public class ReadTextFile {

	/**
	 * Input de arquivo
	 */
	private Scanner input = null;

	/**
	 * Nome: openFile
	 * <p>Propósito: openFile</p>
	 * Data: <28/09/2015>
	 * @author sergio.junior <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 * @param path
	 */
	public void openFile(String path) {

		try {

			input = new Scanner(new File(path));

		} catch (FileNotFoundException fileNotFoundException) {

			System.err.println("Error opening file.");
			System.exit(1);

		}
	}

	/**
	 * Nome: readRecords
	 * <p>Propósito: Metodo responsavel por ler o arquivo</p>
	 * Data: <28/09/2015>
	 * @author sergio.junior <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 * @return AutenticacaoVO[]
	 */
	public AutenticacaoVO[] readRecords() {

		ArrayList<AutenticacaoVO> logins = new ArrayList<AutenticacaoVO>();

		try
		{
			while (input.hasNext()) {

				AutenticacaoVO record = new AutenticacaoVO();
				record.setAgencia(Integer.parseInt(input.next()));
				record.setConta(Integer.parseInt(input.next()));
				record.setSenha(input.next());
				System.out.printf("%-12s%-12s%-12s\n",
						record.getAgencia(),
						record.getConta(),
						record.getSenha());
				logins.add(record);
			}

		} catch (Exception ex) {

			System.err.println("Falha ao ler o arquivo.\n\n Mensagem:" + ex.getMessage());
			input.close();
			System.exit(1);
		}

		return logins.toArray(new AutenticacaoVO[logins.size()]);
	}

	/**
	 * Nome: closeFile
	 * <p>Propósito:Metodo responsavel por  fechar o arquivo</p>
	 * Data: <28/09/2015>
	 * @author sergio.junior <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 */
	public void closeFile() {

		if (input != null)
			input.close();
	}
}

