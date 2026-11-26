package SistemaPremoldado.Estoque;

import SistemaPremoldado.EstruturaDeDados.Lista;

public class EstoqueMateriaPrima {
    private Lista<ItemEstoque> materiaisEstoque;

    public EstoqueMateriaPrima() {
        this.materiaisEstoque = new Lista<>();
    }

    public Lista<ItemEstoque> getMateriaisEstoque() {
        return materiaisEstoque;
    }

    public ItemEstoque verificarDisponibilidade(MateriaPrima materiaPrima) {
        for (int i = 0; i < materiaisEstoque.retornarTamanho(); i++) {
            ItemEstoque item = (ItemEstoque) materiaisEstoque.procurarData(i);
            if (item.getMateriaPrima().getNome().equals(materiaPrima.getNome())) {
                return item;
            }
        }

        return null;
    }

    public boolean darBaixa(MateriaPrima materiaPrima, double quantidade) {
        ItemEstoque item = verificarDisponibilidade(materiaPrima);

        if (item == null || item.getQuantidadeDisponivel() < quantidade) {
            return false;
        }

        double novaQuantidade = item.getQuantidadeDisponivel() - quantidade;
        item.atualizaQuantidade(novaQuantidade);
        return true;
    }

    public boolean repor(MateriaPrima materiaPrima, double quantidade) {
        ItemEstoque item = verificarDisponibilidade(materiaPrima);
        if (item == null || quantidade <= 0) {
            return false;
        }
        double novaQuantidade = item.getQuantidadeDisponivel() + quantidade;
        item.atualizaQuantidade(novaQuantidade);
        return true;
    }
}

