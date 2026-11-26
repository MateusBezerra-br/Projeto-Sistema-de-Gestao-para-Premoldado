package SistemaPremoldado.Estoque;

public class EstoqueFacade {

    private EstoqueMateriaPrima estoque;

    public EstoqueFacade() {
        this.estoque = EstoqueMateriaPrima.getInstancia();
    }

    public ItemEstoque consultarDisponibilidade(MateriaPrima materiaPrima) {
        return estoque.verificarDisponibilidade(materiaPrima);
    }

    public boolean darBaixa(MateriaPrima materiaPrima, double quantidade) {
        return estoque.darBaixa(materiaPrima, quantidade);
    }

    public boolean repor(MateriaPrima materiaPrima, double quantidade) {
        return estoque.repor(materiaPrima, quantidade);
    }
}