package SistemaPremoldado.ControleDeVendas;

import SistemaPremoldado.EstruturaDeDados.Lista;
import SistemaPremoldado.ControleDeVendas.Pagamento.Pagamento;
import SistemaPremoldado.ControleDeVendas.Pagamento.EstrategiaPagamento;
import SistemaPremoldado.GestaoDePedidos.Cliente;
import SistemaPremoldado.ControleDeEntregas.Entrega;

public class Venda {

    private String dataVenda;
    private Lista<ItemVenda> itensVenda;
    private double valorTotal;
    private String statusDeVenda;
    private Pagamento pagamento;

    private Cliente cliente;
    private Entrega entrega;

    public Venda(String dataVenda, String statusDeVenda) {
        this.dataVenda = dataVenda;
        this.statusDeVenda = statusDeVenda;
        this.itensVenda = new Lista<>();
        this.valorTotal = 0.0;
    }

    public void adicionarItemVenda(ItemVenda item) {
        if (item == null) {
            throw new IllegalArgumentException(
                "O item não pode ser nulo."
            );
        }

        itensVenda.addData(item);
        atualizarValorTotal();
    }

    public void atualizarValorTotal() {
        valorTotal = 0.0;

        for (int i = 0; i < itensVenda.retornarTamanho(); i++) {
            ItemVenda item =
                (ItemVenda) itensVenda.procurarData(i);

            valorTotal += item.getSubTotal();
        }
    }

    public void atualizarStatusDeVenda(String novoStatus) {
        if (novoStatus == null || novoStatus.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "O status da venda é inválido."
            );
        }

        this.statusDeVenda = novoStatus;
    }

    public void configurarPagamento(EstrategiaPagamento estrategia) {
        if (estrategia == null) {
            throw new IllegalArgumentException(
                "A estratégia de pagamento não pode ser nula."
            );
        }

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

    public void associarCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException(
                "O cliente não pode ser nulo."
            );
        }

        this.cliente = cliente;
    }

    public void associarEntrega(Entrega entrega) {
        if (entrega == null) {
            throw new IllegalArgumentException(
                "A entrega não pode ser nula."
            );
        }

        this.entrega = entrega;
        entrega.setVenda(this);
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

    public Lista<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setStatusDeVenda(String statusDeVenda) {
        atualizarStatusDeVenda(statusDeVenda);
    }
}