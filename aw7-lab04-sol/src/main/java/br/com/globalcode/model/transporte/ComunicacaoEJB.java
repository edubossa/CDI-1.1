package br.com.globalcode.model.transporte;

@EJBRemoto
public class ComunicacaoEJB implements Comunicacao{

    @Override
    public void comunicarComBanco(String dados) {
        System.out.println("Comunicando com o banco via EJB");
    }
    
}
