package exerciciothread;

import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadSeguranca extends Thread {
    
    private boolean status;
    String msg= null;

    @Override
    public void run() {
        setStatus(true);
        
        while (status) {
            try {
                msg = SampleSingleton.getInstancia().VerMensagensSeguranca();
                if (msg != null) {
                    enviaMensagemSeguranca(msg);
                }
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadSeguranca.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void setStatus(boolean value) {
        status = value;
    }

    private void enviaMensagemSeguranca(String msg) throws InterruptedException {
        System.out.printf("%s - Valor %s\n", Instant.now().toString(), msg);
        Thread.sleep(100);
    }
}