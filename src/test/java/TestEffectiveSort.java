import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TestEffectiveSort {

    private void sortInBounds(List<Integer> list, int begin, int end) {
        /*
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
        size = rand.nextInt(2, 353);
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
        size = rand.nextInt(2, 353);
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
        size = rand.nextInt(2, 353);
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

    @Test
    void ByteSort(){
        Random rand = new Random();
        //---- sort full
        int size = rand.nextInt(0, 353);
        byte[] arr = new byte[size];
        byte[] rightArr, tmp;
        rand.nextBytes(arr);
        rightArr = Arrays.copyOf(arr, arr.length);
        tmp = Arrays.copyOf(arr, arr.length);
        tmp = Arrays.copyOf(arr, arr.length);
        if(size > 0) {
            rightArr[0] = (byte) (arr[0] + 1);
            assertTrue(rightArr[0] != arr[0]);
            rightArr[0] = arr[0];
        }
        Arrays.sort(rightArr);
        EffectiveSorts.QuickSort(arr);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        EffectiveSorts.HeapSort(arr);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        EffectiveSorts.MergeSort(arr);
        assertArrayEquals(rightArr, arr);
        //---- sort with bounds
        size = rand.nextInt(2, 353);
        int begin = rand.nextInt(0, size-1);
        int end = rand.nextInt(begin, size-1);
        arr = new byte[size];
        rand.nextBytes(arr);
        rightArr = Arrays.copyOf(arr, arr.length);
        tmp = Arrays.copyOf(arr, arr.length);
        if(size > 0) {
            rightArr[0] = (byte) (arr[0] + 1);
            assertTrue(rightArr[0] != arr[0]);
            rightArr[0] = arr[0];
        }
        Arrays.sort(rightArr, begin, end);
        EffectiveSorts.QuickSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        EffectiveSorts.HeapSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        EffectiveSorts.MergeSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        //---- test on Exception
        try{
            EffectiveSorts.MergeSort((byte[]) null);
        } catch (NullPointerException e) {
            assertTrue(true);
        }
        try{
            EffectiveSorts.MergeSort(arr, -1, end);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try{
            EffectiveSorts.MergeSort(arr, begin, size+1);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try{
            EffectiveSorts.MergeSort(arr, end, begin);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    void ShortSort(){
        Random rand = new Random();
        //---- sort full
        int size = rand.nextInt(0, 353);
        short[] arr = new short[size];
        short[] rightArr, tmp;
        for(int i = 0; i < size; i++) {
            arr[i] = (short) rand.nextInt();
        }
        rightArr = Arrays.copyOf(arr, arr.length);
        tmp = Arrays.copyOf(arr, arr.length);
        if(size > 0) {
            rightArr[0] = (short) (arr[0] + 1);
            assertTrue(rightArr[0] != arr[0]);
            rightArr[0] = arr[0];
        }
        Arrays.sort(rightArr);
        EffectiveSorts.QuickSort(arr);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        EffectiveSorts.HeapSort(arr);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        EffectiveSorts.MergeSort(arr);
        assertArrayEquals(rightArr, arr);
        //---- sort with bounds
        size = rand.nextInt(2, 353);
        int begin = rand.nextInt(0, size-1);
        int end = rand.nextInt(begin, size-1);
        arr = new short[size];
        for(int i = 0; i < size; i++) {
            arr[i] = (short) rand.nextInt();
        }
        rightArr = Arrays.copyOf(arr, arr.length);
        tmp = Arrays.copyOf(arr, arr.length);
        if(size > 0) {
            rightArr[0] = (short) (arr[0] + 1);
            assertTrue(rightArr[0] != arr[0]);
            rightArr[0] = arr[0];
        }
        Arrays.sort(rightArr, begin, end);
        EffectiveSorts.QuickSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        EffectiveSorts.HeapSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        EffectiveSorts.MergeSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        //---- test on Exception
        try{
            EffectiveSorts.MergeSort((short[]) null);
        } catch (NullPointerException e) {
            assertTrue(true);
        }
        try{
            EffectiveSorts.MergeSort(arr, -1, end);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try{
            EffectiveSorts.MergeSort(arr, begin, size+1);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try{
            EffectiveSorts.MergeSort(arr, end, begin);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    void IntSort(){
        Random rand = new Random();
        //---- sort full
        int size = rand.nextInt(0, 353);
        int[] arr = new int[size];
        int[] rightArr, tmp;
        for(int i = 0; i < size; i++) {
            arr[i] = rand.nextInt();
        }
        rightArr = Arrays.copyOf(arr, arr.length);
        tmp = Arrays.copyOf(arr, arr.length);
        if(size > 0) {
            rightArr[0] = (int) (arr[0] + 1);
            assertTrue(rightArr[0] != arr[0]);
            rightArr[0] = arr[0];
        }
        Arrays.sort(rightArr);
        EffectiveSorts.QuickSort(arr);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        EffectiveSorts.HeapSort(arr);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        EffectiveSorts.MergeSort(arr);
        assertArrayEquals(rightArr, arr);
        //---- sort with bounds
        size = rand.nextInt(2, 353);
        int begin = rand.nextInt(0, size-1);
        int end = rand.nextInt(begin, size-1);
        arr = new int[size];
        for(int i = 0; i < size; i++) {
            arr[i] = rand.nextInt();
        }
        rightArr = Arrays.copyOf(arr, arr.length);
        tmp = Arrays.copyOf(arr, arr.length);
        if(size > 0) {
            rightArr[0] = (int) (arr[0] + 1);
            assertTrue(rightArr[0] != arr[0]);
            rightArr[0] = arr[0];
        }
        Arrays.sort(rightArr, begin, end);
        EffectiveSorts.QuickSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        EffectiveSorts.HeapSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        EffectiveSorts.MergeSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        //---- test on Exception
        try{
            EffectiveSorts.MergeSort((int[]) null);
        } catch (NullPointerException e) {
            assertTrue(true);
        }
        try{
            EffectiveSorts.MergeSort(arr, -1, end);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try{
            EffectiveSorts.MergeSort(arr, begin, size+1);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try{
            EffectiveSorts.MergeSort(arr, end, begin);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    void LongSort(){
        Random rand = new Random();
        //---- sort full
        int size = rand.nextInt(0, 353);
        long[] arr = new long[size];
        long[] rightArr, tmp;
        for(int i = 0; i < size; i++) {
            arr[i] = rand.nextLong();
        }
        rightArr = Arrays.copyOf(arr, arr.length);
        tmp = Arrays.copyOf(arr, arr.length);
        if(size > 0) {
            rightArr[0] = (long) (arr[0] + 1);
            assertTrue(rightArr[0] != arr[0]);
            rightArr[0] = arr[0];
        }
        Arrays.sort(rightArr);
        EffectiveSorts.QuickSort(arr);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        EffectiveSorts.HeapSort(arr);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        EffectiveSorts.MergeSort(arr);
        assertArrayEquals(rightArr, arr);
        //---- sort with bounds
        size = rand.nextInt(2, 353);
        int begin = rand.nextInt(0, size-1);
        int end = rand.nextInt(begin, size-1);
        arr = new long[size];
        for(int i = 0; i < size; i++) {
            arr[i] = rand.nextLong();
        }
        rightArr = Arrays.copyOf(arr, arr.length);
        tmp = Arrays.copyOf(arr, arr.length);
        if(size > 0) {
            rightArr[0] = (long) (arr[0] + 1);
            assertTrue(rightArr[0] != arr[0]);
            rightArr[0] = arr[0];
        }
        Arrays.sort(rightArr, begin, end);
        EffectiveSorts.QuickSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        EffectiveSorts.HeapSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        EffectiveSorts.MergeSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        //---- test on Exception
        try{
            EffectiveSorts.MergeSort((long[]) null);
        } catch (NullPointerException e) {
            assertTrue(true);
        }
        try{
            EffectiveSorts.MergeSort(arr, -1, end);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try{
            EffectiveSorts.MergeSort(arr, begin, size+1);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try{
            EffectiveSorts.MergeSort(arr, end, begin);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    void charSort(){
        Random rand = new Random();
        //---- sort full
        int size = rand.nextInt(0, 353);
        char[] arr = new char[size];
        char[] rightArr, tmp;
        for(int i = 0; i < size; i++) {
            arr[i] = (char) rand.nextInt();
        }
        rightArr = Arrays.copyOf(arr, arr.length);
        tmp = Arrays.copyOf(arr, arr.length);
        if(size > 0) {
            rightArr[0] = (char) (arr[0] + 1);
            assertTrue(rightArr[0] != arr[0]);
            rightArr[0] = arr[0];
        }
        Arrays.sort(rightArr);
        EffectiveSorts.QuickSort(arr);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        EffectiveSorts.HeapSort(arr);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        EffectiveSorts.MergeSort(arr);
        assertArrayEquals(rightArr, arr);
        //---- sort with bounds
        size = rand.nextInt(2, 353);
        int begin = rand.nextInt(0, size-1);
        int end = rand.nextInt(begin, size-1);
        arr = new char[size];
        for(int i = 0; i < size; i++) {
            arr[i] = (char) rand.nextInt();
        }
        rightArr = Arrays.copyOf(arr, arr.length);
        tmp = Arrays.copyOf(arr, arr.length);
        if(size > 0) {
            rightArr[0] = (char) (arr[0] + 1);
            assertTrue(rightArr[0] != arr[0]);
            rightArr[0] = arr[0];
        }
        Arrays.sort(rightArr, begin, end);
        EffectiveSorts.QuickSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        EffectiveSorts.HeapSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        EffectiveSorts.MergeSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        //---- test on Exception
        try{
            EffectiveSorts.MergeSort((char[]) null);
        } catch (NullPointerException e) {
            assertTrue(true);
        }
        try{
            EffectiveSorts.MergeSort(arr, -1, end);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try{
            EffectiveSorts.MergeSort(arr, begin, size+1);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try{
            EffectiveSorts.MergeSort(arr, end, begin);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    void floatSort(){
        Random rand = new Random();
        //---- sort full
        int size = rand.nextInt(0, 353);
        float[] arr = new float[size];
        float[] rightArr, tmp;
        for(int i = 0; i < size; i++) {
            arr[i] = rand.nextFloat() +((float) rand.nextInt());
        }
        rightArr = Arrays.copyOf(arr, arr.length);
        tmp = Arrays.copyOf(arr, arr.length);
        if(size > 0) {
            rightArr[0] = (float) (arr[0] + 1e10f);
            assertTrue(rightArr[0] - arr[0] > 1E-5);
            rightArr[0] = arr[0];
        }
        Arrays.sort(rightArr);
        EffectiveSorts.QuickSort(arr);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        EffectiveSorts.HeapSort(arr);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        EffectiveSorts.MergeSort(arr);
        assertArrayEquals(rightArr, arr);
        //---- sort with bounds
        size = rand.nextInt(2, 353);
        int begin = rand.nextInt(0, size-1);
        int end = rand.nextInt(begin, size-1);
        arr = new float[size];
        for(int i = 0; i < size; i++) {
            arr[i] = rand.nextFloat() +((float) rand.nextInt());
        }
        rightArr = Arrays.copyOf(arr, arr.length);
        tmp = Arrays.copyOf(arr, arr.length);
        if(size > 0) {
            rightArr[0] = (float) (arr[0] + 1e10f);
            assertTrue(rightArr[0] - arr[0] > 1E-5);
            rightArr[0] = arr[0];
        }
        Arrays.sort(rightArr, begin, end);
        EffectiveSorts.QuickSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        EffectiveSorts.HeapSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        EffectiveSorts.MergeSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        //---- test on Exception
        try{
            EffectiveSorts.MergeSort((float[]) null);
        } catch (NullPointerException e) {
            assertTrue(true);
        }
        try{
            EffectiveSorts.MergeSort(arr, -1, end);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try{
            EffectiveSorts.MergeSort(arr, begin, size+1);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try{
            EffectiveSorts.MergeSort(arr, end, begin);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    void doubleSort(){
        Random rand = new Random();
        //---- sort full
        int size = rand.nextInt(0, 353);
        double[] arr = new double[size];
        double[] rightArr, tmp;
        for(int i = 0; i < size; i++) {
            arr[i] = rand.nextDouble() +((double) rand.nextInt());
        }
        rightArr = Arrays.copyOf(arr, arr.length);
        tmp = Arrays.copyOf(arr, arr.length);
        if(size > 0) {
            rightArr[0] = (double) (arr[0] + 1e10d);
            assertTrue(rightArr[0] != arr[0]);
            rightArr[0] = arr[0];
        }
        Arrays.sort(rightArr);
        EffectiveSorts.QuickSort(arr);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        EffectiveSorts.HeapSort(arr);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        EffectiveSorts.MergeSort(arr);
        assertArrayEquals(rightArr, arr);
        //---- sort with bounds
        size = rand.nextInt(2, 353);
        int begin = rand.nextInt(0, size-1);
        int end = rand.nextInt(begin, size-1);
        arr = new double[size];
        for(int i = 0; i < size; i++) {
            arr[i] = rand.nextDouble() +((double) rand.nextInt());
        }
        rightArr = Arrays.copyOf(arr, arr.length);
        tmp = Arrays.copyOf(arr, arr.length);
        if(size > 0) {
            rightArr[0] = (double) (arr[0] + 1e10d);
            assertTrue(rightArr[0] != arr[0]);
            rightArr[0] = arr[0];
        }
        Arrays.sort(rightArr, begin, end);
        EffectiveSorts.QuickSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        EffectiveSorts.HeapSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        EffectiveSorts.MergeSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        //---- test on Exception
        try{
            EffectiveSorts.MergeSort((double[]) null);
        } catch (NullPointerException e) {
            assertTrue(true);
        }
        try{
            EffectiveSorts.MergeSort(arr, -1, end);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try{
            EffectiveSorts.MergeSort(arr, begin, size+1);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try{
            EffectiveSorts.MergeSort(arr, end, begin);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }
}
