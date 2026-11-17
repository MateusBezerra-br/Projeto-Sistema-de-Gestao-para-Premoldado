package SistemaPremoldado.ControleDeCura;

import java.time.LocalDate;

public class CuraPosConvencional extends LoteEmCura{


    private LocalDate tempoParaDesmoldePrevisto;
    private LocalDate dataDeDesmoldePrevisto;
    private LocalDate dataDeDesmolde;

    public CuraPosConvencional(int id, int quantidade, LocalDate dataIncioDeCura, LocalDate dataFinalizacaoDeCuraPrevista, LocalDate dataDeDesmoldePrevista, LocalDate dataDeDesmolde) {
        super(id, quantidade, dataIncioDeCura, dataFinalizacaoDeCuraPrevista);

        this.dataDeDesmoldePrevisto = dataDeDesmoldePrevisto;
    }


}
