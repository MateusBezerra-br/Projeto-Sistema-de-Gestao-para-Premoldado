package SistemaPremoldado.ControleDeCura;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;

public class LoteEmCura {


   private int id;
   private int quantidade;
   private LocalDate dataIncioDeCura;
   private LocalDate dataFinalizacaoDeCuraPrevista;
   private LocalDate dataDeCuraFinalizada;
   private String statusDeCura;
   private Boolean curaAtrasada =  Boolean.FALSE;

   public LoteEmCura(int id,int quantidade,LocalDate dataIncioDeCura, LocalDate dataFinalizacaoDeCuraPrevista) {

       this.id = id;
       this.quantidade = quantidade;
       this.dataIncioDeCura = dataIncioDeCura;
       this.dataFinalizacaoDeCuraPrevista = dataFinalizacaoDeCuraPrevista;

   }

   public void atualizaStatusDeCura(String statusDeCura) {
       this.statusDeCura = statusDeCura;
   }

   public void setDataDeCuraFinalizada() {
        this.dataDeCuraFinalizada = LocalDate.now();
   }




}
