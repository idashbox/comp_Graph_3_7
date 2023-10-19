package Math.tests;

import Math.vector.Vector4D;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Vector4DTest {

    @Test
    public void testAddition() {
        Vector4D v1 = new Vector4D(1.0, 2.0, 3.0, 4.0);
        Vector4D v2 = new Vector4D(4.0, 5.0, 6.0, 7.0);
        Vector4D result = v1.add(v2);
        assertEquals(5.0, result.get(0), 0.01);
        assertEquals(7.0, result.get(1), 0.01);
        assertEquals(9.0, result.get(2), 0.01);
        assertEquals(11.0, result.get(3), 0.01);
    }

    @Test
    public void testSubtraction() {
        Vector4D v1 = new Vector4D(4.0, 5.0, 6.0, 7.0);
        Vector4D v2 = new Vector4D(1.0, 2.0, 3.0, 4.0);
        Vector4D result = v1.subtract(v2);
        assertEquals(3.0, result.get(0), 0.01);
        assertEquals(3.0, result.get(1), 0.01);
        assertEquals(3.0, result.get(2), 0.01);
        assertEquals(3.0, result.get(3), 0.01);
    }

    @Test
    public void testMultiplication() {
        Vector4D v1 = new Vector4D(2.0, 3.0, 4.0, 5.0);
        double scalar = 2.0;
        Vector4D result = v1.multiply(scalar);
        assertEquals(4.0, result.get(0), 0.01);
        assertEquals(6.0, result.get(1), 0.01);
        assertEquals(8.0, result.get(2), 0.01);
        assertEquals(10.0, result.get(3), 0.01);
    }

    @Test
    public void testDivision() {
        Vector4D v1 = new Vector4D(6.0, 8.0, 10.0, 12.0);
        double scalar = 2.0;
        Vector4D result = v1.divide(scalar);
        assertEquals(3.0, result.get(0), 0.01);
        assertEquals(4.0, result.get(1), 0.01);
        assertEquals(5.0, result.get(2), 0.01);
        assertEquals(6.0, result.get(3), 0.01);
    }

    @Test
    public void testLength() {
        Vector4D v = new Vector4D(3.0, 4.0, 5.0, 6.0);
        double result = v.length();
        double expected = 9.273618495495704; // Примерное значение
        assertEquals(expected, result, 0.00001); // Учитывать погрешность
    }

    @Test
    public void testNormalization() {
        Vector4D v = new Vector4D(1.0, 2.0, 2.0, 2.0);
        Vector4D result = v.normalize();
        double length = result.length();
        assertTrue(Math.abs(length - 1.0) < 0.00001);
    }

    @Test
    public void testDotProduct() {
        Vector4D v1 = new Vector4D(1.0, 2.0, 3.0, 4.0);
        Vector4D v2 = new Vector4D(4.0, 5.0, 6.0, 7.0);
        double result = v1.dotProduct(v2);
        double expected = 60.0;
        assertEquals(expected, result, 0.00001); // Учитывать погрешность

    }
}
