package br.com.pucc.cuida_pet.data

import java.sql.Blob

data class Exame(
    val nome: String,
    val resultado: Blob?
)