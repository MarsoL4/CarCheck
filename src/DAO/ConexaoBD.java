package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBD {
    public static Connection con=null;// variável de classe conexão

    // Configurando os parâmetros da autenticação
    static String driverJDBC = "";//Nome do driver da Oracle
    static String server = "";//Endereço do Banco de dados (server)
    static String port = "";// Porta TCP padrão da Oracle
    static String user = "";// Usuário BD
    static String passwd = "";// Senha BD
    static String sid = "";//SID do Banco de Dados
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

