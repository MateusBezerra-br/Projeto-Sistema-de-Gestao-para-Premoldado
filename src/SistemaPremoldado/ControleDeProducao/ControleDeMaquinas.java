package SistemaPremoldado.ControleDeProducao;

import SistemaPremoldado.EstoqueDeMoldes.EstoqueMolde;
import SistemaPremoldado.EstoqueDeMoldes.ItemMolde;
import SistemaPremoldado.EstoqueDeMoldes.Molde;
import SistemaPremoldado.EstruturaDeDados.Node;
import SistemaPremoldado.EstruturaDeDados.lista;

public class ControleDeMaquinas extends lista<MaquinaVibroCompressora> {


    EstoqueMolde  estoqueMolde;

    private static ControleDeMaquinas  instancia;

    ControleDeMaquinas(){


    }

    public static ControleDeMaquinas getIntancia(){

        if(instancia == null){
             instancia = new ControleDeMaquinas();
        }

        return instancia;
    }



    public void cadastrarNovaMaquina(MaquinaVibroCompressora novaMaquina){

        instancia.cadastrarNovaMaquina(novaMaquina);
    }


    public void verificarStatusMaquinas(){

        Node<MaquinaVibroCompressora> aux = getBegin();

        for(int i = 0; i  < retornarTamanho(); ){

            MaquinaVibroCompressora aux2 = aux.data;

            System.out.println(aux2);

            aux = procurarNode(i);

        }


    }

    public void colocarMoldeEmMaquina(Molde molde, String nome){

        retirarMoldeEmMaquina(molde, nome);

       MaquinaVibroCompressora maquinaVibroCompressora = encontrarMaquina(nome);

       estoqueMolde.retirarMoldes(molde,1);


    }

    public void retirarMoldeEmMaquina(Molde molde, String nome){

        MaquinaVibroCompressora maquinaVibroCompressora = encontrarMaquina(nome);

        estoqueMolde.devolverMoldes(maquinaVibroCompressora.getMoldeInstalado(), 1);


        maquinaVibroCompressora.setStatusDeFuncionamento(MaquinaVibroCompressora.statusFuncionamento.MAQUINA_LIBERADA);
    }

    public MaquinaVibroCompressora encontrarMaquina(String nome){


        Node<MaquinaVibroCompressora> aux = getBegin();

        for(int i = 0; i  < retornarTamanho(); ){

            MaquinaVibroCompressora aux2 = aux.data;

            if(aux2.getNome().equals(nome)){

                return aux2;
            }

            aux = procurarNode(i);

        }

        return null;
    }

    public void ocuparMaquinaEmUmLote(String nome, LoteDeProducao loteDeProducao){


     MaquinaVibroCompressora maquinaVibroCompressora =  encontrarMaquina(nome);

     if(maquinaVibroCompressora.getStatusDeFuncionamento() != MaquinaVibroCompressora.statusFuncionamento.MAQUINA_OCUPADA && maquinaVibroCompressora.getMoldeInstalado().getProduto() == loteDeProducao.getProduto()) {

         maquinaVibroCompressora.setLoteAtribuido(loteDeProducao);

         maquinaVibroCompressora.setStatusDeFuncionamento(MaquinaVibroCompressora.statusFuncionamento.MAQUINA_OCUPADA);
     }
     else{
         System.out.println("maquina ocupada e/ou molde nao compativel");
     }

    }

    public void liberarMaquinaEmUmLote(String nome){


        MaquinaVibroCompressora maquinaVibroCompressora =  encontrarMaquina(nome);
            maquinaVibroCompressora.setStatusDeFuncionamento(MaquinaVibroCompressora.statusFuncionamento.MAQUINA_LIBERADA);
            maquinaVibroCompressora.setLoteAtribuido(null);

    }



    public EstoqueMolde getEstoqueMolde() {
        return estoqueMolde;
    }

    public void setEstoqueMolde(EstoqueMolde estoqueMolde) {
        this.estoqueMolde = estoqueMolde;
    }
}
