package banco.modelos;

public class ContaPoupanca extends ContaCorrente {
    
    private double txRendimento;
    
    //métodos => ações
    public ContaPoupanca(String numero, String agencia, ClientePF dono, double saldo, double txRendimento){
        super(numero, agencia, dono, saldo);

        this.txRendimento = txRendimento;
    }

    public ContaPoupanca(String numero, String agencia, ClientePF dono){
        this(numero,agencia,dono,0.0,0.1);
    }
    
    public void render(){
        this.saldo += this.saldo * this.txRendimento/100;
    }

    public double getTxRendimento(){
        return this.txRendimento;
    }

    public void setTxRendimento(double txRendimento){
        this.txRendimento =txRendimento;
    }

    
    public String toString(){
        return super.toString()+" txRendimento: "+this.txRendimento;
    }

}
