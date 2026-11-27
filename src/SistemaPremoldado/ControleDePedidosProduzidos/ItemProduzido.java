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

    private boolean vendido = false;

    public ItemProduzido(int id, int quantidade, String dataProduzido, ItemPremoldado itemPremoldado, Produto produto, LoteEmCura loteEmCura, PedidoItensProduzido pedidoItensProduzido) {

        if (id <= 0 || quantidade != 1) {
            throw new IllegalArgumentException(
                "ID inválido ou quantidade diferente de uma unidade."
            );
        }

        if (dataProduzido == null || produto == null) {
            throw new IllegalArgumentException(
                "Data de produção e produto são obrigatórios."
            );
        }

        this.id = id;
        this.quantidade = quantidade;
        this.dataProduzido = dataProduzido;

        this.itemPremoldado = itemPremoldado;
        this.produto = produto;
        this.loteEmCura = loteEmCura;
        this.pedidoItensProduzido = pedidoItensProduzido;

        this.itemVenda = null;
        this.vendido = false;
    }

    public void atualizarQuantProduzida() {
        this.quantidade = 1;
    }

    public void marcarComoVendido() {
        if (vendido) {
            throw new IllegalStateException(
                "Este item já foi vendido."
            );
        }

        if (itemVenda == null) {
            throw new IllegalStateException(
                "O item ainda não possui associação com uma venda."
            );
        }

        this.vendido = true;
    }

    public void setItemVenda(ItemVenda itemVenda) {
        if (itemVenda == null) {
            throw new IllegalArgumentException(
                "O item de venda não pode ser nulo."
            );
        }

        if (this.itemVenda != null) {
            throw new IllegalStateException(
                "Este item já possui um ItemVenda associado."
            );
        }

        this.itemVenda = itemVenda;
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

    public boolean isVendido() {
        return vendido;
    }
}