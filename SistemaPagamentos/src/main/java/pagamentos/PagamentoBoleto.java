
package pagamentos;

import java.time.LocalDate;

import interfaces.Validador;
import interfaces.EmissorComprovante;
import model.Pagamento;
import template.PagamentoTemplate;

public class PagamentoBoleto extends PagamentoTemplate {

    private LocalDate dataVencimento;

    public PagamentoBoleto(
            Validador validador,
            EmissorComprovante emissor,
            LocalDate dataVencimento) {

        super(validador, emissor);
        this.dataVencimento = dataVencimento;
    }

    @Override
    protected void verificarDisponibilidade(Pagamento pagamento) {

        System.out.println("2. Verificando vencimento do boleto...");

        if (dataVencimento == null ||
            dataVencimento.isBefore(LocalDate.now())) {

            throw new IllegalStateException(
                "Boleto vencido ou com data inválida."
            );
        }

        System.out.println("Boleto dentro do prazo de validade!");
    }

    @Override
    protected void executarPagamento(Pagamento pagamento) {

        System.out.println("3. Boleto registrado para pagamento!");

    }
    
    @Override
    protected String obterStatus() {
        return "BOLETO REGISTRADO";
    }
}



/*
Aplicação do S.O.L.I.D.
- SRP: a classe possui as regras específicas da modalidade boleto.
- OCP: podemos acrescentar outras modalidades sem modificar o algoritmo principal.
- LSP: respeitamos os métodos abstratos definidos pela classe principal.
*/