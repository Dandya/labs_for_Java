import java.util.ArrayList;

/**
 * class myList
 * @param <Type>
 */
public class myList <Type>{
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
    private int size = 0;
    public myList() {}
    public myList(Type value) {
        firstElement = new Element<Type>(value);
        lastElement = firstElement;
        this.size++;
    }
    public myList(Type ... vars) {
        for(Type value: vars){
            this.push(value);
        }
    }
    public int size(){
        return this.size;
    }
    private Element<Type> getElm(int index) {
        Element<Type> tmpElement = firstElement;
        if(index >= this.size)
            return null;
        while(index-- > 0)
            tmpElement = tmpElement.nextElement;
        return tmpElement;
    }
    public Type get(int index) throws ArrayIndexOutOfBoundsException {
        if(index < 0 || index >= this.size)
            throw new ArrayIndexOutOfBoundsException(String.format("Element with %d don't exist", index));
        return getElm(index).value;
    }
    public void push(Type value) {
        if(firstElement == null){
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
    public Type deleleFirstElm() throws UnsupportedOperationException {
        if(firstElement == null)
            throw new UnsupportedOperationException("First element don't exist");
        Type tmp = firstElement.value;
        firstElement = firstElement.nextElement;
        this.size--;
        return tmp;
    }
    public void deleteByValue(Type value) throws IllegalArgumentException{
        boolean isDeleted = false;
        for(int i = 0; i < this.size; i++){
            if(this.get(i).equals(value)){
                if(i == 0){
                    deleleFirstElm();
                    return;
                }
                this.getElm(i-1).nextElement = this.getElm(i+1);
                isDeleted = true;
                this.size--;
            }
        }
        if(!isDeleted)
            throw new IllegalArgumentException(String.format("%s - don't exist in list", value.toString()));
    }
    public void deleteAll(){
        firstElement = null;
        lastElement = null;
        this.size = 0;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder("[");
        for(int i = 0; i < this.size-1; i++){
            str.append(this.get(i).toString()).append(",");
        }
        str.append(this.get(this.size-1).toString()).append("]");
        return str.toString();
    }
}
