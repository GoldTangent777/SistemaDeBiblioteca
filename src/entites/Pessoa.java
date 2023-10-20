package entites;

import javax.swing.*;

public class Pessoa {
    private String nome;
    private int idade;
    public boolean validaIdade;

    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade > 0) {
            this.idade = idade;
            validaIdade = true;
        } else {
            JOptionPane.showMessageDialog(null,
                    "ERRO!!\ndigite uma idade válida",
                    "IDADE INVÁLIDA",
                    JOptionPane.ERROR_MESSAGE);
            validaIdade = false;
        }
    }

    public String mostrarDados() {
        String dados = "Dados:\nNome: "+nome+
                "\nIdade: "+idade;

        return dados;
    }
}
