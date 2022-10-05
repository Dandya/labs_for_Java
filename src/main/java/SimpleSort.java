import java.util.List;

public class SimpleSort<Type extends Comparable> {

    public SimpleSort(){
    }

    public List<Type> BubbleSort(List<Type> list, int begin, int end) throws IllegalArgumentException {
        if(list == null || begin < 0 || end < 0 || begin > list.size() || end > list.size()) {
            throw new IllegalArgumentException();
        }
        boolean was_change = true;
        while (was_change) {
            was_change = false;
            for (int i = begin + 1; i < end; i++) {
                if (list.get(i - 1).compareTo(list.get(i)) > 0) {
                    list.set(i - 1, list.set(i, list.get(i - 1)));
                    was_change = true;
                }
            }
        }
        return list;
    }

    public List<Type> BubbleSort(List<Type> list) {
        return this.BubbleSort(list, 0, list.size());
    }

    public Type[] BubbleSort(Type[] arr, int begin, int end) throws IllegalArgumentException{
        if(arr == null || begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new IllegalArgumentException();
        }
        boolean was_change = true;
        while (was_change) {
            was_change = false;
            for (int i = begin + 1; i < end; i++) {
                if (arr[i - 1].compareTo(arr[i]) > 0) {
                    Type tmp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = tmp;
                    was_change = true;
                }
            }
        }
        return arr;
    }

    public Type[] BubbleSort(Type[] arr) {
        return this.BubbleSort(arr, 0, arr.length);
    }

    public List<Type> InputSort(List<Type> list, int begin, int end) throws IllegalArgumentException {
        if(list == null || begin < 0 || end < 0 || begin > list.size() || end > list.size()) {
            throw new IllegalArgumentException();
        }
        for(int i = begin + 1; i < end; i++) {
            Type value = list.get(i);
            int j= i-1;
            while((j >= begin) ? value.compareTo(list.get(j)) < 0 : false) {
                list.set(j+1, list.get(j));
                j--;
            }
            list.set(j+1, value);
        }
        return list;
    }

    public List<Type> InputSort(List<Type> list) {
        return this.BubbleSort(list, 0, list.size());
    }

    public Type[] InputSort(Type[] arr, int begin, int end) throws IllegalArgumentException {
        if(arr == null || begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new IllegalArgumentException();
        }
        for(int i = begin + 1; i < end; i++) {
            Type value = arr[i];
            int j= i-1;
            while((j >= begin) ? value.compareTo(arr[j]) < 0 : false) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = value;
        }
        return arr;
    }

    public Type[] InputSort(Type[] arr) {
        return this.BubbleSort(arr, 0, arr.length);
    }

    public List<Type> SelectSort(List<Type> list, int begin, int end) throws IllegalArgumentException {
        if(list == null || begin < 0 || end < 0 || begin > list.size() || end > list.size()) {
            throw new IllegalArgumentException();
        }
        int indexOfNextMinimal = begin;
        while (indexOfNextMinimal != end) {
            int indexOfMinimal = indexOfNextMinimal;
            for (int i = indexOfNextMinimal + 1; i < end; i++) {
                if (list.get(indexOfMinimal).compareTo(list.get(i)) > 0) {
                    indexOfMinimal = i;
                }
            }
            list.set(indexOfMinimal, list.set(indexOfNextMinimal, list.get(indexOfMinimal)));
            indexOfNextMinimal++;
        }
        return list;
    }

    public List<Type> SelectSort(List<Type> list) {
        return this.BubbleSort(list, 0, list.size());
    }

    public Type[] SelectSort(Type[] arr, int begin, int end) throws IllegalArgumentException{
        if(arr == null || begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new IllegalArgumentException();
        }
        int indexOfNextMinimal = begin;
        while (indexOfNextMinimal != end) {
            int indexOfMinimal = indexOfNextMinimal;
            for (int i = indexOfNextMinimal + 1; i < end; i++) {
                if (arr[indexOfMinimal].compareTo(arr[i]) > 0) {
                    indexOfMinimal = i;
                }
            }
            Type tmp = arr[indexOfNextMinimal];
            arr[indexOfNextMinimal] = arr[indexOfMinimal];
            arr[indexOfMinimal] = tmp;
            indexOfNextMinimal++;
        }
        return arr;
    }

    public Type[] SelectSort(Type[] arr) {
        return this.BubbleSort(arr, 0, arr.length);
    }
}
