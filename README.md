# Relatório Técnico

- Como foi utilizada esta estratégia de sincronização?
    - A estratégia de sincronização utilizada foi baseada em locks (travas) para controlar o acesso aos garfos. Cada garfo tem um lock associado, e os filósofos tentam adquirir esses locks para pegar os garfos.

- Como o deadlock foi evitado na hora dos impasses dentro da sincronização?
    - O deadlock é evitado porque cada filósofo tenta pegar os garfos em uma ordem diferente, ou seja, um filósofo tenta pegar primeiro o garfo esquerdo e depois o direito, enquanto outro tenta pegar primeiro o garfo direito e depois o esquerdo. Isso garante que pelo menos um filósofo consiga pegar ambos os garfos e comer, evitando que todos fiquem presos esperando pelos mesmos recursos.

- Starvation:
    - Com base no código executado, o tempo de resposta na execução ocorre um tempo de atraso na hora de de fazer a troca do garfo de um filósofo para o outro.

- O código está executando de uma forma aleatória, aqui embaixo está um exemplo explicado de uma execução:

 Nesta mesa, há cinco filósofos sentados, cada um com seu prato pronto para comer, e apenas cinco garfos na mesa, um garfo dividido para cada filósofo.
 Primeiramente, todos os cinco filósfos vão pensar em uma forma certa para pegar ambos os garfos e comer.
 Os quatro filósofos iniciam a pegar primeiro o garfo esquerdo, e como há apenas um garfo, o garfo esquerdo fica posteriormente atribuído.
 Quando um filósofo pega um garfo, fica um garfo a menos na mesa.
 Mesmo com um garfo a menos, ainda é com a quantidade disponível de garfos na mesa podem ser utilizadas, enquanto o filósofo está comendo.
 Assim que o filósofo termina de comer, ele solta um garfo, deixando o garfo na mesa disponível para outro filósofo.
 A excecução do código é indeterteminável, ou seja, cada vez que o código é executado, a ordem em que os filósofos tentam pegar os garfos pode ser diferente, o que pode levar a resultados diferentes em cada execução. Isso é uma característica comum em sistemas concorrentes, onde a ordem de execução das threads pode variar a cada vez que o programa é executado.

Filósofo 1 está pensando.
Filósofo 4 está pensando.
Filósofo 5 está pensando.
Filósofo 3 está pensando.
Filósofo 2 está pensando.
Filósofo 1 com fome, pegou o garfo esquerdo.
Filósofo 1 pegou o garfo direito.
Filósofo 1 está comendo.
Filósofo 5 com fome, pegou o garfo esquerdo.
Filósofo 2 com fome, pegou o garfo esquerdo.
Filósofo 3 com fome, pegou o garfo esquerdo.
Filósofo 1 soltou os garfos.
Filósofo 1 está pensando.
Filósofo 4 com fome, pegou o garfo esquerdo.
Filósofo 5 pegou o garfo direito.
Filósofo 5 está comendo.
Filósofo 5 soltou os garfos.
Filósofo 5 está pensando.
Filósofo 1 com fome, pegou o garfo esquerdo.
Filósofo 4 pegou o garfo direito.
Filósofo 4 está comendo.
Filósofo 3 pegou o garfo direito.
Filósofo 3 está comendo.
Filósofo 2 pegou o garfo direito.
Filósofo 2 está comendo.
Filósofo 1 pegou o garfo direito.
Filósofo 1 está comendo.
Filósofo 4 soltou os garfos.
