import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TestSimpleSort {

    private void sortInBounds(List<Integer> list, int begin, int end) {
        /*
        https://docs.oracle.com/javase/9/docs/api/java/util/List.html#subList-int-int-
        "The returned list is backed by this list, so non-structural changes in the returned list are reflected in this list"
         */
        List<Integer> subList = list.subList(begin, end);
        Collections.sort(subList);
    }

    private boolean Equals(List<Integer> list1, List<Integer> list2) {
        if(list1.size() != list2.size()) {
            return false;
        }
        for(int i = 0; i < list1.size(); i++) {
            if(!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Test
    void bubbleSortGeneric() {
        Random rand = new Random();
        SimpleSort<Integer> Sorts = new SimpleSort<>();
        //---- sort full
        ArrayList<Integer> list = new ArrayList<>();
        int size = rand.nextInt(0, 353);
        for(int i = 0; i < size; i++){
            list.add(rand.nextInt());
        }
        List<Integer> rightList = (List<Integer>) list.clone();
        Collections.sort(rightList);
        Sorts.BubbleSort(list);
        assertTrue(Equals(rightList, list));
        size = rand.nextInt(0, 353);
        Integer[] arrInt = new Integer[size];
        Integer[] rightArrInt = new Integer[size];
        for(int i = 0; i < size; i++){
            arrInt[i] = rand.nextInt();
            rightArrInt[i] = arrInt[i];
        }
        Arrays.sort(rightArrInt);
        Sorts.BubbleSort(arrInt);
        assertArrayEquals(rightArrInt, arrInt);
        //---- sort with bounds
        size = rand.nextInt(2, 353);
        int begin = rand.nextInt(0, size-1);
        int end = rand.nextInt(begin, size-1);
        list = new ArrayList<>();
        for(int i = 0; i < size; i++){
            list.add(rand.nextInt());
        }
        rightList = (List<Integer>) list.clone();
        sortInBounds(rightList, begin, end);
        Sorts.BubbleSort(list, begin, end);
        assertTrue(Equals(rightList, list));
        arrInt = new Integer[size];
        rightArrInt = new Integer[size];
        for(int i = 0; i < size; i++){
            arrInt[i] = rand.nextInt();
            rightArrInt[i] = arrInt[i];
        }
        Arrays.sort(rightArrInt, begin, end);
        Sorts.BubbleSort(arrInt, begin, end);
        assertArrayEquals(rightArrInt, arrInt);
        //---- test on Exception
        try{
            Sorts.BubbleSort((List<Integer>) null);
        } catch (NullPointerException e) {
            assertTrue(true);
        }
        try{
            Sorts.BubbleSort(list, -1, end);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try{
            Sorts.BubbleSort(list, begin, size+1);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try{
            Sorts.BubbleSort(list, end, begin);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }
    @Test
    void inputSortGeneric() {
        Random rand = new Random();
        SimpleSort<Integer> Sorts = new SimpleSort<>();
        //---- sort full
        ArrayList<Integer> list = new ArrayList<>();
        int size = rand.nextInt(0, 353);
        for(int i = 0; i < size; i++){
            list.add(rand.nextInt());
        }
        List<Integer> rightList = (List<Integer>) list.clone();
        Collections.sort(rightList);
        Sorts.InputSort(list);
        assertTrue(Equals(rightList, list));
        size = rand.nextInt(0, 353);
        Integer[] arrInt = new Integer[size];
        Integer[] rightArrInt = new Integer[size];
        for(int i = 0; i < size; i++){
            arrInt[i] = rand.nextInt();
            rightArrInt[i] = arrInt[i];
        }
        Arrays.sort(rightArrInt);
        Sorts.InputSort(arrInt);
        assertArrayEquals(rightArrInt, arrInt);
        //---- sort with bounds
        size = rand.nextInt(2, 353);
        int begin = rand.nextInt(0, size-1);
        int end = rand.nextInt(begin, size-1);
        list = new ArrayList<>();
        for(int i = 0; i < size; i++){
            list.add(rand.nextInt());
        }
        rightList = (List<Integer>) list.clone();
        sortInBounds(rightList, begin, end);
        Sorts.InputSort(list, begin, end);
        assertTrue(Equals(rightList, list));
        arrInt = new Integer[size];
        rightArrInt = new Integer[size];
        for(int i = 0; i < size; i++){
            arrInt[i] = rand.nextInt();
            rightArrInt[i] = arrInt[i];
        }
        Arrays.sort(rightArrInt, begin, end);
        Sorts.InputSort(arrInt, begin, end);
        assertArrayEquals(rightArrInt, arrInt);
        //---- test on Exception
        try{
            Sorts.InputSort((List<Integer>) null);
        } catch (NullPointerException e) {
            assertTrue(true);
        }
        try{
            Sorts.InputSort(list, -1, end);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try{
            Sorts.InputSort(list, begin, size+1);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try{
            Sorts.InputSort(list, end, begin);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    void selectSortGeneric() {
        Random rand = new Random();
        SimpleSort<Integer> Sorts = new SimpleSort<>();
        //---- sort full
        ArrayList<Integer> list = new ArrayList<>();
        int size = rand.nextInt(0, 353);
        for(int i = 0; i < size; i++){
            list.add(rand.nextInt());
        }
        List<Integer> rightList = (List<Integer>) list.clone();
        Collections.sort(rightList);
        Sorts.SelectSort(list);
        assertTrue(Equals(rightList, list));
        size = rand.nextInt(0, 353);
        Integer[] arrInt = new Integer[size];
        Integer[] rightArrInt = new Integer[size];
        for(int i = 0; i < size; i++){
            arrInt[i] = rand.nextInt();
            rightArrInt[i] = arrInt[i];
        }
        Arrays.sort(rightArrInt);
        Sorts.SelectSort(arrInt);
        assertArrayEquals(rightArrInt, arrInt);
        //---- sort with bounds
        size = rand.nextInt(2, 353);
        int begin = rand.nextInt(0, size-1);
        int end = rand.nextInt(begin, size-1);
        list = new ArrayList<>();
        for(int i = 0; i < size; i++){
            list.add(rand.nextInt());
        }
        rightList = (List<Integer>) list.clone();
        sortInBounds(rightList, begin, end);
        Sorts.SelectSort(list, begin, end);
        assertTrue(Equals(rightList, list));
        arrInt = new Integer[size];
        rightArrInt = new Integer[size];
        for(int i = 0; i < size; i++){
            arrInt[i] = rand.nextInt();
            rightArrInt[i] = arrInt[i];
        }
        Arrays.sort(rightArrInt, begin, end);
        Sorts.SelectSort(arrInt, begin, end);
        assertArrayEquals(rightArrInt, arrInt);
        //---- test on Exception
        try{
            Sorts.SelectSort((List<Integer>) null);
        } catch (NullPointerException e) {
            assertTrue(true);
        }
        try{
            Sorts.SelectSort(list, -1, end);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try{
            Sorts.SelectSort(list, begin, size+1);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try{
            Sorts.SelectSort(list, end, begin);
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
        SimpleSort.BubbleSort(arr);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        SimpleSort.InputSort(arr);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        SimpleSort.SelectSort(arr);
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
        SimpleSort.BubbleSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        SimpleSort.InputSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        SimpleSort.SelectSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        //---- test on Exception
        try{
            SimpleSort.SelectSort((byte[]) null);
        } catch (NullPointerException e) {
            assertTrue(true);
        }
        try{
            SimpleSort.SelectSort(arr, -1, end);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try{
            SimpleSort.SelectSort(arr, begin, size+1);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try{
            SimpleSort.SelectSort(arr, end, begin);
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
        SimpleSort.BubbleSort(arr);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        SimpleSort.InputSort(arr);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        SimpleSort.SelectSort(arr);
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
        SimpleSort.BubbleSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        SimpleSort.InputSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        SimpleSort.SelectSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        //---- test on Exception
        try{
            SimpleSort.SelectSort((short[]) null);
        } catch (NullPointerException e) {
            assertTrue(true);
        }
        try{
            SimpleSort.SelectSort(arr, -1, end);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try{
            SimpleSort.SelectSort(arr, begin, size+1);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try{
            SimpleSort.SelectSort(arr, end, begin);
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
        SimpleSort.BubbleSort(arr);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        SimpleSort.InputSort(arr);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        SimpleSort.SelectSort(arr);
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
        SimpleSort.BubbleSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        SimpleSort.InputSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        SimpleSort.SelectSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        //---- test on Exception
        try{
            SimpleSort.SelectSort((int[]) null);
        } catch (NullPointerException e) {
            assertTrue(true);
        }
        try{
            SimpleSort.SelectSort(arr, -1, end);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try{
            SimpleSort.SelectSort(arr, begin, size+1);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try{
            SimpleSort.SelectSort(arr, end, begin);
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
        SimpleSort.BubbleSort(arr);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        SimpleSort.InputSort(arr);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        SimpleSort.SelectSort(arr);
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
        SimpleSort.BubbleSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        SimpleSort.InputSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        SimpleSort.SelectSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        //---- test on Exception
        try{
            SimpleSort.SelectSort((long[]) null);
        } catch (NullPointerException e) {
            assertTrue(true);
        }
        try{
            SimpleSort.SelectSort(arr, -1, end);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try{
            SimpleSort.SelectSort(arr, begin, size+1);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try{
            SimpleSort.SelectSort(arr, end, begin);
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
        SimpleSort.BubbleSort(arr);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        SimpleSort.InputSort(arr);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        SimpleSort.SelectSort(arr);
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
        SimpleSort.BubbleSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        SimpleSort.InputSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        SimpleSort.SelectSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        //---- test on Exception
        try{
            SimpleSort.SelectSort((char[]) null);
        } catch (NullPointerException e) {
            assertTrue(true);
        }
        try{
            SimpleSort.SelectSort(arr, -1, end);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try{
            SimpleSort.SelectSort(arr, begin, size+1);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try{
            SimpleSort.SelectSort(arr, end, begin);
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
        SimpleSort.BubbleSort(arr);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        SimpleSort.InputSort(arr);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        SimpleSort.SelectSort(arr);
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
        SimpleSort.BubbleSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        SimpleSort.InputSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        SimpleSort.SelectSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        //---- test on Exception
        try{
            SimpleSort.SelectSort((float[]) null);
        } catch (NullPointerException e) {
            assertTrue(true);
        }
        try{
            SimpleSort.SelectSort(arr, -1, end);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try{
            SimpleSort.SelectSort(arr, begin, size+1);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try{
            SimpleSort.SelectSort(arr, end, begin);
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
        SimpleSort.BubbleSort(arr);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        SimpleSort.InputSort(arr);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        SimpleSort.SelectSort(arr);
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
        SimpleSort.BubbleSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        SimpleSort.InputSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        arr = Arrays.copyOf(tmp, tmp.length);
        SimpleSort.SelectSort(arr, begin, end);
        assertArrayEquals(rightArr, arr);
        //---- test on Exception
        try{
            SimpleSort.SelectSort((double[]) null);
        } catch (NullPointerException e) {
            assertTrue(true);
        }
        try{
            SimpleSort.SelectSort(arr, -1, end);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try{
            SimpleSort.SelectSort(arr, begin, size+1);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try{
            SimpleSort.SelectSort(arr, end, begin);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    void EmptyArrayAndList() {
        List<String> list = new ArrayList<>();
        String[] arr1 = new String[0];
        int[] arr2 = new int[0];
        SimpleSort<String> Sorts = new SimpleSort<>();
        try {
            Sorts.BubbleSort(list);
            Sorts.InputSort(list);
            Sorts.SelectSort(list);
            Sorts.BubbleSort(arr1);
            Sorts.InputSort(arr1);
            Sorts.SelectSort(arr1);
            SimpleSort.BubbleSort(arr2);
            SimpleSort.InputSort(arr2);
            SimpleSort.SelectSort(arr2);
            assertTrue(true);
        } catch (Exception e) {
            fail();
        }
    }
}