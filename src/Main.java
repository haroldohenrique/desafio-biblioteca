import model.Autor;
import model.Biblioteca;
import model.Emprestimo;
import model.Livro;


import java.sql.SQLOutput;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner input = new Scanner(System.in);

        //preset de livros e autores


        //Adicionando autores na biblioteca
        Autor autor1 = new Autor(1, "Haroldo Henrique das Neves", new Date(2000, 3, 4));
        Autor autor2 = new Autor(2, "Maria Ivania Martins dos Santos", new Date(1967, 6, 26));
        Autor autor3 = new Autor(3,"Tayssa Quaresma",new Date(2005,8,22));

        biblioteca.adicionarAutor(autor1);
        biblioteca.adicionarAutor(autor2);

        //Adicionando livros na biblioteca
        Livro livro1 = new Livro("The Witcher III", autor1);
        Livro livro2 = new Livro("Liberalismo é o futuro?!", autor1);
        Livro livro3 = new Livro("Viva a privatização!", autor2);

        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.adicionarLivro(livro3);

        // Loop para a interação com o usuário
        while (true) {
            System.out.println("Menu de interação BIBLIOTECA \n1 - Listar livros\n2 - Listar livros emprestados\n3 - Adicionar livros\n4 - Encerrar programa");
            String resposta = input.nextLine();

            if (resposta.equals("1")) {
                List<Livro> livrosDisponiveis = biblioteca.mostrarLivrosDisponiveis();

                if (livrosDisponiveis.isEmpty()) {
                    System.out.println("Não há livros disponíveis no momento.\n------------------------");
                } else {
                    System.out.println("Livros disponíveis:");
                    for (Livro livro : livrosDisponiveis) {
                        System.out.println(livro.getId() + ": " + livro.getTitulo());
                    }

                    System.out.println("Digite o ID do livro que você deseja emprestar:");
                    int idLivro = input.nextInt();
                    input.nextLine();

                    Livro livroSelecionado = biblioteca.buscarLivroPorId(idLivro);

                    if (livroSelecionado != null && livroSelecionado.isDisponivel()) {
                        System.out.println("Digite seu nome:");
                        String nomeUsuario = input.nextLine();

                        biblioteca.emprestarLivro(livroSelecionado, nomeUsuario);
                        System.out.println("O livro " + livroSelecionado.getTitulo() + " foi emprestado para " + nomeUsuario + "\n------------------------");
                    } else {
                        System.out.println("Livro não encontrado ou não disponível para empréstimo.\n------------------------");
                    }
                }
            } else if (resposta.equals("2")) {
                if (biblioteca.mostrarEmprestimos().isEmpty()) {
                    System.out.println("Não existe nenhum livro emprestado");

                } else {
                    System.out.println("Lista de emprestimos: ");
                    for (Emprestimo emprestimo : biblioteca.mostrarEmprestimos()) {
                        System.out.println("ID: " + emprestimo.getId());
                        System.out.println("Nome do livro: " + emprestimo.getLivro().getTitulo() + "\nLocator: " + emprestimo.getNomeUsuario());
                        System.out.println("Data do emprestimo: " + emprestimo.getDataEmprestimo() + "\n------------------------");
                    }
                    do {
                        System.out.println("Deseja devolver algum livro?\n1 - Sim\n2 - Não");
                        resposta = input.nextLine();
                        if (resposta.equals("1")) {
                            System.out.println("Digite o id do livro a ser devolvido: ");
                            int idLivro = input.nextInt();
                            input.nextLine();
                            biblioteca.devolverLivro(idLivro);
                            System.out.println("Livro devolvido");
                        } else if (resposta.equals("2")) {
                            System.out.println("Voltando ao menu");
                            break;
                        } else {
                            System.out.println("Digite somente 1 ou 2");
                        }
                    } while (!biblioteca.mostrarEmprestimos().isEmpty());

                }

            } else if (resposta.equals("3")) {
                System.out.println("Digite o nome do livro que deseja adicionar: ");
                String nomeLivro = input.nextLine();

                for (Autor autor : biblioteca.mostrarAutores()) {
                    System.out.println(autor.getId() + " - " + autor.getNome());
                }


                while (true) {
                    System.out.println("Digite o ID do autor: ");
                    int idAutor = input.nextInt();
                    input.nextLine();
                    if (biblioteca.buscaAutorPorId(idAutor) == null) {
                        System.out.println("Autor não encontrado");
                    } else {
                        Livro novoLivro = new Livro(nomeLivro, biblioteca.buscaAutorPorId(idAutor));
                        biblioteca.adicionarLivro(novoLivro);
                        System.out.println("Livro adicionado com sucesso");
                        break;
                    }
                }

            } else if (resposta.equals("4")) {
                System.out.println("Encerrando menu");
                input.close();
                break;
            } else {
                System.out.println("Resposta inválida. Por favor, responda com 'sim' ou 'não'.");
            }

        }
        input.close();

    }
}

