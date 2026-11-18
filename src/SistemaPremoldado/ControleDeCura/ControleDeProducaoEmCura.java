package SistemaPremoldado.ControleDeCura;

import SistemaPremoldado.EstoqueDeMoldes.EstoqueMolde;

import SistemaPremoldado.EstruturaDeDados.lista;

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






}
