package set;

import java.util.Comparator;
import java.util.Iterator;
import trees.SearchBinaryTree;

public class TreeSet<E extends Comparable<E>> implements SortedSet<E> {
    
    private final SearchBinaryTree<E> tree; 

    public TreeSet() {
        tree = new SearchBinaryTree<>();
    }
    
    @Override
    public SortedSet<E> subSet(E fromElement, E toElement){
        SortedSet<E> set = new TreeSet();
        if((contains(fromElement) && contains(fromElement))) {
            boolean start = false;
            Iterator<E> it = iterator();

            while (it.hasNext()) {
                E elem = it.next();
                if(start) {
                    if(elem == toElement) break;
                    set.add(elem);
                }
                else if(elem == fromElement) {
                    set.add(elem);
                    start = true;
                }
            }
        }
        return set;
    }
    @Override
    public SortedSet<E> headSet(E toElement) { 
        return subSet(tree.root().getElement(), toElement);
    }
    @Override
    public SortedSet<E> tailSet(E fromElement) { 
        return subSet(fromElement, tree.root().getElement());
    }
    
    private class Comparador implements Comparator<E>{
        @Override
        public int compare(E o1, E o2) { 
            return o1.compareTo(o2);
        }
    }
    
    @Override
    public E min() { 
        Comparador comp = new Comparador();
        E min = null;
        for (E e : tree) {
            if (min == null) min = e;
            else if(comp.compare(e, min) < 0) min = e;
        }
        return min;
    }
    @Override
    public E max() {
        Comparador comp = new Comparador();
        E max = null;
        for (E e : tree) {
            if (max == null) max = e;
            else if(comp.compare(e, max) > 0) max = e;
        }
        return max;
    }
    
    @Override
    public int size() { 
        return tree.size();
    }
    @Override
    public boolean isEmpty() { 
        return size() == 0;
    }
    
    @Override
    public boolean contains(E e) {
        return tree.find(e) != null;
    }
    @Override
    public boolean add(E e) { 
        if (contains(e)) return false;
        else return tree.put(e) == null;
    }
    @Override
    public boolean remove(E e) { 
        if (!contains(e)) return false;
        else return tree.remove(e) != null;
    }
    
    @Override
    public boolean containsAll(SortedSet<E> s) {
        if(s.isEmpty()) return true;
        Iterator<E> it = s.iterator();
        
        while (it.hasNext()) {
            if(!contains(it.next())) return false;
        }
        return true;
    }
    @Override
    public void addAll(SortedSet<E> s) {
        Iterator<E> it = s.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }
    @Override
    public void removeAll(SortedSet<E> s) {
        Iterator<E> it = s.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }
    @Override
    public void retainAll(SortedSet<E> s) {
        SortedSet<E> toRemove = new TreeSet<>();
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            E e = it.next();
            if (!s.contains(e)) toRemove.add(e);
        }
        removeAll(toRemove);
    }
    @Override
    public void clear() {
        removeAll(clone());
    }

    @Override
    public String toString() {
        if(isEmpty()) return "Valores: Vazia;";
        else {
            Iterator<E> it = iterator();
            String string = "Valores: " + it.next().toString();
            while (it.hasNext()) {
                string += ", " + it.next().toString();
            }
            return string + ";";
        }
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override
    public SortedSet<E> clone() {
        SortedSet<E> clone = new TreeSet();
        clone.addAll(this);
        return clone;
    }

    @Override
    public Iterator<E> iterator() {
        return tree.iterator();
    }
}
