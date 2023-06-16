package trees;

/**Definição duma Árvore Binária Pesquisa por derivação da classe LinkedBinaryTree.*/
public class SearchBinaryTree<E extends Comparable<E>> extends LinkedBinaryTree<E>{
    // Segue-se um conj. de operações herdadas que não devem ser permitidas, pois não
    // asseguram a organização específica duma ABP. Opta-se por sobrepor o compor-
    // tamento herdado dessas operações pelo lançamento de uma exceção adequada.
    public Position<E> addRoot(E e){
        throw new UnsupportedOperationException("Operação não permitida numa ABP");
    }
    public Position<E> addLeft(Position<E> p, E e){
        throw new UnsupportedOperationException("Operação não permitida numa ABP");
    }
    public Position<E> addRight(Position<E> p, E e){
        throw new UnsupportedOperationException("Operação não permitida numa ABP");
    }
    public E set(Position<E> p, E e){
        throw new UnsupportedOperationException("Operação não permitida numa ABP");
    }
    
    // Método auxiliar que compara um elemento 'e' com um nodo 'n'.
    private int compEN(E e, Node<E> n){ return e.compareTo(n.getElement());}

    /** Insere o elemento 'e' na árvore. */
    public E put(E e){ //devolve o elemento substituído, caso já exista um igual
        if(isEmpty()) {
            super.addRoot(e);
            return null;
        } else return put(root,e); //invoca o método recursivo
    }
    
    //Método auxiliar recursivo que insere o elemento 'e' na subárvore iniciada em 'n'
    private E put(Node<E> n, E e){
        E res=null;
        if(compEN(e,n)==0){ //substitui o elemento
            res=n.getElement();
            n.setElement(e);
        }else
            if(compEN(e,n)<0){ //insere à esquerda
                if(left(n)==null) super.addLeft(n,e); //acrescenta filho à esquerda
                else res=put(n.getLeft(),e); //manda inserir na subárvore esquerda
            }else{ //insere à direita
                if(right(n)==null) super.addRight(n,e); // acrescenta filho à direita
                else res=put(n.getRight(),e); //manda inserir na subárvore direita
            }
        return res;
    }
    
    private Node<E> minNode(Node<E> n) { //Devolve o nodo com o menor dos elementos
        if (n.getLeft()==null) return n; //da subárvore iniciada no nodo 'n'.
        else return minNode(n.getLeft());
    }
    
    private E remove(Node<E> n, E e){ //Método auxiliar recursivo que remove o
        if(n==null) return null; //elemento 'e' da subárvore iniciada em 'n'.
        else if(compEN(e,n)<0) return remove(n.getLeft(),e);
        else if(compEN(e,n)>0) return remove(n.getRight(),e);
        else //'n' é o nodo a remover
        if(numChildren(n)<2) return super.remove(n);//invoca-se o remove() herdado
        else{ //n tem dois filhos
            Node<E> min=minNode(n.getRight()); //Copia para o nodo 'n' o menor
            n.setElement(min.getElement()); //elemento da subárvore direita.
            return super.remove(min);//Apaga o nodo com o menor elemento.
            //Como não tem filho à esq. pode ser apagado com o remove() herdado.
        }
    }
    
    /** Remove da árvore o elemento 'e'. */
    public E remove(E e){
        return remove(root,e); //invoca o método recursivo
    }
    
    // Método auxiliar recursivo que procura o nodo com o elemento 'e' na subárvore
    // iniciada em 'n'.
    private Node<E> find(Node<E> n, E e){
        if(n==null) return null;
        else if(compEN(e,n)==0) return n;
        else if(compEN(e,n)<0) return find(n.getLeft(),e);
        else return find(n.getRight(),e);
    }
    
    /** Procura a posição da árvore que contém o elemento 'e'. */
    public Position<E> find(E e){ //devolve a posição do nodo com o elemento 'e'
        return find(root,e); //invoca o método recursivo
    }
}