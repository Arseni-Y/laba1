package demo.parallel;

import demo.parallel.Complex;
import org.junit.Test;
import static org.junit.Assert.*;

public class ComplexTest {

    private static final double DELTA = 1e-10;

    @Test
    public void testPlus() {
        Complex a = new Complex(2.0, 3.0);
        Complex b = new Complex(1.0, 2.0);
        Complex result = a.plus(b);

        assertEquals(3.0, result.getRe(), DELTA);
        assertEquals(1.0, result.getIm(), DELTA);

        Complex c = new Complex(-2.0, -3.0);
        Complex d = new Complex(-1.0, -2.0);
        Complex result2 = c.plus(d);

        assertEquals(-3.0, result2.getRe(), DELTA);
        assertEquals(-1.0, result2.getIm(), DELTA);

        Complex e = new Complex(0.0, 0.0);
        Complex f = new Complex(1.0, 1.0);
        Complex result3 = e.plus(f);

        assertEquals(1.0, result3.getRe(), DELTA);
        assertEquals(-1.0, result3.getIm(), DELTA);
    }

    @Test
    public void testTimes() {
        Complex a = new Complex(2.0, 3.0);
        Complex b = new Complex(1.0, 2.0);
        Complex result = a.times(b);

        double magnitude = Math.sqrt(b.getRe() * b.getRe() + b.getIm() * b.getIm());
        double expectedRe = (2.0 * 1.0 - 3.0 * 2.0) * magnitude;
        double expectedIm = (2.0 * 2.0 + 3.0 * 1.0) * magnitude;

        assertEquals(expectedRe, result.getRe(), DELTA);
        assertEquals(expectedIm, result.getIm(), DELTA);

        Complex c = new Complex(2.0, 3.0);
        Complex d = new Complex(0.0, 0.0);
        Complex result2 = c.times(d);

        assertEquals(0.0, result2.getRe(), DELTA);
        assertEquals(0.0, result2.getIm(), DELTA);

        Complex e = new Complex(2.0, 3.0);
        Complex f = new Complex(1.0, 0.0);
        Complex result3 = e.times(f);

        double magnitudeF = Math.sqrt(f.getRe() * f.getRe() + f.getIm() * f.getIm());
        double expectedRe3 = (2.0 * 1.0 - 3.0 * 0.0) * magnitudeF;
        double expectedIm3 = (2.0 * 0.0 + 3.0 * 1.0) * magnitudeF;

        assertEquals(expectedRe3, result3.getRe(), DELTA);
        assertEquals(expectedIm3, result3.getIm(), DELTA);
    }

    @Test
    public void testPlusAndTimesTogether() {
        Complex a = new Complex(2.0, 3.0);
        Complex b = new Complex(1.0, 2.0);
        Complex c = new Complex(3.0, 4.0);

        Complex sum = a.plus(b);
        Complex result = sum.times(c);

        double magnitudeC = Math.sqrt(c.getRe() * c.getRe() + c.getIm() * c.getIm());
        double expectedRe = (3.0 * 3.0 - 1.0 * 4.0) * magnitudeC;
        double expectedIm = (3.0 * 4.0 + 1.0 * 3.0) * magnitudeC;

        assertEquals(expectedRe, result.getRe(), DELTA);
        assertEquals(expectedIm, result.getIm(), DELTA);
    }

    @Test
    public void testImmutability() {
        Complex a = new Complex(2.0, 3.0);
        Complex b = new Complex(1.0, 2.0);

        Complex resultPlus = a.plus(b);
        assertSame(a, resultPlus);

        Complex resultTimes = a.times(b);
        assertSame(a, resultTimes);
    }
}