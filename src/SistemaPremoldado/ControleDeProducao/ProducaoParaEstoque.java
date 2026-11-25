package SistemaPremoldado.ControleDeProducao;

import SistemaPremoldado.EstoqueDeMoldes.Molde;
import SistemaPremoldado.GestaoDePedidos.Produtos.Produto;

import java.time.LocalDate;

public class ProducaoParaEstoque extends LoteDeProducao{



    ProducaoParaEstoque(Produto produto, int quantidade, metodoProducao metodoDeProducao, LocalDate dataPrevisaoIniciarProducao, Molde moldeOcupado) {
        super(produto, quantidade, metodoDeProducao, dataPrevisaoIniciarProducao, moldeOcupado);
    }


}
