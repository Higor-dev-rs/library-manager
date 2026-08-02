package br.com.higor.librarymanager.app.model;

public class Livro {
    private String codigo;
    private String titulo;
    private String autor;
    private String editora;
    private int anoPublicacao;
    private int quantidadeDisponivel;

    public Livro (String codigo, String titulo, String autor, String editora,
           int anoPublicacao, int quantidadeDisponivel){
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public boolean estaDisponivel() {
        return quantidadeDisponivel > 0;
    }

    public boolean subtrairExemplar() {
        if (quantidadeDisponivel <= 0) {
            return false;
        }
        quantidadeDisponivel--;
        return true;
    }

    public void adicionarExemplares(int quantidade) {
        if (quantidade > 0) {
            this.quantidadeDisponivel += quantidade;
        }
    }

    public boolean removerExemplares (int quantidade) {
        if (quantidade <= 0 || quantidade > quantidadeDisponivel) {
            return false;
        }
        quantidadeDisponivel -= quantidade;
        return true;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String nomeLivro) {
        this.titulo = nomeLivro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String nomeAutor) {
        this.autor = nomeAutor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }
}
