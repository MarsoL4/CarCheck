package DAO;

import Model.Veiculo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImplementacaoVeiculo {
    Connection con;

    public ImplementacaoVeiculo() { // construtor
        con = ConexaoBD.conectarBD();
    }

    public void criarTabelaVeiculo() {
        Statement st = null;

        try {
            if (con == null) {
                System.out.println("Erro: Conexão não estabelecida.");
                return;
            }

            st = con.createStatement();
            // Criação da tabela no banco
            String sql = "CREATE TABLE TBL_VEICULO ("
                    + "veiculo_id INTEGER PRIMARY KEY, "
                    + "cliente_id INTEGER, "
                    + "marca VARCHAR(50) NOT NULL, "
                    + "modelo VARCHAR(50) NOT NULL, "
                    + "ano_fabricacao VARCHAR(4) NOT NULL, "
                    + "numero_chassi VARCHAR(50) UNIQUE NOT NULL, "
                    + "quilometragem INTEGER NOT NULL, "
                    + "CONSTRAINT chk_ano_fabricacao CHECK ( TO_NUMBER(ano_fabricacao) BETWEEN 1886 AND 2024), "
                    + "FOREIGN KEY (cliente_id) REFERENCES TBL_CLIENTE(cliente_id)"
                    + ")";
            st.executeUpdate(sql);
            st.close();

            System.out.println("\nTBL_VEICULO criada com sucesso!");

        } catch (SQLException e) {
            System.out.println("\nErro na criação da Tabela: " + e.getMessage());
        } finally {
            try {
                if (st != null) st.close();
            } catch (SQLException e) {
                System.out.println("\nErro na criação da Tabela: " + e.getMessage());
            }
        }
    }

    public void inserirVeiculo(int veiculo_id, int cliente_id, String marca, String modelo, String ano_fabricacao, String numero_chassi, int quilometragem) {

        try {
            if (con == null) {
                System.out.println("\nErro: Conexão não estabelecida.");
                return;
            }

            // Inserção de dados
            String sql = "INSERT INTO TBL_VEICULO (veiculo_id, cliente_id, marca, modelo, ano_fabricacao, numero_chassi, quilometragem) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, veiculo_id);
            st.setInt(2, cliente_id);
            st.setString(3, marca);
            st.setString(4, modelo);
            st.setString(5, ano_fabricacao);
            st.setString(6, numero_chassi);
            st.setInt(7, quilometragem);
            st.executeUpdate();
            st.close();

            System.out.println("\nNovo veículo cadastrado!");

        } catch (SQLException e) {
            System.out.println("\nErro no insert na TBL_VEICULO: " + e.getMessage());
        }
    }

    //Método que Recupera os Veiculos existentes
    public List<Veiculo> recuperarVeiculos(){
        Statement st;
        ResultSet rs;
        List<Veiculo> lv = new ArrayList<>();
        try {
            st= con.createStatement();
            rs= st.executeQuery("select * from TBL_VEICULO");
            System.out.println("\n\nLista dos Veículos cadastrados: ");
            while (rs.next()){
                Veiculo v = new Veiculo
                        (rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                lv.add(v);
            }
        }
        catch (SQLException e) {
            System.out.println("\nErro no select ");
        }
        return lv; //retornou a lista
    }


    //Método que busca um Veiculo existente a partir de um numero de chassi
    public List<Veiculo> buscarVeiculoChassi(String numero_chassi) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Veiculo> lvb = new ArrayList<>();

        try {
            pst = con.prepareStatement("SELECT * FROM TBL_VEICULO WHERE numero_chassi = ?");
            pst.setString(1, numero_chassi);
            rs = pst.executeQuery();

            // Processando o resultado da busca
            while (rs.next()) {
                Veiculo v = new Veiculo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                lvb.add(v);
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
        return lvb;
    }

    //Método que elimina a TBL_VEICULO
    public void dropTabelaVeiculo() {
        Statement st = null;

        try {
            if (con == null) {
                System.out.println("Erro: Conexão não estabelecida.");
                return;
            }

            st = con.createStatement();

            String sql = "DROP TABLE TBL_VEICULO";
            st.executeUpdate(sql);
            st.close();

            System.out.println("\nTBL_VEICULO eliminada com sucesso!");

        } catch (SQLException e) {
            System.out.println("\nErro no drop da TBL_VEICULO: " + e.getMessage());
        } finally {
            try {
                if (st != null) st.close();
            } catch (SQLException e) {
                System.out.println("\nErro no drop da TBL_VEICULO: " + e.getMessage());
            }
        }
    }

}
