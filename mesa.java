//Mesa instancia os garfos e os filósofos, iniciando a execução.
// Nesta classe mesa, criamos os garfos e os filósofos, atribuindo a cada filósofo os garfos à sua esquerda e à sua direita. Em seguida, iniciamos as threads dos filósofos para que eles possam começar a pensar e comer de forma concorrente. A classe mesa é o ponto de entrada do programa, onde a configuração inicial do cenário é feita.

package comanda;

public class mesa {
    public static void main(String[] args) {
        garfo[] garfos = new garfo[5];
        for (int i = 0; i < 5; i++) {
            garfos[i] = new garfo();
        }

        filosofo[] filosofos = new filosofo[5];
        for (int i = 0; i < 5; i++) {
            filosofos[i] = new filosofo("Filósofo " + (i + 1));
            filosofos[i].garfoEsquerdo = garfos[i];
            filosofos[i].garfoDireito = garfos[(i + 1) % 5];
            filosofos[i].start();
        }
    }
}