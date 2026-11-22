class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String mensagem) {
        super(mensagem);
    }
}

class Conta {
    private int numero;
    private double saldo;

    public Conta(int numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public void transferir(Conta destino, double valor) throws SaldoInsuficienteException {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor deve ser maior que zero.");
        }
        if (destino == null) {
            throw new IllegalArgumentException("A conta de destino nao pode ser null.");
        }
        if (this.saldo < valor) {
            throw new SaldoInsuficienteException(
                String.format("Conta %d: saldo insuficiente (saldo: %.2f, valor: %.2f).", numero, saldo, valor));
        }
        this.saldo -= valor;
        destino.saldo += valor;
    }

    public int getNumero() { return numero; }
    public double getSaldo() { return saldo; }
}

public class Questao10 {
    private static void tentar(Conta origem, Conta destino, double valor) {
        try {
            origem.transferir(destino, valor);
            System.out.printf("Transferencia de R$ %.2f realizada.%n", valor);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Conta a = new Conta(1, 500);
        Conta b = new Conta(2, 100);

        tentar(a, b, 200);   // valida
        tentar(a, b, 1000);  // saldo insuficiente
        tentar(a, b, -50);   // valor invalido
        tentar(a, null, 10); // destino null

        System.out.printf("Saldo A: %.2f | Saldo B: %.2f%n", a.getSaldo(), b.getSaldo());
    }
}
