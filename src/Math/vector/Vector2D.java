package Math.vector;

public class Vector2D extends Vector{
    private double x;
    private double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double get(int index) {
        switch (index){
            case 0: return x;
            case 1: return y;
        }
//        System.out.println("Index may be in 0 to 1");
        return 0;
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
        if (scalar == 0) {
            throw new ArithmeticException("Division by zero");
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
        if (len == 0) {
            return new Vector2D(0, 0);
        }
        return new Vector2D(x / len, y / len);
    }

    // Скалярное произведение векторов
    public double dotProduct(Vector2D other) {
        return this.x * other.x + this.y * other.y;
    }
}
