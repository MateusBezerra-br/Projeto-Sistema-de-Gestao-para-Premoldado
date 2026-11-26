package SistemaPremoldado.EstoqueDeMoldes;

import SistemaPremoldado.EstruturaDeDados.Node;
import SistemaPremoldado.EstruturaDeDados.Lista;


public class EstoqueMolde extends Lista<ItemMolde>{


    public void cadastrarMolde (Molde Molde, int quantidadeTotal ) {


        if(!moldeExiste(Molde)) {


            addData(new ItemMolde(Molde, quantidadeTotal));
        }
        else{
            System.out.println("Ja existe molde com essas caracteristicas e nome cadastrado");
        }

    }

    public void descadastrarMolde (Molde molde) {


        Node<ItemMolde> aux = getBegin();

        for(int i = 0; i  < retornarTamanho(); ){

            ItemMolde aux2 = aux.data;


            if(molde == aux2.getMolde() ){
                removeData(i);
            }

            aux = procurarNode(i);

        }


    }

    public Boolean moldeExiste(Molde moldeCandidatoCadastro) {

        return !(encontrarMolde(moldeCandidatoCadastro).getMolde() == null);
    }

    public ItemMolde encontrarMolde(Molde moldeAlvo) {

        Node<ItemMolde> aux = getBegin();

        for(int i = 0; i  < retornarTamanho(); ){

            ItemMolde aux2 = aux.data;


            if(caracteristicasMoldeIguais(aux2, moldeAlvo) ){
                return aux2;
            }

            aux = procurarNode(i);

        }

        return null;
    }

    public boolean caracteristicasMoldeIguais(ItemMolde existente, Molde novo){

        return  existente.getMolde().getNome().equals(novo.getNome()) &&
                existente.getMolde().getCapacidade() == novo.getCapacidade() &&
                existente.getMolde().getTipoDeMolde() == novo.getTipoDeMolde() &&
                existente.getMolde().getProduto().equals(novo.getProduto()) &&
                existente.getMolde().getTipoDeMolde().equals(novo.getTipoDeMolde());

        }

    public void retirarMoldes(Molde molde, int quantidadeRetirar){


        encontrarMolde(molde).retirarMoldes(quantidadeRetirar);


    }

    public void devolverMoldes(Molde molde, int quantidadeDevolver){


        encontrarMolde(molde).devolverMoldes(quantidadeDevolver);



    }

    public boolean verificarDisponibilidade(Molde moldeVerificar, int quantidadeSolicitada){


      return  encontrarMolde(moldeVerificar).getQuantidadeDisponivel() == quantidadeSolicitada;

    }


}
