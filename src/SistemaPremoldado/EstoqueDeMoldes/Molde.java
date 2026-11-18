package SistemaPremoldado.EstoqueDeMoldes;

import java.util.Objects;

public class Molde {

    private int id;
    private String nome;
    private Enum tipoDeMolde;
    private int capacidade;




    public Molde(int id, String nome, Enum tipoDeMolde, int capacidade) {
        this.id = id;
        this.nome = nome;
        this.tipoDeMolde = tipoDeMolde;
        this.capacidade = capacidade;
    }

    public void atualizarCapacidade(int capacidade) {

        this.capacidade = capacidade ;

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


    public enum getTipoDeMolde{

        moldeParaVibroCompressao,
        moldeDesmontavel,
        moldeFixo

    }

    @Override
    public String toString() {
        return getNome() ;
    }


}
