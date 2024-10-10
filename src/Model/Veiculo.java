package Model;

public class Veiculo {
    int veiculo_id;
    int cliente_id;
    String marca;
    String modelo;
    String ano_fabricacao;
    String numero_chassi;
    int quilometragem;

    public Veiculo(int veiculo_id, int cliente_id, String marca, String modelo, String ano_fabricacao, String numero_chassi, int quilometragem) {
        this.veiculo_id = veiculo_id;
        this.cliente_id = cliente_id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano_fabricacao = ano_fabricacao;
        this.numero_chassi = numero_chassi;
        this.quilometragem = quilometragem;
    }

    public int getVeiculo_id() {
        return veiculo_id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getAno_fabricacao() {
        return ano_fabricacao;
    }

    public String getNumero_chassi() {
        return numero_chassi;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

}
