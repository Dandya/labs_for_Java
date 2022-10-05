import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestSimpleSort {

    private static final boolean isInputTest = false;

    @Test
    void bubbleSort() {
        SimpleSort<Integer> Sorts = new SimpleSort<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(List.of(-1, 2, 5, 8, 2, -2, 4, 12, -24));
        List<Integer> rightList = List.of(-24, -2, -1, 2, 2, 4, 5, 8, 12);
        assertEquals(rightList, Sorts.BubbleSort(list));
        Integer[] arrInt = {-1, 2, 5, 8, 2, -2, 4, 12, -24};
        assertArrayEquals(new Integer[]{-24, -2, -1, 2, 2, 4, 5, 8, 12}, Sorts.BubbleSort(arrInt));
        //----
        list = new ArrayList<>();
        list.addAll(List.of(-1, 2, 5, 8, 2, -2, 4, 12, -24));
        rightList = List.of(-1, 2, -2, 2, 4, 5, 8, 12, -24);
        assertEquals(rightList, Sorts.BubbleSort(list, 2, 7));
        arrInt = new Integer[] {-1, 2, 5, 8, 2, -2, 4, 12, -24};
        assertArrayEquals(new Integer[]{-1, 2, -2, 2, 4, 5, 8, 12, -24}, Sorts.BubbleSort(arrInt, 2, 7));
        //---- TODO: add test on Exception

    }

    @Test
    void InputSort() {
        SimpleSort<Integer> Sorts = new SimpleSort<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(List.of(-1, 2, 5, 8, 2, -2, 4, 12, -24));
        List<Integer> rightList = List.of(-24, -2, -1, 2, 2, 4, 5, 8, 12);
        assertEquals(rightList, Sorts.InputSort(list));
        Integer[] arrInt = {-1, 2, 5, 8, 2, -2, 4, 12, -24};
        assertArrayEquals(new Integer[]{-24, -2, -1, 2, 2, 4, 5, 8, 12}, Sorts.InputSort(arrInt));
        //----
        list = new ArrayList<>();
        list.addAll(List.of(-1, 2, 5, 8, 2, -2, 4, 12, -24));
        rightList = List.of(-1, 2, -2, 2, 4, 5, 8, 12, -24);
        assertEquals(rightList, Sorts.InputSort(list, 2, 7));
        arrInt = new Integer[] {-1, 2, 5, 8, 2, -2, 4, 12, -24};
        assertArrayEquals(new Integer[]{-1, 2, -2, 2, 4, 5, 8, 12, -24}, Sorts.InputSort(arrInt, 2, 7));
        //---- TODO: add test on Exception

    }

    @Test
    void SelectSort() {
        SimpleSort<Integer> Sorts = new SimpleSort<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(List.of(-1, 2, 5, 8, 2, -2, 4, 12, -24));
        List<Integer> rightList = List.of(-24, -2, -1, 2, 2, 4, 5, 8, 12);
        assertEquals(rightList, Sorts.SelectSort(list));
        Integer[] arrInt = {-1, 2, 5, 8, 2, -2, 4, 12, -24};
        assertArrayEquals(new Integer[]{-24, -2, -1, 2, 2, 4, 5, 8, 12}, Sorts.SelectSort(arrInt));
        //----
        list = new ArrayList<>();
        list.addAll(List.of(-1, 2, 5, 8, 2, -2, 4, 12, -24));
        rightList = List.of(-1, 2, -2, 2, 4, 5, 8, 12, -24);
        assertEquals(rightList, Sorts.SelectSort(list, 2, 7));
        arrInt = new Integer[] {-1, 2, 5, 8, 2, -2, 4, 12, -24};
        assertArrayEquals(new Integer[]{-1, 2, -2, 2, 4, 5, 8, 12, -24}, Sorts.SelectSort(arrInt, 2, 7));
        //---- TODO: add test on Exception

    }
}