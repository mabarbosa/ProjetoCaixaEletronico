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
import br.com.usjt.model.factory.ConnectionFactory;


/**
 * Nome:ClienteDAO
 * <p>Propósito: DAO - (Data Acess Object) para o cliente </p>
 * Data: <04/07/2015>
 * @author Sergio Teixeira <br>
 * copyright Copyright (c) 2013 <br> * </p>
 */
public class ClienteDAO {

    /**
     * Conexao com o banco dados
     */
    private Connection conexao = null;

	/**
	 * Nome: ClienteDAO
	 * <p>Propósito: Metodo construtor</p>
	 * Data: <04/07/2015>
	 * @author Sergio Teixeira<br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 * @param data the DataSource
	 */
	public ClienteDAO(Connection connection) {

		this.conexao = connection;

	}
    
    /**
     * Nome: ClienteDAO
     * <p>Propósito: </p>
     * Data: <07/10/2015>
     * @author sergio.junior  <br> 
     * copyright Copyright (c) 2015 <br> * </p>
     */
	public ClienteDAO() {

		this.conexao = ConnectionFactory.getConnection();

	}

	/**
	 * Nome: cadastrar
	 * <p>Propósito: Metodo responsavel por cadastrar o cliente </p>
	 * Data: <07/07/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 * @param cliente
	 */
	public  void cadastrar(ClienteVO cliente)
    {
        String sql = "INSERT INTO USUARIO (nome,login,senha) values(?,?,?)";
        try {
            PreparedStatement preparador = conexao.prepareStatement(sql);
            //configura os valores do insert
//            preparador.setString(1, usuario.getNome());
//            preparador.setString(2, usuario.getLogin());
//            preparador.setString(3, usuario.getSenha());
            preparador.execute();//execulta o codigo sql
            preparador.close();//fecha conexao com bando banco
            System.out.println("CADASTRADO COM SUCESSO");
        } catch (SQLException ex) {
            System.out.println("Erro inserir");
        }
    }

    /**
     * Nome: alterar
     * <p>Propósito: Metodo responsavel por alterar o cliente</p>
     * Data: <04/07/2015>
     * @author Sergio Teixeira <br>
     * copyright Copyright (c) 2013 <br> * </p>
     * @param cliente the cliente
     */
    public  void alterar (ClienteVO cliente)
    {
        String sql = "UPDATE USUARIO SET nome = ? ,login = ?,senha =? WHERE id = ?";
        try {
            PreparedStatement preparador = conexao.prepareStatement(sql);
            //configura os valores do insert
//            preparador.setString(1, usuario.getNome());
//            preparador.setString(2, usuario.getLogin());
//            preparador.setString(3, usuario.getSenha());
//            preparador.setInt(4, usuario.getId());
            preparador.execute();//execulta o codigo sql
            preparador.close();//fecha conexao com bando banco
            System.out.println("Alterado COM SUCESSO");
        } catch (SQLException ex) {
            System.out.println("Erro alterar");
        }
    }

    /**
     * Nome: excluir
     * <p>Propósito: Metodo resposavel por excluir um registro</p>
     * Data: <07/07/2015>
     * @author Sergio Teixeira <br>
     * copyright Copyright (c) 2013 <br> * </p>
     *
     * @param cliente the Cliente
     */
    public void excluir(ClienteVO cliente){
        String sql = "DELETE FROM USUARIO WHERE id=?";
        try {
            PreparedStatement preparador = conexao.prepareStatement(sql);
            //configura os valores do insert
//            preparador.setInt(1, usuario.getId());
            preparador.execute();//execulta o codigo sql
            preparador.close();//fecha conexao com bando banco
            System.out.println("Excluido COM SUCESSO");
        } catch (SQLException ex) {
            System.out.println("Erro exclusao");
        }

    }
    /**
     * Nome: buscarTodos
     * <p>Propósito: </p>
     * <p>
     * Data: <04/07/2015>
     * @author Sergio Teixeira <br>
     * copyright Copyright (c) 2013 <br> * </p>
     * @return List<Cliente>
     */
    public List<ClienteVO> buscarTodos(){
        String sql = "SELECT * FROM USUARIO ";
        List <ClienteVO> list = new ArrayList<ClienteVO>();
        try {
            PreparedStatement preparador = conexao.prepareStatement(sql);

            ResultSet resul = preparador.executeQuery();//execulta consulta

            while(resul.next()){ //execulta enquanro possui registros
            	ClienteVO usu = new ClienteVO(); //um objeto para cada registro
//                usu.setId(resul.getInt("id")); //recupera valor da coluna id
//                usu.setNome(resul.getString("nome"));
//                usu.setLogin(resul.getString("login"));
//                usu.setSenha(resul.getString("senha"));
                list.add(usu);
            }
            System.out.println("busca feita COM SUCESSO");
        } catch (SQLException ex) {
            System.out.println("Erro feio");
        }
        return list;
    }
    /**
     * Nome: buscaPorId
     * <p>Prop�sito: Busca o usuario pelo id </p>
     * Data: <24/06/2015>
     * @author Sergio Teixeira <br>
     * copyright Copyright (c) 2013 <br> * </p>
     *
     * @param id
     * @return
     */
    public ClienteVO buscaPorId(Integer id)
    {
        String sql = "SELECT * FROM usuario WHERE id = ?";
        ClienteVO usu = null;
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet resul = stmt.executeQuery();

            if(resul.next()){ //se tiver registros ele configura o usuario
                usu = new ClienteVO();
//                usu.setId(resul.getInt("id"));
//                usu.setLogin(resul.getString("login"));
//                usu.setNome(resul.getString("nome"));
//                usu.setSenha(resul.getString("senha"));
            }


        } catch (SQLException ex) {
            System.out.println("Erro busca por id"+ ex.getMessage());
        }
        return usu;
    }
    /**
     * Nome: buscaPornome
     * <p>Prop�sito: Busca o usuario pelo nome</p>
     * <p>
     * Data: <24/06/2015>
     * @author Sergio Teixeira <br>
     * copyright Copyright (c) 2013 <br> * </p>
     *
     * @param nome
     * @return
     */
    public List<ClienteVO> buscaPornome(String nome)
    {
        String sql = "SELECT * FROM usuario WHERE nome like ?";// like vai retornar qualquer registtro que contenha aquela palavra
        List <ClienteVO> usuario = new  ArrayList<ClienteVO>();
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, "%"+ nome +"%");// Qualquer coisa no inicio e no fim

            ResultSet resul = stmt.executeQuery();

            while(resul.next()){ //se tiver registros ele configura o usuario
            	ClienteVO usu = new ClienteVO();
//                usu.setId(resul.getInt("id"));
//                usu.setLogin(resul.getString("login"));
//                usu.setNome(resul.getString("nome"));
//                usu.setSenha(resul.getString("senha"));
                usuario.add(usu);
            }
        } catch (SQLException ex) {
            System.out.println("Erro busca por id"+ ex.getMessage());
        }
        return usuario;
    }


    /**
     * Nome: existeUsuario
     * <p>Prop�sito: Verifica se o usuario existe</p>
     * Data: <24/06/2015>
     * @author Sergio Teixeira <br>
     * copyright Copyright (c) 2013 <br> * </p>
     *
     * @param us
     * @return
     */
    public ClienteVO existeUsuario(ClienteVO us)
    {
        String sql = "SELECT * FROM usuario WHERE login = ? and senha = ?";// like vai retornar qualquer registtro que contenha aquela palavra
        ClienteVO usu = new ClienteVO();
        try {

            PreparedStatement stmt = conexao.prepareStatement(sql);
//            stmt.setString(1, us.getLogin());
//            stmt.setString(2, us.getSenha());
            ResultSet resul = stmt.executeQuery();
            while(resul.next())
            {
//                usu.setId(resul.getInt("id"));
//                usu.setLogin(resul.getString("login"));
//                usu.setNome(resul.getString("nome"));
//                usu.setSenha(resul.getString("senha"));
            }
         } catch (SQLException ex) {
            System.out.println("Erro busca por id"+ ex.getMessage());
        }
        return usu;
    }
    
    
    /**
	 * Nome: buscarTodos
	 * <p>Propósito: Metodo reposanvel por exibir todos os registros </p>
	 * Data: <04/07/2015>
	 * @author Sergio Teixeira <br>
	 * copyright Copyright (c) 2013 <br> * </p>
	 * @return the List<Cliente>
	 */
	public ClienteVO buscarClinteLogado (int banco , int agencia , int numConta ) {
		
		String sqlConta = "SELECT * FROM conta WHERE agencia = ? AND numero = ? AND banco = ?";
		 
		String sqlCliente = "SELECT * FROM cliente WHERE cnpj = ?";
		
		ClienteVO cliente = new  ClienteVO();
        try {

            PreparedStatement st = conexao.prepareStatement(sqlConta);
            st.setInt(1, agencia );
            st.setInt(2, numConta );
            st.setInt(3, banco );

            ResultSet resul = st.executeQuery();

			if (resul.next()) {
				
				cliente.setCnpj(resul.getLong("cnpj_cliente"));
				
				PreparedStatement stc = conexao.prepareStatement(sqlCliente);
				stc.setLong(1, cliente.getCnpj());
				
				resul = stc.executeQuery();
				
				if (resul.next()) {
					
					cliente.setNome(resul.getString("nome"));
					
				}
			}			
            System.out.println("Busca Execultada com sucesso");
            
        } catch (SQLException ex) {
        	//TODO:Trocar por gestor de log
            System.out.println("Erro ao execultar a consulta");
        }
        
		return cliente;
	}

}
