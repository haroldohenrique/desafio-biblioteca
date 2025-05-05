package model;

import java.util.Date;

public class Emprestimo {
    private int id;
    private static int contadorId = 1;
    private Livro livro;
    private String nomeUsuario;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private boolean ativo;

    public Emprestimo(String nomeUsuario, Livro livro) {
        this.id = contadorId++;
        this.nomeUsuario = nomeUsuario;
        this.livro = livro;
        this.dataEmprestimo = new Date();
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

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void devolverLivro(){
        dataDevolucao = new Date();
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
