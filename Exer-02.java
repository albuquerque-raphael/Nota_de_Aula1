//Defina um sistema onde o usuário informe (na classe principal, através do teclado)
//qual opção deseja visualizar. Caso informe 1, ele vai ver a soma de dois números
//caso informe 2, vai ver a subtração, 3 a divisão, 4 multiplicação.
// Observação, essas operações deverão ser realizadas em uma classe chamada matemática


import java.util.Scanner;

class Matematica {
    public static double somar(double num1, double num2) {
        return num1 + num2;
    }

    public static double subtrair(double num1, double num2) {
        return num1 - num2;
    }

    public static double dividir(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Erro: Divisão por zero!");
            return Double.NaN; // Retorna NaN (Not-a-Number) em caso de divisão por zero.
        }
        return num1 / num2;
    }

    public static double multiplicar(double num1, double num2) {
        return num1 * num2;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha a operação:");
        System.out.println("1 - Soma");
        System.out.println("2 - Subtração");
        System.out.println("3 - Divisão");
        System.out.println("4 - Multiplicação");

        int escolha = scanner.nextInt();

        System.out.print("Digite o primeiro número: ");
        double num1 = scanner.nextDouble();

        System.out.print("Digite o segundo número: ");
        double num2 = scanner.nextDouble();

        double resultado = 0.0;

        switch (escolha) {
            case 1:
                resultado = Matematica.somar(num1, num2);
                break;
            case 2:
                resultado = Matematica.subtrair(num1, num2);
                break;
            case 3:
                resultado = Matematica.dividir(num1, num2);
                break;
            case 4:
                resultado = Matematica.multiplicar(num1, num2);
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }

        System.out.println("Resultado: " + resultado);

        scanner.close();
    }
}
