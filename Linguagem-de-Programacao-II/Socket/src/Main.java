import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    private static ServerSocket ss;
    private final static int PORT = 8884;

    public static void main(String[] args) {
        try {
            ss = new ServerSocket(PORT);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        System.out.println("Server Socket rodando na porta = " + ss.getLocalPort());

        while (true) {
            try {
                Socket conexao = ss.accept();
                System.out.println("Cliente Aceito");
                System.out.println("HOSTNAME = " + conexao.getInetAddress().getHostName());
                System.out.println("HOST ADDRESS = " + conexao.getInetAddress().getHostAddress());
                System.out.println("PORTA LOCAL = " + conexao.getLocalPort());
                System.out.println("PORTA DE CONEXAO = " + conexao.getPort());
                System.out.println("======================================");
                new Server(conexao).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}