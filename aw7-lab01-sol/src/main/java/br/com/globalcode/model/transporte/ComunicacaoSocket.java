package br.com.globalcode.model.transporte;

import javax.enterprise.context.Dependent;


@Dependent
public class ComunicacaoSocket implements Comunicacao{

    @Override
    public void comunicarComBanco(String dados) {
        System.out.println("Comunicando com o banco via Socket na porta 1234");
    }
    
}
