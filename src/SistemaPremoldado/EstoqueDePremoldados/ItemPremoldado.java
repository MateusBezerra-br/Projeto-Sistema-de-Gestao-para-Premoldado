package SistemaPremoldado.EstoqueDePremoldados;

public class ItemPremoldado {

    private int id;
    private int quantidade;

    public ItemPremoldado(int id, int quantidade) {
        this.id = id;
        this.quantidade = quantidade;
    }

    public void atualizarQuant() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}