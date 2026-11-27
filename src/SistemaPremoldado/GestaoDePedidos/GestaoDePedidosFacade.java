package SistemaPremoldado.GestaoDePedidos;

import SistemaPremoldado.GestaoDePedidos.Produtos.Produto;

public class GestaoDePedidosFacade {
    private ListaDeClientes listaDeClientes;
    private ListaDePedidos listaDePedidos;

    public GestaoDePedidosFacade() {
        this.listaDeClientes = ListaDeClientes.getInstancia();
        this.listaDePedidos = ListaDePedidos.getInstancia();
    }

    public void cadastrarCliente(int id, String nome, String telefone, String localDeEntrega) {
        Cliente cliente = new Cliente(id, nome, telefone, localDeEntrega);
        listaDeClientes.cadastrarCliente(cliente);
    }

    public Cliente consultarCliente(int index) {
        return listaDeClientes.consultarCliente(index);
    }

    public void cadastrarPedido(int id, String status, String dataDeChegada, String prazoEstimado, String dataTermino, Cliente cliente) {
        Pedido pedido = new Pedido(id, status, dataDeChegada, prazoEstimado, dataTermino, cliente);
        listaDePedidos.adicionarPedido(pedido);
    }

    public Pedido consultarPedidoAtual() {
        return listaDePedidos.pedidoAtual();
    }

    public Pedido consultarProximoPedido() {
        return listaDePedidos.proximoPedido();
    }

    public Pedido consultarPedidoAnterior() {
        return listaDePedidos.pedidoAnterior();
    }

    public void removerCliente(int index) {
        listaDeClientes.removerCliente(index);
    }

    public void removerPedido(int index) {
        listaDePedidos.removerPedido(index);
    }

    public void adicionarItemAoPedido(Pedido pedido, int idItem, int quantidade, Produto produto) {
        ItemPedido item = new ItemPedido(idItem, quantidade, produto);

        pedido.adicionarItem(item);
        pedido.calcularValor();
    }

    public void removerItemDoPedido(Pedido pedido, int index) {
        pedido.removerItem(index);
    }
}
