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



    public void adicionarNovoLoteEmCura(LoteDeProducao loteEtapaCura){

        LoteEmCura novoLoteCura;

        if(loteEtapaCura.getMetodoDeProducao() == LoteDeProducao.metodoProducao.CONVENCIONAL){

            novoLoteCura = new CuraPosConvencional(loteEtapaCura.getProduto(), loteEtapaCura.getQuantidade(),LocalDate.now().plusDays(loteEtapaCura.getProduto().getTempoCura()) , loteEtapaCura.getMoldeOcupado() ,loteEtapaCura.getEstoqueMolde() );




        }
        else {


             novoLoteCura = new CuraPosSemiSeco(loteEtapaCura.getProduto(),loteEtapaCura.getQuantidade());


        }

        instancia.addData(novoLoteCura);

    }



}
