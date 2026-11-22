abstract class FormaGeometrica {
    public abstract double calcularArea();
}

class Circulo extends FormaGeometrica {
    private double raio;
    public Circulo(double raio) { this.raio = raio; }

    @Override
    public double calcularArea() { return Math.PI * raio * raio; }
}

class Retangulo extends FormaGeometrica {
    private double base, altura;
    public Retangulo(double base, double altura) { this.base = base; this.altura = altura; }

    @Override
    public double calcularArea() { return base * altura; }
}

class Triangulo extends FormaGeometrica {
    private double base, altura;
    public Triangulo(double base, double altura) { this.base = base; this.altura = altura; }

    @Override
    public double calcularArea() { return base * altura / 2; }
}

public class Questao02 {
    public static void main(String[] args) {
        FormaGeometrica[] formas = {
            new Circulo(3), new Retangulo(4, 5), new Triangulo(6, 2)
        };
        for (FormaGeometrica f : formas) {
            System.out.printf("%s -> area = %.2f%n", f.getClass().getSimpleName(), f.calcularArea());
        }
    }
}
