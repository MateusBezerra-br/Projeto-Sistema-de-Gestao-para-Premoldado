package SistemaPremoldado.EstoqueDeMoldes;

import SistemaPremoldado.EstruturaDeDados.Node;
import SistemaPremoldado.EstruturaDeDados.lista;


public class EstoqueMolde extends lista<ItemMolde>{

    private static EstoqueMolde instancia;

    private EstoqueMolde() {

    }

    public static EstoqueMolde getInstancia() {

        if(instancia == null) {

            instancia = new EstoqueMolde();
        }

        return instancia;
    }






    public void cadastrarMolde (Molde Molde, int quantidadeTotal ) {


        if(!moldeExiste(Molde)) {


            addData(new ItemMolde(Molde, quantidadeTotal));
        }
        else{
            System.out.println("Ja existe molde com essas caracteristicas e nome cadastrado");
        }

    }




    public Boolean moldeExiste(Molde moldeSolicitado) {

        return !(null == encontrarMolde(moldeSolicitado).getMolde());
    }

    public ItemMolde encontrarMolde(Molde MoldeSolicitado) {

        Node<ItemMolde> aux = getBegin();

        for(int i = 0; i  < retornarTamanho(); ){

            ItemMolde aux2 = aux.data;


            if(aux2.getMolde().getNome().equals(MoldeSolicitado.getNome()) &&  aux2.getMolde().getCapacidade() == MoldeSolicitado.getCapacidade() && aux2.getMolde().getTipoDeMolde() == MoldeSolicitado.getTipoDeMolde() ){
                return aux2;
            }

            aux = procurarNode(i);

        }

        return null;
    }

    public void ocuparMoldes(Molde molde, int quantidadeOcupar){


        encontrarMolde(molde).ocuparMoldes(quantidadeOcupar);


    }

    public void desocuparMoldes(Molde molde, int quantidadeDesocupar){


        encontrarMolde(molde).desocuparMoldes(quantidadeDesocupar);



    }


    public void verificarDisponibilidade(Molde moldeVerificar){


        System.out.println( encontrarMolde(moldeVerificar).getQuantidadeDisponivel());

    }


}
