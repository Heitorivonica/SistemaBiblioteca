package repositories;
import models.Emprestimo;
import models.Livros;

import java.time.LocalDate;
import java.util.*;

public class BibliotecaRepository {

    // Armazena livros em um Map onde a chave é o ID e o valor é o objeto Livro
    Map<Integer, Livros> livros = new HashMap<>();

    // Armazena empréstimos em um Map onde a chave é o ID e o valor é o objeto Emprestimo
    Map<Integer, Emprestimo> emprest = new HashMap<>();

    // Adiciona um livro ao Map (salva na "memória")
    public void adicionar(Livros livro){
        livros.put(livro.getId(), livro);
    }

    // Adiciona um empréstimo ao Map
    public void adicionarEmprestimo(Emprestimo emprestimo){
        emprest.put(emprestimo.getId(), emprestimo);
    }

    // Busca um livro pelo ID - retorna o livro ou null se não existir
    public Livros buscarId(int id){
        return livros.get(id);
    }

    // Retorna uma lista com TODOS os livros (valores do Map)
    public List<Livros> buscarTodosOsLivros(){
        return new ArrayList<>(livros.values());
    }

    // Retorna apenas os livros que estão disponíveis para empréstimo
    // Percorre todos os livros e adiciona na lista os que tem disponivel = true
    public List<Livros> buscarTodosOsLivrosDisponiveis(){
        List<Livros> disponiveis = new ArrayList<>();
        for(Livros livro : livros.values()){
            if(livro.isDisponivel()){
                disponiveis.add(livro);
            }
        }
        return disponiveis;
    }

    // Busca livro por ID usando Optional
    // Optional.ofNullable: se o livro existir, retorna um Optional com o livro
    // Se não existir, retorna um Optional vazio (evita NullPointerException)
    public Optional<Livros> buscarLivroPorIdOptional(int id){
        return Optional.ofNullable(livros.get(id));
    }
}