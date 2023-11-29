package Server

data class DonoPet (
        var nome: String? = "",
        var linkFoto: String? = "",
        var especie: String? = "",
        var raca: String? = "",
        var idade: Int = 0,
        var cor: String? = "",
        var peso: Float = 0.0f,
        val exames: List<Exame>? = null,
        val idUser: Int = 0,
        val vacinas: List<Vacina>? = null,
)