package models;

public class Livros {

    // ========== ATRIBUTOS ==========

    private String name;              // Nome/título do livro
    private String autor;            // Nome do autor
    private String tipo;             // Gênero do livro (Ficção, Ciência, etc.)
    private int anoDaPublicacao;     // Ano que o livro foi publicado
    private int id;                  // Identificador único do livro
    private boolean disponivel;      // Status: true = disponível, false = emprestado

    // ========== CONSTRUTOR ==========

    // Construtor que recebe todos os dados do livro
    public Livros(int id, String name, String autor, String tipo, int anoDaPublicacao, boolean disponivel) {
        this.id = id;                  // Define o ID do livro
        this.name = name;              // Define o título
        this.autor = autor;            // Define o autor
        this.tipo = tipo;              // Define o gênero
        this.anoDaPublicacao = anoDaPublicacao;  // Define o ano
        this.disponivel = disponivel;  // Define se está disponível
    }

    // ========== GETTERS E SETTERS ==========

    // Retorna se o livro está disponível (true = sim, false = não)
    public boolean isDisponivel() {
        return disponivel;
    }

    // Altera o status de disponibilidade do livro
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    // Retorna o ID do livro
    public int getId() {
        return id;
    }

    // Altera o ID do livro
    public void setId(int id) {
        this.id = id;
    }

    // Retorna o gênero/tipo do livro
    public String getTipo() {
        return tipo;
    }

    // Altera o gênero/tipo do livro
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Retorna o ano de publicação
    public int getAnoDaPublicacao() {
        return anoDaPublicacao;
    }

    // Altera o ano de publicação
    public void setAnoDaPublicacao(int anoDaPublicacao) {
        this.anoDaPublicacao = anoDaPublicacao;
    }

    // Retorna o nome do autor
    public String getAutor() {
        return autor;
    }

    // Altera o autor do livro
    public void setAutor(String autor) {
        this.autor = autor;
    }

    // Retorna o título do livro
    public String getName() {
        return name;
    }

    // Altera o título do livro
    public void setName(String name) {
        this.name = name;
    }
}