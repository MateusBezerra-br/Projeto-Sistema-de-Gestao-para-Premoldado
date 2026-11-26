package SistemaPremoldado.GestaoDePedidos;

import SistemaPremoldado.EstruturaDeDados.Lista;

public class ListaDeClientes {

    private Lista<Cliente> listaDeClientes;
    private static ListaDeClientes instancia;

    private ListaDeClientes() {
        this.listaDeClientes = new Lista<>();
    }

    public static ListaDeClientes getInstancia() {
        if (instancia == null) {
            instancia = new ListaDeClientes();
        }
        return instancia;
    }

    public void cadastrarCliente(Cliente cliente) {
        listaDeClientes.addData(cliente);
    }

    public void removerCliente(int index) {
        listaDeClientes.removeData(index);
    }

    public Cliente consultarCliente(int index) {
        return (Cliente) listaDeClientes.procurarData(index);
    }

    public int retornarQuantidade() {
        return listaDeClientes.retornarTamanho();
    }


}