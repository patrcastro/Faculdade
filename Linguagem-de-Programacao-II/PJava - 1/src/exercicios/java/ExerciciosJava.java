/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios.java;

import java.util.Scanner;

/**
 *
 * @author 082170035
 */
public class ExerciciosJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nome;
        String endereco;
        String telefone;
        
        Scanner ler = new Scanner(System.in);
        
        System.out.println("Qual o seu nome: ");
        nome = ler.nextLine();
        
        System.out.println("Qual o seu endereço: ");
        endereco = ler.nextLine();
        
        System.out.println("Qual o seu telefone: ");
        telefone = ler.nextLine();
        
        System.out.print("Dados coletados: " + nome + "," + endereco + "," + telefone);

    }
    
}
