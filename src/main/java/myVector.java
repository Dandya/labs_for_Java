import org.jetbrains.annotations.NotNull;

public class myVector<Type> {
    private Type[] array = null;
    private int length = 0;
    private int maxLength = 0;

    public myVector(int size) {
        this.array = (Type[]) new Object[size * 2 + 10];
        this.length = size;
        this.maxLength = size * 2 + 10;
    }

    public myVector(Type value) {
        this.array = (Type[]) new Object[12];
        this.maxLength = 12;
        this.push(value);
    }

    public myVector(Type @NotNull ... vars) {
        this.array = (Type[]) new Object[vars.length * 2 + 10];
        this.maxLength = vars.length * 2 + 10;
        for (Type value : vars) {
            this.push(value);
        }
    }

    public int getLength() {
        return this.length;
    }

    public int getMaxLength() {
        return this.maxLength;
    }

    public void push(Type value) {
        if (this.length == this.maxLength) {
            this.array = realloc(array, maxLength * 2 + 10);
        }
        this.array[this.length++] = value;
    }

    public Type get(int index) throws ArrayIndexOutOfBoundsException {
        if (index < this.length && index >= 0) {
            return this.array[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void insert(Type value, int index) throws ArrayIndexOutOfBoundsException {
        if (index < this.length && index >= 0) {
            if (this.array[index] == null) {
                this.array[index] = value;
            } else {
                if (this.length == this.maxLength) {
                    this.array = realloc(array, maxLength * 2 + 10);
                }
                for (int i = this.length; i > index; i--) {
                    this.array[i] = this.array[i - 1];
                }
                this.array[index] = value;
                this.length++;
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void delete(int index) throws ArrayIndexOutOfBoundsException {
        if (index < this.length && index >= 0) {
            Type tmp;
            for (int i = index; i < this.length; i++)
                this.array[i] = this.array[i + 1];
            this.length--;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void deleteLastElm() {
        delete(this.length - 1);
    }

    public void deleteAll() {
        this.length = 0;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        if (this.length == 0) {
            return str.append("]").toString();
        }
        for (int i = 0; i < this.length - 1; i++) {
            if (this.get(i) != null) {
                str.append(this.get(i).toString()).append(",");
            } else {
                str.append("null,");
            }
        }
        if (this.get(this.length - 1) != null) {
            str.append(this.get(this.length - 1).toString()).append("]");
        } else {
            str.append("null]");
        }
        return str.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof myVector) {
            myVector<Type> other = (myVector<Type>) obj;
            if (this.length != other.length) {
                return false;
            }
            for (int i = 0; i < this.length; i++) {
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
        for (int i = 0; i < this.length; i++) {
            result += this.get(i).hashCode();
        }
        return result;
    }

    private Type[] realloc(Type[] array, int newSize) {
        Type[] newArray = (Type[]) new Object[newSize];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        this.maxLength = newSize;
        return newArray;
    }
}
