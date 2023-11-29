package Server;

data class Pet (
        var idPet: Int = 0,
        var nome: String? = "",
        var linkFoto: String? = "",
        var especie: String? = "",
        var raca: String? = "",
        var idade: Int = 0,
        var cor: String? = "",
        var peso: Float = 0.0f,
        val exames: kotlin.collections.List<Exame>? = null,
        var idUser: Int = 0,
        val vacinas: kotlin.collections.List<Vacina>? = null,
)