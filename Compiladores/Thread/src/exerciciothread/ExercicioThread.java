package exerciciothread;

import java.time.Instant;
import java.util.Random;
import java.util.Scanner;

public class ExercicioThread {

    public static void main(String[] args) throws InterruptedException {

        SampleSingleton.getInstancia().Ativar();
        String nome = " ";

        Scanner ler = new Scanner(System.in);
        try {
            System.out.println("Digite o nome: ");
            nome = ler.nextLine();

            String msg = String.format("%s - Cadastrado com sucesso o registro \n", Instant.now().toString());
            System.out.printf(msg);

            SampleSingleton.getInstancia().AddMensagensSeguranca("Auditoria - " + msg);
            System.out.println(SampleSingleton.getInstancia().VerMensagensSeguranca());
            Thread.sleep(2000);

            Thread.sleep(15000);
        } finally {
            SampleSingleton.getInstancia().Desativar();
        }
    }
}
