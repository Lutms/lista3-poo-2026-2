class LivroIndisponivelException extends Exception {
    public LivroIndisponivelException(String mensagem) {
        super(mensagem);
    }
}

class Livro {
    private String titulo;
    private int exemplaresDisponiveis;

    public Livro(String titulo, int exemplaresDisponiveis) {
        this.titulo = titulo;
        this.exemplaresDisponiveis = exemplaresDisponiveis;
    }

    public void emprestar() throws LivroIndisponivelException {
        if (exemplaresDisponiveis <= 0) {
            throw new LivroIndisponivelException("Nao ha exemplares disponiveis de \"" + titulo + "\".");
        }
        exemplaresDisponiveis--;
    }

    public int getExemplaresDisponiveis() { return exemplaresDisponiveis; }
}

public class Questao09 {
    public static void main(String[] args) {
        Livro livro = new Livro("Clean Code", 2);

        for (int i = 1; i <= 3; i++) {
            try {
                livro.emprestar();
                System.out.println("Emprestimo " + i + " realizado. Restantes: " + livro.getExemplaresDisponiveis());
            } catch (LivroIndisponivelException e) {
                System.out.println("Emprestimo " + i + " falhou: " + e.getMessage());
            }
        }
    }
}
