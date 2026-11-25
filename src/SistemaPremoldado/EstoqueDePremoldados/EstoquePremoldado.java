
package SistemaPremoldado.EstoqueDePremoldados;

import java.util.ArrayList;
import java.util.List;

public class EstoquePremoldado {

    private List<ItemPremoldado> itensPremoldados;

    public EstoquePremoldado() {
        this.itensPremoldados = new ArrayList<>();
    }

    public void adicionarItem(ItemPremoldado item) {

        if (item == null) {
            throw new IllegalArgumentException("O item não pode ser nulo.");
        }

        if (consultarItem(item.getId()) != null) {
            throw new IllegalArgumentException("Já existe um item com esse ID.");
        }

        itensPremoldados.add(item);
    }

    public ItemPremoldado consultarItem(int id) {

        for (ItemPremoldado item : itensPremoldados) {
            if (item.getId() == id) {
                return item;
            }
        }

        return null;
    }

    public void descontarEstoque(ItemPremoldado item, int quantidade) {

        if (item == null || quantidade <= 0) {
            throw new IllegalArgumentException("Item ou quantidade inválida.");
        }

        if (!itensPremoldados.contains(item)) {
            throw new IllegalArgumentException("Item não cadastrado neste estoque.");
        }

        if (item.getQuantidade() < quantidade) {
            throw new IllegalArgumentException("Estoque insuficiente.");
        }

        item.setQuantidade(item.getQuantidade() - quantidade);
    }

    public void reporEstoque(ItemPremoldado item, int quantidade) {

        if (item == null || quantidade <= 0) {
            throw new IllegalArgumentException("Item ou quantidade inválida.");
        }

        if (!itensPremoldados.contains(item)) {
            throw new IllegalArgumentException("Item não cadastrado neste estoque.");
        }

        item.setQuantidade(item.getQuantidade() + quantidade);
    }

    public List<ItemPremoldado> getItensPremoldados() {
        return new ArrayList<>(itensPremoldados);
    }
}
