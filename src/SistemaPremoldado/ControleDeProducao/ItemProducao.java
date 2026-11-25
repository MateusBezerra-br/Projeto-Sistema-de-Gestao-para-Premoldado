package SistemaPremoldado.ControleDeProducao;

import SistemaPremoldado.GestaoDePedidos.Cliente;

public class ItemProducao {

    int id;
    Cliente cliente;
    int quantidade;



    public ItemProducao(int id, Cliente cliente, int quantidade) {
        this.id = id;
        this.cliente = cliente;
        this.quantidade = quantidade;
    }

    public void atualizarQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

}
