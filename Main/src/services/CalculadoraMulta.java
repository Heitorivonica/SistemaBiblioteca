package services;

import Enums.TipoUsuario;


import java.math.BigDecimal;

public class CalculadoraMulta {




    public BigDecimal calcularMulta(TipoUsuario tipo, int diasAtraso){

        BigDecimal valorMulta = tipo.getMulta();
        BigDecimal multaTotal = valorMulta.multiply(BigDecimal.valueOf(diasAtraso));
        return multaTotal;
    }

}
