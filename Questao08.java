class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do produto nao pode ser vazio.");
        }
        if (preco <= 0) {
            throw new IllegalArgumentException("O preco deve ser maior que zero.");
        }
        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade nao pode ser negativa.");
        }
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return String.format("Produto{nome='%s', preco=%.2f, quantidade=%d}", nome, preco, quantidade);
    }
}

public class Questao08 {
    private static void cadastrar(String nome, double preco, int quantidade) {
        try {
            Produto p = new Produto(nome, preco, quantidade);
            System.out.println("Cadastrado: " + p);
        } catch (IllegalArgumentException e) {
            System.out.println("Falha no cadastro: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        cadastrar("Teclado", 120.0, 10);   // valido
        cadastrar("", 50.0, 5);            // nome vazio
        cadastrar("Mouse", 0, 5);          // preco invalido
        cadastrar("Monitor", 800.0, -1);   // quantidade negativa
    }
}
