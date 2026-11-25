package SistemaPremoldado.ControleDeCura;

import SistemaPremoldado.EstoqueDeMoldes.EstoqueMolde;
import SistemaPremoldado.EstoqueDeMoldes.Molde;
import SistemaPremoldado.GestaoDePedidos.Produtos.Produto;

import java.time.LocalDate;

public class CuraPosConvencional extends LoteEmCura{

    private EstoqueMolde estoqueMolde;
    private Molde moldeOcupado;
    private int quantidadeOcupadaDeMoldes;
    private statusDesmolde statusDeDesmolde ;
    private LocalDate tempoParaDesmoldePrevisto;
    private LocalDate dataDeDesmoldePrevisto;
    private LocalDate dataDeDesmolde;


    public CuraPosConvencional( Produto produto , int quantidade,  LocalDate dataDeDesmoldePrevisto, Molde moldeOcupado, EstoqueMolde estoqueMolde) {
        super( produto, quantidade);

        this.dataDeDesmoldePrevisto = dataDeDesmoldePrevisto;
        this.moldeOcupado = moldeOcupado;
        this.statusDeDesmolde = statusDesmolde.AGUARDANDO_DESMOLDE;
        this.estoqueMolde = estoqueMolde;

    }

    public enum statusDesmolde{

        AGUARDANDO_DESMOLDE,
        LOTE_DESMOLDADO

    }

    public void atualizarStatusDeDesmolde(statusDesmolde status){
        this.statusDeDesmolde = status;
    }


    public void desmoldarLote(){

        estoqueMolde.devolverMoldes(this.moldeOcupado, quantidadeOcupadaDeMoldes);
        this.dataDeDesmolde =  LocalDate.now();

    }




    @Override
    public boolean statusPermitido(statusCura status) {

        return status == statusCura.AGUARDANDO_INICIO ||
                status == statusCura.CURA_INICIAL ||
                status == statusCura.AGUARDANDO_DESFORMA ||
                status == statusCura.CURA_COMPLEMENTAR ||
                status == statusCura.CURA_CONCLUIDA ||
                status == statusCura.LIBERADO_PARA_ESTOQUE ||
                status == statusCura.CANCELADO;
    }






}
