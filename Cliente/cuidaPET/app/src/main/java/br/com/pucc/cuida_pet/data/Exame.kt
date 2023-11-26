import android.os.Parcel
import android.os.Parcelable

data class Exame(
    val nome: String,
    val resultado: String?
) : Parcelable {
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nome)
        // Use writeParcelable para escrever o Blob no Parcel
        parcel.writeString(resultado)
    }

    override fun describeContents(): Int {
        return 0
    }

}
