package models;

import Enums.Status;
import Enums.TipoUsuario;
import java.time.LocalDate;

public class Emprestimo {

    // ========== ATRIBUTOS ==========

    private int id;                      // ID único do empréstimo
    private int livroId;                // ID do livro emprestado
    private Usuario usuario;            // Objeto do usuário (nome, email, tipo, bloqueado)
    private LocalDate dataEmprestimo;   // Data que o livro foi emprestado
    private LocalDate dataDevolucaoPrevista;  // Data limite para devolução
    private LocalDate dataDevolucaoReal;      // Data real da devolução (null se ainda não devolveu)
    private Status status;              // Situação: ATIVO, DEVOLVIDO ou ATRASADO
    private TipoUsuario tipoUsuario;    // Tipo do usuário (para calcular multa)

    // ========== CONSTRUTOR COMPLETO ==========

    // Cria um empréstimo com todos os dados de uma vez
    public Emprestimo(int id, int livroId, Usuario usuario, LocalDate dataEmprestimo,
                      LocalDate dataDevolucaoPrevista, LocalDate dataDevolucaoReal,
                      Status status, TipoUsuario tipoUsuario) {
        this.id = id;
        this.livroId = livroId;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.dataDevolucaoReal = dataDevolucaoReal;
        this.status = status;
        this.tipoUsuario = tipoUsuario;
    }

    // ========== CONSTRUTOR VAZIO ==========
    // Cria um empréstimo vazio para preencher com os setters depois
    public Emprestimo() {

    }

    // ========== GETTERS E SETTERS ==========

    // Retorna o ID do empréstimo
    public int getId() {
        return id;
    }

    // Altera o ID do empréstimo
    public void setId(int id) {
        this.id = id;
    }

    // Retorna o ID do livro emprestado
    public int getLivroId() {
        return livroId;
    }

    // Altera o ID do livro emprestado
    public void setLivroId(int livroId) {
        this.livroId = livroId;
    }

    // Retorna o objeto Usuario completo
    public Usuario getUsuario() {
        return usuario;
    }

    // Altera o objeto Usuario
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // Retorna a data do empréstimo
    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    // Altera a data do empréstimo
    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    // Retorna a data prevista para devolução
    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    // Altera a data prevista para devolução
    public void setDataDevolucaoPrevista(LocalDate dataDevolucaoPrevista) {
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    // Retorna a data real da devolução (pode ser null)
    public LocalDate getDataDevolucaoReal() {
        return dataDevolucaoReal;
    }

    // Altera a data real da devolução
    public void setDataDevolucaoReal(LocalDate dataDevolucaoReal) {
        this.dataDevolucaoReal = dataDevolucaoReal;
    }

    // Retorna o status do empréstimo (ATIVO, DEVOLVIDO, ATRASADO)
    public Status getStatus() {
        return status;
    }

    // Altera o status do empréstimo
    public void setStatus(Status status) {
        this.status = status;
    }

    // Retorna o tipo do usuário (para calcular multa)
    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    // Altera o tipo do usuário
    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}