import java.util.InputMismatchException;
import java.util.Scanner;

public class Questao07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Digite o primeiro numero inteiro: ");
            int a = sc.nextInt();
            System.out.print("Digite o segundo numero inteiro: ");
            int b = sc.nextInt();

            int resultado = a / b;
            System.out.println("Resultado: " + a + " / " + b + " = " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Erro: nao e possivel dividir por zero.");
        } catch (InputMismatchException e) {
            System.out.println("Erro: entrada invalida. Digite apenas numeros inteiros.");
        } finally {
            System.out.println("Operacao encerrada.");
            sc.close();
        }
    }
}
