package SistemaPremoldado.ControleDeProducao;

import SistemaPremoldado.EstoqueDeMoldes.EstoqueMolde;
import SistemaPremoldado.EstruturaDeDados.lista;

public class ControleLoteDeProducao extends lista<LoteDeProducao> {

    lista<ItemProducao> itensProducao =  new lista<>();

    private static ControleLoteDeProducao instancia;


    private ControleLoteDeProducao() {

    }

    public static ControleLoteDeProducao getInstancia() {

        if(instancia == null) {

            instancia = new ControleLoteDeProducao();
        }

        return instancia;
    }



}
