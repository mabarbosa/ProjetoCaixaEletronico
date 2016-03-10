package br.com.usjt.utils;

import java.io.*;
import java.net.URL;
import java.nio.file.*;
import java.nio.charset.Charset;

public class CriptografaArquivo
{
	public void Criptografa()
	{
		try
		{
			//Objeto responsável pela criptografia
			CryptoAES caes = new CryptoAES();

			//Capturo o caminho do arquivo de autenticação
			File f1 = new File("src/main/resources/autenticacao/autenticacao.txt");
			String caminhoArquivoAutenticacao = f1.getAbsolutePath();

			//Captura a string do arquivo
			String arquivo = this.readFile(caminhoArquivoAutenticacao, Charset.defaultCharset());

			//Converte para um vetor de bytes
			byte[] arquivoAutenticacao = arquivo.getBytes("ISO-8859-1");

			//Captura a chave simétrica
			File f2 = new File("src/main/resources/autenticacao/chave.simetrica");
			String caminhoChaveSimetrica = f2.getAbsolutePath();

			File chave = new File(caminhoChaveSimetrica);

			//Criptografa
		    caes.geraCifra(arquivoAutenticacao, chave);

		    //Captura o arquivo criptografado
		    byte[] arquivoCifrado = caes.getTextoCifrado();

		    // Converte o texto byte[] no equivalente String
		    String arquivoCriptografado = (new String (arquivoCifrado, "ISO-8859-1"));

		    //Salva a string criptografada devolta no arquivo
		    BufferedWriter out = null;
		    try
		    {
		        FileWriter fstream = new FileWriter(caminhoArquivoAutenticacao);
		        out = new BufferedWriter(fstream);
		        out.write(arquivoCriptografado);
		    }
		    catch (IOException e)
		    {
		        System.err.println("Erro: " + e.getMessage());
		    }
		    finally
		    {
		        if(out != null) {
		            out.close();
		        }
		    }
		}
		catch(Exception ex)
		{
			System.err.println("Erro: "+ ex.getMessage());
		}
	}

	public void verificaArquivo()
	{
		try
		{
			//Capturo o caminho do arquivo de autenticação
			File f1 = new File("src/main/resources/autenticacao/autenticacao.txt");
			String caminhoArquivoAutenticacao = f1.getAbsolutePath();

			//Captura a string do arquivo
			String arquivo = this.readFile(caminhoArquivoAutenticacao, Charset.defaultCharset());

			//Se for possível verificar o banco, agencia e conta, significa que o
			//arquivo não está criptografado e necessita ser criptografado.
			String[] vetor = arquivo.split("\n");
			Long.parseLong(vetor[0].substring(0, 8));
			new CriptografaArquivo().Criptografa();
		}
		catch(IOException e)
		{
			System.err.println("Erro: "+ e.getMessage());
		}
		catch(NumberFormatException e)
		{
			//
		}
	}

    private String readFile(String path, Charset encoding) throws IOException
    {
       byte[] encoded = Files.readAllBytes(Paths.get(path));
       return new String(encoded, encoding);
    }
}
