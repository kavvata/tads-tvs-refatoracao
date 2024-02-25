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

  private ArrayList<Conta> contasCorrente;

  private ArrayList<ContaPoupanca> contasPoupanca;

  public Banco(String nome, String email) {
    this.nome = nome;
    this.setEmail(email);

    this.clientes = new ArrayList<>();

    this.contasCorrente = new ArrayList<>();
    this.contasPoupanca = new ArrayList<>();
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

  public boolean adicionaContaCorrente(Conta conta) {

    if (buscaContaCorrente(conta.getNumero(), conta.getAgencia()) == null) {
      contasCorrente.add(conta);
      return true;
    }

    return false;
  }

  public Conta buscaContaCorrente(String numero, String agencia) {

    for (Conta c : contasCorrente) {
      if (c.getAgencia().equals(agencia) && c.getNumero().equals(numero)) {
        return c;
      }
    }

    return null;
  }

  public boolean adicionaContaPoupanca(ContaPoupanca conta) {

    if (buscaContaPoupanca(conta.getNumero(), conta.getAgencia()) == null) {
      contasPoupanca.add(conta);
      return true;
    }
    return false;
  }

  public ContaPoupanca buscaContaPoupanca(String numero, String agencia) {

    for (ContaPoupanca c : contasPoupanca) {
      if (c.getAgencia().equals(agencia) && c.getNumero().equals(numero)) {
        return c;
      }
    }
    return null;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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

  public ArrayList<ContatasCorrente() {
    return this.contasCorrente;
  }

  public ArrayList<ContaPoupanca> getContasPoupanca() {
    return this.contasPoupanca;
  }
}
