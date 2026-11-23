package SistemaPremoldado.GestaoDePedidos.Produtos;

public class Produto {
    private int id;
    private String nome;
    private double precoUnidade;
    private String descricao;
    private double comprimento;
    private double largura;
    private double altura;
    private int tempoCura;

    public Produto(int id, String nome, double precoUnidade, String descricao, double comprimento, double largura, double altura, int tempoCura) {
        this.id = id;
        this.nome = nome;
        this.precoUnidade = precoUnidade;
        this.descricao = descricao;
        this.comprimento = comprimento;
        this.largura = largura;
        this.altura = altura;
        this.tempoCura = tempoCura;
    }

    public void atualizaPreco(double novoPreco) {
        this.precoUnidade = novoPreco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoUnidade() {
        return precoUnidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getComprimento() {
        return comprimento;
    }

    public double getLargura() {
        return largura;
    }

    public double getAltura() {
        return altura;
    }

    public int getTempoCura() {
        return tempoCura;
    }
}
