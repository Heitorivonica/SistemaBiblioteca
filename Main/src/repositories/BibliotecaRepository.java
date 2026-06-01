package repositories;
import models.Emprestimo;
import models.Livros;

import java.time.LocalDate;
import java.util.*;

public class BibliotecaRepository {
    Map<Integer, Livros> livros = new HashMap<>();
    Map<Integer, Emprestimo> emprest = new HashMap<>();


    public void adicionar(Livros livro){
        livros.put(livro.getId(), livro);
    }

    public void adicionarEmprestimo(Emprestimo emprestimo){
        emprest.put(emprestimo.getId(), emprestimo);
    }

    public Livros buscarId(int id){
        return livros.get(id);

    }
    public List<Livros> buscarTodosOsLivros(){
        return new ArrayList<>(livros.values());
    }
    public List<Livros> buscarTodosOsLivrosDisponiveis(){
        List<Livros> disponiveis = new ArrayList<>();
        for(Livros livro : livros.values()){
            if(livro.isDisponivel()){
                disponiveis.add(livro);

            }

        }
        return disponiveis;
    }
     public Optional<Livros> buscarLivroPorIdOptional(int id){
        return Optional.ofNullable(livros.get(id));

    }

}
