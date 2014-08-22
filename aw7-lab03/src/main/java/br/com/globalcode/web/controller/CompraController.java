package br.com.globalcode.web.controller;

import br.com.globalcode.dao.BancoDAO;
import br.com.globalcode.dao.BandeiraCartaoCreditoDAO;
import br.com.globalcode.dao.PedidoDAO;
import br.com.globalcode.dao.ProdutoDAO;
import br.com.globalcode.dao.collection.BancoCollection;
import br.com.globalcode.dao.collection.BandeiraCartaoCreditoCollection;
import br.com.globalcode.model.Banco;
import br.com.globalcode.model.BandeiraCartaoCredito;
import br.com.globalcode.model.CarrinhoCompras;
import br.com.globalcode.model.Cliente;
import br.com.globalcode.model.ItemCompra;
import br.com.globalcode.model.Pagamento;
import br.com.globalcode.model.PagamentoBoleto;
import br.com.globalcode.model.PagamentoCartaoCredito;
import br.com.globalcode.model.Pedido;
import br.com.globalcode.model.Produto;
import br.com.globalcodeweb.util.JSFHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

@Named("compraController")
@ConversationScoped
public class CompraController implements Serializable{

    private final static Logger logger = Logger.getLogger(CompraController.class);
    final static String CARTAO_CREDITO = "cartao";
    final static String BOLETO = "boleto";
    private Collection<Produto> produtos;
    private CarrinhoCompras carrinho;
    private String formaPagamentoSelecionada = "cartao";
    private Cliente cliente;
    private boolean boleto = false;
    private List formasPagamento;
    private Pagamento pagamento = new PagamentoCartaoCredito();
    @Inject
    transient PedidoDAO pedidoDAO;
    @Inject
    transient ProdutoDAO produtoDAO;

    public PedidoDAO getPedidoDAO() {
        return pedidoDAO;
    }

    public void setPedidoDAO(PedidoDAO pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }

    public ProdutoDAO getProdutoDAO() {
        return produtoDAO;
    }

    public void setProdutoDAO(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    
    
    public CompraController() {
        pagamento = new PagamentoCartaoCredito();
        HttpSession session =
                (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        cliente = (Cliente) session.getAttribute("usuario");
        if (cliente == null) {
            cliente = new Cliente();
        }
    }

    public void setProdutos(Collection<Produto> produtos) {
        this.produtos = produtos;
    }

    public Collection<Produto> getProdutos() {
        try {
            if (produtos == null) {
                produtos = produtoDAO.findAll();
            }
        } catch (Exception e) {
            String msg = "Erro ao carregar produtos";
            logger.error(msg, e);
            JSFHelper.addErrorMessage(msg);
            return null;
        }
        return produtos;
    }

    public void setCarrinho(CarrinhoCompras carrinho) {
        this.carrinho = carrinho;
    }

    public CarrinhoCompras getCarrinho() {
        return carrinho;
    }

    public void setFormaPagamentoSelecionada(String formaPagamento) {
        this.formaPagamentoSelecionada = formaPagamento;
        if (BOLETO.equals(formaPagamento)) {
            boleto = true;
        } else {
            boleto = false;
        }
    }

    public List getBancos() {
        BancoDAO dao = BancoCollection.getInstance();
        List bancos = dao.getAll();
        return bancos;
    }

    public void setBoleto(boolean boleto) {
        this.boleto = boleto;
    }

    public boolean isBoleto() {
        return boleto;
    }

    public void setFormasPagamento(List formasPagamento) {
        this.formasPagamento = formasPagamento;
    }

    public List getFormasPagamento() {
        formasPagamento = new ArrayList();
        formasPagamento.add(new SelectItem(BOLETO, BOLETO));
        formasPagamento.add(new SelectItem(CARTAO_CREDITO, CARTAO_CREDITO));
        return formasPagamento;
    }

    public String getFormaPagamentoSelecionada() {
        return formaPagamentoSelecionada;
    }

    public List getBandeiras() {
        BandeiraCartaoCreditoDAO dao = BandeiraCartaoCreditoCollection.getInstance();
        List<BandeiraCartaoCredito> bandeiras = dao.getAll();
        return bandeiras;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void atualizarFormaPagamento(ValueChangeEvent valueChangeEvent) {
        logger.info("[ValueChangeListener] - pagamento=" + pagamento);
        if (valueChangeEvent.getNewValue().equals("boleto")) {
            this.setBoleto(true);
            pagamento = new PagamentoBoleto(pagamento);
        } else {
            this.setBoleto(false);
            pagamento = new PagamentoCartaoCredito(pagamento);
        }
        FacesContext.getCurrentInstance().renderResponse();
    }

    public String adicionarCarrinho(Produto produto) {
        logger.info("Adicionar produto no carrinho");
        logger.info("Produto selecionado pelo cliente " + produto);
        ItemCompra item = new ItemCompra(produto, 1, 0);
        //caso não exista um carrinho, cria-se um e adiciona-se o item desejado
        if (carrinho == null) {
            carrinho = new CarrinhoCompras(item);
        } else {
            carrinho.addItem(item);
        }
        return "carrinhoCompras";
    }

    public String enviarPedido() {
        logger.info("[CatalogoProdutosMB - enviarPedido]" + pagamento);

        try {

            pagamento.setDataPagamento(new Date());
            pagamento.setValor(carrinho.getPrecoTotal());
            if (pagamento instanceof PagamentoCartaoCredito) {
                ((PagamentoCartaoCredito) pagamento).setBandeiraCartaoCredito(new BandeiraCartaoCredito(new Integer(1), "Visa"));
            } else if (pagamento instanceof PagamentoBoleto) {
                ((PagamentoBoleto) pagamento).setBanco(new Banco(new Integer(1), "Banco do Brasil"));
            }

            //Criacao do pedido
            String clienteBrowser = "";
            String clienteIP = "";
            String status = "";

            Pedido pedido =
                    new Pedido(cliente, clienteBrowser, clienteIP, new Date(),
                    carrinho.getItens(), pagamento, status);
            logger.info("[CatalogoProdutosManagedBean ] Enviando pedido para o banco de dados " + pedido);
            pedidoDAO.save(pedido);

        } catch (Exception ex) {
            ex.printStackTrace();
            JSFHelper.addErrorMessage("Erro ao salvar os dados do pedido no envio do pedido");
            return null;
        }
        return "pedidoEnviado";
    }
}
