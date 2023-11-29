package Server

import java.time.LocalDate;
data class DonoPet (
    val nome: String,
    val email: String,
    val telefone: String,
    val dataNascimento: LocalDate,
    val senha: String
)