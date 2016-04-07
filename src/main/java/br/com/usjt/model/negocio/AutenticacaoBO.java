package br.com.usjt.model.negocio;


import java.io.*;
//import java.nio.file.*;
import java.nio.charset.Charset;

import br.com.usjt.model.entidades.AutenticacaoVO;
import br.com.usjt.security.CryptoAES;
import br.com.usjt.security.DadosLogin;
import br.com.usjt.utils.BuscaBinaria;

/**
 * Nome: Autenticacao
 * <p>Propósito:  </p>
 * Data: <07/10/2015>
 * @author sergio.junior  <br>
 * copyright Copyright (c) 2015 <br> * </p>
 */
public class AutenticacaoBO {

	/**
	 * Nome: validaUsuario
	 * <p>Propósito: metodo responsavel por validar o usuario </p>
	 * Data: <07/10/2015>
	 * @author sergio.junior  <br>
	 * copyright Copyright (c) 2015 <br> * </p>
	 * @param authUser
	 * @return
	 */
	public Boolean validaUsuario(AutenticacaoVO authUser)
	{
		Boolean acesso = false;

		long bancoAgenciaConta = Long.parseLong((authUser.getBanco() +""+ authUser.getAgencia() +""+ authUser.getConta()));

		ProcessaLogin pl = new ProcessaLogin();

		acesso = pl.executar(bancoAgenciaConta, authUser.getSenha());

		if (acesso) {

			DadosLogin.banco = authUser.getBanco();
			DadosLogin.agencia = authUser.getAgencia();
			DadosLogin.conta = authUser.getConta();
		}

		return acesso;
	}

	/**
	 * Nome:
	 * <p>Propósito: </p>
	 * <p>
	 * Data: <07/10/2015>
	 * @author sergio.junior  <br>
	 * copyright Copyright (c) 2015 <br> * </p>
	 */
	public class ProcessaLogin
	{
		   /**
		 * Nome: executar
		 * <p>Propósito: </p>
		 * <p>
		 * Data: <07/10/2015>
		 * @author sergio.junior  <br>
		 * copyright Copyright (c) 2015 <br> * </p>
		 *
		 * @param bancoAgenciaConta
		 * @param senha
		 * @return
		 */
		public boolean executar(long bancoAgenciaConta, String senha) {
			String[] vetor = recuperaArquivoAutenticacao();
			boolean acesso = false;

			try {
				int buscaAcesso = BuscaBinaria.executar(vetor,
						bancoAgenciaConta);

				if (buscaAcesso >= 0) {
					String[] vetorLogin = vetor[buscaAcesso].split(";");

					if (vetorLogin[1].equalsIgnoreCase(senha)) {
						acesso = true;
					}
				}
			} catch (Exception e) {
				System.err.println("Erro: " + e.getMessage());
			}

			return acesso;
		}

		/**
		 * Nome: recuperaArquivoAutenticacao
		 * <p>Propósito: </p>
		 * <p>
		 * Data: <07/10/2015>
		 * @author sergio.junior  <br>
		 * copyright Copyright (c) 2015 <br> * </p>
		 *
		 * @return
		 */
		public String[] recuperaArquivoAutenticacao() {
			String[] retorno = {};

			try {
				// Objeto responsável pela criptografia
				CryptoAES caes = new CryptoAES();

				File f1 = new File(
						"src/main/resources/autenticacao/autenticacao.txt");
				String caminhoArquivoAutenticacao = f1.getAbsolutePath();

				// Captura a string do arquivo
				String arquivo = readFile(caminhoArquivoAutenticacao,
						Charset.defaultCharset());

				// Converte para um vetor de bytes
				byte[] arquivoAutenticacao = arquivo.getBytes("ISO-8859-1");

				// Captura a chave simétrica
				File f2 = new File(
						"src/main/resources/autenticacao/chave.simetrica");
				String caminhoChaveSimetrica = f2.getAbsolutePath();

				File chave = new File(caminhoChaveSimetrica);

				// Descriptografa
				caes.geraDecifra(arquivoAutenticacao, chave);

				// Captura o arquivo descriptografado
				byte[] arquivoDecifrado = caes.getTextoDecifrado();

				// Converte o texto byte[] no equivalente String
				String arquivoDescriptografado = (new String(arquivoDecifrado,
						"ISO-8859-1"));

				retorno = arquivoDescriptografado.split("\n");
			} catch (Exception e) {
				System.err.println("Erro: " + e.getMessage());
			}

			return retorno;
		}

		/**
		 * Nome: readFile
		 * <p>Propósito: </p>
		 * <p>
		 * Data: <07/10/2015>
		 * @author sergio.junior  <br>
		 * copyright Copyright (c) 2015 <br> * </p>
		 *
		 * @param path
		 * @param encoding
		 * @return
		 * @throws IOException
		 */
		private String readFile(String path, Charset encoding)
				throws IOException {
			byte[] encoded = null; //Files.readAllBytes(Paths.get(path));
			return new String(encoded, encoding);
		}
	}
}
