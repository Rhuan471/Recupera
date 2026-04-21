// A classe garfo representa cada garfo na mesa. Cada garfo tem um estado que indica se está disponível ou não, e métodos para pegar e soltar o garfo. A implementação usa locks para garantir que o acesso ao garfo seja thread-safe, evitando condições de corrida.
// Esta classe garfo representa o recurso compartilhado que os filósofos precisam para comer. O método pegar() tenta adquirir o garfo, retornando true se for bem-sucedido e false se o garfo já estiver em uso. O método soltar() libera o garfo, tornando-o disponível para outros filósofos.
// Cada filósofo é um thread diferente, e o garfo é um recurso compartilhado. O uso de locks garante que apenas um filósofo possa pegar o garfo de cada vez, evitando condições de corrida e garantindo a integridade do estado do garfo.
package comanda;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class garfo {
    private final Lock lock = new ReentrantLock();
    private boolean isAvailable = true;

    public boolean pegar() {
        lock.lock();
        try {
            if (isAvailable) {
                isAvailable = false;
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    public void soltar() {
        lock.lock();
        try {
            isAvailable = true;
        } finally {
            lock.unlock();
        }
    }

    public boolean isAvailable() {
        lock.lock();
        try {
            return isAvailable;
        } finally {
            lock.unlock();
        }
    }
}