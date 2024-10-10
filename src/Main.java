import DAO.ImplementacaoCliente;
import DAO.ImplementacaoVeiculo;
import Model.Cliente;
import Model.Veiculo;

import java.util.List;

public class Teste {
    public static void main(String[] args) {
        /*-------------------------------------Métodos de Cliente-------------------------------------*/
        ImplementacaoCliente impC = new ImplementacaoCliente(); //Criação do Objeto impC
        impC.criarTabelaCliente();//Criou a tabela TBL_CLIENTE
        impC.inserirCliente(1, "Rubens", "Rua AAA, 57", "11912345688", "12345678911"); //Inseriu dois novos clientes
        impC.inserirCliente(2, "Henrique", "Rua BBB, 97", "11915724598", "43764583813");

        //Implementação do método que irá mostrar os clientes já cadastrados
        List<Cliente> lc;
        lc= impC.recuperarClientes();
        for (Cliente c: lc)
        {
            System.out.println("\nID:" + c.getCliente_id());
            System.out.println("Nome: " + c.getNome());
            System.out.println("Endereço: " +c.getEndereco());
            System.out.println("Contato: " + c.getContato());
            System.out.println("CPF: " + c.getCpf());
        }

        //Implementação do método que irá recuperar os dados de um cliente específico pelo cpf
        List <Cliente> lcb = impC.buscarClienteCPF("43764583813");
        if (!lcb.isEmpty()){
            for (Cliente c : lcb){
                System.out.println("\n\nDados do Cliente desejado encontrados pelo CPF recebido: ");
                System.out.println("\nID:" + c.getCliente_id());
                System.out.println("Nome: " + c.getNome());
                System.out.println("Endereço: " +c.getEndereco());
                System.out.println("Contato: " + c.getContato());
                System.out.println("CPF: " + c.getCpf());

            }
        } else {
        System.out.println("\n\nNenhum cliente encontrado com o CPF fornecido.");
        }




        /*-------------------------------------Métodos de Veículo-------------------------------------*/
        ImplementacaoVeiculo impV = new ImplementacaoVeiculo(); //Criação do objeto impV
        impV.criarTabelaVeiculo(); //Criação da TBL_VEICULO
        impV.inserirVeiculo(1,1,"Toyota", "Corolla", "2020", "9BWZZZ377VT004251", 30000); //Inseriu dois veiculos que têm o cliente 1 como proprietário
        impV.inserirVeiculo(2,1,"Chevrolet", "Monza", "1996", "9BGZX21X0LC123456", 150000);
        impV.inserirVeiculo(3,2,"Volkswagen", "Brasilia", "1982", "9BWZZZ377BP123456", 200000); //Inseriu um veiculo que tem o cliente 2 como seu proprietário

        //Implementação do método que irá mostrar os veículos cadastrados
        List<Veiculo> lv;
        lv= impV.recuperarVeiculos();
        for (Veiculo v: lv)
        {
            System.out.println("\nID do Veículo:" + v.getVeiculo_id());
            System.out.println("ID do proprietário: " + v.getCliente_id());
            System.out.println("Marca: " +v.getMarca());
            System.out.println("Modelo: " + v.getModelo());
            System.out.println("Ano de fabricação: " + v.getAno_fabricacao());
            System.out.println("Número do chassi: " + v.getNumero_chassi());
            System.out.println("Quilometragem: " + v.getQuilometragem());
        }

        //Implementação do método que irá recuperar os dados de um veículo específico pelo número de chassi
        List <Veiculo> lvb = impV.buscarVeiculoChassi("9BGZX21X0LC123456");
        if (!lvb.isEmpty()){
            for (Veiculo v : lvb){
                System.out.println("\n\nDados do Veículo desejado encontrados pelo Número de Chassi recebido: ");
                System.out.println("\nID do Veículo:" + v.getVeiculo_id());
                System.out.println("ID do proprietário: " + v.getCliente_id());
                System.out.println("Marca: " +v.getMarca());
                System.out.println("Modelo: " + v.getModelo());
                System.out.println("Ano de fabricação: " + v.getAno_fabricacao());
                System.out.println("Número do chassi: " + v.getNumero_chassi());
                System.out.println("Quilometragem: " + v.getQuilometragem());
            }
        } else {
        System.out.println("\n\nNenhum veículo encontrado com o Número de Chassi fornecido.");
    }

        /*-------------------------------------Métodos Gerais-------------------------------------*/
        //Implementação dos Métodos que eliminam a TBL_VEICULO e a TBL_CLIENTE
        //impV.dropTabelaVeiculo();
        //impC.dropTabelaCliente();





    }
}
