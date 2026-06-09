# 📚 Sistema de Biblioteca

Sistema de gerenciamento de biblioteca feito em Java para portfólio.

---

## 🚀 O que o sistema faz?

- Cadastra livros e usuários
- Faz empréstimos e devoluções
- Calcula multa por atraso
- Bloqueia usuário que atrasar muito

---

## 🛠️ Tecnologias usadas

| Tecnologia | Pra que serve |
|------------|---------------|
| Java 17 | Linguagem principal |
| BigDecimal | Calcular multa com dinheiro |
| Optional | Evitar erro de "valor nulo" |
| Stream API | Filtrar listas (buscar por autor, tipo, etc.) |
| LocalDate | Trabalhar com datas |
| Enums | Definir tipos fixos (status, tipo de usuário) |

---

## 📁 Estrutura do projeto
src/
├── Enums/
│ ├── Status.java (ATIVO, DEVOLVIDO, ATRASADO)
│ └── TipoUsuario.java (ALUNO, PROFESSOR, DIARIA, CIENTISTA)
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

## 👥 Tipos de usuário

| Tipo | Multa por dia | Prazo | Bloqueia? |
|------|--------------|-------|-----------|
| ALUNO | R$ 3,50 | 20 dias | Sim |
| PROFESSOR | R$ 2,50 | 30 dias | Sim |
| DIARIA | R$ 7,75 | 1 dia | Sim |
| CIENTISTA | R$ 0,00 | 45 dias | Não |

---

## 💰 Como funciona a multa?

1. **Sem atraso** → multa R$ 0
2. **Primeiros 3 dias de atraso** → grátis (cortesia)
3. **A partir do 4º dia** → cobra por dia
4. **Limite máximo** → R$ 100,00
5. **Se atrasar mais de 30 dias** → usuário é bloqueado

---

## 📊 Exemplo de cálculo

| Dias de atraso | Dias que paga | Conta | Multa final |
|---------------|---------------|-------|-------------|
| 2 dias | 0 | R$ 3,50 × 0 | R$ 0 |
| 5 dias | 2 | R$ 3,50 × 2 | R$ 7,00 |
| 40 dias | 37 | R$ 3,50 × 37 = R$ 129,50 | R$ 100 (limitado) |

---

## ▶️ Como rodar

1. Abra o projeto no IntelliJ (ou qualquer IDE)
2. Execute a classe `Main.java`
3. Veja os testes no console

---

## 📋 O que foi testado

| Teste | Resultado |
|-------|-----------|
| Aluno atrasa 40 dias | Multa R$ 100 + Bloqueado ✅ |
| Diária devolve no prazo | Multa R$ 0 + Não bloqueado ✅ |
| Cientista atrasa 5 dias | Multa R$ 0 + Bloqueado ✅ |
| Professor devolve no prazo | Multa R$ 0 + Não bloqueado ✅ |

---

## 👨‍💻 Autor

**Heitor Ivonica Petenati Cardoso**

- 📧 ivonicaheitor@gmail.com
- 💻 [GitHub](https://github.com/Heitorivonica)
- 🔗 [LinkedIn](https://linkedin.com/in/heitor-ivonica)
- 🔗 [Portifolio] (https://portifolioheitorivonica.vercel.app/)

---

**Status:** ✅ Projeto finalizado (versão atual). Novas atualizações previstas com Spring Boot para transformar a aplicação em uma API REST.

*Última atualização: 06/06/2026*
