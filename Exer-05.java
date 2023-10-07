//Crie um programa que simule um sistema de biblioteca para gerenciar 
//emrpestimo de livros. Os usuários podem escolher as seguintes opções:
//Registrar um novo livro com título e autor, Registrar um novo usuário
//com o nome e número de identificação, realizar empréstimo de um livro,
//associando um livro a um usuário, devolver um livro, liberando-o para 
//empréstimo novamente e exibir a lista de livros emprestados no momento.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Livro {
    private String titulo;
    private String autor;
    private boolean emprestado;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.emprestado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void emprestar() {
        emprestado = true;
    }

    public void devolver() {
        emprestado = false;
    }
}

class Usuario {
    private String nome;
    private int id;

    public Usuario(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }
}

class Biblioteca {
    private List<Livro> livros;
    private List<Usuario> usuarios;
    private Map<Livro, Usuario> emprestimos;

    public Biblioteca() {
        livros = new ArrayList<>();
        usuarios = new ArrayList<>();
        emprestimos = new HashMap<>();
    }

    public void registrarLivro(String titulo, String autor) {
        Livro livro = new Livro(titulo, autor);
        livros.add(livro);
        System.out.println("Livro registrado: " + titulo);
    }

    public void registrarUsuario(String nome, int id) {
        Usuario usuario = new Usuario(nome, id);
        usuarios.add(usuario);
        System.out.println("Usuário registrado: " + nome);
    }

    public void realizarEmprestimo(int livroId, int usuarioId) {
        Livro livro = buscarLivroPorId(livroId);
        Usuario usuario = buscarUsuarioPorId(usuarioId);

        if (livro != null && usuario != null && !livro.isEmprestado()) {
            livro.emprestar();
            emprestimos.put(livro, usuario);
            System.out.println("Empréstimo realizado: " + livro.getTitulo() + " para " + usuario.getNome());
        } else {
            System.out.println("Não foi possível realizar o empréstimo.");
        }
    }

    public void devolverLivro(int livroId) {
        Livro livro = buscarLivroPorId(livroId);

        if (livro != null && livro.isEmprestado()) {
            Usuario usuario = emprestimos.get(livro);
            livro.devolver();
            emprestimos.remove(livro);
            System.out.println("Devolução realizada: " + livro.getTitulo() + " de " + usuario.getNome());
        } else {
            System.out.println("Não foi possível realizar a devolução.");
        }
    }

    public void listarLivrosEmprestados() {
        System.out.println("\nLista de Livros Emprestados:");
        for (Map.Entry<Livro, Usuario> entry : emprestimos.entrySet()) {
            Livro livro = entry.getKey();
            Usuario usuario = entry.getValue();
            System.out.println("Livro: " + livro.getTitulo() + " | Autor: " + livro.getAutor() + " | Usuário: "
                    + usuario.getNome());
        }
    }

    private Livro buscarLivroPorId(int livroId) {
        for (Livro livro : livros) {
            if (livroId == livros.indexOf(livro)) {
                return livro;
            }
        }
        return null;
    }

    private Usuario buscarUsuarioPorId(int usuarioId) {
        for (Usuario usuario : usuarios) {
            if (usuarioId == usuarios.indexOf(usuario)) {
                return usuario;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1 - Registrar Livro");
            System.out.println("2 - Registrar Usuário");
            System.out.println("3 - Realizar Empréstimo");
            System.out.println("4 - Devolver Livro");
            System.out.println("5 - Listar Livros Emprestados");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite o título do livro: ");
                    String tituloLivro = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    String autorLivro = scanner.nextLine();
                    biblioteca.registrarLivro(tituloLivro, autorLivro);
                    break;
                case 2:
                    System.out.print("Digite o nome do usuário: ");
                    String nomeUsuario = scanner.nextLine();
                    System.out.print("Digite o número de identificação do usuário: ");
                    int idUsuario = scanner.nextInt();
                    biblioteca.registrarUsuario(nomeUsuario, idUsuario);
                    break;
                case 3:
                    System.out.print("Digite o ID do livro a ser emprestado: ");
                    int livroId = scanner.nextInt();
                    System.out.print("Digite o ID do usuário que está pegando emprestado o livro: ");
                    int usuarioId = scanner.nextInt();
                    biblioteca.realizarEmprestimo(livroId, usuarioId);
                    break;
                case 4:
                    System.out.print("Digite o ID do livro a ser devolvido: ");
                    int livroDevolucaoId = scanner.nextInt();
                    biblioteca.devolverLivro(livroDevolucaoId);
                    break;
                case 5:
                    biblioteca.listarLivrosEmprestados();
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
