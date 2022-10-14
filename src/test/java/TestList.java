import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestList {

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
                System.out.println(list1);
                System.out.println(list2);
                return false;
            }
        }
        return true;
    }

    @Test
    void constructorsEqualsAndSize() {
        myList<Integer> list1 = new myList<>();
        list1.hashCode();
        myList<Integer> list2 = new myList<>(10);
        myList<Integer> list3 = new myList<>(10, 12, 21);
        assertEquals(0, list1.size());
        assertEquals(1, list2.size());
        assertEquals(3, list3.size());
        list2.push(12);
        list2.push(21);
        assertTrue(list2.equals(list3));
        list2.push(1);
        assertFalse(list2.equals(list3));
        myList<String> list4 = new myList<>("10", "12", "21", "1");
        assertFalse(list2.equals(list4));
        try {
            list1 = new myList<>(null);
            assertTrue(false);
        } catch (NullPointerException e) {
            assertTrue(true);
        }
    }

    @Test
    void get(){
        myList<String> list = new myList<>("Hello");
        assertEquals("Hello", list.get(0));
        try{
            assertNotEquals("Hello", list.get(1));
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try{
            assertNotEquals("Hello", list.get(-1));
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }

    @Test
    void push(){
        myList<Integer> list = new myList<>(0);
        list.push(1);
        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
        for(int i = -100, index = 2; i < 100; i++,index++ ){
            list.push(i);
            assertEquals(i, list.get(index));
        }
    }
    @Test
    void pushToBegin(){
        myList<Integer> list = new myList<>();
        for(int i = -100; i < 100; i++){
            list.push(i);
        }
        assertEquals(99, list.get(list.size()-1));
        list.pushToBegin(0);
        assertEquals(0,list.get(0));
        assertEquals(99, list.get(list.size()-1));
    }
    @Test
    void deleteFirstElm(){
        myList<Integer> list = new myList<>();
        try{
            list.deleteFirstElm();
        }
        catch (UnsupportedOperationException e){
            assertTrue(true);
        }
        for(int i = -100; i < 100; i++){
            list.push(i);
        }
        assertEquals(-100, list.deleteFirstElm());
        assertEquals(-99, list.get(0));
    }
    @Test
    void deleteByValue(){
        myList<Integer> list = new myList<>();
        for(int i = -100; i < 100; i++){
            list.push(i);
        }
        list.deleteByValue(0);
        assertEquals(1, list.get(100));
        assertEquals(-1, list.get(99));
        list.deleteByValue(-100);
        assertEquals(-99, list.get(0));
        list.deleteByValue(99);
        try{
            assertNotEquals(99, list.get(199));
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try{
            list.deleteByValue(300);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }
    @Test
    void deleteAll(){
        myList<Integer> list = new myList<>();
        for(int i = -100; i < 100; i++){
            list.push(i);
        }
        list.deleteAll();
        try{
            assertNotEquals(-100, list.get(0));
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }
    @Test
    void toStr(){
        myList<String> emplyList = new myList<>();
        assertEquals("[]", emplyList.toString());
        emplyList = new myList<>("1", null);
        assertEquals("[1,null]", emplyList.toString());
        myList<String> list = new myList<>("Hello", " World!");
        assertEquals("[Hello, World!]", list.toString());
    }

    @Test
    void add() {
        Random rand = new Random();
        myList<Integer> list = new myList<>();
        int size = rand.nextInt(0, 4);
        for(int i = 0; i < size; i++){
            list.add(rand.nextInt());
        }
        Integer tmp = null, value = rand.nextInt();
        int index = rand.nextInt(0,size+1);
        if(index < list.size()) {
            tmp = list.get(index);
        }
        list.add(index, value);
        assertEquals(value, list.get(index));
        if(index != list.size()-1) {
            assertEquals(tmp, list.get(index+1));
        }
    }

    @Test
    void remove() {
        Random rand = new Random();
        myList<Integer> list = new myList<>();
        int size = rand.nextInt(0, 4);
        for(int i = 0; i < size; i++){
            list.add(rand.nextInt());
        }
        int index = rand.nextInt(0, size);
        Integer value = list.get(index), tmp = null;
        if(index+1 < list.size()) {
            tmp = list.get(index+1);
        }
        assertEquals(value, list.remove(index));
        if(index < list.size()) {
            assertEquals(tmp, list.get(index));
        }
        try {
            list.remove(list.size());
            fail();
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
        try {
            list.remove(-1);
            fail();
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }

    @Test
    void iteratorFromBegin(){
        Random rand = new Random();
        myList<Integer> list = new myList<>();
        int size = rand.nextInt(0, 353);
        for(int i = 0; i < size; i++){
            list.add(rand.nextInt());
        }
        Iterator it = list.iterator();
        for(int i = 0; i < list.size(); i++) {
            assertTrue(list.get(i).equals(it.next()));
        }
    }

    @Test
    void iteratorFromEnd(){
        Random rand = new Random();
        myList<Integer> list = new myList<>();
        int size = rand.nextInt(1, 353);
        for(int i = 0; i < size; i++){
            list.add(rand.nextInt());
        }
        Iterator it = list.iteratorOnTheEnd();
        assertTrue(list.get(list.size()-1).equals(it.next()));
        assertFalse(it.hasNext());
    }

    @Test
    void listIterator() {
        Random rand = new Random();
        myList<Integer> list = new myList<>();
        int size = rand.nextInt(1, 353);
        for(int i = 0; i < size; i++){
            list.add(rand.nextInt());
        }
        ListIterator it = list.listIterator();
        for(int i = 0; i < list.size(); i++) {
            assertTrue(it.hasNext());
            assertEquals(list.get(i), it.next());
        }
        assertFalse(it.hasNext());
        for(int i = list.size()-1; i >= 0; i--) {
            assertTrue(it.hasPrevious());
            assertEquals(list.get(i), it.previous());
        }
    }

    @Test
    void BubbleSort() {
        Random rand = new Random();
        SimpleSort<Integer> Sorts = new SimpleSort<>();
        //---- sort full
        myList<Integer> list = new myList<>();
        int size = rand.nextInt(0, 353);
        for(int i = 0; i < size; i++){
            list.add(rand.nextInt());
        }
        List<Integer> rightList = (List<Integer>) list.clone();
        Collections.sort(rightList);
        Sorts.BubbleSort(list);
        assertTrue(Equals(rightList, list));
        //---- sort with bounds
        size = rand.nextInt(2, 353);
        int begin = rand.nextInt(0, size-1);
        int end = rand.nextInt(begin, size-1);
        list = new myList<>();
        for(int i = 0; i < size; i++){
            list.add(rand.nextInt());
        }
        rightList = (List<Integer>) list.clone();
        sortInBounds(rightList, begin, end);
        Sorts.BubbleSort(list, begin, end);
        assertTrue(Equals(rightList, list));
    }

    @Test
    void inputSort() {
        Random rand = new Random();
        SimpleSort<Integer> Sorts = new SimpleSort<>();
        //---- sort full
        myList<Integer> list = new myList<>();
        int size = rand.nextInt(0, 353);
        for(int i = 0; i < size; i++){
            list.add(rand.nextInt());
        }
        List<Integer> rightList = (List<Integer>) list.clone();
        Collections.sort(rightList);
        Sorts.InputSort(list);
        assertTrue(Equals(rightList, list));
        //---- sort with bounds
        size = rand.nextInt(2, 353);
        int begin = rand.nextInt(0, size-1);
        int end = rand.nextInt(begin, size-1);
        list = new myList<>();
        for(int i = 0; i < size; i++){
            list.add(rand.nextInt());
        }
        rightList = (List<Integer>) list.clone();
        sortInBounds(rightList, begin, end);
        Sorts.InputSort(list, begin, end);
        assertTrue(Equals(rightList, list));
    }

    @Test
    void selectSort() {
        Random rand = new Random();
        SimpleSort<Integer> Sorts = new SimpleSort<>();
        //---- sort full
        myList<Integer> list = new myList<>();
        int size = rand.nextInt(0, 353);
        for(int i = 0; i < size; i++){
            list.add(rand.nextInt());
        }
        List<Integer> rightList = (List<Integer>) list.clone();
        Collections.sort(rightList);
        Sorts.SelectSort(list);
        assertTrue(Equals(rightList, list));
        //---- sort with bounds
        size = rand.nextInt(2, 353);
        int begin = rand.nextInt(0, size-1);
        int end = rand.nextInt(begin, size-1);
        list = new myList<>();
        for(int i = 0; i < size; i++){
            list.add(rand.nextInt());
        }
        rightList = (List<Integer>) list.clone();
        sortInBounds(rightList, begin, end);
        Sorts.SelectSort(list, begin, end);
        assertTrue(Equals(rightList, list));
    }
}
