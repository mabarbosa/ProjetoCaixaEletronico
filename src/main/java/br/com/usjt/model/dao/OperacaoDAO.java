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
import java.util.List;

import br.com.usjt.model.entidades.OperacaoVO;
import br.com.usjt.model.entidades.ContaVO;
import br.com.usjt.model.factory.ConnectionFactory;
import br.com.usjt.security.DadosLogin;


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
	 * <p>Propósito:Metodo Construtor padrão</p>
	 * Data: <04/07/2015>
	 * @author Sergio Teixeira<br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 */
	public OperacaoDAO() {
		this.conexao = ConnectionFactory.getConnection();
	}
	
	/**
	 * Nome: Contrutor com parametros
	 * <p>Propósito: </p>
	 * <p>
	 * Data: <05/04/2016>
	 * @author sergio.junior  <br> 
	 * copyright Copyright (c) 2015 <br> * </p>
	 *
	 * @param connection
	 */
	public OperacaoDAO(Connection connection) {
		this.conexao = connection;
	}
	

	/**
	 * Nome: getOperacao
	 * <p>Propósito: Metodo responsavel por buscar as operaçoes</p>
	 * <p>
	 * Data: <05/04/2016>
	 * @author sergio.junior  <br> 
	 * copyright Copyright (c) 2015 <br> * </p>
	 *
	 * @param codOperacao 
	 * @return OperacaoVO
	 */
	public OperacaoVO getOperacao(Integer codOperacao)
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

	/**
	 * Nome: addOperacao
	 * <p>Propósito: Metodo reponsavel por buscar as operaçoes</p>
	 * <p>
	 * Data: <05/04/2016>
	 * @author sergio.junior  <br> 
	 * copyright Copyright (c) 2015 <br> * </p>
	 *
	 * @param operacao OperacaoVO
	 * @param conta ContaVO
	 * @return OperacaoVO
	 */
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

	/**
	 * Nome: buscarOperacoes
	 * <p>Propósito: buscarOperacoes </p>
	 * Data: <05/04/2016>
	 * @author sergio.junior  <br> 
	 * copyright Copyright (c) 2015 <br> * </p>
	 *
	 * @param conta ContaVO
	 * @return List<OperacaoVO>
	 */
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
}
