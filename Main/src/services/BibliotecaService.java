package services;

import models.Usuario;
import repositories.BibliotecaRepository;
import Enums.TipoUsuario;
import Enums.Status;
import models.Emprestimo;
import services.CalculadoraMulta;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BibliotecaService {

    // Repository para acessar os dados (livros, empréstimos)
    private BibliotecaRepository repository;

    // Construtor - recebe o repository por parâmetro (injeção de dependência)
    public BibliotecaService(BibliotecaRepository repository) {
        this.repository = repository;
    }

    // ========== MÉTODO PARA EMPRESTAR LIVRO ==========

    /**
     * Realiza o empréstimo de um livro
     * @param livroid ID do livro a ser emprestado
     * @param tipoUsuario Tipo do usuário (ALUNO, PROFESSOR, etc.)
     * @param diasEmprestimo Quantidade de dias do empréstimo
     * @param usuario Objeto do usuário que está pegando o livro
     * @param id ID do empréstimo (gerado manualmente)
     */
    public void emprestarLivro(int livroid, TipoUsuario tipoUsuario, int diasEmprestimo, Usuario usuario, int id) {

        // Busca o livro pelo ID usando Optional
        repository.buscarLivroPorIdOptional(livroid).ifPresent(lvro -> {

            // Verifica se o livro está disponível
            boolean livroDisponivel = lvro.isDisponivel();

            if (livroDisponivel == true) {
                // Data atual (hoje)
                LocalDate hoje = LocalDate.now();

                // Calcula a data prevista de devolução
                LocalDate dataPrevista = hoje.plusDays(diasEmprestimo);

                // Cria um novo objeto de empréstimo
                Emprestimo emprestimo = new Emprestimo();
                emprestimo.setId(id);                      // ID do empréstimo
                emprestimo.setUsuario(usuario);            // Quem pegou
                emprestimo.setTipoUsuario(tipoUsuario);    // Tipo do usuário
                emprestimo.setLivroId(livroid);            // Qual livro
                emprestimo.setDataEmprestimo(hoje);        // Data que pegou
                emprestimo.setDataDevolucaoPrevista(dataPrevista); // Data para devolver
                emprestimo.setDataDevolucaoReal(null);     // Ainda não devolveu
                emprestimo.setStatus(Status.ATIVO);        // Empréstimo ativo

                // Salva o empréstimo no repositório
                repository.adicionarEmprestimo(emprestimo);

                // Marca o livro como indisponível
                lvro.setDisponivel(false);

                System.out.println("Empréstimo realizado com sucesso");

            } else {
                System.out.println("Livro não disponível");
            }
        });

        // Se o livro não existe, mostra mensagem de erro
        if (repository.buscarLivroPorIdOptional(livroid).isEmpty()) {
            System.out.println("Livro não existe");
        }
    }

    // ========== MÉTODO PARA DEVOLVER LIVRO ==========

    /**
     * Registra a devolução de um livro
     * @param emprestimoId ID do empréstimo a ser devolvido
     * @param dataDevolucao Data real da devolução
     */
    public void devolverLivro(int emprestimoId, LocalDate dataDevolucao) {

        // Busca o empréstimo pelo ID usando Optional
        repository.buscarEmprestimoPorIdOptional(emprestimoId).ifPresent(emprest -> {

            // Registra a data real de devolução
            emprest.setDataDevolucaoReal(dataDevolucao);

            // Pega a data prevista do empréstimo
            LocalDate dataPrevista = emprest.getDataDevolucaoPrevista();

            // Calcula os dias de atraso (diferença entre data prevista e data real)
            long diasAtraso = ChronoUnit.DAYS.between(dataPrevista, dataDevolucao);

            // ========== VERIFICA SITUAÇÃO DO ATRASO ==========

            if (diasAtraso < 0) {
                // Caso 1: Devolveu ANTES do prazo
                diasAtraso = 0;
                emprest.setStatus(Status.DEVOLVIDO);
                System.out.println("Livro devolvido com sucesso sem multas");

            } else if (diasAtraso == 0) {
                // Caso 2: Devolveu NO PRAZO
                emprest.setStatus(Status.DEVOLVIDO);
                System.out.println("Livro devolvido com sucesso sem multas");

            } else {
                // Caso 3: Devolveu COM ATRASO
                emprest.setStatus(Status.ATRASADO);
                System.out.println("Livro devolvido com atraso com multas");

                // BLOQUEIA o usuário por causa do atraso
                emprest.getUsuario().setBloqueado(true);
            }

            // ========== CALCULA A MULTA ==========

            CalculadoraMulta calcularMulta = new CalculadoraMulta();
            BigDecimal multa = calcularMulta.calcularMulta(emprest.getTipoUsuario(), (int) diasAtraso);
            System.out.println("Valor da multa: R$ " + multa);

            // ========== LIBERA O LIVRO ==========

            // Pega o ID do livro que foi emprestado
            int livroEncontrado = emprest.getLivroId();

            // Busca o livro e libera ele (disponível novamente)
            repository.buscarLivroPorIdOptional(livroEncontrado).ifPresent(livros -> {
                livros.setDisponivel(true);






                });
        });

        }

    }
