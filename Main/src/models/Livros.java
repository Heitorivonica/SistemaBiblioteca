package models;

public class Livros {

    private String name;
    private String autor;
    private String tipo;
    private int anoDaPublicacao;
    private int id;
    private boolean disponivel;


    public Livros(int id, String name, String autor, String tipo, int anoDaPublicação, boolean disponivel){
        this.id = id;
        this.name = name;
        this.autor = autor;
        this.tipo = tipo;
        this.anoDaPublicacao = anoDaPublicacao;
        this.disponivel = disponivel;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnoDaPublicacao() {
        return anoDaPublicacao;
    }

    public void setAnoDaPublicacao(int anoDaPublicacao) {
        this.anoDaPublicacao = anoDaPublicacao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
