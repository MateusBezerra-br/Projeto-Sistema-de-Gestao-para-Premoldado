package SistemaPremoldado.ControleDeCura;

import SistemaPremoldado.ControleDeProducao.LoteDeProducao;
import SistemaPremoldado.EstoqueDeMoldes.EstoqueMolde;
import SistemaPremoldado.EstruturaDeDados.Lista;

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







}
