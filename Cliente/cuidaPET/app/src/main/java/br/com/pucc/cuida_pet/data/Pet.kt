package br.com.pucc.cuida_pet.data

import Exame
import android.os.Parcel
import android.os.Parcelable
import java.sql.Blob

data class Pet(
    var nome: String? = "",
    var linkFoto: String? = "",
    var especie: String? = "",
    var raca: String? = "",
    var idade: Int = 0,
    var cor: String? = "",
    var peso: Float = 0.0f,
    val exames: List<Exame>? = null,
    val idUser: Int = 0,
    // val idPet: Int = 0,
    val vacinas: List<Vacina>? = null,
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readInt(),
        source.readString(),
        source.readFloat(),
        source.createTypedArrayList(Exame.CREATOR),
        source.readInt(),
        source.createTypedArrayList(Vacina.CREATOR)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(nome)
        writeString(linkFoto)
        writeString(especie)
        writeString(raca)
        writeInt(idade)
        writeString(cor)
        writeFloat(peso)
        writeTypedList(exames)
        writeInt(idUser)
        writeTypedList(vacinas)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Pet> = object : Parcelable.Creator<Pet> {
            override fun createFromParcel(source: Parcel): Pet = Pet(source)
            override fun newArray(size: Int): Array<Pet?> = arrayOfNulls(size)
        }
    }
}