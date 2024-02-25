package banco;

import  banco.modelos.ClientePF;
import  banco.modelos.ClientePJ;

public class AppTeste {
    

    public static void main(String[] args) {
        
        ClientePF clientpf = new ClientePF("Chico","chico@teste.com","001.001.001-11",2001);
        System.out.println(clientpf.toString());
        
        System.out.println(clientpf.emailAniversario());

        System.out.println(clientpf.metodoGenerico());
        System.out.println();

        ClientePJ clientepj = new ClientePJ("Empresa Teste","empresa@teste.com","0001.0000/000-1", 10);
        System.out.println(clientepj.toString());
        System.out.println(clientepj.metodoGenerico());
        


    }


}
