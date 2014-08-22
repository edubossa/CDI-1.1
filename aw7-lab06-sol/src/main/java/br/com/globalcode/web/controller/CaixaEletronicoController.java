package br.com.globalcode.web.controller;

import br.com.globalcode.model.caixa.CaixaEletronico;
import java.math.BigDecimal;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named("CaixaController")
@RequestScoped
public class CaixaEletronicoController {

    @Inject
    private CaixaEletronico caixa;
    
    private BigDecimal valor;
    
    public void sacar() {
        caixa.sacar(valor);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Saque de " + valor + " efetuado com sucesso"));
    }
    
    public void depositar() {
        caixa.depositar(valor);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Deposito de " + valor + " efetuado com sucesso"));        
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    
    
}
