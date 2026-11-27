package SistemaPremoldado.ControleDeCura;

import SistemaPremoldado.ControleDeProducao.LoteDeProducao;
import SistemaPremoldado.EstoqueDeMoldes.EstoqueMolde;
import SistemaPremoldado.EstruturaDeDados.Lista;

import SistemaPremoldado.EstruturaDeDados.Lista;
import SistemaPremoldado.EstruturaDeDados.Node;

import java.time.LocalDate;

public class ControleDeProducaoEmCura extends Lista<LoteEmCura> {

    private static ControleDeProducaoEmCura instancia;

    private ControleDeProducaoEmCura() {

    }

    public static ControleDeProducaoEmCura getInstancia() {

        if(instancia == null) {

            instancia = new ControleDeProducaoEmCura();
        }

        return instancia;
    }









    public void adicionarNovoLoteEmCura(LoteDeProducao loteEtapaCura){

        LoteEmCura novoLoteCura;

        if(loteEtapaCura.getMetodoDeProducao() == LoteDeProducao.metodoProducao.CONVENCIONAL){

            novoLoteCura = new CuraPosConvencional(loteEtapaCura.getProduto(), loteEtapaCura.getQuantidade(),LocalDate.now().plusDays(loteEtapaCura.getProduto().getTempoCura()) , loteEtapaCura.getMoldeOcupado() ,loteEtapaCura.getEstoqueMolde(), loteEtapaCura.getProducaoParaEstoque() );




        }
        else {


             novoLoteCura = new CuraPosSemiSeco(loteEtapaCura.getProduto(),loteEtapaCura.getQuantidade(), loteEtapaCura.getProducaoParaEstoque());


        }

        instancia.addData(novoLoteCura);

    }


    public void listarLotesEmCura(){


        Node<LoteEmCura> aux = getBegin();


        for(int i = 0 ; i < getInstancia().retornarTamanho(); i++ ){

            LoteEmCura LoteAtual = aux.data;

            System.out.println("Lote "+ i + ":");
            System.out.println(LoteAtual);
            System.out.println("-------------------------------------");


        }



        
    }

    public LoteEmCura encontrarLoteEmCura(int id ){


        Node<LoteEmCura> aux = getBegin();


        for(int i = 0 ; i < getInstancia().retornarTamanho(); i++ ){

            LoteEmCura LoteAtual = aux.data;

            if(LoteAtual.getProduto().getId() == id){

                return LoteAtual;
            }

        }

        return null;

    }

    public void armazenarLoteEmCuraFinalizado(LoteEmCura LoteFinalizado ){


        if( LoteFinalizado.getQuantidadeParaEstoque() > 0){

        }




    }



}
