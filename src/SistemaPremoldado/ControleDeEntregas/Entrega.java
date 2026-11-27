package SistemaPremoldado.ControleDeEntregas;

import SistemaPremoldado.EstruturaDeDados.Lista;
import SistemaPremoldado.ControleDeVendas.Venda;

public class Entrega {

    private String nomeEntregador;
    private StatusEntrega statusEntrega;
    private String dataPrevistaEntrega;
    private Lista<ItemEntrega> itensEntrega;
    private Venda venda;

    public Entrega(String nomeEntregador, StatusEntrega statusEntrega,
                   String dataPrevistaEntrega, Venda venda) {

        if (venda == null) {
            throw new IllegalArgumentException(
                "A venda não pode ser nula."
            );
        }

        this.nomeEntregador = nomeEntregador;
        this.statusEntrega = statusEntrega;
        this.dataPrevistaEntrega = dataPrevistaEntrega;
        this.itensEntrega = new Lista<>();

        this.venda = null;
        venda.associarEntrega(this);
    }

    public void atualizarStatusEntrega(StatusEntrega novoStatus) {
        if (novoStatus == null) {
            throw new IllegalArgumentException(
                "O status não pode ser nulo."
            );
        }

        this.statusEntrega = novoStatus;
    }

    public void adicionarItemEntrega(ItemEntrega item) {
        if (item == null) {
            throw new IllegalArgumentException(
                "O item de entrega não pode ser nulo."
            );
        }

        if (item.getEntrega() != null && item.getEntrega() != this) {
            throw new IllegalStateException(
                "O item já pertence a outra entrega."
            );
        }

        item.setEntrega(this);
        itensEntrega.addData(item);
    }

    public void calcularPrevisao() {

    }

    public String getNomeEntregador() {
        return nomeEntregador;
    }

    public StatusEntrega getStatusEntrega() {
        return statusEntrega;
    }

    public String getDataPrevistaEntrega() {
        return dataPrevistaEntrega;
    }

    public Lista<ItemEntrega> getItensEntrega() {
        return itensEntrega;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setNomeEntregador(String nomeEntregador) {
        this.nomeEntregador = nomeEntregador;
    }

    public void setStatusEntrega(StatusEntrega statusEntrega) {
        atualizarStatusEntrega(statusEntrega);
    }

    public void setDataPrevistaEntrega(String dataPrevistaEntrega) {
        this.dataPrevistaEntrega = dataPrevistaEntrega;
    }

    public void setVenda(Venda venda) {
        if (venda == null) {
            throw new IllegalArgumentException(
                "A venda não pode ser nula."
            );
        }

        if (this.venda != null && this.venda != venda) {
            throw new IllegalStateException(
                "Esta entrega já está associada a outra venda."
            );
        }

        this.venda = venda;
    }
}