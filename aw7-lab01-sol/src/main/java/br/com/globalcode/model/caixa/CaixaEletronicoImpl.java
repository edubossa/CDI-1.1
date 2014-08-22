package br.com.globalcode.model.caixa;

import br.com.globalcode.model.transporte.Comunicacao;
import java.math.BigDecimal;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class CaixaEletronicoImpl implements CaixaEletronico{
    private Comunicacao transporte;
    
    @Override
    @Inject
    public void setTransporte(Comunicacao transporte){
        this.transporte = transporte;
    }
    

    @Override
    public void depositar(BigDecimal bd) {
        transporte.comunicarComBanco(bd.toString());
        System.out.println("Realizando deposito de R$" + bd.doubleValue());
    }

    @Override
    public void sacar(BigDecimal bd) {
        transporte.comunicarComBanco(bd.toString());
        System.out.println("Realizando saque de R$" + bd.doubleValue());
    }
    
}
