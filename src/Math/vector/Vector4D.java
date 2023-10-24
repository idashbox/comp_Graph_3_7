package Math.vector;

public class Vector4D{
    private double x;
    private double y;
    private double z;
    private double w;
    private static double eps = 1e-4;

    public Vector4D(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public double get(int index) {
        switch (index){
            case 0: return x;
            case 1: return y;
            case 2: return z;
            case 3: return w;
        }
        throw new IllegalArgumentException("Индекс выходит за границы");
    }
    // Сложение векторов
    public Vector4D add(Vector4D other) {
        return new Vector4D(this.x + other.x, this.y + other.y, this.z + other.z, this.w + other.w);
    }

    // Вычитание векторов
    public Vector4D subtract(Vector4D other) {
        return new Vector4D(this.x - other.x, this.y - other.y, this.z - other.z, this.w - other.w);
    }

    // Умножение на скаляр
    public Vector4D multiply(double scalar) {
        return new Vector4D(this.x * scalar, this.y * scalar, this.z * scalar, this.w * scalar);
    }

    // Деление на скаляр
    public Vector4D divide(double scalar) {
        if (Math.abs(scalar) < eps) {
            throw new ArithmeticException("Деление на ноль");
        }
        return new Vector4D(this.x / scalar, this.y / scalar, this.z / scalar, this.w / scalar);
    }

    // Вычисление длины вектора
    public double length() {
        return Math.sqrt(x * x + y * y + z * z + w * w);
    }

    // Нормализация вектора
    public Vector4D normalize() {
        double length = length();
        if (Math.abs(length) < eps) {
            return new Vector4D(0, 0, 0, 0);
        }
        return new Vector4D(x / length, y / length, z / length, w / length);
    }

    // Скалярное произведение векторов
    public double dotProduct(Vector4D other) {
        return this.x * other.x + this.y * other.y + this.z * other.z + this.w * other.w;
    }
}
