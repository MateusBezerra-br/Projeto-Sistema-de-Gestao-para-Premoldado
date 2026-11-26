package SistemaPremoldado.ControleDeVendas.Pagamento;

public class Pagamento {

    private EstrategiaPagamento estrategia;

    public Pagamento(EstrategiaPagamento estrategia) {
        this.estrategia = estrategia;
    }

    public void realizarPagamento(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido.");
        }

        estrategia.realizarPagamento(valor);
    }

    public void setEstrategia(EstrategiaPagamento estrategia) {
        if (estrategia == null) {
            throw new IllegalArgumentException("Estratégia inválida.");
        }

        this.estrategia = estrategia;
    }
}