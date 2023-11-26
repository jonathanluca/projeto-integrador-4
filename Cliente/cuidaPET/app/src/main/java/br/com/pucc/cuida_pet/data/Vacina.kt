package br.com.pucc.cuida_pet.data

import android.os.Parcelable
import java.time.LocalDate
import android.os.Parcel

data class Vacina(
    val nome: String,
    val tipo: String,
    val data: LocalDate,
    val proximaDose: LocalDate? = null
) :Parcelable {
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
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        // Converte o long de volta para LocalDate
        LocalDate.ofEpochDay(parcel.readLong()),
        parcel.readLong().let { if (it == -1L) null else LocalDate.ofEpochDay(it) }
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nome)
        parcel.writeString(tipo)
        // Converte LocalDate para long antes de escrever no Parcel
        parcel.writeLong(data.toEpochDay())
        // Se proximaDose for nula, escreva -1L no Parcel, caso contrário, escreva o valor em EpochDay
        parcel.writeLong(proximaDose?.toEpochDay() ?: -1L)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Vacina> {
        override fun createFromParcel(parcel: Parcel): Vacina {
            return Vacina(parcel)
        }

        override fun newArray(size: Int): Array<Vacina?> {
            return arrayOfNulls(size)
        }
    }

}
