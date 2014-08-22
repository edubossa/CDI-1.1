package br.com.globalcode.dao;

import br.com.globalcode.model.Pagamento;
import java.util.Collection;

public interface PagamentoDAO {
    void delete(Pagamento pagamento) throws DAOException;

    Collection<Pagamento> findAll() throws DAOException;

    Pagamento findByPrimaryKey(Integer id) throws DAOException;

    void save(Pagamento pagamento) throws DAOException;
    
}
