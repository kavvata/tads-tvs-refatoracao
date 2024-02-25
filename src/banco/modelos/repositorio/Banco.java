package banco.modelos.repositorio;

import java.util.ArrayList;

import banco.modelos.clientes.Cliente;
import banco.modelos.clientes.ClientePF;
import banco.modelos.clientes.ClientePJ;
import banco.modelos.contas.Conta;
import banco.modelos.contas.ContaPoupanca;

//DRY
//Don't
//Repeat
//Yourself

public class Banco {

  private String nome;
  private String email;

  private ArrayList<Cliente> clientes;
  private ArrayList<Conta> contas;

  public Banco(String nome, String email) {
    this.nome = nome;
    this.email = email;

    this.clientes = new ArrayList<>();
    this.contas = new ArrayList<>();
  }

  public boolean adicionaCliente(Cliente cliente) {
    if (buscaCliente(cliente.getDocumento()) == null) {
      clientes.add(cliente);
      return true;
    }
    return false;
  }

  public Cliente buscaCliente(String doc) {

    for (int i = 0; i < clientes.size(); i++) {
      Cliente cliente = clientes.get(i);

      if (cliente.getDocumento().equals(doc)) {
        return cliente;
      }
    }
    return null;
  }

  // procurar na coleção de clientes um cliente com o CPF
  public ClientePF buscaClientePF(String cpf) {
    return (ClientePF) buscaCliente(cpf); // percorer todos os clientes
  }

  public ClientePJ buscaClientePJ(String cnpj) {

    return (ClientePJ) buscaCliente(cnpj);
  }

  public boolean cadastraConta(Conta conta) {

    if (buscaConta(conta.getNumero(), conta.getAgencia()) == null) {
      contas.add(conta);
      return true;
    }

    return false;
  }

  public Conta buscaConta(String numero, String agencia) {

    for (Conta c : contas) {
      if (c.getAgencia().equals(agencia) && c.getNumero().equals(numero)) {
        return c;
      }
    }

    return null;
  }

  public String getEmail() {
    return email;
  }

  public String getNome() {
    return this.nome;
  }

  public ArrayList<ClientePF> getClientesPF() {
    ArrayList<ClientePF> encontrados = new ArrayList<>();

    for (Cliente c : clientes) {
      if (c instanceof ClientePF) {
        encontrados.add((ClientePF) c);
      }
    }
    return encontrados;
  }

  public ArrayList<ClientePJ> getClientesPJ() {
    ArrayList<ClientePJ> encontrados = new ArrayList<>();

    for (Cliente c : clientes) {
      if (c instanceof ClientePJ) {
        encontrados.add((ClientePJ) c);
      }
    }
    return encontrados;
  }

  public ArrayList<Conta> getContasCorrente() {
    ArrayList<Conta> contasCorrente = new ArrayList<>();

    for (Conta c : contas) {
      if (!(c instanceof ContaPoupanca)) {
        contasCorrente.add(c);
      }

    }

    return contasCorrente;
  }

  public ArrayList<ContaPoupanca> getContasPoupanca() {
    ArrayList<ContaPoupanca> contasPoupanca = new ArrayList<>();

    for (Conta c : contas) {
      if (c instanceof ContaPoupanca) {
        contasPoupanca.add((ContaPoupanca) c);
      }

    }

    return contasPoupanca;
  }
}
