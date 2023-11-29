package Server

import java.time.LocalDate

data class Vacina(
    val nome: String,
    val tipo: String,
    val data: LocalDate,
    val proximaDose: LocalDate? = null
)