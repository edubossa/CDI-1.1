package br.com.globalcode.model.caixa;

import java.math.BigDecimal;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import br.com.globalcode.model.transporte.Comunicacao;

@Dependent
public class CaixaEletronicoImpl implements CaixaEletronico{
    
	private Comunicacao transporte;
    
	/*
	 * -------------------------------------
	 * OBS: caso use o @Produces na classe ComunicacaoFactory
	 * deve tirar a anotacao @EJBRemoto, pois a mesma nao sera
	 * mais necessaria.
	 * ------------------------------------- 	
	 */
	
    @Inject
    public void setTransporte(/*@EJBRemoto*/ Comunicacao transporte){
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