
package template;

import interfaces.Validador;
import interfaces.EmissorComprovante;
import model.Pagamento;

public abstract class PagamentoTemplate {

    private final Validador validador;
    private final EmissorComprovante emissor;

    public PagamentoTemplate(
        Validador validador,
        EmissorComprovante emissor
    ) {
        this.validador = validador;
        this.emissor = emissor;
    }

    // TEMPLATE METHOD
    public final void processarPagamento(Pagamento pagamento) {

        System.out.println("\nIniciando processamento...");

        validador.validar(pagamento);

        verificarDisponibilidade(pagamento);

        executarPagamento(pagamento);

        String status = obterStatus();

        emissor.emitir(pagamento, status);

        System.out.println("Processamento finalizado!");
    }

    protected abstract void verificarDisponibilidade(Pagamento pagamento);

    protected abstract void executarPagamento(Pagamento pagamento);

    protected abstract String obterStatus();
}










/*4. Aplicação do S.O.L.I.D


SRP-	A classe controla o fluxo, sem implementar os detalhes de validação e emissão.
OCP-	Novas modalidades podem herdar da classe e implementar suas etapas.
LSP-	As subclasses devem respeitar o comportamento esperado do processamento.
ISP-	Utilizamos interfaces específicas para cada serviço.
DIP-	A classe depende das interfaces Validador e EmissorComprovante*/




