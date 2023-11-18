package br.com.pucc.cuida_pet.data

import java.time.LocalDate

data class Vacina(
    val nome: String,
    val tipo: String,
    val data: LocalDate,
    val proximaDose: LocalDate? = null
) {
    init {
        val mensagensErro = mutableListOf<String>()

        // Validando o nome
        if (nome.isBlank()) {
            mensagensErro.add("O nome da vacina não pode estar em branco.")
        }

        // Validando o tipo
        if (tipo.isBlank()) {
            mensagensErro.add("O tipo da vacina não pode estar em branco.")
        }

        // Validando a data
        if (data.isAfter(LocalDate.now())) {
            mensagensErro.add("A data da vacinação não pode ser no futuro.")
        }

        // Validando a próxima dose
        if (proximaDose != null && proximaDose.isBefore(data)) {
            mensagensErro.add("A próxima dose não pode ser anterior à data da vacinação.")
        }

        // Se houver mensagens de erro, lançar exceção
        if (mensagensErro.isNotEmpty()) {
            throw IllegalArgumentException(mensagensErro.joinToString("; "))
        }
    }
}
