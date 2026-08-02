package br.com.higor.librarymanager.app.service;

import br.com.higor.librarymanager.app.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {

    //CADASTRAR NOVO USUÁRIO
    private List<Usuario> listaCadastrados = new ArrayList<>();

    public String cadastrarUsuario(Usuario novoUsuario) {
        if (novoUsuario.getNome().isEmpty() || novoUsuario.getEmail().isEmpty()) {
            return "Erro: Nome e E-mail são obrigatórios para cadastro!";
        }

        for (Usuario usuarioExistente : listaCadastrados) {
            if (usuarioExistente.getMatricula().equals(novoUsuario.getMatricula()) ||
                usuarioExistente.getEmail().equals(novoUsuario.getEmail())){
                return "Erro: Matrícula ou E-mail já cadastrados!";
            }
        }
        listaCadastrados.add(novoUsuario);
        return "Sucesso: Usuario " + novoUsuario.getNome() + " cadastrado com sucesso!";
    }

    //ATUALIZAR USUÁRIO
    public String atualizarUsuario(String matricula,String novoNome, String novoEmail, String novoTelefone) {
        if (novoNome.isEmpty() || novoEmail.isEmpty() || novoTelefone.isEmpty()) {
            return "Erro: Nenhum campo de cadastro pode ficar em branco.";
        }

        for (Usuario usuarioDaLista : listaCadastrados) {
            if (usuarioDaLista.getMatricula().equals(matricula)) {
                usuarioDaLista.setNome(novoNome);
                usuarioDaLista.setEmail(novoEmail);
                usuarioDaLista.setTelefone(novoTelefone);

                return "Sucesso: Os dados do usuário " + usuarioDaLista.getNome() + " foram atualizados";
            }
        }
        return "Erro: Usuário com a matrícula " + matricula + " não foi encontrado.";
    }

    //REMOVER USUÁRIO
    public String removerUsuario(Usuario usuarioAlvo){
        if (usuarioAlvo.getLivrosEmprestadosAtualmente() > 0) {
            return "Erro: Não é possível remover o usuário, pois o usuário tem livros pendentes.";
        }
        listaCadastrados.remove(usuarioAlvo);
        return "Usuário removido com sucesso!";
    }

}
