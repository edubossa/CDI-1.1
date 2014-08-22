package br.com.globalcode.dao;

import br.com.globalcode.model.Categoria;
import java.util.Collection;

public interface CategoriaDAO {
    void delete(Categoria categoria) throws DAOException;

    Collection<Categoria> findAll() throws DAOException;

    Categoria findByPrimaryKey(Integer id) throws DAOException;

    void save(Categoria categoria) throws DAOException;
    
}
