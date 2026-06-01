package Enums;

import java.math.BigDecimal;

public enum TipoUsuario {
    PROFESSOR(new BigDecimal("2.50")),
    ALUNO( new BigDecimal("3.50")),
    DIARIA( new BigDecimal("7.75")),
    CIENTISTA(new BigDecimal("0"));


    private BigDecimal multa;



    TipoUsuario(BigDecimal multa) {
        this.multa = multa;
    }

    public BigDecimal getMulta() {
        return multa;
    }


}
