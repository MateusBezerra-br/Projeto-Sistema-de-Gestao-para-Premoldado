package SistemaPremoldado.ControleDeCura;

import SistemaPremoldado.EstruturaDeDados.Lista;

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






}
