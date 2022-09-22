import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

public class testVector {
    @Test
    void constructors(){
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
        for(int i = 0; i < 10; i++)
            dynamicArr.insert(i, i);
        assertEquals(4, dynamicArr.get(4));
        try{ assertEquals(1, dynamicArr.get(10)); }
        catch (ArrayIndexOutOfBoundsException e){ assertTrue(true); }
        dynamicArr.push(10);
        assertEquals(10, dynamicArr.get(10));
        dynamicArr.insert(11, 10);
        assertEquals(11, dynamicArr.get(10));
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
}
