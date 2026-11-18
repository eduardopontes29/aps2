Sistema de Processamento de Pagamentos

Equipe: Eduardo Pontes, Lucas Mendes, Marcos Vinicius



Sobre o Projeto:

   O projeto consiste em um sistema de pagamentos, desenvolvido em Java,
tendo sido utilizado o padrão de projeto Template Method.

   O sistema simula três modalidades de pagamentos diferentes: PIX, Cartão e
Boleto, cada uma delas possuem as suas próprias regras, porém todas elas seguem
uma sequência padronizada que foi definida pelo Template Method.

Oque é o Template Method?

   Ele é um padrão de projeto que define a estrutura de um algoritmo em uma classe
abstrata, permitindo que as suas subclasses implementem etapas específicas sem alterar
a sequência principal.

Neste projeto, a classe template/PagamentoTemplate determina esse fluxo de processamento:

1-Validar os Dados

2-Verificar Disponibilidade

3-Executar a Operação

4-Obter o Status da modalidade

5-Emitir o Comprovante


As subclasses PagamentoPix, PagamentoCartao e PagamentoBoleto implementam as etapas 
específicas de Verificação, Execução e os Status:

PagamentoPix:

-Confere se existe Saldo Suficiente (Saldo definido como 1000)

-Simula a Transferência

-Retorna "Pagamento Aprovado"



PagamentoCartao:

-Confere se existe limite disponível (Limite definido como 2000)

-Simula a cobrança

-Retorna "Pagamento Aprovado"



PagamentoBoleto:

-Confere se a data de vencimento não passou.

-Registra o boleto

-Retorna "Boleto Registrado"



Estrutura:


main: inicialização do sistema e menu de opções.

model: representação dos dados do pagamento.

interfaces: contratos utilizados pelas classes.

services: serviços de validação e emissão de comprovantes.

template: classe abstrata que define o fluxo de processamento.

pagamentos: implementações específicas de PIX, cartão e boleto.



Por que utilizamos o Template Method?

   Porque nosso sistema de pagamentos trabalha com diferentes formas de pagamento
que possuem um fluxo de processamento semelhante mas apresentam regras específicas 
diferentes uma das outras no momento de execução.
   Com ele, nós conseguimos definir uma sequência fixa de operações na classe
abstrata PagamentoTemplate, permitindo que as subclasses implementem particularidades
em cada uma das modalidades.


Haveria outros padrões que também poderiam ser usados?

   Sim, haveriam como o padrão Strategy que permite criar diferentes
estratégias para executar uma determinada operação, sem utilizar herança,
o padrão State porque ele permite que um objeto tenha comportamentos diferentes
dependendo do estado em que se encontra.





