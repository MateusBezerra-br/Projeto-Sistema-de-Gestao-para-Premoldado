package SistemaPremoldado.ControleDeProducao;

import SistemaPremoldado.EstoqueDeMoldes.EstoqueMolde;
import SistemaPremoldado.EstoqueDeMoldes.Molde;
import SistemaPremoldado.EstruturaDeDados.lista;

public class ControleDeMaquinas extends lista<MaquinaVibroCompressora> {


    EstoqueMolde  estoqueMolde;

    private static ControleDeMaquinas  instancia;

    ControleDeMaquinas(){


    }

    public static ControleDeMaquinas getIntancia(){

        if(instancia == null){
             instancia = new ControleDeMaquinas();
        }

        return instancia;
    }






    public void cadastrarNovaMaquina(MaquinaVibroCompressora novaMaquina){

        instancia.cadastrarNovaMaquina(novaMaquina);
    }


    public void verificarStatusMaquinas(){



    }

    public void colocarMoldeEmMaquina(Molde molde){


    }


    public EstoqueMolde getEstoqueMolde() {
        return estoqueMolde;
    }

    public void setEstoqueMolde(EstoqueMolde estoqueMolde) {
        this.estoqueMolde = estoqueMolde;
    }
}
