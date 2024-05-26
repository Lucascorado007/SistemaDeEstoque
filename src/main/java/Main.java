import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Produto{
  private String nome;
  private String cor;
  private int quantidade;

  public Produto(String nome, String cor, int quantidade){
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
  public int getQuantidade(){
    return quantidade;
  }
  public void setQuantidade(int quantidade){
    this.quantidade = quantidade;
  }
}
class Inventario{
  private Map<String, Produto> produtos = new         HashMap<>();
  public Inventario (){
    this.produtos = new HashMap<>();
  }

  public void adicionarProduto(String nome, String     cor, int quantidade){
   Produto produto = new Produto(nome, cor,             quantidade);
  produtos.put(nome, produto);
  }

  public void removerProduto(String nome){
   produtos.remove(nome);
  }

  public void atualizarQuantidade(String nome, int     quantidade){
  Produto produto = produtos.get(nome);
    if(produto != null){
  produto.setQuantidade(quantidade);
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
      System.out.println("3. Atualizar Qauntidade");
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
    System.out.println("Adicionar produto: ");
    System.out.println("Digite o nome do produto: ");
    String nome = scanner.nextLine();
    System.out.println("Digite a cor do produto: ");
    String cor = scanner.nextLine();
    System.out.println("Digite a quantidade do produto: ");
    int quantidade = scanner.nextInt();
    inventario.adicionarProduto(nome, cor, quantidade);
    System.out.println("Produto adicionado com sucesso!");
  }
  private static void visualizarProduto(){
    System.out.println("Visualizar do produto: ");
    System.out.println("Nome do produto:");
    String nome = scanner.nextLine();
    Produto produto = inventario.getProduto(nome);
    if(produto != null){
      System.out.println("Nome: " + produto.getNome());
      System.out.println("Cor: " + produto.getCor());
      System.out.println("Quantidade: " + produto.getQuantidade());
    } else{
      System.out.println("Produto não encontrado!");
    }
  }
  private static void atualizarQuantidade(){
    System.out.println("Atualizar quantidade: ");
    System.out.println("Digite o nome do produto: ");
    String nome = scanner.nextLine();
    System.out.println("Digite quantidade a ser adicionada: ");
    int quantidade = scanner.nextInt();
    Produto produto = inventario.getProduto(nome);
    if(produto != null){
      int quantidadeAtual = produto.getQuantidade();
      int atualizarQuantidade = quantidadeAtual + quantidade;
      inventario.atualizarQuantidade(nome, quantidadeAtual);
      System.out.println("Quantidade atualizada com sucesso!");
    } else {
      System.out.println("Produto não encontrado!");
    }
  }
  private static void removerProduto(){
    System.out.println("Remover produto: ");
    System.out.println("Digite o nome do produto: ");
    String nome = scanner.nextLine();
    System.out.println("Digite a quantidade a ser removida: ");
    int removerQuantidade = scanner.nextInt();
    Produto produto = inventario.getProduto(nome);
    if(produto != null){
      int quantidadeAtual = produto.getQuantidade();
      if(quantidadeAtual >= removerQuantidade){
      int atualizarQuantidade = quantidadeAtual - removerQuantidade;
      inventario.atualizarQuantidade(nome, quantidadeAtual);
      System.out.println("Produto removido com sucesso!");
    } else {
      System.out.println("Quantidade insuficiente no estoque!");
      }
    }
    }
  }


