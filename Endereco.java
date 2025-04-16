public class Endereco {
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
