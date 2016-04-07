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

import br.com.usjt.model.entidades.ContaVO;
import br.com.usjt.model.factory.ConnectionFactory;

/**
 * Nome: ContaDAO
 * <p>Propósito: DAO - (Data Acess Object) para o conta</p>
 * Data: <04/07/2015>
 * @author Sergio Teixeira <br>
 * copyright Copyright (c) 2013 <br> * </p>
 */
public class ContaDAO {

	/**
	 * Conexao com o banco de dados
	 */
	private Connection conexao = null;

	/**
	 * Nome:ContaDAO
	 * <p>Propósito:Metodo Construtor Padrao </p>
	 * Data: <04/07/2015>
	 * @author Sergio Teixeira<br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 */
	public ContaDAO() {

		this.conexao = ConnectionFactory.getConnection();
	}

	/**
	 * Nome: ContaDAO 
	 * <p>Propósito: Metodo construtor com parametros </p>
	 * <p>
	 * Data: <05/04/2016>
	 * @author sergio.junior  <br> 
	 * copyright Copyright (c) 2015 <br> * </p>
	 *
	 * @param connection
	 */
	public ContaDAO(Connection connection) {
		this.conexao = connection;
	}
	
	/**
	 * Nome: buscarTodos
	 * <p>Propósito: Metodo reponsavel por exibir todos os registros </p>
	 * Data: <04/07/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 * @return the List<Cliente>
	 */
	public ContaVO buscarSaldo (int banco , int agencia , int numConta ) {
		
		String sql = "SELECT * FROM conta WHERE agencia = ? AND numero = ? AND banco = ?";
		
		ContaVO conta = new ContaVO();
        try {

            PreparedStatement st = conexao.prepareStatement(sql);
            st.setInt(1, agencia );
            st.setInt(2, numConta );
            st.setInt(3, banco );

            //execulta consulta
            ResultSet resul = st.executeQuery();

            //execulta enquanro possui registros
			if (resul.next()) {
				
				conta.setNumero(resul.getInt("numero"));
				conta.setAgencia(resul.getInt("agencia"));
				conta.setBanco(resul.getString("banco"));
				conta.setSaldo(resul.getDouble("saldo"));
				
			}
			
            System.out.println("Busca Execultada com sucesso");
            
        } catch (SQLException ex) {
        	//TODO:Trocar por gestor de log
            System.out.println("Erro ao execultar a consulta");
        }
        
		return conta;
	}
	
	
	public ContaVO consultaSaldo(int agencia , int numConta ) {
		
		String sql = "SELECT * FROM conta WHERE agencia = ? AND numero = ? ";		
		ContaVO conta = null;
        try {

            PreparedStatement st = conexao.prepareStatement(sql);
            st.setInt(1, agencia );
            st.setInt(2, numConta );

            //execulta consulta
            ResultSet resul = st.executeQuery();
          
            //execulta enquanro possui registros
			if (resul.next()) {
				
				conta = new ContaVO();
				
				conta.setNumero(resul.getInt("numero"));
				conta.setAgencia(resul.getInt("agencia"));
				conta.setBanco(resul.getString("banco"));
				conta.setSaldo(resul.getDouble("saldo"));
				
			}
			
            System.out.println("Busca Execultada com sucesso");
            
        } catch (SQLException ex) 
        {
            System.out.println("Erro ao execultar a consulta");
        }
		
		return conta;
	}
	
	public void mudarSaldo(ContaVO conta, double saldo)
	{
		String sql = "UPDATE conta set saldo = ? where numero = ?";

		try
		{
			PreparedStatement st = conexao.prepareStatement(sql);
			st.setDouble(1, saldo);
			st.setInt(2, conta.getNumero());

			st.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("Erro ao executar o comando.");
		}
	}
	
}
