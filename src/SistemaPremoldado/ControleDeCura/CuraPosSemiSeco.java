package SistemaPremoldado.ControleDeCura;

import SistemaPremoldado.GestaoDePedidos.Produtos.Produto;

import java.time.LocalDate;

public class CuraPosSemiSeco extends LoteEmCura {


    @Override
    public boolean statusPermitido(statusCura status) {

        return status == statusCura.AGUARDANDO_INICIO ||
                status == statusCura.CURA_COMPLEMENTAR ||
                status == statusCura.CURA_CONCLUIDA ||
                status == statusCura.LIBERADO_PARA_ESTOQUE ||
                status == statusCura.CANCELADO;
    }

    public CuraPosSemiSeco( Produto produto, int quantidade, int quantidadeParaEstoque) {
        super(produto, quantidade, quantidadeParaEstoque);
    }






}
