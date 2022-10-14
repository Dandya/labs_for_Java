import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class LinSortTest {

    @Test
    void LSDSortInteger() {
        System.out.println("\nLSDSort");
        Random rand = new Random();
        int size = rand.nextInt(0, 20);
        Integer[] arrInt = new Integer[size];
        Integer[] rightArrInt = new Integer[size];
        for(int i = 0; i < size; i++){
            arrInt[i] = rand.nextInt();
            rightArrInt[i] = arrInt[i];
        }
        Arrays.sort(rightArrInt);
        LinSort.LSDSort(arrInt);
        System.out.println(Arrays.toString(rightArrInt));
        System.out.println(Arrays.toString(arrInt));
        assertArrayEquals(rightArrInt, arrInt);
        //---- sort with bounds
        size = rand.nextInt(2, 20);
        int begin = rand.nextInt(0, size-1);
        int end = rand.nextInt(begin, size-1);
        arrInt = new Integer[size];
        rightArrInt = new Integer[size];
        for(int i = 0; i < size; i++){
            arrInt[i] = rand.nextInt();
            rightArrInt[i] = arrInt[i];
        }
        Arrays.sort(rightArrInt, begin, end);
        LinSort.LSDSort(arrInt, begin, end);
        System.out.println(begin + " - " + end);
        System.out.println(Arrays.toString(rightArrInt));
        System.out.println(Arrays.toString(arrInt));
        assertArrayEquals(rightArrInt, arrInt);
    }

    @Test
    void MSDSortInteger() {
        System.out.println("\nMSDSort");
        Random rand = new Random();
        int size = rand.nextInt(0, 20);
        Integer[] arrInt = new Integer[size];
        Integer[] rightArrInt = new Integer[size];
        for(int i = 0; i < size; i++){
            arrInt[i] = rand.nextInt();
            rightArrInt[i] = arrInt[i];
        }
        Arrays.sort(rightArrInt);
        LinSort.MSDSort(arrInt);
        System.out.println(Arrays.toString(rightArrInt));
        System.out.println(Arrays.toString(arrInt));
        assertArrayEquals(rightArrInt, arrInt);
        //---- sort with bounds
        size = rand.nextInt(2, 20);
        int begin = rand.nextInt(0, size-1);
        int end = rand.nextInt(begin, size-1);
        arrInt = new Integer[size];
        rightArrInt = new Integer[size];
        for(int i = 0; i < size; i++){
            arrInt[i] = rand.nextInt();
            rightArrInt[i] = arrInt[i];
        }
        Arrays.sort(rightArrInt, begin, end);
        LinSort.MSDSort(arrInt, begin, end);
        System.out.println(begin + " - " + end);
        System.out.println(Arrays.toString(rightArrInt));
        System.out.println(Arrays.toString(arrInt));
        assertArrayEquals(rightArrInt, arrInt);
    }

    @Test
    void CountSortInteger() {
        System.out.println("\nCountSort");
        Random rand = new Random();
        int size = rand.nextInt(0, 20);
        Integer[] arrInt = new Integer[size];
        Integer[] rightArrInt = new Integer[size];
        for(int i = 0; i < size; i++){
            arrInt[i] = rand.nextInt();
            rightArrInt[i] = arrInt[i];
        }
        Arrays.sort(rightArrInt);
        LinSort.CountSort(arrInt);
        System.out.println(Arrays.toString(rightArrInt));
        System.out.println(Arrays.toString(arrInt));
        assertArrayEquals(rightArrInt, arrInt);
        //---- sort with bounds
        size = rand.nextInt(2, 20);
        int begin = rand.nextInt(0, size-1);
        int end = rand.nextInt(begin, size-1);
        arrInt = new Integer[size];
        rightArrInt = new Integer[size];
        for(int i = 0; i < size; i++){
            arrInt[i] = rand.nextInt();
            rightArrInt[i] = arrInt[i];
        }
        Arrays.sort(rightArrInt, begin, end);
        LinSort.CountSort(arrInt, begin, end);
        System.out.println(begin + " - " + end);
        System.out.println(Arrays.toString(rightArrInt));
        System.out.println(Arrays.toString(arrInt));
        assertArrayEquals(rightArrInt, arrInt);
    }

    @Test
    void LSDSortInt() {
        Random rand = new Random();
        int size = rand.nextInt(0, 20);
        int[] arrInt = new int[size];
        int[] rightArrInt = new int[size];
        for(int i = 0; i < size; i++){
            arrInt[i] = rand.nextInt();
            rightArrInt[i] = arrInt[i];
        }
        Arrays.sort(rightArrInt);
        LinSort.LSDSort(arrInt);
        assertArrayEquals(rightArrInt, arrInt);
        //---- sort with bounds
        size = rand.nextInt(2, 20);
        int begin = rand.nextInt(0, size-1);
        int end = rand.nextInt(begin, size-1);
        arrInt = new int[size];
        rightArrInt = new int[size];
        for(int i = 0; i < size; i++){
            arrInt[i] = rand.nextInt();
            rightArrInt[i] = arrInt[i];
        }
        Arrays.sort(rightArrInt, begin, end);
        LinSort.LSDSort(arrInt, begin, end);
        assertArrayEquals(rightArrInt, arrInt);
    }

    @Test
    void MSDSortInt() {
        Random rand = new Random();
        int size = rand.nextInt(0, 20);
        int[] arrInt = new int[size];
        int[] rightArrInt = new int[size];
        for(int i = 0; i < size; i++){
            arrInt[i] = rand.nextInt();
            rightArrInt[i] = arrInt[i];
        }
        Arrays.sort(rightArrInt);
        LinSort.MSDSort(arrInt);
        assertArrayEquals(rightArrInt, arrInt);
        //---- sort with bounds
        size = rand.nextInt(2, 20);
        int begin = rand.nextInt(0, size-1);
        int end = rand.nextInt(begin, size-1);
        arrInt = new int[size];
        rightArrInt = new int[size];
        for(int i = 0; i < size; i++){
            arrInt[i] = rand.nextInt();
            rightArrInt[i] = arrInt[i];
        }
        Arrays.sort(rightArrInt, begin, end);
        LinSort.MSDSort(arrInt, begin, end);
        assertArrayEquals(rightArrInt, arrInt);
    }

    @Test
    void CountSortInt() {
        Random rand = new Random();
        int size = rand.nextInt(0, 20);
        int[] arrInt = new int[size];
        int[] rightArrInt = new int[size];
        for(int i = 0; i < size; i++){
            arrInt[i] = rand.nextInt();
            rightArrInt[i] = arrInt[i];
        }
        Arrays.sort(rightArrInt);
        LinSort.CountSort(arrInt);
        assertArrayEquals(rightArrInt, arrInt);
        //---- sort with bounds
        size = rand.nextInt(2, 20);
        int begin = rand.nextInt(0, size-1);
        int end = rand.nextInt(begin, size-1);
        arrInt = new int[size];
        rightArrInt = new int[size];
        for(int i = 0; i < size; i++){
            arrInt[i] = rand.nextInt();
            rightArrInt[i] = arrInt[i];
        }
        Arrays.sort(rightArrInt, begin, end);
        LinSort.CountSort(arrInt, begin, end);
        assertArrayEquals(rightArrInt, arrInt);
    }

    @Test
    void LSDSortBigInt() {
        Random rand = new Random();
        int size = rand.nextInt(0, 20);
        BigInteger[] arrInt = new BigInteger[size];
        BigInteger[] rightArrInt = new BigInteger[size];
        for(int i = 0; i < size; i++){
            arrInt[i] = BigInteger.valueOf(rand.nextInt());
            rightArrInt[i] = arrInt[i];
        }
        Arrays.sort(rightArrInt);
        LinSort.LSDSort(arrInt);
        assertArrayEquals(rightArrInt, arrInt);
        //---- sort with bounds
        size = rand.nextInt(2, 20);
        int begin = rand.nextInt(0, size-1);
        int end = rand.nextInt(begin, size-1);
        arrInt = new BigInteger[size];
        rightArrInt = new BigInteger[size];
        for(int i = 0; i < size; i++){
            arrInt[i] = BigInteger.valueOf(rand.nextInt());
            rightArrInt[i] = arrInt[i];
        }
        Arrays.sort(rightArrInt, begin, end);
        LinSort.LSDSort(arrInt, begin, end);
        assertArrayEquals(rightArrInt, arrInt);
    }

    @Test
    void MSDSortBigInt() {
        Random rand = new Random();
        int size = rand.nextInt(0, 20);
        BigInteger[] arrInt = new BigInteger[size];
        BigInteger[] rightArrInt = new BigInteger[size];
        for(int i = 0; i < size; i++){
            arrInt[i] = BigInteger.valueOf(rand.nextInt());
            rightArrInt[i] = arrInt[i];
        }
        Arrays.sort(rightArrInt);
        LinSort.MSDSort(arrInt);
        assertArrayEquals(rightArrInt, arrInt);
        //---- sort with bounds
        size = rand.nextInt(2, 20);
        int begin = rand.nextInt(0, size-1);
        int end = rand.nextInt(begin, size-1);
        arrInt = new BigInteger[size];
        rightArrInt = new BigInteger[size];
        for(int i = 0; i < size; i++){
            arrInt[i] = BigInteger.valueOf(rand.nextInt());
            rightArrInt[i] = arrInt[i];
        }
        Arrays.sort(rightArrInt, begin, end);
        LinSort.MSDSort(arrInt, begin, end);
        assertArrayEquals(rightArrInt, arrInt);
    }

    @Test
    void CountSortBigInt() {
        Random rand = new Random();
        int size = rand.nextInt(0, 20);
        BigInteger[] arrInt = new BigInteger[size];
        BigInteger[] rightArrInt = new BigInteger[size];
        for(int i = 0; i < size; i++){
            arrInt[i] = BigInteger.valueOf(rand.nextInt());
            rightArrInt[i] = arrInt[i];
        }
        Arrays.sort(rightArrInt);
        LinSort.CountSort(arrInt);
        assertArrayEquals(rightArrInt, arrInt);
        //---- sort with bounds
        size = rand.nextInt(2, 20);
        int begin = rand.nextInt(0, size-1);
        int end = rand.nextInt(begin, size-1);
        arrInt = new BigInteger[size];
        rightArrInt = new BigInteger[size];
        for(int i = 0; i < size; i++){
            arrInt[i] = BigInteger.valueOf(rand.nextInt());
            rightArrInt[i] = arrInt[i];
        }
        Arrays.sort(rightArrInt, begin, end);
        LinSort.CountSort(arrInt, begin, end);
        assertArrayEquals(rightArrInt, arrInt);
    }
}
