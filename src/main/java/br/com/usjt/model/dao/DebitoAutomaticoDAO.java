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
import java.sql.Statement;

import br.com.usjt.model.entidades.*;
import br.com.usjt.model.jdbc.Conexao;


/**
 * Nome: DebitoAutomaticoDAO
 * <p>Propósito: DAO - (Data Acess Object) para o conta</p>
 * Data: <04/07/2015>
 * @author Sergio Teixeira <br>
 * copyright Copyright (c) 2013 <br> * </p>
 */
public class DebitoAutomaticoDAO {

	/**
	 * Conexao com o banco de dados
	 */
	private Connection conexao = null;


	public DebitoAutomaticoDAO()
	{
		try {

			Conexao data = new Conexao();
			this.conexao = data.getConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean addDebitoAutomatico(DebitoAutomaticoVO debito)
	{
		boolean status = true;

		try
		{
			String sql = "INSERT INTO debito_automatico (id_conta, dat, cod_operadora, cod_consumidor) VALUES(?, ?, ?, ?)";

			try
			{
				PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

				ps.setInt(1, debito.getConta().getNumero());
				ps.setDate(2, new java.sql.Date(debito.getData().getTime()));
				ps.setDouble(3, debito.getCodOperadora());
				ps.setInt(4, debito.getCodConsumidor());

				ps.execute();

				ResultSet retorno = ps.getGeneratedKeys();
				retorno.next();

				debito.setCodigo(retorno.getInt(1));

				ps.close();

			}
			catch(Exception e)
			{
				status = false;

				System.out.println("Erro ao executar a operação.");
			}

		}
		catch(Exception e)
		{
			status = false;
		}

		return status;
	}
}
