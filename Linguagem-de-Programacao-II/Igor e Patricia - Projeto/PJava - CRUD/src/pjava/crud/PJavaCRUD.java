/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pjava.crud;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 082170035
 */
public class PJavaCRUD {

    public static void main(String args[]) throws FileNotFoundException, IOException {
        //-------------------------------------------------------------------------------------------------
        //Central de login :
        Scanner ler = new Scanner (System.in);
        System.out.println("Seja bem-vindo! digite seu login\nLogin:");
        String login = ler.nextLine();
        System.out.println("Digite sua senha\nSenha:");
        String senha = ler.nextLine();
        //-------------------------------------------------------------------------------------------------
        //Separação de Logins
        Scanner leitor = new Scanner(new File("C:\\Users\\082170035\\Desktop\\logins.txt"));
        List linhas = new ArrayList<>();
        while (leitor.hasNextLine()) 
        {
            linhas.add(leitor.nextLine());
        }
        leitor.close();
        //-------------------------------------------------------------------------------------------------
        //Realizador do Login
        int cont = 0;
        for (int n=0; n<linhas.size();n++)
        {
          String[] usuario = linhas.get(n).toString().split(",");
          if (login.equals(usuario[0]) && senha.equals(usuario[1]))
          {
              if(usuario[2].equals("V"))
              {
                  Vendedor();
              }
              else 
              {
                  Gerente();
              }
              cont++;
          }
        } 
        if(cont == 0)
        {
          System.out.println("Login não encontrado");
        }
    }
    //-------------------------------------------------------------------------------------------------
    //Tela do Vendedor
    public static void Vendedor() throws FileNotFoundException, IOException
    {
        MenuProd();
    }
    //-------------------------------------------------------------------------------------------------
    //Tela do Gerente
    public static void Gerente()
    {
        
    }
    //-------------------------------------------------------------------------------------------------
    //Método de cadastro/exclusão/edição de produtos
   public static void MenuProd() throws FileNotFoundException, IOException
   {
       Metodos metodos = new Metodos();
       String resposta = null;
       while (!"5".equals(resposta))
       {
       Scanner leitor = new Scanner(new File("C:\\Users\\082170035\\Desktop\\produtos.txt"));
       List linhas = new ArrayList<>();
       
       Scanner leitura = new Scanner(System.in);
       System.out.println("Bem-vindo a central de produtos, você deseja:");
       System.out.println("1 - Visualizar produtos");
       System.out.println("2 - Cadastrar produtos");
       System.out.println("3 - Editar produtos");
       System.out.println("4 - Excluir produtos");
       System.out.println("5 - Sair");
       resposta = leitura.nextLine();
       
       if(resposta.equals("1"))
       {
        while (leitor.hasNextLine()) 
        {
            String products = leitor.nextLine();
            metodos.Listar(linhas, products);
        }
       }
       else if(resposta.equals("2"))
       {
           BufferedWriter buffWrite = new BufferedWriter(new FileWriter("C:\\Users\\082170035\\Desktop\\produtos.txt" , true));
           Produto prod = new Produto();
           System.out.println("Digite o código do produto:");
           prod.codigo = leitura.nextLine();
           System.out.println("Digite o nome do produto:");
           prod.nome = leitura.nextLine();
           System.out.println("Digite a quantidade do produto:");
           prod.qntd = leitura.nextInt();
           System.out.println("Digite o preço do produtos:");
           prod.preco = leitura.nextDouble();
           String novo = prod.codigo + "-" + prod.nome + "-" + prod.qntd + "-" + prod.preco;
           buffWrite.write(novo + "\n");
           buffWrite.close();
       }
       else if(resposta.equals("3"))
       {
           
       }
       else if(resposta.equals("4"))
       {
           
       }
       else{
           System.out.println("Número inválido");
       }
     }  
   }
}

