
package services;

import interfaces.Validador;
import model.Pagamento;

public class ValidadorPagamento implements Validador {

    @Override
    public void validar(Pagamento pagamento) {

        if (pagamento == null) {
            throw new IllegalArgumentException(
                "O pagamento não pode ser nulo."
            );
        }

        if (pagamento.getValor() <= 0) {
            throw new IllegalArgumentException(
                "O valor do pagamento deve ser maior que zero."
            );
        }

        if (pagamento.getIdentificacao() == null ||
            pagamento.getIdentificacao().trim().isEmpty()) {

            throw new IllegalArgumentException(
                "A identificação do pagador é obrigatória."
            );
        }

        System.out.println("1. Dados do pagamento validados!");
    }
}




//Aqui estamos aplicando principalmente:
//- SRP: a classe possui uma única responsabilidade: validar os dados do pagamento.
//- DIP: ela implementa uma abstração (Validador), permitindo que outras classes
//dependam do contrato em vez de sua implementação.




