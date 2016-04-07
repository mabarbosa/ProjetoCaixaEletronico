/**
 * Nome: br.com.usjt.project.banco.projeto.model.dao
 * Data da CriaÃ§Ã£o: 19/05/2015
 * Compilador: 1.6
 * PropÃ³sito: Pacote Principal do Projeto
 * ParÃ¢metros de CompilaÃ§Ã£o:
 */
package br.com.usjt.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.usjt.model.factory.ConnectionFactory;

/**
 * Nome: SaqueDAO
 * <p>PropÃ³sito: DAO - (Data Acess Object) para o conta</p>
 * Data: <04/07/2015>
 * @author Sergio Teixeira <br>
 * copyright Copyright (c) 2013 <br> * </p>
 */
public class SaqueDAO
{

	/**
	 * Conexao com o banco de dados
	 */
	private Connection conexao = null;

	/**
	 * Nome:SaqueDAO
	 * <p>PropÃ³sito:Metodo Construtor </p>
	 * Data: <04/07/2015>
	 * @author Sergio Teixeira<br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 */
	public SaqueDAO() {
		this.conexao = ConnectionFactory.getConnection();
	}
	
	/**
	 * Nome: SaqueDAO
	 * <p>Propósito: Metodo construtor com parametros </p>
	 * <p>
	 * Data: <05/04/2016>
	 * @author sergio.junior  <br> 
	 * copyright Copyright (c) 2015 <br> * </p>
	 *
	 * @param connection
	 */
	public SaqueDAO(Connection connection) {
		this.conexao = ConnectionFactory.getConnection();
	}

	/**
	 * Nome: getNotasDisponiveis
	 * <p>Propósito: buscas todas as notas disponiveis</p>
	 * <p>
	 * Data: <05/04/2016>
	 * @author sergio.junior  <br> 
	 * copyright Copyright (c) 2015 <br> * </p>
	 *
	 * @return String
	 */
	public String getNotasDisponiveis()
	{
		String retorno = null;

		String sql = "SELECT * FROM dispenser WHERE qtdeNota > 0 ORDER BY valorNota";

        try
        {
            PreparedStatement preparador = conexao.prepareStatement(sql);

            ResultSet resul = preparador.executeQuery();

			while (resul.next())
			{
				retorno += "        R$"+ resul.getInt("valorNota") +",00";
			}

            System.out.println("Busca Executada com sucesso");
        }
        catch (SQLException ex)
        {
            System.out.println("Erro ao executar a consulta");
        }

		return retorno;
	}
}
