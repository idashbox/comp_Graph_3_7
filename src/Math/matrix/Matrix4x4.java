package Math.matrix;

import Math.vector.Vector4D;

public class Matrix4x4{
    private double[][] matrix = new double[4][4];

    public Matrix4x4(double[][] data) {
        if (data.length != 4 || data[0].length != 4) {
            throw new IllegalArgumentException("Matrix must be 4x4");
        }
        this.matrix = data;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    // Сложение матриц
    public Matrix4x4 add(Matrix4x4 other) {
        double[][] result = new double[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = this.matrix[i][j] + other.matrix[i][j];
            }
        }
        return new Matrix4x4(result);
    }

    // Вычитание матриц
    public Matrix4x4 subtract(Matrix4x4 other) {
        double[][] result = new double[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = this.matrix[i][j] - other.matrix[i][j];
            }
        }
        return new Matrix4x4(result);
    }

    // Умножение на вектор4Д
    public Vector4D multiply(Vector4D vector) {
        if (vector == null) {
            throw new NullPointerException("Vector cannot be null");
        }
        double[] result = new double[4];
        for (int i = 0; i < 4; i++) {
            result[i] = 0;
            for (int j = 0; j < 4; j++) {
                result[i] += this.matrix[i][j] * vector.get(j);
            }
        }
        return new Vector4D(result[0], result[1], result[2], result[3]);
    }

    // Умножение на матрицу
    public Matrix4x4 multiply(Matrix4x4 other) {
        double[][] result = new double[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = 0;
                for (int k = 0; k < 4; k++) {
                    result[i][j] += this.matrix[i][k] * other.matrix[k][j];
                }
            }
        }
        return new Matrix4x4(result);
    }

    // Транспонирование
    public Matrix4x4 transpose() {
        double[][] result = new double[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = this.matrix[j][i];
            }
        }
        return new Matrix4x4(result);
    }

    // Задание единичной матрицы
    public static Matrix4x4 identity() {
        double[][] identityMatrix = new double[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        return new Matrix4x4(identityMatrix);
    }

    // Задание нулевой матрицы
    public static Matrix4x4 zero() {
        double[][] zeroMatrix = new double[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        return new Matrix4x4(zeroMatrix);
    }
}
