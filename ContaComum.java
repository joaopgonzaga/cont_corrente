import java.util.ArrayList;

public class ContaComum extends ContaCorrente {
    public ContaComum(String agencia, int numeroconta, ArrayList<Cliente> titulares) {
        super(agencia, numeroconta,"Comum", titulares);
        this.taxa_deposito = 0.2;
        this.taxa_transferencia = 0.2;
        this.taxa_saque = 0.2;
    }
}
