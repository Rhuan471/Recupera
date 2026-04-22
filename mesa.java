package comanda;

public class mesa {
    public static void main(String[] args) {
        int numFilosofos = 5;
        garfo[] garfos = new garfo[numFilosofos];
        filosofo[] filosofos = new filosofo[numFilosofos];

        for (int i = 0; i < numFilosofos; i++) {
            garfos[i] = new garfo(i);
        }

// Criar os filósofos e atribuir os garfos.

        for (int i = 0; i < numFilosofos; i++) {
            garfo garfoEsquerdo = garfos[i];
            garfo garfoDireito = garfos[(i + 1) % numFilosofos];
            filosofos[i] = new filosofo("Filósofo " + (i + 1), garfoEsquerdo, garfoDireito);
        }

// Aqui inicia as threads dos filósofos de uma forma aleatória, para evitar que todos os filósofos tentem pegar os garfos na mesma ordem, o que poderia levar a um 
// deadlock. Cada filósofo tenta pegar os garfos, se não conseguir pegar ambos, ele solta o garfo que conseguiu pegar e volta a pensar, garantindo que o sistema 
// continue funcionando sem ficar preso em um impasse.

        for (filosofo f : filosofos) {
            f.start();

// Primeiramente, a execução se inicia com os cinco filósofos, eles começam a pensar, a seleção de filósofos são executados de uma ordem aleatória, ao evitar o deadlock, cada filósofo tenta pegar os 
// garfos, se um filósofo não conseguir pegar ambos os garfos, ele solta o garfo que conseguiu pegar e volta a pensar, isso garante que os filósofos possam continuar a pensar e comer sem ficar presos 
// em um impasse.
        }
    }
}
