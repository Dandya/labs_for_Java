import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class LinSortTest {

    @Test
    void LSDSort() {
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
}
