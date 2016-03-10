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

import br.com.usjt.model.entidades.ClienteVO;
import br.com.usjt.model.entidades.ContaVO;
import br.com.usjt.model.jdbc.Conexao;

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
			try {

				Conexao data = new Conexao();
				this.conexao = data.getConnection();

			} catch (Exception e) {
				// TODO Trocar por log
				e.printStackTrace();
			}
		}

	public void mudaDispenser(int nota, int qtd)
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
