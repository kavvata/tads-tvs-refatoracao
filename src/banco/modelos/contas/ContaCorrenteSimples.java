package banco.modelos.contas;

import banco.modelos.clientes.Cliente;

public class ContaCorrenteSimples extends Conta {

  // métodos => ações
  public ContaCorrenteSimples(String numero, String agencia, Cliente dono, double saldo) {
    super(numero, agencia, dono, saldo);
  }

  public ContaCorrenteSimples(String numero, String agencia, Cliente dono) {
    this(numero, agencia, dono, 0.0);
  }

}
