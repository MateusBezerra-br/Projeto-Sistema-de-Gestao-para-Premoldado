package SistemaPremoldado.ControleDeVendas.Pagamento;

public class Pix implements EstrategiaPagamento {

    @Override
    public void realizarPagamento(double valor) {
        System.out.println("Pagamento realizado via PIX: R$ " + valor);
    }
}