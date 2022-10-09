import java.util.ArrayList;
import java.util.List;

public class EffectiveSorts<Type extends Comparable<Type>> {

    public EffectiveSorts(){
    }

    private void testOfParameters(List<Type> list, int begin, int end) throws ArrayIndexOutOfBoundsException,
            NullPointerException, IllegalArgumentException {
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

    private void testOfParameters(Type[] arr, int begin, int end) throws ArrayIndexOutOfBoundsException,
            NullPointerException, IllegalArgumentException {
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

    public void QuickSort(List<Type> list, int begin, int end) throws ArrayIndexOutOfBoundsException,
            NullPointerException, IllegalArgumentException {
        testOfParameters(list, begin, end);
        if(end - begin == 0) {
            return;
        }
        quickSortR(list, begin, end);
    }

    public void QuickSort(List<Type> list) throws ArrayIndexOutOfBoundsException,
            NullPointerException, IllegalArgumentException {
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

    public void QuickSort(Type[] arr, int begin, int end) throws ArrayIndexOutOfBoundsException,
            NullPointerException, IllegalArgumentException {
        testOfParameters(arr, begin, end);
        if(end - begin == 0) {
            return;
        }
        quickSortR(arr, begin, end);
    }

    public void QuickSort(Type[] arr) throws ArrayIndexOutOfBoundsException,
            NullPointerException, IllegalArgumentException {
        this.QuickSort(arr, 0, arr.length);
    }

    private void changeTree(List<Type> list, int index, int begin, int end) {
        int max = index;
        int leftNode = 2*(index - begin) + 1 + begin;
        int rightNode = 2*(index - begin) + 2 + begin;
        if((leftNode < end)? list.get(leftNode).compareTo(list.get(max)) > 0 : false) {
           int tmp  = max;
           max = leftNode;
           leftNode = tmp;
        }
        if((rightNode < end)? list.get(rightNode).compareTo(list.get(max)) > 0 : false) {
            int tmp  = max;
            max = rightNode;
            leftNode = tmp;
        }
        if(max != index) {
            list.set(index, list.set(max, list.get(index)));
            changeTree(list, max, begin, end);
        }
    }

    public void HeapSort(List<Type> list, int begin, int end) throws ArrayIndexOutOfBoundsException,
            NullPointerException, IllegalArgumentException {
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

    public void HeapSort(List<Type> list) throws ArrayIndexOutOfBoundsException,
            NullPointerException, IllegalArgumentException {
        this.HeapSort(list, 0, list.size());
    }

    private void changeTree(Type[] arr, int index, int begin, int end) {
        int max = index;
        int leftNode = 2*(index - begin) + 1 + begin;
        int rightNode = 2*(index - begin) + 2 + begin;
        if((leftNode < end)? arr[leftNode].compareTo(arr[max]) > 0 : false) {
            int tmp  = max;
            max = leftNode;
            leftNode = tmp;
        }
        if((rightNode < end)? arr[rightNode].compareTo(arr[max]) > 0 : false) {
            int tmp  = max;
            max = rightNode;
            leftNode = tmp;
        }
        if(max != index) {
            Type tmp = arr[index];
            arr[index] = arr[max];
            arr[max] = tmp;
            changeTree(arr, max, begin, end);
        }
    }

    public void HeapSort(Type[] arr, int begin, int end) throws ArrayIndexOutOfBoundsException,
            NullPointerException, IllegalArgumentException {
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

    public void HeapSort(Type[] arr) throws ArrayIndexOutOfBoundsException,
            NullPointerException, IllegalArgumentException {
        this.QuickSort(arr, 0, arr.length);
    }

    private void mergeSortR(List<Type> listSrc, int begin, int end) {
        if(end - begin == 1) {
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

    public void MergeSort(List<Type> list, int begin, int end) throws ArrayIndexOutOfBoundsException,
            NullPointerException, IllegalArgumentException {
        testOfParameters(list, begin, end);
        if(end - begin == 0) {
            return;
        }
        mergeSortR(list, begin, end);
    }

    public void MergeSort(List<Type> list) throws ArrayIndexOutOfBoundsException,
            NullPointerException, IllegalArgumentException {
        this.MergeSort(list, 0, list.size());
    }

    private void mergeSortR(Type[] arrSrc, int begin, int end) {
        if(end - begin == 1) {
            return;
        }
        int mid = (end - begin)/2 + begin;
        int sizeLeft = mid - begin, sizeRight = end - mid;
        Type[] leftArr = new Type[sizeLeft];
        for(int i  = begin; i < mid; i++) {
            leftArr[i-begin] = arrSrc[i];
        }
        Type[] rightArr = new Type[sizeRight];
        for(int i  = mid; i < end; i++) {
            
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

    public void MergeSort(Type[] arr) throws ArrayIndexOutOfBoundsException,
            NullPointerException, IllegalArgumentException {
        this.QuickSort(arr, 0, arr.length);
    }
}
