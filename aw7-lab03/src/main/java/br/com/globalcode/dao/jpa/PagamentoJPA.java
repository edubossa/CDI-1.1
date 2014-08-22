package br.com.globalcode.dao.jpa;

import br.com.globalcode.dao.PagamentoDAO;
import br.com.globalcode.model.Pagamento;
import javax.inject.Named;

@Named("pagamentoDAO")
public class PagamentoJPA extends DaoSupport<Pagamento, Integer>
        implements PagamentoDAO {

    @Override
    public void save(Pagamento pagamento) {
        super.save(pagamento);
    }

    @Override
    public void delete(Pagamento pagamento) {
        super.delete(pagamento);
    }
}
