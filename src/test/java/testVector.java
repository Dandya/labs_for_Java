import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class testVector {
    @Test
    void constructorsAndEquals(){
        myVector<Integer> dynamicArr = new myVector<>(10);
        assertEquals(null, dynamicArr.get(0));
        try{ assertEquals(null, dynamicArr.get(10)); }
        catch (ArrayIndexOutOfBoundsException e){ assertTrue(true); }
        dynamicArr = new myVector<>(Integer.valueOf(8), Integer.valueOf(4), Integer.valueOf(5));
        assertEquals(4, dynamicArr.get(1));
        dynamicArr = new myVector<>(Integer.valueOf(1));
        assertEquals(1, dynamicArr.get(0));
        try{ dynamicArr  = new myVector<>(null); }
        catch (IllegalArgumentException e){ assertTrue(true);}
    }
    @Test
    void length(){
        myVector<Integer> dynamicArr = dynamicArr = new myVector<>(Integer.valueOf(8), Integer.valueOf(4), Integer.valueOf(5));
        assertEquals(3, dynamicArr.getLength());
        assertEquals(16, dynamicArr.getMaxLength());
        for(int i = 0; i < 100; i++)
            dynamicArr.push(i);
        assertEquals(103, dynamicArr.getLength());
        assertEquals(198, dynamicArr.getMaxLength());
    }
    @Test
    void push(){
        myVector<Integer> dynamicArr = new myVector<>(10);
        for(int i = 0; i < 100; i++)
            dynamicArr.push(i);
        assertEquals(null, dynamicArr.get(0));
        assertEquals(0, dynamicArr.get(10));
        assertEquals(1, dynamicArr.get(11));
        assertEquals(99, dynamicArr.get(109));
    }
    @Test
    void insert(){
        myVector<Integer> dynamicArr = new myVector<>(10);
        // test 1
        for(int i = 0; i < 10; i++)
            dynamicArr.insert(i, i);
        assertEquals(4, dynamicArr.get(4));
        assertEquals(10, dynamicArr.getLength());
        // test 2
        try{ dynamicArr.insert(10, 10); }
        catch (ArrayIndexOutOfBoundsException e){ assertTrue(true); }
        // test 3
        dynamicArr.insert(-1,0);
        assertEquals(-1, dynamicArr.get(0));
        assertEquals(0, dynamicArr.get(1));
        assertEquals(11, dynamicArr.getLength());
        // test 4
        assertEquals(5, dynamicArr.get(6));
        dynamicArr.insert(-5, 6);
        assertEquals(-5, dynamicArr.get(6));
        assertEquals(5, dynamicArr.get(7));
        assertEquals(12, dynamicArr.getLength());
    }
    @Test
    void delete(){
        myVector<Integer> dynamicArr = new myVector<>(10);
        for(int i = 0; i < 10; i++)
            dynamicArr.insert(i, i);
        dynamicArr.delete(5);
        assertEquals(6, dynamicArr.get(5));
        assertEquals(9, dynamicArr.get(8));
        //try start
        try{ assertEquals(9, dynamicArr.get(9)); }
        catch(ArrayIndexOutOfBoundsException e){ assertTrue(true); }
        // try start
        try{ dynamicArr.delete(9); }
        catch (ArrayIndexOutOfBoundsException e){ assertTrue(true); }
        // try end
        // try start
        try{ dynamicArr.delete(-1); }
        catch (ArrayIndexOutOfBoundsException e){ assertTrue(true); }
        // try end
        dynamicArr.deleteLastElm();
        try{ assertEquals(9, dynamicArr.get(8)); }
        catch (ArrayIndexOutOfBoundsException e){ assertTrue(true); }
        dynamicArr.deleteAll();
        try{ assertEquals(0, dynamicArr.get(0)); }
        catch (ArrayIndexOutOfBoundsException e){ assertTrue(true); }
        dynamicArr.push(1);
        assertEquals(1, dynamicArr.get(0));
    }
    @Test
    void Equals(){
        myVector<Integer> vr = new myVector<>(10, 2, 10, 5);
        myVector<Integer> vr2 = new myVector<>(4);
        vr2.insert(10, 0); vr2.insert(2, 1);
        vr2.insert(10, 2); vr2.insert(5, 3);
        assertTrue(vr.equals(vr2));
        assertEquals(vr.hashCode(), vr2.hashCode());
        vr2.insert(11, 0);
        assertFalse(vr.equals(vr2));
        vr2.insert(10, 0);
        vr2.push(-2);
        assertFalse(vr.equals(vr2));
        assertNotEquals(vr.hashCode(), vr2.hashCode());
    }
    @Test
    void toStr(){
        myVector<String> emplyList = new myVector<>();
        assertEquals("[]", emplyList.toString());
        emplyList = new myVector<>(2);
        assertEquals("[null,null]", emplyList.toString());
        myVector<String> list = new myVector<>("Hello", " World!");
        assertEquals("[Hello, World!]", list.toString());
    }
}
