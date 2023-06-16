package trees;

/** Concrete implementation of a binary tree using a node-based, linked structure. */
public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
    
    //---------------- nested Node class ----------------
    protected static class Node<E> implements Position<E>{ // tipo de nodo a usar
        private E element; // an element stored at this node
        private Node<E> parent; // a reference to the parent node (if any)
        private Node<E> left; // a reference to the left child (if any)
        private Node<E> right; // a reference to the right child (if any)

        /** Constructs a node with the given element and neighbours. */
        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }

        // accessor methods
        public E getElement( ) { return element; }
        public Node<E> getParent( ) { return parent; }
        public Node<E> getLeft( ) { return left; }
        public Node<E> getRight( ) { return right; }

        // update methods
        public void setElement(E e) { element = e; }
        public void setParent(Node<E> parentNode) { parent = parentNode; }
        public void setLeft(Node<E> leftChild) { left = leftChild; }
        public void setRight(Node<E> rightChild) { right = rightChild; }
    } //----------- end of nested Node class -----------
    
    protected Node<E> root = null; // root of the tree
    private int size = 0; // number of nodes in the tree
    
    /** Método auxiliar que converte uma posição num nodo (down cast). */
    protected Node<E> node(Position<E> p){
        if (!(p instanceof Node))
        throw new IllegalArgumentException("Tipo de posição inválido!");
        return (Node<E>) p; // safe cast
    }
    
    // accessor methods (not already implemented in AbstractBinaryTree)
    public int size( ) { return size; }
    public Position<E> root( ) { return root; }//implicit up cast (from Node to Position)
    
    /** Returns the node of p's parent (or null if p is root). */
    public Position<E> parent(Position<E> p) {return node(p).getParent( ); }
    /** Returns the node of p's left child (or null if no child exists). */
    public Position<E> left(Position<E> p) {return node(p).getLeft( );}
    /** Returns the node of p's right child (or null if no child exists). */
    public Position<E> right(Position<E> p) {return node(p).getRight( );}
    // update methods supported by this class
    
    /** Places element e at the root of an empty tree and returns new node. */
    public Position<E> addRoot(E e){
        if (!isEmpty( )) return null;
        root = new Node<E>(e, null, null, null);
        size = 1;
        return root;
    }
    
    /** Creates a new left child of node p storing element e; returns new node. */
    public Position<E> addLeft(Position<E> p, E e){
        Node<E> n = node(p);
        if (n.getLeft( ) != null) return null;
        Node<E> child = new Node<E>(e, n, null, null);
        n.setLeft(child);
        size++;
        return child;
    } 
    
    /** Creates a new right child of node p storing element e; returns new node. */
    public Position<E> addRight(Position<E> p, E e){
        Node<E> n = node(p);
        if (n.getRight( ) != null) return null;
        Node<E> child = new Node<E>(e, n, null, null);
        n.setRight(child);
        size++;
        return child;
    }
    
    /** Replaces the element at node p with e and returns the replaced element. */
    public E set(Position<E> p, E e){
        Node<E> n = node(p);
        E temp = n.getElement( );
        n.setElement(e);
        return temp;
    }
    
    /** Removes the node p and replaces it with its child, if any. */
    public E remove(Position<E> p) {
        if (numChildren(p) == 2) return null;//não se remove o nodo se tiver 2 filhos
        Node<E> n = node(p);
        Node<E> parent = n.getParent( );
        Node<E> child = (n.getLeft( ) != null ? n.getLeft( ) : n.getRight( ) );
        if (child != null) child.setParent(parent); // child’s grandparent
        // becomes its parent
        if (n == root) root = child; // child becomes root
        else
        if (n == parent.getLeft( )) parent.setLeft(child);
        else parent.setRight(child);
        size--;
        E temp = n.getElement( );
        n.setElement(null); // help garbage collection
        n.setLeft(null); //para perder a ligação à árvore
        n.setRight(null); //para perder a ligação à árvore
        n.setParent(null); //para perder a ligação à árvore
        return temp;
    }
}