/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pjava.pkg3;

import java.util.Scanner;

/**
 *
 * @author 082170035
 */
public class PJava3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    String palavra;
    Scanner ler = new Scanner (System.in);
    System.out.println("Digite uma palavra: ");
    palavra = ler.nextLine();
    Invertido(palavra);
    }
    
    static void Invertido(String palavra){
    
        int tamanho;
        String invertida = "";
        tamanho = palavra.length()-1;
        for (int i=tamanho; i>=0; i--)
        {
            invertida = invertida + palavra.charAt(i);
        }  
        System.out.println(invertida);
    }
 }
