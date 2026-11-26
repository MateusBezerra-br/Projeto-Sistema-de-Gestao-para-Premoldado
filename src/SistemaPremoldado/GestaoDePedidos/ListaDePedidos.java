package SistemaPremoldado.GestaoDePedidos;

import SistemaPremoldado.EstruturaDeDados.Lista;


public class ListaDePedidos {
    private Lista<Pedido> listaDePedidos;
    private int indiceAtual;
    private static ListaDePedidos instancia;

    private ListaDePedidos() {
        this.listaDePedidos = new Lista<>();
        this.indiceAtual = 0;
    }

    public static ListaDePedidos getInstancia() {
        if (instancia == null) {
            instancia = new ListaDePedidos();
        }

        return instancia;
    }

    public void adicionarPedido(Pedido pedido) {
        this.listaDePedidos.addData(pedido);
    }

    public void removerPedido(int index) {
        this.listaDePedidos.removeData(index);
        if (listaDePedidos.retornarTamanho() == 0 || indiceAtual >= listaDePedidos.retornarTamanho()) {
            indiceAtual = 0;
        } else if (index < indiceAtual) {
            indiceAtual--;
        }
    }

    public Pedido proximoPedido() {
        if (listaDePedidos.retornarTamanho() == 0) {
            return null;
        }
        indiceAtual = (indiceAtual + 1) % listaDePedidos.retornarTamanho();
        return (Pedido) listaDePedidos.procurarData(indiceAtual);
    }

    public Pedido pedidoAnterior() {
        if (listaDePedidos.retornarTamanho() == 0) {
            return null;
        }
        indiceAtual = (indiceAtual - 1 + listaDePedidos.retornarTamanho()) % listaDePedidos.retornarTamanho();
        return (Pedido) listaDePedidos.procurarData(indiceAtual);
    }

    public Pedido pedidoAtual() {
        if (listaDePedidos.retornarTamanho() == 0) {
            return null;
        }

        return (Pedido) listaDePedidos.procurarData(indiceAtual);
    }
}