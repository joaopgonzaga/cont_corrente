import java.util.ArrayList;

public class ContaPreferencial extends ContaCorrente{
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