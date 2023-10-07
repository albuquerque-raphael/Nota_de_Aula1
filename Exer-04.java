//Elabore um programa que simule um sistema bancário de um cliente.
//Inicialemnte o saldo está zerado, mas o cliente pode escolher qual
//quer uma das seguintes opções do menu: Consultar saldo, Depositar,
//Sacar e ransferir.
//Uma observação é que o clinete só pode sacar e transferir, se o saldo
//da conta não estiver zerado

import java.util.Scanner;

class SistemaBancario {
    private double saldo;

    public SistemaBancario() {
        this.saldo = 0.0;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("O valor a ser depositado deve ser maior que zero.");
        }
    }

    public void sacar(double valor) {
        if (saldo > 0 && valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        } else if (saldo == 0) {
            System.out.println("Saldo insuficiente para saque.");
        } else {
            System.out.println("Valor de saque inválido.");
        }
    }

    public void transferir(double valor, SistemaBancario destino) {
        if (saldo > 0 && valor > 0 && valor <= saldo) {
            saldo -= valor;
            destino.depositar(valor);
            System.out.println("Transferência de R$" + valor + " realizada com sucesso.");
        } else if (saldo == 0) {
            System.out.println("Saldo insuficiente para transferência.");
        } else {
            System.out.println("Valor de transferência inválido.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SistemaBancario cliente = new SistemaBancario();
        SistemaBancario destinatario = new SistemaBancario();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1 - Consultar Saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Transferir");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    double saldo = cliente.consultarSaldo();
                    System.out.println("Saldo: R$" + saldo);
                    break;
                case 2:
                    System.out.print("Digite o valor a ser depositado: ");
                    double valorDeposito = scanner.nextDouble();
                    cliente.depositar(valorDeposito);
                    break;
                case 3:
                    System.out.print("Digite o valor a ser sacado: ");
                    double valorSaque = scanner.nextDouble();
                    cliente.sacar(valorSaque);
                    break;
                case 4:
                    System.out.print("Digite o valor a ser transferido: ");
                    double valorTransferencia = scanner.nextDouble();
                    cliente.transferir(valorTransferencia, destinatario);
                    break;
                case 0:
                    System.out.println("Saindo do programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
