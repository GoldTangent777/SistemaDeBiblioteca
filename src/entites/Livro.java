package entites;

import java.util.ArrayList;

public class Livro {
    private String titulo;
    private String autor;
    private int anoPubli;
    public boolean validaAno;

    public Livro() {
    }

    public Livro(String titulo, String autor, int anoPubli) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPubli = anoPubli;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPubli() {
        return anoPubli;
    }

    public void setAnoPubli(int anoPubli) {
        if (anoPubli < 0) {
            validaAno = false;
        } else {
            this.anoPubli = anoPubli;
            validaAno = true;
        }
    }

    public String mostrarLivro() {
        String dados = "Dados:\nTitulo: "+titulo+
                "\nAutor: "+autor+
                "\nAno de Publicação: "+anoPubli;

        return dados;
    }
}