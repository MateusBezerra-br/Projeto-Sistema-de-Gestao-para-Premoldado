package SistemaPremoldado.ControleDeProducao;

import SistemaPremoldado.ControleDeCura.ControleDeProducaoEmCura;
import SistemaPremoldado.Estoque.EstoqueMateriaPrima;
import SistemaPremoldado.EstoqueDeMoldes.EstoqueMolde;
import SistemaPremoldado.EstoqueDeMoldes.ItemMolde;
import SistemaPremoldado.EstoqueDeMoldes.Molde;
import SistemaPremoldado.EstruturaDeDados.Lista;
import SistemaPremoldado.GestaoDePedidos.ItemPedido;
import SistemaPremoldado.GestaoDePedidos.Pedido;

public class ControleLoteDeProducao extends Lista<LoteDeProducao> {

    Lista<ItemProducao> itensProducao =  new Lista<>();
    private EstoqueMolde estoqueMolde;

    private static ControleLoteDeProducao instancia;

    private ControleLoteDeProducao() {

    }

    public static ControleLoteDeProducao getInstancia() {

        if(instancia == null) {

            instancia = new ControleLoteDeProducao();
        }

        return instancia;
    }



    public void mandarPedidoParaEtapaProducao(Pedido pedido) {

        for(int i = 0 ; i < pedido.getItensPedido().retornarTamanho();){

          ItemPedido itemPedido = (ItemPedido) pedido.getItensPedido().procurarData(i);

          ItemProducao novoItemProducao = new ItemProducao(itemPedido.getId(),itemPedido.getCliente(), itemPedido.getQuantidade(), itemPedido.getProduto());
         itensProducao.addData(novoItemProducao);
        }


    }


    public void EmitirLoteDeProducao(LoteDeProducao novoloteDeProducao) {

        addData(novoloteDeProducao);
    }

    public void visualizarItensProducoes(){

        for(int i = 0; i < getInstancia().itensProducao.retornarTamanho();i++){

            System.out.println( getInstancia().itensProducao.procurarData(i));

        }
    }

    public void consultarStatusDeMaquinas(){


            ControleDeMaquinas.getIntancia().verificarStatusMaquinas();

    }





    public void iniciarProducao(LoteDeProducao lote) {

        if (lote == null) {
            System.out.println("Lote inválido.");
            return;
        }

        String problemas = "";

        if (lote.getStatusAtual() != LoteDeProducao.statusAtuais.AGUARDANDO_INICIIO_PRODUCAO) {
            System.out.println("O lote não está aguardando o início da produção.");
            return;
        }

        if (lote.getMetodoDeProducao() == LoteDeProducao.metodoProducao.CONVENCIONAL) {

            problemas += verificarMoldesConvencionais(lote);

        } else if (lote.getMetodoDeProducao() == LoteDeProducao.metodoProducao.SEMISSECO_MANUAL) {

            problemas += verificarMoldesSemisseco(lote);

        } else if (lote.getMetodoDeProducao() == LoteDeProducao.metodoProducao.VIBROCOMPRESSAO) {

            problemas += verificarMaquinaVibrocompressao(lote);

        }

        problemas += EstoqueMateriaPrima.getInstancia().verificarMateriaPrima(lote);

        if (!problemas.isEmpty()) {
            System.out.println("Não foi possível iniciar a produção:");
            System.out.println(problemas);
            return;
        }

        reservarRecursos(lote);

        lote.iniciarProducao();

        System.out.println("Produção iniciada com sucesso!");
    }


    private String verificarMaquinaVibrocompressao(LoteDeProducao lote) {

        MaquinaVibroCompressora maquina =
                ControleDeMaquinas.getIntancia().encontrarMaquinaDisponivelPara(lote);

        if (maquina == null) {
            return "- Não existe máquina liberada com molde de vibrocompressão compatível.\n";
        }

        return "";
    }

    private String verificarMoldesConvencionais(LoteDeProducao lote) {

        if (estoqueMolde == null) {
            return "- Estoque de moldes não foi definido.\n";
        }

        for (int i = 0; i < estoqueMolde.retornarTamanho(); i++) {

            ItemMolde item = (ItemMolde) estoqueMolde.procurarData(i);
            Molde molde = item.getMolde();

            if (molde.getTipoDeMolde() == Molde.TipoDeMolde.moldeFixo
                    && molde.getProduto().getId() == lote.getProduto().getId()) {

                if (molde.getCapacidade() <= 0) {
                    continue;
                }

                int necessario = (int) Math.ceil(
                        (double) lote.getQuantidade() / molde.getCapacidade()
                );

                if (item.getQuantidadeDisponivel() >= necessario) {
                    return "";
                }

                return "- Moldes convencionais insuficientes. Necessários: "
                        + necessario + "; disponíveis: "
                        + item.getQuantidadeDisponivel() + ".\n";
            }
        }

        return "- Não existe molde fixo cadastrado para esse produto.\n";
    }


    private String verificarMoldesSemisseco(LoteDeProducao lote) {

        if (estoqueMolde == null) {
            return "- Estoque de moldes não foi definido.\n";
        }

        for (int i = 0; i < estoqueMolde.retornarTamanho(); i++) {

            ItemMolde item = (ItemMolde) estoqueMolde.procurarData(i);
            Molde molde = item.getMolde();

            if (molde.getTipoDeMolde() == Molde.TipoDeMolde.moldeDesemissecoManual
                    && molde.getProduto().getId() == lote.getProduto().getId()) {

                if (item.getQuantidadeDisponivel() >= 1) {
                    return "";
                }

                return "- Não há moldes semisseco disponíveis.\n";
            }
        }

        return "- Não existe molde semisseco cadastrado para esse produto.\n";
    }







    private void reservarRecursos(LoteDeProducao lote) {

        if (lote.getMetodoDeProducao() == LoteDeProducao.metodoProducao.CONVENCIONAL) {

            for (int i = 0; i < estoqueMolde.retornarTamanho(); i++) {

                ItemMolde item = (ItemMolde) estoqueMolde.procurarData(i);
                Molde molde = item.getMolde();

                if (molde.getTipoDeMolde() == Molde.TipoDeMolde.moldeFixo
                        && molde.getProduto().getId() == lote.getProduto().getId()) {

                    int quantidade = (int) Math.ceil(
                            (double) lote.getQuantidade() / molde.getCapacidade()
                    );

                    item.retirarMoldes(quantidade);
                    lote.setMoldeOcupado(molde);
                    break;
                }
            }

        } else if (lote.getMetodoDeProducao() == LoteDeProducao.metodoProducao.SEMISSECO_MANUAL) {

            for (int i = 0; i < estoqueMolde.retornarTamanho(); i++) {

                ItemMolde item = (ItemMolde) estoqueMolde.procurarData(i);
                Molde molde = item.getMolde();

                if (molde.getTipoDeMolde() == Molde.TipoDeMolde.moldeDesemissecoManual
                        && molde.getProduto().getId() == lote.getProduto().getId()) {

                    item.retirarMoldes(1);
                    lote.setMoldeOcupado(molde);
                    break;
                }
            }

        } else if (lote.getMetodoDeProducao() == LoteDeProducao.metodoProducao.VIBROCOMPRESSAO) {

            MaquinaVibroCompressora maquina =
                    ControleDeMaquinas.getIntancia().encontrarMaquinaDisponivelPara(lote);

            if (maquina != null) {
                maquina.setLoteAtribuido(lote);
                maquina.setStatusDeFuncionamento(
                        MaquinaVibroCompressora.statusFuncionamento.MAQUINA_OCUPADA
                );

                lote.setMaquinaVibroCompressora(maquina);
            }
        }

        EstoqueMateriaPrima.getInstancia().darBaixaMateriaPrima(lote);
    }

    public void mandarLoteParaEtapaDeCura(LoteDeProducao loteDeProducao) {

        if (loteDeProducao == null) {
            return;
        }

        if (loteDeProducao.getMetodoDeProducao()
                == LoteDeProducao.metodoProducao.SEMISSECO_MANUAL) {

            estoqueMolde.devolverMoldes(loteDeProducao.getMoldeOcupado(), 1);

        } else if (loteDeProducao.getMetodoDeProducao()
                == LoteDeProducao.metodoProducao.VIBROCOMPRESSAO) {

            MaquinaVibroCompressora maquina =
                    loteDeProducao.getMaquinaVibroCompressora();

            if (maquina != null) {
                maquina.setStatusDeFuncionamento(
                        MaquinaVibroCompressora.statusFuncionamento.MAQUINA_LIBERADA
                );

                maquina.setLoteAtribuido(null);
                loteDeProducao.setMaquinaVibroCompressora(null);
            }
        }

        loteDeProducao.finalizarProducao();

        ControleDeProducaoEmCura.getInstancia()
                .adicionarNovoLoteEmCura(loteDeProducao);
    }


    public void setEstoqueMolde(EstoqueMolde estoqueMolde) {
        this.estoqueMolde = estoqueMolde;
    }

}
