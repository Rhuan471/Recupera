// O cenário consiste em cinco filósofos sentados à volta de uma mesa redonda, cada um com um prato de espaguete. Entre cada par de filósofos existe um único garfo.
// Aqui há 5 filósofos, cada filósofo é um thread, e cada filósofo precisa de dois garfos para comer e na mesa tem 5 garfos. O desafio é coordenar o acesso aos garfos de forma que os filósofos possam comer sem entrar em um estado de impasse (deadlock) ou inanição (starvation).
// Para comer, um filósofo precisa de dois garfos.
// O desafio central é implementar uma solução que evite Deadlock (Impasses): Onde todos os filósofos pegam um garfo e ninguém consegue comer e Starvation (Inanição): Onde um ou mais filósofos nunca conseguem acesso aos dois garfos simultaneamente.
// Aqui é a classe filosofo, que representa cada filósofo na mesa. Cada filósofo tem um nome e referências para os garfos à sua esquerda e à sua direita.
// essa classe filósofo tem: extends thread, para que cada filósofo possa ser executado como uma thread separada, permitindo que eles pensem e comam de forma concorrente.
// Cada filósofo deve ser uma Thread independente.
// O filósofo deve alternar entre três estados: Pensando, Com fome (tentando pegar garfos) e Comendo.
// Use Thread com valores aleatórios para simular o tempo de pensamento e de refeição, tornando o comportamento do sistema não-determinístico.
// Primeiramente implementar a solução "ingênua" onde cada filósofo pega o garfo à sua esquerda e depois o da direita. Após observar o deadlock, devem implementar uma das seguintes soluções clássicas para evitar o deadlock:

package comanda;

public class filosofo extends Thread {
    private final String nome;
    private garfo garfoEsquerdo;
    private final garfo garfoDireito;

    public filosofo(String nome, garfo garfoEsquerdo, garfo garfoDireito) {
        this.nome = nome;
        this.garfoEsquerdo = garfoEsquerdo;
        this.garfoDireito = garfoDireito;
    }

    public garfo getGarfoEsquerdo() {
        return garfoEsquerdo;
        
    }

    public void GarfoEsquerdo(garfo garfoEsquerdo) {
        this.garfoEsquerdo = garfoEsquerdo;
        
    }

    @Override
    public void run() {
        while (true) {
            pensar();
            pegarGarfo();
            comer();
            soltarGarfo();
        }
    }

// Aqui é aonde inicia a ação dos filósofos, cada um deles começam a pensar, com o uso do Thread.sleep para simular o tempo gasto em cada ação. O método pegarGarfo é implementado de forma ingênua,
// onde o filósofo tenta pegar primeiro o garfo esquerdo e depois o direito, o que pode levar a um impasse  (deadlock) se todos os filósofos fizerem isso ao mesmo tempo. O método soltarGarfo é 
// apenas uma mensagem, pois os garfos são liberados automaticamente ao sair dos blocos synchronized.

    private void pensar() {
        System.out.println(nome + " está pensando.");
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            getMessage();
        }
    }

    private void pegarGarfo() {
// Implementação ingênua: primeiro pega o garfo esquerdo, depois o direito.
// Este método pode levar a um impasse (deadlock) se todos os filósofos fizerem isso ao mesmo tempo. O uso de blocos synchronized garante que o filósofo tenha acesso exclusivo aos garfos enquanto os
// estiver usando.
        synchronized (getGarfoEsquerdo()) {
            System.out.println(nome + " com fome, pegou o garfo esquerdo.");
            try {
                Thread.sleep((long) (Math.random() * 1000));
// Simula o tempo para pegar o segundo garfo, aumentando a chance de ocorrer um impasse se todos os filósofos fizerem isso ao mesmo tempo.
// Para evitar o deadlock, seria necessário implementar uma estratégia diferente para pegar os garfos, como por exemplo, sempre pegar o garfo de menor número primeiro ou usar um árbitro para
// controlar o acesso aos garfos.
            } catch (InterruptedException e) {
// No lugar de StackTrace, o método getMessage é chamado para lidar com a exceção de forma mais adequada, tomando alguma ação corretiva.
                getMessage();
            }
            synchronized (garfoDireito) {
                System.out.println(nome + " pegou o garfo direito.");
            }
        }
    }

    private void comer() {
        System.out.println(nome + " está comendo.");
        try {
// Aqui simula o tempo de refeição é pausado por um período aleatório, representando o tempo que o filósofo leva para comer. O método Thread.sleep é usado para simular esse tempo, e a exceção 
// InterruptedException é capturada para lidar com possíveis interrupções durante a pausa.
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            getMessage();
        }
    }

    private void soltarGarfo() {
        // Os garfos são liberados automaticamente ao sair dos blocos synchronized
        System.out.println(nome + " soltou os garfos.");
    }

    private void getMessage() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

    private void soltarGarfo() {
        // Implementar a lógica para soltar os garfos após comer
    }
}
