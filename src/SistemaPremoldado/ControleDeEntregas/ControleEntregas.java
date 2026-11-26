
package SistemaPremoldado.ControleDeEntregas;

import SistemaPremoldado.EstruturaDeDados.lista;

public class ControleEntregas extends lista<Entrega> {

    public void adicionarNaFila(Entrega entrega) {
        addData(entrega);
    }

    public Entrega proximoDaFila() {
        if (retornarTamanho() == 0) {
            return null;
        }

        return (Entrega) procurarData(0);
    }

    public lista<Entrega> listarPorStatus(StatusEntrega status) {
        lista<Entrega> entregasEncontradas = new lista<>();

        for (int i = 0; i < retornarTamanho(); i++) {
            Entrega entrega = (Entrega) procurarData(i);

            if (entrega.getStatusEntrega() == status) {
                entregasEncontradas.addData(entrega);
            }
        }

        return entregasEncontradas;
    }

    public void removerDaFila(Entrega entrega) {
        for (int i = 0; i < retornarTamanho(); i++) {
            Entrega atual = (Entrega) procurarData(i);

            if (atual == entrega) {
                removeData(i);
                return;
            }
        }
    }

    public void criarNovaOrdemEntrega(Entrega entrega) {
        adicionarNaFila(entrega);
    }
}

  