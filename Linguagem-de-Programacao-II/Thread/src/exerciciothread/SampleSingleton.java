package exerciciothread;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SampleSingleton {

    private static SampleSingleton _instance;

    public static SampleSingleton getInstancia() {
        if (_instance == null) {
            _instance = new SampleSingleton();
        }
        return _instance;
    }

    LinkedList<String> ListaDeMensagens;
    ThreadSeguranca thread;

    private SampleSingleton() {

        ListaDeMensagens = new LinkedList<>();
    }

    public void AddMensagensSeguranca(String mensagem) {
        ListaDeMensagens.add(mensagem);
    }

    String VerMensagensSeguranca() {
        String msg = ListaDeMensagens.poll();
        return msg;
    }

    void Ativar() {
        if (thread == null) {
            thread = new ThreadSeguranca();
            thread.start();
        }
    }

    void Desativar() {
        if (thread != null) {
            thread.setStatus(false);
            try {
                thread.join(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(SampleSingleton.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (thread.isAlive()) {
                thread.interrupt();
            }
        }
    }

}
