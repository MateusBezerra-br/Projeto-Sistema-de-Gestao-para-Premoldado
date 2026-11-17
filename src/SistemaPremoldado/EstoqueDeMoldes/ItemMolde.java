package SistemaPremoldado.EstoqueDeMoldes;

public class ItemMolde {

    private Molde molde;
    private int  quantidadeTotal;
    private int quantidadeDisponivel;
    private int quantidadeEmUso = 0;

    public ItemMolde(Molde molde, int quantidadeTotal, int quantidadeDisponivel) {
        this.molde = molde;
        this.quantidadeTotal = quantidadeTotal;
        this.quantidadeDisponivel = quantidadeDisponivel;

    }

    public Molde getMolde() {
        return molde;
    }

    public void setMolde(Molde molde) {
        this.molde = molde;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public int getQuantidadeEmUso() {
        return quantidadeEmUso;
    }

    public void setQuantidadeEmUso(int quantidadeEmUso) {
        this.quantidadeEmUso = quantidadeEmUso;
    }

    public int getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(int quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }
}
