package SistemaPremoldado.Estoque;

public class MateriaPrima {
    private String nome;
    private String descrição;

    public MateriaPrima(String nome, String descricao) {
        this.nome = nome;
        this.descrição = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descrição;
    }
}
