package SistemaPremoldado.ControleDePedidosProduzidos;

import SistemaPremoldado.EstruturaDeDados.Lista;
import SistemaPremoldado.GestaoDePedidos.Pedido;
import SistemaPremoldado.ControleDeVendas.ControleVendas;
import SistemaPremoldado.ControleDeVendas.Venda;
import SistemaPremoldado.EstoqueDePremoldados.EstoquePremoldado;

public class PedidoItensProduzido {

    private int id;
    private Lista<ItemProduzido> itensProduzidos;
    private Pedido pedido;

    public PedidoItensProduzido(int id, Pedido pedido) {

        if (id <= 0 || pedido == null) {
            throw new IllegalArgumentException(
                "ID inválido ou pedido não informado."
            );
        }

        this.id = id;
        this.pedido = pedido;
        this.itensProduzidos = new Lista<>();
    }

    public void adicionarItem(ItemProduzido item) {

        if (item == null) {
            throw new IllegalArgumentException(
                "O item produzido não pode ser nulo."
            );
        }

        if (item.getPedidoItensProduzido() != this) {
            throw new IllegalArgumentException(
                "O item não pertence a este pedido."
            );
        }

        itensProduzidos.addData(item);
    }

    public void removerItem(ItemProduzido item) {

        if (item == null) {
            throw new IllegalArgumentException(
                "O item não pode ser nulo."
            );
        }

        for (int i = 0; i < itensProduzidos.retornarTamanho(); i++) {

            ItemProduzido atual =
                (ItemProduzido) itensProduzidos.procurarData(i);

            if (atual == item) {

                if (atual.isVendido()) {
                    throw new IllegalStateException(
                        "Não é possível remover um item já vendido."
                    );
                }

                itensProduzidos.removeData(i);
                return;
            }
        }

        throw new IllegalArgumentException(
            "Item produzido não encontrado."
        );
    }

    public Venda venderItem(ItemProduzido item, ControleVendas controle, EstoquePremoldado estoque, String dataVenda) {

        if (controle == null || estoque == null) {
            throw new IllegalArgumentException(
                "Controle de vendas ou estoque não informado."
            );
        }

        if (item == null || !itemPertenceAoPedido(item)) {
            throw new IllegalArgumentException(
                "Item inválido ou não pertence a este pedido."
            );
        }

        Lista<ItemProduzido> selecionados = new Lista<>();
        selecionados.addData(item);

        return controle.criarVenda(selecionados, estoque, dataVenda
        );
    }

    public Venda venderPedidoItensProduzido(Lista<ItemProduzido> selecionados, ControleVendas controle, EstoquePremoldado estoque, String dataVenda) {

        if (selecionados == null ||
            selecionados.retornarTamanho() == 0) {

            throw new IllegalArgumentException(
                "Selecione pelo menos um item produzido."
            );
        }

        if (controle == null || estoque == null) {
            throw new IllegalArgumentException(
                "Controle de vendas ou estoque não informado."
            );
        }

        for (int i = 0; i < selecionados.retornarTamanho(); i++) {

            ItemProduzido item =
                (ItemProduzido) selecionados.procurarData(i);

            if (!itemPertenceAoPedido(item)) {
                throw new IllegalArgumentException(
                    "Um dos itens não pertence a este pedido."
                );
            }
        }

        return controle.criarVenda(
            selecionados,
            estoque,
            dataVenda
        );
    }

    private boolean itemPertenceAoPedido(ItemProduzido item) {

        if (item == null) {
            return false;
        }

        for (int i = 0; i < itensProduzidos.retornarTamanho(); i++) {

            ItemProduzido atual =
                (ItemProduzido) itensProduzidos.procurarData(i);

            if (atual == item) {
                return true;
            }
        }

        return false;
    }

    public int getId() {
        return id;
    }

    public Lista<ItemProduzido> getItensProduzidos() {
        return itensProduzidos;
    }

    public Pedido getPedido() {
        return pedido;
    }
}