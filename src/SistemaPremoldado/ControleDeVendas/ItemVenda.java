
package SistemaPremoldado.ControleDeVendas;

import SistemaPremoldado.EstoqueDePremoldados.EstoquePremoldado;
import SistemaPremoldado.ControleDePedidosProduzidos.ItemProduzido;

public class ItemVenda {

    private int quantidade;
    private double precoUnitario;
    private double subTotal;

    private EstoquePremoldado estoquePremoldado;
    private ItemProduzido itemProduzido;

    public ItemVenda(int quantidade, double precoUnitario,
                     EstoquePremoldado estoquePremoldado,
                     ItemProduzido itemProduzido) {

        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.estoquePremoldado = estoquePremoldado;
        this.itemProduzido = itemProduzido;

        calcularSubTotal();
    }

    public void atualizarQuantidade(int quantidade) {
        this.quantidade = quantidade;
        calcularSubTotal();
    }

    public void calcularSubTotal() {
        this.subTotal = quantidade * precoUnitario;
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
}
