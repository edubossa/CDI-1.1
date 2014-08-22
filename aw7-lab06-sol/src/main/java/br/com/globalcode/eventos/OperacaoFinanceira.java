package br.com.globalcode.eventos;

import java.io.Serializable;
import java.math.BigDecimal;

public class OperacaoFinanceira implements Serializable {

    private final TipoOperacao tipo;
    private final BigDecimal valor;

    public OperacaoFinanceira(TipoOperacao tipo, BigDecimal valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public TipoOperacao getTipo() {
        return tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }
    
    @Override
    public String toString() {
        return tipo + " : " + valor;
    }
}
