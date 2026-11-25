package SistemaPremoldado.GestaoDePedidos.Produtos;

public class PisoEspecial extends Produto {

    private String tipo;

    public PisoEspecial(int id, String nome, double precoUnidade, String descricao, double comprimento, double largura, double altura, int tempoCura, String tipo) {
        super(id, nome, precoUnidade, descricao, comprimento, largura, altura, tempoCura);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
