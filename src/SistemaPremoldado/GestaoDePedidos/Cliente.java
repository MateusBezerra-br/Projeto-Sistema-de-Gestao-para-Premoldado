package SistemaPremoldado.GestaoDePedidos;

public class Cliente {
    private int id;
    private String nome;
    private String telefone;
    private String localDeEntrega;

    public Cliente(int id, String nome, String telefone, String localDeEntrega) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.localDeEntrega = localDeEntrega;
    }

    public void atualizarDados(String nome, String telefone, String localDeEntrega) {
        this.nome = nome;
        this.telefone = telefone;
        this.localDeEntrega = localDeEntrega;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getLocalDeEntrega() {
        return localDeEntrega;
    }
}
