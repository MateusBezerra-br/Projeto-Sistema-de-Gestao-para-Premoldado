
package SistemaPremoldado.ControleDeEntregas;

import SistemaPremoldado.EstruturaDeDados.Lista;

public class ControleEntregas extends Lista<Entrega> {

    public void adicionarNaFila(Entrega entrega) {
        addData(entrega);
    }

    public Entrega proximoDaFila() {
        if (retornarTamanho() == 0) {
            return null;
        }

        return (Entrega) procurarData(0);
    }

    public Lista<Entrega> ListarPorStatus(StatusEntrega status) {
        Lista<Entrega> entregasEncontradas = new Lista<>();

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

