import java.util.ArrayList;
import java.util.List;

public class EffectiveSorts<Type extends Comparable<Type>> {

    /**
     * QuickSort
     *      best: O(n)
     *      middle: O(nlog(n))
     *      bad: O(n^2)
     * HeapSort
     *      best: O(nlog(n))
     *      middle: O(nlog(n))
     *      bad: O(nlog(n))
     * MergeSort
     *      best: O(nlog(n))
     *      middle: O(nlog(n))
     *      bad: O(nlog(n))
     */
    public EffectiveSorts(){
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

    private void quickSortR(List<Type> list, int begin, int end) {
        Type supportElement = list.get((end - begin) / 2 + begin);
        int leftBound = begin, rightBound = end-1;
        while(leftBound <= rightBound) {
            while(list.get(leftBound).compareTo(supportElement) < 0) {
                leftBound++;
            }
            while(list.get(rightBound).compareTo(supportElement) > 0) {
                rightBound--;
            }
            if(leftBound <= rightBound) {
                list.set(leftBound, list.set(rightBound, list.get(leftBound)));
                leftBound++;
                rightBound--;
            }
        }
        if(rightBound > begin) {
            quickSortR(list, begin, rightBound+1);
        }
        if(leftBound < end-1) {
            quickSortR(list, leftBound, end);
        }
    }

    public void QuickSort(List<Type> list, int begin, int end) {
        testOfParameters(list, begin, end);
        if(end - begin == 0) {
            return;
        }
        quickSortR(list, begin, end);
    }

    public void QuickSort(List<Type> list) {
        this.QuickSort(list, 0, list.size());
    }

    private void quickSortR(Type[] arr, int begin, int end) {
        Type supportElement = arr[(end - begin) / 2 + begin];
        int leftBound = begin, rightBound = end-1;
        while(leftBound <= rightBound) {
            while(arr[leftBound].compareTo(supportElement) < 0) {
                leftBound++;
            }
            while(arr[rightBound].compareTo(supportElement) > 0) {
                rightBound--;
            }
            if(leftBound <= rightBound) {
                Type tmp = arr[rightBound];
                arr[rightBound] = arr[leftBound];
                arr[leftBound] = tmp;
                leftBound++;
                rightBound--;
            }
        }
        if(rightBound > begin) {
            quickSortR(arr, begin, rightBound+1);
        }
        if(leftBound < end-1) {
            quickSortR(arr, leftBound, end);
        }
    }

    public void QuickSort(Type[] arr, int begin, int end) {
        testOfParameters(arr, begin, end);
        if(end - begin == 0) {
            return;
        }
        quickSortR(arr, begin, end);
    }

    public void QuickSort(Type[] arr) {
        this.QuickSort(arr, 0, arr.length);
    }

    private void changeTree(List<Type> list, int index, int begin, int end) {
        int max = index;
        int leftNode = 2*(index - begin) + 1 + begin;
        int rightNode = 2*(index - begin) + 2 + begin;
        if((leftNode < end)? list.get(leftNode).compareTo(list.get(max)) > 0 : false) {
           max = leftNode;
        }
        if((rightNode < end)? list.get(rightNode).compareTo(list.get(max)) > 0 : false) {
            max = rightNode;
        }
        if(max != index) {
            list.set(index, list.set(max, list.get(index)));
            changeTree(list, max, begin, end);
        }
    }

    public void HeapSort(List<Type> list, int begin, int end) {
        testOfParameters(list, begin, end);
        if(end - begin == 0) {
            return;
        }
        // create start tree
        for(int i = begin + (end - begin)/2 - 1; i >= begin; i--) {
            changeTree(list, i, begin, end);
        }
        // sort of list
        for (int i = end - 1; i >= begin; i--) {
            list.set(begin, list.set(i, list.get(begin)));
            changeTree(list, begin, begin, i);
        }
    }

    public void HeapSort(List<Type> list) {
        this.HeapSort(list, 0, list.size());
    }

    private void changeTree(Type[] arr, int index, int begin, int end) {
        int max = index;
        int leftNode = 2*(index - begin) + 1 + begin;
        int rightNode = 2*(index - begin) + 2 + begin;
        if((leftNode < end)? arr[leftNode].compareTo(arr[max]) > 0 : false) {
            max = leftNode;
        }
        if((rightNode < end)? arr[rightNode].compareTo(arr[max]) > 0 : false) {
            max = rightNode;
        }
        if(max != index) {
            Type tmp = arr[index];
            arr[index] = arr[max];
            arr[max] = tmp;
            changeTree(arr, max, begin, end);
        }
    }

    public void HeapSort(Type[] arr, int begin, int end) {
        testOfParameters(arr, begin, end);
        if(end - begin == 0) {
            return;
        }
        // create start tree
        for(int i = (end - begin)/2 -1 + begin; i >= begin; i--) {
            changeTree(arr, i, begin, end);
        }
        // sort of arr
        for (int i = end - 1; i >= begin; i--) {
            Type tmp = arr[i];
            arr[i] = arr[begin];
            arr[begin] = tmp;
            changeTree(arr, begin, begin, i);
        }
    }

    public void HeapSort(Type[] arr) {
        this.HeapSort(arr, 0, arr.length);
    }

    private void mergeSortR(List<Type> listSrc, int begin, int end) {
        if(end - begin <= 1) {
            return;
        }
        int mid = (end - begin)/2 + begin;
        int sizeLeft = mid - begin, sizeRight = end - mid;
        List<Type> leftList = new ArrayList<>(sizeLeft);
        for(int i  = begin; i < mid; i++) {
            leftList.add(listSrc.get(i));
        }
        List<Type> rightList = new ArrayList<>(sizeRight);
        for(int i  = mid; i < end; i++) {
            rightList.add(listSrc.get(i));
        }
        mergeSortR(leftList, 0, sizeLeft);
        mergeSortR(rightList, 0,  sizeRight);
        int index = begin;
        for(int i = 0, j = 0; i < sizeLeft || j < sizeRight;) {
            if(i == sizeLeft) {
                listSrc.set(index, rightList.get(j));
                j++;
                index++;
            } else if(j == sizeRight) {
                listSrc.set(index, leftList.get(i));
                i++;
                index++;
            } else if (leftList.get(i).compareTo(rightList.get(j)) < 0) {
                listSrc.set(index, leftList.get(i));
                i++;
                index++;
            } else {
                listSrc.set(index, rightList.get(j));
                j++;
                index++;
            }
        }
    }

    public void MergeSort(List<Type> list, int begin, int end) {
        testOfParameters(list, begin, end);
        if(end - begin == 0) {
            return;
        }
        mergeSortR(list, begin, end);
    }

    public void MergeSort(List<Type> list) {
        this.MergeSort(list, 0, list.size());
    }

    private void mergeSortR(Object[] arrSrc, int begin, int end) throws ClassCastException {
        if(end - begin <= 1) {
            return;
        }
        int mid = (end - begin)/2 + begin;
        int sizeLeft = mid - begin, sizeRight = end - mid;
        Object[] leftArr = new Object[sizeLeft];
        for(int i  = begin; i < mid; i++) {
            leftArr[i-begin] = arrSrc[i];
        }
        Object[] rightArr = new Object[sizeRight];
        for(int i  = mid; i < end; i++) {
            rightArr[i-mid] = arrSrc[i];
        }
        mergeSortR(leftArr, 0, sizeLeft);
        mergeSortR(rightArr, 0,  sizeRight);
        int index = begin;
        for(int i = 0, j = 0; i < sizeLeft || j < sizeRight;) {
            if(i == sizeLeft) {
                arrSrc[index] = rightArr[j];
                j++;
                index++;
            } else if(j == sizeRight) {
                arrSrc[index] = leftArr[i];
                i++;
                index++;
            } else if (((Type)leftArr[i]).compareTo(((Type)rightArr[j])) < 0) {
                arrSrc[index] = leftArr[i];
                i++;
                index++;
            } else {
                arrSrc[index] = rightArr[j];
                j++;
                index++;
            }
        }
    }

    public void MergeSort(Type[] arr, int begin, int end) {
        testOfParameters(arr, begin, end);
        if(end - begin == 0) {
            return;
        }
        mergeSortR(arr, begin, end);
    }

    public void MergeSort(Type[] arr) {
        this.mergeSortR(arr, 0, arr.length);
    }

    // primitive types
    private static void quickSortR(byte[] arr, int begin, int end) {
        byte supportElement = arr[(end - begin) / 2 + begin];
        int leftBound = begin, rightBound = end-1;
        while(leftBound <= rightBound) {
            while(arr[leftBound] < supportElement) {
                leftBound++;
            }
            while(arr[rightBound] > supportElement) {
                rightBound--;
            }
            if(leftBound <= rightBound) {
                byte tmp = arr[rightBound];
                arr[rightBound] = arr[leftBound];
                arr[leftBound] = tmp;
                leftBound++;
                rightBound--;
            }
        }
        if(rightBound > begin) {
            quickSortR(arr, begin, rightBound+1);
        }
        if(leftBound < end-1) {
            quickSortR(arr, leftBound, end);
        }
    }

    public static void QuickSort(byte[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if(end - begin == 0) {
            return;
        }
        quickSortR(arr, begin, end);
    }

    public static void QuickSort(byte[] arr) {
        QuickSort(arr, 0, arr.length);
    }

    private static void changeTree(byte[] arr, int index, int begin, int end) {
        int max = index;
        int leftNode = 2*(index - begin) + 1 + begin;
        int rightNode = 2*(index - begin) + 2 + begin;
        if((leftNode < end)? arr[leftNode] > arr[max] : false) {
            max = leftNode;
        }
        if((rightNode < end)? arr[rightNode] > arr[max] : false) {
            max = rightNode;
        }
        if(max != index) {
            byte tmp = arr[index];
            arr[index] = arr[max];
            arr[max] = tmp;
            changeTree(arr, max, begin, end);
        }
    }

    public static void HeapSort(byte[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if(end - begin == 0) {
            return;
        }
        // create start tree
        for(int i = (end - begin)/2 -1 + begin; i >= begin; i--) {
            changeTree(arr, i, begin, end);
        }
        // sort of arr
        for (int i = end - 1; i >= begin; i--) {
            byte tmp = arr[i];
            arr[i] = arr[begin];
            arr[begin] = tmp;
            changeTree(arr, begin, begin, i);
        }
    }

    public static void HeapSort(byte[] arr) {
        HeapSort(arr, 0, arr.length);
    }

    private static void mergeSortR(byte[] arrSrc, int begin, int end) {
        if(end - begin <= 1) {
            return;
        }
        int mid = (end - begin)/2 + begin;
        int sizeLeft = mid - begin, sizeRight = end - mid;
        byte[] leftArr = new byte[sizeLeft];
        for(int i  = begin; i < mid; i++) {
            leftArr[i-begin] = arrSrc[i];
        }
        byte[] rightArr = new byte[sizeRight];
        for(int i  = mid; i < end; i++) {
            rightArr[i-mid] = arrSrc[i];
        }
        mergeSortR(leftArr, 0, sizeLeft);
        mergeSortR(rightArr, 0,  sizeRight);
        int index = begin;
        for(int i = 0, j = 0; i < sizeLeft || j < sizeRight;) {
            if(i == sizeLeft) {
                arrSrc[index] = rightArr[j];
                j++;
                index++;
            } else if(j == sizeRight) {
                arrSrc[index] = leftArr[i];
                i++;
                index++;
            } else if (leftArr[i] < rightArr[j]) {
                arrSrc[index] = leftArr[i];
                i++;
                index++;
            } else {
                arrSrc[index] = rightArr[j];
                j++;
                index++;
            }
        }
    }

    public static void MergeSort(byte[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if(end - begin == 0) {
            return;
        }
        mergeSortR(arr, begin, end);
    }

    public static void MergeSort(byte[] arr) {
        MergeSort( arr, 0, arr.length);
    }

    private static void quickSortR(short[] arr, int begin, int end) {
        short supportElement = arr[(end - begin) / 2 + begin];
        int leftBound = begin, rightBound = end-1;
        while(leftBound <= rightBound) {
            while(arr[leftBound] < supportElement) {
                leftBound++;
            }
            while(arr[rightBound] > supportElement) {
                rightBound--;
            }
            if(leftBound <= rightBound) {
                short tmp = arr[rightBound];
                arr[rightBound] = arr[leftBound];
                arr[leftBound] = tmp;
                leftBound++;
                rightBound--;
            }
        }
        if(rightBound > begin) {
            quickSortR(arr, begin, rightBound+1);
        }
        if(leftBound < end-1) {
            quickSortR(arr, leftBound, end);
        }
    }

    public static void QuickSort(short[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if(end - begin == 0) {
            return;
        }
        quickSortR(arr, begin, end);
    }

    public static void QuickSort(short[] arr) {
        QuickSort(arr, 0, arr.length);
    }

    private static void changeTree(short[] arr, int index, int begin, int end) {
        int max = index;
        int leftNode = 2*(index - begin) + 1 + begin;
        int rightNode = 2*(index - begin) + 2 + begin;
        if((leftNode < end)? arr[leftNode] > arr[max] : false) {
            max = leftNode;
        }
        if((rightNode < end)? arr[rightNode] > arr[max] : false) {
            max = rightNode;
        }
        if(max != index) {
            short tmp = arr[index];
            arr[index] = arr[max];
            arr[max] = tmp;
            changeTree(arr, max, begin, end);
        }
    }

    public static void HeapSort(short[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if(end - begin == 0) {
            return;
        }
        // create start tree
        for(int i = (end - begin)/2 -1 + begin; i >= begin; i--) {
            changeTree(arr, i, begin, end);
        }
        // sort of arr
        for (int i = end - 1; i >= begin; i--) {
            short tmp = arr[i];
            arr[i] = arr[begin];
            arr[begin] = tmp;
            changeTree(arr, begin, begin, i);
        }
    }

    public static void HeapSort(short[] arr) {
        HeapSort(arr, 0, arr.length);
    }

    private static void mergeSortR(short[] arrSrc, int begin, int end) {
        if(end - begin <= 1) {
            return;
        }
        int mid = (end - begin)/2 + begin;
        int sizeLeft = mid - begin, sizeRight = end - mid;
        short[] leftArr = new short[sizeLeft];
        for(int i  = begin; i < mid; i++) {
            leftArr[i-begin] = arrSrc[i];
        }
        short[] rightArr = new short[sizeRight];
        for(int i  = mid; i < end; i++) {
            rightArr[i-mid] = arrSrc[i];
        }
        mergeSortR(leftArr, 0, sizeLeft);
        mergeSortR(rightArr, 0,  sizeRight);
        int index = begin;
        for(int i = 0, j = 0; i < sizeLeft || j < sizeRight;) {
            if(i == sizeLeft) {
                arrSrc[index] = rightArr[j];
                j++;
                index++;
            } else if(j == sizeRight) {
                arrSrc[index] = leftArr[i];
                i++;
                index++;
            } else if (leftArr[i] < rightArr[j]) {
                arrSrc[index] = leftArr[i];
                i++;
                index++;
            } else {
                arrSrc[index] = rightArr[j];
                j++;
                index++;
            }
        }
    }

    public static void MergeSort(short[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if(end - begin == 0) {
            return;
        }
        mergeSortR(arr, begin, end);
    }

    public static void MergeSort(short[] arr) {
        MergeSort( arr, 0, arr.length);
    }

    private static void quickSortR(int[] arr, int begin, int end) {
        int supportElement = arr[(end - begin) / 2 + begin];
        int leftBound = begin, rightBound = end-1;
        while(leftBound <= rightBound) {
            while(arr[leftBound] < supportElement) {
                leftBound++;
            }
            while(arr[rightBound] > supportElement) {
                rightBound--;
            }
            if(leftBound <= rightBound) {
                int tmp = arr[rightBound];
                arr[rightBound] = arr[leftBound];
                arr[leftBound] = tmp;
                leftBound++;
                rightBound--;
            }
        }
        if(rightBound > begin) {
            quickSortR(arr, begin, rightBound+1);
        }
        if(leftBound < end-1) {
            quickSortR(arr, leftBound, end);
        }
    }

    public static void QuickSort(int[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if(end - begin == 0) {
            return;
        }
        quickSortR(arr, begin, end);
    }

    public static void QuickSort(int[] arr) {
        QuickSort(arr, 0, arr.length);
    }

    private static void changeTree(int[] arr, int index, int begin, int end) {
        int max = index;
        int leftNode = 2*(index - begin) + 1 + begin;
        int rightNode = 2*(index - begin) + 2 + begin;
        if((leftNode < end)? arr[leftNode] > arr[max] : false) {
            max = leftNode;
        }
        if((rightNode < end)? arr[rightNode] > arr[max] : false) {
            max = rightNode;
        }
        if(max != index) {
            int tmp = arr[index];
            arr[index] = arr[max];
            arr[max] = tmp;
            changeTree(arr, max, begin, end);
        }
    }

    public static void HeapSort(int[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if(end - begin == 0) {
            return;
        }
        // create start tree
        for(int i = (end - begin)/2 -1 + begin; i >= begin; i--) {
            changeTree(arr, i, begin, end);
        }
        // sort of arr
        for (int i = end - 1; i >= begin; i--) {
            int tmp = arr[i];
            arr[i] = arr[begin];
            arr[begin] = tmp;
            changeTree(arr, begin, begin, i);
        }
    }

    public static void HeapSort(int[] arr) {
        HeapSort(arr, 0, arr.length);
    }

    private static void mergeSortR(int[] arrSrc, int begin, int end) {
        if(end - begin <= 1) {
            return;
        }
        int mid = (end - begin)/2 + begin;
        int sizeLeft = mid - begin, sizeRight = end - mid;
        int[] leftArr = new int[sizeLeft];
        for(int i  = begin; i < mid; i++) {
            leftArr[i-begin] = arrSrc[i];
        }
        int[] rightArr = new int[sizeRight];
        for(int i  = mid; i < end; i++) {
            rightArr[i-mid] = arrSrc[i];
        }
        mergeSortR(leftArr, 0, sizeLeft);
        mergeSortR(rightArr, 0,  sizeRight);
        int index = begin;
        for(int i = 0, j = 0; i < sizeLeft || j < sizeRight;) {
            if(i == sizeLeft) {
                arrSrc[index] = rightArr[j];
                j++;
                index++;
            } else if(j == sizeRight) {
                arrSrc[index] = leftArr[i];
                i++;
                index++;
            } else if (leftArr[i] < rightArr[j]) {
                arrSrc[index] = leftArr[i];
                i++;
                index++;
            } else {
                arrSrc[index] = rightArr[j];
                j++;
                index++;
            }
        }
    }

    public static void MergeSort(int[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if(end - begin == 0) {
            return;
        }
        mergeSortR(arr, begin, end);
    }

    public static void MergeSort(int[] arr) {
        MergeSort( arr, 0, arr.length);
    }

    private static void quickSortR(long[] arr, int begin, int end) {
        long supportElement = arr[(end - begin) / 2 + begin];
        int leftBound = begin, rightBound = end-1;
        while(leftBound <= rightBound) {
            while(arr[leftBound] < supportElement) {
                leftBound++;
            }
            while(arr[rightBound] > supportElement) {
                rightBound--;
            }
            if(leftBound <= rightBound) {
                long tmp = arr[rightBound];
                arr[rightBound] = arr[leftBound];
                arr[leftBound] = tmp;
                leftBound++;
                rightBound--;
            }
        }
        if(rightBound > begin) {
            quickSortR(arr, begin, rightBound+1);
        }
        if(leftBound < end-1) {
            quickSortR(arr, leftBound, end);
        }
    }

    public static void QuickSort(long[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if(end - begin == 0) {
            return;
        }
        quickSortR(arr, begin, end);
    }

    public static void QuickSort(long[] arr) {
        QuickSort(arr, 0, arr.length);
    }

    private static void changeTree(long[] arr, int index, int begin, int end) {
        int max = index;
        int leftNode = 2*(index - begin) + 1 + begin;
        int rightNode = 2*(index - begin) + 2 + begin;
        if((leftNode < end)? arr[leftNode] > arr[max] : false) {
            max = leftNode;
        }
        if((rightNode < end)? arr[rightNode] > arr[max] : false) {
            max = rightNode;
        }
        if(max != index) {
            long tmp = arr[index];
            arr[index] = arr[max];
            arr[max] = tmp;
            changeTree(arr, max, begin, end);
        }
    }

    public static void HeapSort(long[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if(end - begin == 0) {
            return;
        }
        // create start tree
        for(int i = (end - begin)/2 -1 + begin; i >= begin; i--) {
            changeTree(arr, i, begin, end);
        }
        // sort of arr
        for (int i = end - 1; i >= begin; i--) {
            long tmp = arr[i];
            arr[i] = arr[begin];
            arr[begin] = tmp;
            changeTree(arr, begin, begin, i);
        }
    }

    public static void HeapSort(long[] arr) {
        HeapSort(arr, 0, arr.length);
    }

    private static void mergeSortR(long[] arrSrc, int begin, int end) {
        if(end - begin <= 1) {
            return;
        }
        int mid = (end - begin)/2 + begin;
        int sizeLeft = mid - begin, sizeRight = end - mid;
        long[] leftArr = new long[sizeLeft];
        for(int i  = begin; i < mid; i++) {
            leftArr[i-begin] = arrSrc[i];
        }
        long[] rightArr = new long[sizeRight];
        for(int i  = mid; i < end; i++) {
            rightArr[i-mid] = arrSrc[i];
        }
        mergeSortR(leftArr, 0, sizeLeft);
        mergeSortR(rightArr, 0,  sizeRight);
        int index = begin;
        for(int i = 0, j = 0; i < sizeLeft || j < sizeRight;) {
            if(i == sizeLeft) {
                arrSrc[index] = rightArr[j];
                j++;
                index++;
            } else if(j == sizeRight) {
                arrSrc[index] = leftArr[i];
                i++;
                index++;
            } else if (leftArr[i] < rightArr[j]) {
                arrSrc[index] = leftArr[i];
                i++;
                index++;
            } else {
                arrSrc[index] = rightArr[j];
                j++;
                index++;
            }
        }
    }

    public static void MergeSort(long[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if(end - begin == 0) {
            return;
        }
        mergeSortR(arr, begin, end);
    }

    public static void MergeSort(long[] arr) {
        MergeSort( arr, 0, arr.length);
    }

    private static void quickSortR(char[] arr, int begin, int end) {
        char supportElement = arr[(end - begin) / 2 + begin];
        int leftBound = begin, rightBound = end-1;
        while(leftBound <= rightBound) {
            while(arr[leftBound] < supportElement) {
                leftBound++;
            }
            while(arr[rightBound] > supportElement) {
                rightBound--;
            }
            if(leftBound <= rightBound) {
                char tmp = arr[rightBound];
                arr[rightBound] = arr[leftBound];
                arr[leftBound] = tmp;
                leftBound++;
                rightBound--;
            }
        }
        if(rightBound > begin) {
            quickSortR(arr, begin, rightBound+1);
        }
        if(leftBound < end-1) {
            quickSortR(arr, leftBound, end);
        }
    }

    public static void QuickSort(char[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if(end - begin == 0) {
            return;
        }
        quickSortR(arr, begin, end);
    }

    public static void QuickSort(char[] arr) {
        QuickSort(arr, 0, arr.length);
    }

    private static void changeTree(char[] arr, int index, int begin, int end) {
        int max = index;
        int leftNode = 2*(index - begin) + 1 + begin;
        int rightNode = 2*(index - begin) + 2 + begin;
        if((leftNode < end)? arr[leftNode] > arr[max] : false) {
            max = leftNode;
        }
        if((rightNode < end)? arr[rightNode] > arr[max] : false) {
            max = rightNode;
        }
        if(max != index) {
            char tmp = arr[index];
            arr[index] = arr[max];
            arr[max] = tmp;
            changeTree(arr, max, begin, end);
        }
    }

    public static void HeapSort(char[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if(end - begin == 0) {
            return;
        }
        // create start tree
        for(int i = (end - begin)/2 -1 + begin; i >= begin; i--) {
            changeTree(arr, i, begin, end);
        }
        // sort of arr
        for (int i = end - 1; i >= begin; i--) {
            char tmp = arr[i];
            arr[i] = arr[begin];
            arr[begin] = tmp;
            changeTree(arr, begin, begin, i);
        }
    }

    public static void HeapSort(char[] arr) {
        HeapSort(arr, 0, arr.length);
    }

    private static void mergeSortR(char[] arrSrc, int begin, int end) {
        if(end - begin <= 1) {
            return;
        }
        int mid = (end - begin)/2 + begin;
        int sizeLeft = mid - begin, sizeRight = end - mid;
        char[] leftArr = new char[sizeLeft];
        for(int i  = begin; i < mid; i++) {
            leftArr[i-begin] = arrSrc[i];
        }
        char[] rightArr = new char[sizeRight];
        for(int i  = mid; i < end; i++) {
            rightArr[i-mid] = arrSrc[i];
        }
        mergeSortR(leftArr, 0, sizeLeft);
        mergeSortR(rightArr, 0,  sizeRight);
        int index = begin;
        for(int i = 0, j = 0; i < sizeLeft || j < sizeRight;) {
            if(i == sizeLeft) {
                arrSrc[index] = rightArr[j];
                j++;
                index++;
            } else if(j == sizeRight) {
                arrSrc[index] = leftArr[i];
                i++;
                index++;
            } else if (leftArr[i] < rightArr[j]) {
                arrSrc[index] = leftArr[i];
                i++;
                index++;
            } else {
                arrSrc[index] = rightArr[j];
                j++;
                index++;
            }
        }
    }

    public static void MergeSort(char[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if(end - begin == 0) {
            return;
        }
        mergeSortR(arr, begin, end);
    }

    public static void MergeSort(char[] arr) {
        MergeSort( arr, 0, arr.length);
    }

    private static void quickSortR(float[] arr, int begin, int end) {
        float supportElement = arr[(end - begin) / 2 + begin];
        int leftBound = begin, rightBound = end-1;
        while(leftBound <= rightBound) {
            while(arr[leftBound] < supportElement) {
                leftBound++;
            }
            while(arr[rightBound] > supportElement) {
                rightBound--;
            }
            if(leftBound <= rightBound) {
                float tmp = arr[rightBound];
                arr[rightBound] = arr[leftBound];
                arr[leftBound] = tmp;
                leftBound++;
                rightBound--;
            }
        }
        if(rightBound > begin) {
            quickSortR(arr, begin, rightBound+1);
        }
        if(leftBound < end-1) {
            quickSortR(arr, leftBound, end);
        }
    }

    public static void QuickSort(float[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if(end - begin == 0) {
            return;
        }
        quickSortR(arr, begin, end);
    }

    public static void QuickSort(float[] arr) {
        QuickSort(arr, 0, arr.length);
    }

    private static void changeTree(float[] arr, int index, int begin, int end) {
        int max = index;
        int leftNode = 2*(index - begin) + 1 + begin;
        int rightNode = 2*(index - begin) + 2 + begin;
        if((leftNode < end)? arr[leftNode] > arr[max] : false) {
            max = leftNode;
        }
        if((rightNode < end)? arr[rightNode] > arr[max] : false) {
            max = rightNode;
        }
        if(max != index) {
            float tmp = arr[index];
            arr[index] = arr[max];
            arr[max] = tmp;
            changeTree(arr, max, begin, end);
        }
    }

    public static void HeapSort(float[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if(end - begin == 0) {
            return;
        }
        // create start tree
        for(int i = (end - begin)/2 -1 + begin; i >= begin; i--) {
            changeTree(arr, i, begin, end);
        }
        // sort of arr
        for (int i = end - 1; i >= begin; i--) {
            float tmp = arr[i];
            arr[i] = arr[begin];
            arr[begin] = tmp;
            changeTree(arr, begin, begin, i);
        }
    }

    public static void HeapSort(float[] arr) {
        HeapSort(arr, 0, arr.length);
    }

    private static void mergeSortR(float[] arrSrc, int begin, int end) {
        if(end - begin <= 1) {
            return;
        }
        int mid = (end - begin)/2 + begin;
        int sizeLeft = mid - begin, sizeRight = end - mid;
        float[] leftArr = new float[sizeLeft];
        for(int i  = begin; i < mid; i++) {
            leftArr[i-begin] = arrSrc[i];
        }
        float[] rightArr = new float[sizeRight];
        for(int i  = mid; i < end; i++) {
            rightArr[i-mid] = arrSrc[i];
        }
        mergeSortR(leftArr, 0, sizeLeft);
        mergeSortR(rightArr, 0,  sizeRight);
        int index = begin;
        for(int i = 0, j = 0; i < sizeLeft || j < sizeRight;) {
            if(i == sizeLeft) {
                arrSrc[index] = rightArr[j];
                j++;
                index++;
            } else if(j == sizeRight) {
                arrSrc[index] = leftArr[i];
                i++;
                index++;
            } else if (leftArr[i] < rightArr[j]) {
                arrSrc[index] = leftArr[i];
                i++;
                index++;
            } else {
                arrSrc[index] = rightArr[j];
                j++;
                index++;
            }
        }
    }

    public static void MergeSort(float[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if(end - begin == 0) {
            return;
        }
        mergeSortR(arr, begin, end);
    }

    public static void MergeSort(float[] arr) {
        MergeSort( arr, 0, arr.length);
    }

    private static void quickSortR(double[] arr, int begin, int end) {
        double supportElement = arr[(end - begin) / 2 + begin];
        int leftBound = begin, rightBound = end-1;
        while(leftBound <= rightBound) {
            while(arr[leftBound] < supportElement) {
                leftBound++;
            }
            while(arr[rightBound] > supportElement) {
                rightBound--;
            }
            if(leftBound <= rightBound) {
                double tmp = arr[rightBound];
                arr[rightBound] = arr[leftBound];
                arr[leftBound] = tmp;
                leftBound++;
                rightBound--;
            }
        }
        if(rightBound > begin) {
            quickSortR(arr, begin, rightBound+1);
        }
        if(leftBound < end-1) {
            quickSortR(arr, leftBound, end);
        }
    }

    public static void QuickSort(double[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if(end - begin == 0) {
            return;
        }
        quickSortR(arr, begin, end);
    }

    public static void QuickSort(double[] arr) {
        QuickSort(arr, 0, arr.length);
    }

    private static void changeTree(double[] arr, int index, int begin, int end) {
        int max = index;
        int leftNode = 2*(index - begin) + 1 + begin;
        int rightNode = 2*(index - begin) + 2 + begin;
        if((leftNode < end)? arr[leftNode] > arr[max] : false) {
            max = leftNode;
        }
        if((rightNode < end)? arr[rightNode] > arr[max] : false) {
            max = rightNode;
        }
        if(max != index) {
            double tmp = arr[index];
            arr[index] = arr[max];
            arr[max] = tmp;
            changeTree(arr, max, begin, end);
        }
    }

    public static void HeapSort(double[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if(end - begin == 0) {
            return;
        }
        // create start tree
        for(int i = (end - begin)/2 -1 + begin; i >= begin; i--) {
            changeTree(arr, i, begin, end);
        }
        // sort of arr
        for (int i = end - 1; i >= begin; i--) {
            double tmp = arr[i];
            arr[i] = arr[begin];
            arr[begin] = tmp;
            changeTree(arr, begin, begin, i);
        }
    }

    public static void HeapSort(double[] arr) {
        HeapSort(arr, 0, arr.length);
    }

    private static void mergeSortR(double[] arrSrc, int begin, int end) {
        if(end - begin <= 1) {
            return;
        }
        int mid = (end - begin)/2 + begin;
        int sizeLeft = mid - begin, sizeRight = end - mid;
        double[] leftArr = new double[sizeLeft];
        for(int i  = begin; i < mid; i++) {
            leftArr[i-begin] = arrSrc[i];
        }
        double[] rightArr = new double[sizeRight];
        for(int i  = mid; i < end; i++) {
            rightArr[i-mid] = arrSrc[i];
        }
        mergeSortR(leftArr, 0, sizeLeft);
        mergeSortR(rightArr, 0,  sizeRight);
        int index = begin;
        for(int i = 0, j = 0; i < sizeLeft || j < sizeRight;) {
            if(i == sizeLeft) {
                arrSrc[index] = rightArr[j];
                j++;
                index++;
            } else if(j == sizeRight) {
                arrSrc[index] = leftArr[i];
                i++;
                index++;
            } else if (leftArr[i] < rightArr[j]) {
                arrSrc[index] = leftArr[i];
                i++;
                index++;
            } else {
                arrSrc[index] = rightArr[j];
                j++;
                index++;
            }
        }
    }

    public static void MergeSort(double[] arr, int begin, int end) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(end < begin) {
            throw new IllegalArgumentException();
        }
        if(begin < 0 || end < 0 || begin > arr.length || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if(end - begin == 0) {
            return;
        }
        mergeSortR(arr, begin, end);
    }

    public static void MergeSort(double[] arr) {
        MergeSort( arr, 0, arr.length);
    }
}
