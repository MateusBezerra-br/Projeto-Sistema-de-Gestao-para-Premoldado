package SistemaPremoldado.EstoqueDeMoldes;

import SistemaPremoldado.EstruturaDeDados.Node;
import SistemaPremoldado.EstruturaDeDados.Lista;

public class EstoqueMolde extends Lista<ItemMolde> {

    private static EstoqueMolde instancia;



    private EstoqueMolde() {

    }

    public static EstoqueMolde getInstancia() {

        if(instancia == null) {

            instancia = new EstoqueMolde();
        }

        return instancia;
    }




    public void cadastrarMolde (ItemMolde itemMolde) {

        if(!moldeJaExiste(itemMolde)) {

            addData(itemMolde);
        }
        else{
            System.out.println("Ja existe molde com essas caracteristicas e nome cadastrado");
        }

    }

    public Boolean moldeJaExiste(ItemMolde itemMolde) {

        Node aux = this.begin;

        for(int i = 0; i  < retornarTamanho(); ){

            ItemMolde aux2 = (ItemMolde)aux.data;


            if(aux2.getMolde().getNome().equals(itemMolde.getMolde().getNome()) &&  aux2.getMolde().getCapacidade() == itemMolde.getMolde().getCapacidade() ){
                return true;
            }

            aux = procurarNode(i);

        }

        return false;
    }

    public void ocuparMoldes(){




    }




}
