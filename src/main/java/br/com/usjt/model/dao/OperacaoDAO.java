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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.usjt.model.entidades.ClienteVO;
import br.com.usjt.model.entidades.OperacaoVO;
import br.com.usjt.model.entidades.ContaVO;
import br.com.usjt.utils.DadosLogin;
import br.com.usjt.model.jdbc.Conexao;


/**
 * Nome: OperacaoDAO
 * <p>Propósito: DAO - (Data Acess Object) para o conta</p>
 * Data: <04/07/2015>
 * @author Sergio Teixeira <br>
 * copyright Copyright (c) 2013 <br> * </p>
 */
public class OperacaoDAO {
	/**
	 * Conexao com o banco de dados
	 */
	private Connection conexao = null;

	/**
	 * Nome:OperacaoDAO
	 * <p>Propósito:Metodo Construtor </p>
	 * Data: <04/07/2015>
	 * @author Sergio Teixeira<br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 */
	public OperacaoDAO() {
		try
		{
			Conexao data = new Conexao();
			this.conexao = data.getConnection();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public OperacaoVO getOperacao(int codOperacao)
	{
		ContaDAO contaDao = new ContaDAO();

		ContaVO conta = contaDao.buscarSaldo(DadosLogin.banco, DadosLogin.agencia, DadosLogin.conta );

		//Pesquisa a Operação na Conta Logada
		String sql = "SELECT * FROM operacao WHERE id_operacao="+ codOperacao +" AND id_conta="+ conta.getNumero();

		OperacaoVO operacao = new OperacaoVO();

		try
		{
			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet result = ps.executeQuery();

			if(result.next()){
				operacao.setCodigo(result.getInt("id_operacao"));
				operacao.setConta(conta);
				operacao.setDate(result.getDate("dat"));
				operacao.setTipoOperacao(result.getString("tipo_operacao"));
				operacao.setValor(result.getDouble("valor"));
			}
		}
		catch(Exception e)
		{
			System.out.println("Erro ao executar a consulta");
		}

		return operacao;
	}

	public OperacaoVO addOperacao(OperacaoVO operacao, ContaVO conta)
	{
		String sql = "INSERT INTO operacao (id_conta, dat, valor, tipo_operacao) VALUES(?, ?, ?, ?)";

		try
		{
			PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, conta.getNumero());
			ps.setDate(2, new java.sql.Date(operacao.getDate().getTime()));
			ps.setDouble(3, operacao.getValor());
			ps.setString(4, operacao.getTipoOperacao());
			
			ps.executeUpdate();
			
			ResultSet retorno = ps.getGeneratedKeys();
			retorno.next();

			operacao.setCodigo(retorno.getInt(1));

			ps.close();

		}
		catch(Exception e)
		{
			System.out.println("Erro ao executar a operação.");
		}

		return operacao;
	}

	public List<OperacaoVO> buscarOperacoes(ContaVO conta) {

		String sql = "SELECT * FROM operacao where id_conta ="+ conta.getNumero() ;
        List <OperacaoVO> list = new ArrayList<OperacaoVO>();

        try
        {
            PreparedStatement preparador = conexao.prepareStatement(sql);

            ResultSet resul = preparador.executeQuery();

			while (resul.next())
			{
				OperacaoVO operacao = new OperacaoVO();
				operacao.setCodigo(resul.getInt("id_operacao"));
				operacao.setConta(conta);
				operacao.setDate(resul.getDate("dat"));
				operacao.setTipoOperacao(resul.getString("tipo_operacao"));
				operacao.setValor(resul.getDouble("valor"));

				list.add(operacao);
			}

            System.out.println("Busca Executada com sucesso");
        }
        catch (SQLException ex)
        {
            System.out.println("Erro ao executar a consulta");
        }

		return list;
	}

	public String[][] getExtrato(ContaVO conta)
	{
		List<OperacaoVO> lista = buscarOperacoes(conta);

		String[][] retorno = new String[lista.size()][4];

		int contador = 0;

		try
		{
			for(OperacaoVO operacao : lista)
			{
				String[] x = { operacao.getDate().toString(), operacao.getTipoOperacao().toString(), operacao.getCodigo().toString(), operacao.getValor().toString() };

				retorno[contador] = x;

				contador++;
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

		return retorno;
	}
}
