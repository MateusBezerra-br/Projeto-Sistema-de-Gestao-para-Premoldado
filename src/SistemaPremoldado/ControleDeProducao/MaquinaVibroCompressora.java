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
        MAQUINA_EM_TROCA_DE_MOLDE


    }


    public MaquinaVibroCompressora(String nome, Molde moldeInstalado,  LoteDeProducao LoteAtribuido) {
        this.nome = nome;
        this.moldeInstalado = moldeInstalado;
        this.statusDeFuncionamento = statusFuncionamento.MAQUINA_LIBERADA;
        this.LoteAtribuido = LoteAtribuido;
    }


    public void retirarMatrizDaMaquina(){


    }






}
