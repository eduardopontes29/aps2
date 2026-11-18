
package pagamentos;

import interfaces.Validador;
import interfaces.EmissorComprovante;
import model.Pagamento;
import template.PagamentoTemplate;

public class PagamentoCartao extends PagamentoTemplate {

    private double limiteDisponivel;

    public PagamentoCartao(
            Validador validador,
            EmissorComprovante emissor,
            double limiteDisponivel) {

        super(validador, emissor);
        this.limiteDisponivel = limiteDisponivel;
    }

    @Override
    protected void verificarDisponibilidade(Pagamento pagamento) {

        System.out.println("2. Verificando limite do cartão...");

        if (limiteDisponivel < pagamento.getValor()) {
            throw new IllegalStateException(
                "Limite insuficiente para realizar o pagamento."
            );
        }

        System.out.println("Limite disponível!");
    }

    @Override
    protected void executarPagamento(Pagamento pagamento) {

        limiteDisponivel -= pagamento.getValor();

        System.out.println("3. Pagamento realizado no cartão!");
        System.out.printf("Limite restante: R$ %.2f%n",
                limiteDisponivel);
    }
    
    @Override
    protected String obterStatus() {
        return "PAGAMENTO APROVADO";
    }
}
/*
 O que estamos aplicando do S.O.L.I.D.?
- SRP: a classe cuida exclusivamente das regras de pagamento com cartão.
- OCP: podemos adicionar novas modalidades sem precisar modificar as classes PIX e Cartão.
- LSP: a classe respeita o contrato definido por PagamentoTemplate.
*/