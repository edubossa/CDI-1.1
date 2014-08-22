package br.com.globalcode.dao;

import br.com.globalcode.model.Cliente;
import br.com.globalcode.model.Pedido;
import java.util.Collection;

public interface PedidoDAO {
    void delete(Pedido pedido) throws DAOException;

    Collection<Pedido> findAll() throws DAOException;

    Collection<Pedido> findByCliente(Cliente cliente) throws DAOException;

    Collection<Pedido> findByPeriodo(String strDataInicio, String strDataFinal) throws DAOException;

    Pedido findByPrimaryKey(Long numero) throws DAOException;

    void save(Pedido pedido) throws DAOException;
    
}
