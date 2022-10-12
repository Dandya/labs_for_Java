import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class myList<Type> implements List {
    private static class Element<Type> {
        public Type value;
        public Element<Type> nextElement;

        public Element() {
        }

        public Element(Type elm) {
            this.value = elm;
        }
    }

    private class myIterator implements ListIterator<Type> {
        private myList<Type> list = null;
        private Element<Type> nextElm = null;
        private Element<Type> lastReturnedElm = null;
        private int indexOfElm = -1;

        public myIterator(){
        }

        public void setElements(Element<Type> elm, int index, myList<Type> list) {
            this.nextElm = elm;
            this.indexOfElm = index;
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return this.nextElm != null;
        }

        @Override
        public Type next() {
            Type tmp = this.nextElm.value;
            this.lastReturnedElm = this.nextElm;
            this.nextElm = this.nextElm.nextElement;
            this.indexOfElm++;
            return tmp;
        }

        @Override
        public boolean hasPrevious() {
            if(!nextElm.equals(list.firstElement)) {
                return true;
            }
            return false;
        }

        @Override
        public Type previous() {
            indexOfElm--;
            this.nextElm = list.getElm(indexOfElm);
            this.lastReturnedElm = this.nextElm;
            return this.nextElm.value;
        }

        @Override
        public int nextIndex() {
            return indexOfElm;
        }

        @Override
        public int previousIndex() {
            return indexOfElm-1;
        }

        @Override
        public void remove() {
        }

        @Override
        public void set(Type type) {
            this.lastReturnedElm.value = type;
        }

        @Override
        public void add(Type type) {
        }
    }

    private Element<Type> firstElement = null;
    private Element<Type> lastElement = null;
    private int size = 0;

    public myList() {
    }

    public myList(Type value) {
        firstElement = new Element<Type>(value);
        lastElement = firstElement;
        this.size++;
    }

    public myList(Type... vars) throws NullPointerException {
        if( vars == null ) {
            throw new NullPointerException();
        }
        for (Type value : vars) {
            this.push(value);
        }
    }

    public int size() {
        return this.size;
    }

    private Element<Type> getElm(int index) {
        Element<Type> tmpElement = firstElement;
        if (index >= this.size) {
            return null;
        }
        while (index-- > 0) {
            tmpElement = tmpElement.nextElement;
        }
        return tmpElement;
    }

    public Type get(int index) throws ArrayIndexOutOfBoundsException {
        if (index < 0 || index >= this.size) {
            throw new ArrayIndexOutOfBoundsException(String.format("Element with %d don't exist", index));
        }
        return getElm(index).value;
    }

    public void push(Type value) {
        if (firstElement == null) {
            firstElement = new Element<Type>(value);
            lastElement = firstElement;
            this.size++;
            return;
        }
        lastElement.nextElement = new Element<>();
        lastElement = lastElement.nextElement;
        lastElement.value = value;
        this.size++;
    }

    public void pushToBegin(Type value) {
        Element<Type> tmpElement = firstElement;
        firstElement = new Element<Type>(value);
        firstElement.nextElement = tmpElement;
        this.size++;
    }

    public Type deleteFirstElm() throws UnsupportedOperationException {
        if (firstElement == null) {
            throw new UnsupportedOperationException("First element don't exist");
        }
        Type tmp = firstElement.value;
        firstElement = firstElement.nextElement;
        this.size--;
        return tmp;
    }

    public void deleteByValue(Type value) throws IllegalArgumentException {
        boolean isDeleted = false;
        for (int i = 0; i < this.size; i++) {
            if (this.get(i).equals(value)) {
                if (i == 0) {
                    deleteFirstElm();
                    return;
                }
                this.getElm(i - 1).nextElement = this.getElm(i + 1);
                isDeleted = true;
                this.size--;
            }
        }
        if (!isDeleted) {
            throw new IllegalArgumentException(String.format("%s - don't exist in list", value.toString()));
        }
    }

    public void deleteAll() {
        firstElement = null;
        lastElement = null;
        this.size = 0;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        if (firstElement == null) {
            return str.append("]").toString();
        }
        for (int i = 0; i < this.size - 1; i++) {
            if (this.get(i) != null) {
                str.append(this.get(i).toString()).append(",");
            } else {
                str.append("null,");
            }
        }
        if (this.get(this.size - 1) != null) {
            str.append(this.get(this.size - 1).toString()).append("]");
        } else {
            str.append("null]");
        }
        return str.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof myList) {
            myList<Type> other = (myList<Type>) obj;
            if (this.size != other.size) {
                return false;
            }
            for (int i = 0; i < this.size; i++) {
                if (!this.get(i).equals(other.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 0;
        for (int i = 0; i < this.size; i++) {
            result += this.get(i).hashCode();
        }
        return result;
    }

    @Override
    public Iterator iterator() {
        myIterator it = new myIterator();
        it.setElements(this.firstElement, 0, this);
        return it;
    }

    public Iterator iteratorOnTheEnd() {
        myIterator it = new myIterator();
        it.setElements(this.lastElement, this.size-1, this);
        return it;
    }

    @Override
    public ListIterator listIterator() {
        myIterator it = new myIterator();
        it.setElements(this.firstElement, 0, this);
        return it;
    }


    @Override
    public ListIterator listIterator(int index) {
        myIterator it = new myIterator();
        it.setElements(this.getElm(index), index, this);
        return it;
    }

    @Override
    public boolean isEmpty() {
        return firstElement == null;
    }

    @Override
    public boolean contains(Object o) {
        for (int  i = 0; i < this.size; i++) {
            if(this.get(i).equals(o)){
                return true;
            }
        }
        return false;
    }

     
    @Override
    public Object[] toArray() {
        Object[] arr = new Object[this.size];
        for(int i = 0; i < this.size; i++) {
            arr[i] = this.get(i);
        }
        return arr;
    }

    @Override
    public boolean add(Object o) {
        this.push((Type)o);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        try {
            deleteByValue((Type)o);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean addAll(  Collection c) {
        for(Iterator it = c.iterator(); it.hasNext();) {
            push((Type) it.next());
        }
        return true;
    }

    @Override
    public void clear() {
        this.deleteAll();
    }

    @Override
    public Object set(int index, Object element) {
        Element<Type> elm = this.getElm(index);
        Type tmp = elm.value;
        elm.value = (Type) element;
        return tmp;
    }

     
    @Override
    public List subList(int fromIndex, int toIndex) throws IndexOutOfBoundsException {
        if(fromIndex < 0 || fromIndex >= this.size || toIndex < 0 || toIndex > this.size) {
            throw new IndexOutOfBoundsException();
        }
        myList<Type> list = new myList();
        list.firstElement = this.getElm(fromIndex);
        list.lastElement = this.getElm(toIndex-1);
        list.size = toIndex - fromIndex;
        return list;
    }

    public Object clone() {
        myList<Type> list = new myList<>();
        for(Iterator it = this.iterator(); it.hasNext(); ) {
            list.add(it.next());
        }
        return list;
    }

    //---- Заглушки

    @Override
    public boolean addAll(int index,   Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(  Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(  Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(  Collection c) {
        return false;
    }

     
    @Override
    public Object[] toArray(  Object[] a) {
        return null;
    }

    @Override
    public void add(int index, Object element) {
    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return -1;
    }
}