package Math.tests;

import Math.matrix.Matrix3x3;
import Math.matrix.Matrix4x4;
import Math.vector.Vector4D;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Matrix4x4Test {

    @Test
    public void testAddition() {
        double[][] data1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        double[][] data2 = {
                {16, 15, 14, 13},
                {12, 11, 10, 9},
                {8, 7, 6, 5},
                {4, 3, 2, 1}
        };
        Matrix4x4 m1 = new Matrix4x4(data1);
        Matrix4x4 m2 = new Matrix4x4(data2);

        Matrix4x4 result = m1.add(m2);

        double[][] expectedData = {
                {17, 17, 17, 17},
                {17, 17, 17, 17},
                {17, 17, 17, 17},
                {17, 17, 17, 17}
        };
        assertArrayEquals(expectedData, result.getMatrix());
    }

    @Test
    public void testSubtraction() {
        double[][] data1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        double[][] data2 = {
                {16, 15, 14, 13},
                {12, 11, 10, 9},
                {8, 7, 6, 5},
                {4, 3, 2, 1}
        };
        Matrix4x4 m1 = new Matrix4x4(data1);
        Matrix4x4 m2 = new Matrix4x4(data2);

        Matrix4x4 result = m1.subtract(m2);

        double[][] expectedData = {
                {-15, -13, -11, -9},
                {-7, -5, -3, -1},
                {1, 3, 5, 7},
                {9, 11, 13, 15}
        };
        assertArrayEquals(expectedData, result.getMatrix());
    }

    @Test
    public void testMatrixVectorMultiplication() {
        double[][] matrixData = {
                {2, 0, 0, 0},
                {0, 2, 0, 0},
                {0, 0, 2, 0},
                {0, 0, 0, 2}
        };
        Matrix4x4 matrix = new Matrix4x4(matrixData);

        double[] vectorData = {1, 2, 3, 4};
        Vector4D vector = new Vector4D(vectorData[0], vectorData[1],vectorData[2], vectorData[3]);

        Vector4D result = matrix.multiply(vector);

        assertEquals(2, result.get(0), 0.01);
        assertEquals(4, result.get(1), 0.01);
        assertEquals(6, result.get(2), 0.01);
        assertEquals(8, result.get(3), 0.01);
    }

    @Test
    public void testMatrixMatrixMultiplication() {
        double[][] matrixData1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        Matrix4x4 matrix1 = new Matrix4x4(matrixData1);

        double[][] matrixData2 = {
                {16, 15, 14, 13},
                {12, 11, 10, 9},
                {8, 7, 6, 5},
                {4, 3, 2, 1}
        };
        Matrix4x4 matrix2 = new Matrix4x4(matrixData2);

        Matrix4x4 result = matrix1.multiply(matrix2);

        double[][] expectedData = {
                {80, 70, 60, 50},
                {240, 214, 188, 162},
                {400, 358, 316, 274},
                {560, 502, 444, 386}
        };
        assertArrayEquals(expectedData, result.getMatrix());
    }

    @Test
    public void testTranspose() {
        double[][] matrixData = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        Matrix4x4 matrix = new Matrix4x4(matrixData);

        Matrix4x4 transposed = matrix.transpose();

        double[][] expectedData = {
                {1, 5, 9, 13},
                {2, 6, 10, 14},
                {3, 7, 11, 15},
                {4, 8, 12, 16}
        };
        assertArrayEquals(expectedData, transposed.getMatrix());
    }

    @Test
    public void testIdentityMatrix() {
        Matrix4x4 identity = Matrix4x4.identity();
        double[][] data = identity.getMatrix();

        double[][] expectedData = {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };

        assertArrayEquals(expectedData, data);
    }

    @Test
    public void testZeroMatrix() {
        Matrix4x4 zero = Matrix4x4.zero();
        double[][] data = zero.getMatrix();

        double[][] expectedData = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        assertArrayEquals(expectedData, data);
    }
    @Test
    public void testDetermination() {
        double[][] data = {
                {10, 34, 5, 45},
                {28, 12, 93, 3},
                {7, 48, 200, 10},
                {41, 6, 23, 18}
        };
        Matrix4x4 matrix = new Matrix4x4(data);

        double result = matrix.determinate();
        assertEquals(308450, result, 0.001);
    }
}
