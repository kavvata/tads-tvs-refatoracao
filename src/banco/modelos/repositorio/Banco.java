package banco.modelos.repositorio;

import java.util.ArrayList;

import banco.modelos.clientes.Cliente;
import banco.modelos.clientes.ClientePF;
import banco.modelos.clientes.ClientePJ;
import banco.modelos.contas.ContaCorrenteEspecial;
import banco.modelos.contas.ContaCorrenteSimples;
import banco.modelos.contas.ContaPoupanca;

//DRY
//Don't
//Repeat
//Yourself

public class Banco {

  private String nome;
  private String email;

  private ArrayList<Cliente> clientes;

  private ArrayList<ContaCorrenteSimples> contasSimples;
  private ArrayList<ContaCorrenteEspecial> contasEspecial;
  private ArrayList<ContaPoupanca> contasPoupanca;

  public Banco(String nome, String email) {
    this.nome = nome;
    this.setEmail(email);

    this.clientes = new ArrayList<>();

    this.contasSimples = new ArrayList<>();
    this.contasEspecial = new ArrayList<>();
    this.contasPoupanca = new ArrayList<>();
  }

  private boolean adicionaCliente(Cliente cliente) {
    if (buscaCliente(cliente.getDocumento()) == null) {
      clientes.add(cliente);
      return true;
    }
    return false;
  }

  private Cliente buscaCliente(String doc) {

    for (int i = 0; i < clientes.size(); i++) {
      Cliente cliente = clientes.get(i);

      if (cliente.getDocumento().equals(doc)) {
        return cliente;
      }
    }
    return null;
  }

  public boolean adicionaClientePF(ClientePF cliente) {
    return adicionaCliente(cliente);
  }

  // procurar na coleção de clientes um cliente com o CPF
  public ClientePF buscaClientePF(String cpf) {
    return (ClientePF) buscaCliente(cpf); // percorer todos os clientes
  }

  public boolean adicionaClientePJ(ClientePJ cliente) {

    return adicionaCliente(cliente);
  }

  public ClientePJ buscaClientePJ(String cnpj) {

    return (ClientePJ) buscaCliente(cnpj);
  }

  public boolean adicionaContaSimples(ContaCorrenteSimples conta) {

    if (buscaContaSimples(conta.getNumero(), conta.getAgencia()) == null) {
      contasSimples.add(conta);
      return true;
    }
    return false;
  }

  public ContaCorrenteSimples buscaContaSimples(String numero, String agencia) {

    for (ContaCorrenteSimples c : contasSimples) {
      if (c.getAgencia().equals(agencia) && c.getNumero().equals(numero)) {
        return c;
      }
    }
    return null;
  }

  public boolean adicionaContaEspecial(ContaCorrenteEspecial conta) {

    if (buscaContaEspecial(conta.getNumero(), conta.getAgencia()) == null) {
      contasEspecial.add(conta);
      return true;
    }
    return false;
  }

  public ContaCorrenteEspecial buscaContaEspecial(String numero, String agencia) {

    for (ContaCorrenteEspecial c : contasEspecial) {
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

  public ArrayList<Cliente> getClientesPF() {
    return this.clientes;
  }

  public ArrayList<Cliente> getClientesPJ() {
    return this.clientes;
  }

  public ArrayList<ContaCorrenteSimples> getContasSimples() {
    return this.contasSimples;
  }

  public ArrayList<ContaCorrenteEspecial> getContasEspecial() {
    return this.contasEspecial;
  }

  public ArrayList<ContaPoupanca> getContasPoupanca() {
    return this.contasPoupanca;
  }
}
