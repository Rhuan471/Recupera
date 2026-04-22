// Nesta mesa, cada filósofo contém apenas um garfo, o que significa que cada filósofo tem um garfo. O garfo é representado por uma classe chamada "garfo", 
// que possui um identificador único e um lock para controlar o acesso ao garfo. O método pegar() tenta adquirir o lock, retornando true se for bem-sucedido e false caso contrário. O método soltar() 
// libera o lock, permitindo que outros filósofos possam pegar o garfo. A classe garfo é projetada para ser thread-safe, garantindo que apenas um filósofo possa pegar o garfo de cada vez.
package comanda;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Com uma variável imutável para o nome do filósofo e uma referência final para o garfo direito, garantimos que essas partes da classe sejam thread-safe. O garfo esquerdo é mutável, mas como cada
// filósofo tem seu próprio garfo esquerdo, não há risco de concorrência nessa parte. O método getGarfoEsquerdo é fornecido para acessar o garfo esquerdo, mas a modificação do garfo esquerdo deve 
// ser feita com cuidado para evitar problemas de concorrência.
public class garfo {
    private String nome = null;
    private Lock lock = null;
    private garfo garfoDireito = null;
    private garfo garfoEsquerdo;

    public garfo(String nome, garfo garfoDireito) {
        this.nome = nome;
        this.lock = new ReentrantLock();
        this.garfoDireito = garfoDireito;
        this.garfoEsquerdo = null; 
    }
// Após pegar o garfo, na mesa fica um garfo a menos, o que significa que o filósofo que pegou o garfo tem acesso a ele, enquanto os outros filósofos não podem pegá-lo até que seja solto. O método pegar() retorna true se o lock for adquirido com sucesso, indicando que o filósofo conseguiu pegar o garfo, e false caso contrário. 

    public garfo(int i) {
        this.nome = "Garfo " + (i + 1);
        this.lock = new ReentrantLock();
        this.garfoDireito = null;
        this.garfoEsquerdo = null;
    }

    public boolean pegar() {
        return lock.tryLock();
    }

// O método soltar() libera o lock, permitindo que outros filósofos possam pegar o garfo novamente.
    public void soltar() {
        lock.unlock();
    }

    public String getNome() {
        return nome;
    }

    public garfo getGarfoDireito() {
        return garfoDireito;
    }

    public garfo getGarfoEsquerdo() {
        return garfoEsquerdo;
    }

    public void setGarfoEsquerdo(garfo garfoEsquerdo) {
        this.garfoEsquerdo = garfoEsquerdo;
    }
}
