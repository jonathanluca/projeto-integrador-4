package br.com.pucc.cuida_pet.data
import java.time.LocalDate

class DonoPet(
    val nome: String,
    val email: String,
    val telefone: String,
    val dataNascimento: LocalDate,
    val senha: String
) {
    init {
        val mensagensErro = mutableListOf<String>()

        // Validando o nome
        if (nome.isBlank()) {
            mensagensErro.add("O nome não pode estar em branco.")
        }

        // Validando o email
        if (!email.matches(Regex("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$"))) {
            mensagensErro.add("O email não é válido.")
        }

        // Validando o telefone
        if (telefone.length < 11) {
            mensagensErro.add("O telefone não é válido.")
        }

        // Validando a data de nascimento
        if (dataNascimento.isAfter(LocalDate.now())) {
            mensagensErro.add("A data de nascimento não pode ser no futuro.")
        }

        // Validando a senha
        if (senha.length < 8) {
            mensagensErro.add("A senha deve ter pelo menos 8 caracteres.")
        }

        // Se houver mensagens de erro, lançar exceção
        if (mensagensErro.isNotEmpty()) {
            throw IllegalArgumentException(mensagensErro.joinToString("; "))
        }
    }

    override fun toString(): String {
        return "DonoPet(nome='$nome', email='$email', telefone='$telefone', dataNascimento=$dataNascimento, senha='$senha')"
    }
}
