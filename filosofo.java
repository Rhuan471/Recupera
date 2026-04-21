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
    String nome;
    garfo garfoEsquerdo;
    garfo garfoDireito;

    public filosofo(String nome) {
        this.nome = nome;
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

    private void pensar() {
        System.out.println(nome + " está pensando.");
        try {
            Thread.sleep((long) (Math.random() * 1000)); // Simula o tempo de pensamento
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void pegarGarfo() {
        // Implementar a lógica para pegar os garfos, garantindo que não haja deadlock
    }

    private void comer() {
        System.out.println(nome + " está comendo.");
        try {
            Thread.sleep((long) (Math.random() * 1000)); // Simula o tempo de refeição
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void soltarGarfo() {
        // Implementar a lógica para soltar os garfos após comer
    }
}