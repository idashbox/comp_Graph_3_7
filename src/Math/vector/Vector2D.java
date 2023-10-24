package Math.vector;

public class Vector2D{
    private double x;
    private double y;
    private static double eps = 1e-4;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double get(int index) {
        switch (index){
            case 0: return x;
            case 1: return y;
        }
    throw new IllegalArgumentException("Индекс выходит за границы");
    }

    // Сложение векторов
    public Vector2D add(Vector2D other) {
        return new Vector2D(this.x + other.x, this.y + other.y);
    }

    // Вычитание векторов
    public Vector2D subtract(Vector2D other) {
        return new Vector2D(this.x - other.x, this.y - other.y);
    }

    // Умножение на скаляр
    public Vector2D multiply(double scalar) {
        return new Vector2D(this.x * scalar, this.y * scalar);
    }

    // Деление на скаляр
    public Vector2D divide(double scalar) {
        if (Math.abs(scalar) < eps) {
            throw new ArithmeticException("Деление на ноль");
        }
        return new Vector2D(this.x / scalar, this.y / scalar);
    }

    // Вычисление длины вектора
    public double length() {
        return Math.sqrt(x * x + y * y);
    }

    // Нормализация вектора
    public Vector2D normalize() {
        double len = length();
        if (Math.abs(len) < eps) {
            return new Vector2D(0, 0);
        }
        return new Vector2D(x / len, y / len);
    }

    // Скалярное произведение векторов
    public double dotProduct(Vector2D other) {
        return this.x * other.x + this.y * other.y;
    }
}
