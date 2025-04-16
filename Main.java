import java.util.ArrayList;

class Endereco {
    String logradouro, numero, complemento, cep, cidade, estado;

    public Endereco(String logradouro, String numero, String complemento, String cep, String cidade, String estado) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }
    public String toString() {
        return logradouro + ", " + numero + ", " + complemento + ", " + cep + ", " + cidade + " - " + estado;
    }
}

class Cliente {
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


class ContaCorrente {

    String agencia;
    int numeroconta;
    double saldo;
    ArrayList<Cliente> titulares;
    String tipo;
    double taxa_deposito, taxa_saque, taxa_transferencia;
    
    public ContaCorrente(String agencia, int numeroconta, String tipo, ArrayList<Cliente> titulares) {
        this.agencia = agencia;
        this.numeroconta = numeroconta;
        this.saldo = 0.0;
        this.titulares = titulares;
        this.tipo = tipo;
    }

    public void exibirExtrato() {
        System.out.println("Agência: " + agencia);
        System.out.println("Número da Conta: " + numeroconta);
        System.out.println("Saldo: R$ " + saldo);
        System.out.println("Tipo de Conta: " + tipo);
        System.out.print("Titular(es): ");
        for (Cliente titular : titulares) {
            System.out.print(titular.nome + " ");
        }
    }

    public void depositar(double valor) {
        saldo += valor*(1-taxa_deposito);
        System.out.println("Depósito de R$ " + valor + " realizado. Novo saldo: R$ " + saldo);
    }
    public void sacar(double valor) {
        if (valor*(1+taxa_saque) <= saldo) {
            saldo -= valor*(1+taxa_saque);
            System.out.println("Saque de R$ " + valor + " realizado. Novo saldo: R$ " + saldo);
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }
    public void transferir(double valor, ContaCorrente contaDestino) {
        if (saldo > valor*(1+taxa_transferencia)) {
            saldo -= valor*(1+taxa_transferencia);
            contaDestino.depositar(valor);
            System.out.println("Transferência de R$ " + valor + " realizada.");
        }
    }

}

class ContaComum extends ContaCorrente {
    public ContaComum(String agencia, int numeroconta, ArrayList<Cliente> titulares) {
        super(agencia, numeroconta,"Comum", titulares);
        this.taxa_deposito = 0.2;
        this.taxa_transferencia = 0.2;
        this.taxa_saque = 0.2;
    }

}


class ContaPoupanca extends ContaCorrente{
    public ContaPoupanca(String agencia, int numeroconta, ArrayList<Cliente> titulares) {
        super(agencia, numeroconta,"Poupança", titulares);
        this.taxa_deposito = 0;
        this.taxa_transferencia = 0.2;
        this.taxa_saque = 0.2;
    }
}

class ContaPreferencial extends ContaCorrente{
    public ContaPreferencial(String agencia, int numeroconta, ArrayList<Cliente> titulares) {
        super(agencia, numeroconta,"Preferencial", titulares);
        this.taxa_deposito = 0.2;
        this.taxa_saque = 0.2;
        if(saldo >= 50000){
            taxa_transferencia = 0.1;
        }
        else{
            taxa_transferencia = 0.2;
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Endereco endereco = new Endereco("Rua Principal", "123", "Apto 101", "12345-678", "Cidade X", "Estado Y");

        Cliente cliente1 = new Cliente("Carlos Silva", "100.000.000-00", "123456", endereco, "Comum");
        Cliente cliente2 = new Cliente("Maria Silva", "200.000.000-00", "654321", endereco, "Comum");
        Cliente cliente3 = new Cliente("João Oliveira", "300.000.000-00", "111223", endereco, "Especial");

        ArrayList<Cliente> titularesContaConjunta = new ArrayList<>();
        titularesContaConjunta.add(cliente1);
        titularesContaConjunta.add(cliente2);
        ContaCorrente contaConjunta = new ContaComum("001", 123456, titularesContaConjunta);

        ArrayList<Cliente> titularesContaPoupanca = new ArrayList<>();
        titularesContaPoupanca.add(cliente1);
        ContaCorrente contaPoupanca = new ContaPoupanca("002", 654321, titularesContaPoupanca);

        ArrayList<Cliente> titularesContaPreferencial = new ArrayList<>();
        titularesContaPreferencial.add(cliente3);
        ContaCorrente contaPreferencial = new ContaPreferencial("003", 789012, titularesContaPreferencial);

        System.out.println("Operações para a Conta Conjunta:");
        contaConjunta.depositar(1000);
        contaConjunta.sacar(500);
        contaConjunta.transferir(200, contaPoupanca);
        contaConjunta.exibirExtrato();
}

}

