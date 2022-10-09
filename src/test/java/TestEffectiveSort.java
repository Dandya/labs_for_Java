import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TestEffectiveSort {

    private void sortInBounds(List<Integer> list, int begin, int end) {
        /*
        subList ссылается на ту же память, что и list
        https://docs.oracle.com/javase/9/docs/api/java/util/List.html#subList-int-int-
        "The returned list is backed by this list, so non-structural changes in the returned list are reflected in this list"
         */
        List<Integer> subList = list.subList(begin, end);
        Collections.sort(subList);
    }

    private boolean Equals(List<Integer> list1, List<Integer> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Test
    void QuickSortGeneric() {
        Random rand = new Random();
        EffectiveSorts<Integer> Sorts = new EffectiveSorts<>();
        //---- sort full
        ArrayList<Integer> list = new ArrayList<>();
        int size = rand.nextInt(0, 353);
        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt());
        }
        List<Integer> rightList = (List<Integer>) list.clone();
        Collections.sort(rightList);
        Sorts.QuickSort(list);
        assertTrue(Equals(rightList, list));
        size = rand.nextInt(0, 353);
        Integer[] arrInt = new Integer[size];
        Integer[] rightArrInt = new Integer[size];
        for (int i = 0; i < size; i++) {
            arrInt[i] = rand.nextInt();
            rightArrInt[i] = arrInt[i];
        }
        Arrays.sort(rightArrInt);
        Sorts.QuickSort(arrInt);
        assertArrayEquals(rightArrInt, arrInt);
        //---- sort with bounds
        size = rand.nextInt(1, 353);
        int begin = rand.nextInt(0, size - 1);
        int end = rand.nextInt(begin, size - 1);
        list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt());
        }
        rightList = (List<Integer>) list.clone();
        sortInBounds(rightList, begin, end);
        Sorts.QuickSort(list, begin, end);
        assertTrue(Equals(rightList, list));
        arrInt = new Integer[size];
        rightArrInt = new Integer[size];
        for (int i = 0; i < size; i++) {
            arrInt[i] = rand.nextInt();
            rightArrInt[i] = arrInt[i];
        }
        Arrays.sort(rightArrInt, begin, end);
        Sorts.QuickSort(arrInt, begin, end);
        assertArrayEquals(rightArrInt, arrInt);
        //---- test on Exception
        try {
            Sorts.QuickSort((List<Integer>) null);
        } catch (NullPointerException e) {
            assertTrue(true);
        }
        try {
            Sorts.QuickSort(list, -1, end);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try {
            Sorts.QuickSort(list, begin, size + 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try {
            Sorts.QuickSort(list, end, begin);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    void HeapSortGeneric() {
        Random rand = new Random();
        EffectiveSorts<Integer> Sorts = new EffectiveSorts<>();
        //---- sort full
        ArrayList<Integer> list = new ArrayList<>();
        int size = rand.nextInt(0, 353);
        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt());
        }
        List<Integer> rightList = (List<Integer>) list.clone();
        Collections.sort(rightList);
        Sorts.HeapSort(list);
        assertTrue(Equals(rightList, list));
        size = rand.nextInt(0, 353);
        Integer[] arrInt = new Integer[size];
        Integer[] rightArrInt = new Integer[size];
        for (int i = 0; i < size; i++) {
            arrInt[i] = rand.nextInt();
            rightArrInt[i] = arrInt[i];
        }
        Arrays.sort(rightArrInt);
        Sorts.HeapSort(arrInt);
        assertArrayEquals(rightArrInt, arrInt);
        //---- sort with bounds
        size = rand.nextInt(1, 353);
        int begin = rand.nextInt(0, size - 1);
        int end = rand.nextInt(begin, size - 1);
        list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt());
        }
        rightList = (List<Integer>) list.clone();
        sortInBounds(rightList, begin, end);
        Sorts.HeapSort(list, begin, end);
        assertTrue(Equals(rightList, list));
        arrInt = new Integer[size];
        rightArrInt = new Integer[size];
        for (int i = 0; i < size; i++) {
            arrInt[i] = rand.nextInt();
            rightArrInt[i] = arrInt[i];
        }
        Arrays.sort(rightArrInt, begin, end);
        Sorts.HeapSort(arrInt, begin, end);
        assertArrayEquals(rightArrInt, arrInt);
        //---- test on Exception
        try {
            Sorts.HeapSort((List<Integer>) null);
        } catch (NullPointerException e) {
            assertTrue(true);
        }
        try {
            Sorts.HeapSort(list, -1, end);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try {
            Sorts.HeapSort(list, begin, size + 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try {
            Sorts.HeapSort(list, end, begin);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    void MergeSortGeneric() {
        Random rand = new Random();
        EffectiveSorts<Integer> Sorts = new EffectiveSorts<>();
        //---- sort full
        ArrayList<Integer> list = new ArrayList<>();
        int size = rand.nextInt(0, 353);
        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt());
        }
        List<Integer> rightList = (List<Integer>) list.clone();
        Collections.sort(rightList);
        Sorts.MergeSort(list);
        assertTrue(Equals(rightList, list));
        size = rand.nextInt(0, 353);
        Integer[] arrInt = new Integer[size];
        Integer[] rightArrInt = new Integer[size];
        for (int i = 0; i < size; i++) {
            arrInt[i] = rand.nextInt();
            rightArrInt[i] = arrInt[i];
        }
        Arrays.sort(rightArrInt);
        Sorts.MergeSort(arrInt);
        assertArrayEquals(rightArrInt, arrInt);
        //---- sort with bounds
        size = rand.nextInt(1, 353);
        int begin = rand.nextInt(0, size - 1);
        int end = rand.nextInt(begin, size - 1);
        list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt());
        }
        rightList = (List<Integer>) list.clone();
        sortInBounds(rightList, begin, end);
        Sorts.MergeSort(list, begin, end);
        assertTrue(Equals(rightList, list));
        arrInt = new Integer[size];
        rightArrInt = new Integer[size];
        for (int i = 0; i < size; i++) {
            arrInt[i] = rand.nextInt();
            rightArrInt[i] = arrInt[i];
        }
        Arrays.sort(rightArrInt, begin, end);
        Sorts.MergeSort(arrInt, begin, end);
        assertArrayEquals(rightArrInt, arrInt);
        //---- test on Exception
        try {
            Sorts.MergeSort((List<Integer>) null);
        } catch (NullPointerException e) {
            assertTrue(true);
        }
        try {
            Sorts.MergeSort(list, -1, end);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try {
            Sorts.MergeSort(list, begin, size + 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try {
            Sorts.MergeSort(list, end, begin);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }
}
