package SistemaPremoldado.ControleDeProducao;

import SistemaPremoldado.EstoqueDeMoldes.EstoqueMolde;
import SistemaPremoldado.EstoqueDeMoldes.Molde;
import SistemaPremoldado.GestaoDePedidos.Produtos.Produto;

import java.time.LocalDate;

public class LoteDeProducao {


    public enum statusAtuais{

        AGUARDANDO_INICIIO_PRODUCAO,
        SENDO_PRODUZIDO,
        PASSOU_PARA_ETAPA_CURA

    }

    public enum metodoProducao{

        CONVENCIONAL,
        SEMISSECO_MANUAL,
        VIBROCOMPRESSAO

    }

    private EstoqueMolde estoqueMolde;
    private Molde moldeOcupado;
    private Produto produto;
    private int quantidade;
    private statusAtuais statusAtual;
    private metodoProducao metodoDeProducao;
    private LocalDate dataEmissaoDeProducao;
    private LocalDate dataPrevisaoIniciarProducao;
    private LocalDate dataInicioProducao;
    private MaquinaVibroCompressora maquinaVibroCompressora;



    LoteDeProducao(Produto produto,  int quantidade, metodoProducao metodoDeProducao, LocalDate dataPrevisaoIniciarProducao, Molde moldeOcupado) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.metodoDeProducao = metodoDeProducao;
        this.statusAtual = statusAtuais.AGUARDANDO_INICIIO_PRODUCAO;
        this.dataEmissaoDeProducao = LocalDate.now();
        this.moldeOcupado = moldeOcupado;
    }

    public void setMaquinaVibroCompressora(MaquinaVibroCompressora maquinaVibroCompressora) {
        this.maquinaVibroCompressora = maquinaVibroCompressora;
    }

    public MaquinaVibroCompressora getMaquinaVibroCompressora() {
        return maquinaVibroCompressora;
    }

    public void iniciarProducao(){

        this.statusAtual = statusAtuais.SENDO_PRODUZIDO;
        this.dataInicioProducao = LocalDate.now();
    }

    public void finalizarProducao(){
        this.statusAtual = statusAtuais.PASSOU_PARA_ETAPA_CURA;
    }




    public metodoProducao getMetodoDeProducao() {
        return metodoDeProducao;
    }

    public void setMetodoDeProducao(metodoProducao metodoDeProducao) {
        this.metodoDeProducao = metodoDeProducao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Molde getMoldeOcupado() {
        return moldeOcupado;
    }

    public void setMoldeOcupado(Molde moldeOcupado) {
        this.moldeOcupado = moldeOcupado;
    }

    public EstoqueMolde getEstoqueMolde() {
        return estoqueMolde;
    }

    public void setEstoqueMolde(EstoqueMolde estoqueMolde) {
        this.estoqueMolde = estoqueMolde;
    }
}
