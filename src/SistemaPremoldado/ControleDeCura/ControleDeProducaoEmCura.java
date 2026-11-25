package SistemaPremoldado.ControleDeCura;

import SistemaPremoldado.ControleDeProducao.LoteDeProducao;
import SistemaPremoldado.EstoqueDeMoldes.EstoqueMolde;

import SistemaPremoldado.EstruturaDeDados.lista;

import java.time.LocalDate;

public class ControleDeProducaoEmCura extends lista<LoteEmCura> {

    private static ControleDeProducaoEmCura instancia;


    private ControleDeProducaoEmCura() {

    }

    public static ControleDeProducaoEmCura getInstancia() {

        if(instancia == null) {

            instancia = new ControleDeProducaoEmCura();
        }

        return instancia;
    }



    public void adicionarNovoLoteEmCura(LoteDeProducao loteEtapaCura, int tempoNoMolde){


        if(loteEtapaCura.getMetodoDeProducao() == LoteDeProducao.metodoProducao.CONVENCIONAL){

            CuraPosConvencional novoLoteCura = new CuraPosConvencional(loteEtapaCura.getProduto(), loteEtapaCura.getQuantidade(),LocalDate.now().plusDays(tempoNoMolde) , loteEtapaCura.getMoldeOcupado() ,loteEtapaCura.getEstoqueMolde() );

            instancia.addData(novoLoteCura);


        }
        else{


        }


    }



}
