package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public List<Livro> mostrarLivros() {
        return livros;
    }

    public List<Livro> mostrarLivrosDisponiveis() {
        List<Livro> livrosDisponiveis = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                livrosDisponiveis.add(livro);
            }
        }
        return livrosDisponiveis;
    }

    public Livro buscarLivroPorId(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                return livro;
            }
        }
        return null;
    }

    public Livro atualizaLivro(int id, String novoTitulo) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                livro.setTitulo(novoTitulo);
                break;
            }
        }
        return null;
    }

    public void removeLivro(int id) {
        livros.removeIf(livro -> livro.getId() == id);
    }

    public void adicionarAutor(Autor autor) {
        autores.add(autor);
    }

    public List<Autor> mostrarAutores() {
        return autores;
    }

    public Autor atualizaAutor(int id, String novoNome) {
        for (Autor autor : autores) {
            if (autor.getId() == id) {
                autor.setNome(novoNome);
                break;
            }
        }
        return null;
    }

    public void removeAutor(int id) {
        autores.removeIf(autor -> autor.getId() == id);
    }

    public void emprestarLivro(Livro livro, String nomeUsuario) {
        if (livro.isDisponivel()) {
            Emprestimo livroEmprestado = new Emprestimo(nomeUsuario, livro);
            emprestimos.add(livroEmprestado);
            livro.setDisponivel(false);
        } else {
            System.out.println("Livro não encontrado para emprestar");
        }
    }

    public void devolverLivro(int idDoLivroEmprestado) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getId() == idDoLivroEmprestado && emprestimo.isAtivo()) {
                emprestimo.devolverLivro();
                emprestimos.remove(emprestimo);
                break;
            }
        }
    }

    public List<Emprestimo> mostrarEmprestimos(){
        return emprestimos;
    }
}
