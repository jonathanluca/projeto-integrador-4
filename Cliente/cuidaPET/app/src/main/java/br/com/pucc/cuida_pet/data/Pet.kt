package br.com.pucc.cuida_pet.data

data class Pet(
    val nome: String,
    val linkFoto: String,
    val especie: String,
    val raca: String,
    val idade: Int,
    val cor: String,
    val peso: Float, //Em mg
    val exames: List<Exame>? = null,
    val idVet: Int,
    val idUser: Int,
    val vacinas: List<Vacina>? = null,
) {
    // Construtor secundário com validações
    constructor(nome: String, especie: String, idade: Int, cor: String, peso: Float, exames: List<Exame>? = null, idVet: Int, idUser: Int, vacinas: List<Vacina>? = null) :
            this(nome, "", especie, "", idade, cor, peso, exames, idVet, idUser, vacinas) {

        val mensagensErro = mutableListOf<String>()

        // Validando o nome
        if (nome.isBlank()) {
            mensagensErro.add("O nome não pode estar em branco.")
        }

        // Validando a idade
        if (idade < 0) {
            mensagensErro.add("A idade não pode ser negativa.")
        }

        // Validando a espécie
        if (especie.isBlank()) {
            mensagensErro.add("A espécie não pode estar em branco.")
        }

        // Validando a cor
        if (cor.isBlank()) {
            mensagensErro.add("A cor não pode estar em branco.")
        }

        // Validando o peso
        if (peso <= 0) {
            mensagensErro.add("O peso deve ser maior que zero.")
        }

        // Validando o ID do veterinário
        if (idVet <= 0) {
            mensagensErro.add("O ID do veterinário deve ser maior que zero.")
        }

        // Validando o ID do usuário
        if (idUser <= 0) {
            mensagensErro.add("O ID do usuário deve ser maior que zero.")
        }

        // Se houver mensagens de erro, lançar exceção
        if (mensagensErro.isNotEmpty()) {
            throw IllegalArgumentException(mensagensErro.joinToString("; "))
        }
    }
}