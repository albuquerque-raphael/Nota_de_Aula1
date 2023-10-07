//Defina uma classe Aluno que faça o cadastro do nome das três notasl
//e a operação do calculo da mádia. Ao final, exiba (na classe principal)
//a média. Em seguida informa se ela está aprovado, reprovado ou na final
//Se a média for >= 70 está aprovado, abaixo de 40 está reprovado, senão,
//está a final.

import java.util.Scanner;

public class Aluno {
    private String nome;
    private double nota1;
    private double nota2;
    private double nota3;


    public Aluno(String nome, double nota1, double nota2, double nota3) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = npta3;
    }
    public double calcularMedia() {
        return (nota1 + nota2 + nota3) / 3.0;    
    }
    public void exibirStatus() {
        double media = calcularMedia();
        System.out.println("Aluno " + nome);
        System.out.println("Média" + media);

        if (media >= 70) {
            System.out.println("Você está aprovado!")
        } else if (media < 40) {
            System.out.println("Você está reprovado!");
        } else {
            System.out.println("Na final!")
        }
    }
    public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual é seu nome: ");
        String nome = scanner.nextLine();

        System.out.println("Qual foi a primeria nota: ")
        double nota1 = scanner.nextDouble();

        System.out.println("Qual foi a segunda nota: ")
        double nota2 = scanner.nextLine();

        System.out.println("Qual foi a terceira nota: ")
        double nota3 = scanner.nextLine();

        Aluno aluno = new Aluno(nome, nota1, nota2, nota3);
        aluno.exibirStatus();
        
        scanner.close();
    }
}