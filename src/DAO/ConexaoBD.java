package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBD {
    public static Connection con=null;// variável de classe conexão

    // Configurando os parâmetros da autenticação
    static String driverJDBC = "oracle.jdbc.driver.OracleDriver";//Nome do driver da Oracle
    static String server = "oracle.fiap.com.br";//Endereço do Banco de dados (server)
    static String port = "1521";// Porta TCP padrão da Oracle
    static String user = "RM556310";// Usuário BD
    static String passwd = "130206";// Senha BD
    static String sid = "ORCL";//SID do Banco de Dados
    static String url = "jdbc:oracle:thin:@" + server + ":" + port + ":" + sid;//Cria a da url da conexão

    public static Connection conectarBD(){
        if (con == null){
            try {
                Class.forName(driverJDBC);//carrega o Driver
                con = DriverManager.getConnection(url, user, passwd); //Realiza a conexão

            } catch (ClassNotFoundException e) {
                System.out.println("Driver não funcionou");

            }catch (java.sql.SQLException e2){
                System.out.println("Conexão não efetuada");
            }
        }
        return con;
    }


    }

