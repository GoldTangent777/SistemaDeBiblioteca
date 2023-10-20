package application;

import entites.Editora;
import entites.Livro;
import entites.Pessoa;

import javax.swing.*;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        String titulo = "BIBLIOTECA";
        int respostaUsusario, respostaLivro;

        do {
            ArrayList<Livro> livros = new ArrayList<>();
            Livro l;
            Editora e;
            JOptionPane.showMessageDialog(null,
                    "Bem Vindo á Bibilioteca!!",
                    titulo,
                    JOptionPane.PLAIN_MESSAGE);

            //Criação da Pessoa
            Pessoa p = new Pessoa();
            String nomeUsuario = JOptionPane.showInputDialog(null,
                    "Cadastro do usuário:\nDigite o nome:",
                    "CADASTRO USUÁRIO",
                    JOptionPane.PLAIN_MESSAGE);
            p.setNome(nomeUsuario);

            do {
                String idade = JOptionPane.showInputDialog(null,
                        "Digite a idade do usário:",
                        "CADASTRO USUÁRIO",
                        JOptionPane.PLAIN_MESSAGE);
                Integer idadeUsuario = Integer.parseInt(idade);
                p.setIdade(idadeUsuario);
            } while (p.validaIdade == false);

            JOptionPane.showMessageDialog(null,
                    p.mostrarDados(),
                    "DADOS",
                    JOptionPane.PLAIN_MESSAGE);

            //Criação do Livro
            do {
                Integer anoLivro;
                String tituloLivro = JOptionPane.showInputDialog(null,
                        "Cadastro do livro\nDigite o nome do título:",
                        "CADASTRO LIVRO",
                        JOptionPane.PLAIN_MESSAGE);

                String autorLivro = JOptionPane.showInputDialog(null,
                        "Digite o Autor do Livro:",
                        "CADASTRO LIVRO",
                        JOptionPane.PLAIN_MESSAGE);

                String ano = JOptionPane.showInputDialog(null,
                        "Digite o ano do Livro:",
                        "CADASTRO DO LIVRO",
                        JOptionPane.PLAIN_MESSAGE);
                anoLivro = Integer.parseInt(ano);
                l = new Livro(tituloLivro, autorLivro, anoLivro);

                //Criação da Editora
                String nomeEditora = JOptionPane.showInputDialog(null,
                        "Cadastro da Editora\nDigite o nome da Editora do livro: ",
                        "CADASTRO DA EDITORA",
                        JOptionPane.PLAIN_MESSAGE);
                e = new Editora(nomeEditora);

                Object[] opcoes = {"Emprestar", "Devolver"};

                Object escolhaPegar = JOptionPane.showInputDialog(null,
                        "Deseja emprestar?",
                        "EMPRESTAR?", JOptionPane.PLAIN_MESSAGE,
                        null,
                        opcoes,
                        opcoes[0]);

                if (escolhaPegar == opcoes[0]) {
                    livros.add(l);
                } else if (escolhaPegar == opcoes[1]) {
                    JOptionPane.showMessageDialog(null,
                            "Não foi pego nenhum livro!",
                            "NENHUM LIVRO PEGO",
                            JOptionPane.PLAIN_MESSAGE);
                }

                respostaLivro = JOptionPane.showConfirmDialog(null,
                        "Deseja Colocar mais alugm livro?",
                        "ESCOLHAS?",
                        JOptionPane.YES_NO_OPTION);
            } while (respostaLivro == JOptionPane.YES_OPTION);

            for (Livro dados : livros) {
                JOptionPane.showMessageDialog(null,
                        "dados Livro: " + dados.mostrarLivro());
            }

            int escolhaDevolver = JOptionPane.showConfirmDialog(null,
                    "Deseja devolver algum livro?",
                    "Devolver?",
                    JOptionPane.YES_NO_OPTION);

            //Escolha da posição de qual livro deseja remover
            if (escolhaDevolver == JOptionPane.YES_OPTION) {
                String num = JOptionPane.showInputDialog(null,
                        "Digite a ordem do livro que foi criada: ",
                        "ORDEM LIVRO",
                        JOptionPane.PLAIN_MESSAGE);
                Integer posLivro = Integer.parseInt(num) - 1;

                if (posLivro >= 0 && posLivro < livros.size()) {
                    livros.remove((int) posLivro);  // Remove o livro da lista
                    JOptionPane.showMessageDialog(null,
                            "Livro removido!",
                            "REMOÇÃO CONCLUÍDA",
                            JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Ordem do livro inválida!",
                            "ERRO",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "Nenhum livro foi devolvido!!",
                        "NENHUM LIVRO DEVOLVIDO",
                        JOptionPane.PLAIN_MESSAGE);
            }

            JOptionPane.showMessageDialog(null,
                    "Dados atualizados!",
                    "ATUALIZAÇÃO",
                    JOptionPane.PLAIN_MESSAGE);

            for (Livro liv : livros) {
                JOptionPane.showMessageDialog(null,
                        "dados: " + liv.mostrarLivro(),
                        "DADOS",
                        JOptionPane.PLAIN_MESSAGE);
            }
            respostaUsusario = JOptionPane.showConfirmDialog(null,
                    "Deseja Repetir?",
                    "REPETIR?",
                    JOptionPane.YES_NO_OPTION);
        } while (respostaUsusario == JOptionPane.YES_OPTION);
    }
}