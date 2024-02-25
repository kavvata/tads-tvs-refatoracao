package banco.modelos;

public class ContaCorrenteEspecial extends ContaCorrente {
    
    private double limite;
    
    
    //métodos => ações
    public ContaCorrenteEspecial(String numero, String agencia, ClientePF dono, double saldo, double limite){
        super(numero, agencia, dono,saldo);
        this.limite = limite;
    }

    public ContaCorrenteEspecial(String numero, String agencia, ClientePF dono){
        this(numero,agencia,dono,0.0,0.0);
    }
    
    @Override
    public boolean sacar(double valor){
        if(valor <= saldo+limite){
            saldo -= valor;
            return true;
        }
        return false;
    }
    
    public double getLimite(){
        return this.limite;
    }

    public void setLimite(double limite){
        this.limite = limite;
    }

    public String toString(){
        return super.toString()+" limite:"+limite;
    }

}
