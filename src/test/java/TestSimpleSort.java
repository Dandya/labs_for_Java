import com.sun.source.tree.AssertTree;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TestSimpleSort {

    private static final boolean isInputTest = false;

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
        assertTrue(Equals(rightList, Sorts.BubbleSort(list)));
        size = rand.nextInt(0, 353);
        Integer[] arrInt = new Integer[size];
        Integer[] rightArrInt = new Integer[size];
        for(int i = 0; i < size; i++){
            arrInt[i] = rand.nextInt();
            rightArrInt[i] = arrInt[i];
        }
        Arrays.sort(rightArrInt);
        assertArrayEquals(rightArrInt, Sorts.BubbleSort(arrInt));
        //---- sort with bounds
        size = rand.nextInt(1, 353);
        int begin = rand.nextInt(0, size-1);
        int end = rand.nextInt(begin, size-1);
        list = new ArrayList<>();
        for(int i = 0; i < size; i++){
            list.add(rand.nextInt());
        }
        rightList = (List<Integer>) list.clone();
        sortInBounds(rightList, begin, end);
        assertTrue(Equals(rightList, Sorts.BubbleSort(list, begin, end)));
        arrInt = new Integer[size];
        rightArrInt = new Integer[size];
        for(int i = 0; i < size; i++){
            arrInt[i] = rand.nextInt();
            rightArrInt[i] = arrInt[i];
        }
        Arrays.sort(rightArrInt, begin, end);
        assertArrayEquals(rightArrInt, Sorts.BubbleSort(arrInt, begin, end));
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
        assertTrue(Equals(rightList, Sorts.InputSort(list)));
        size = rand.nextInt(0, 353);
        Integer[] arrInt = new Integer[size];
        Integer[] rightArrInt = new Integer[size];
        for(int i = 0; i < size; i++){
            arrInt[i] = rand.nextInt();
            rightArrInt[i] = arrInt[i];
        }
        Arrays.sort(rightArrInt);
        assertArrayEquals(rightArrInt, Sorts.InputSort(arrInt));
        //---- sort with bounds
        size = rand.nextInt(1, 353);
        int begin = rand.nextInt(0, size-1);
        int end = rand.nextInt(begin, size-1);
        list = new ArrayList<>();
        for(int i = 0; i < size; i++){
            list.add(rand.nextInt());
        }
        rightList = (List<Integer>) list.clone();
        sortInBounds(rightList, begin, end);
        assertTrue(Equals(rightList, Sorts.InputSort(list, begin, end)));
        arrInt = new Integer[size];
        rightArrInt = new Integer[size];
        for(int i = 0; i < size; i++){
            arrInt[i] = rand.nextInt();
            rightArrInt[i] = arrInt[i];
        }
        Arrays.sort(rightArrInt, begin, end);
        assertArrayEquals(rightArrInt, Sorts.InputSort(arrInt, begin, end));
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
        assertTrue(Equals(rightList, Sorts.SelectSort(list)));
        size = rand.nextInt(0, 353);
        Integer[] arrInt = new Integer[size];
        Integer[] rightArrInt = new Integer[size];
        for(int i = 0; i < size; i++){
            arrInt[i] = rand.nextInt();
            rightArrInt[i] = arrInt[i];
        }
        Arrays.sort(rightArrInt);
        assertArrayEquals(rightArrInt, Sorts.SelectSort(arrInt));
        //---- sort with bounds
        size = rand.nextInt(1, 353);
        int begin = rand.nextInt(0, size-1);
        int end = rand.nextInt(begin, size-1);
        list = new ArrayList<>();
        for(int i = 0; i < size; i++){
            list.add(rand.nextInt());
        }
        rightList = (List<Integer>) list.clone();
        sortInBounds(rightList, begin, end);
        assertTrue(Equals(rightList, Sorts.SelectSort(list, begin, end)));
        arrInt = new Integer[size];
        rightArrInt = new Integer[size];
        for(int i = 0; i < size; i++){
            arrInt[i] = rand.nextInt();
            rightArrInt[i] = arrInt[i];
        }
        Arrays.sort(rightArrInt, begin, end);
        assertArrayEquals(rightArrInt, Sorts.SelectSort(arrInt, begin, end));
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
        byte[] rightArr;
        rand.nextBytes(arr);
        rightArr = Arrays.copyOf(arr, arr.length);
        if(size > 0) {
            rightArr[0] = (byte) (arr[0] + 1);
            assertTrue(rightArr[0] != arr[0]);
            rightArr[0] = arr[0];
        }
        Arrays.sort(rightArr);
        assertArrayEquals(rightArr, SimpleSort.BubbleSort(Arrays.copyOf(arr, arr.length)));
        assertArrayEquals(rightArr, SimpleSort.InputSort(Arrays.copyOf(arr, arr.length)));
        assertArrayEquals(rightArr, SimpleSort.SelectSort(Arrays.copyOf(arr, arr.length)));
        //---- sort with bounds
        size = rand.nextInt(1, 353);
        int begin = rand.nextInt(0, size-1);
        int end = rand.nextInt(begin, size-1);
        arr = new byte[size];
        rand.nextBytes(arr);
        rightArr = Arrays.copyOf(arr, arr.length);
        if(size > 0) {
            rightArr[0] = (byte) (arr[0] + 1);
            assertTrue(rightArr[0] != arr[0]);
            rightArr[0] = arr[0];
        }
        Arrays.sort(rightArr, begin, end);
        assertArrayEquals(rightArr, SimpleSort.BubbleSort(Arrays.copyOf(arr, arr.length), begin, end));
        assertArrayEquals(rightArr, SimpleSort.InputSort(Arrays.copyOf(arr, arr.length), begin, end));
        assertArrayEquals(rightArr, SimpleSort.SelectSort(Arrays.copyOf(arr, arr.length), begin, end));
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
        short[] rightArr;
        for(int i = 0; i < size; i++) {
            arr[i] = (short) rand.nextInt();
        }
        rightArr = Arrays.copyOf(arr, arr.length);
        if(size > 0) {
            rightArr[0] = (short) (arr[0] + 1);
            assertTrue(rightArr[0] != arr[0]);
            rightArr[0] = arr[0];
        }
        Arrays.sort(rightArr);
        assertArrayEquals(rightArr, SimpleSort.BubbleSort(Arrays.copyOf(arr, arr.length)));
        assertArrayEquals(rightArr, SimpleSort.InputSort(Arrays.copyOf(arr, arr.length)));
        assertArrayEquals(rightArr, SimpleSort.SelectSort(Arrays.copyOf(arr, arr.length)));
        //---- sort with bounds
        size = rand.nextInt(1, 353);
        int begin = rand.nextInt(0, size-1);
        int end = rand.nextInt(begin, size-1);
        arr = new short[size];
        for(int i = 0; i < size; i++) {
            arr[i] = (short) rand.nextInt();
        }
        rightArr = Arrays.copyOf(arr, arr.length);
        if(size > 0) {
            rightArr[0] = (short) (arr[0] + 1);
            assertTrue(rightArr[0] != arr[0]);
            rightArr[0] = arr[0];
        }
        Arrays.sort(rightArr, begin, end);
        assertArrayEquals(rightArr, SimpleSort.BubbleSort(Arrays.copyOf(arr, arr.length), begin, end));
        assertArrayEquals(rightArr, SimpleSort.InputSort(Arrays.copyOf(arr, arr.length), begin, end));
        assertArrayEquals(rightArr, SimpleSort.SelectSort(Arrays.copyOf(arr, arr.length), begin, end));
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
        int[] rightArr;
        for(int i = 0; i < size; i++) {
            arr[i] = rand.nextInt();
        }
        rightArr = Arrays.copyOf(arr, arr.length);
        if(size > 0) {
            rightArr[0] = (int) (arr[0] + 1);
            assertTrue(rightArr[0] != arr[0]);
            rightArr[0] = arr[0];
        }
        Arrays.sort(rightArr);
        assertArrayEquals(rightArr, SimpleSort.BubbleSort(Arrays.copyOf(arr, arr.length)));
        assertArrayEquals(rightArr, SimpleSort.InputSort(Arrays.copyOf(arr, arr.length)));
        assertArrayEquals(rightArr, SimpleSort.SelectSort(Arrays.copyOf(arr, arr.length)));
        //---- sort with bounds
        size = rand.nextInt(1, 353);
        int begin = rand.nextInt(0, size-1);
        int end = rand.nextInt(begin, size-1);
        arr = new int[size];
        for(int i = 0; i < size; i++) {
            arr[i] = rand.nextInt();
        }
        rightArr = Arrays.copyOf(arr, arr.length);
        if(size > 0) {
            rightArr[0] = (int) (arr[0] + 1);
            assertTrue(rightArr[0] != arr[0]);
            rightArr[0] = arr[0];
        }
        Arrays.sort(rightArr, begin, end);
        assertArrayEquals(rightArr, SimpleSort.BubbleSort(Arrays.copyOf(arr, arr.length), begin, end));
        assertArrayEquals(rightArr, SimpleSort.InputSort(Arrays.copyOf(arr, arr.length), begin, end));
        assertArrayEquals(rightArr, SimpleSort.SelectSort(Arrays.copyOf(arr, arr.length), begin, end));
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
        long[] rightArr;
        for(int i = 0; i < size; i++) {
            arr[i] = rand.nextLong();
        }
        rightArr = Arrays.copyOf(arr, arr.length);
        if(size > 0) {
            rightArr[0] = (long) (arr[0] + 1);
            assertTrue(rightArr[0] != arr[0]);
            rightArr[0] = arr[0];
        }
        Arrays.sort(rightArr);
        assertArrayEquals(rightArr, SimpleSort.BubbleSort(Arrays.copyOf(arr, arr.length)));
        assertArrayEquals(rightArr, SimpleSort.InputSort(Arrays.copyOf(arr, arr.length)));
        assertArrayEquals(rightArr, SimpleSort.SelectSort(Arrays.copyOf(arr, arr.length)));
        //---- sort with bounds
        size = rand.nextInt(1, 353);
        int begin = rand.nextInt(0, size-1);
        int end = rand.nextInt(begin, size-1);
        arr = new long[size];
        for(int i = 0; i < size; i++) {
            arr[i] = rand.nextLong();
        }
        rightArr = Arrays.copyOf(arr, arr.length);
        if(size > 0) {
            rightArr[0] = (long) (arr[0] + 1);
            assertTrue(rightArr[0] != arr[0]);
            rightArr[0] = arr[0];
        }
        Arrays.sort(rightArr, begin, end);
        assertArrayEquals(rightArr, SimpleSort.BubbleSort(Arrays.copyOf(arr, arr.length), begin, end));
        assertArrayEquals(rightArr, SimpleSort.InputSort(Arrays.copyOf(arr, arr.length), begin, end));
        assertArrayEquals(rightArr, SimpleSort.SelectSort(Arrays.copyOf(arr, arr.length), begin, end));
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
        char[] rightArr;
        for(int i = 0; i < size; i++) {
            arr[i] = (char) rand.nextInt();
        }
        rightArr = Arrays.copyOf(arr, arr.length);
        if(size > 0) {
            rightArr[0] = (char) (arr[0] + 1);
            assertTrue(rightArr[0] != arr[0]);
            rightArr[0] = arr[0];
        }
        Arrays.sort(rightArr);
        assertArrayEquals(rightArr, SimpleSort.BubbleSort(Arrays.copyOf(arr, arr.length)));
        assertArrayEquals(rightArr, SimpleSort.InputSort(Arrays.copyOf(arr, arr.length)));
        assertArrayEquals(rightArr, SimpleSort.SelectSort(Arrays.copyOf(arr, arr.length)));
        //---- sort with bounds
        size = rand.nextInt(1, 353);
        int begin = rand.nextInt(0, size-1);
        int end = rand.nextInt(begin, size-1);
        arr = new char[size];
        for(int i = 0; i < size; i++) {
            arr[i] = (char) rand.nextInt();
        }
        rightArr = Arrays.copyOf(arr, arr.length);
        if(size > 0) {
            rightArr[0] = (char) (arr[0] + 1);
            assertTrue(rightArr[0] != arr[0]);
            rightArr[0] = arr[0];
        }
        Arrays.sort(rightArr, begin, end);
        assertArrayEquals(rightArr, SimpleSort.BubbleSort(Arrays.copyOf(arr, arr.length), begin, end));
        assertArrayEquals(rightArr, SimpleSort.InputSort(Arrays.copyOf(arr, arr.length), begin, end));
        assertArrayEquals(rightArr, SimpleSort.SelectSort(Arrays.copyOf(arr, arr.length), begin, end));
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
        float[] rightArr;
        for(int i = 0; i < size; i++) {
            arr[i] = rand.nextFloat() +((float) rand.nextInt());
        }
        rightArr = Arrays.copyOf(arr, arr.length);
        if(size > 0) {
            rightArr[0] = (float) (arr[0] + 1e10f);
            assertTrue(rightArr[0] - arr[0] > 1E-5);
            rightArr[0] = arr[0];
        }
        Arrays.sort(rightArr);
        assertArrayEquals(rightArr, SimpleSort.BubbleSort(Arrays.copyOf(arr, arr.length)));
        assertArrayEquals(rightArr, SimpleSort.InputSort(Arrays.copyOf(arr, arr.length)));
        assertArrayEquals(rightArr, SimpleSort.SelectSort(Arrays.copyOf(arr, arr.length)));
        //---- sort with bounds
        size = rand.nextInt(1, 353);
        int begin = rand.nextInt(0, size-1);
        int end = rand.nextInt(begin, size-1);
        arr = new float[size];
        for(int i = 0; i < size; i++) {
            arr[i] = rand.nextFloat() +((float) rand.nextInt());
        }
        rightArr = Arrays.copyOf(arr, arr.length);
        if(size > 0) {
            rightArr[0] = (float) (arr[0] + 1e10f);
            assertTrue(rightArr[0] - arr[0] > 1E-5);
            rightArr[0] = arr[0];
        }
        Arrays.sort(rightArr, begin, end);
        assertArrayEquals(rightArr, SimpleSort.BubbleSort(Arrays.copyOf(arr, arr.length), begin, end));
        assertArrayEquals(rightArr, SimpleSort.InputSort(Arrays.copyOf(arr, arr.length), begin, end));
        assertArrayEquals(rightArr, SimpleSort.SelectSort(Arrays.copyOf(arr, arr.length), begin, end));
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
        double[] rightArr;
        for(int i = 0; i < size; i++) {
            arr[i] = rand.nextDouble() +((double) rand.nextInt());
        }
        rightArr = Arrays.copyOf(arr, arr.length);
        if(size > 0) {
            rightArr[0] = (double) (arr[0] + 1e10d);
            assertTrue(rightArr[0] != arr[0]);
            rightArr[0] = arr[0];
        }
        Arrays.sort(rightArr);
        assertArrayEquals(rightArr, SimpleSort.BubbleSort(Arrays.copyOf(arr, arr.length)));
        assertArrayEquals(rightArr, SimpleSort.InputSort(Arrays.copyOf(arr, arr.length)));
        assertArrayEquals(rightArr, SimpleSort.SelectSort(Arrays.copyOf(arr, arr.length)));
        //---- sort with bounds
        size = rand.nextInt(1, 353);
        int begin = rand.nextInt(0, size-1);
        int end = rand.nextInt(begin, size-1);
        arr = new double[size];
        for(int i = 0; i < size; i++) {
            arr[i] = rand.nextDouble() +((double) rand.nextInt());
        }
        rightArr = Arrays.copyOf(arr, arr.length);
        if(size > 0) {
            rightArr[0] = (double) (arr[0] + 1e10d);
            assertTrue(rightArr[0] != arr[0]);
            rightArr[0] = arr[0];
        }
        Arrays.sort(rightArr, begin, end);
        assertArrayEquals(rightArr, SimpleSort.BubbleSort(Arrays.copyOf(arr, arr.length), begin, end));
        assertArrayEquals(rightArr, SimpleSort.InputSort(Arrays.copyOf(arr, arr.length), begin, end));
        assertArrayEquals(rightArr, SimpleSort.SelectSort(Arrays.copyOf(arr, arr.length), begin, end));
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
}