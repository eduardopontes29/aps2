package interfaces;

import model.Pagamento;

public interface EmissorComprovante {
    void emitir(Pagamento pagamento, String status);
}



//Ele estabelece que qualquer classe responsável pela emissão de comprovantes deverá implementar esse método.
//r exemplo, futuramente poderemos ter uma classe GeradorComprovante que implementará essa interface.


//Aqui estamos trabalhando principalmente com:
//- SRP: a emissão de comprovantes terá uma responsabilidade separada do processamento.
//- ISP: criamos uma interface específica para emissão de comprovantes, sem misturar outras responsabilidades.
//- DIP: outras classes poderão depender dessa abstração, em vez de depender diretamente de um gerador específico.