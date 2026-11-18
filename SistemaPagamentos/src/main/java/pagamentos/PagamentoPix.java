
package pagamentos;

import interfaces.Validador;
import interfaces.EmissorComprovante;
import model.Pagamento;
import template.PagamentoTemplate;

public class PagamentoPix extends PagamentoTemplate {

    private double saldoDisponivel;

    public PagamentoPix(
            Validador validador,
            EmissorComprovante emissor,
            double saldoDisponivel) {

        super(validador, emissor);
        this.saldoDisponivel = saldoDisponivel;
    }

    @Override
    protected void verificarDisponibilidade(Pagamento pagamento) {

        System.out.println("2. Verificando saldo da conta...");

        if (saldoDisponivel < pagamento.getValor()) {
            throw new IllegalStateException(
                "Saldo insuficiente para realizar o PIX."
            );
        }

        System.out.println("Saldo disponível!");
    }

    @Override
    protected void executarPagamento(Pagamento pagamento) {

        saldoDisponivel -= pagamento.getValor();

        System.out.println("3. Transferência PIX realizada!");
        System.out.printf("Saldo restante: R$ %.2f%n",
                saldoDisponivel);
    }
    
    @Override
    protected String obterStatus() {
        return "PAGAMENTO APROVADO";
    }
}


/*
 * 5. Aplicação do S.O.L.I.D.
- SRP: a classe é responsável pelas regras específicas do pagamento via PIX.
- OCP: podemos adicionar outras modalidades sem modificar essa classe.
- LSP: ela deve respeitar o contrato estabelecido por PagamentoTemplate
 */





