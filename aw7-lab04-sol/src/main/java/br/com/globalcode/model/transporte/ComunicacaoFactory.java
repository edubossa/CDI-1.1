package br.com.globalcode.model.transporte;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.servlet.ServletContext;

@ApplicationScoped
public class ComunicacaoFactory {
    
    @Inject
    ServletContext ctx;
    
    @Produces
    public Comunicacao createComunicacao() {
        String classe = ctx.getInitParameter("comunicacao");
        Comunicacao comm = null;
        if(classe != null) {
            try{
                Class classComm = Class.forName(classe);
                comm = (Comunicacao) classComm.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return comm;
    }
}
