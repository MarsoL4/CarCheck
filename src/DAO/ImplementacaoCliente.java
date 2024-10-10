package DAO;

import Model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImplementacaoCliente {
    Connection con;

    //Método responsável por fazer a conexão com o banco de dados
    public ImplementacaoCliente() { // construtor
        con = ConexaoBD.conectarBD();
    }


    //Método que Cria a tabela TBL_CLIENTE
    public void criarTabelaCliente() {
        Statement st = null;

        try {
            if (con == null) {
                System.out.println("Erro: Conexão não estabelecida.");
                return;
            }

            st = con.createStatement();
            // Criação da tabela no banco
            String sql = "CREATE TABLE TBL_CLIENTE ("
                    + "cliente_id INTEGER PRIMARY KEY, "
                    + "nome VARCHAR2(255) NOT NULL, "
                    + "endereco VARCHAR2(255), "
                    + "contato VARCHAR2(50), "
                    + "cpf VARCHAR2(11)"
                    + ")";
            st.executeUpdate(sql);
            st.close();

            System.out.println("\nTBL_CLIENTE criada com sucesso!");

        } catch (SQLException e) {
            System.out.println("\nErro na criação da Tabela TBL_CLIENTE: " + e.getMessage());
        } finally {
            try {
                if (st != null) st.close();
            } catch (SQLException e) {
                System.out.println("\nErro na criação da Tabela TBL_CLIENTE: " + e.getMessage());
            }
        }
    }

    //Método que insere os dados passados de um cliente na tabela de clientes
    public void inserirCliente(int cliente_id, String nome, String endereco, String contato, String cpf) {

        try {
            if (con == null) {
                System.out.println("\nErro: Conexão não estabelecida.");
                return;
            }

            // Inserção de dados
            String sql = "INSERT INTO TBL_CLIENTE (cliente_id, nome, endereco, contato, cpf) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, cliente_id);
            st.setString(2, nome);
            st.setString(3, endereco);
            st.setString(4, contato);
            st.setString(5, cpf);
            st.executeUpdate();
            st.close();
            System.out.println("\nNovo cliente cadastrado!");

        } catch (SQLException e) {
            System.out.println("\nErro no insert na TBL_CLIENTE: " + e.getMessage());
        }
    }

    //Método que Recupera os Clientes existentes
    public List<Cliente> recuperarClientes(){
        Statement st;
        ResultSet rs;
        List<Cliente> lc = new ArrayList<>();
        try {
            st= con.createStatement();
            rs= st.executeQuery("select * from TBL_CLIENTE");
            System.out.println("\n\nLista dos Clientes cadastrados: ");
            while (rs.next()){
                Cliente c = new Cliente
                        (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5));
                lc.add(c);
            }
            st.close();
        }
        catch (SQLException e) {
            System.out.println("\nErro no select");
        }
        return lc; //retornou a lista
    }


    //Método que busca um Cliente existente a partir de um cpf passado
    public List<Cliente> buscarClienteCPF(String cpf) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Cliente> lcb = new ArrayList<>();

        try {
            pst = con.prepareStatement("SELECT * FROM TBL_CLIENTE WHERE cpf = ?");
            pst.setString(1, cpf);
            rs = pst.executeQuery();

            // Processando o resultado da busca
            while (rs.next()) {
                Cliente c = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                lcb.add(c);
            }
            pst.close();

        } catch (SQLException e) {
            System.out.println("\nErro na busca");
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
            } catch (SQLException e) {
                System.out.println("\nErro na busca");
            }
        }
        return lcb;
    }

    //Método que elimina a TBL_CLIENTE
    public void dropTabelaCliente() {
        Statement st = null;

        try {
            if (con == null) {
                System.out.println("Erro: Conexão não estabelecida.");
                return;
            }

            st = con.createStatement();

            String sql = "DROP TABLE TBL_CLIENTE";
            st.executeUpdate(sql);
            st.close();

            System.out.println("\nTBL_CLIENTE eliminada com sucesso!");

        } catch (SQLException e) {
            System.out.println("\nErro no drop da TBL_CLIENTE: " + e.getMessage());
        } finally {
            try {
                if (st != null) st.close();
            } catch (SQLException e) {
                System.out.println("\nErro ao fechar Statement: " + e.getMessage());
            }
        }
    }




}
