package br.com.pucc.cuida_pet

import android.content.Context
import android.content.SharedPreferences
import br.com.pucc.cuida_pet.data.Pet
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PetManager(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("PetPreferences", Context.MODE_PRIVATE)
    private val gson = Gson()

    fun savePets(pets: List<Pet>) {
        val json = gson.toJson(pets)
        sharedPreferences.edit().putString("petList", json).apply()
    }

    fun getPets(): List<Pet> {
        val json = sharedPreferences.getString("petList", "")
        return if (json.isNullOrEmpty()) {
            emptyList()
        } else {
            val type = object : TypeToken<List<Pet>>() {}.type
            gson.fromJson(json, type)
        }
    }
}
