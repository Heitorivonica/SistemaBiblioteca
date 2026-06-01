# 📚 Biblioteca Manager

## ✅ Status do Projeto — Em Desenvolvimento

## 🏗️ Estrutura implementada

A base do projeto foi concluída e já está no repositório. A estrutura de pacotes está organizada da seguinte forma:
src/
├── Enums/
│   ├── Status.java        ✅ Criado
│   └── TipoUsuario.java   ✅ Criado
├── models/
│   ├── Emprestimo.java    ✅ Criado
│   ├── Livros.java        ✅ Criado
│   └── Usuario.java       ✅ Criado
├── repositories/
│   └── BibliotecaRepository.java  ✅ Criado
├── services/
│   ├── BibliotecaService.java     ✅ Criado
│   └── CalculadoraMulta.java      ✅ Criado
└── Main.java              ✅ Criado
## 📚 Conceitos já aplicados

| Conceito | Onde foi usado |
|----------|----------------|
| **Enum** | `Status` e `TipoUsuario` |
| **BigDecimal** | `CalculadoraMulta` — cálculo de multas por atraso |
| **Optional** | `BibliotecaRepository` — buscas seguras |
| **Stream API** | `BibliotecaService` — filtros e relatórios |
| **Generics** | Código reutilizável nos repositórios |
| **Lambda** | Regras de negócio nos services |

## 🚧 O que falta finalizar

- [ ] Implementar a lógica completa de empréstimo e devolução
- [ ] Validações de regras de negócio (ex: devolução por usuário)
- [ ] Relatórios com Stream API (livros mais emprestados, usuários em atraso)
- [ ] Testes unitários das classes de serviço
- [ ] Tratamento de exceções personalizadas
- [ ] Documentação Javadoc nas classes principais
- [ ] Refinar o `Main.java` com um menu interativo via console

## 📌 Fase atual
**Desenvolvimento ativo** — estrutura criada, lógica de negócio em construção.
