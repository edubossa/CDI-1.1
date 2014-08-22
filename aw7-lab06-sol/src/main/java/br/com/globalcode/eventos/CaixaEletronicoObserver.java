package br.com.globalcode.eventos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;

@SessionScoped
public class CaixaEletronicoObserver implements Serializable {

    private List<OperacaoFinanceira> historico = new ArrayList<>();
    
    public void saqueEfetuado(@Observes @Saque EventoCaixaEletronico caixa) {
        historico.add(new OperacaoFinanceira(TipoOperacao.SAQUE, caixa.getValor()));
        System.out.println("Adicionando nova operacao de saque no historico");
        listarHistorico();
    }
    
    public void depositoEfetuado(@Observes @Deposito EventoCaixaEletronico caixa) {
        historico.add(new OperacaoFinanceira(TipoOperacao.DEPOSITO, caixa.getValor()));
        System.out.println("Adicionando nova operacao de deposito no historico");
        listarHistorico();
    }
    
    public void listarHistorico() {
        for(OperacaoFinanceira op: historico) {
            System.out.println(op);
        }
    }
}
