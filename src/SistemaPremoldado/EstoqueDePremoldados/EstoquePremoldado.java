package SistemaPremoldado.EstoqueDePremoldados;

import SistemaPremoldado.EstruturaDeDados.Lista;
import SistemaPremoldado.GestaoDePedidos.Produtos.Produto;
import SistemaPremoldado.ControleDeVendas.ItemVenda;
import SistemaPremoldado.ControleDePedidosProduzidos.ItemProduzido;
import SistemaPremoldado.ControleDePedidosProduzidos.PedidoItensProduzido;

public class EstoquePremoldado {

    private Lista<ItemPremoldado> itensPremoldados;
    private Lista<Produto> produtos;
    private Lista<ItemVenda> itensVenda;

    private static int proximoIdItemProduzido = 1;

    public EstoquePremoldado() {
        this.itensPremoldados = new Lista<>();
        this.produtos = new Lista<>();
        this.itensVenda = new Lista<>();
    }

    public void adicionarItem(ItemPremoldado item) {
        if (item == null) {
            throw new IllegalArgumentException("O item não pode ser nulo.");
        }

        itensPremoldados.addData(item);
    }

    public void adicionarProduto(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("O produto não pode ser nulo.");
        }

        produtos.addData(produto);
    }

    public void adicionarItemVenda(ItemVenda itemVenda) {
        if (itemVenda == null) {
            throw new IllegalArgumentException("O item de venda não pode ser nulo.");
        }

        itensVenda.addData(itemVenda);
    }

    public ItemPremoldado consultarItem(int id) {
        for (int i = 0; i < itensPremoldados.retornarTamanho(); i++) {
            ItemPremoldado item =
                (ItemPremoldado) itensPremoldados.procurarData(i);

            if (item.getId() == id) {
                return item;
            }
        }

        return null;
    }

    public void descontarEstoque(int id, int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException(
                "A quantidade deve ser maior que zero."
            );
        }

        ItemPremoldado item = consultarItem(id);

        if (item == null) {
            throw new IllegalArgumentException(
                "Item não encontrado no estoque."
            );
        }

        if (item.getQuantidade() < quantidade) {
            throw new IllegalArgumentException(
                "Quantidade insuficiente no estoque."
            );
        }

        item.atualizarQuant(item.getQuantidade() - quantidade);
    }

    public void reporEstoque(int id, int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException(
                "A quantidade deve ser maior que zero."
            );
        }

        ItemPremoldado item = consultarItem(id);

        if (item == null) {
            throw new IllegalArgumentException(
                "Item não encontrado no estoque."
            );
        }

        item.atualizarQuant(item.getQuantidade() + quantidade);
    }

    
    public void destinarAoPedido(
            int idItem,
            int quantidade,
            Produto produto,
            PedidoItensProduzido pedido,
            String dataProduzido) {

        if (quantidade <= 0) {
            throw new IllegalArgumentException(
                "A quantidade deve ser maior que zero."
            );
        }

        if (produto == null || pedido == null || dataProduzido == null) {
            throw new IllegalArgumentException(
                "Produto, pedido e data de produção são obrigatórios."
            );
        }

        ItemPremoldado item = consultarItem(idItem);

        if (item == null) {
            throw new IllegalArgumentException(
                "Item não encontrado no estoque."
            );
        }

        if (item.getQuantidade() < quantidade) {
            throw new IllegalArgumentException(
                "Quantidade insuficiente no estoque."
            );
        }

        if (!produtoEstaCadastrado(produto)) {
            throw new IllegalArgumentException(
                "Produto não cadastrado no estoque."
            );
        }

        
        for (int i = 0; i < quantidade; i++) {

            ItemProduzido produzido = new ItemProduzido(
                proximoIdItemProduzido++,
                1,
                dataProduzido,
                item,
                produto,
                null,
                pedido
            );

            pedido.adicionarItem(produzido);
        }

        
        descontarEstoque(idItem, quantidade);
    }

    private boolean produtoEstaCadastrado(Produto produto) {
        for (int i = 0; i < produtos.retornarTamanho(); i++) {
            Produto atual = (Produto) produtos.procurarData(i);

            if (atual == produto) {
                return true;
            }
        }

        return false;
    }

    public Lista<ItemPremoldado> getItensPremoldados() {
        return itensPremoldados;
    }

    public Lista<Produto> getProdutos() {
        return produtos;
    }

    public Lista<ItemVenda> getItensVenda() {
        return itensVenda;
    }
}