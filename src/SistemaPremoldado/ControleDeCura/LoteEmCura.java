package SistemaPremoldado.ControleDeCura;

import SistemaPremoldado.EstruturaDeDados.Lista;
import SistemaPremoldado.GestaoDePedidos.Cliente;
import SistemaPremoldado.GestaoDePedidos.Produtos.Produto;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;

public abstract class LoteEmCura {


    public enum statusCura {

        AGUARDANDO_INICIO,
        CURA_INICIAL,
        AGUARDANDO_DESFORMA,
        CURA_COMPLEMENTAR,
        CURA_CONCLUIDA,
        LIBERADO_PARA_ESTOQUE,
        CANCELADO

    }



    private Lista<Cliente> clientes ;
    private Produto produto;
   private int id;
   private int quantidade;
   private LocalDate dataIncioDeCura;
   private LocalDate dataFinalizacaoDeCuraPrevista;
   private LocalDate dataDeCuraFinalizada;
   private statusCura statusDeCura;
   private Boolean curaAtrasada =  Boolean.FALSE;
   private int quantidadeParaEstoque;

   public LoteEmCura(Produto produto, int quantidade, int quantidadeParaEstoque) {

       this.produto = produto;
       this.id = id;
       this.quantidade = quantidade;
       this.dataIncioDeCura = LocalDate.now();
       this.dataFinalizacaoDeCuraPrevista = LocalDate.now().plusDays(produto.getTempoCura());
       this.quantidadeParaEstoque = quantidadeParaEstoque;

   }

    public abstract boolean statusPermitido(statusCura status);

   public void atualizarStatusDeCura(statusCura statusDeCura) {
       this.statusDeCura = statusDeCura;
   }

   public void setDataDeCuraFinalizada() {
        this.dataDeCuraFinalizada = LocalDate.now();
   }



    public void alterarStatus(statusCura novoStatus) {

        if (!statusPermitido(novoStatus)) {
            throw new IllegalArgumentException(
                    "Status incompatível com o processo de cura."
            );
        }

        atualizarStatusDeCura(novoStatus);
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public statusCura getStatusDeCura() {
        return statusDeCura;
    }

    public void setStatusDeCura(statusCura statusDeCura) {
        this.statusDeCura = statusDeCura;
    }

    public Lista<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Lista<Cliente> clientes) {
        this.clientes = clientes;
    }

    public int getQuantidadeParaEstoque() {
        return quantidadeParaEstoque;
    }

    public void setQuantidadeParaEstoque(int quantidadeParaEstoque) {
        this.quantidadeParaEstoque = quantidadeParaEstoque;
    }

    @Override
    public String toString() {

       return "Id: "+ this.id + "\nproduto: " + this.produto + "\nquantidade: " + this.quantidade + "statusDeCura: " + this.statusDeCura;
    }
}
