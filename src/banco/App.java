package banco;

import java.util.Scanner;

import banco.modelos.repositorio.Banco;
import banco.modelos.clientes.Cliente;
import banco.modelos.clientes.ClientePF;
import banco.modelos.clientes.ClientePJ;
import banco.modelos.contas.ContaCorrenteEspecial;
import banco.modelos.contas.ContaCorrenteSimples;
import banco.modelos.contas.ContaPoupanca;

public class App {
  private static Scanner scan = new Scanner(System.in);
  private static Banco banco = new Banco("Banco teste", "teste@banco.com");

  public static void main(String[] args) throws Exception {

    String cpf, agencia, numero, cnpj;
    ClientePF clientePF;
    ClientePJ clientePJ;
    ContaCorrenteSimples contaSimples;
    ContaCorrenteEspecial contaEspecial;
    ContaPoupanca contaPoupanca;

    double valor, limite, txRendimento;
    int opcao;

    showMenu();
    opcao = scan.nextInt();
    scan.nextLine();
    while (opcao != 0) {
      switch (opcao) {
        case 1:
          cadastrarNovoCliente();
          break;
        case 2:
          System.out.println("Digite o cpf do cliente:");
          cpf = scan.nextLine();
          clientePF = banco.buscaClientePF(cpf);
          if (clientePF != null) {
            System.out.println(clientePF);
          } else {
            System.out.println("Cliente não encontrado!");
          }
          System.out.println("######");
          break;
        case 3:
          break;
        case 4:
          System.out.println("Digite o cnpj do cliente:");
          cnpj = scan.nextLine();
          clientePJ = banco.buscaClientePJ(cnpj);
          if (clientePJ != null) {
            System.out.println(clientePJ);
          } else {
            System.out.println("Cliente não encontrado!");
          }
          System.out.println("######");
          break;

        case 5:
          System.out.println("Digite o cpf do cliente:");
          cpf = scan.nextLine();
          clientePF = banco.buscaClientePF(cpf);
          if (clientePF != null) {
            System.out.println("Cliente encontrado!");
            System.out.println("Digite o número da conta:");
            numero = scan.nextLine();
            System.out.println("Digite a agência da conta:");
            agencia = scan.nextLine();

            contaSimples = new ContaCorrenteSimples(numero, agencia, clientePF);

            if (banco.adicionaContaSimples(contaSimples)) {
              System.out.println("Conta criada com sucesso!!");
            } else {
              System.out.println("Não foi possível criar a conta!");
            }
          } else {
            System.out.println("Cliente não encontrado!");
          }
          System.out.println("######");
          break;
        case 6:
          System.out.println("Digite o cpf do cliente:");
          cpf = scan.nextLine();
          clientePF = banco.buscaClientePF(cpf);
          if (clientePF != null) {
            System.out.println("Cliente encontrado!");
            System.out.println("Digite o número da conta:");
            numero = scan.nextLine();
            System.out.println("Digite a agência da conta:");
            agencia = scan.nextLine();
            System.out.println("Digite o limite da conta:");
            limite = scan.nextDouble();

            contaEspecial = new ContaCorrenteEspecial(numero, agencia, clientePF, 0.0, limite);

            if (banco.adicionaContaEspecial(contaEspecial)) {
              System.out.println("Conta criada com sucesso!!");
            } else {
              System.out.println("Não foi possível criar a conta!");
            }
          } else {
            System.out.println("Cliente não encontrado!");
          }
          System.out.println("######");
          break;
        case 7:
          System.out.println("Digite o cpf do cliente:");
          cpf = scan.nextLine();
          clientePF = banco.buscaClientePF(cpf);
          if (clientePF != null) {
            System.out.println("Cliente encontrado!");
            System.out.println("Digite o número da conta:");
            numero = scan.nextLine();
            System.out.println("Digite a agência da conta:");
            agencia = scan.nextLine();
            System.out.println("Digite a taxa de rendimento:");
            txRendimento = scan.nextDouble();

            contaPoupanca = new ContaPoupanca(numero, agencia, clientePF);
            contaPoupanca.setTxRendimento(txRendimento);

            if (banco.adicionaContaPoupanca(contaPoupanca)) {
              System.out.println("Conta criada com sucesso!!");
            } else {
              System.out.println("Não foi possível criar a conta!");
            }
          } else {
            System.out.println("Cliente não encontrado!");
          }
          System.out.println("######");
          break;
        case 8:
          System.out.println("Listando todos os clientes");
          System.out.println("---PF---");
          for (Cliente cliente : banco.getClientesPF()) {
            if (cliente instanceof ClientePF) {
              System.err.println("\t" + cliente.toString());
            }

          }
          System.out.println("---PJ---");
          for (Cliente cliente : banco.getClientesPJ()) {
            if (cliente instanceof ClientePJ) {
              System.err.println("\t" + cliente.toString());
            }

          }
          System.out.println("######");
          break;
        case 9:
          System.out.println("Listando todas as contas");
          System.out.println("---Simples---");
          for (ContaCorrenteSimples conta : banco.getContasSimples()) {
            System.err.println("\t" + conta.toString());
          }
          System.out.println("---Especial---");
          for (ContaCorrenteEspecial conta : banco.getContasEspecial()) {
            System.err.println("\t" + conta.toString());
          }
          System.out.println("---Poupança---");
          for (ContaPoupanca conta : banco.getContasPoupanca()) {
            System.err.println("\t" + conta.toString());
          }
          System.out.println("######");
          break;
        case 10:
          System.out.println("Digite o número da conta:");
          numero = scan.nextLine();
          System.out.println("Digite a agência da conta:");
          agencia = scan.nextLine();

          contaSimples = banco.buscaContaSimples(numero, agencia);

          if (contaSimples != null) {
            System.out.println("Digite o valor:");
            valor = scan.nextDouble();

            contaSimples.sacar(valor);

          } else {
            System.out.println("Conta não encontrada!");
          }
          System.out.println("######");
          break;
        case 11:
          System.out.println("Digite o número da conta:");
          numero = scan.nextLine();
          System.out.println("Digite a agência da conta:");
          agencia = scan.nextLine();
          contaSimples = banco.buscaContaSimples(numero, agencia);
          if (contaSimples != null) {
            System.out.println("Digite o valor:");
            valor = scan.nextDouble();

            contaSimples.depositar(valor);
          } else {
            System.out.println("Conta não encontrada!");
          }
          System.out.println("######");
          break;
        default:
          System.out.println("Opção inválida!");
          break;
      }

      showMenu();
      opcao = scan.nextInt();
      scan.nextLine();
    }
  }

  private static void showMenu() {
    System.out.println("1 - cadastrar novo cliente");
    System.out.println("2 - buscar cliente por cpf");

    System.out.println("3 - cadastrar cliente PJ");
    System.out.println("4 - buscar cliente por cnpj");

    System.out.println("5 - cadastrar conta Simples");
    System.out.println("6 - cadastrar conta Especial");
    System.out.println("7 - cadastrar conta Poupanca");

    System.out.println("8 - listar todos os clientes");

    System.out.println("9 - listas todas as contas");

    System.out.println("11 - depositar em uma conta Simples");
    System.out.println("12 - sacar de uma conta Simples");

    System.out.println("0 - Sair");
    System.out.println("Digite uma opção:");

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
}
