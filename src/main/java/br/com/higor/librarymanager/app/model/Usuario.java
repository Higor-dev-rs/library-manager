package br.com.higor.librarymanager.app.model;

public class Usuario {
    private String matricula;
    private String nome;
    private String email;
    private String telefone;
    private int livrosEmprestadosAtualmente;

    public Usuario(String matricula, String nome,
            String email, String telefone) {
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.livrosEmprestadosAtualmente = 0;
    }

    public void incrementarLivroEmprestado() {
        this.livrosEmprestadosAtualmente++;
    }

    public void decrementarLivroEmprestado() {
        if (this.livrosEmprestadosAtualmente > 0) {
            this.livrosEmprestadosAtualmente--;
        }
    }

    public String getMatricula () {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getLivrosEmprestadosAtualmente() {
        return livrosEmprestadosAtualmente;
    }
}
