package banco.modelos.contas;

import banco.modelos.clientes.Cliente;

public class ContaPoupanca extends Conta {

  private double txRendimento;

  // métodos => ações
  public ContaPoupanca(String numero, String agencia, Cliente dono, double saldo, double txRendimento) {
    super(numero, agencia, dono, saldo);

    this.txRendimento = txRendimento;
  }

  public ContaPoupanca(String numero, String agencia, Cliente dono, double txRendimento) {
    this(numero, agencia, dono, 0.1, txRendimento);
  }

  public void render() {
    this.saldo += this.saldo * this.txRendimento / 100;
  }

  public double getTxRendimento() {
    return this.txRendimento;
  }

  public void setTxRendimento(double txRendimento) {
    this.txRendimento = txRendimento;
  }

  public String toString() {
    return super.toString() + " txRendimento: " + this.txRendimento;
  }

}
