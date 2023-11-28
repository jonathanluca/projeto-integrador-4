import android.os.Parcel
import android.os.Parcelable

data class Exame(
    val nome: String?,
    val resultado: String?
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(nome)
        writeString(resultado)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Exame> = object : Parcelable.Creator<Exame> {
            override fun createFromParcel(source: Parcel): Exame = Exame(source)
            override fun newArray(size: Int): Array<Exame?> = arrayOfNulls(size)
        }
    }
}