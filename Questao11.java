class PrecoInvalidoException extends Exception {
    public PrecoInvalidoException(String mensagem) {
        super(mensagem);
    }
}

interface Descontavel {
    double aplicarDesconto(double percentual);
}

abstract class Produto {
    protected String nome;
    protected double precoBase;

    public Produto(String nome, double precoBase) throws PrecoInvalidoException {
        if (precoBase <= 0) {
            throw new PrecoInvalidoException("Preco invalido para \"" + nome + "\": " + precoBase);
        }
        this.nome = nome;
        this.precoBase = precoBase;
    }

    public String getNome() { return nome; }

    public abstract double calcularPrecoFinal();
}

class ProdutoFisico extends Produto {
    private static final double TAXA_ENTREGA = 15.00;

    public ProdutoFisico(String nome, double precoBase) throws PrecoInvalidoException {
        super(nome, precoBase);
    }

    @Override
    public double calcularPrecoFinal() { return precoBase + TAXA_ENTREGA; }
}

class ProdutoDigital extends Produto implements Descontavel {
    public ProdutoDigital(String nome, double precoBase) throws PrecoInvalidoException {
        super(nome, precoBase);
    }

    @Override
    public double calcularPrecoFinal() { return precoBase; }

    @Override
    public double aplicarDesconto(double percentual) {
        return calcularPrecoFinal() * (1 - percentual / 100.0);
    }
}

public class Questao11 {
    public static void main(String[] args) {
        try {
            Produto[] produtos = {
                new ProdutoFisico("Livro impresso", 80.0),
                new ProdutoDigital("E-book", 40.0),
                new ProdutoDigital("Curso online", 200.0)
            };

            for (Produto p : produtos) {
                System.out.printf("%s -> preco final: R$ %.2f%n", p.getNome(), p.calcularPrecoFinal());
            }

            if (produtos[1] instanceof Descontavel) {
                Descontavel d = (Descontavel) produtos[1];
                System.out.printf("%s com 20%% de desconto: R$ %.2f%n", produtos[1].getNome(), d.aplicarDesconto(20));
            }
        } catch (PrecoInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            new ProdutoFisico("Produto defeituoso", 0);
        } catch (PrecoInvalidoException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
        }
    }
}
