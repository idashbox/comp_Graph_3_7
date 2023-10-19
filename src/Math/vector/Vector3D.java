package Math.vector;

public class Vector3D extends Vector{
    private double x;
    private double y;
    private double z;

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
//        System.out.println("Index may be in 0 to 2");
        return 0;
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
        if (scalar == 0) {
            throw new ArithmeticException("Division by zero");
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
        if (len == 0) {
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
