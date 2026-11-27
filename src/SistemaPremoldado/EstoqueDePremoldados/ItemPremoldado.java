package SistemaPremoldado.EstoqueDePremoldados;

import SistemaPremoldado.GestaoDePedidos.Produtos.Produto;

public class ItemPremoldado {

    private int id;
    private int quantidade;
    private Produto Produto;

    public ItemPremoldado(int id, int quantidade,  Produto produto) {

        if (id <= 0 || quantidade < 0) {
            throw new IllegalArgumentException("ID ou quantidade inválida.");
        }

        this.id = id;
        this.quantidade = quantidade;
        this.Produto = produto;
    }

    public void atualizarQuant(int novaQuantidade) {

        if (novaQuantidade < 0) {
            throw new IllegalArgumentException("A quantidade não pode ser negativa.");
        }

        this.quantidade = novaQuantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {

        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido.");
        }

        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {

        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade não pode ser negativa.");
        }

        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return Produto;
    }

    public void setProduto(Produto produto) {
        Produto = produto;
    }
}