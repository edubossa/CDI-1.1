package br.com.globalcode.dao;
import br.com.globalcode.model.Categoria;
import br.com.globalcode.model.Produto;
import java.util.Collection;

public interface ProdutoDAO {
    void delete(Produto produto) throws DAOException;

    Collection<Produto> findAll() throws DAOException;

    Collection<Produto> findByCategoria(Categoria categoria) throws DAOException;

    Collection<Produto> findByMarca(String marca) throws DAOException;

    Produto findByPrimaryKey(Integer id) throws DAOException;

    Collection<Produto> findProdutos(String nome, Integer idCategoria, String marca) throws DAOException;

    void save(Produto produto) throws DAOException;
    
}
