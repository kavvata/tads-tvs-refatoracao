package banco.modelos.clientes;

public class ClientePF extends Cliente {

  private String cpf;
  private int anoNascimento;

  public ClientePF(String nome, String email, String cpf, int anoNascimento) {
    super(nome, email);

    this.cpf = cpf;
    this.anoNascimento = anoNascimento;
  }

  @Override
  public String getDocumento() {
    return this.cpf;
  }

  public int getAnoNascimento() {
    return this.anoNascimento;
  }

  public String emailAniversario() {
    String corpo = "";

    corpo += "Destinatario:" + getEmail();
    corpo += "\nParabéns " + nome + ", pelo seu aniversário!!!";

    return corpo;

  }

  @Override
  public String metodoGenerico() {
    return super.metodoGenerico();
  }

  public String toString() {
    return super.toString() + " CPF:" + cpf + " nascimento:" + anoNascimento;
  }
}
