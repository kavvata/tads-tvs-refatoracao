package banco;

import java.util.ArrayList;
import java.util.Scanner;

import banco.modelos.repositorio.Banco;
import banco.modelos.clientes.Cliente;
import banco.modelos.clientes.ClientePF;
import banco.modelos.clientes.ClientePJ;
import banco.modelos.contas.ContaCorrente;
import banco.modelos.contas.ContaCorrenteEspecial;
import banco.modelos.contas.ContaCorrenteSimples;
import banco.modelos.contas.ContaPoupanca;

public class App {
  private static Scanner scan = new Scanner(System.in);
  private static Banco banco = new Banco("Banco teste", "teste@banco.com");

  public static void main(String[] args) throws Exception {

    int opcao = -1;

    while (opcao != 0) {
      showMenu();
      opcao = scan.nextInt();
      scan.nextLine();

      switch (opcao) {
        case 1:
          cadastrarNovoCliente();
          break;
        case 2:
          buscarCliente();
          break;
        case 3:
          cadastrarContaSimples();
          break;
        case 4:
          cadastrarContaEspecial();
          break;
        case 5:
          cadastrarContaPoupanca();
          break;
        case 6:
          listarTodosClientes();
          break;
        case 7:
          listarTodasContas();
          break;
        case 8:
          depositar();
          break;
        case 9:
          sacar();
          break;
        default:
          System.out.println("Opção inválida!");
          break;
      }
    }
  }

  private static void showMenu() {
    System.out.println("1 - cadastrar novo cliente");
    System.out.println("2 - buscar cliente");

    System.out.println("3 - cadastrar conta Simples");
    System.out.println("4 - cadastrar conta Especial");
    System.out.println("5 - cadastrar conta Poupanca");

    System.out.println("6 - listar todos os clientes");
    System.out.println("7 - listas todas as contas");

    System.out.println("8 - depositar em uma conta Simples");
    System.out.println("9 - sacar de uma conta Simples");

    System.out.println("0 - Sair");
    System.out.print("> ");

  }

  private static void cadastrarNovoCliente() {
    final int TIPO_FISICO = 1;
    final int TIPO_JURIDICO = 2;

    Cliente novoCliente;
    int tipoCliente = 0;

    while (tipoCliente != TIPO_FISICO || tipoCliente != TIPO_JURIDICO) {
      System.out.print("Tipo de cliente? \n1 - Fisico\n2 - Juridico\n> ");
      tipoCliente = scan.nextInt();
    }

    System.out.print("Digite o nome: ");
    String nome = scan.nextLine();

    System.out.print("Digite o e-mail: ");
    String email = scan.nextLine();

    System.out.print("Digite o " + (tipoCliente == TIPO_FISICO ? "CPF" : "CNPJ") + ": ");
    String documento = scan.nextLine();

    if (tipoCliente == TIPO_FISICO) {
      System.out.print("Digite o ano de nascimento: ");
      int anoNascimento = scan.nextInt();

      novoCliente = new ClientePF(nome, email, documento, anoNascimento);
    } else {
      System.out.println("Digite o numero de funcionarios: ");
      int numeroFuncionarios = scan.nextInt();

      novoCliente = new ClientePJ(nome, email, documento, numeroFuncionarios);
    }

    if (banco.adicionaCliente(novoCliente)) {
      System.out.println("Cliente adicionado!");
    } else {
      System.out.println("Não foi possível adicionar o cliente!");
    }

    System.out.println("######");
  }

  private static Cliente buscarCliente() {
    final int TIPO_FISICO = 1;
    final int TIPO_JURIDICO = 2;

    int tipoCliente = 0;

    while (tipoCliente != TIPO_FISICO || tipoCliente != TIPO_JURIDICO) {
      System.out.print("Tipo de cliente? \n1 - Fisico\n2 - Juridico\n> ");
      tipoCliente = scan.nextInt();
    }

    String documentoCliente = "";

    System.out.print("Digite o " + (tipoCliente == TIPO_FISICO ? "CPF" : "CNPJ") + "do cliente: ");
    documentoCliente = scan.nextLine();

    Cliente encontrado = banco.buscaCliente(documentoCliente);

    if (encontrado == null) {
      System.out.println("Cliente não encontrado!");
    } else {
      System.out.println(encontrado);
    }

    System.out.println("######");
    return encontrado;
  }

  private static void cadastrarContaSimples() {
    Cliente cliente = buscarCliente();
    if (cliente == null) {
      System.out.println("Cliente nao encontrado.");
      return;
    }

    System.out.println("Cliente encontrado!");
    System.out.println("Digite o número da conta:");
    String numero = scan.nextLine();
    System.out.println("Digite a agência da conta:");
    String agencia = scan.nextLine();

    ContaCorrente contaSimples = new ContaCorrenteSimples(numero, agencia, cliente);

    if (banco.adicionaContaCorrente(contaSimples)) {
      System.out.println("Conta criada com sucesso!");
    } else {
      System.out.println("Nao foi possivel criar conta.");
    }
  }

  private static void cadastrarContaEspecial() {
    Cliente cliente = buscarCliente();
    if (cliente == null) {
      System.out.println("Cliente nao encontrado.");
      return;
    }

    System.out.println("Cliente encontrado!");
    System.out.println("Digite o número da conta:");
    String numero = scan.nextLine();
    System.out.println("Digite a agência da conta:");
    String agencia = scan.nextLine();
    System.out.println("Digite o limite da conta:");
    double limite = scan.nextDouble();

    ContaCorrente novaConta = new ContaCorrenteEspecial(numero, agencia, cliente, 0.0, limite);

    if (banco.adicionaContaCorrente(novaConta)) {
      System.out.println("Conta criada com sucesso!!");
    } else {
      System.out.println("Não foi possível criar a conta!");
    }
    System.out.println("######");
  }

  private static void cadastrarContaPoupanca() {
    Cliente cliente = buscarCliente();
    if (cliente == null) {
      System.out.println("Cliente nao encontrado.");
      return;
    }

    System.out.println("Cliente encontrado!");
    System.out.println("Digite o número da conta:");
    String numero = scan.nextLine();
    System.out.println("Digite a agência da conta:");
    String agencia = scan.nextLine();
    System.out.println("Digite a taxa de rendimento:");
    double txRendimento = scan.nextDouble();

    ContaPoupanca nova = new ContaPoupanca(numero, agencia, cliente);
    nova.setTxRendimento(txRendimento);

    if (banco.adicionaContaPoupanca(nova)) {
      System.out.println("Conta criada com sucesso!!");
    } else {
      System.out.println("Não foi possível criar a conta!");
    }

    System.out.println("######");
  }

  private static void listarTodosClientes() {
    System.out.println("Listando todos os clientes");
    System.out.println("---PF---");
    for (Cliente cliente : banco.getClientesPF()) {
      System.err.println("\t" + cliente.toString());

    }
    System.out.println("---PJ---");
    for (Cliente cliente : banco.getClientesPJ()) {
      System.err.println("\t" + cliente.toString());
    }
    System.out.println("######");
  }

  private static void listarTodasContas() {
    ArrayList<ContaCorrente> contasCorrente = banco.getContasCorrente();

    System.out.println("Listando todas as contas");

    System.out.println("---Simples---");
    for (ContaCorrente conta : contasCorrente) {
      if (conta instanceof ContaCorrenteSimples) {
        System.out.println("\t" + conta.toString());
      }
    }

    System.out.println("---Especial---");
    for (ContaCorrente conta : contasCorrente) {
      if (conta instanceof ContaCorrenteEspecial) {
        System.out.println("\t" + conta.toString());
      }
    }
    System.out.println("---Poupança---");
    for (ContaPoupanca conta : banco.getContasPoupanca()) {
      System.err.println("\t" + conta.toString());
    }
    System.out.println("######");
  }

  static void depositar() {
    System.out.println("Digite o número da conta:");
    String numero = scan.nextLine();
    System.out.println("Digite a agência da conta:");
    String agencia = scan.nextLine();

    ContaCorrente contaSimples = banco.buscaContaCorrente(numero, agencia);
    if (contaSimples == null) {
      System.out.println("Conta nao encontrada!");
      return;
    }

    System.out.println("Digite o valor:");
    double valor = scan.nextDouble();
    contaSimples.depositar(valor);

    System.out.println("######");
  }

  static void sacar() {
    System.out.println("Digite o número da conta:");
    String numero = scan.nextLine();
    System.out.println("Digite a agência da conta:");
    String agencia = scan.nextLine();

    ContaCorrente contaSimples = banco.buscaContaCorrente(numero, agencia);
    if (contaSimples == null) {
      System.out.println("Conta nao encontrada!");
      return;
    }

    System.out.println("Digite o valor:");
    double valor = scan.nextDouble();
    contaSimples.sacar(valor);

    System.out.println("######");
  }
}
