/**
 * Nome: br.com.usjt.project.banco.projeto.model.dao
 * Data da Criação: 19/05/2015
 * Compilador: 1.6
 * Propósito: Pacote Principal do Projeto
 * Parâmetros de Compilação:
 */
package br.com.usjt.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.usjt.model.factory.ConnectionFactory;

/**
 * Nome: DispenserDAO
 * <p>Propósito: DAO - (Data Acess Object) para o conta</p>
 * Data: <04/07/2015>
 * @author Sergio Teixeira <br>
 * copyright Copyright (c) 2013 <br> * </p>
 */
public class DispenserDAO {

	/**
	 * Conexao com o banco de dados
	 */
	private Connection conexao = null;

	/**
	 * Nome:DispenserDAO
	 * <p>Propósito:Metodo Construtor </p>
	 * Data: <04/07/2015>
	 * @author Sergio Teixeira<br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 */
	public DispenserDAO() {

		this.conexao = ConnectionFactory.getConnection();
	}

	/**
	 * Nome: DispenserDAO
	 * <p>Propósito: Metodo construtor com parametros</p>
	 * <p>
	 * Data: <05/04/2016>
	 * @author sergio.junior  <br> 
	 * copyright Copyright (c) 2015 <br> * </p>
	 *
	 * @param connection
	 */
	public DispenserDAO(Connection connection) {

		this.conexao = connection;
	}
	
	/**
	 * Nome: mudaDispenser
	 * <p>Propósito: Metodo reponsavel por mudar o dispenser </p>
	 * <p>
	 * Data: <05/04/2016>
	 * @author sergio.junior  <br> 
	 * copyright Copyright (c) 2015 <br> * </p>
	 *
	 * @param nota Integer
	 * @param qtd  Integer
	 */
	public void mudaDispenser(Integer nota, Integer qtd)
	{
		String sql = "UPDAtE dispenser set qtdeNota = (qtdeNota - ?) WHERE valorNota = ?";

		try
		{
			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setInt(1, qtd);
			ps.setInt(2, nota);

			ps.executeUpdate();

			ps.close();
		}
		catch(Exception e)
		{
			System.out.println("Erro ao executar a consulta");
		}
	}

	/**
	 * Nome: getNotasDisponiveis
	 * <p>Propósito: pega as notas disponiveis</p>
	 * <p>
	 * Data: <05/04/2016>
	 * @author sergio.junior  <br> 
	 * copyright Copyright (c) 2015 <br> * </p>
	 *
	 * @return List<Integer>
	 */
	public List<Integer> getNotasDisponiveis()
	{
		String sql = "SELECT * FROM dispenser WHERE qtdeNota > 0 order by valorNota desc";

		List<Integer> lista = new ArrayList<Integer>();

        try
        {
            PreparedStatement preparador = conexao.prepareStatement(sql);

            ResultSet resul = preparador.executeQuery();

			while (resul.next())
			{
				lista.add(resul.getInt("valorNota"));
			}

            System.out.println("Busca Executada com sucesso");
        }
        catch (SQLException ex)
        {
            System.out.println("Erro ao executar a consulta");
        }

		return lista;
	}
}
