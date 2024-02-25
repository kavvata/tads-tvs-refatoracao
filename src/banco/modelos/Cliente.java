package banco.modelos;
public abstract class Cliente {
    
    protected String nome;
    protected String email;

    
    public Cliente(String nome, String email){
        this.nome = nome;
        this.email = email;
    }

    public abstract String getDocumento();

    public String getEmail() {
        return email;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String toString(){
        return "Nome: "+nome+" e-mail:"+email;
    }

    public String metodoGenerico(){
        return "Isso é um método...";
    }

}
