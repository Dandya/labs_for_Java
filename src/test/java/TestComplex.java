import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class TestComplex {

    @Test
    void constructorsEqualsAndValueOf(){
        Complex a = new Complex();
        Complex b = new Complex(0, 0);
        Complex c = Complex.valueOf(0,0);
        assertEquals(0, a.getReal().compareTo(b.getReal()));
        assertEquals(0, a.getImag().compareTo(b.getImag()));
        assertTrue(a.equals(c));
    }

    @Test
    void add() {
        Complex a = new Complex(1, 1.8);
        Complex b = new Complex(2.5, -1.8);
        Complex c = new Complex(3.5, 0);
        assertTrue(c.getReal().subtract(a.add(b).getReal()).abs().compareTo(BigDecimal.valueOf(1E-5)) < 0);
        assertTrue(c.getImag().subtract(a.add(b).getImag()).abs().compareTo(BigDecimal.valueOf(1E-5)) < 0);
    }

    @Test
    void subtract() {
        Complex a = new Complex(1, 1.8);
        Complex b = new Complex(2.5, -1.8);
        Complex c = new Complex(-1.5, 3.6);
        assertTrue(c.getReal().subtract(a.sub(b).getReal()).abs().compareTo(BigDecimal.valueOf(1E-5)) < 0);
        assertTrue(c.getImag().subtract(a.sub(b).getImag()).abs().compareTo(BigDecimal.valueOf(1E-5)) < 0);
    }

    @Test
    void multiply() {
        assertAll(
                () -> assertTrue(Complex.valueOf(0,0).mul(Complex.valueOf(1000, 1000))
                        .equals(Complex.valueOf(0,0))),
                () -> assertTrue(Complex.valueOf(1,2).mul(Complex.valueOf(1000, 1000))
                        .equals(Complex.valueOf(-1000,3000))),
                () -> assertTrue(Complex.valueOf(-1,-2).mul(Complex.valueOf(1000, 1000))
                        .equals(Complex.valueOf(1000,-3000)))
        );
    }

    @Test
    void getModule() {
        assertAll(
                () -> assertTrue( Complex.valueOf(3, 4).getModule()
                    .subtract(BigDecimal.valueOf(5d)).abs().compareTo(BigDecimal.valueOf(1E-5)) < 0),
                () -> assertTrue( Complex.valueOf(-3, 4).getModule()
                        .subtract(BigDecimal.valueOf(5d)).abs().compareTo(BigDecimal.valueOf(1E-5)) < 0),
                () -> assertTrue( Complex.valueOf(3, -4).getModule()
                        .subtract(BigDecimal.valueOf(5d)).abs().compareTo(BigDecimal.valueOf(1E-5)) < 0),
                () -> assertTrue( Complex.valueOf(0.3, 0.4).getModule()
                        .subtract(BigDecimal.valueOf(0.5d)).abs().compareTo(BigDecimal.valueOf(1E-5)) < 0)
                );
    }

    @Test
    void getArg() {
        assertAll(
                () -> assertTrue(Math.abs(Math.PI/3 - Complex.valueOf(Math.cos(Math.PI*4/3), Math.sin(Math.PI*4/3)).getArg()) < 1E-5),
                () -> assertTrue(Math.abs(Math.PI/3 - Complex.valueOf(4*Math.cos(Math.PI/3), 4*Math.sin(Math.PI/3))
                        .mul(Complex.valueOf(Double.MAX_VALUE, 0)).getArg()) < 1E-5),
                () -> assertTrue(Math.abs(Math.PI/3 - Complex.valueOf(Math.cos(Math.PI/3), Math.sin(Math.PI/3))
                        .mul(Complex.valueOf(Double.MIN_VALUE, 0)).getArg()) < 1E-5)
        );
    }

    @Test
    void ToString() {
        assertEquals("1,12345 + (-6,789)i", Complex.valueOf(1.12345, -6.789).toString());
    }
}
