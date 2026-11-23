package SistemaPremoldado.ControleDeCura;

import java.time.LocalDate;

public class CuraPosSemiSeco extends LoteEmCura {



    public CuraPosSemiSeco(int id, int quantidade, LocalDate dataIncioDeCura, LocalDate dataFinalizacaoDeCuraPrevista) {
        super(id, quantidade, dataIncioDeCura, dataFinalizacaoDeCuraPrevista);
    }



    @Override
    public boolean statusPermitido(statusCura status) {

        return status == statusCura.AGUARDANDO_INICIO ||
                status == statusCura.CURA_COMPLEMENTAR ||
                status == statusCura.CURA_CONCLUIDA ||
                status == statusCura.LIBERADO_PARA_ESTOQUE ||
                status == statusCura.CANCELADO;
    }


}
