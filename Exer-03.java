//Crie uma classe chamada produto que representará um produto com os 
//atributos nome, preço e quantidade em estoque. Implemente um médtodo
//para adicionar estoque, vender unidades do produto. Na classe principal
//crie um objeto Produto, realize operações de: Adicionar estoque, Vender
//produtos, Exibir estoque.

class Produto {
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;

    public Produto(String nome, double preco, int quantidadeEmEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public void adicionarEstoque(int quantidade) {
        if (quantidade > 0) {
            quantidadeEmEstoque += quantidade;
            System.out.println(quantidade + " unidades adicionadas ao estoque de " + nome);
        } else {
            System.out.println("A quantidade a ser adicionada deve ser maior que zero.");
        }
    }

    public void vender(int quantidade) {
        if (quantidade > 0 && quantidade <= quantidadeEmEstoque) {
            quantidadeEmEstoque -= quantidade;
            System.out.println(quantidade + " unidades de " + nome + " vendidas.");
        } else if (quantidade > quantidadeEmEstoque) {
            System.out.println("Quantidade insuficiente em estoque para venda.");
        } else {
            System.out.println("A quantidade a ser vendida deve ser maior que zero.");
        }
    }

    public void exibirEstoque() {
        System.out.println("Produto: " + nome);
        System.out.println("Preço: R$" + preco);
        System.out.println("Quantidade em Estoque: " + quantidadeEmEstoque);
    }
}

public class Main {
    public static void main(String[] args) {
        Produto produto = new Produto("Camiseta", 29.99, 50);

        produto.adicionarEstoque(10);

        produto.vender(5);

        produto.exibirEstoque();
    }
}
