package banco.modelos.contas;

import banco.modelos.clientes.Cliente;

public class ContaCorrente {

  // atributos => caracteristicas
  private String numero;
  private String agencia;
  protected double saldo;
  // Cliente
  private Cliente dono;

  // métodos => ações
  public ContaCorrente(String numero, String agencia, Cliente dono, double saldo) {
    this.numero = numero;
    this.agencia = agencia;
    this.saldo = saldo;
    this.dono = dono;
  }

  public ContaCorrente(String numero, String agencia, Cliente dono) {
    this(numero, agencia, dono, 0.0);
  }

  public boolean sacar(double valor) {
    if (valor <= saldo) {
      saldo -= valor;
      return true;
    }
    return false;
  }

  public boolean depositar(double valor) {
    if (valor > 0) {
      saldo += valor;
      return true;
    }
    return false;
  }

  public String getNumero() {
    return numero;
  }

  public String getAgencia() {
    return agencia;
  }

  public double getSaldo() {
    return saldo;
  }

  public Cliente getDono() {
    return this.dono;
  }

}
