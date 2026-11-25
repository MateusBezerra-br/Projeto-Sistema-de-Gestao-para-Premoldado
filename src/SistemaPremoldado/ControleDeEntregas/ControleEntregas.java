package SistemaPremoldado.ControleDeEntregas;

import java.util.ArrayList;
import java.util.List;

public class ControleEntregas {

    private List<Entrega> filaDeEntrega;

    public ControleEntregas() {
        this.filaDeEntrega = new ArrayList<>();
    }

    public void adicionarNaFila(Entrega entrega) {
        filaDeEntrega.add(entrega);
    }

    public Entrega proximoDaFila() {

        if (filaDeEntrega.isEmpty()) {
            return null;
        }

        return filaDeEntrega.get(0);
    }

    public List<Entrega> listarPorStatus(String status) {

        List<Entrega> entregasEncontradas = new ArrayList<>();

        for (Entrega entrega : filaDeEntrega) {

            if (entrega.getStatusEntrega().equalsIgnoreCase(status)) {
                entregasEncontradas.add(entrega);
            }
        }

        return entregasEncontradas;
    }

    public void removerDaFila(Entrega entrega) {
        filaDeEntrega.remove(entrega);
    }

    public void criarNovaOrdemEntrega(Entrega entrega) {
        adicionarNaFila(entrega);
    }

    public List<Entrega> getFilaDeEntrega() {
        return filaDeEntrega;
    }
}