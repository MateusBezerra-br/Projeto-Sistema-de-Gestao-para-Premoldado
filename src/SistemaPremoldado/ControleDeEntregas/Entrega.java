
package SistemaPremoldado.ControleDeEntregas;

import SistemaPremoldado.EstruturaDeDados.lista;
import SistemaPremoldado.ControleDeVendas.Venda;

public class Entrega {

    private String nomeEntregador;
    private String statusEntrega;
    private String dataPrevistaEntrega;
    private lista<ItemEntrega> itensEntrega;
    private Venda venda;

    public Entrega(String nomeEntregador, String statusEntrega,
                   String dataPrevistaEntrega, Venda venda) {

        this.nomeEntregador = nomeEntregador;
        this.statusEntrega = statusEntrega;
        this.dataPrevistaEntrega = dataPrevistaEntrega;
        this.venda = venda;
        this.itensEntrega = new lista<>();
    }

    public void atualizarStatusEntrega() {

    }

    public void calcularPrevisao() {

    }

    public String getNomeEntregador() {
        return nomeEntregador;
    }

    public String getStatusEntrega() {
        return statusEntrega;
    }

    public String getDataPrevistaEntrega() {
        return dataPrevistaEntrega;
    }

    public lista<ItemEntrega> getItensEntrega() {
        return itensEntrega;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setNomeEntregador(String nomeEntregador) {
        this.nomeEntregador = nomeEntregador;
    }

    public void setStatusEntrega(String statusEntrega) {
        this.statusEntrega = statusEntrega;
    }

    public void setDataPrevistaEntrega(String dataPrevistaEntrega) {
        this.dataPrevistaEntrega = dataPrevistaEntrega;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }
}
