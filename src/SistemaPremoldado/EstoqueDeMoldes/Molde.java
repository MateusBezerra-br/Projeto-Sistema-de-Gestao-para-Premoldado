package SistemaPremoldado.EstoqueDeMoldes;

import SistemaPremoldado.GestaoDePedidos.Cliente;

import java.util.Objects;

public class Molde {

    private int id;
    private String nome;
    private TipoDeMolde tipoDeMolde;
    private int capacidade;




    public Molde(int id, String nome, TipoDeMolde tipoDeMolde, int capacidade) {
        this.id = id;
        this.nome = nome;
        this.tipoDeMolde = tipoDeMolde;
        this.capacidade = capacidade;
    }

    public void atualizarCapacidade(int capacidade) {

        this.capacidade = capacidade ;

    }

    public TipoDeMolde getTipoDeMolde() {
        return tipoDeMolde;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getNome() {
        return nome;
    }


    public enum TipoDeMolde{

        moldeParaVibroCompressao,
        moldeDesemissecoManual,
        moldeFixo

    }

    @Override
    public String toString() {
        return getNome() ;
    }


}
