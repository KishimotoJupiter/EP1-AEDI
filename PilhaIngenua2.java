import java.util.Scanner;
import java.io.*;
class PilhaIngenua3{
  static void gerador(File arq){
    try{
      PilhaIngenua PI = new PilhaIngenua();
      Scanner ler = new Scanner(arq);
      String saida = "";
      while(ler.hasNextLine()){
        String linha = ler.nextLine();
        if(linha.equals("")){
          saida = saida + Integer.toString(PI.remove()) + "\n";
        }
        else{
          PI.add(Integer.parseInt(linha));
        }
      }
      FileWriter escrever = new FileWriter("saida.txt");
      escrever.write(saida);
      ler.close();
      escrever.close();
    }
    catch(FileNotFoundException ex){}
    catch(IOException e){}
  }
  public static void main(String[] args){
    long inicio = System.currentTimeMillis();
    String nome = args[0];
    File arq = new File(nome);
    gerador(arq);
    System.out.print("O tempo de execucao do programa neste arquivo foi de: " + (System.currentTimeMillis() - inicio) + "ms");
  }
}
