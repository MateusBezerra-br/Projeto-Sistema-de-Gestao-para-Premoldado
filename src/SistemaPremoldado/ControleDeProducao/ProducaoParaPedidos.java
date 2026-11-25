package SistemaPremoldado.ControleDeProducao;

import SistemaPremoldado.EstoqueDeMoldes.Molde;
import SistemaPremoldado.EstruturaDeDados.lista;
import SistemaPremoldado.GestaoDePedidos.Produtos.Produto;

import java.time.LocalDate;

public class ProducaoParaPedidos extends LoteDeProducao{

    private lista<ItemProducao> itemProducaoDeClientes;

    ProducaoParaPedidos(Produto produto, int quantidade, metodoProducao metodoDeProducao, LocalDate dataPrevisaoIniciarProducao, Molde moldeOcupado, lista<ItemProducao> itemProducaoDeClientes) {
        super(produto, quantidade, metodoDeProducao, dataPrevisaoIniciarProducao, moldeOcupado);

        this.itemProducaoDeClientes = itemProducaoDeClientes;
    }

    lista<ItemProducao> getItemProducaoDeClientes() {
        return itemProducaoDeClientes;
    }



}
