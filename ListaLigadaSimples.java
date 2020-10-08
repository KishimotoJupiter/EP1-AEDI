import java.util.Scanner;
import java.io.*;
class ListaLigadaSimples{
  static void gerador(File arq){
    try{
      SLinkedList pilha = new SLinkedList();
      Scanner ler = new Scanner(arq);
      String saida = "";
      while(ler.hasNextLine()){
        String linha = ler.nextLine();
        if(linha.equals("")){
          saida = saida + pilha.removeFirst().getElement() + "\n";
        }
        else{
          Node topo = new Node(linha, null);
          pilha.addFirst(topo);
        }
      }
      FileWriter escrever = new FileWriter("saidaInteligente.txt");
      escrever.write(saida);
      escrever.close();
      ler.close();
    }
    catch(FileNotFoundException ex) {}
    catch(IOException e) {}
  }

  public static void main(String[] args){
    long inicio = System.currentTimeMillis();
    String nome = args[0];
    File arq = new File(nome);
    gerador(arq);
    System.out.print("O tempo de execucao do programa neste arquivo foi de: " + (System.currentTimeMillis() - inicio) + "ms");
  }
}
