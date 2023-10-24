package Math.vector;

public class Vector3D{
    private double x;
    private double y;
    private double z;
    private static double eps = 1e-4;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public double get(int index) {
        switch (index){
            case 0: return x;
            case 1: return y;
            case 2: return z;
        }
        throw new IllegalArgumentException("Индекс выходит за границы");
    }

    // Сложение векторов
    public Vector3D add(Vector3D other) {
        return new Vector3D(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    // Вычитание векторов
    public Vector3D subtract(Vector3D other) {
        return new Vector3D(this.x - other.x, this.y - other.y, this.z - other.z);
    }

    // Умножение на скаляр
    public Vector3D multiply(double scalar) {
        return new Vector3D(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    // Деление на скаляр
    public Vector3D divide(double scalar) {
        if (Math.abs(scalar) < eps) {
            throw new ArithmeticException("Деление на ноль");
        }
        return new Vector3D(this.x / scalar, this.y / scalar, this.z / scalar);
    }

    // Вычисление длины вектора
    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    // Нормализация вектора
    public Vector3D normalize() {
        double len = length();
        if (Math.abs(len) < eps) {
            return new Vector3D(0, 0, 0);
        }
        return new Vector3D(x / len, y / len, z / len);
    }

    // Скалярное произведение векторов
    public double dotProduct(Vector3D other) {
        return this.x * other.x + this.y * other.y + this.z * other.z;
    }

    // Векторное произведение векторов
    public Vector3D crossProduct(Vector3D other) {
        return new Vector3D(
                this.y * other.z - this.z * other.y,
                this.z * other.x - this.x * other.z,
                this.x * other.y - this.y * other.x
        );
    }
}
