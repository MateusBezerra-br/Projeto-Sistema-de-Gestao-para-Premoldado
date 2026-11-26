package SistemaPremoldado.ControleDeVendas.Pagamento;

public class Cartao implements EstrategiaPagamento {

    @Override
    public void realizarPagamento(double valor) {
        System.out.println("Pagamento realizado via cartão: R$ " + valor);
    }
}