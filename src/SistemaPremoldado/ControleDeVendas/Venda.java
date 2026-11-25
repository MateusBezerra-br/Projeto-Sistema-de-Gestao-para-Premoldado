
package SistemaPremoldado.ControleDeVendas;

import SistemaPremoldado.EstruturaDeDados.lista;

public class Venda {

    private String dataVenda;
    private lista<ItemVenda> itensVenda;
    private double valorTotal;
    private String statusDeVenda;

    public Venda(String dataVenda, String statusDeVenda) {
        this.dataVenda = dataVenda;
        this.statusDeVenda = statusDeVenda;
        this.itensVenda = new lista<>();
        this.valorTotal = 0.0;
    }

    public void adicionarItemVenda(ItemVenda item) {
        itensVenda.addData(item);
        atualizarValorTotal();
    }

    public void atualizarValorTotal() {
        valorTotal = 0.0;

        for (int i = 0; i < itensVenda.retornarTamanho(); i++) {
            ItemVenda item = (ItemVenda) itensVenda.procurarData(i);
            valorTotal += item.getSubTotal();
        }
    }

    public void atualizarStatusDeVenda() {

    }

    public String getDataVenda() {
        return dataVenda;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public String getStatusDeVenda() {
        return statusDeVenda;
    }

    public lista<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setStatusDeVenda(String statusDeVenda) {
        this.statusDeVenda = statusDeVenda;
    }
}
