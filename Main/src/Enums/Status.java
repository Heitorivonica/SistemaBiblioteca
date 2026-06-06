package Enums;

// Enum que define os possíveis status de um empréstimo
public enum Status {

    // ========== CONSTANTES DO ENUM ==========

    ATIVO,      // Empréstimo ativo (livro não foi devolvido ainda)
    DEVOLVIDO,  // Livro foi devolvido no prazo ou antes
    ATRASADO;   // Livro foi devolvido depois do prazo (gerou multa)
}