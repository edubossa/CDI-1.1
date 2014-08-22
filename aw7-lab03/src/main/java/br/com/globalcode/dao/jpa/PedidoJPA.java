package br.com.globalcode.dao.jpa;

import br.com.globalcode.dao.DAOException;
import br.com.globalcode.dao.PedidoDAO;
import br.com.globalcode.model.Cliente;
import br.com.globalcode.model.Pedido;
import br.com.globalcode.dao.util.FormatHelper;
import java.util.Collection;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Named("pedidoDAO")
@Dependent
public class PedidoJPA extends DaoSupport<Pedido, Long>
        implements PedidoDAO {

    @Override
    public void save(Pedido pedido) {
        super.save(pedido);
    }

    @Override
    public void delete(Pedido pedido) {
        super.delete(pedido);
    }
    
    
    @Override
    public Collection<Pedido> findAll() throws DAOException {
        String jpql = "select p from Pedido p left join fetch p.cliente left join fetch p.pagamento";
        return findByQuery(jpql);
    }

    @Override
    public Collection<Pedido> findByCliente(Cliente cliente) throws DAOException {
        String jpql = "select p from Pedido p where p.cliente = :cliente";
        Map params = new HashMap();
        params.put("cliente", cliente);
        return findByQuery(jpql, params);
    }

    @Override
    public Collection<Pedido> findByPeriodo(String strDataInicio, String strDataFinal) throws DAOException {
        String jpql = "select p from Pedido p where ";
        Map params = new HashMap();
        boolean dataInicio = false;
        try {
            if (strDataInicio != null && !(strDataInicio.equals(""))) {
                Date dataInicial = FormatHelper.getInstance().parseSimpleDate(strDataInicio + " 00:00");
                jpql += " data >= :dataInicio";
                params.put("dataInicio", dataInicial);
                dataInicio = true;
            }
            if (strDataFinal != null && !(strDataFinal.equals(""))) {
                Date dataFinal = FormatHelper.getInstance().parseSimpleDate(strDataFinal + " 23:59");
                if (dataInicio) {
                    jpql += " and ";
                }
                jpql += " data <= :dataFinal";
                params.put("dataFinal", dataFinal);
            }
        } catch (ParseException pe) {
            throw new DAOException("Formato de data invalido " + strDataInicio + " ou " + strDataFinal, pe);
        }
        return findByQuery(jpql,params);
    }

}

