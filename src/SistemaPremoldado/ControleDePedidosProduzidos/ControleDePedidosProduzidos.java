package SistemaPremoldado.ControleDePedidosProduzidos;

import SistemaPremoldado.EstruturaDeDados.Lista;

public class ControleDePedidosProduzidos {

    private Lista<PedidoItensProduzido> listaDePedidosProduzidos;

    public ControleDePedidosProduzidos() {
        this.listaDePedidosProduzidos = new Lista<>();
    }

    public void proximoDaLista() {
        if (listaDePedidosProduzidos.retornarTamanho() == 0) {
            throw new IllegalStateException(
                "Não existem pedidos na lista."
            );
        }

        PedidoItensProduzido primeiro = (PedidoItensProduzido) listaDePedidosProduzidos.procurarData(0);

        listaDePedidosProduzidos.removeData(0);
        listaDePedidosProduzidos.addData(primeiro);
    }

    public void removerDaLista() {
        if (listaDePedidosProduzidos.retornarTamanho() == 0) {
            throw new IllegalStateException(
                "Não existem pedidos para remover."
            );
        }

        listaDePedidosProduzidos.removeData(0);
    }

    public void adicionarNovoItemPedidoProduzido(PedidoItensProduzido pedidoItensProduzido) {

        if (pedidoItensProduzido == null) {
            throw new IllegalArgumentException(
                "O pedido não pode ser nulo."
            );
        }

        listaDePedidosProduzidos.addData(pedidoItensProduzido);
    }
}