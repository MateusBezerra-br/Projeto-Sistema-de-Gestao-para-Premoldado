package SistemaPremoldado.Estoque;

public class ItemEstoque {
    private int id;
    private double quantidadeDisponivel;
    private MateriaPrima materiaPrima;

    public ItemEstoque(int id, double quantidadeDisponivel, MateriaPrima materiaPrima) {
        this.id = id;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.materiaPrima = materiaPrima;
    }

    public int getId() {
        return id;
    }

    public double getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public MateriaPrima getMateriaPrima() {
        return materiaPrima;
    }

    public void atualizaQuantidade(double quantidade) {
        this.quantidadeDisponivel = quantidade;
    }
}
