Correção TP2
---

|           | Criterio 1 | Criterio 2 | Criterio 3 |
|:----------|:----------:|:----------:|:----------:|
|Refat.   1 |  15        | 30         | 55         |
|Refat.   2 |  15        | 40         | 00         |
|Refat.   3 |  15        | 60         | 00         |



### Observações: 
- Refatoração 1:   
  - Critério 1:  Ok 
  - Critério 2:  Ok 
  - Critério 3:  Ok 
  
- Refatoração 2:   
  - Critério 1:  Ok 
  - Critério 2:  Ok - os atributos e métodos de sale foram distribuidos entre as
    classes SaleFormatter e PaymentDetails.
  - Critério 3:  NOk - Foi feita apenas uma substituição de Sale por
    SaleTransaction. -45 pontos.
  Obs: A classe Sale foi extinta e em seu lugar entraram as classes
SaleFormatter, SaleTransaction e PaymentDetails. 
  
- Refatoração 3:   
  - Critério 1:  Ok 
  - Critério 2:  Ok 
  - Critério 3:  NOk - O método SaleProcess::processSale continua tendo
    variáveis temporárias em sua implementação. -25 pontos. 



### Critérios:  

- Critério geral: 
  - No casos de falha dos testes para as unidades em que as refatorações foram
    realizadas, a refatoração será considerada nula. (-100 pontos para a
    refatoração.)   

- Refatoração 1 - Extrair método
  - Critério 1: A refatoração foi aplicada na unidade solicitada? (-15 pontos
    caso contrário) 
  - Critério 2: O novo método tem o retorno adequado para a unidade de onde foi
    extraído? (-30 pontos caso contrário)
  - Critério 3: Todos os pontos em que existia o código extraído foram
    substituídos pela chamada ao novo método? (-10 pontos por substituição não
    realizada, limitado a -55 pontos)


- Refatoração 2 - Extrair classe
  - Critério 1: A nova classe foi criada a partir da classe solicitada? (-15
    pontos caso contrário)
  - Critério 2: Foram movidos ao menos um atributo e um método da classe de
    origem para a classe extraída? (-20 pontos por ausência de método ou
    atributo movido para a classe de origem, limitado a -40 pontos)
  - Critério 3: A classe de origem tem uma referência e instancia o objeto da
    nova classe?  (-25 pontos para cada, limitado a -45 pontos)

- Refatoração 3 - Substituir método por objeto-método
  - Critério 1: A refatoração foi realizada no método indicado? (-15 pontos caso
    contrário)
  - Critério 2: A classe do método-objeto possui como atributos os parâmetros e
    variáveis temporárias do método de origem, e a referência para o objeto de
    origem? (-20 pontos para cada parametro / variável temporária / referência
    que não for definido como atributo na classe do método-objeto, limitado a
    -60 pontos). 
  - Critério 3: O método na classe de origem foi substituído pela instanciação
    do método-objeto e a chamada ao método computar? (-25 pontos)
