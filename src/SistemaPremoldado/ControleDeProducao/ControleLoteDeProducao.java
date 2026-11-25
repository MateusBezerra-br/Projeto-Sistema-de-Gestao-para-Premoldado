package SistemaPremoldado.ControleDeProducao;

import SistemaPremoldado.EstruturaDeDados.Lista;

public class ControleLoteDeProducao extends Lista<LoteDeProducao> {

    Lista<ItemProducao> itensProducao =  new Lista<>();

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
