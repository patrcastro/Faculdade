/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pjava.pkg2;

import java.util.Scanner;

/**
 *
 * @author 082170035
 */
public class PJava2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner ler = new Scanner (System.in);
        int numero;
        System.out.println("Informe um numero: ");
        numero = ler.nextInt();
        
        NumeroPar(numero);
    }
        static void NumeroPar(int num)
        {
            if(num%2 == 0)
                System.out.println("Esse numero é par");
            else
                System.out.println("Esse numero é impar");
            
        }
    }
 }
}