package SistemaPremoldado.ControleDeEntregas;

import SistemaPremoldado.ControleDeVendas.ItemVenda;

public class ItemEntrega {

    private int quantidade;
    private Entrega entrega;
    private ItemVenda itemVenda;

    public ItemEntrega(int quantidade, Entrega entrega, ItemVenda itemVenda) {
        this.quantidade = quantidade;
        this.entrega = entrega;
        this.itemVenda = itemVenda;
    }

    public void atualizarQuantidade(int novaQuantidade) {
        if (novaQuantidade <= 0) {
            throw new IllegalArgumentException(
                "A quantidade deve ser maior que zero."
            );
        }

        this.quantidade = novaQuantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public ItemVenda getItemVenda() {
        return itemVenda;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

    public void setItemVenda(ItemVenda itemVenda) {
        this.itemVenda = itemVenda;
    }
}
