import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Produto{
  private String nome;
  private String cor;
  private double quantidade;

  public Produto(String nome, String cor, double quantidade){
    this.nome = nome;
    this.cor = cor;
    this.quantidade = quantidade;
  }
  public String getNome(){
    return nome;
  }
  public void setNome(String nome){
    this.nome = nome;
  }
  public String getCor(){
    return cor;
  }
  public void setCor(String cor){
    this.cor = cor;
  }
  public double getQuantidade(){
    return quantidade;
  }
  public void setQuantidade(Double quantidade){
    this.quantidade = quantidade;
  }
  public void adicionarQuantidade(Double quantidade){
    this.quantidade += quantidade;
  }
  public void removerQuantidade(Double quantidade){
    this.quantidade -= quantidade;
  }
}
class Inventario{
  private Map<String, Produto> produtos = new         HashMap<>();
  public Inventario (){
    this.produtos = new HashMap<>();
  }

  public void adicionarProduto(String nome, String     cor, double quantidade){
   Produto produto = new Produto(nome, cor,             quantidade);
  produtos.put(nome, produto);
  }

  public void removerProduto(String nome){
   produtos.remove(nome);
  }

  public void atualizarQuantidade(String nome, double quantidade){
  Produto produto = produtos.get(nome);
    if(produto != null){
  produto.adicionarQuantidade(quantidade);
    }
  }
  public Produto getProduto(String nome){
  return produtos.get(nome);
  }
}
public class Main{
  private static Inventario inventario = new Inventario();
  private static Scanner scanner = new Scanner(System.in);
  
  public static void main(String[] args){
    boolean sair = false;
    while(!sair){
      System.out.println("\n=====SISTEMA DE STOQUE=====");
      System.out.println("1. Adicionar produto");
      System.out.println("2. Visualizar Produtos");
      System.out.println("3. Atualizar Quantidade");
      System.out.println("4. Remover Produto");
      System.out.println("5. Sair");
      System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
      switch(opcao){
        case 1:
          adicionarProduto();
          break;
        case 2:
          visualizarProduto();
          break;
        case 3:
          atualizarQuantidade();
          break;
        case 4:
          removerProduto();
          break;
        case 5:
          sair = true;
        System.out.println("Programas encerrado");
          break;
        default:
        System.out.println("Opção inválida");
      }
    }
    scanner.close();
  }
  private static void adicionarProduto(){
    System.out.println("\nADICIONAR PRODUTO: ");
    System.out.println("Digite o nome do produto: ");
    String nome = scanner.nextLine();
    System.out.println("Digite a cor do produto: ");
    String cor = scanner.nextLine();
    System.out.println("Digite a quantidade do produto: ");
    double quantidade = scanner.nextDouble();
    inventario.adicionarProduto(nome, cor, quantidade);
    System.out.println("-Produto adicionado com sucesso! \n");
  }
  private static void visualizarProduto(){
    System.out.println("\nVISUALIZAR PRODUTO: ");
    System.out.println("Nome do produto:");
    String nome = scanner.nextLine();
    Produto produto = inventario.getProduto(nome);
    if(produto != null){
      System.out.println("Nome: " + produto.getNome());
      System.out.println("Cor: " + produto.getCor());
      System.out.println("Quantidade: " + produto.getQuantidade());
    } else{
      System.out.println("-Produto não encontrado! \n");
    }
  }
  private static void atualizarQuantidade(){
    System.out.println("\nATUALIZAR QUANTIDADE: ");
    System.out.println("Digite o nome do produto: ");
    String nome = scanner.nextLine();
    System.out.println("Digite quantidade a ser adicionada: ");
    double quantidade = scanner.nextDouble();
    Produto produto = inventario.getProduto(nome);
    if(produto != null){
      double quantidadeAtual = produto.getQuantidade();
      double atualizarQuantidade = quantidadeAtual + produto.getQuantidade();
      inventario.atualizarQuantidade(nome, quantidadeAtual);
      System.out.println("-Quantidade atualizada com sucesso! \n");
    } else {
      System.out.println("-Produto não encontrado! \n");
    }
  }
  private static void removerProduto(){
    System.out.println("\nREMOVER PRODUTO: ");
    System.out.println("Digite o nome do produto: ");
    String nome = scanner.nextLine();
    System.out.println("Digite a quantidade a ser removida: ");
    double removerQuantidade = scanner.nextDouble();
    Produto produto = inventario.getProduto(nome);
    if(produto != null){
      double quantidadeAtual = produto.getQuantidade();
      if(quantidadeAtual >= removerQuantidade){
      produto.removerQuantidade(removerQuantidade);
      double atualizarQuantidade = quantidadeAtual - removerQuantidade;
      inventario.atualizarQuantidade(nome, quantidadeAtual);
      System.out.println("-Produto removido com sucesso!");
    } else {
      System.out.println("-Quantidade insuficiente no estoque!");
      }
    }
    }
  }


