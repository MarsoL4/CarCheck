package Model;

public class Cliente {
    int cliente_id;
    String nome;
    String endereco;
    String contato;
    String cpf;

    public Cliente(int cliente_id, String nome, String endereco, String contato, String cpf) {
        this.cliente_id = cliente_id;
        this.nome = nome;
        this.endereco = endereco;
        this.contato = contato;
        this.cpf = cpf;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getContato() {
        return contato;
    }

    public String getCpf() {
        return cpf;
    }

}
