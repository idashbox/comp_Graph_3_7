package Math.tests;

import Math.matrix.Matrix3x3;
import Math.vector.Vector3D;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Matrix3x3Test {

    @Test
    public void testAddition() {
        double[][] data1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        double[][] data2 = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };
        Matrix3x3 m1 = new Matrix3x3(data1);
        Matrix3x3 m2 = new Matrix3x3(data2);

        Matrix3x3 result = m1.add(m2);

        double[][] expectedData = {
                {10, 10, 10},
                {10, 10, 10},
                {10, 10, 10}
        };
        Matrix3x3 expected = new Matrix3x3(expectedData);
        for (int i = 0; i < 3; i++){
            for (int j = 0; i < 3; i++) {
                assertEquals(expected.getMatrix()[i][j], result.getMatrix()[i][j], 0.001);
            }
        }
    }

    @Test
    public void testSubtraction() {
        double[][] data1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        double[][] data2 = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };
        Matrix3x3 m1 = new Matrix3x3(data1);
        Matrix3x3 m2 = new Matrix3x3(data2);

        Matrix3x3 result = m1.subtract(m2);

        double[][] expectedData = {
                {-8, -6, -4},
                {-2, 0, 2},
                {4, 6, 8}
        };
        Matrix3x3 expected = new Matrix3x3(expectedData);

        for (int i = 0; i < 3; i++){
            for (int j = 0; i < 3; i++) {
                assertEquals(expected.getMatrix()[i][j], result.getMatrix()[i][j], 0.001);
            }
        }
    }

    @Test
    public void testVectorMultiplication() {
        double[][] data = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Matrix3x3 matrix = new Matrix3x3(data);
        Vector3D vector = new Vector3D(2, 3, 4);

        Vector3D result = matrix.multiply(vector);

        Vector3D expected = new Vector3D(20, 47, 74);

        for (int i = 0; i < 3; i++){
                assertEquals(expected.get(i), result.get(i), 0.001);
            }
    }

    @Test
    public void testMatrixMultiplication() {
        double[][] data1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        double[][] data2 = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };
        Matrix3x3 m1 = new Matrix3x3(data1);
        Matrix3x3 m2 = new Matrix3x3(data2);

        Matrix3x3 result = m1.multiply(m2);

        double[][] expectedData = {
                {30, 24, 18},
                {84, 69, 54},
                {138, 114, 90}
        };
        Matrix3x3 expected = new Matrix3x3(expectedData);

        for (int i = 0; i < 3; i++){
            for (int j = 0; i < 3; i++) {
                assertEquals(expected.getMatrix()[i][j], result.getMatrix()[i][j], 0.001);
            }
        }
    }

    @Test
    public void testTranspose() {
        double[][] data = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Matrix3x3 matrix = new Matrix3x3(data);

        Matrix3x3 result = matrix.transpose();

        double[][] expectedData = {
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}
        };
        Matrix3x3 expected = new Matrix3x3(expectedData);

        for (int i = 0; i < 3; i++){
            for (int j = 0; i < 3; i++) {
                assertEquals(expected.getMatrix()[i][j], result.getMatrix()[i][j], 0.001);
            }
        }
    }

    @Test
    public void testIdentityMatrix() {
        Matrix3x3 identity = Matrix3x3.identity();

        double[][] expectedData = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };

        double[][] actualData = identity.getMatrix();

        assertArrayEquals(expectedData, actualData);
    }

    @Test
    public void testZeroMatrix() {
        Matrix3x3 zero = Matrix3x3.zero();

        double[][] expectedData = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        double[][] actualData = zero.getMatrix();

        assertArrayEquals(expectedData, actualData);
    }
    @Test
    public void testDetermination() {
        double[][] data = {
                {10, 34, 5},
                {28, 12, 93},
                {7, 48, 200}
        };
        Matrix3x3 matrix = new Matrix3x3(data);

        double result = matrix.determinate();
        assertEquals(-182606, result, 0.001);
    }
}
