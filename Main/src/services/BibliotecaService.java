package services;
import repositories.BibliotecaRepository;
import Enums.TipoUsuario;
import Enums.Status;
import models.Emprestimo;
import java.time.LocalDate;


public class BibliotecaService {
    private BibliotecaRepository repository;

    public BibliotecaService(BibliotecaRepository repository) {
        this.repository = repository;
    }

    public void emprestarLivro(int livroid, TipoUsuario TipoUsuario, int diasEmprestimo, int usuarioId, int id ) {
        repository.buscarLivroPorIdOptional(livroid).ifPresent(lvro -> {
            boolean livroDisponivel = lvro.isDisponivel();
            if (livroDisponivel == true) {
                LocalDate hoje = LocalDate.now();
                LocalDate dataPrevista = hoje.plusDays(diasEmprestimo);
                Emprestimo emprestimo = new Emprestimo();
                emprestimo.setId(id);
                emprestimo.setUsuarioId(usuarioId);
                emprestimo.setLivroId(livroid);
                emprestimo.setDataEmprestimo(hoje);
                emprestimo.setDataDevolucaoPrevista(dataPrevista);
                emprestimo.setDataDevolucaoReal(null);
                emprestimo.setStatus(Status.ATIVO);
                repository.adicionarEmprestimo(emprestimo);
                lvro.setDisponivel(false);
                System.out.println("Emprestimo realizado com sucesso ");


            } else {
                System.out.println("Livro não disponivel");
            }
        });


        if(repository.buscarLivroPorIdOptional(livroid).isEmpty()){
            System.out.println("Livro não existe");
        }
    }

}
