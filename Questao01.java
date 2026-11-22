abstract class Funcionario {
    protected String nome;
    protected double salarioBase;

    public Funcionario(String nome, double salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    public String getNome() { return nome; }

    public abstract double calcularSalario();
}

class FuncionarioCLT extends Funcionario {
    public FuncionarioCLT(String nome, double salarioBase) { super(nome, salarioBase); }

    @Override
    public double calcularSalario() { return salarioBase * 1.10; }
}

class FuncionarioPJ extends Funcionario {
    public FuncionarioPJ(String nome, double salarioBase) { super(nome, salarioBase); }

    @Override
    public double calcularSalario() { return salarioBase * 0.95; }
}

public class Questao01 {
    public static void main(String[] args) {
        Funcionario[] funcionarios = {
            new FuncionarioCLT("Ana", 3000),
            new FuncionarioPJ("Bruno", 3000)
        };
        for (Funcionario f : funcionarios) {
            System.out.printf("%s (%s): R$ %.2f%n", f.getNome(), f.getClass().getSimpleName(), f.calcularSalario());
        }
    }
}
