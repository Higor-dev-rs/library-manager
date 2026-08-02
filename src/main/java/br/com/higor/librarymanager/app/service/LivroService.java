package br.com.higor.librarymanager.app.service;

import br.com.higor.librarymanager.app.model.Livro;
import br.com.higor.librarymanager.app.model.Usuario;

public class LivroService {
    public String realizarEmprestimo(Livro livro){
        if (!livro.estaDisponivel()) {
            return "Erro: O livro " + livro.getTitulo() + " Não possui exemplares disponíveis";
        }

        livro.subtrairExemplar();
        return "Empréstimo realizado com sucesso!";
    }

    public String realizarEmprestimo(Livro livro, Usuario usuario) {
        livro.adicionarExemplares(1);
        usuario.decrementarLivroEmprestado();

        return "Livro devolvido com sucesso!";
    }

    public String gerenciarRemocaoDeExemplares(Livro livro, int quantidadeParaRemover) {
        if (quantidadeParaRemover <= 0) {
            return "Erro: A quantidade para remoção deve ser maior que zero";
        }

        if (livro.getQuantidadeDisponivel() < quantidadeParaRemover) {
            return "Erro: Estoque insuficiente. O livro possui apenas " +
                    livro.getQuantidadeDisponivel() + " exemplares";
        }

        livro.removerExemplares(quantidadeParaRemover);
        return "Exemplares removidos com sucesso";
    }
}

