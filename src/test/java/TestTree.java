import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TestTree {
    @Test
    void constructorsAndCount(){
        BinaryTree <Integer> tree = new BinaryTree<>(10, 8, 4);
        assertTrue(tree.search(8));
        assertFalse(tree.search(5));
        assertEquals(3, tree.getCountNodes());
        tree = new BinaryTree<>();
        assertFalse(tree.search(0));
        assertEquals(0, tree.getCountNodes());
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
    void forwardOrderArray(){
        BinaryTree <Integer> tree = new BinaryTree<>(10, 8, 4, 5, -1, -8, 43);
        assertEquals(2, tree.getHeight(-1));
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5); list.add(-1); list.add(-8); list.add(4); list.add(10); list.add(8); list.add(43);
        ArrayList<Integer> result = tree.forwardOrderArray();
        assertEquals(list.size(), result.size());
        for(int i = 0; i < list.size(); i++)
            assertEquals(list.get(i), result.get(i));
    }

    @Test
    void deleteValue(){
        BinaryTree <Integer> tree = new BinaryTree<>(10, 8, 4, 5, -1, -8, 43);
        assertEquals(7, tree.getCountNodes());
        tree.deleteValue(4);
        ArrayList<Integer> arr = tree.symmetricOrderArray();
        ArrayList<Integer> goodArr = new ArrayList<Integer>();
        goodArr.addAll(List.of(-8,-1,5,8,10,43));
        assertEquals(goodArr, arr);
        assertEquals(6, tree.getCountNodes());
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
        assertEquals(0, tree.getCountNodes());
    }
    @Test
    void equalsAndHashCode(){
        BinaryTree <Integer> tree = new BinaryTree<>(10, 8, 4, 5, -1, -8, 43);
        BinaryTree <Integer> tree2 = new BinaryTree<>(10, 8, 4, 5, -1, -8, 43);
        assertTrue(tree.equals(tree2));
        assertEquals(tree.hashCode(), tree2.hashCode());
        tree2.deleteValue(4);
        assertFalse(tree.equals(tree2));
        assertNotEquals(tree.hashCode(), tree2.hashCode());
        BinaryTree <String> tree3 = new BinaryTree<>("10", "8", "4", "5", "-1", "-8", "43");
        assertFalse(tree.equals(tree3));
        assertNotEquals(tree.hashCode(), tree3.hashCode());
    }
    @Test
    void toStr(){
        BinaryTree <Integer> tree = new BinaryTree<>(10, 8, 4, 5, -1, -8, 43, -9);
        assertEquals("5(-1(-8(-9)())(4))(10(8)(43))", tree.toString());
    }
}
