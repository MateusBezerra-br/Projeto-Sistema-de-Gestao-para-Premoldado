package SistemaPremoldado.ControleDeProducao;

import SistemaPremoldado.ControleDeCura.ControleDeProducaoEmCura;
import SistemaPremoldado.EstoqueDeMoldes.EstoqueMolde;
import SistemaPremoldado.EstruturaDeDados.lista;
import SistemaPremoldado.GestaoDePedidos.ItemPedido;
import SistemaPremoldado.GestaoDePedidos.Pedido;

public class ControleLoteDeProducao extends lista<LoteDeProducao> {

    lista<ItemProducao> itensProducao =  new lista<>();
    private EstoqueMolde estoqueMolde;

    private static ControleLoteDeProducao instancia;


    private ControleLoteDeProducao() {

    }

    public static ControleLoteDeProducao getInstancia() {

        if(instancia == null) {

            instancia = new ControleLoteDeProducao();
        }

        return instancia;
    }



    public void mandarPedidoParaEtapaProducao(Pedido pedido) {

        for(int i = 0 ; i < pedido.getItensPedido().retornarTamanho();){

          ItemPedido itemPedido = (ItemPedido) pedido.getItensPedido().procurarData(i);

          ItemProducao novoItemProducao = new ItemProducao(itemPedido.getId(),itemPedido.getCliente(), itemPedido.getQuantidade(), itemPedido.getProduto());
         itensProducao.addData(novoItemProducao);
        }


    }


    public void EmitirLoteDeProducao(LoteDeProducao novoloteDeProducao) {

        addData(novoloteDeProducao);
    }

    public void visualizarItensProducoes(){

        for(int i = 0; i < getInstancia().itensProducao.retornarTamanho();i++){

            System.out.println( getInstancia().itensProducao.procurarData(i).toString());

        }
    }

    public void verificaStausDeMaquinas(){


            ControleDeMaquinas.getIntancia().verificarStatusMaquinas();

    }

    public void iniciarProducao (LoteDeProducao loteDeProducao) {


        if(loteDeProducao.getMetodoDeProducao() == LoteDeProducao.metodoProducao.VIBROCOMPRESSAO){




        }



    }


    public void mandarLoteParaEtapaDeCura(LoteDeProducao loteDeProducao) {


        loteDeProducao.setStatusAtual(LoteDeProducao.statusAtuais.PASSOU_PARA_ETAPA_CURA);
        ControleDeProducaoEmCura.getInstancia().adicionarNovoLoteEmCura(loteDeProducao);


    }


}
