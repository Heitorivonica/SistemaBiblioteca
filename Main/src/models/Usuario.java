package models;

import Enums.TipoUsuario;

public class Usuario {

    // ========== ATRIBUTOS ==========

    private String name;        // Nome do usuário
    private String email;       // E-mail do usuário
    private TipoUsuario tipo;   // Tipo do usuário (ALUNO, PROFESSOR, VIP, etc.)
    private boolean bloqueado;  // Status de bloqueio (true = bloqueado, false = ativo)

    // ========== CONSTRUTOR ==========

    // Construtor que recebe todos os dados do usuário
    public Usuario(TipoUsuario tipo, String email, String name, boolean bloqueado) {
        this.tipo = tipo;           // Define o tipo (ALUNO, PROFESSOR...)
        this.email = email;         // Define o e-mail
        this.name = name;           // Define o nome
        this.bloqueado = bloqueado; // Define se está bloqueado (true/false)
    }

    // ========== GETTERS E SETTERS ==========

    // Retorna se o usuário está bloqueado
    public boolean isBloqueado() {
        return bloqueado;
    }

    // Altera o status de bloqueio (true = bloquear, false = desbloquear)
    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    // Retorna o tipo do usuário (ALUNO, PROFESSOR, etc.)
    public TipoUsuario getTipo() {
        return tipo;
    }

    // Altera o tipo do usuário
    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    // Retorna o e-mail do usuário
    public String getEmail() {
        return email;
    }

    // Altera o e-mail do usuário
    public void setEmail(String email) {
        this.email = email;
    }

    // Retorna o nome do usuário
    public String getName() {
        return name;
    }

    // Altera o nome do usuário
    public void setName(String name) {
        this.name = name;
    }

    // ========== MÉTODO AUXILIAR ==========

    // Exibe todos os dados do usuário no console
    public void exibirDados() {
        System.out.println(name);      // Mostra o nome
        System.out.println(email);     // Mostra o e-mail
        System.out.println(tipo);      // Mostra o tipo (ex: ALUNO)
    }
}