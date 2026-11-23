package SistemaPremoldado.EstoqueDeMoldes;

public class ItemMolde {

    private Molde molde;
    private int  quantidadeTotal;
    private int quantidadeDisponivel = 0;
    private int quantidadeEmUso = 0;

    public ItemMolde(Molde molde, int quantidadeTotal) {
        this.molde = molde;
        this.quantidadeTotal = quantidadeTotal;

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

    public void ocuparMoldes( int quantidadeOcupar){

        if(quantidadeTotal ==  (quantidadeEmUso + quantidadeOcupar) + (quantidadeDisponivel - quantidadeEmUso) ){

            quantidadeEmUso += quantidadeOcupar;
            quantidadeDisponivel -= quantidadeOcupar;

        }

    }

    public  void desocuparMoldes(int quantidadeDesocupar){


        if(quantidadeTotal ==  (quantidadeDisponivel + quantidadeDesocupar) + (quantidadeEmUso - quantidadeDesocupar) ){

            quantidadeDisponivel += quantidadeDesocupar;
            quantidadeEmUso -= quantidadeDesocupar;

        }

    }


}
