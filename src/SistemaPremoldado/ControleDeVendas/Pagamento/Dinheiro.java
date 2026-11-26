package SistemaPremoldado.ControleDeVendas.Pagamento;

public class Dinheiro implements EstrategiaPagamento {

    @Override
    public void realizarPagamento(double valor) {
        System.out.println("Pagamento realizado em dinheiro: R$ " + valor);
    }
}