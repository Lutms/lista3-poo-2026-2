interface Pagamento {
    void processarPagamento(double valor);
}

class PagamentoPix implements Pagamento {
    @Override
    public void processarPagamento(double valor) {
        System.out.printf("Pagamento de R$ %.2f realizado via PIX (confirmacao instantanea).%n", valor);
    }
}

class PagamentoCartao implements Pagamento {
    @Override
    public void processarPagamento(double valor) {
        System.out.printf("Pagamento de R$ %.2f aprovado no CARTAO de credito.%n", valor);
    }
}

class PagamentoBoleto implements Pagamento {
    @Override
    public void processarPagamento(double valor) {
        System.out.printf("Boleto de R$ %.2f gerado. Aguardando compensacao.%n", valor);
    }
}

public class Questao04 {
    public static void main(String[] args) {
        Pagamento[] pagamentos = { new PagamentoPix(), new PagamentoCartao(), new PagamentoBoleto() };
        for (Pagamento p : pagamentos) {
            p.processarPagamento(199.90);
        }
    }
}
