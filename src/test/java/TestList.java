import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestList {

    @Test
    void constructorsAndSize() {
        myList<Integer> list1 = new myList<>();
        myList<Integer> list2 = new myList<>(10);
        myList<Integer> list3 = new myList<>(10, 12, 21);
        assertEquals(0, list1.size());
        assertEquals(1, list2.size());
        assertEquals(3, list3.size());
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
            list.deleleFirstElm();
        }
        catch (UnsupportedOperationException e){
            assertTrue(true);
        }
        for(int i = -100; i < 100; i++){
            list.push(i);
        }
        assertEquals(-100, list.deleleFirstElm());
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
        myList<String> list = new myList<>("Hello", " World!");
        assertEquals("[Hello, World!]", list.toString());
    }
}
