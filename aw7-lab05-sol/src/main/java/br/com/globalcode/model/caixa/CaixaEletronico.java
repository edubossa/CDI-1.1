package br.com.globalcode.model.caixa;

import br.com.globalcode.model.transporte.Comunicacao;
import java.math.BigDecimal;

public interface CaixaEletronico {
    void depositar(BigDecimal bd);

    void sacar(BigDecimal bd);
    
    void setTransporte(Comunicacao transporte);
}
