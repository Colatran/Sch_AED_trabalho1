package trees;

/** An interface for a tree where nodes can have an arbitrary number of children.
 * @param <E> */
public interface Tree<E> extends Iterable<E> {
    Position<E> root(); //devolve a posição do nodo raiz
    Position<E> parent(Position<E> p); //devolve a posição do nodo ascendente de p
    Iterable<Position<E>> children(Position<E> p); //returns an iterable collection
    //of the positions representing p's children
    int numChildren(Position<E> p); //devolve nº de nodos descendentes de p
    boolean isInternal(Position<E> p); //verifica se p é nodo interno (não folha)
    boolean isExternal(Position<E> p); //verifica se p é nodo externo (folha)
    boolean isRoot(Position<E> p); //verifica se a posição p é nodo raiz
    int size(); //devolve nº total de nodos
    boolean isEmpty(); //verifica se não existem nodos
    Iterable<Position<E>> positions(); //devolve uma coleção iterável contendo todas as posições
}

