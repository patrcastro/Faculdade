import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Server extends Thread {
    private Socket s;

    public Server(Socket s) {
        this.s = s;
    }

    public void run() {
        try (InputStream stream = s.getInputStream()) {
            boolean ativo = true;
            while (ativo) {
                if (stream.available() != 0) {
                    byte[] dados = new byte[stream.available()];
                    stream.read(dados);
                    String dadosLidos = new String(dados);
                    if (dadosLidos.equals("sair"))
                        ativo = false;
                    else
                       ThreadServerImpressora.getInstance().addMessage(new String(dados));
                }
                Thread.sleep(10);
            }
            s.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}