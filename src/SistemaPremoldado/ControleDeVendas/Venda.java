
package SistemaPremoldado.ControleDeVendas;

import SistemaPremoldado.EstruturaDeDados.lista;
import SistemaPremoldado.ControleDeVendas.Pagamento.Pagamento;
import SistemaPremoldado.ControleDeVendas.Pagamento.EstrategiaPagamento;

public class Venda {

    private String dataVenda;
    private lista<ItemVenda> itensVenda;
    private double valorTotal;
    private String statusDeVenda;
    private Pagamento pagamento;

    public Venda(String dataVenda, String statusDeVenda) {
        this.dataVenda = dataVenda;
        this.statusDeVenda = statusDeVenda;
        this.itensVenda = new lista<>();
        this.valorTotal = 0.0;
    }

    public void adicionarItemVenda(ItemVenda item) {
        if (item == null) {
            throw new IllegalArgumentException("O item não pode ser nulo.");
        }

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

    public void atualizarStatusDeVenda(String novoStatus) {
        if (novoStatus == null || novoStatus.trim().isEmpty()) {
            throw new IllegalArgumentException("O status da venda é inválido.");
        }

        this.statusDeVenda = novoStatus;
    }

    
    public void configurarPagamento(EstrategiaPagamento estrategia) {
        this.pagamento = new Pagamento(estrategia);
    }

    
    public void realizarPagamento() {
        if (pagamento == null) {
            throw new IllegalStateException(
                "Nenhuma forma de pagamento foi configurada."
            );
        }

        atualizarValorTotal();
        pagamento.realizarPagamento(valorTotal);
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
        atualizarStatusDeVenda(statusDeVenda);
    }
}
