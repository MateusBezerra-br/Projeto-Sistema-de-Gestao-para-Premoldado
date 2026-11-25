
package SistemaPremoldado.ControleDeEntregas;

import SistemaPremoldado.EstruturaDeDados.lista;

public class ControleEntregas {

    private lista<Entrega> filaDeEntrega;

    public ControleEntregas() {
        this.filaDeEntrega = new lista<>();
    }

    public void adicionarNaFila(Entrega entrega) {
        filaDeEntrega.addData(entrega);
    }

    public Entrega proximoDaFila() {

        if (filaDeEntrega.retornarTamanho() == 0) {
            return null;
        }

        return (Entrega) filaDeEntrega.procurarData(0);
    }

    public lista<Entrega> listarPorStatus(String status) {

        lista<Entrega> entregasEncontradas = new lista<>();

        for (int i = 0; i < filaDeEntrega.retornarTamanho(); i++) {

            Entrega entrega = (Entrega) filaDeEntrega.procurarData(i);

            if (entrega.getStatusEntrega().equalsIgnoreCase(status)) {
                entregasEncontradas.addData(entrega);
            }
        }

        return entregasEncontradas;
    }

    public void removerDaFila(Entrega entrega) {

        for (int i = 0; i < filaDeEntrega.retornarTamanho(); i++) {

            Entrega atual = (Entrega) filaDeEntrega.procurarData(i);

            if (atual == entrega) {
                filaDeEntrega.removeData(i);
                return;
            }
        }
    }

    public void criarNovaOrdemEntrega(Entrega entrega) {
        adicionarNaFila(entrega);
    }

    public lista<Entrega> getFilaDeEntrega() {
        return filaDeEntrega;
    }
}
