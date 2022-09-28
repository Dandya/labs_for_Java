import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TestTree {
    @Test
    void constructors(){
        BinaryTree <Integer> tree = new BinaryTree<>(10, 8, 4);
        assertTrue(tree.search(8));
        assertFalse(tree.search(5));
        tree = new BinaryTree<>();
        assertFalse(tree.search(0));
    }
    @Test
    void search(){
        BinaryTree <Integer> tree = new BinaryTree<>(10, 8, 4, 5, -1, -8, 43);
        assertTrue(tree.search(-1));
        assertFalse(tree.search(-2));
        assertFalse(tree.search(50));
        assertFalse(tree.search(-20));
    }
    @Test
    void insert(){
        BinaryTree <Integer> tree = new BinaryTree<>();
        tree.insert(0);
        tree.insert(2);
        tree.insert(4);
        tree.insert(-1);
        tree.insert(5);
        assertTrue(tree.search(0) && tree.search(2) &&
                tree.search(4) && tree.search(-1) && tree.search(5));
        assertTrue(tree.isBalancedTree());
        assertEquals(3, tree.getHeight(2));
        assertEquals(2, tree.getHeight(0));
        assertEquals(1, tree.getHeight(-1));
    }

    @Test
    void symmetricOrderArray(){
        BinaryTree <Integer> tree = new BinaryTree<>(10, 8, 4, 5, -1, -8, 43);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-8); list.add(-1); list.add(4); list.add(5); list.add(8); list.add(10); list.add(43);
        ArrayList<Integer> result = tree.symmetricOrderArray();
        assertEquals(list.size(), result.size());
        for(int i = 0; i < list.size(); i++)
            assertEquals(list.get(i), result.get(i));
    }

    @Test
    void deleteValue(){
        BinaryTree <Integer> tree = new BinaryTree<>(10, 8, 4, 5, -1, -8, 43);
        tree.deleteValue(4);
        ArrayList<Integer> arr = tree.symmetricOrderArray();
        ArrayList<Integer> goodArr = new ArrayList<Integer>();
        goodArr.addAll(List.of(-8,-1,5,8,10,43));
        assertEquals(goodArr, arr);
        tree.deleteValue(5);
        arr = tree.symmetricOrderArray();
        goodArr = new ArrayList<Integer>();
        goodArr.addAll(List.of(-8,-1,8,10,43));
        assertEquals(goodArr, arr);
        assertTrue(tree.isBalancedTree());
    }
    @Test
    void deleteAll(){
        BinaryTree <Integer> tree = new BinaryTree<>(10, 8, 4, 5, -1, -8, 43);
        tree.deleteAll();
        ArrayList<Integer> goodArr = new ArrayList<Integer>();
        goodArr.addAll(List.of(10, 8, 4, 5, -1, -8, 43));
        for(Integer val : goodArr)
            assertFalse(tree.search(val));
    }
}
