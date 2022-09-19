import java.util.ArrayList;

/**
 * class myList
 * @param <Type>
 */
public class myList <Type> {
    private static class Element <Type> {
        public Type value;
        public Element<Type> nextElement;
        public Element() {}
        public Element(Type elm) {
            this.value = elm;
        }
    }
    private Element <Type> firstElement;
    private Element <Type> lastElement;
    private long size = 0;
    public myList() {}
    public myList(Type value) {
        firstElement = new Element<Type>(value);
        lastElement = firstElement;
        size++;
    }
    public long size(){
        return size;
    }
    private Element<Type> getElm(long index) {
        Element<Type> tmpElement = firstElement;
        while(index-- > 0)
            tmpElement = tmpElement.nextElement;
        return tmpElement;
    }
    public Type get(long index) throws ArrayIndexOutOfBoundsException {
        if(index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException(String.format("Element with %d don't exist", index));
        return getElm(index).value;
    }
    public void push(Type value) {
        if(firstElement == null){
            firstElement = new Element<Type>(value);
            lastElement = firstElement;
            size++;
            return;
        }
        lastElement.nextElement = new Element<>();
        lastElement = lastElement.nextElement;
        lastElement.value = value;
        size++;
    }
    public void pushToBegin(Type value) {
        Element<Type> tmpElement = firstElement;
        firstElement = new Element<Type>(value);
        firstElement.nextElement = tmpElement;
        size++;
    }
    public Type deleleFirstElm() throws UnsupportedOperationException {
        if(firstElement == null)
            throw new UnsupportedOperationException("First element don't exist");
        Type tmp = firstElement.value;
        firstElement = firstElement.nextElement;
        size--;
        return tmp;
    }
    public void deleteByValue(Type value) throws IllegalArgumentException{
        boolean isDeleted = false;
        for(int i = 0; i < this.size; i++){
            if(this.get(i).equals(value)){
                this.getElm(i-1).nextElement = this.getElm(i+1);
                isDeleted = true;
            }
        }
        if(!isDeleted)
            throw new IllegalArgumentException(String.format("%s - don't exist in list", value.toString()));
    }
    public void deleteAll(){
        firstElement = null;
        lastElement = null;
        
    }
}
