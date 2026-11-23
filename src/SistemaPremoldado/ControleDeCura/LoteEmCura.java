package SistemaPremoldado.ControleDeCura;

import SistemaPremoldado.GestaoDePedidos.Cliente;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;

public abstract class LoteEmCura {


   private int id;
   private int quantidade;
   private LocalDate dataIncioDeCura;
   private LocalDate dataFinalizacaoDeCuraPrevista;
   private LocalDate dataDeCuraFinalizada;
   private statusCura statusDeCura;
   private Boolean curaAtrasada =  Boolean.FALSE;

   public LoteEmCura(int id,int quantidade,LocalDate dataIncioDeCura, LocalDate dataFinalizacaoDeCuraPrevista) {

       this.id = id;
       this.quantidade = quantidade;
       this.dataIncioDeCura = dataIncioDeCura;
       this.dataFinalizacaoDeCuraPrevista = dataFinalizacaoDeCuraPrevista;

   }

   public void atualizarStatusDeCura(statusCura statusDeCura) {
       this.statusDeCura = statusDeCura;
   }

   public void setDataDeCuraFinalizada() {
        this.dataDeCuraFinalizada = LocalDate.now();
   }

    public enum statusCura {

        AGUARDANDO_INICIO,
        CURA_INICIAL,
        AGUARDANDO_DESFORMA,
        CURA_COMPLEMENTAR,
        CURA_CONCLUIDA,
        LIBERADO_PARA_ESTOQUE,
        CANCELADO

    }

    public abstract boolean statusPermitido(statusCura status);

    public void alterarStatus(statusCura novoStatus) {

        if (!statusPermitido(novoStatus)) {
            throw new IllegalArgumentException(
                    "Status incompatível com o processo de cura."
            );
        }

        atualizarStatusDeCura(novoStatus);
    }





}
