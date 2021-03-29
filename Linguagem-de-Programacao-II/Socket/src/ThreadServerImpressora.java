import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

public class ThreadServerImpressora {

    private static ThreadServerImpressora INSTANCE = null;
    private Thread threadMessaging = new Thread(){
        @Override
        public void run() {

            ArrayList<ThreadImpressora> impressoraList = new ArrayList<>();
                impressoraList.add(new ThreadImpressora("IMPRESSORA 1"));
                impressoraList.add(new ThreadImpressora("IMPRESSORA 2"));
                impressoraList.add(new ThreadImpressora("IMPRESSORA 3"));
                impressoraList.add(new ThreadImpressora("IMPRESSORA 4"));
                impressoraList.add(new ThreadImpressora("IMPRESSORA 5"));


            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(100);

                    String menssage = queue.poll();
                    if(menssage != null) {
                        ThreadImpressora impressoraAnterior = impressoraList.get(0);
                        for(ThreadImpressora impressora: impressoraList){
                                if(impressoraAnterior.CountQueue() > impressora.CountQueue()){
                                    impressoraAnterior = impressora;
                                }
                            }
                        impressoraAnterior.addMessage(menssage);
                    }

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    };

    private Queue<String> queue = new ConcurrentLinkedQueue<>();

    public static ThreadServerImpressora getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ThreadServerImpressora();
            INSTANCE.startPrint();
        }
        return INSTANCE;
    }

    public void addMessage(String menssage) {
        queue.add(menssage);
    }

    private void startPrint(){
        threadMessaging.start();
    }
}