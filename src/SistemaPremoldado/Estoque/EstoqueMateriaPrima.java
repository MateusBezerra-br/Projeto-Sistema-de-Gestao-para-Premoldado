package SistemaPremoldado.Estoque;

import SistemaPremoldado.ControleDeProducao.LoteDeProducao;
import SistemaPremoldado.EstruturaDeDados.Lista;

public class EstoqueMateriaPrima {
    private Lista<ItemEstoque> materiaisEstoque;
    private static EstoqueMateriaPrima instancia;

    private EstoqueMateriaPrima() {
        this.materiaisEstoque = new Lista<>();
    }

    public static EstoqueMateriaPrima getInstancia() {
        if (instancia == null) {
            instancia = new EstoqueMateriaPrima();
        }

        return instancia;
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

    public String verificarMateriaPrima(LoteDeProducao lote) {

        if (lote.getProduto().getTracoProduto() == null) {
            return "- O produto não possui traço cadastrado.\n";
        }

        String problemas = "";

        for (int i = 0; i < lote.getProduto().getTracoProduto()
                .getItensReceita().retornarTamanho(); i++) {

            ItemTraco itemTraco = (ItemTraco) lote.getProduto()
                    .getTracoProduto().getItensReceita().procurarData(i);

            ItemEstoque itemEstoque = null;

            for (int j = 0; j < EstoqueMateriaPrima.getInstancia()
                    .getMateriaisEstoque().retornarTamanho(); j++) {

                ItemEstoque atual = (ItemEstoque) EstoqueMateriaPrima.getInstancia()
                        .getMateriaisEstoque().procurarData(j);

                if (atual.getMateriaPrima().getNome().equals(itemTraco.getNome())) {
                    itemEstoque = atual;
                    break;
                }
            }

            if (itemEstoque == null) {
                problemas += "- Matéria-prima não cadastrada: "
                        + itemTraco.getNome() + ".\n";
                continue;
            }

            double quantidadeNecessaria =
                    itemTraco.getQuantidade() * lote.getQuantidade();

            if (itemEstoque.getQuantidadeDisponivel() < quantidadeNecessaria) {
                problemas += "- Matéria-prima insuficiente: "
                        + itemTraco.getNome()
                        + ". Necessário: " + quantidadeNecessaria
                        + "; disponível: " + itemEstoque.getQuantidadeDisponivel()
                        + ".\n";
            }
        }

        return problemas;
    }

    public void darBaixaMateriaPrima(LoteDeProducao lote) {

        for (int i = 0; i < lote.getProduto().getTracoProduto()
                .getItensReceita().retornarTamanho(); i++) {

            ItemTraco itemTraco = (ItemTraco) lote.getProduto()
                    .getTracoProduto().getItensReceita().procurarData(i);

            for (int j = 0; j < EstoqueMateriaPrima.getInstancia()
                    .getMateriaisEstoque().retornarTamanho(); j++) {

                ItemEstoque itemEstoque = (ItemEstoque) EstoqueMateriaPrima.getInstancia()
                        .getMateriaisEstoque().procurarData(j);

                if (itemEstoque.getMateriaPrima().getNome().equals(itemTraco.getNome())) {

                    double quantidade =
                            itemTraco.getQuantidade() * lote.getQuantidade();

                    EstoqueMateriaPrima.getInstancia().darBaixa(
                            itemEstoque.getMateriaPrima(),
                            quantidade
                    );

                    break;
                }
            }
        }
    }
}

