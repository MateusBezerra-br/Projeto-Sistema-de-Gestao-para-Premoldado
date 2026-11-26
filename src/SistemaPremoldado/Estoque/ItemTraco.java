package SistemaPremoldado.Estoque;

public class ItemTraco {
    private String nome;
    private double quantidade;

    public ItemTraco(String nome, double quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public double getQuantidade() {
        return quantidade;
    }
}
