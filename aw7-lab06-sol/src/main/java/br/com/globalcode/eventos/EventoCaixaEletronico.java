package br.com.globalcode.eventos;

import br.com.globalcode.model.caixa.CaixaEletronico;
import java.math.BigDecimal;

public class EventoCaixaEletronico {

    private final CaixaEletronico caixa;
    private final BigDecimal valor;

    public EventoCaixaEletronico(CaixaEletronico caixa, BigDecimal valor) {
        this.caixa = caixa;
        this.valor = valor;
    }

    public CaixaEletronico getCaixa() {
        return caixa;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
