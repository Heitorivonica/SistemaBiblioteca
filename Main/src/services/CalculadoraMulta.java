package services;

import Enums.TipoUsuario;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculadoraMulta {

    /**
     * Calcula o valor da multa com base no tipo de usuário e dias de atraso
     *
     * Regras:
     * - Multa só se aplica se diasAtraso > 0
     * - Primeiros 3 dias são grátis (cortesia)
     * - Valor máximo da multa: R$ 100,00
     * - Arredondamento para 2 casas decimais
     *
     * @param tipo Tipo do usuário (ALUNO, PROFESSOR, etc.)
     * @param diasAtraso Quantidade de dias de atraso
     * @return Valor da multa calculado
     */
    public BigDecimal calcularMulta(TipoUsuario tipo, int diasAtraso) {

        // ========== REGRA 1: SEM ATRASO ==========
        // Se não houve atraso, multa é ZERO
        if (diasAtraso <= 0) {
            return BigDecimal.ZERO;
        }

        // ========== REGRA 2: COM ATRASO ==========
        else {
            // Aplica cortesia de 3 dias (só paga a partir do 4º dia)
            int diasPagos = diasAtraso - 3;

            // Se o resultado for negativo, ajusta para zero
            if (diasPagos < 0) {
                diasPagos = 0;
            }

            // Pega o valor da multa por dia do tipo de usuário
            // Ex: ALUNO = R$ 2,00 / PROFESSOR = R$ 1,00
            BigDecimal valorMulta = tipo.getMulta();

            // Calcula: valorMulta × diasPagos
            // .setScale(2) = 2 casas decimais
            // HALF_UP = arredondamento padrão (5 ou mais sobe)
            BigDecimal multaTotal = valorMulta
                    .multiply(BigDecimal.valueOf(diasPagos))
                    .setScale(2, RoundingMode.HALF_UP);

            // ========== REGRA 3: LIMITE MÁXIMO ==========
            // Se a multa ultrapassar R$ 100,00, limita a R$ 100,00
            if (multaTotal.compareTo(new BigDecimal("100")) > 0) {
                multaTotal = new BigDecimal("100");
            }

            return multaTotal;
        }
    }
}