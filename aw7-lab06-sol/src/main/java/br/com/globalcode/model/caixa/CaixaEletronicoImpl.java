package br.com.globalcode.model.caixa;

import br.com.globalcode.eventos.Deposito;
import br.com.globalcode.eventos.EventoCaixaEletronico;
import br.com.globalcode.eventos.Saque;
import br.com.globalcode.model.transporte.Comunicacao;
import java.math.BigDecimal;
import javax.enterprise.context.Dependent;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@Dependent
public class CaixaEletronicoImpl implements CaixaEletronico{
    private Comunicacao transporte;
    
    @Inject @Saque
    private Event<EventoCaixaEletronico> saque;

    @Inject @Deposito
    private Event<EventoCaixaEletronico> deposito;
    
    @Override
    @Inject
    public void setTransporte(Comunicacao transporte){
        this.transporte = transporte;
    }
    

    @Override
    public void depositar(BigDecimal bd) {
        transporte.comunicarComBanco(bd.toString());
        deposito.fire(new EventoCaixaEletronico(this, bd));
    }

    @Override
    public void sacar(BigDecimal bd) {
        transporte.comunicarComBanco(bd.toString());
        saque.fire(new EventoCaixaEletronico(this, bd));
    }
    
}
