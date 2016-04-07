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
import java.sql.SQLException;

import br.com.usjt.model.entidades.ContaVO;
import br.com.usjt.model.entidades.OperacaoVO;
import br.com.usjt.model.entidades.TransferenciaVO;
import br.com.usjt.model.factory.ConnectionFactory;
import br.com.usjt.security.DadosLogin;

/**
 * Nome: TransferenciaDAO
 * <p>Propósito: DAO - (Data Acess Object) para o conta</p>
 * Data: <04/07/2015>
 * @author Sergio Teixeira <br>
 * copyright Copyright (c) 2013 <br> * </p>
 */
public class TransferenciaDAO {

	/**
	 * Conexao com o banco de dados
	 */
	private Connection conexao = null;


	/**
	 * DAO para a Operação
	 */
	private OperacaoDAO operacao = null;
	
	/**
	 * Nome:TransferenciaDAO
	 * <p>Propósito:Metodo Construtor </p>
	 * Data: <04/07/2015>
	 * @author Sergio Teixeira<br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 *
	 */
	public TransferenciaDAO() {

		this.conexao = ConnectionFactory.getConnection();
		operacao = new OperacaoDAO();
	}

	/**
	 * Nome: cadastrar
	 * <p>Propósito: Metodo responsavel por cadastrar o cliente </p>
	 * Data: <07/07/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 * @param cliente
	 */
	public  void cadastrar(TransferenciaVO transfencia)
    {

		try {
			ContaVO contaDest = new ContaVO();
			contaDest.setAgencia(transfencia.getAgenciaDestino());
			contaDest.setNumero(transfencia.getContaDestino());

			ContaVO contaOrigem = new ContaVO();
			contaOrigem.setAgencia(DadosLogin.agencia);
			contaOrigem.setNumero(DadosLogin.conta);
			operacao.addOperacao(((OperacaoVO)transfencia), contaDest);
			operacao.addOperacao(((OperacaoVO)transfencia), contaOrigem);

	        String sql = "INSERT INTO TRANSFERENCIA (agencia_destino , conta_destino,) values(?,?)";

	        PreparedStatement preparador = conexao.prepareStatement(sql);

            preparador.setInt(1, transfencia.getAgenciaDestino());
            preparador.setInt(2, transfencia.getContaDestino());
            preparador.execute();//execulta o codigo sql
            preparador.close();//fecha conexao com bando banco
            System.out.println("CADASTRADO COM SUCESSO");
        } catch (SQLException ex) {
            System.out.println("Erro inserir");
        } catch (Exception ex){
        	 System.out.println("Erro inserir");
        }
    }

}

