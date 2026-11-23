package SistemaPremoldado.GestaoDePedidos.Produtos;

public class Intertravado extends Produto {
    private String formatoEncaixe;

    public Intertravado(int id, String nome, double precoUnidade, String descricao, double comprimento, double largura, double altura, int tempoCura, String formatoEncaixe) {
        super(id, nome, precoUnidade, descricao, comprimento, largura, altura, tempoCura);
        this.formatoEncaixe = formatoEncaixe;
    }

    public String getFormatoEncaixe() {
        return formatoEncaixe;
    }
}
