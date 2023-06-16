package trees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** An abstract base class providing some functionality of the Tree interface. */
public abstract class AbstractTree<E> implements Tree<E> {
    public boolean isInternal(Position<E> p) { return numChildren(p) > 0; }
    public boolean isExternal(Position<E> p) { return numChildren(p) == 0; }
    public boolean isRoot(Position<E> p) { return p == root( ); }
    public boolean isEmpty( ) { return size( ) == 0; }
    
    /** Adds nodes of the subtree rooted at node p to the given list. */
    private void subtreePositions (Position<E> p, List<Position<E>> list) {
        list.add(p); // for preorder, we add position p before exploring subtrees
        for (Position<E> c : children(p))
        subtreePositions(c, list);
    }
    
    /** Defining preorder as the default traversal algorithm for the positions() meth.
    * @return an iterable collection of positions of the tree.
    */
    public Iterable<Position<E>> positions( ) {
        List<Position<E>> list = new ArrayList<>( );
        if (!isEmpty( ))
        subtreePositions(root( ), list); // fill the list recursively
        return list;
    }
    
    /** Returns an iterator of the elements stored in the tree. */
    public Iterator<E> iterator( ) { return new ElementIterator( ); }
    
    //---------------- nested ElementIterator class ----------------
    
    /* This class adapts the iteration produced by positions() to return elements. */
    private class ElementIterator implements Iterator<E> {
        Iterable<Position<E>> snapshot = positions();
        Iterator<Position<E>> posIterator = snapshot.iterator( );
        public boolean hasNext( ) { return posIterator.hasNext( ); }
        public E next( ) { return posIterator.next( ).getElement( );}//return element
    }
}
