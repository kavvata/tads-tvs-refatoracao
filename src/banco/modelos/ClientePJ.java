package banco.modelos;
public class ClientePJ extends Cliente {
    
    private String cnpj;
    private int numeroFuncionarios;

    public ClientePJ(String nome, String email, String cnpj, int numeroFuncionarios) {
        super(nome, email);

        this.cnpj = cnpj;
        this.numeroFuncionarios = numeroFuncionarios;
    }

    @Override
    public String getDocumento(){
        return this.cnpj;
    }

    public int getNumeroFuncionarios() {
        return numeroFuncionarios;
    }

    public void setNumeroFuncionarios(int numeroFuncionarios) {
        this.numeroFuncionarios = numeroFuncionarios;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String toString(){
        return "Nome:"+getNome()+" e-mail"+getEmail()+"CNPJ:"+cnpj+" funcionarios:"+numeroFuncionarios;
    }

}
