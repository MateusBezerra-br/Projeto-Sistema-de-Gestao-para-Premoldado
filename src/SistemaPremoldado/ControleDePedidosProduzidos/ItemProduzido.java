
package SistemaPremoldado.ControleDePedidosProduzidos;

import SistemaPremoldado.ControleDeVendas.ItemVenda;
import SistemaPremoldado.EstoqueDePremoldados.ItemPremoldado;
import SistemaPremoldado.GestaoDePedidos.Produtos.Produto;
import SistemaPremoldado.ControleDeCura.LoteEmCura;

public class ItemProduzido {

    private int id;
    private int quantidade;
    private String dataProduzido;

    private ItemVenda itemVenda;
    private ItemPremoldado itemPremoldado;
    private Produto produto;
    private LoteEmCura loteEmCura;
    private PedidoItensProduzido pedidoItensProduzido;

    public ItemProduzido(int id, int quantidade, String dataProduzido,
                         ItemVenda itemVenda,
                         ItemPremoldado itemPremoldado,
                         Produto produto,
                         LoteEmCura loteEmCura,
                         PedidoItensProduzido pedidoItensProduzido) {

        this.id = id;
        this.quantidade = quantidade;
        this.dataProduzido = dataProduzido;
        this.itemVenda = itemVenda;
        this.itemPremoldado = itemPremoldado;
        this.produto = produto;
        this.loteEmCura = loteEmCura;
        this.pedidoItensProduzido = pedidoItensProduzido;
    }

    public void atualizarQuantProduzida() {

    }

    public int getId() {
        return id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getDataProduzido() {
        return dataProduzido;
    }

    public ItemVenda getItemVenda() {
        return itemVenda;
    }

    public ItemPremoldado getItemPremoldado() {
        return itemPremoldado;
    }

    public Produto getProduto() {
        return produto;
    }

    public LoteEmCura getLoteEmCura() {
        return loteEmCura;
    }

    public PedidoItensProduzido getPedidoItensProduzido() {
        return pedidoItensProduzido;
    }
}
