
package SistemaPremoldado.ControleDePedidosProduzidos;

import SistemaPremoldado.EstruturaDeDados.Lista;
import SistemaPremoldado.GestaoDePedidos.Pedido;

public class PedidoItensProduzido {

    private int id;
    private Lista<ItemProduzido> itensProduzidos;
    private Pedido pedido;

    public PedidoItensProduzido(int id, Pedido pedido) {
        this.id = id;
        this.pedido = pedido;
        this.itensProduzidos = new Lista<>();
    }

    public void adicionarItem() {

    }

    public void removerItem() {

    }

    public void venderItem() {

    }

    public void venderPedidoItensProduzido() {

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
