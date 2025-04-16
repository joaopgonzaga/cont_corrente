public class Cliente {
    String nome, cpf, rg, tipocliente;
    Endereco endereco;

    public Cliente(String nome, String cpf, String rg, Endereco endereco, String tipocliente) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.tipocliente = tipocliente;
    }

    public String toString() {
        return nome + " (" + tipocliente + ") - CPF: " + cpf + ", RG: " + rg + ", Endereço: " + endereco;
    }
}
