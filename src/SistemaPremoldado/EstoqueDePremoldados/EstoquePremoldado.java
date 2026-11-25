package SistemaPremoldado.EstoqueDePremoldados;

import SistemaPremoldado.EstruturaDeDados.lista;

public class EstoquePremoldado {

    private lista<ItemPremoldado> itensPremoldados;

    public void descontarEstoque(ItemPremoldado item, int quantidade) {

        if (quantidade <= 0) {
            return;
        }

        if (item.getQuantidade() >= quantidade) {
            item.setQuantidade(item.getQuantidade() - quantidade);
        }
    }

    public void reporEstoque(ItemPremoldado item, int quantidade) {

        if (quantidade <= 0) {
            return;
        }

        item.setQuantidade(item.getQuantidade() + quantidade);
    }
}