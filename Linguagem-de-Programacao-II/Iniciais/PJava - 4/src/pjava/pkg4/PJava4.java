/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pjava.pkg4;

import java.util.Scanner;

/**
 *
 * @author 082170035
 */
public class PJava4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String texto;
        Scanner recebe = new Scanner(System.in);
        String resposta = "";
        System.out.println("Digite um texto: ");
        texto = recebe.nextLine();
        while (resposta != "0")
        {
            System.out.println("Escolha uma das opções: \n1 - Ultima letra \n2 - Troca de Caracter");
            resposta = recebe.next();
            if ("1".equals(resposta))
            {
                Ultima(texto);
            }
            else if ("2".equals(resposta))
            {
                System.out.println("Letra a ser trocada: ");
                char letra = recebe.next().charAt(0);
                System.out.println("Letra nova: ");
                char letratroca = recebe.next().charAt(0);
                Troca(texto, letra, letratroca);
            }
        }
        
    }
    
    public static void Ultima(String texto)
    {
        String Ultima = texto.substring(texto.length() - 1);
        System.out.println(Ultima);
    }
    
    public static void Troca (String texto, char letra, char letratroca )
    {
        String Troca = texto.replace(letra,letratroca);
        System.out.println(Troca);  
    }
}
