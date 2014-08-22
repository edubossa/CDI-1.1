package br.com.globalcode.model.transporte;

@WebServiceSOAP
public class ComunicacaoWebService implements Comunicacao{

    @Override
    public void comunicarComBanco(String dados) {
        System.out.println("Comunicando com o banco via WebService SOAP");
    }
    
}
