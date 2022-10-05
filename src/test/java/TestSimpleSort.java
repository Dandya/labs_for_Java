import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestSimpleSort {

    @Test
    void bubbleSort() {
        SimpleSort<Integer> Sorts = new SimpleSort<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(List.of(-1, 2, 5, 8, 2, -2, 4, 12, -24));
        List<Integer> rightList = List.of(-24, -2, -1, 2, 2, 4, 5, 8, 12);
        assertEquals(rightList, Sorts.BubbleSort(list));
        Integer[] arrInt = {-1, 2, 5, 8, 2, -2, 4, 12, -24};
        assertEquals(rightList, Sorts.BubbleSort(arrInt));
    }
}