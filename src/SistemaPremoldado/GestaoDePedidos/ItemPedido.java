package SistemaPremoldado.GestaoDePedidos;

import SistemaPremoldado.GestaoDePedidos.Produtos.Produto;

public class ItemPedido {
    private int id;
    private int quantidade;
    private Produto produto;
    private double precoUnitario;
    private double subtotal;

    public ItemPedido (int id, int quantidade, Produto produto) {
        this.id = id;
        this.quantidade = quantidade;
        this.produto = produto;
        this.precoUnitario = produto.getPrecoUnidade();
        this.subtotal = 0.0;
        calcularSubtotal();
    }

    public double calcularSubtotal() {
        this.subtotal = this.quantidade * this.precoUnitario;
        return this.subtotal;
    }

    public void atualizarQuantidade(int quantidade) {
        this.quantidade = quantidade;
        calcularSubtotal();
    }

    public int getId() {
        return id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public double getSubtotal() {
        return subtotal;
    }
}
