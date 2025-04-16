import java.util.ArrayList;

public class ContaPoupanca extends ContaCorrente{
    public ContaPoupanca(String agencia, int numeroconta, ArrayList<Cliente> titulares) {
        super(agencia, numeroconta,"Poupança", titulares);
        this.taxa_deposito = 0;
        this.taxa_transferencia = 0.2;
        this.taxa_saque = 0.2;
    }
}