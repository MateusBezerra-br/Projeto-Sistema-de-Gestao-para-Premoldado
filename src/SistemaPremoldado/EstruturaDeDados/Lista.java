package SistemaPremoldado.EstruturaDeDados;

public class Lista<T>  {

    private Node<T> begin;
    private Node<T> end;

    public void addData(T data) {

        Node<T> novo = new Node<T>();
        novo.data = data;

        if (begin == null) {

            begin = novo;
            begin.next = begin;
            begin.back = begin;
            end = begin;

        } else {

            end.next = novo;
            novo.back = end;
            novo.next = begin;
            begin.back = novo;
            end = novo;

        }

    }

    public Node<T> getBegin() {
        return begin;
    }

    public void addBefore(Node<T> ref, T data) {

        Node<T> novo = new Node<T>();
        novo.data = data;

        novo.next = ref;
        novo.back = ref.back;
        ref.back.next = novo;
        ref.back = novo;

        if (ref == begin) {
            begin = novo;
        }

    }

    boolean isEmpty() {
        return this.begin == null;
    }

    public Node<T> procurarNode(int index) {

        Node<T> aux = this.begin;
        int contador = 0;

        if (index < 0) {

            while (contador != index) {
                aux = aux.back;
                contador--;
            }

        } else {

            while (contador != index) {
                aux = aux.next;
                contador++;
            }

        }

        return aux;

    }

    public Object procurarData(int index) {
        return procurarNode(index).data;
    }

    public void removeData(int index) {

        if (this.isEmpty()) {
            return;
        }

        Node<T> aux = procurarNode(index);

        if (aux.next == aux) {

            this.begin = null;
            this.end = null;
            aux.back = null;
            aux.next = null;
            aux.data = null;
            return;

        }

        aux.back.next = aux.next;
        aux.next.back = aux.back;

        if (aux == this.begin) {
            this.begin = aux.next;
        }

        if (aux == this.end) {
            this.end = aux.back;
        }

        aux.back = null;
        aux.next = null;
        aux.data = null;

    }



    public int retornarTamanho() {

        Node<T> aux = this.begin;
        int tamanho = 0;

        if (this.begin != null) {

            do {

                tamanho++;
                aux = aux.next;

            } while (aux != this.begin);

        }

        return tamanho;

    }

}
