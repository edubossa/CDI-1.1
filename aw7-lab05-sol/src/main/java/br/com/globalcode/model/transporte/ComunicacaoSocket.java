package br.com.globalcode.model.transporte;


@Socket
public class ComunicacaoSocket implements Comunicacao{

    @Override
    public void comunicarComBanco(String dados) {
        System.out.println("Comunicando com o banco via Socket na porta 1234");
    }
    
}
