package SistemaPremoldado.Estoque;


import SistemaPremoldado.EstruturaDeDados.Lista;

public class TracoProduto {
    private Lista<ItemTraco> itensReceita;
    public TracoProduto() {
        this.itensReceita = new Lista<>();
    }

    public Lista<ItemTraco> getItensReceita() {
        return itensReceita;
    }

    public void adicionarItemReceita(ItemTraco item){
        this.itensReceita.addData(item);
    }

    public void removerItemReceita(int index) {
        this.itensReceita.removeData(index);
    }
}
