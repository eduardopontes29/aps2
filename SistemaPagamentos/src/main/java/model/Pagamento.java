package model;

public class Pagamento {

    private double valor;
    private String identificacao;

    public Pagamento(double valor, String identificacao) {
        this.valor = valor;
        this.identificacao = identificacao;
    }

    public double getValor() {
        return valor;
    }

    public String getIdentificacao() {
        return identificacao;
    }
}
//A classe Pagamento será responsável exclusivamente por representar os dados de uma operação.
//Responsabilidade Única do S do S.O.L.I.D;