package Math.tests;

import Math.vector.Vector3D;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Vector3DTest {

    @Test
    public void testAddition() {
        Vector3D v1 = new Vector3D(1.0, 2.0, 3.0);
        Vector3D v2 = new Vector3D(4.0, 5.0, 6.0);
        Vector3D result = v1.add(v2);
        assertEquals(5.0, result.get(0), 0.01);
        assertEquals(7.0, result.get(1), 0.01);
        assertEquals(9.0, result.get(2), 0.01);
    }

    @Test
    public void testSubtraction() {
        Vector3D v1 = new Vector3D(4.0, 5.0, 6.0);
        Vector3D v2 = new Vector3D(1.0, 2.0, 3.0);
        Vector3D result = v1.subtract(v2);
        assertEquals(3.0, result.get(0), 0.01);
        assertEquals(3.0, result.get(1), 0.01);
        assertEquals(3.0, result.get(2), 0.01);
    }

    @Test
    public void testMultiplication() {
        Vector3D v1 = new Vector3D(2.0, 3.0, 4.0);
        double scalar = 2.0;
        Vector3D result = v1.multiply(scalar);
        assertEquals(4.0, result.get(0), 0.01);
        assertEquals(6.0, result.get(1), 0.01);
        assertEquals(8.0, result.get(2), 0.01);
    }

    @Test
    public void testDivision() {
        Vector3D v1 = new Vector3D(6.0, 8.0, 10.0);
        double scalar = 2.0;
        Vector3D result = v1.divide(scalar);
        assertEquals(3.0, result.get(0), 0.01);
        assertEquals(4.0, result.get(1), 0.01);
        assertEquals(5.0, result.get(2), 0.01);
    }

    @Test
    public void testLength() {
        Vector3D v = new Vector3D(3.0, 4.0, 5.0);
        double result = v.length();
        double expected = 7.0710678118654755; // Примерное значение
        assertEquals(expected, result, 0.00001); // Учитывать погрешность
    }

    @Test
    public void testNormalization() {
        Vector3D v = new Vector3D(1.0, 2.0, 2.0);
        Vector3D result = v.normalize();
        double length = result.length();
        assertTrue(Math.abs(length - 1.0) < 0.00001);
    }

    @Test
    public void testDotProduct() {
        Vector3D v1 = new Vector3D(1.0, 2.0, 3.0);
        Vector3D v2 = new Vector3D(4.0, 5.0, 6.0);
        double result = v1.dotProduct(v2);
        double expected = 32.0;
        assertEquals(expected, result, 0.00001); // Учитывать погрешность
    }

    @Test
    public void testCrossProduct() {
        Vector3D v1 = new Vector3D(1.0, 0.0, 0.0);
        Vector3D v2 = new Vector3D(0.0, 1.0, 0.0);
        Vector3D result = v1.crossProduct(v2);
        assertEquals(0.0, result.get(0), 0.01);
        assertEquals(0.0, result.get(1), 0.01);
        assertEquals(1.0, result.get(2), 0.01);
    }
}
