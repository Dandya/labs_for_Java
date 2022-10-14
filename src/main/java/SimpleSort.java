import java.util.List;

public class SimpleSort<Type extends Comparable<Type>> {

    public SimpleSort(){
    }

    private void testOfParameters(List<Type> list, int begin, int end) {
        if(list == null) {
            throw new NullPointerException();
        }
        if(begin < 0 || end < 0 || begin > list.size() || end > list.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
    }

    private void testOfParameters(Type[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
    }

    public void BubbleSort(List<Type> list, int begin, int end) {
        testOfParameters(list, begin, end);
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
    }

    public void BubbleSort(List<Type> list) {
        this.BubbleSort(list, 0, list.size());
    }

    public void BubbleSort(Type[] arr, int begin, int end) {
        testOfParameters(arr, begin, end);
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
    }

    public void BubbleSort(Type[] arr) {
        this.BubbleSort(arr, 0, arr.length);
    }

    public void InputSort(List<Type> list, int begin, int end) {
        testOfParameters(list, begin, end);
        for(int i = begin + 1; i < end; i++) {
            Type value = list.get(i);
            int j= i-1;
            while((j >= begin) ? value.compareTo(list.get(j)) < 0 : false) {
                list.set(j+1, list.get(j));
                j--;
            }
            list.set(j+1, value);
        }
    }

    public void InputSort(List<Type> list) {
        this.InputSort(list, 0, list.size());
    }

    public void InputSort(Type[] arr, int begin, int end) {
        testOfParameters(arr, begin, end);
        for(int i = begin + 1; i < end; i++) {
            Type value = arr[i];
            int j= i-1;
            while((j >= begin) ? value.compareTo(arr[j]) < 0 : false) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = value;
        }
    }

    public void InputSort(Type[] arr) {
        this.InputSort(arr, 0, arr.length);
    }

    public void SelectSort(List<Type> list, int begin, int end) {
        testOfParameters(list, begin, end);
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
    }

    public void SelectSort(List<Type> list) {
        this.SelectSort(list, 0, list.size());
    }

    public void SelectSort(Type[] arr, int begin, int end) {
        testOfParameters(arr, begin, end);
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
    }

    public void SelectSort(Type[] arr) {
        this.SelectSort(arr, 0, arr.length);
    }

    public static void BubbleSort(byte[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        boolean was_change = true;
        while (was_change) {
            was_change = false;
            for (int i = begin + 1; i < end; i++) {
                if (arr[i - 1] > arr[i]) {
                    byte tmp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = tmp;
                    was_change = true;
                }
            }
        }
    }

    public static void BubbleSort(byte[] arr) {
        BubbleSort(arr, 0, arr.length);
    }

    public static void InputSort(byte[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for(int i = begin + 1; i < end; i++) {
            byte value = arr[i];
            int j= i-1;
            while((j >= begin) ? value < arr[j] : false) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = value;
        }
    }

    public static void InputSort(byte[] arr) {
        InputSort(arr, 0, arr.length);
    }

    public static void SelectSort(byte[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int indexOfNextMinimal = begin;
        while (indexOfNextMinimal != end) {
            int indexOfMinimal = indexOfNextMinimal;
            for (int i = indexOfNextMinimal + 1; i < end; i++) {
                if (arr[indexOfMinimal] > arr[i]) {
                    indexOfMinimal = i;
                }
            }
            byte tmp = arr[indexOfNextMinimal];
            arr[indexOfNextMinimal] = arr[indexOfMinimal];
            arr[indexOfMinimal] = tmp;
            indexOfNextMinimal++;
        }
    }

    public static void SelectSort(byte[] arr) {
        SelectSort(arr, 0, arr.length);
    }

    public static void BubbleSort(short[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        boolean was_change = true;
        while (was_change) {
            was_change = false;
            for (int i = begin + 1; i < end; i++) {
                if (arr[i - 1] > arr[i]) {
                    short tmp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = tmp;
                    was_change = true;
                }
            }
        }
    }

    public static void BubbleSort(short[] arr) {
        BubbleSort(arr, 0, arr.length);
    }

    public static void InputSort(short[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for(int i = begin + 1; i < end; i++) {
            short value = arr[i];
            int j= i-1;
            while((j >= begin) ? value < arr[j] : false) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = value;
        }
    }

    public static void InputSort(short[] arr) {
        InputSort(arr, 0, arr.length);
    }

    public static void SelectSort(short[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int indexOfNextMinimal = begin;
        while (indexOfNextMinimal != end) {
            int indexOfMinimal = indexOfNextMinimal;
            for (int i = indexOfNextMinimal + 1; i < end; i++) {
                if (arr[indexOfMinimal] > arr[i]) {
                    indexOfMinimal = i;
                }
            }
            short tmp = arr[indexOfNextMinimal];
            arr[indexOfNextMinimal] = arr[indexOfMinimal];
            arr[indexOfMinimal] = tmp;
            indexOfNextMinimal++;
        }
    }

    public static void SelectSort(short[] arr) {
        SelectSort(arr, 0, arr.length);
    }

    public static void BubbleSort(int[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        boolean was_change = true;
        while (was_change) {
            was_change = false;
            for (int i = begin + 1; i < end; i++) {
                if (arr[i - 1] > arr[i]) {
                    int tmp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = tmp;
                    was_change = true;
                }
            }
        }
    }

    public static void BubbleSort(int[] arr) {
        BubbleSort(arr, 0, arr.length);
    }

    public static void InputSort(int[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for(int i = begin + 1; i < end; i++) {
            int value = arr[i];
            int j= i-1;
            while((j >= begin) ? value < arr[j] : false) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = value;
        }
    }

    public static void InputSort(int[] arr) {
        InputSort(arr, 0, arr.length);
    }

    public static void SelectSort(int[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int indexOfNextMinimal = begin;
        while (indexOfNextMinimal != end) {
            int indexOfMinimal = indexOfNextMinimal;
            for (int i = indexOfNextMinimal + 1; i < end; i++) {
                if (arr[indexOfMinimal] > arr[i]) {
                    indexOfMinimal = i;
                }
            }
            int tmp = arr[indexOfNextMinimal];
            arr[indexOfNextMinimal] = arr[indexOfMinimal];
            arr[indexOfMinimal] = tmp;
            indexOfNextMinimal++;
        }
    }

    public static void SelectSort(int[] arr) {
        SelectSort(arr, 0, arr.length);
    }

    public static void BubbleSort(long[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        boolean was_change = true;
        while (was_change) {
            was_change = false;
            for (int i = begin + 1; i < end; i++) {
                if (arr[i - 1] > arr[i]) {
                    long tmp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = tmp;
                    was_change = true;
                }
            }
        }
    }

    public static void BubbleSort(long[] arr) {
        BubbleSort(arr, 0, arr.length);
    }

    public static void InputSort(long[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for(int i = begin + 1; i < end; i++) {
            long value = arr[i];
            int j= i-1;
            while((j >= begin) ? value < arr[j] : false) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = value;
        }
    }

    public static void InputSort(long[] arr) {
        InputSort(arr, 0, arr.length);
    }

    public static void SelectSort(long[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int indexOfNextMinimal = begin;
        while (indexOfNextMinimal != end) {
            int indexOfMinimal = indexOfNextMinimal;
            for (int i = indexOfNextMinimal + 1; i < end; i++) {
                if (arr[indexOfMinimal] > arr[i]) {
                    indexOfMinimal = i;
                }
            }
            long tmp = arr[indexOfNextMinimal];
            arr[indexOfNextMinimal] = arr[indexOfMinimal];
            arr[indexOfMinimal] = tmp;
            indexOfNextMinimal++;
        }
    }

    public static void SelectSort(long[] arr) {
        SelectSort(arr, 0, arr.length);
    }

    public static void BubbleSort(float[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        boolean was_change = true;
        while (was_change) {
            was_change = false;
            for (int i = begin + 1; i < end; i++) {
                if (arr[i - 1] > arr[i]) {
                    float tmp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = tmp;
                    was_change = true;
                }
            }
        }
    }

    public static void BubbleSort(float[] arr) {
        BubbleSort(arr, 0, arr.length);
    }

    public static void InputSort(float[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for(int i = begin + 1; i < end; i++) {
            float value = arr[i];
            int j= i-1;
            while((j >= begin) ? value < arr[j] : false) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = value;
        }
    }

    public static void InputSort(float[] arr) {
        InputSort(arr, 0, arr.length);
    }

    public static void SelectSort(float[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int indexOfNextMinimal = begin;
        while (indexOfNextMinimal != end) {
            int indexOfMinimal = indexOfNextMinimal;
            for (int i = indexOfNextMinimal + 1; i < end; i++) {
                if (arr[indexOfMinimal] > arr[i]) {
                    indexOfMinimal = i;
                }
            }
            float tmp = arr[indexOfNextMinimal];
            arr[indexOfNextMinimal] = arr[indexOfMinimal];
            arr[indexOfMinimal] = tmp;
            indexOfNextMinimal++;
        }
    }

    public static void SelectSort(float[] arr) {
        SelectSort(arr, 0, arr.length);
    }

    public static void BubbleSort(double[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        boolean was_change = true;
        while (was_change) {
            was_change = false;
            for (int i = begin + 1; i < end; i++) {
                if (arr[i - 1] > arr[i]) {
                    double tmp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = tmp;
                    was_change = true;
                }
            }
        }
    }

    public static void BubbleSort(double[] arr) {
        BubbleSort(arr, 0, arr.length);
    }

    public static void InputSort(double[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for(int i = begin + 1; i < end; i++) {
            double value = arr[i];
            int j= i-1;
            while((j >= begin) ? value < arr[j] : false) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = value;
        }
    }

    public static void InputSort(double[] arr) {
        InputSort(arr, 0, arr.length);
    }

    public static void SelectSort(double[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int indexOfNextMinimal = begin;
        while (indexOfNextMinimal != end) {
            int indexOfMinimal = indexOfNextMinimal;
            for (int i = indexOfNextMinimal + 1; i < end; i++) {
                if (arr[indexOfMinimal] > arr[i]) {
                    indexOfMinimal = i;
                }
            }
            double tmp = arr[indexOfNextMinimal];
            arr[indexOfNextMinimal] = arr[indexOfMinimal];
            arr[indexOfMinimal] = tmp;
            indexOfNextMinimal++;
        }
    }

    public static void SelectSort(double[] arr) {
        SelectSort(arr, 0, arr.length);
    }

    public static void BubbleSort(char[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        boolean was_change = true;
        while (was_change) {
            was_change = false;
            for (int i = begin + 1; i < end; i++) {
                if (arr[i - 1] > arr[i]) {
                    char tmp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = tmp;
                    was_change = true;
                }
            }
        }
    }

    public static void BubbleSort(char[] arr) {
        BubbleSort(arr, 0, arr.length);
    }

    public static void InputSort(char[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for(int i = begin + 1; i < end; i++) {
            char value = arr[i];
            int j= i-1;
            while((j >= begin) ? value < arr[j] : false) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = value;
        }
    }

    public static void InputSort(char[] arr) {
        InputSort(arr, 0, arr.length);
    }

    public static void SelectSort(char[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int indexOfNextMinimal = begin;
        while (indexOfNextMinimal != end) {
            int indexOfMinimal = indexOfNextMinimal;
            for (int i = indexOfNextMinimal + 1; i < end; i++) {
                if (arr[indexOfMinimal] > arr[i]) {
                    indexOfMinimal = i;
                }
            }
            char tmp = arr[indexOfNextMinimal];
            arr[indexOfNextMinimal] = arr[indexOfMinimal];
            arr[indexOfMinimal] = tmp;
            indexOfNextMinimal++;
        }
    }

    public static void SelectSort(char[] arr) {
        SelectSort(arr, 0, arr.length);
    }
}
