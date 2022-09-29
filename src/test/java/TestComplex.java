import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class TestComplex {

    @Test
    void constructorsEqualsAndValueOf(){
        Complex<Comparable> a = new Complex<Comparable>();
        Complex<Comparable> b = new Complex<Comparable>(0, 0);
        Complex<Comparable> c = Complex.valueOf(0,0);
        assertEquals(0, a.getReal().compareTo(b.getReal()));
        assertEquals(0, a.getImag().compareTo(b.getImag()));
        assertTrue(a.equals(c));
        assertEquals(a.hashCode(), c.hashCode());
        a = a.add(new Complex<Comparable>(20,0));
        c = c.add(new Complex<Comparable>(20,0));
        assertTrue(a.equals(c));
        assertFalse(a.equals(new String("1")));
        c = c.sub(new Complex<Comparable>(1e-10, 0));
        assertFalse(a.equals(c));
        assertNotEquals(a.hashCode(), c.hashCode());
    }

    @Test
    void add() {
        Complex<Comparable> a = new Complex<Comparable>(1, 1.8);
        Complex<Comparable> b = new Complex<Comparable>(2.5, -1.8);
        Complex<Comparable> c = new Complex<Comparable>(3.5, 0);
        assertTrue(c.getReal().subtract(a.add(b).getReal()).abs().compareTo(BigDecimal.valueOf(1E-5)) < 0);
        assertTrue(c.getImag().subtract(a.add(b).getImag()).abs().compareTo(BigDecimal.valueOf(1E-5)) < 0);
    }

    @Test
    void subtract() {
        Complex<Comparable> a = new Complex<Comparable>(1, 1.8);
        Complex<Comparable> b = new Complex<Comparable>(2.5, -1.8);
        Complex<Comparable> c = new Complex<Comparable>(-1.5, 3.6);
        assertTrue(c.getReal().subtract(a.sub(b).getReal()).abs().compareTo(BigDecimal.valueOf(1E-5)) < 0);
        assertTrue(c.getImag().subtract(a.sub(b).getImag()).abs().compareTo(BigDecimal.valueOf(1E-5)) < 0);
    }

    @Test
    void multiply() {
        assertTrue(Complex.valueOf(0,0).mul(Complex.valueOf(1000, 1000))
                        .equals(Complex.valueOf(0,0)));
        assertTrue(Complex.valueOf(1,2).mul(Complex.valueOf(1000, 1000))
                        .equals(Complex.valueOf(-1000,3000)));
        assertTrue(Complex.valueOf(-1,-2).mul(Complex.valueOf(1000, 1000))
                        .equals(Complex.valueOf(1000,-3000)));
    }

    @Test
    void getModule() {
        assertTrue( Complex.valueOf(3, 4).getModule()
                    .subtract(BigDecimal.valueOf(5d)).abs().compareTo(BigDecimal.valueOf(1E-5)) < 0);
        assertTrue( Complex.valueOf(-3, 4).getModule()
                .subtract(BigDecimal.valueOf(5d)).abs().compareTo(BigDecimal.valueOf(1E-5)) < 0);
        assertTrue( Complex.valueOf(3, -4).getModule()
                .subtract(BigDecimal.valueOf(5d)).abs().compareTo(BigDecimal.valueOf(1E-5)) < 0);
        assertTrue( Complex.valueOf(0.3, 0.4).getModule()
                .subtract(BigDecimal.valueOf(0.5d)).abs().compareTo(BigDecimal.valueOf(1E-5)) < 0);
    }

    @Test
    void getArg() {
        assertTrue(Math.abs(Math.PI/3 - Complex.valueOf(Math.cos(Math.PI*4/3), Math.sin(Math.PI*4/3)).getArg()) < 1E-5);
        assertTrue(Math.abs(Math.PI/3 - Complex.valueOf(4*Math.cos(Math.PI/3), 4*Math.sin(Math.PI/3))
                        .mul(Complex.valueOf(Double.MAX_VALUE, 0)).getArg()) < 1E-5);
        assertTrue(Math.abs(Math.PI/3 - Complex.valueOf(Math.cos(Math.PI/3), Math.sin(Math.PI/3))
                        .mul(Complex.valueOf(Double.MIN_VALUE, 0)).getArg()) < 1E-5);
    }

    @Test
    void ToString() {
        assertEquals("1,12345 + (-6,789)i", Complex.valueOf(1.12345, -6.789).toString());
    }
}
