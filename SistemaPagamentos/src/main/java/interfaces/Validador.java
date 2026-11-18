package interfaces;

import model.Pagamento;

public interface Validador {

    void validar(Pagamento pagamento);

}


//define um contrato que outras classes deverão implementar.
//determina que a classe responsável pela validação deverá receber um pagamento e verificar seus dados.

//DIP — Dependency Inversion Principle

//Nossa futura classe PagamentoTemplate não precisará conhecer diretamente 
//a implementação da validação. Ela conhecerá apenas a interface Validador.
//Isso permite trocar a implementação da validação sem precisar modificar o algoritmo principal.