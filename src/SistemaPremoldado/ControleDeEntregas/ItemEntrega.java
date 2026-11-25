package SistemaPremoldado.ControleDeEntregas;

import java.util.List;
import SistemaPremoldado.ControleDeVendas.ItemVenda;

public class ItemEntrega {

    private int quantidade;
    private Entrega entrega;
    private List<ItemVenda> itensVenda;

    public ItemEntrega(int quantidade) {
        this.quantidade = quantidade;
    }

    public void atualizarQuantidade() {
        // Regra de atualização será definida posteriormente.
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}