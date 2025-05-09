package model;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Emprestimo {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private int id;
    private static int contadorId = 1;
    private Livro livro;
    private String nomeUsuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean ativo;

    public Emprestimo(String nomeUsuario, Livro livro) {
        this.id = contadorId++;
        this.nomeUsuario = nomeUsuario;
        this.livro = livro;
        this.dataEmprestimo = LocalDate.now();
        this.ativo = true;
    }

    //gerando getters and setters automaticos


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo.format(formatter);

    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataDevolucao() {
        return dataDevolucao.format(formatter);
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void devolverLivro() {
        dataDevolucao = LocalDate.now();
        this.ativo = false;
        this.livro.setDisponivel(true);
    }


    //toString automatico
    @Override
    public String toString() {
        return "Emprestimo{" +
                "id=" + id +
                ", livro=" + livro +
                ", nomeUsuario='" + nomeUsuario + '\'' +
                ", dataEmprestimo=" + dataEmprestimo +
                ", dataDevolucao=" + dataDevolucao +
                ", ativo=" + ativo +
                '}';
    }
}
