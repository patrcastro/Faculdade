import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

public class ThreadImpressora  {
    private String nomeImpressora;

    private Thread threadMessaging = new Thread(){
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    String menssage = queue.poll();
                    if(menssage != null) {
                        System.out.println(nomeImpressora + ": " + menssage);
                    }
                    Thread.sleep(10000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    };

    private Queue<String> queue = new ConcurrentLinkedQueue<>();

    public ThreadImpressora(String nome)
    {
        nomeImpressora = nome;
        threadMessaging.start();
    }

    public void addMessage(String menssage) {
        queue.add(menssage);
    }

    public int CountQueue(){
        return  queue.size();
    }
}