package SistemaPremoldado.ControleDeVendas;

import SistemaPremoldado.EstruturaDeDados.Lista;
import SistemaPremoldado.EstoqueDePremoldados.EstoquePremoldado;
import SistemaPremoldado.ControleDePedidosProduzidos.ItemProduzido;

public class ControleVendas {

    private Lista<Venda> vendas;

    public ControleVendas() {
        this.vendas = new Lista<>();
    }

    
    public Venda criarVenda(Lista<ItemProduzido> itensSelecionados, EstoquePremoldado estoque, String dataVenda) {

        if (itensSelecionados == null ||
            itensSelecionados.retornarTamanho() == 0) {

            throw new IllegalArgumentException(
                "Selecione pelo menos um item produzido."
            );
        }

        if (estoque == null) {
            throw new IllegalArgumentException(
                "O estoque não pode ser nulo."
            );
        }

        
        for (int i = 0; i < itensSelecionados.retornarTamanho(); i++) {

            ItemProduzido item = (ItemProduzido)
                    itensSelecionados.procurarData(i);

            if (item == null) {
                throw new IllegalArgumentException(
                    "Item produzido inválido."
                );
            }

            if (item.isVendido()) {
                throw new IllegalArgumentException(
                    "Um dos itens selecionados já foi vendido."
                );
            }

            if (item.getProduto() == null) {
                throw new IllegalArgumentException(
                    "O item produzido não possui produto."
                );
            }

            
            for (int j = i + 1; j < itensSelecionados.retornarTamanho(); j++) {

                ItemProduzido outro = (ItemProduzido)
                        itensSelecionados.procurarData(j);

                if (item == outro) {
                    throw new IllegalArgumentException(
                        "O mesmo item foi selecionado mais de uma vez."
                    );
                }
            }
        }

        
        Venda venda = new Venda(dataVenda, "PENDENTE");

        
        for (int i = 0; i < itensSelecionados.retornarTamanho(); i++) {

            ItemProduzido item = (ItemProduzido)
                    itensSelecionados.procurarData(i);

            double preco = item.getProduto().getPrecoUnidade();

            ItemVenda itemVenda = new ItemVenda(
                1,
                preco,
                estoque,
                item
            );

            
            item.setItemVenda(itemVenda);

            
            venda.adicionarItemVenda(itemVenda);
        }

        
        vendas.addData(venda);

        
        for (int i = 0; i < itensSelecionados.retornarTamanho(); i++) {

            ItemProduzido item = (ItemProduzido)
                    itensSelecionados.procurarData(i);

            item.marcarComoVendido();
        }

        return venda;
    }

    
    public int quantidadeDeVendas() {
        return vendas.retornarTamanho();
    }

    
    public Venda consultarVenda(int indice) {
        if (indice < 0 || indice >= vendas.retornarTamanho()) {
            throw new IndexOutOfBoundsException(
                "Índice de venda inválido."
            );
        }

        return (Venda) vendas.procurarData(indice);
    }

    
    public Lista<Venda> getVendas() {
        return vendas;
    }
}