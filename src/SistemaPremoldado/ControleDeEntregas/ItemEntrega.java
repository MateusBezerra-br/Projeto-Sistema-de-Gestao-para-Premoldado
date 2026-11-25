
package SistemaPremoldado.ControleDeEntregas;

import SistemaPremoldado.ControleDeVendas.ItemVenda;

public class ItemEntrega {

    private int quantidade;
    private Entrega entrega;
    private ItemVenda itemVenda;

    public ItemEntrega(int quantidade) {
        this.quantidade = quantidade;
    }

    public void atualizarQuantidade() {

    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
