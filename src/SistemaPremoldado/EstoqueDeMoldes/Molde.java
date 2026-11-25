package SistemaPremoldado.EstoqueDeMoldes;

import SistemaPremoldado.GestaoDePedidos.Cliente;
import SistemaPremoldado.GestaoDePedidos.Produtos.Produto;

import java.util.Objects;

public class Molde {

    public enum TipoDeMolde{

        moldeParaVibroCompressao,
        moldeDesemissecoManual,
        moldeFixo

    }



    private Produto produto;
    private int id;
    private String nome;
    private TipoDeMolde tipoDeMolde;
    private int capacidade;




    public Molde(int id,Produto produto , String nome, TipoDeMolde tipoDeMolde, int capacidade) {

        this.produto = produto;
        this.id = id;
        this.nome = nome;
        this.tipoDeMolde = tipoDeMolde;
        this.capacidade = capacidade;
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

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Produto getProduto() {
        return this.produto;
    }




    @Override
    public String toString() {
        return getNome() ;
    }


}
