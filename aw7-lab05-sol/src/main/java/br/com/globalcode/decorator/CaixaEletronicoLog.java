package br.com.globalcode.decorator;

import br.com.globalcode.model.caixa.CaixaEletronico;
import java.math.BigDecimal;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
public abstract class CaixaEletronicoLog implements CaixaEletronico{

    @Delegate @Inject
    private CaixaEletronico caixa;
    
    @Override
    public void depositar(BigDecimal bd) {
        System.out.println("Realizando deposito de R$" + bd.doubleValue());
        caixa.depositar(bd);
    }

    @Override
    public void sacar(BigDecimal bd) {
        System.out.println("Realizando saque de R$" + bd.doubleValue());
        caixa.sacar(bd);
    }
    
}
