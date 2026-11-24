
package SistemaPremoldado.ControleDeVendas;

public class ItemVenda {

    private int quantidade;
    private double precoUnitario;
    private double subTotal;

    public ItemVenda(int quantidade, double precoUnitario) {
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
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
}
