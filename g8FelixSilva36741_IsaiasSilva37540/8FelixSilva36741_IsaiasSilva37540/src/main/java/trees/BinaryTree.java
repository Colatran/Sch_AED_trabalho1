package trees;

public interface BinaryTree<E> extends Tree<E> {
    Position<E> left(Position<E> p);//devolve a posição do nodo esquerdo de p
    Position<E> right(Position<E> p);//devolve a posição do nodo direito de p
    Position<E> sibling(Position<E> p);//devolve a posição do nodo irmão de p
}
