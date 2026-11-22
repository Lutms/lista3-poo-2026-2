abstract class ContaBancaria {
    protected String titular;
    protected double saldo;

    public ContaBancaria(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public abstract void sacar(double valor);

    public double getSaldo() { return saldo; }
    public String getTitular() { return titular; }
}

class ContaCorrente extends ContaBancaria {
    private static final double TAXA_SAQUE = 2.00;

    public ContaCorrente(String titular, double saldo) { super(titular, saldo); }

    @Override
    public void sacar(double valor) {
        double total = valor + TAXA_SAQUE;
        if (valor > 0 && total <= saldo) {
            saldo -= total;
        } else {
            System.out.println("Saque negado (conta corrente): saldo insuficiente.");
        }
    }
}

class ContaPoupanca extends ContaBancaria {
    public ContaPoupanca(String titular, double saldo) { super(titular, saldo); }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println("Saque negado (poupanca): saldo insuficiente.");
        }
    }
}

public class Questao03 {
    public static void main(String[] args) {
        ContaBancaria cc = new ContaCorrente("Ana", 500);
        ContaBancaria cp = new ContaPoupanca("Bruno", 500);

        cc.depositar(100);
        cc.sacar(50);   // 50 + taxa de 2
        cp.depositar(100);
        cp.sacar(50);   // sem taxa
        cc.sacar(1000); // invalido

        System.out.printf("%s (corrente): R$ %.2f%n", cc.getTitular(), cc.getSaldo());
        System.out.printf("%s (poupanca): R$ %.2f%n", cp.getTitular(), cp.getSaldo());
    }
}
