package SistemaPremoldado.ControleDeProducao;

import SistemaPremoldado.EstoqueDeMoldes.EstoqueMolde;
import SistemaPremoldado.EstoqueDeMoldes.Molde;

public class MaquinaVibroCompressora {


    private int id;
    private String nome;
    private statusFuncionamento statusDeFuncionamento;
    private Molde moldeInstalado;
    private LoteDeProducao LoteAtribuido;

    public  enum statusFuncionamento{

        MAQUINA_OCUPADA,
        MAQUINA_LIBERADA,

    }


    public MaquinaVibroCompressora(String nome, Molde moldeInstalado) {
        this.nome = nome;
        this.moldeInstalado = moldeInstalado;
        this.statusDeFuncionamento = statusFuncionamento.MAQUINA_LIBERADA;
    }


    public void retirarMatrizDaMaquina(){


    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Molde getMoldeInstalado() {
        return moldeInstalado;
    }

    public void setMoldeInstalado(Molde moldeInstalado) {
        this.moldeInstalado = moldeInstalado;
    }

    public statusFuncionamento getStatusDeFuncionamento() {
        return statusDeFuncionamento;
    }

    public void setStatusDeFuncionamento(statusFuncionamento statusDeFuncionamento) {
        this.statusDeFuncionamento = statusDeFuncionamento;
    }

    public LoteDeProducao getLoteAtribuido() {
        return LoteAtribuido;
    }

    public void setLoteAtribuido(LoteDeProducao loteAtribuido) {
        LoteAtribuido = loteAtribuido;
    }

    @Override
    public String toString(){
        return nome + statusDeFuncionamento +  moldeInstalado ;
    }



}
