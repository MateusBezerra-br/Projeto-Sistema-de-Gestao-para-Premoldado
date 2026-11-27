package SistemaPremoldado.ControleDeVendas;

import SistemaPremoldado.EstruturaDeDados.Lista;
import SistemaPremoldado.EstoqueDePremoldados.EstoquePremoldado;
import SistemaPremoldado.ControleDePedidosProduzidos.ItemProduzido;
import SistemaPremoldado.ControleDeEntregas.ItemEntrega;

public class ItemVenda {

    private int quantidade;
    private double precoUnitario;
    private double subTotal;

    private EstoquePremoldado estoquePremoldado;
    private ItemProduzido itemProduzido;
    private Venda venda;
    private Lista<ItemEntrega> itensEntrega;

    public ItemVenda(int quantidade, double precoUnitario,
                     EstoquePremoldado estoquePremoldado,
                     ItemProduzido itemProduzido) {

        if (quantidade != 1 || precoUnitario < 0) {
            throw new IllegalArgumentException(
                "Quantidade ou preço inválido."
            );
        }

        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.estoquePremoldado = estoquePremoldado;
        this.itemProduzido = itemProduzido;
        this.itensEntrega = new Lista<>();

        calcularSubTotal();
    }

    public void atualizarQuantidade(int quantidade) {
        if (quantidade != 1) {
            throw new IllegalArgumentException(
                "Cada item de venda representa uma unidade."
            );
        }

        this.quantidade = quantidade;
        calcularSubTotal();
    }

    public void calcularSubTotal() {
        this.subTotal = quantidade * precoUnitario;
    }

    public void associarVenda(Venda venda) {
        if (venda == null) {
            throw new IllegalArgumentException(
                "A venda não pode ser nula."
            );
        }

        if (this.venda != null) {
            throw new IllegalStateException(
                "Este item já está associado a uma venda."
            );
        }

        this.venda = venda;
    }

    public void adicionarItemEntrega(ItemEntrega itemEntrega) {
        if (itemEntrega == null) {
            throw new IllegalArgumentException(
                "O item de entrega não pode ser nulo."
            );
        }

        itensEntrega.addData(itemEntrega);
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        atualizarQuantidade(quantidade);
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        if (precoUnitario < 0) {
            throw new IllegalArgumentException(
                "O preço não pode ser negativo."
            );
        }

        this.precoUnitario = precoUnitario;
        calcularSubTotal();
    }

    public double getSubTotal() {
        return subTotal;
    }

    public EstoquePremoldado getEstoquePremoldado() {
        return estoquePremoldado;
    }

    public ItemProduzido getItemProduzido() {
        return itemProduzido;
    }

    public Venda getVenda() {
        return venda;
    }

    public Lista<ItemEntrega> getItensEntrega() {
        return itensEntrega;
    }
}