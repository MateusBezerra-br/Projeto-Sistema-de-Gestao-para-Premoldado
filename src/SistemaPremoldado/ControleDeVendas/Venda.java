
package SistemaPremoldado.ControleDeVendas;

import java.util.ArrayList;
import java.util.List;

public class Venda {

    private String dataVenda;
    private List<ItemVenda> itensVenda;
    private double valorTotal;
    private String statusDeVenda;

    public Venda(String dataVenda, String statusDeVenda) {
        this.dataVenda = dataVenda;
        this.statusDeVenda = statusDeVenda;
        this.itensVenda = new ArrayList<>();
        this.valorTotal = 0.0;
    }

    public void adicionarItemVenda(ItemVenda item) {
        itensVenda.add(item);
        atualizarValorTotal();
    }

    public void atualizarValorTotal() {
        valorTotal = 0.0;

        for (ItemVenda item : itensVenda) {
            valorTotal += item.getSubTotal();
        }
    }

    public void atualizarStatusDeVenda() {

        // Regra de atualização de status será definida posteriormente.

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

    public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setStatusDeVenda(String statusDeVenda) {
        this.statusDeVenda = statusDeVenda;
    }
}

