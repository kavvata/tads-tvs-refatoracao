package banco.modelos;

public class ContaCorrenteSimples extends ContaCorrente {
    
    //métodos => ações
    public ContaCorrenteSimples(String numero, String agencia, ClientePF dono, double saldo){
        super(numero, agencia, dono,saldo);
    }

    public ContaCorrenteSimples(String numero, String agencia, ClientePF dono){
        this(numero,agencia,dono,0.0);
    }

}
