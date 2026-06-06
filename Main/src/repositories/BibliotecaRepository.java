package repositories;

import models.Emprestimo;
import models.Livros;
import models.Usuario;
import Enums.Status;
import java.util.stream.Collectors;
import java.util.*;

public class BibliotecaRepository {

    // ========== BANCO DE DADOS EM MEMÓRIA ==========

    // Mapa que guarda livros (chave = ID do livro, valor = objeto Livro)
    Map<Integer, Livros> livros = new HashMap<>();

    // Mapa que guarda empréstimos (chave = ID do empréstimo, valor = objeto Emprestimo)
    Map<Integer, Emprestimo> emprest = new HashMap<>();

    // ========== MÉTODOS PARA ADICIONAR ==========

    // Adiciona um livro ao mapa
    public void adicionar(Livros livro) {
        livros.put(livro.getId(), livro);
    }

    // Adiciona um empréstimo ao mapa
    public void adicionarEmprestimo(Emprestimo emprestimo) {
        emprest.put(emprestimo.getId(), emprestimo);
    }

    // ========== BUSCAS SIMPLES ==========

    // Busca um livro pelo ID (retorna null se não existir)
    public Livros buscarId(int id) {
        return livros.get(id);
    }

    // Retorna todos os livros (valores do mapa)
    public List<Livros> buscarTodosOsLivros() {
        return new ArrayList<>(livros.values());
    }

    // ========== BUSCAS COM STREAM ==========

    // Retorna apenas os livros disponíveis para empréstimo
    // Usa Stream para filtrar os livros onde isDisponivel() é true
    public List<Livros> buscarTodosOsLivrosDisponiveis() {
        return livros.values().stream()
                .filter(Livros::isDisponivel)      // só livros disponíveis
                .collect(Collectors.toList());      // junta em uma lista
    }

    // ========== BUSCAS COM OPTIONAL ==========

    // Busca livro por ID usando Optional (evita NullPointerException)
    // Se o livro existir → Optional com o livro
    // Se não existir → Optional vazio
    public Optional<Livros> buscarLivroPorIdOptional(int id) {
        return Optional.ofNullable(livros.get(id));
    }

    // Busca empréstimo por ID usando Optional
    public Optional<Emprestimo> buscarEmprestimoPorIdOptional(int id) {
        return Optional.ofNullable(emprest.get(id));
    }

    // ========== LISTAGENS COM FILTRO (STREAM) ==========

    // Lista todos os empréstimos de um usuário específico
    // Filtra comparando o objeto Usuario inteiro (==)
    public List<Emprestimo> buscarEmprestimosPorUsuario(Usuario usuario) {
        return emprest.values().stream()
                .filter(emprestimo -> emprestimo.getUsuario() == usuario)
                .collect(Collectors.toList());
    }

    // Lista todos os empréstimos que estão ATIVOS (não foram devolvidos)
    public List<Emprestimo> buscarEmprestimosAtivos() {
        return emprest.values().stream()
                .filter(emprestimo -> emprestimo.getStatus() == Status.ATIVO)
                .collect(Collectors.toList());
    }

    // Lista todos os livros de um autor específico
    // equalsIgnoreCase = ignora diferenças entre maiúsculas/minúsculas
    public List<Livros> buscarLivrosPorAutor(String autor) {
        return livros.values().stream()
                .filter(livro -> livro.getAutor().equalsIgnoreCase(autor))
                .collect(Collectors.toList());
    }

    // Lista todos os livros de um tipo/gênero específico
    // equalsIgnoreCase = ignora diferenças entre maiúsculas/minúsculas
    public List<Livros> buscarLivrosPorTipo(String tipo) {
        return livros.values().stream()
                .filter(livro -> livro.getTipo().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
    }
}