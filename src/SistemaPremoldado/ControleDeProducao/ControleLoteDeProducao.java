package SistemaPremoldado.ControleDeProducao;

import SistemaPremoldado.ControleDeCura.ControleDeProducaoEmCura;
import SistemaPremoldado.EstoqueDeMoldes.EstoqueMolde;
import SistemaPremoldado.EstruturaDeDados.Lista;
import SistemaPremoldado.GestaoDePedidos.ItemPedido;
import SistemaPremoldado.GestaoDePedidos.Pedido;

public class ControleLoteDeProducao extends Lista<LoteDeProducao> {

    Lista<ItemProducao> itensProducao =  new Lista<>();
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

    public void verificaStatusDeMaquinas(){


            ControleDeMaquinas.getIntancia().verificarStatusMaquinas();

    }

    public void iniciarProducao(LoteDeProducao loteDeProducao) {

        String pendencias = "";

        if (loteDeProducao.getMetodoDeProducao() == LoteDeProducao.metodoProducao.VIBROCOMPRESSAO) {

            pendencias = verificarDisponibilidadeMetodoVibrocompressao(loteDeProducao);

        } else if (loteDeProducao.getMetodoDeProducao() == LoteDeProducao.metodoProducao.SEMISSECO_MANUAL) {

            pendencias = verificarDisponibilidadeMetodoManualSemisseco(loteDeProducao);

        } else if (loteDeProducao.getMetodoDeProducao() == LoteDeProducao.metodoProducao.CONVENCIONAL) {

            pendencias = verificarDisponibilidadeMetodoConvencional(loteDeProducao);

        }

        if (!pendencias.isEmpty()) {
            System.out.println("Não foi possível iniciar a produção:");
            System.out.println(pendencias);
            return;
        }

        System.out.println("Produção iniciada!");

    }


    public String verificarDisponibilidadeMetodoVibrocompressao(LoteDeProducao loteDeProducao) {

        return ControleDeMaquinas.getIntancia().verificarDisponibilidadePara(loteDeProducao);

    }


    public String verificarDisponibilidadeMetodoManualSemisseco(LoteDeProducao loteDeProducao) {

        String pendencias = "";

        // Verificação de moldes será adicionada aqui.

        return pendencias;
    }


    public String verificarDisponibilidadeMetodoConvencional(LoteDeProducao loteDeProducao) {

        String pendencias = "";

        // Verificação de moldes será adicionada aqui.

        return pendencias;
    }






    public void mandarLoteParaEtapaDeCura(LoteDeProducao loteDeProducao) {


        loteDeProducao.setStatusAtual(LoteDeProducao.statusAtuais.PASSOU_PARA_ETAPA_CURA);
        ControleDeProducaoEmCura.getInstancia().adicionarNovoLoteEmCura(loteDeProducao);


    }


}
