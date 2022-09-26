import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestTree {
    @Test
    void constructors(){
        BinaryTree <Integer> tree = new BinaryTree<>(10, 8, 4);
        assertTrue(tree.search(8));
        assertFalse(tree.search(5));
        tree.insert(11);
        tree.insert(12);
        tree.insert(9);
        tree.insert(5);
        tree.insert(6);
        ArrayList<Integer> arr = tree.symmetricOrderArray();
        for(Integer value : arr)
            System.out.println(value);
    }
}
