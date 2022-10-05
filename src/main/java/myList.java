import org.jetbrains.annotations.NotNull;

import java.util.List;

public class myList<Type> {
    private static class Element<Type> {
        public Type value;
        public Element<Type> nextElement;

        public Element() {
        }

        public Element(Type elm) {
            this.value = elm;
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

    public myList(@NotNull Type... vars) {
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
}
