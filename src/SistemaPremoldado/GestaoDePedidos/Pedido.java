package SistemaPremoldado.GestaoDePedidos;

import SistemaPremoldado.EstruturaDeDados.Lista;

public class Pedido {
    private int id;
    private String status;
    private String dataDeChegada;
    private String prazoEstimado;
    private String dataTermino;
    private double valorTotal;
    private Lista<ItemPedido> itensPedido;

    public Pedido(int id, String status, String dataDeChegada, String prazoEstimado, String dataTermino) {
        this.id = id;
        this.status = status;
        this.dataDeChegada = dataDeChegada;
        this.prazoEstimado = prazoEstimado;
        this.dataTermino = dataTermino;
        this.valorTotal = 0.0;
        this.itensPedido = new Lista<>();
    }

    public void adicionarItem(ItemPedido item) {
        this.itensPedido.addData(item);
    }

    public void removerItem(int index) {
        itensPedido.removeData(index);
        calcularValor();
    }

    public void calcularValor() {
        this.valorTotal = 0.0;

        for (int i = 0; i < itensPedido.retornarTamanho(); i++) {
            ItemPedido item = (ItemPedido) itensPedido.procurarData(i);
            this.valorTotal += item.calcularSubtotal();
        }
    }


    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getDataDeChegada() {
        return dataDeChegada;
    }

    public String getPrazoEstimado() {
        return prazoEstimado;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public Lista<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setPrazoEstimado(String prazoEstimado) {
        this.prazoEstimado = prazoEstimado;
    }
}
