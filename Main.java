import java.util.ArrayList;

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

