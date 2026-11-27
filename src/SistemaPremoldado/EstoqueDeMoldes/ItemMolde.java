package SistemaPremoldado.EstoqueDeMoldes;

public class ItemMolde {

    private Molde molde;
    private int  quantidadeTotal;
    private int quantidadeDisponivel ;
    private int quantidadeEmUso = 0;

    public ItemMolde(Molde molde, int quantidadeTotal) {
        this.molde = molde;
        this.quantidadeTotal = quantidadeTotal;
        this.quantidadeDisponivel = quantidadeTotal;
    }

    public Molde getMolde() {
        return molde;
    }

    public void setMolde(Molde molde) {
        this.molde = molde;
    }

    public void setQuantidadeTotal(int quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public int getQuantidadeEmUso() {
        return quantidadeEmUso;
    }

    public int getQuantidadeTotal() {
        return quantidadeTotal;
    }


    public void retirarMoldes(int quantidadeOcupar) {
        if (quantidadeOcupar > 0 && quantidadeDisponivel >= quantidadeOcupar) {
            quantidadeEmUso += quantidadeOcupar;
            quantidadeDisponivel -= quantidadeOcupar;
        }
    }

    public void devolverMoldes(int quantidadeDesocupar) {
        if (quantidadeDesocupar > 0 && quantidadeEmUso >= quantidadeDesocupar) {
            quantidadeDisponivel += quantidadeDesocupar;
            quantidadeEmUso -= quantidadeDesocupar;
        }
    }



}
