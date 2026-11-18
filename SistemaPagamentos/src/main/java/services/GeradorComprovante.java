
package services;

import interfaces.EmissorComprovante;
import model.Pagamento;

public class GeradorComprovante implements EmissorComprovante {

    @Override
    public void emitir(Pagamento pagamento, String status) {

        System.out.println("\n===== COMPROVANTE DE PAGAMENTO =====");
        System.out.println("Pagador: " + pagamento.getIdentificacao());
        System.out.printf("Valor: R$ %.2f%n", pagamento.getValor());
        System.out.println("Status: " + status);
        System.out.println("====================================");
    }
}

/*Estamos reforçando dois princípios:

- SRP: a classe possui exclusivamente a responsabilidade de emitir comprovantes.
- ISP: implementa somente a interface específica de emissão de comprovantes.

Uma observação: o status aprovado será uma simulação didática. Mais adiante, vamos
garantir que o comprovante só seja emitido depois que as etapas de disponibilidade e execução forem concluída*/