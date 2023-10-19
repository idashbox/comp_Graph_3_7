package Math.tests;
import static org.junit.Assert.*;

import Math.vector.Vector2D;
import org.junit.Test;

public class Vector2DTest {

    @Test
    public void testAdd() {
        Vector2D vector1 = new Vector2D(3.0, 4.0);
        Vector2D vector2 = new Vector2D(1.0, 2.0);
        Vector2D result = vector1.add(vector2);
        assertEquals(4.0, result.get(0), 0.01);
        assertEquals(6.0, result.get(1), 0.01);
    }

    @Test
    public void testSubtract() {
        Vector2D vector1 = new Vector2D(3.0, 4.0);
        Vector2D vector2 = new Vector2D(1.0, 2.0);
        Vector2D result = vector1.subtract(vector2);
        assertEquals(2.0, result.get(0), 0.01);
        assertEquals(2.0, result.get(1), 0.01);
    }

    @Test
    public void testMultiply() {
        Vector2D vector = new Vector2D(3.0, 4.0);
        Vector2D result = vector.multiply(2.0);
        assertEquals(6.0, result.get(0), 0.01);
        assertEquals(8.0, result.get(1), 0.01);
    }

    @Test
    public void testDivide() {
        Vector2D vector = new Vector2D(6.0, 8.0);
        Vector2D result = vector.divide(2.0);
        assertEquals(3.0, result.get(0), 0.01);
        assertEquals(4.0, result.get(1), 0.01);
    }

    @Test
    public void testLength() {
        Vector2D vector = new Vector2D(3.0, 4.0);
        double length = vector.length();
        assertEquals(5.0, length, 0.01);
    }

    @Test
    public void testNormalize() {
        Vector2D vector = new Vector2D(3.0, 4.0);
        Vector2D result = vector.normalize();
        assertEquals(0.6, result.get(0), 0.01);
        assertEquals(0.8, result.get(1), 0.01);
    }

    @Test
    public void testDotProduct() {
        Vector2D vector1 = new Vector2D(3.0, 4.0);
        Vector2D vector2 = new Vector2D(1.0, 2.0);
        double dotProduct = vector1.dotProduct(vector2);
        assertEquals(11.0, dotProduct, 0.01);
    }
}
