package SistemaPremoldado.ControleDeProducao;

import SistemaPremoldado.GestaoDePedidos.Cliente;
import SistemaPremoldado.GestaoDePedidos.Produtos.Produto;

public class ItemProducao {


    Produto produto;
    int id;
    Cliente cliente;
    int quantidade;



    public ItemProducao(int id, Cliente cliente, int quantidade,  Produto produto) {
        this.id = id;
        this.cliente = cliente;
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }






    @Override
    public String toString() {

        return "cliente referente: " + this.cliente.getNome() + "\nproduto: " + this.produto.getNome() + "\nQuantidade: " + this.quantidade;
    }
}
