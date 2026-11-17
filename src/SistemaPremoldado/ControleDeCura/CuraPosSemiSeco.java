package SistemaPremoldado.ControleDeCura;

import java.time.LocalDate;

public class CuraPosSemiSeco extends LoteEmCura {
    public CuraPosSemiSeco(int id, int quantidade, LocalDate dataIncioDeCura, LocalDate dataFinalizacaoDeCuraPrevista) {
        super(id, quantidade, dataIncioDeCura, dataFinalizacaoDeCuraPrevista);
    }
}
