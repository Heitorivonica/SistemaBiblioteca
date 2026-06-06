package Enums;

import java.math.BigDecimal;

// Enum que define os tipos de usuário da biblioteca
// Cada tipo tem um valor de multa por dia de atraso
public enum TipoUsuario {

    // ========== CONSTANTES DO ENUM ==========

    PROFESSOR(new BigDecimal("2.50")),   // Professor paga R$ 2,50 por dia de atraso
    ALUNO(new BigDecimal("3.50")),       // Aluno paga R$ 3,50 por dia de atraso
    DIARIA(new BigDecimal("7.75")),      // Diária paga R$ 7,75 por dia de atraso
    CIENTISTA(new BigDecimal("0"));      // Cientista NÃO paga multa (R$ 0,00)

    // ========== ATRIBUTO ==========

    private BigDecimal multa;  // Valor da multa por dia para este tipo de usuário

    // ========== CONSTRUTOR ==========
    // Cada constante do enum recebe um valor de multa
    TipoUsuario(BigDecimal multa) {
        this.multa = multa;
    }

    // ========== GETTER ==========
    // Retorna o valor da multa por dia
    public BigDecimal getMulta() {
        return multa;
    }
}