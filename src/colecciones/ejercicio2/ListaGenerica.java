package colecciones.ejercicio2;

import java.util.LinkedList;


public class ListaGenerica<T> {

    private LinkedList<T> lista;

    public ListaGenerica() {
        lista = new LinkedList<T>();
    }

    /**
     * Añade un elemento a la lista.
     * @param elemento
     */
    public void annadirElemento(T elemento) {
        lista.add(elemento);
    }
    /**
     * Devuelve una lista con los elementos de la lista hasta el elemento buscado (incluido).
     * @param elementoBuscado
     * @return listaHastaElemento
     */
    public ListaGenerica<T> listaHastaElemento(T elementoBuscado) {
        //Creamos una lista para almacenar los elementos de la lista hasta el elemento buscado.
        ListaGenerica<T> listaHastaElemento = new ListaGenerica<T>();
        //Recorremos la lista con un for each para poder acceder a los elementos de la lista.
        for (T elemento : lista) {
            //Añadimos los elementos a la lista hasta el elemento buscado.
            listaHastaElemento.annadirElemento(elemento);
            //Si el elemento es igual al elemento buscado, devolvemos la lista hasta el elemento buscado.
            if (elemento.equals(elementoBuscado)) {
                //Devolvemos la lista hasta el elemento buscado.
                return listaHastaElemento;
            }
        }
        //Si no existe el elemento buscado, devolvemos null.
        return null;
    }

    @Override
    public String toString() {
        return "ListaGenerica=" + lista;
    }

    public static void main(String[] args) {
        //Creamos una lista de tipo String.
        ListaGenerica<String> lista = new ListaGenerica<String>();
        //Añadimos elementos a la lista.
        lista.annadirElemento("A");
        lista.annadirElemento("B");
        lista.annadirElemento("C");
        lista.annadirElemento("D");
        //Mostramos la lista.
        System.out.println(lista.listaHastaElemento("C"));
    }


}
