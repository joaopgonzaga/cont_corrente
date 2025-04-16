import java.util.ArrayList;

public class ContaCorrente {
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
