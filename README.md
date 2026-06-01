# 📚 Biblioteca Manager

> 🚧 **EM DESENVOLVIMENTO** – Sistema de gerenciamento de biblioteca em Java

## 📌 Sobre o Projeto

Sistema de biblioteca desenvolvido em Java com foco em boas práticas e conceitos modernos da linguagem. O projeto serve como portfólio para demonstrar conhecimentos em POO, Collections, BigDecimal, Optional, Enums e Stream API.

## ✅ O que já está implementado

### Core do Sistema
- [x] Estrutura de pacotes organizada (models, enums, repositories, services)
- [x] Classe `Livros` (atributos, getters, setters)
- [x] Classe `Usuario` (atributos, getters, setters)
- [x] Classe `Emprestimo` (atributos, getters, setters)
- [x] Enum `Status` (ATIVO, ENTREGUE, ATRASADO)
- [x] Enum `TipoUsuario` com valores de multa por tipo

### Repository
- [x] `BibliotecaRepository` com Map para armazenamento
- [x] Método `adicionar` (livros e empréstimos)
- [x] Método `buscarId`
- [x] Método `buscarTodosOsLivros`
- [x] Método `buscarTodosOsLivrosDisponiveis`
- [x] Método `buscarLivroPorIdOptional` (com Optional)

### Service
- [x] `BibliotecaService` com injeção do repository
- [x] Método `emprestarLivro` (com Optional.ifPresent)
- [x] `CalculadoraMulta` com cálculo base usando BigDecimal

### Testes
- [x] `Main.java` com testes de criação de usuários
- [x] Testes de cálculo de multa para diferentes tipos

---

## ⏳ Pendências por Etapa

### 🔴 PRIORIDADE 1 - Stream API
| Tarefa | Arquivo | Descrição |
|--------|---------|-----------|
| [ ] | `BibliotecaRepository.java` | Substituir `for` por Stream em `buscarTodosOsLivrosDisponiveis` |
| [ ] | `BibliotecaRepository.java` | Criar `buscarLivrosPorAutor` usando Stream filter |
| [ ] | `BibliotecaRepository.java` | Criar `buscarLivrosPorTipo` usando Stream filter |
| [ ] | `BibliotecaRepository.java` | Criar `buscarEmprestimosAtivos` usando Stream filter |

### 🟡 PRIORIDADE 2 - Regras de Negócio
| Tarefa | Arquivo | Descrição |
|--------|---------|-----------|
| [ ] | `CalculadoraMulta.java` | Adicionar constante `LIMITE_MAXIMO_MULTA` |
| [ ] | `CalculadoraMulta.java` | Adicionar constante `DIAS_CORTESIA` |
| [ ] | `CalculadoraMulta.java` | Implementar verificação de dias grátis |
| [ ] | `CalculadoraMulta.java` | Aplicar limite máximo na multa |
| [ ] | `CalculadoraMulta.java` | Usar `RoundingMode.HALF_UP` para 2 casas decimais |
| [ ] | `Status.java` | Renomear `ENTREGUE` para `DEVOLVIDO` (mais claro) |

### 🟢 PRIORIDADE 3 - Novos Métodos no Service
| Tarefa | Arquivo | Descrição |
|--------|---------|-----------|
| [ ] | `BibliotecaService.java` | Criar `devolverLivro(int emprestimoId, LocalDate dataDevolucao)` |
| [ ] | `BibliotecaService.java` | Calcular dias de atraso na devolução |
| [ ] | `BibliotecaService.java` | Atualizar status do empréstimo |
| [ ] | `BibliotecaService.java` | Liberar livro (setDisponivel true) |
| [ ] | `BibliotecaService.java` | Chamar CalculadoraMulta para gerar multa |

### 🔵 PRIORIDADE 4 - Repository (Métodos Faltantes)
| Tarefa | Arquivo | Descrição |
|--------|---------|-----------|
| [ ] | `BibliotecaRepository.java` | Criar `buscarEmprestimoPorId` (com Optional) |
| [ ] | `BibliotecaRepository.java` | Criar `buscarEmprestimosPorUsuario` |
| [ ] | `BibliotecaRepository.java` | Criar `buscarEmprestimosAtivosPorUsuario` |
| [ ] | `BibliotecaRepository.java` | Criar `atualizarEmprestimo` |

### 🟣 PRIORIDADE 5 - Testes na Main
| Tarefa | Arquivo | Descrição |
|--------|---------|-----------|
| [ ] | `Main.java` | Testar `emprestarLivro` com diferentes tipos de usuário |
| [ ] | `Main.java` | Testar `devolverLivro` com dias de atraso |
| [ ] | `Main.java` | Exibir multa calculada na devolução |
| [ ] | `Main.java` | Testar Stream (buscar livros por autor) |
| [ ] | `Main.java` | Listar empréstimos ativos |

---

## 📊 Resumo do Progresso

| Categoria | Concluído | Pendente |
|-----------|-----------|----------|
| Models | 100% | - |
| Enums | 90% | Ajustar Status |
| Repository | 60% | 4 métodos + Streams |
| Service | 40% | Devolução + melhorias |
| CalculadoraMulta | 30% | Limites + regras |
| Main/Testes | 30% | Mais cenários |
| Stream API | 0% | 4 métodos |

---

## 🎯 Próximas Ações Sugeridas

### Imediatas (hoje)
1. Implementar Stream em `buscarTodosOsLivrosDisponiveis`
2. Criar `buscarLivrosPorAutor` com Stream
3. Ajustar `Status.ENTREGUE` para `Status.DEVOLVIDO`

### Em seguida
4. Criar método `devolverLivro` no Service
5. Melhorar `CalculadoraMulta` com limites
6. Testar fluxo completo (emprestar → devolver → multa)

---

## 🛠️ Tecnologias Utilizadas

- Java 17+
- BigDecimal (valores financeiros)
- Optional (evitar NullPointer)
- Stream API (em implementação)
- Enums com atributos
- Collections (Map, List)
- LocalDate API

---

## 📁 Estrutura do Projeto
src/
├── Enums/
│ ├── Status.java
│ └── TipoUsuario.java
├── models/
│ ├── Emprestimo.java
│ ├── Livros.java
│ └── Usuario.java
├── repositories/
│ └── BibliotecaRepository.java
├── services/
│ ├── BibliotecaService.java
│ └── CalculadoraMulta.java
└── Main.java

---

**📌 Última atualização:** 01/06/2026

**Status:** 🚧 Código base concluído. Implementando Stream API e regras de negócio.
