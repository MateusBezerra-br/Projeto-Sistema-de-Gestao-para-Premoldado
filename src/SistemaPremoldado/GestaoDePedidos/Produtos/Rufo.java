package SistemaPremoldado.GestaoDePedidos.Produtos;

public class Rufo extends Produto {

    private String tipoMaterial;

    public Rufo(int id, String nome, double precoUnidade, String descricao, double comprimento, double largura, double altura, int tempoCura, String tipoMaterial) {
        super(id, nome, precoUnidade, descricao, comprimento, largura, altura, tempoCura);

        this.tipoMaterial = tipoMaterial;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }
}
