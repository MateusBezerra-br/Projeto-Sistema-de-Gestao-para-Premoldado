package SistemaPremoldado.ControleDeCura;

import SistemaPremoldado.EstoqueDeMoldes.EstoqueMolde;
import SistemaPremoldado.EstoqueDeMoldes.Molde;

import java.time.LocalDate;

public class CuraPosConvencional extends LoteEmCura{

    private Molde moldeOcupado;
    private int quantidadeOcupadaDeMoldes;
    private statusDesmolde statusDeDesmolde ;
    private LocalDate tempoParaDesmoldePrevisto;
    private LocalDate dataDeDesmoldePrevisto;
    private LocalDate dataDeDesmolde;

    public CuraPosConvencional(int id, int quantidade, LocalDate dataIncioDeCura, LocalDate dataFinalizacaoDeCuraPrevista, LocalDate dataDeDesmoldePrevisto, LocalDate dataDeDesmolde, Molde moldeOcupado) {
        super(id, quantidade, dataIncioDeCura, dataFinalizacaoDeCuraPrevista);

        this.dataDeDesmoldePrevisto = dataDeDesmoldePrevisto;
        this.dataDeDesmolde = dataDeDesmolde;
        this.moldeOcupado = moldeOcupado;

    }

    public enum statusDesmolde{

        AGUARDANDO_DESMOLDE,
        LOTE_DESMOLDADO

    }

    public void atualizarStatusDeDesmolde(statusDesmolde status){
        this.statusDeDesmolde = status;
    }


    public void desmoldarLote(){





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
